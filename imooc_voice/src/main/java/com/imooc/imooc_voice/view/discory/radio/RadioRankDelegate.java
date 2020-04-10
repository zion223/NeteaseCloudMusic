package com.imooc.imooc_voice.view.discory.radio;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.dj.DjTopListBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class RadioRankDelegate extends NeteaseDelegate {

	/**
	 * 	主播电台排行榜
	 * 	 主播榜 24小时榜 新人榜 最热主播
	 * 	 节目榜(默认)
	 * 	 电台榜
	 */

	@Override
	public Object setLayout() {
		return null;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

	}
}
