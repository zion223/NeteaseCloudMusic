package com.imooc.imooc_voice.view.video.mv;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import butterknife.OnClick;

public class MvDelegate extends NeteaseDelegate {

	/**
	 * 	MV 精选 更多MV
	 * 	排行榜
	 * 	MV分类 全部MV
	 *
	 */

	@Override
	public Object setLayout() {
		return R.layout.delegate_mv_normal;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

	}


	@OnClick(R2.id.rl_mv_rank)
	void onClickRank(){
		getParentDelegate().getParentDelegate().getSupportDelegate().start(new MvRankTabDelegate());
	}


	//更多MV
	@OnClick(R2.id.tv_mv_more)
	void onClickMoreMv(){
		getParentDelegate().getParentDelegate().getSupportDelegate().start(new MvMoreDelegate());

	}
}
