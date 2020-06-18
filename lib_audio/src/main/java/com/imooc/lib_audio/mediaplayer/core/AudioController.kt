package com.imooc.lib_audio.mediaplayer.core

import com.imooc.lib_audio.mediaplayer.events.*
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.NullPointerException
import kotlin.random.Random

object AudioController {


    /**
     * 播放模式
     */
    enum class PlayMode{
        LOOP,
        RANDOM,
        REPEAT
    }
    
    //播放器
    private var mAudioPlayer: AudioPlayer = AudioPlayer()

    //当前播放队列
    private var mQueue: ArrayList<AudioBean> = ArrayList()

    //当前播放模式
    private lateinit var mPlayMode: PlayMode
    //当前播放索引
    private var mQueueIndex = 0

    //object 关键字表示的单例类 不允许有构造方法
    init {
        mQueueIndex = 0
        mPlayMode = PlayMode.LOOP
        EventBus.getDefault().register(this)
    }


    fun isStartState():Boolean{
        return CustomMediaPlayer.Status.STARTED == getStatus()
    }

    fun isPauseState():Boolean{
        return CustomMediaPlayer.Status.PAUSED == getStatus()
    }

    //获取当前播放队列
    fun getQueue() : ArrayList<AudioBean>{
        return mQueue
    }

    //添加Audio
    fun addAudio(bean : AudioBean){
        addAudio(0, bean)
    }

    fun addAudio(index : Int, bean : AudioBean){
        val query = mQueue.indexOf(bean)
        if(query <= -1){
            mQueue.add(index, bean)
            //设置播放索引
            setPlayIndex(index)
        }else{
            val currentPlaying = getCurrentPlaying()
            if(!currentPlaying.id.equals(bean.id)){
                setPlayIndex(index)
            }
        }
    }

    //移除音乐  不可移除当前正在播放的音乐
    fun removeAudio(bean : AudioBean){
        if(mQueue.remove(bean)){
            EventBus.getDefault().post(AudioRemoveEvent())
        }
    }

    //移除全部播放队列
    fun removeAudio(){
        val currentBean = getCurrentPlaying()
        mQueue.clear()
        //不移除当前播放的歌曲
        mQueue.add(currentBean)
    }

    //设置播放队列
    fun setQueue(bean : ArrayList<AudioBean>){
        setQueue(bean, 0)
    }

    fun setQueue(bean : ArrayList<AudioBean>, index : Int){
        mQueue.addAll(bean)
        mQueueIndex = index
    }

    //播放模式
    fun getPlayMode():PlayMode{
        return mPlayMode
    }

    //设置播放模式
    fun setPlayMode(playMode: PlayMode){
        mPlayMode = playMode
        //对外发送事件
        EventBus.getDefault().post(AudioPlayModeEvent(mPlayMode))
    }


    private fun getCurrentPlaying(): AudioBean {
        return getPlaying(mQueueIndex)
    }

    //设置播放索引
    fun setPlayIndex(index: Int) {
        mQueueIndex = index
        play()
    }

    //播放音乐
    public fun play() {
        mAudioPlayer.load(getCurrentPlaying())
    }

    //暂停播放
    fun pause(){
        mAudioPlayer.pause()
    }

    //跳转到指定时间
    fun seekTo(time : Long){
        mAudioPlayer.seekTo(time)
    }

    fun release(){
        mAudioPlayer.release()
        EventBus.getDefault().unregister(this)
    }

    fun resume(){
        mAudioPlayer.resume()
    }

    fun next(){
        mAudioPlayer.load(getNextPlaying())
    }

    //获取下一首播放的歌曲 根据当前播放模式
    private fun getNextPlaying(): AudioBean {
        when(mPlayMode){
            //列表循环
            PlayMode.LOOP -> {
                mQueueIndex = (mQueueIndex + 1) % mQueue.size
                return getPlaying(mQueueIndex)
            }
            //随机播放
            PlayMode.RANDOM -> {
                mQueueIndex = Random.nextInt(mQueue.size) % mQueue.size
                return getPlaying(mQueueIndex)
            }
            //单曲循环
            PlayMode.REPEAT -> {
                return getPlaying(mQueueIndex)
            }
        }
    }

    //获取上一首歌曲
    fun getPrePlaying():AudioBean{
        when(mPlayMode){
            //列表循环
            PlayMode.LOOP -> {
                mQueueIndex = (mQueueIndex + mQueue.size - 1 ) % mQueue.size
                return getPlaying(mQueueIndex)
            }
            //随机播放
            PlayMode.RANDOM -> {
                mQueueIndex = Random.nextInt(mQueue.size) % mQueue.size
                return getPlaying(mQueueIndex)
            }
            //单曲循环
            PlayMode.REPEAT -> {
                return getPlaying(mQueueIndex)
            }
        }
    }

    //播放上一首
    fun previous(){
        mAudioPlayer.load(getPrePlaying())
    }

    //切换 播放/暂停 状态
    fun playOrPause(){
        if(CustomMediaPlayer.Status.INITIALIZED == getStatus()){
            play()
        }
        if(isStartState()){
            pause()
        }else if(isPauseState()){
            resume()
        }
    }

    fun getNowPlaying(): AudioBean{
        return getPlaying(mQueueIndex)
    }

    //获取当前播放状态
    private fun getStatus(): CustomMediaPlayer.Status {
        return mAudioPlayer.getStatus()
    }


    fun getPlaying(index : Int): AudioBean {
        return if(!mQueue.isEmpty() && index < mQueue.size && index >= 0){
            mQueue.get(index)
        } else {
            throw NullPointerException("")
        }
    }
    //插放完毕事件处理
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioCompleteEvent(event: AudioCompleteEvent){
        //播放下一首
        next()
    }

    //播放出错事件处理
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioErrorEvent(event: AudioErrorEvent){
        //播放下一首
        next()
    }

}