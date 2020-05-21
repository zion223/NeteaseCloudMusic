package com.imooc.imooc_voice.view.drawer.notification;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.notification.PrivateCommentBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

public class CommentDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;

	private CommentAdapter mAdapter;
	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		//获取当前用户ID
		int userId = SharePreferenceUtil.getInstance(getContext()).getUserId();

		RequestCenter.getPrivateComment(userId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				PrivateCommentBean bean = (PrivateCommentBean) responseObj;
				ArrayList<PrivateCommentBean.Comment> comments = bean.getComments();
				mAdapter = new CommentAdapter(comments);
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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


	static class CommentAdapter extends BaseQuickAdapter<PrivateCommentBean.Comment, BaseViewHolder> {

		CommentAdapter(@Nullable List<PrivateCommentBean.Comment> data) {
			super(R.layout.item_notification_comment, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, PrivateCommentBean.Comment comment) {
			//回复你的用户头像
			ImageLoaderManager.getInstance().displayImageForCircle(adapter.getView(R.id.iv_item_notification_comment_avatar_img), comment.getUser().getAvatarUrl());
			//用户昵称
			adapter.setText(R.id.tv_item_notification_comment_avatar_name, comment.getUser().getNickname());
			//回复时间
			adapter.setText(R.id.tv_item_notification_comment_time, TimeUtil.getPrivateMsgTime(comment.getTime()));
			//回复内容
			adapter.setText(R.id.tv_item_notification_content, "回复我: "+comment.getContent());
			//被回复的内容
			adapter.setText(R.id.tv_item_notification_comment_replied, comment.getBeRepliedContent());

		}
	}
}
