package com.imooc.imooc_voice.view.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.ScreenUtils;
import com.imooc.lib_audio.mediaplayer.view.BottomMusicView;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import butterknife.BindView;


public class BaseDelegate extends NeteaseDelegate {

	@BindView(R2.id.content_layout)
	RelativeLayout mRelativelayout;

	public BottomMusicView musicView;

	@Override
	public Object setLayout() {
		return R.layout.delegate_base;
	}


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		final View loadView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_base, mRelativelayout, false);
		musicView = loadView.findViewById(R.id.bottom_view);
		ScreenUtils.setStatusBarColor(getProxyActivity(), Color.parseColor("#ffffffff"));
		getSupportDelegate().loadRootFragment(R.id.frame_base, new HomeDelegate());
	}

	//TODO 返回按键拦截
	@Override
	public boolean onBackPressedSupport() {
		return false;
	}
}
