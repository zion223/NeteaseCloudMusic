package com.imooc.imooc_voice.view.user;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.personal.UserEventBean;
import com.imooc.imooc_voice.view.cloud.adapter.EventAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;


public class UserEventDelegate extends NeteaseLoadingDelegate {

	private static final String ARGS_USER_ID = "ARGS_USER_ID";

	private RecyclerView mRecyclerView;
	private EventAdapter mAdapter;

	private String userId;

	public static UserEventDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_USER_ID, id);
		final UserEventDelegate delegate = new UserEventDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			userId = args.getString(ARGS_USER_ID);
		}

	}

	@Override
	public void initView() {

		initEvent();
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_user_event_loading;
	}


	@SuppressLint("StaticFieldLeak")
	private void initEvent() {
		mRecyclerView = rootView.findViewById(R.id.rv_user_event);
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
			}

			@Override
			protected Void doInBackground(Void... voids) {
				RequestCenter.getUserEvent(userId, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						UserEventBean bean = (UserEventBean) responseObj;
						List<UserEventBean.EventsBean> events = bean.getEvents();
						mAdapter = new EventAdapter(events);
						mRecyclerView.setAdapter(mAdapter);
						mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
						addRootView();
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
				return null;
			}
		}.execute();

	}


}
