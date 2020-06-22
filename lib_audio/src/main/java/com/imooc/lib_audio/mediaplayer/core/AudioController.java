package com.imooc.lib_audio.mediaplayer.core;

import android.util.Log;

import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.events.AudioCompleteEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioErrorEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioPlayModeEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioRemoveEvent;
import com.imooc.lib_audio.mediaplayer.exception.AudioQueueEmptyException;
import com.imooc.lib_api.model.AudioBean;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//不允许在包外的类访问
public class AudioController {

	private static final String TAG = "AudioController";

	/*
	 * 播放模式
	 */
	public enum PlayMode{
		LOOP,
		RANDOM,
		REPEAT
	}

	//播放器
	private final AudioPlayer mAudioPlayer;
	//当前播放队列
	private final ArrayList<AudioBean> mQueue = new ArrayList<>();
	//播放模式
	private PlayMode mPlayMode;
	//当前播放索引
	private int mQueueIndex;

	private AudioController(){
		mAudioPlayer = new AudioPlayer();
		final AudioBean audio = SharePreferenceUtil.getInstance(AudioHelper.getContext()).getLatestSong();
		final List<AudioBean> list = SharePreferenceUtil.getInstance(AudioHelper.getContext()).getMusicList();
		if(audio != null && list != null) {
			mQueue.add(audio);
			list.remove(audio);
			//上次保存的播放列表
			mQueue.addAll(list);
		}
		mQueueIndex = 0;
		mPlayMode = PlayMode.LOOP;
		EventBus.getDefault().register(this);

	}

	public static AudioController getInstance(){
		return SingletonHolder.INSTANCE;
	}

	private static class SingletonHolder{
		private static final AudioController INSTANCE = new AudioController();
	}

	public boolean isStartState() {
		return CustomMediaPlayer.Status.STARTED == getStatus();
	}

	/**
	 * 对外提提供是否暂停状态
	 */
	private boolean isPauseState() {
		return CustomMediaPlayer.Status.PAUSED == getStatus();
	}

	private CustomMediaPlayer.Status getStatus() {
		return mAudioPlayer.getState();
	}

	public ArrayList<AudioBean> getQueue() {
		return mQueue;
	}

	//添加Audio
	public void addAudio(AudioBean bean) {
		addAudio(0, bean);
	}

	public void addAudio(ArrayList<AudioBean> list) {
		mQueue.addAll(list);
	}

	public void addAudio(int index, AudioBean bean) {
		if(mQueue.size() <= 0){
			throw new AudioQueueEmptyException("");
		}
		int query = mQueue.indexOf(bean);
		if(query <= -1){
			//当前播放列表中没有此歌曲
			mQueue.add(index, bean);
			setPlayIndex(index);
		}else{
			//当前播放列表中有这个歌曲
			AudioBean currentPlaying = getCurrentPlaying();
			if(!currentPlaying.getId().equals(bean.getId())){
				setPlayIndex(query);
			}
		}
	}

	//删除单个Audio
	public void removeAudio(AudioBean bean){
		if(mQueue.size() <= 0){
			throw new AudioQueueEmptyException("");
		}
		if(mQueue.remove(bean)){
			EventBus.getDefault().post(new AudioRemoveEvent());
		}
	}

	//删除全部
	public void removeAudio(){
		if(mQueue.size() <= 0){
			throw new AudioQueueEmptyException("");
		}
		AudioBean currentBean = getCurrentPlaying();
		mQueue.clear();
		//不删除当前播放的歌曲
		mQueue.add(currentBean);

	}

	public void setQueue(ArrayList<AudioBean> bean){
		setQueue(bean, 0);
	}

	public void setQueue(ArrayList<AudioBean> bean, int index){
		mQueue.addAll(bean);
		mQueueIndex = index;
	}

	public PlayMode getPlayMode() {
		return mPlayMode;
	}

	public void setPlayMode(PlayMode playMode) {
		mPlayMode = playMode;
		//还要对外发送切换事件，更新UI
		EventBus.getDefault().post(new AudioPlayModeEvent(mPlayMode));
		Log.e(TAG, "AudioPlayModeEvent " + mPlayMode.name());
	}

	public void setPlayIndex(int index) {
		if (mQueue.size() <= 0) {
			throw new AudioQueueEmptyException("当前播放队列为空,请先设置播放队列.");
		}
		mQueueIndex = index;
		play();
	}

	public void play() {
		mAudioPlayer.load(getCurrentPlaying());
	}

	private AudioBean getCurrentPlaying() {
		return getPlaying(mQueueIndex);
	}

	public void pause(){
		mAudioPlayer.pause();
	}

	public void seekTo(long time){
		mAudioPlayer.seekTo(time);
	}
	public void release(){
		mAudioPlayer.release();
		EventBus.getDefault().unregister(this);
	}

	public void resume(){
		mAudioPlayer.resume();
	}

	public void next(){
		mAudioPlayer.load(getNextPlaying());
	}

	//获取下一首歌曲
	private AudioBean getNextPlaying() {
		switch (mPlayMode){
			case LOOP:
				//列表循环 取余运算防止越界
				mQueueIndex = (mQueueIndex + 1) % mQueue.size();
				return getPlaying(mQueueIndex);
			case RANDOM:
				//随机播放
				mQueueIndex = new Random().nextInt(mQueue.size()) % mQueue.size();
				return getPlaying(mQueueIndex);
			case REPEAT:
				//单曲循环
				return getPlaying(mQueueIndex);
			default:
				break;
		}
		return null;
	}

	//获取上一首歌曲
	private AudioBean getPrePlaying() {
		switch (mPlayMode) {
			case LOOP:
				mQueueIndex = (mQueueIndex + mQueue.size() - 1) % mQueue.size();
				return getPlaying(mQueueIndex);
			case RANDOM:
				mQueueIndex = new Random().nextInt(mQueue.size()) % mQueue.size();
				return getPlaying(mQueueIndex);
			case REPEAT:
				return getPlaying(mQueueIndex);
		}
		return null;
	}

	public void previous(){
		mAudioPlayer.load(getPrePlaying());
	}

	public int getQueueIndex() {
		return mQueueIndex;
	}

	/**
	 * 切换播放/暂停状态
	 */
	public void playOrPause(){
		if(CustomMediaPlayer.Status.IDLE == getStatus()){
			play();
		}
		if(isStartState()){
			pause();
		}else if(isPauseState()){
			resume();
		}
	}

	private AudioBean getPlaying(int index) {
		if (mQueue != null && !mQueue.isEmpty() && index >= 0 && index < mQueue.size()) {
			return mQueue.get(index);
		} else {
			return null;
			//throw new AudioQueueEmptyException("当前播放队列为空,请先设置播放队列." + "当前Index: "+ index + "播放队列大小: " + mQueue.size());
		}
	}

	public AudioBean getNowPlaying() {
		return getPlaying(mQueueIndex);
	}

	//插放完毕事件处理
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onAudioCompleteEvent(AudioCompleteEvent event) {
		Log.e(TAG, "onAudioCompleteEvent");
		next();
	}

	//播放出错事件处理
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onAudioErrorEvent(AudioErrorEvent event) {
		next();
	}

}
