package com.imooc.imooc_voice.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

public class BaseDelegate extends NeteaseDelegate {


	@Override
	public Object setLayout() {
		return R.layout.delegate_base;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		getSupportDelegate().loadRootFragment(R.id.frame_base, new HomeDelegate());
	}

	@Override
	public void post(Runnable runnable) {

	}
}
