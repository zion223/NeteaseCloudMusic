package com.imooc.imooc_voice.view.cloud;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.cloud.adapter.EventAdapter;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.MainEventBean;
import com.imooc.lib_api.model.personal.UserEventBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


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
		//延时操作符
		Observable.timer(2, TimeUnit.SECONDS)
				.subscribe(new Observer<Long>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(Long aLong) {
						refreshLayout.setRefreshing(false);
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
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
