package com.imooc.lib_audio.mediaplayer.core

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.MediaPlayer.SEEK_CLOSEST
import android.net.wifi.WifiManager
import android.os.*
import android.util.Log
import com.imooc.lib_audio.app.AudioHelper
import com.imooc.lib_audio.mediaplayer.events.*
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import org.greenrobot.eventbus.EventBus
import java.io.IOException

class AudioPlayer : MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        AudioFocusManager.AudioFocusListener{

    private val TAG : String = "AudioPlayer"

    private val TIME_MSG : Int = 0x01
    private val TIME_INVAL : Long = 100

    private var mMediaPlayer : CustomMediaPlayer = CustomMediaPlayer()
    private var mWifiLock : WifiManager.WifiLock
    private var manager : WifiManager
    private var mAudioFocusManager : AudioFocusManager

    private var isPausedByFocusLossTransient : Boolean = false

    constructor(){
        mMediaPlayer.setWakeMode(AudioHelper.getContext(), PowerManager.PARTIAL_WAKE_LOCK)
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mMediaPlayer.setOnCompletionListener(this)
        mMediaPlayer.setOnPreparedListener(this)
        mMediaPlayer.setOnBufferingUpdateListener(this)
        mMediaPlayer.setOnErrorListener(this)
        manager = AudioHelper.getContext().applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        mWifiLock = manager.createWifiLock(WifiManager.WIFI_MODE_FULL, TAG)

        //音频焦点管理器
        mAudioFocusManager = AudioFocusManager(AudioHelper.getContext(), this)

    }

    private val mHandler : Handler = object :Handler(Looper.getMainLooper()){

        override fun handleMessage(msg: Message?) {
            if(msg?.what == TIME_MSG){
                if(mMediaPlayer.getState() == CustomMediaPlayer.Status.STARTED
                        || mMediaPlayer.getState() == CustomMediaPlayer.Status.PAUSED){
                    EventBus.getDefault().post(AudioProgressEvent(mMediaPlayer.getState(), getCurrentPosition(), getDuration()))
                    //100ms 后再次发送
                    sendEmptyMessageDelayed(TIME_MSG, TIME_INVAL)
                }
            }
        }
    }

    //加载歌曲
    fun load(bean : AudioBean){
        try{
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(bean.mUrl)
            //异步加载  加载完回调 onPrepared()
            mMediaPlayer.prepareAsync()
            EventBus.getDefault().post(AudioLoadEvent(bean))
            Log.e(TAG, "AudioLoadEvent$bean");
        }catch (e : IOException){
            e.printStackTrace()
            EventBus.getDefault().post(AudioErrorEvent())
            Log.e(TAG, "AudioErrorEvent")
        }
    }

    //恢复播放
    fun resume(){
        if(getStatus() == CustomMediaPlayer.Status.PAUSED){
            start()
        }
    }

    //开始播放
    fun start(){
        if(!mAudioFocusManager.requestAudioFocus()){
            Log.e(TAG, "requestAudioFocus Error")
        }
        mMediaPlayer.start()
        mWifiLock.acquire()
        //更新进度条
        mHandler.sendEmptyMessage(TIME_MSG)
        //发送AudioStartEvent事件
        EventBus.getDefault().post(AudioStartEvent())
        Log.e(TAG, "AudioStartEvent")
    }

    fun getStatus(): CustomMediaPlayer.Status{
        return mMediaPlayer.getState()
    }

    //获取当前播放到的时长
    private fun getCurrentPosition(): Int = if(mMediaPlayer.getState() == CustomMediaPlayer.Status.STARTED
                || mMediaPlayer.getState() == CustomMediaPlayer.Status.PAUSED){
            mMediaPlayer.currentPosition
        } else 0


    //音乐总时长
    private fun getDuration(): Int =
        if(mMediaPlayer.getState() == CustomMediaPlayer.Status.STARTED
                || mMediaPlayer.getState() == CustomMediaPlayer.Status.PAUSED){
             mMediaPlayer.duration
        }else 0


    override fun onCompletion(mp: MediaPlayer?) {
        //音乐播放完毕
        Log.e(TAG, "AudioCompleteEvent")
        EventBus.getDefault().post(AudioCompleteEvent())
    }

    override fun onBufferingUpdate(mp: MediaPlayer?, percent: Int) {
        //网络歌曲 缓存的进度 在第二进度条显示
        EventBus.getDefault().post(AudioBufferUpdateEvent(percent))
    }

    override fun onPrepared(mp: MediaPlayer?) {
        //准备完成 可以开始播放
        Log.e(TAG, "onPrepared")
        start()
    }

    override fun onError(mp: MediaPlayer?, p1: Int, p2: Int): Boolean {
        Log.e(TAG, "AudioErrorEvent")
        EventBus.getDefault().post(AudioErrorEvent())
        return true
    }

    override fun audioFocusGrant() {
        //音频焦点获取到
        setVolumn(1.0f, 1.0f)
        if(isPausedByFocusLossTransient){
            //焦点被暂时丢失
            resume()
        }
        isPausedByFocusLossTransient = false
    }

    override fun audioFocusLossTransient() {
        //暂时失去音频焦点  来电话 来短信 闹钟等事件
        pause()
        isPausedByFocusLossTransient = true

    }

    override fun audioFocusLossDuck() {
        //瞬间失去焦点
        setVolumn(0.5f, 0.5f)
    }

    override fun audioFocusLoss() {
        //短暂失去焦点
        pause()
    }

    //跳转到指定时间
    fun seekTo(time : Long){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            mMediaPlayer.seekTo(time, SEEK_CLOSEST)
        }
    }


    //暂停播放
    fun pause(){
        //当前时播放状态
        if(getStatus() == CustomMediaPlayer.Status.STARTED){
            mMediaPlayer.pause()
            //释放wifi Lock
            if(mWifiLock.isHeld){
                mWifiLock.release()
            }
            //释放音频焦点
            mAudioFocusManager.abandonAudioFocus()
            //暂停事件
            EventBus.getDefault().post(AudioPauseEvent())
            Log.e(TAG, "AudioPauseEvent")
        }
    }

    //释放资源
    fun release(){
        mMediaPlayer.release()
        if(mWifiLock.isHeld){
            mWifiLock.release()
        }
        //释放音频焦点
        mAudioFocusManager.abandonAudioFocus()
        //释放资源事件
        EventBus.getDefault().post(AudioReleaseEvent())
        Log.e(TAG, "AudioReleaseEvent")
    }

    //设置音量
    fun setVolumn(leftVol : Float, rightVol : Float){
        mMediaPlayer.setVolume(leftVol, rightVol)
    }
}