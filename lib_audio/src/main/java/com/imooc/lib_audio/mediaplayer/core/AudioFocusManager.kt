package com.imooc.lib_audio.mediaplayer.core

import android.content.Context
import android.media.AudioManager
import android.os.Build
import android.support.annotation.RequiresApi

class AudioFocusManager(context: Context, listener: AudioFocusListener) : AudioManager.OnAudioFocusChangeListener {

    private var audioManager : AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private var mAudioFocusListener : AudioFocusListener = listener

    //获取音频焦点
    fun requestAudioFocus():Boolean{
        return audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    //释放音频焦点
    @RequiresApi(Build.VERSION_CODES.O)
    fun abandonAudioFocus(){
        audioManager.abandonAudioFocus(this)
    }



    //焦点状态变化
    override fun onAudioFocusChange(focusChange: Int) {
        when(focusChange){
            //获取到焦点
            AudioManager.AUDIOFOCUS_GAIN -> {
                mAudioFocusListener.audioFocusGrant()
            }
            //失去焦点
            AudioManager.AUDIOFOCUS_LOSS -> {
                mAudioFocusListener.audioFocusLoss()
            }
            //暂时失去焦点
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                mAudioFocusListener.audioFocusLossTransient()
            }
            //瞬间失去焦点
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> {
                mAudioFocusListener.audioFocusLossDuck()
            }
        }
    }



    //音频焦点状态改变
    interface AudioFocusListener{
        //获得焦点回调处理
        fun audioFocusGrant()

        //永久失去焦点回调处理
        fun audioFocusLoss()

        //短暂失去焦点回调处理
        fun audioFocusLossTransient()

        //瞬间失去焦点回调
        fun audioFocusLossDuck()
    }
}