package com.imooc.lib_audio.mediaplayer.core;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;

import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.events.AudioCompleteEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioErrorEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioPauseEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioProgressEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioReleaseEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioStartEvent;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

/**
 * 播放音频
 * 对外发送各种类型的事件 播放、暂停、加载失败、播放完毕、销毁
 */
public class AudioPlayer implements MediaPlayer.OnCompletionListener,
		MediaPlayer.OnBufferingUpdateListener,
		MediaPlayer.OnPreparedListener,
		MediaPlayer.OnErrorListener,
		AudioFocusManager.AudioFocusListener{

	private static final String TAG = "AudioPlayer";
	private static final int TIME_MSG = 0x01;
	private static final int TIME_INVAL = 100;

	private CustomMediaPlayer mMediaPlayer;
	private WifiManager.WifiLock mWifiLock;
	private AudioFocusManager mAudioFocusManager;

	private boolean isPausedByFocusLossTransient;

	public AudioPlayer(){
		init();
	}

	//变量初始化
	private void init() {
		mMediaPlayer = new CustomMediaPlayer();
		mMediaPlayer.setWakeMode(AudioHelper.getContext(), PowerManager.PARTIAL_WAKE_LOCK);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.setOnCompletionListener(this);
		mMediaPlayer.setOnPreparedListener(this);
		mMediaPlayer.setOnBufferingUpdateListener(this);
		mMediaPlayer.setOnErrorListener(this);


		mWifiLock = ((WifiManager) AudioHelper.getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE))
				.createWifiLock(WifiManager.WIFI_MODE_FULL, TAG);

		// 初始化音频焦点管理器
		mAudioFocusManager = new AudioFocusManager(AudioHelper.getContext(), this);
	}


	private Handler mHandler = new Handler(Looper.getMainLooper()){
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == TIME_MSG) {
				if (mMediaPlayer.getState() == CustomMediaPlayer.Status.STARTED
						|| mMediaPlayer.getState() == CustomMediaPlayer.Status.PAUSED) {
					EventBus.getDefault().post(new AudioProgressEvent(mMediaPlayer.getState(), getCurrentPosition(), getDuration()));
					//TIME_INVAL 时间后重新发送 Message
					sendEmptyMessageDelayed(TIME_MSG, TIME_INVAL);
				}
			}
		}
	};

	public void load(AudioBean bean){
		try {
			mMediaPlayer.reset();
			mMediaPlayer.setDataSource(bean.getUrl());
			//异步加载 加载完成后调用onPrepared()
			mMediaPlayer.prepareAsync();
			//发送load事件
			EventBus.getDefault().post(new AudioLoadEvent(bean));
			Log.e(TAG, "AudioLoadEvent" + bean.toString());
		} catch (IOException e) {
			e.printStackTrace();
			//发送error事件
			EventBus.getDefault().post(new AudioErrorEvent());
			Log.e(TAG, "AudioErrorEvent");
		}
	}

	/**
	 * 恢复播放
	 */
	public void resume(){
		if(getState() == CustomMediaPlayer.Status.PAUSED){
			start();
		}
	}

	/**
	 * 暂停播放
	 */
	public void pause(){
		if(getState() == CustomMediaPlayer.Status.STARTED){
			mMediaPlayer.pause();
			//释放wifi锁
			if(mWifiLock.isHeld()){
				mWifiLock.release();
			}
			//释放音频焦点
			if(mAudioFocusManager != null){
				mAudioFocusManager.abandonAudioFocus();
			}
			//发送暂停事件
			EventBus.getDefault().post(new AudioPauseEvent());
			Log.e(TAG, "AudioPauseEvent");
		}
	}

	/**
	 * 释放资源
	 */
	public void release(){
		if(mMediaPlayer != null){
			mMediaPlayer.release();
			mMediaPlayer = null;
			if(mWifiLock.isHeld()){
				mWifiLock.release();
			}
			//释放音频焦点
			if(mAudioFocusManager != null){
				mAudioFocusManager.abandonAudioFocus();
			}
			//发送销毁事件
			EventBus.getDefault().post(new AudioReleaseEvent());
			Log.e(TAG, "AudioReleaseEvent");
		}

	}

	/***
	 * 获取当前播放器状态
	 */
	public CustomMediaPlayer.Status getState() {
		if(mMediaPlayer != null){
			return mMediaPlayer.getState();
		}
		return CustomMediaPlayer.Status.STOPPED;
	}


	private void start(){
		if(!mAudioFocusManager.requestAudioFocus()){
			Log.e(TAG, "requestAudioFocus失败");
		}
		mMediaPlayer.start();
		mWifiLock.acquire();
		//更新进度
		mHandler.sendEmptyMessage(TIME_MSG);
		//对外发送start事件
		EventBus.getDefault().post(new AudioStartEvent());
		Log.e(TAG, "AudioStartEvent");
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		//缓存进度
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		//播放完毕
		EventBus.getDefault().post(new AudioCompleteEvent());
		Log.e(TAG, "AudioCompleteEvent");
	}

	/**
	 * true if the method handled the error, false if it didn't.
	 *  Returning false, or not having an OnErrorListener at all, will
	 *  cause the OnCompletionListener to be called.
	 */
	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		EventBus.getDefault().post(new AudioErrorEvent());
		Log.e(TAG, "AudioErrorEvent");
		return true;
	}


	@Override
	public void onPrepared(MediaPlayer mp) {
		Log.e(TAG, "onPrepared");
		start();
	}


	@Override
	public void audioFocusGrant() {
		setVolumn(1.0f, 1.0f);
		if(isPausedByFocusLossTransient){
			resume();
		}
		isPausedByFocusLossTransient = false;
	}



	@Override
	public void audioFocusLoss() {
		//失去焦点
		pause();
	}

	@Override
	public void audioFocusLossTransient() {
		//暂时失去焦点
		pause();
		isPausedByFocusLossTransient = true;
	}

	@Override
	public void audioFocusLossDuck() {
		//瞬间失去焦点
		setVolumn(0.5f, 0.5f);

	}
	/**
	 * 获取当前音乐总时长,更新进度用
	 */
	public int getDuration() {
		if (mMediaPlayer.getState() == CustomMediaPlayer.Status.STARTED
				|| mMediaPlayer.getState() == CustomMediaPlayer.Status.PAUSED) {
			return mMediaPlayer.getDuration();
		}
		return 0;
	}

	/**
	 * 当前播放到的位置
	 */
	public int getCurrentPosition() {
		if (mMediaPlayer.getState() == CustomMediaPlayer.Status.STARTED
				|| mMediaPlayer.getState() == CustomMediaPlayer.Status.PAUSED) {
			return mMediaPlayer.getCurrentPosition();
		}
		return 0;
	}

	/**
	 * 设置音量
	 */
	private void setVolumn(float leftVol, float rightVol) {
		if (mMediaPlayer != null) mMediaPlayer.setVolume(leftVol, rightVol);
	}
}
