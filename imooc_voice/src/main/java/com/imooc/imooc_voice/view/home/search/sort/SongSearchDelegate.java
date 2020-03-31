package com.imooc.imooc_voice.view.home.search.sort;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.search.SongSearchBean;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;


import java.util.List;

/*
 *	单曲搜索
 */
public class SongSearchDelegate extends NeteaseSearchLoadingDelegate {


	@Override
	public void reloadSearchResult(String keyword) {
		requestSongSearchList(keyword);
	}

	@SuppressLint("SetTextI18n")
	private void requestSongSearchList(final String keywords) {
		final View headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_music_header, null);
		final TextView mTvPlayNum = headerView.findViewById(R.id.play_all_number);

		headerView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//播放全部
			}
		});
			RequestCenter.getSongSearch(keywords,1, new DisposeDataListener(){

				@Override
				public void onSuccess(Object responseObj) {
					SongSearchBean bean = (SongSearchBean) responseObj;
					List<SongSearchBean.ResultBean.SongsBean> result = bean.getResult().getSongs();

					mAdapter = new SongSearchAdapter(keywords, result);
					//reload data
					mTvPlayNum.setText("(共"+result.size()+")首");
					mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
					mAdapter.setHeaderView(headerView);
					mRecyclerView.setAdapter(mAdapter);
					mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
					addRootView();
				}

				@Override
				public void onFailure(Object reasonObj) {

				}
			});

	}


	static class SongSearchAdapter extends BaseQuickAdapter<SongSearchBean.ResultBean.SongsBean, BaseViewHolder>{

		private String keywords;
		private List<SongSearchBean.ResultBean.SongsBean> mData;
		public SongSearchAdapter(String keyword, @Nullable List<SongSearchBean.ResultBean.SongsBean> data) {
			super(R.layout.item_gedan_detail_song, data);
			this.keywords = keyword;
			this.mData = data;
		}

		public void reload(List<SongSearchBean.ResultBean.SongsBean> data){
			if(data.get(0).getName().equals(mData.get(0).getName())){
				setNewData(data);
			}
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, SongSearchBean.ResultBean.SongsBean item) {
			//不显示序号
			adapter.getView(R.id.item_play_no).setVisibility(View.GONE);

			if(item.getName().contains(keywords)){
				int start = item.getName().indexOf(keywords);
				int end = start + keywords.length();
				String resString = item.getName();
				SpannableStringBuilder style = new SpannableStringBuilder(resString);
				style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				adapter.setText(R.id.viewpager_list_toptext, style);
			}else{
				adapter.setText(R.id.viewpager_list_toptext, item.getName());
			}

			String artist = item.getArtists().get(0).getName();
			if(artist.contains(keywords)){
				int start = artist.indexOf(keywords);
				int end = start + keywords.length();
				String resString = artist;
				SpannableStringBuilder style = new SpannableStringBuilder(resString);
				style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				adapter.setText(R.id.viewpager_list_bottom_text, style);
			}else{
				adapter.setText(R.id.viewpager_list_bottom_text, artist);
			}

		}
	}
}
