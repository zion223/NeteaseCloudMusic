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
	}

	public static Context getContext(){
		return mContext;
	}

	public static void startMusicService(ArrayList<AudioBean> mLists) {
		MusicService.startMusicService(mLists);
	}
	public static void addAudio(Activity activity, AudioBean bean){
		AudioController.getInstance().addAudio(bean);
		MusicPlayerActivity.start(activity);
	}
}
