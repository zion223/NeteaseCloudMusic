package com.imooc.imooc_voice.view.video.mv;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

public class MvNormalDelegate extends NeteaseDelegate {

	/**
	 * MV 精选 更多MV
	 * 排行榜
	 * MV分类
	 *
	 */

	@Override
	public Object setLayout() {
		return R.layout.delegate_mv_normal;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

	}
}
