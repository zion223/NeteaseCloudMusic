package com.imooc.lib_video.videoplayer.core.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.imooc.lib_video.R;

/**
 * 负责视频播放，暂停，事件触发
 */
public class CustomVideoView extends RelativeLayout
		implements View.OnClickListener, MediaPlayer.OnPreparedListener,
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener
		, TextureView.SurfaceTextureListener {
	/**
	 * Constant
	 */
	private static final int STATE_ERROR = -1;
	private static final int STATE_IDLE = 0;
	private static final int STATE_PLAYING = 1;
	private static final int STATE_PAUSING = 2;
	private static final int LOAD_TOTAL_COUNT = 3;
	/**
	 * UI
	 */
	private RelativeLayout mPlayerView;
	private TextureView mVideoView;
	private Button mMiniPlayBtn;
	private ImageView mFullBtn;
	private ImageView mLoadingBar;
	private AudioManager audioManager;
	private Surface videoSurface;

	/**
	 * Data
	 */
	private String mUrl;
	private boolean isMute;
	private int mScreenWidth, mDestationHeight;

	/**
	 * Status状态保护
	 */
	private boolean canPlay = true;
	private boolean mIsRealPause;
	private boolean mIsComplete;
	private int mCurrentCount;
	private int playerState = STATE_IDLE;

	private MediaPlayer mediaPlayer;
	private ADVideoPlayerListener listener;
	private ScreenEventReceiver mScreenReceiver;

	public CustomVideoView(Context context) {
		super(context);
		audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		initData();
		initView();
		registerBroadcastReceiver();
	}

	private void initData() {
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(dm);
		mScreenWidth = dm.widthPixels;
		mDestationHeight = (int) (mScreenWidth * (9 / 16.0f));
	}

	private void initView() {
		LayoutInflater inflater = LayoutInflater.from(this.getContext());
		mPlayerView = (RelativeLayout) inflater.inflate(R.layout.video_player_layout, this);
		mVideoView = mPlayerView.findViewById(R.id.xadsdk_player_video_textureView);
		mVideoView.setOnClickListener(this);
		mVideoView.setKeepScreenOn(true);
		mVideoView.setSurfaceTextureListener(this);
		initSmallLayoutMode(); //init the small mode
	}

	// 小模式状态
	private void initSmallLayoutMode() {
		LayoutParams params = new LayoutParams(mScreenWidth, mDestationHeight);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		mPlayerView.setLayoutParams(params);

		mMiniPlayBtn = mPlayerView.findViewById(R.id.xadsdk_small_play_btn);
		mFullBtn = mPlayerView.findViewById(R.id.xadsdk_to_full_view);
		mLoadingBar = mPlayerView.findViewById(R.id.loading_bar);
		mMiniPlayBtn.setOnClickListener(this);
		mFullBtn.setOnClickListener(this);
	}

	private synchronized void checkMediaPlayer() {
		if (mediaPlayer == null) {
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setOnPreparedListener(this);
			mediaPlayer.setOnCompletionListener(this);
			mediaPlayer.setOnErrorListener(this);
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		}
	}

	private void showPauseView(boolean show) {
		mFullBtn.setVisibility(show ? View.VISIBLE : View.GONE);
		mMiniPlayBtn.setVisibility(show ? View.GONE : View.VISIBLE);
		mLoadingBar.clearAnimation();
		mLoadingBar.setVisibility(View.GONE);
	}

	private void showLoadingView() {
		mFullBtn.setVisibility(View.GONE);
		mLoadingBar.setVisibility(View.VISIBLE);
		AnimationDrawable anim = (AnimationDrawable) mLoadingBar.getBackground();
		anim.start();
		mMiniPlayBtn.setVisibility(View.GONE);
	}

	private void showPlayView() {
		mLoadingBar.clearAnimation();
		mLoadingBar.setVisibility(View.GONE);
		mMiniPlayBtn.setVisibility(View.GONE);
	}

	private void registerBroadcastReceiver() {
		if (mScreenReceiver == null) {
			mScreenReceiver = new ScreenEventReceiver();
			IntentFilter filter = new IntentFilter();
			filter.addAction(Intent.ACTION_SCREEN_OFF);
			filter.addAction(Intent.ACTION_USER_PRESENT);
			getContext().registerReceiver(mScreenReceiver, filter);
		}
	}

	private void unRegisterBroadcastReceiver() {
		if (mScreenReceiver != null) {
			getContext().unregisterReceiver(mScreenReceiver);
		}
	}

	/**
	 * 进入播放状态时的状态更新
	 */
	private void entryResumeState() {
		canPlay = true;
		setCurrentPlayState(STATE_PLAYING);
		setIsRealPause(false);
		setIsComplete(false);
	}

	private void setCurrentPlayState(int state) {
		playerState = state;
	}

	public void isShowFullBtn(boolean isShow) {
		mFullBtn.setImageResource(isShow ? R.drawable.xadsdk_ad_mini : R.drawable.xadsdk_ad_mini_null);
		mFullBtn.setVisibility(isShow ? View.VISIBLE : View.GONE);
	}

	public boolean isRealPause() {
		return mIsRealPause;
	}

	public boolean isComplete() {
		return mIsComplete;
	}

	/**
	 * true is no voice
	 */
	public void mute(boolean mute) {
		isMute = mute;
		if (mediaPlayer != null && this.audioManager != null) {
			float volume = isMute ? 0.0f : 1.0f;
			mediaPlayer.setVolume(volume, volume);
		}
	}

	public boolean isPlaying() {
		return mediaPlayer != null && mediaPlayer.isPlaying();
	}

	public void setIsComplete(boolean isComplete) {
		mIsComplete = isComplete;
	}

	public void setIsRealPause(boolean isRealPause) {
		this.mIsRealPause = isRealPause;
	}


	public void setDataSource(String url) {
		this.mUrl = url;
	}

	public void setListener(ADVideoPlayerListener listener) {
		this.listener = listener;
	}

	public int getCurrentPosition() {
		if (this.mediaPlayer != null) {
			return mediaPlayer.getCurrentPosition();
		}
		return 0;
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		//可见状态
		if (visibility == VISIBLE && playerState == STATE_PAUSING) {
			if (isRealPause() || isComplete()) {
				pause();
			} else {
				resume();
			}
		//不可见状态
		} else {
			pause();
		}
	}

	@Override
	public void onClick(View v) {
	    //小屏播放
		if (v == this.mMiniPlayBtn) {
			if (this.playerState == STATE_PAUSING) {
				resume();
				this.listener.onClickPlay();
			} else {
				load();
			}
		} else if (v == this.mFullBtn) {
		    //全屏播放
			this.listener.onClickFullScreenBtn();
		} else if (v == mVideoView) {
			this.listener.onClickVideo();
		}
	}

	//播放完成
	@Override
	public void onCompletion(MediaPlayer mp) {
		if (listener != null) {
			listener.onAdVideoLoadComplete();
		}
		playBack();
		setIsComplete(true);
		setIsRealPause(true);
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		this.playerState = STATE_ERROR;
		if (mCurrentCount >= LOAD_TOTAL_COUNT) {
			showPauseView(false);
			if (this.listener != null) {
				listener.onAdVideoLoadFailed();
			}
		}
		this.stop();//去重新load
		return true;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		showPlayView();
		mediaPlayer = mp;
		if (mediaPlayer != null) {
			mCurrentCount = 0;
			if (listener != null) {
				listener.onAdVideoLoadSuccess();
			}
			//满足自动播放条件，则直接播放
			setCurrentPlayState(STATE_PAUSING);
			resume();
		}
	}

	//Surface可用
	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
		videoSurface = new Surface(surface);
		checkMediaPlayer();
		mediaPlayer.setSurface(videoSurface);
		load();
	}

	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
	}

	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
		return false;
	}

	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture surface) {
	}

	public void load() {
		if (this.playerState != STATE_IDLE) {
			return;
		}
		showLoadingView();
		try {
			setCurrentPlayState(STATE_IDLE);
			checkMediaPlayer();
			mute(true);
			mediaPlayer.setDataSource(this.mUrl);
			mediaPlayer.prepareAsync(); //开始异步加载
		} catch (Exception e) {
			stop(); //error以后重新调用stop加载
		}
	}

	public void pause() {
		if (this.playerState != STATE_PLAYING) {
			return;
		}
		setCurrentPlayState(STATE_PAUSING);
		if (isPlaying()) {
			mediaPlayer.pause();
			if (!this.canPlay) {
				this.mediaPlayer.seekTo(0);
			}
		}
		this.showPauseView(false);
	}

	//全屏不显示暂停状态,后续可以整合，不必单独出一个方法
	public void pauseForFullScreen() {
		if (playerState != STATE_PLAYING) {
			return;
		}
		setCurrentPlayState(STATE_PAUSING);
		if (isPlaying()) {
			mediaPlayer.pause();
			if (!this.canPlay) {
				mediaPlayer.seekTo(0);
			}
		}
	}

	//跳到指定点暂停视频
	public void seekAndPause(int position) {
		if (this.playerState != STATE_PLAYING) {
			return;
		}
		showPauseView(false);
		setCurrentPlayState(STATE_PAUSING);
		if (isPlaying()) {
			mediaPlayer.seekTo(position);
			mediaPlayer.setOnSeekCompleteListener(new OnSeekCompleteListener() {
				@Override
				public void onSeekComplete(MediaPlayer mp) {
					mediaPlayer.pause();
				}
			});
		}
	}

	public void resume() {
		if (this.playerState != STATE_PAUSING) {
			return;
		}
		if (!isPlaying()) {
			entryResumeState();
			mediaPlayer.setOnSeekCompleteListener(null);
			mediaPlayer.start();
			showPauseView(true);
		} else {
			showPauseView(false);
		}
	}

	//跳到指定点播放视频
	public void seekAndResume(int position) {
		if (mediaPlayer != null) {
			showPauseView(true);
			entryResumeState();
			mediaPlayer.seekTo(position);
			mediaPlayer.setOnSeekCompleteListener(new OnSeekCompleteListener() {
				@Override
				public void onSeekComplete(MediaPlayer mp) {
					mediaPlayer.start();
				}
			});
		}
	}

	//播放完成后回到初始状态
	public void playBack() {
		setCurrentPlayState(STATE_PAUSING);
		if (mediaPlayer != null) {
			mediaPlayer.setOnSeekCompleteListener(null);
			mediaPlayer.seekTo(0);
			mediaPlayer.pause();
		}
		this.showPauseView(false);
	}

	public void stop() {
		if (this.mediaPlayer != null) {
			this.mediaPlayer.reset();
			this.mediaPlayer.setOnSeekCompleteListener(null);
			this.mediaPlayer.stop();
			this.mediaPlayer.release();
			this.mediaPlayer = null;
		}
		setCurrentPlayState(STATE_IDLE);
		if (mCurrentCount < LOAD_TOTAL_COUNT) { //满足重新加载的条件
			mCurrentCount += 1;
			load();
		} else {
			showPauseView(false); //显示暂停状态
		}
	}

	public void destroy() {
		if (this.mediaPlayer != null) {
			this.mediaPlayer.setOnSeekCompleteListener(null);
			this.mediaPlayer.stop();
			this.mediaPlayer.release();
			this.mediaPlayer = null;
		}
		setCurrentPlayState(STATE_IDLE);
		mCurrentCount = 0;
		setIsComplete(false);
		setIsRealPause(false);
		unRegisterBroadcastReceiver();
		showPauseView(false); //除了播放和loading外其余任何状态都显示pause
	}

	/**
	 * 监听锁屏事件的广播接收器
	 */
	private class ScreenEventReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			//主动锁屏时 pause, 主动解锁屏幕时，resume
			switch (intent.getAction()) {
				case Intent.ACTION_USER_PRESENT:
					if (playerState == STATE_PAUSING) {
						if (mIsRealPause) {
							//手动点的暂停，回来后还暂停
							pause();
						} else {
							resume();
						}
					}
					break;
				//灭屏
				case Intent.ACTION_SCREEN_OFF:
					if (playerState == STATE_PLAYING) {
						pause();
					}
					break;
			}
		}
	}

	/**
	 * 供slot层来实现具体点击逻辑,具体逻辑还会变，
	 * 如果对UI的点击没有具体监测的话可以不回调
	 */
	public interface ADVideoPlayerListener {

		void onBufferUpdate(int time);

		void onClickFullScreenBtn();

		void onClickVideo();

		void onClickBackBtn();

		void onClickPlay();

		void onAdVideoLoadSuccess();

		void onAdVideoLoadFailed();

		void onAdVideoLoadComplete();
	}

	public interface ADFrameImageLoadListener {

		void onStartFrameLoad(String url, ImageLoaderListener listener);
	}

	public interface ImageLoaderListener {
		/**
		 * 如果图片下载不成功，传null
		 */
		void onLoadingComplete(Bitmap loadedImage);
	}
}