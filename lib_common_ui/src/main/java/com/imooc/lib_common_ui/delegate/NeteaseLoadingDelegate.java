package com.imooc.lib_common_ui.delegate;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.imooc.lib_common_ui.R;


public abstract class NeteaseLoadingDelegate extends NeteaseDelegate{


	@Override
	public Object setLayout() {
		return R.layout.delegate_music_load_framelayout;
	}


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		final View loadView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_normal_loading, (FrameLayout)view.findViewById(R.id.loadframe), false);
		ImageView anim1 = loadView.findViewById(R.id.anim_image2);
		ImageView anim2 = loadView.findViewById(R.id.anim_image);
		AnimationDrawable animationDrawable = (AnimationDrawable)anim1.getDrawable();
		AnimationDrawable animation2Drawable = (AnimationDrawable)anim2.getDrawable();
		animationDrawable.start();
		animation2Drawable.start();
		((FrameLayout)view.findViewById(R.id.loadframe)).addView(loadView);

	}


}
