package com.imooc.lib_audio.app

import android.content.Context
import com.imooc.lib_audio.mediaplayer.core.AudioController
import com.imooc.lib_audio.mediaplayer.core.MusicService
import com.imooc.lib_audio.mediaplayer.db.GreenDaoHelper
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.imooc.lib_audio.mediaplayer.view.MusicPlayerActivity
import com.imooc.lib_common_ui.base.ProxyActivity

public class AudioHelper {


    companion object{
        private lateinit var mContext : Context

        public fun init(context:Context){
            mContext = context
            GreenDaoHelper.initDatabase()
            MusicService.startMusicService()
        }

        public fun getContext():Context{
            return mContext
        }

        //TODO AudioBean改造
        public fun addAudio(activity : ProxyActivity?, bean : AudioBean){
            AudioController.addAudio(bean)
            if(activity != null){
                MusicPlayerActivity.start(activity)
            }
        }

        public fun addAudio(bean : AudioBean){

            addAudio(null, bean)
        }

        //播放全部音乐
        public fun addAudio(list: ArrayList<AudioBean>){
            AudioController.addAudio(list)
        }

    }

}