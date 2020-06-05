package com.imooc.imooc_voice.view.drawer.notification;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.notification.PrivateNoticeBean;
import com.imooc.lib_api.model.notification.UserNoticeJsonBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;


//通知
public class PrivateNoticeDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;

	private PrivateNoticeAdapter mAdapter;

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		//获取用户的通知
		RequestCenter.getPrivateNotice(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				PrivateNoticeBean bean = (PrivateNoticeBean) responseObj;
				ArrayList<PrivateNoticeBean.Notice> notices = bean.getNotices();
				mAdapter = new PrivateNoticeAdapter(notices);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				mRecyclerView.setAdapter(mAdapter);
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

	static class PrivateNoticeAdapter extends BaseQuickAdapter<PrivateNoticeBean.Notice, BaseViewHolder> {

		PrivateNoticeAdapter(@Nullable List<PrivateNoticeBean.Notice> data) {
			super(R.layout.item_notification_notice, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, PrivateNoticeBean.Notice item) {
			//解析JSON数据  TODO 适配更多通知类型

			UserNoticeJsonBean userNoticeJsonBean = GsonUtil.fromJSON(item.getNotice(), UserNoticeJsonBean.class);
			if(userNoticeJsonBean.getComment() != null){
				//评论的内容
				adapter.setText(R.id.iv_item_notice_message, userNoticeJsonBean.getComment().getContent());
				//点赞评论
				adapter.setText(R.id.tv_item_notice_event, "赞了你的评论");
			}else if(userNoticeJsonBean.getPlaylist() != null){
				//歌单的通知
				adapter.setText(R.id.iv_item_notice_message, userNoticeJsonBean.getPlaylist().getName());
				adapter.setText(R.id.tv_item_notice_event, "收藏了你的歌单");
			}else{
				adapter.setText(R.id.iv_item_notice_message, "不支持的内容");
				adapter.setText(R.id.tv_item_notice_event, "不支持的内容");
			}
			adapter.setText(R.id.tv_item_notice_fromuser, userNoticeJsonBean.getUser().getNickname());
			//时间
			adapter.setText(R.id.tv_item_notice_time, TimeUtil.getPrivateMsgTime(item.getTime()));

			ImageLoaderManager.getInstance().displayImageForCircle(adapter.getView(R.id.iv_item_notice_fromuser_avatar), userNoticeJsonBean.getUser().getAvatarUrl());

			if(userNoticeJsonBean.getUser().getUserType() == 4){
				//网易音乐人
				adapter.setVisible(R.id.iv_item_notification_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_notification_user_tag)).setImageResource(R.drawable.ic_musician);

			}else if(userNoticeJsonBean.getUser().getUserType() == 10 || userNoticeJsonBean.getUser().getUserType() == 2){
				//明星用户
				adapter.setVisible(R.id.iv_item_notification_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_notification_user_tag)).setImageResource(R.drawable.ic_official);
			}else if(userNoticeJsonBean.getUser().getUserType() == 200){
				//音乐达人
				adapter.setVisible(R.id.iv_item_notification_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_notification_user_tag)).setImageResource(R.drawable.ic_yellow_star);
			}

		}
	}
}
