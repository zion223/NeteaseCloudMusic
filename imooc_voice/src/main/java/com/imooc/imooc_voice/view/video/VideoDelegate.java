package com.imooc.imooc_voice.view.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.VideoBean;
import com.imooc.imooc_voice.model.newapi.VideoUrlBean;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.imooc.lib_video.videoplayer.core.VideoAdContext;

import java.util.List;

public class VideoDelegate extends NeteaseLoadingDelegate {

	private static final String ARGS_VIDEO_ID = "ARGS_VIDEO_ID";

	private String videoId;

	private RecyclerView mRecyclerView;
	private VideoAdapter mAdapter;

	public static VideoDelegate newInstance(long id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_VIDEO_ID, String.valueOf(id));
		final VideoDelegate delegate = new VideoDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			videoId = args.getString(ARGS_VIDEO_ID);
		}
	}


	@Override
	public void initView() {
		//TODO videoId = 1000 请求的视频是MV
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		RequestCenter.getVideoTab(videoId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				VideoBean bean = (VideoBean) responseObj;
				List<VideoBean.VideoEntity> datas = bean.getDatas();
				mAdapter = new VideoAdapter(datas);
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

	static class VideoAdapter extends BaseQuickAdapter<VideoBean.VideoEntity, BaseViewHolder>{
		private ImageLoaderManager manager = ImageLoaderManager.getInstance();

		VideoAdapter(@Nullable List<VideoBean.VideoEntity> data) {
			super(R.layout.item_home_video, data);
		}

		@Override
		protected void convert(@NonNull final BaseViewHolder adapter, final VideoBean.VideoEntity item) {
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_video_cover), item.getData().getCoverurl());
			//播放次数
			adapter.setText(R.id.tv_item_video_play_count, String.valueOf(item.getData().getPlaytime()));
			//播放时长
			adapter.setText(R.id.tv_item_video_play_duration, TimeUtil.getTimeNoYMDH(item.getData().getDurationms()));
			//视频标题
			adapter.setText(R.id.tv_item_video_title, item.getData().getTitle());
			//视频作者 头像
			manager.displayImageForCircle((ImageView) adapter.getView(R.id.iv_item_video_creator_img), item.getData().getCreator().getAvatarurl());
			//视频作者 用户名
			adapter.setText(R.id.tv_item_video_creator_name, item.getData().getCreator().getNickname());
			//点赞次数
			adapter.setText(R.id.tv_item_video_praised_count, String.valueOf(item.getData().getPraisedcount()));
			//评论次数
			adapter.setText(R.id.tv_item_video_comment_count, String.valueOf(item.getData().getCommentcount()));

			adapter.setOnClickListener(R.id.iv_item_video_cover, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					RequestCenter.getVideoUrl(item.getData().getVid(), new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {

							VideoUrlBean bean = (VideoUrlBean) responseObj;
							Log.e("VideoDelegate", "videoUrl:" + bean.getUrls().get(0).getUrl());
							VideoAdContext videoAdSlot = new VideoAdContext((RelativeLayout)adapter.getView(R.id.rl_item_video_group), bean.getUrls().get(0).getUrl());
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
