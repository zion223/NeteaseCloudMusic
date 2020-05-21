package com.imooc.imooc_voice.view.home.search.sort;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.FollowBean;
import com.imooc.lib_api.model.search.UserSearchBean;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class UserSearchDelegate extends NeteaseSearchLoadingDelegate {



	@Override
	public void reloadSearchResult(String keyword) {

		RequestCenter.getUserSearch(keyword, 1002, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				UserSearchBean bean = (UserSearchBean) responseObj;
				List<UserSearchBean.ResultBean.UserprofilesBean> userprofiles = bean.getResult().getUserprofiles();
				mAdapter = new UserSearchAdapter(getContext(), userprofiles);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						UserSearchBean.ResultBean.UserprofilesBean entity = (UserSearchBean.ResultBean.UserprofilesBean) baseQuickAdapter.getItem(i);
						getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(String.valueOf(entity.getUserId())));
					}
				});
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	static class UserSearchAdapter extends BaseQuickAdapter<UserSearchBean.ResultBean.UserprofilesBean, BaseViewHolder> {

		private Context mContext;

		public UserSearchAdapter(Context context, @Nullable List<UserSearchBean.ResultBean.UserprofilesBean> data) {
			super(R.layout.item_search_user, data);
			this.mContext = context;
		}

		@Override
		protected void convert(@NonNull final BaseViewHolder adapter, final UserSearchBean.ResultBean.UserprofilesBean item) {
			adapter.setText(R.id.tv_item_search_user_name, item.getNickname());

			//用户身份
			if(item.getUserType() == 4){
				//网易音乐人
				adapter.setText(R.id.tv_item_search_user_description, "网易音乐人");
				adapter.setVisible(R.id.iv_item_search_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_musician);

			}else if(item.getUserType() ==10){
				//大V
				adapter.setVisible(R.id.iv_item_search_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_official);
				adapter.setText(R.id.tv_item_search_user_description, item.getDescription());
			}else{
				adapter.setText(R.id.tv_item_search_user_description, item.getDescription());
			}
			//是否关注
			if(item.isFollowed()){
				adapter.setVisible(R.id.ll_search_user_followed, true);
			}else{
				adapter.setVisible(R.id.ll_search_user_follow, true);
			}
			//性别
			if(item.getGender()==1){
				//男性
				adapter.setVisible(R.id.iv_item_search_user_gender, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_gender)).setImageResource(R.drawable.ic_male);
			}else if(item.getGender() == 2){
				//女性
				adapter.setVisible(R.id.iv_item_search_user_gender, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_gender)).setImageResource(R.drawable.ic_female);
			}
			//用户头像
			ImageLoaderManager.getInstance().displayImageForCircle((ImageView) adapter.getView(R.id.iv_item_search_user_avatar), item.getAvatarUrl());


			//取消关注
			adapter.setOnClickListener(R.id.ll_search_user_followed, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					RequestCenter.follow(String.valueOf(item.getUserId()), false, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							FollowBean bean = (FollowBean) responseObj;
							Toast.makeText(mContext, bean.getFollowContent(),Toast.LENGTH_SHORT).show();
							adapter.setVisible(R.id.ll_search_user_follow, true);
							adapter.setVisible(R.id.ll_search_user_followed, false);
						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});
				}
			});
			//关注用户
			adapter.setOnClickListener(R.id.ll_search_user_follow, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					RequestCenter.follow(String.valueOf(item.getUserId()), true, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							FollowBean bean = (FollowBean) responseObj;
							Toast.makeText(mContext, bean.getFollowContent(),Toast.LENGTH_SHORT).show();
							adapter.setVisible(R.id.ll_search_user_followed, true);
							adapter.setVisible(R.id.ll_search_user_follow, false);
						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});
				}
			});

		}
	}
}
