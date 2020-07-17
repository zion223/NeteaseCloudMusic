package com.imooc.imooc_voice.view.user.follow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.home.search.sort.UserSearchDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.user.UserFollowerBean;
import com.imooc.lib_api.model.search.UserSearchBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

//获取用户关注的列表
public class UserFollowDelegate extends NeteaseLoadingDelegate {

	private static final String ARGS_USER_ID = "ARGS_USER_ID";


	private RecyclerView recyclerView;

	//用户id
	private String userId;
	private UserSearchDelegate.UserSearchAdapter mAdapter;

	public static UserFollowDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_USER_ID, id);
		final UserFollowDelegate delegate = new UserFollowDelegate();
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
		recyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		RequestCenter.getUserFollowed(userId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				UserFollowerBean bean = (UserFollowerBean) responseObj;
				ArrayList<UserSearchBean.ResultBean.UserprofilesBean> follow = bean.getFollow();
				mAdapter = new UserSearchDelegate.UserSearchAdapter(getContext(), follow, false);
				//查看用户详情
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						UserSearchBean.ResultBean.UserprofilesBean entity = (UserSearchBean.ResultBean.UserprofilesBean) adapter.getItem(position);
						getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(entity.getUserId()));
					}
				});
				recyclerView.setAdapter(mAdapter);
				recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}
}
