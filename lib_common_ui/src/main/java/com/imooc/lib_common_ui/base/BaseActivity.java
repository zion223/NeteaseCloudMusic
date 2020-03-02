package com.imooc.lib_common_ui.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.imooc.lib_common_ui.utils.StatusBarUtil;

public class BaseActivity extends FragmentActivity {


	/**
	 * 沉浸式效果
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StatusBarUtil.statusBarLightMode(this);
	}
}
