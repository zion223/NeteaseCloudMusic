package com.imooc.lib_audio.mediaplayer.core

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import com.imooc.lib_audio.app.AudioHelper
import com.imooc.lib_audio.mediaplayer.core.AudioController.play
import com.imooc.lib_audio.mediaplayer.core.AudioController.setQueue
import com.imooc.lib_audio.mediaplayer.events.*
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.imooc.lib_audio.mediaplayer.view.NotificationHelper
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MusicService : Service(), NotificationHelper.NotificationHelperListener{


    private var mReceiver: NotificationReceiver? = null

    private lateinit var mAudioBeans: ArrayList<AudioBean>


    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
        registerBroadcastReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
        unRegisterBroadcastReceiver()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent != null){
            mAudioBeans = intent.getSerializableExtra(DATA_AUDIOS) as ArrayList<AudioBean>
            if (ACTION_START.equals(intent.getAction())) {
                //开始播放
                playMusic();
                //初始化前台Notification
                NotificationHelper.getInstance().init(this);
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun playMusic() {
        setQueue(mAudioBeans)
        play()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioLoadEvent(event: AudioLoadEvent) {
        //更新notifacation为load状态
        NotificationHelper.getInstance().showLoadStatus(event.bean)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioPauseEvent(event: AudioPauseEvent?) {
        //更新notifacation为暂停状态
        NotificationHelper.getInstance().showPauseStatus()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioStartEvent(event: AudioStartEvent?) {
        //更新notifacation为播放状态
        NotificationHelper.getInstance().showPlayStatus()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioFavouriteEvent(event: AudioFavouriteEvent) {
        //更新notifacation收藏状态
        NotificationHelper.getInstance().changeFavouriteStatus(event.favourite)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioReleaseEvent(event: AudioReleaseEvent?) {
        //移除notifacation
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onNotificationInit() {
        startForeground(NotificationHelper.NOTIFICATION_ID, NotificationHelper.getInstance().getNotification());
    }

    private fun registerBroadcastReceiver() {
        if (mReceiver == null) {
            mReceiver = NotificationReceiver()
            val filter = IntentFilter()
            filter.addAction(NotificationReceiver.ACTION_STATUS_BAR)
            registerReceiver(mReceiver, filter)
        }
    }

    private fun unRegisterBroadcastReceiver() {
        if (mReceiver != null) {
            unregisterReceiver(mReceiver)
        }
    }

    companion object{
        private val DATA_AUDIOS : String = "AUDIOS"
        private val ACTION_START = "ACTION_START"

        fun startMusicService(list : ArrayList<AudioBean?>?) {
            val intent = Intent(AudioHelper.getContext(), MusicService::class.java)
            intent.action = ACTION_START
            intent.putExtra(DATA_AUDIOS, list)
            AudioHelper.getContext().startService(intent)
        }
    }

    class NotificationReceiver : BroadcastReceiver(){

        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent == null){
                return
            }
            when(intent.getStringExtra(EXTRA)){
                EXTRA_PLAY -> {
                    AudioController.playOrPause();
                }
                EXTRA_PRE -> {
                    AudioController.previous();
                }
                EXTRA_NEXT -> {
                    AudioController.next()
                }
                EXTRA_FAV -> {

                }
            }
        }


        companion object{


            val ACTION_STATUS_BAR = AudioHelper.getContext().packageName.toString() + ".NOTIFICATION_ACTIONS"
            const val EXTRA = "extra"
            const val EXTRA_PLAY = "play_pause"
            const val EXTRA_NEXT = "play_next"
            const val EXTRA_PRE = "play_previous"
            const val EXTRA_FAV = "play_favourite"
        }

    }
}