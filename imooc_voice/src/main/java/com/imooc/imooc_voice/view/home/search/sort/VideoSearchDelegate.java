package com.imooc.imooc_voice.view.home.search.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.search.FeedSearchBean;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class VideoSearchDelegate extends NeteaseSearchLoadingDelegate {


	@Override
	public void reloadSearchResult(final String keywords) {
			RequestCenter.getVideoSearch(keywords, 1014, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					FeedSearchBean bean = (FeedSearchBean) responseObj;
					List<FeedSearchBean.ResultBean.VideosBean> videos = bean.getResult().getVideos();

					mAdapter = new VideoSearchAdapter(keywords, videos);
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



	static class VideoSearchAdapter extends BaseQuickAdapter<FeedSearchBean.ResultBean.VideosBean, BaseViewHolder> {

		private String keywords;

		VideoSearchAdapter(String keyword, @Nullable List<FeedSearchBean.ResultBean.VideosBean> data) {
			super(R.layout.item_video_normal, data);
			keywords = keyword;
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, FeedSearchBean.ResultBean.VideosBean item) {

			String count;
			long playcount = item.getPlayTime();
			if (playcount >= 10000) {
				playcount = playcount / 10000;
				count = playcount + "万";
			} else {
				count = playcount + "";
			}
			//设置播放次数
			adapter.setText(R.id.tv_item_video_playnum, count);
			//视频标题
			adapter.setText(R.id.tv_item_video_name, SearchUtil.getMatchingKeywords(item.getTitle(), keywords));
			//视频描述
			String description = TimeUtil.getTimeNoYMDH(item.getDurationms()) + " by " + item.getCreator().get(0).getUserName();
			adapter.setText(R.id.tv_item_video_creator, description);
			ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_video_cover), item.getCoverUrl());


		}
	}
}
