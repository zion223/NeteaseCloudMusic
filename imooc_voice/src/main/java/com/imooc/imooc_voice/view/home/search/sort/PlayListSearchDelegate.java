package com.imooc.imooc_voice.view.home.search.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.search.PlayListSearchBean;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

/*
 *	歌单搜素
 */
public class PlayListSearchDelegate extends NeteaseSearchLoadingDelegate {


	@Override
	public void reloadSearchResult(final String keywords) {

		RequestCenter.getPlayListSearch(keywords, 1000, new DisposeDataListener() {

			@Override
			public void onSuccess(Object responseObj) {
				PlayListSearchBean bean = (PlayListSearchBean) responseObj;
				List<PlayListSearchBean.ResultBean.PlaylistsBean> playlists = bean.getResult().getPlaylists();
				mAdapter = new PlayListSearchAdapter(keywords, playlists);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						PlayListSearchBean.ResultBean.PlaylistsBean entity = (PlayListSearchBean.ResultBean.PlaylistsBean) baseQuickAdapter.getItem(i);
						getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(SongListDetailDelegate.TYPE_PLAYLIST,entity.getId()));
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

	static class PlayListSearchAdapter extends BaseQuickAdapter<PlayListSearchBean.ResultBean.PlaylistsBean, BaseViewHolder> {

		private String keywords;

		PlayListSearchAdapter(String keyword, @Nullable List<PlayListSearchBean.ResultBean.PlaylistsBean> data) {
			super(R.layout.item_mine_gedan_content, data);
			this.keywords = keyword;
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, PlayListSearchBean.ResultBean.PlaylistsBean item) {


			adapter.setText(R.id.tv_item_gedan_content_toptext, SearchUtil.getMatchingKeywords(item.getName(), keywords));

			String description;
			int playcount = item.getPlayCount();
			String count;
			if (playcount >= 10000) {
				playcount = playcount / 10000;
				count = playcount + "万次";
			} else {
				count = playcount + "次";
			}
			description = item.getTrackCount() + "首，by " + item.getCreator().getNickname() + "，播放" + count;

			adapter.setText(R.id.tv_item_gedan_content_bottomtext, SearchUtil.getMatchingKeywords(description, keywords));
			adapter.setVisible(R.id.iv_item_gedan_more, false);
			ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_gedan_content_img), item.getCoverImgUrl());

		}
	}
}
