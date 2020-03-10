package com.imooc.imooc_voice.view.discory.square;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.GedanJson;
import com.imooc.imooc_voice.view.discory.GedanAdapter;
import com.imooc.imooc_voice.view.discory.square.gedandetail.GedanDetailDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

import butterknife.BindView;

public class GedanDelegate extends NeteaseDelegate {

	private static final String ARGS_GEDAN_TAG = "ARGS_GEDAN_TAG";
	private String tag;

	@BindView(R2.id.rv_gedan_normal)
	RecyclerView mRecyclerViewGedan;

	private GedanAdapter mAdapter;

	static GedanDelegate newInstance(String tag){
		final Bundle args = new Bundle();
		args.putString(ARGS_GEDAN_TAG, tag);
		final GedanDelegate delegate = new GedanDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_gedan;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			tag = args.getString(ARGS_GEDAN_TAG);
		}
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		final GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
		RequestCenter.queryGeDanByTag(tag, 1, 20, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				GedanJson json = (GedanJson) responseObj;
				ArrayList<GedanJson.GeDan> content = json.getContent();
				mAdapter = new GedanAdapter(content);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						GedanJson.GeDan item = (GedanJson.GeDan) adapter.getItem(position);
						getParentDelegate().getSupportDelegate().start(GedanDetailDelegate.newInstance(item.getListid()));
					}
				});
				mRecyclerViewGedan.setAdapter(mAdapter);
				mRecyclerViewGedan.setLayoutManager(manager);
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
