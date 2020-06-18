package com.imooc.lib_audio.mediaplayer.core

import android.media.MediaPlayer

class CustomMediaPlayer: MediaPlayer, MediaPlayer.OnCompletionListener{


    private var mStatus : Status = Status.IDLE
    private lateinit var mListener : OnCompletionListener

    constructor() : super() {
        mStatus = Status.IDLE
        super.setOnCompletionListener(this)
    }

    enum class Status{
        IDLE, INITIALIZED, STARTED, PAUSED, STOPPED, COMPLETED, PREPARED
    }



    //播放完毕
    override fun onCompletion(mediaPlayer: MediaPlayer?) {
        mStatus = Status.COMPLETED
        mListener.onCompletion(mediaPlayer)
    }

    override fun setDataSource(path: String?) {
        super.setDataSource(path)
        mStatus = Status.INITIALIZED
    }

    override fun start() {
        super.start()
        mStatus =  Status.STARTED
    }

    override fun stop() {
        super.stop()
        mStatus = Status.STOPPED
    }

    override fun pause() {
        super.pause()
        mStatus = Status.PAUSED
    }

    override fun reset() {
        super.reset()
        mStatus = Status.IDLE
    }

    override fun prepare() {
        super.prepare()
        mStatus = Status.PREPARED
    }

    fun getState() : Status{
        return mStatus
    }

    override fun setOnCompletionListener(listener: OnCompletionListener?) {
        if (listener != null) {
            this.mListener = listener
        }
    }
}