package com.imooc.imooc_voice.view.cloud;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.cloud.adapter.EventAdapter;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.MainEventBean;
import com.imooc.lib_api.model.personal.UserEventBean;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;


//云村
public class CloudVillageFragment extends NeteaseLoadingDelegate implements SwipeRefreshLayout.OnRefreshListener{

	SwipeRefreshLayout refreshLayout;
	RecyclerView mRecyclerView;

	private MainEventBean mRecommandData;
	private List<UserEventBean.EventsBean> mDatas = new ArrayList<>();

	private EventAdapter mAdapter;


	@Override
	public void initView() {
		refreshLayout = rootView.findViewById(R.id.refresh_layout_delegate_friend);
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_friend);
		refreshLayout.setColorSchemeColors(getResources().getColor(R.color.red));
		requestData();
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_friend;
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
				mAdapter = new EventAdapter( CloudVillageFragment.this, mDatas);
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

}
