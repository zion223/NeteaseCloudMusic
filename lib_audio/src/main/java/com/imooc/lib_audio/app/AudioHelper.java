package com.imooc.lib_audio.app;

import android.app.Activity;
import android.content.Context;

import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.core.MusicService;
import com.imooc.lib_audio.mediaplayer.db.GreenDaoHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_audio.mediaplayer.view.MusicPlayerActivity;

import java.util.ArrayList;

public final class AudioHelper {

	private static Context mContext;

	public static void init(Context context){
		mContext = context;
		//初始化数据库
		GreenDaoHelper.initDatabase();
		MusicService.startMusicService();
	}

	public static Context getContext(){
		return mContext;
	}


	//TODO AudioBean改造
	public static void addAudio(Activity activity, AudioBean bean){
		AudioController.getInstance().addAudio(bean);
		if(activity != null){
			MusicPlayerActivity.start(activity);
		}
	}

	//不启动Activity
	public static void addAudio(AudioBean bean){
		addAudio(null, bean);
	}

	//加入List的音乐
	public static void addAudio(ArrayList<AudioBean> mLists){
		AudioController.getInstance().addAudio(mLists);
	}

}
