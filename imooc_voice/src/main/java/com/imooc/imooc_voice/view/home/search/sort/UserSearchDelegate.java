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
import com.imooc.imooc_voice.util.SearchUtil;
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
				mAdapter = new UserSearchAdapter(getContext(), userprofiles, keyword);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						UserSearchBean.ResultBean.UserprofilesBean entity = (UserSearchBean.ResultBean.UserprofilesBean) baseQuickAdapter.getItem(i);
						getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(entity.getUserId()));
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

	//用户查询Adapter
	public static class UserSearchAdapter extends BaseQuickAdapter<UserSearchBean.ResultBean.UserprofilesBean, BaseViewHolder> {

		private Context mContext;
		private String mKeyword = "";
		//是否显示关注或已关注的View
		private boolean showFollowView = true;

		public UserSearchAdapter(Context context, @Nullable List<UserSearchBean.ResultBean.UserprofilesBean> data) {
			super(R.layout.item_search_user, data);
			this.mContext = context;
		}

		UserSearchAdapter(Context context, @Nullable List<UserSearchBean.ResultBean.UserprofilesBean> data, String keyword) {
			super(R.layout.item_search_user, data);
			this.mContext = context;
			this.mKeyword = keyword;
		}

		public UserSearchAdapter(Context context, @Nullable List<UserSearchBean.ResultBean.UserprofilesBean> data, boolean showFollowView) {
			super(R.layout.item_search_user, data);
			this.mContext = context;
			this.showFollowView = showFollowView;
		}

		@Override
		protected void convert(@NonNull final BaseViewHolder adapter, final UserSearchBean.ResultBean.UserprofilesBean item) {
			//关键字匹配的字符串
			adapter.setText(R.id.tv_item_search_user_name, SearchUtil.getMatchingKeywords(item.getNickname(), mKeyword));

			//用户身份
			if(item.getUserType() == 4){
				//网易音乐人
				adapter.setText(R.id.tv_item_search_user_description, "网易音乐人");
				adapter.setVisible(R.id.iv_item_search_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_musician);

			}else if(item.getUserType() == 10 || item.getUserType() == 2){
				//明星用户
				adapter.setVisible(R.id.iv_item_search_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_official);
				adapter.setText(R.id.tv_item_search_user_description, item.getSignature());
			}else if(item.getUserType() == 200){
				//音乐达人
				adapter.setVisible(R.id.iv_item_search_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_yellow_star);
				adapter.setText(R.id.tv_item_search_user_description, item.getSignature());
			}else{
				adapter.setText(R.id.tv_item_search_user_description, item.getSignature());
			}
			if(!showFollowView){
				adapter.setVisible(R.id.ll_search_user_followed, false);
				adapter.setVisible(R.id.ll_search_user_follow, false);
			}else{
				//是否关注
				if(item.isFollowed()){
					adapter.setVisible(R.id.ll_search_user_followed, true);
					adapter.setVisible(R.id.ll_search_user_follow, false);
				}else{
					adapter.setVisible(R.id.ll_search_user_follow, true);
					adapter.setVisible(R.id.ll_search_user_followed, false);
				}
			}
			//性别
			if(item.getGender() == 1){
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
					RequestCenter.follow(item.getUserId(), false, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							FollowBean bean = (FollowBean) responseObj;
							if(bean.getCode() == 200){
								adapter.setVisible(R.id.ll_search_user_follow, true);
								adapter.setVisible(R.id.ll_search_user_followed, false);
							}
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
					RequestCenter.follow(item.getUserId(), true, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							FollowBean bean = (FollowBean) responseObj;
							if(bean.getCode() == 200){
								Toast.makeText(mContext, bean.getFollowContent(),Toast.LENGTH_SHORT).show();
								adapter.setVisible(R.id.ll_search_user_followed, true);
								adapter.setVisible(R.id.ll_search_user_follow, false);
							}
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
