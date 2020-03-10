package com.imooc.imooc_voice.view.discory.rank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.HttpConstants;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import butterknife.BindView;

public class RankingDelegate extends NeteaseDelegate {

	@BindView(R2.id.rv_rank_normal)
	RecyclerView mREcyclerViewRank;

	private RankAdapter mAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_rank;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		RequestCenter.queryRankingSong(HttpConstants.Billboard.BILLBOARD_NEW_MUSIC, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public void post(Runnable runnable) {

	}
}
