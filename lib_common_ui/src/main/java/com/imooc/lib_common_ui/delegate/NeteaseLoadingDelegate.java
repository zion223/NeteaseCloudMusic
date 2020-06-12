package com.imooc.lib_common_ui.delegate;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.imooc.lib_common_ui.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public abstract class NeteaseLoadingDelegate extends NeteaseDelegate{

	public FrameLayout frameLayout;
	public View rootView;


	/**
	 * 	若重写此方法 则布局中需要有id为loadframe的FrameLayout
	 */
	@Override
	public Object setLayout() {
		return R.layout.delegate_music_load_framelayout;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		EventBus.getDefault().register(this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		frameLayout = view.findViewById(R.id.loadframe);
		if(frameLayout == null){
			throw new NullPointerException("can not find FrameLayout id loadframe");
		}else{
			rootView = LayoutInflater.from(getContext()).inflate(setLoadingViewLayout(), frameLayout, false);
			addLoadingView();
		}

	}

	@Override
	public void onLazyInitView(@Nullable Bundle savedInstanceState) {
		super.onLazyInitView(savedInstanceState);
		initView();
	}

	/**
	 * 	防止出现EventBus报错
	 */
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onGetEvent(CommentEvent event){

	}

	public abstract void initView();


	public abstract int setLoadingViewLayout();


	/**
	 *	布局构建完成后需手动调用此方法
	 */
	public void addRootView(){
		frameLayout.removeAllViews();
		//framelayout 创建了新的实例
		ViewGroup p = (ViewGroup) rootView.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
		}
		frameLayout.addView(rootView);
	}

	/**
	 * 	加入Loading布局
	 */
	public void addLoadingView() {
		final View loadView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_normal_loading, frameLayout, false);
		ImageView anim1 = loadView.findViewById(R.id.anim_image2);
		ImageView anim2 = loadView.findViewById(R.id.anim_image);
		AnimationDrawable animationDrawable = (AnimationDrawable)anim1.getDrawable();
		AnimationDrawable animation2Drawable = (AnimationDrawable)anim2.getDrawable();
		animationDrawable.start();
		animation2Drawable.start();
		if(frameLayout != null){
			frameLayout.removeAllViews();
			frameLayout.addView(loadView);
		}

	}

	@Override
	public void post(Runnable runnable) {

	}

}
