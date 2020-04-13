package com.imooc.imooc_voice.view.cloud.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.newapi.personal.UserEventBean;
import com.imooc.imooc_voice.model.newapi.personal.UserEventJsonBean;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends BaseQuickAdapter<UserEventBean.EventsBean, BaseViewHolder> {

	private ImageLoaderManager manager;
	private List<ImageView> imgList = new ArrayList<>();

	public EventAdapter(@Nullable List<UserEventBean.EventsBean> data) {
		super(R.layout.item_user_event, data);
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	protected void convert(@NonNull BaseViewHolder adapter, UserEventBean.EventsBean item) {
		//用户头像
		ImageView avatarView = adapter.getView(R.id.iv_avatar);
		manager.displayImageForCircle(avatarView, item.getUser().getAvatarUrl());
		adapter.setText(R.id.tv_nickname, item.getUser().getNickname());
		adapter.setText(R.id.tv_publish_time, TimeUtil.getTimeStandardOnlyYMDChinese(item.getShowTime()));
		adapter.setText(R.id.tv_relayout_count, item.getInfo().getShareCount() == 0 ? "" : String.valueOf(item.getInfo().getShareCount()));
		adapter.setText(R.id.tv_comment_count, item.getInfo().getCommentCount() == 0 ? "" : String.valueOf(item.getInfo().getCommentCount()));
		adapter.setText(R.id.tv_like_count, item.getInfo().getLikedCount() == 0 ? "" : String.valueOf(item.getInfo().getLikedCount()));

		initImageView(adapter);
		showImg(adapter, item);
		String jsonEvnet = item.getJson();
		UserEventJsonBean userEventJsonBean = GsonUtil.fromJSON(jsonEvnet, UserEventJsonBean.class);
		if (userEventJsonBean != null) {
			Log.d(TAG, "jsonBean:" + userEventJsonBean);
			//显示msg内容
			if (!TextUtils.isEmpty(userEventJsonBean.getMsg())) {
				adapter.setVisible(R.id.tv_content, true);
				adapter.setText(R.id.tv_content, userEventJsonBean.getMsg());
			}
			//showImg(adapter, item);
			showShareLayout(adapter, userEventJsonBean);
			int type;
			if (item.getInfo().getCommentThread().getResourceInfo() == null) {
				type = item.getType();
			} else {
				type = item.getInfo().getCommentThread().getResourceInfo().getEventType();
			}

			//
			//String resourceInfo = item.getInfo().getCommentThread().getResourceInfo().getName();
			//String title = resourceInfo.split(":")[0];
			//标题头
			//adapter.setText(R.id.tv_title, title + ":");

			switch (type) {
				case 18:
					adapter.setText(R.id.tv_title, "分享单曲：");
					break;
				case 19:
					adapter.setText(R.id.tv_title, "分享专辑：");
					break;
				case 17:
				case 28:
					adapter.setText(R.id.tv_title, "分享电台节目：");
					break;
				case 22:
					adapter.setText(R.id.tv_title, "转发：");
					break;
				case 39:
					adapter.setText(R.id.tv_title, "发布视频：");
					showVideoBean(adapter, userEventJsonBean);
					break;
				case 35:
					break;
				case 13:
					adapter.setText(R.id.tv_title, "分享歌单：");
					break;
				case 24:
					adapter.setText(R.id.tv_title, "分享专栏文章：");
					break;
				case 41:
				case 21:
					adapter.setText(R.id.tv_title, "分享视频：");
					break;
					// 13 分享歌单 24 分享专栏文章  41 21 分享视频 2

			}

		}
	}

	private void showVideoBean(BaseViewHolder adapter, UserEventJsonBean userEventJsonBean) {
		//adapter.setVisible(R.id.rl_video, true);
		//adapter.setVisible(R.id.iv_vid, true);
		//manager.displayImageForView((ImageView) adapter.getView(R.id.iv_vid), userEventJsonBean.getVideo().getCoverUrl());
	}

	private void initImageView(BaseViewHolder adapter) {
		ImageView ivShow1 = adapter.getView(R.id.iv_img_1);
		ImageView ivShow2 = adapter.getView(R.id.iv_img_2);
		ImageView ivShow3 = adapter.getView(R.id.iv_img_3);
		ImageView ivShow4 = adapter.getView(R.id.iv_img_4);
		ImageView ivShow5 = adapter.getView(R.id.iv_img_5);
		ImageView ivShow6 = adapter.getView(R.id.iv_img_6);
		ImageView ivShow7 = adapter.getView(R.id.iv_img_7);
		ImageView ivShow8 = adapter.getView(R.id.iv_img_8);
		ImageView ivShow9 = adapter.getView(R.id.iv_img_9);
		imgList.add(ivShow1);
		imgList.add(ivShow2);
		imgList.add(ivShow3);
		imgList.add(ivShow4);
		imgList.add(ivShow5);
		imgList.add(ivShow6);
		imgList.add(ivShow7);
		imgList.add(ivShow8);
		imgList.add(ivShow9);
	}




	//显示图片
	private void showImg(BaseViewHolder adapter, UserEventBean.EventsBean item) {
		if (item.getPics() != null || item.getPics().size() != 0) {
			adapter.setVisible(R.id.rl_img, true);
			Log.d(TAG, "size:" + item.getPics().size());
			for (int i = 0; i < item.getPics().size(); i++) {
				if (i == 0) {
					adapter.setVisible(R.id.ll_img_group1, true);
				}
				if (i == 3) {
					adapter.setVisible(R.id.ll_img_group2, true);
				}
				if (i == 6) {
					adapter.setVisible(R.id.ll_img_group3, true);
				}
				//Glide.with(mContext).load(list.get(position).getPics().get(i).getRectangleUrl()).transition(new DrawableTransitionOptions().crossFade()).into(imgList.get(i));
				manager.displayImageForCorner(imgList.get(i), item.getPics().get(i).getRectangleUrl());
			}
		}
	}

	//分享 layout
	private void showShareLayout(BaseViewHolder adapter, UserEventJsonBean jsonBean) {
		//单曲
		if (jsonBean != null && jsonBean.getSong() != null && !TextUtils.isEmpty(jsonBean.getSong().getName())) {
			adapter.setVisible(R.id.rl_share, true);
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getSong().getAlbum().getPicUrl());
			//单曲名
			adapter.setText(R.id.tv_songname, jsonBean.getSong().getName());
			//歌手名
			adapter.setText(R.id.tv_creator_name, jsonBean.getSong().getArtists().get(0).getName());

			//节目
		} else if (jsonBean != null && jsonBean.getProgram() != null && !TextUtils.isEmpty(jsonBean.getProgram().getName()) ) {
			adapter.setVisible(R.id.rl_share, true);
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getProgram().getCoverUrl());

			adapter.setText(R.id.tv_songname, jsonBean.getProgram().getName());
			//电台名称
			adapter.setText(R.id.tv_creator_name, jsonBean.getProgram().getRadio().getName());

			//视频
		} else if(jsonBean != null && jsonBean.getVideo() != null ){
			adapter.setVisible(R.id.rl_video, true);
			adapter.setVisible(R.id.iv_vid, true);
			manager.displayImageForView((ImageView) adapter.getView(R.id.iv_vid), jsonBean.getVideo().getCoverUrl());
		}else{
			adapter.setVisible(R.id.rl_share, false);
		}
	}

}
