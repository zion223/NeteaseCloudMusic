package com.imooc.lib_video.videoplayer;

import android.content.Context;
import android.util.AttributeSet;

import cn.jzvd.JzvdStd;


public class CustomJzVideoView extends JzvdStd {


	public CustomJzVideoView(Context context) {
		super(context);
	}

	public CustomJzVideoView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onStatePlaying() {
		super.onStatePlaying();
		if(listener != null){
			listener.onStatePlaying();
		}
	}

	@Override
	public void onStatePause() {
		super.onStatePause();
		if(listener != null){
			listener.onStatePause();
		}
	}


	public OnVideoStateChangeListener listener;

	public void setListener(OnVideoStateChangeListener listener) {
		this.listener = listener;
	}

	public interface OnVideoStateChangeListener{

		void onStatePlaying();
		void onStatePause();
	}
}
