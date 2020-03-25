package com.imooc.imooc_voice.view.friend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.friend.BaseFriendModel;
import com.imooc.imooc_voice.model.friend.FriendBodyValue;
import com.imooc.imooc_voice.model.newapi.MainEventBean;
import com.imooc.imooc_voice.model.newapi.personal.UserEventBean;
import com.imooc.imooc_voice.view.friend.adapter.EventAdapter;
import com.imooc.imooc_voice.view.friend.adapter.FriendAdapter;
import com.imooc.imooc_voice.view.home.BaseDelegate;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FriendFragment extends NeteaseDelegate implements SwipeRefreshLayout.OnRefreshListener{

	@BindView(R2.id.refresh_layout_delegate_friend)
	SwipeRefreshLayout refreshLayout;
	@BindView(R2.id.rv_delegate_friend)
	RecyclerView mRecyclerView;

	private MainEventBean mRecommandData;
	private List<UserEventBean.EventsBean> mDatas = new ArrayList<>();

	private EventAdapter mAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_friend;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		refreshLayout.setColorSchemeColors(getResources().getColor(R.color.red));
		requestData();
	}

	@Override
	public void post(Runnable runnable) {

	}

	@Override
	public void onRefresh() {
		//requestData();
		Netease.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				refreshLayout.setRefreshing(false);
			}
		}, 2000);
	}


	private void requestData(){

		RequestCenter.getMainEvent(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				mRecommandData = (MainEventBean) responseObj;
				mDatas = mRecommandData.getEvent();
				mAdapter = new EventAdapter(mDatas);
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}
}
