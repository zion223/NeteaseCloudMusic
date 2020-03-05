package com.imooc.imooc_voice.view.discory.gedandetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.GedanDetailJson;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

import butterknife.BindView;

public class GedanDetailDelegate extends NeteaseDelegate {

	@BindView(R2.id.rv_gedan_detail_normal)
	RecyclerView mRecyclerViewGedan;

	private GedanDetailAdapter mAdapter;

	private static final String ARGS_GEDAN_ID = "ARGS_GEDAN_ID";
	//歌单ID
	private String id;

	public static GedanDetailDelegate newInstance(String id){
		final Bundle args = new Bundle();
		args.putString(ARGS_GEDAN_ID, id);
		final GedanDetailDelegate delegate = new GedanDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			id = args.getString(ARGS_GEDAN_ID);
		}
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_gedan_detail;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		RequestCenter.queryGedanDetail(id, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				GedanDetailJson json = (GedanDetailJson) responseObj;
				ArrayList<GedanDetailJson.GeDanDetail> content = json.getContent();
				mAdapter = new GedanDetailAdapter(content);
				mRecyclerViewGedan.setAdapter(mAdapter);
				mRecyclerViewGedan.setLayoutManager(new LinearLayoutManager(getContext()));
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
