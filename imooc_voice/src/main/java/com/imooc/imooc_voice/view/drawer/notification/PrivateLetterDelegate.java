package com.imooc.imooc_voice.view.drawer.notification;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.notification.MsgDetailBean;
import com.imooc.lib_api.model.notification.PrivateMsgBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;


//私信
public class PrivateLetterDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;

	private PrivateMsgAdapter mAdapter;

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		RequestCenter.getPrivateMsg(30, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				PrivateMsgBean msg = (PrivateMsgBean) responseObj;
				ArrayList<PrivateMsgBean.Msg> msgs = msg.getMsgs();
				mAdapter = new PrivateMsgAdapter(msgs);
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

	static class PrivateMsgAdapter extends BaseQuickAdapter<PrivateMsgBean.Msg, BaseViewHolder> {

		PrivateMsgAdapter(@Nullable List<PrivateMsgBean.Msg> data) {
			super(R.layout.item_notification_msg, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, PrivateMsgBean.Msg item) {
			Log.e("id", item.getFromUser().getUserId() + "==" +item.getFromUser().getNickname());
			//发私信的人 昵称
			adapter.setText(R.id.tv_item_notification_fromuser, item.getFromUser().getNickname());
			//发送时间
			adapter.setText(R.id.tv_item_notification_time, TimeUtil.getPrivateMsgTime(item.getLastMsgTime()));
			ImageLoaderManager.getInstance().displayImageForCircle(adapter.getView(R.id.iv_item_notification_fromuser_avatar), item.getFromUser().getAvatarUrl());
			//最后一条消息
			String lastMsg = item.getLastMsg();
			MsgDetailBean msgDetailBean = GsonUtil.fromJSON(lastMsg, MsgDetailBean.class);
			adapter.setText(R.id.iv_item_notification_message, msgDetailBean.getMsg());

			//用户身份
			if(item.getFromUser().getUserType() == 4){
				//网易音乐人
				adapter.setVisible(R.id.iv_item_notification_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_notification_user_tag)).setImageResource(R.drawable.ic_musician);

			}else if(item.getFromUser().getUserType() ==10){
				//大V
				adapter.setVisible(R.id.iv_item_notification_user_tag, true);
				((ImageView)adapter.getView(R.id.iv_item_notification_user_tag)).setImageResource(R.drawable.ic_official);
			}

			if (item.getNewMsgCount() != 0){
				adapter.setVisible(R.id.tv_item_notification_count, true);
				adapter.setText(R.id.tv_item_notification_count, String.valueOf(item.getNewMsgCount()));
			}
		}
	}
}
