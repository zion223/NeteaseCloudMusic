package com.imooc.imooc_voice.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import butterknife.BindView;
import butterknife.OnClick;

public class BaseDelegate extends NeteaseDelegate {


	@BindView(R2.id.base_drawer_layout)
	DrawerLayout mDrawerLayout;

	@Override
	public Object setLayout() {
		return R.layout.delegate_base;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		getSupportDelegate().loadRootFragment(R.id.frame_base, new HomeDelegate());
	}


	@OnClick(R2.id.drawer_layout)
	void onClickDrawer(){
		if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
			mDrawerLayout.closeDrawer(Gravity.LEFT);
		} else {
			mDrawerLayout.openDrawer(Gravity.LEFT);
		}
	}

	@Override
	public void post(Runnable runnable) {

	}
}
