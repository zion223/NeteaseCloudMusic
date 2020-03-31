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


public abstract class NeteaseLoadingDelegate extends NeteaseDelegate{

	public FrameLayout frameLayout;
	public View rootView;


	@Override
	public Object setLayout() {
		return R.layout.delegate_music_load_framelayout;
	}


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		frameLayout = view.findViewById(R.id.loadframe);
		rootView = LayoutInflater.from(getContext()).inflate(setLoadingViewLayout(), frameLayout, false);

		addLoadingView();

	}

	@Override
	public void onLazyInitView(@Nullable Bundle savedInstanceState) {
		super.onLazyInitView(savedInstanceState);
		initView();
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
