package com.imooc.lib_audio.mediaplayer.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.imooc.lib_audio.R;
import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioPauseEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioStartEvent;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_audio.mediaplayer.view.adapter.IndictorViewPager;
import com.imooc.lib_audio.mediaplayer.view.adapter.MusicPagerAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class IndictorView extends RelativeLayout implements ViewPager.OnPageChangeListener, IndictorViewPager.OnSingleTouchListener {


	private static final String TAG = "IndictorView";
	private Context mContext;

	/*
	 * view相关
	 */
	private IndictorViewPager mViewPager;
	private MusicPagerAdapter mMusicPagerAdapter;

	/*
	 * data
	 */
	private AudioBean mAudioBean; //当前播放歌曲
	private ArrayList<AudioBean> mQueue; //播放队列

	/*
	 * Listener
	 */
	private OnIndicatorViewStatusChangeListener mListener;

	public IndictorView(Context context) {
		this(context,null);
	}

	public IndictorView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public IndictorView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mContext = context;
		EventBus.getDefault().register(this);
		initData();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		initView();
	}

	//取消注册EventBus
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		EventBus.getDefault().unregister(this);
	}

	private void initView() {
		View rootView = LayoutInflater.from(mContext).inflate(R.layout.indictor_view, this);
		mViewPager = rootView.findViewById(R.id.view_pager);
		mViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
		mMusicPagerAdapter = new MusicPagerAdapter(mQueue, mContext);
		mViewPager.setAdapter(mMusicPagerAdapter);
		showLoadView(false);
		//要在UI初始化完，否则会多一次listener响应
		mViewPager.addOnPageChangeListener(this);
		mViewPager.setOnSingleTouchListener(this);
	}

	private void initData() {
		mQueue = AudioController.INSTANCE.getQueue();
		mAudioBean = AudioController.INSTANCE.getNowPlaying();
	}


	private void showLoadView(boolean isSmooth) {
		mViewPager.setCurrentItem(mQueue.indexOf(mAudioBean), isSmooth);
	}

	/**
	 * 方法调用：当页面在滑动时至滑动被停止之前，此方法会一直调用
	 * 参数说明：
	 * arg0 :当前页面，及你点击滑动的页面
	 * arg1:当前页面偏移的百分比
	 * arg2:当前页面偏移的像素位置
	 */
	@Override
	public void onPageScrolled(int i, float v, int i1) {
		//当滑动百分比超过一半时 更新下一首歌曲
	}

	/**
	 * 方法调用：页面跳转完后调用
	 * 参数说明：arg0=当前选中页面的Position（位置编号）
	 */
	@Override
	public void onPageSelected(int position) {
		AudioController.INSTANCE.setPlayIndex(position);
	}

	//改变专辑动画
	@Override
	public void onPageScrollStateChanged(int state) {
		switch (state){
			//空闲状态
			case ViewPager.SCROLL_STATE_IDLE:
				Log.d(TAG, "SCROLL_STATE_IDLE");
				//当前是播放状态
				if(AudioController.INSTANCE.isStartState()){
					showPlayAnim();
					if(mListener != null){
						mListener.onIdle();
					}
				}
				break;
			//滑动状态
			case ViewPager.SCROLL_STATE_DRAGGING:
				Log.d(TAG, "SCROLL_STATE_DRAGGING");
				if(mListener != null){
					mListener.onDrag();
				}
				showPauseAnim();
				break;
			//滑动后自然沉降的状态
			case ViewPager.SCROLL_STATE_SETTLING:
				Log.d(TAG, "SCROLL_STATE_SETTLING");
				break;
		}
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onAudioLoadEvent(AudioLoadEvent event) {
		//更新viewpager为load状态
		mAudioBean = event.getBean();
		showLoadView(true);
		showPauseAnim();
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onAudioPauseEvent(AudioPauseEvent event) {
		//更新activity为暂停状态
		showPauseAnim();
	}


	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onAudioStartEvent(AudioStartEvent event) {
		//更新activity为播放状态
		showPlayAnim();
	}

	/**
	 * 暂停动画
	 */
	private void showPauseAnim() {
		Animator anim = mMusicPagerAdapter.getAnims(mViewPager.getCurrentItem());
		if (anim != null){
			anim.pause();
		}
	}

	
	/*
	 * 显示播放动画
	 */
	private void showPlayAnim() {
		ObjectAnimator anims = mMusicPagerAdapter.getAnims(mViewPager.getCurrentItem());
		if(anims != null){
			if(anims.isPaused()){
				anims.resume();
			}else{
				anims.start();
			}
		}
	}

	void setListener(OnIndicatorViewStatusChangeListener listener){
		this.mListener = listener;
	}

	@Override
	public void onSingleTouch(MotionEvent event) {
		if(mListener != null){
			mListener.onSingleTouch(event);
		}
	}

	public interface OnIndicatorViewStatusChangeListener {
		void onDrag();
		void onIdle();
		void onSingleTouch(MotionEvent event);
	}
}
