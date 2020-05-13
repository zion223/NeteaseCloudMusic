package com.imooc.imooc_voice.view.home.search.sort;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.HttpConstants;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.search.SongSearchBean;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import me.yokeyword.fragmentation.SupportFragmentDelegate;

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
				//TODO 播放全部
			}
		});
		RequestCenter.getSongSearch(keywords, 1, new DisposeDataListener() {

			@Override
			public void onSuccess(Object responseObj) {
				SongSearchBean bean = (SongSearchBean) responseObj;
				List<SongSearchBean.ResultBean.SongsBean> result = bean.getResult().getSongs();

				mAdapter = new SongSearchAdapter(keywords, getParentDelegate(), result);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						SongSearchBean.ResultBean.SongsBean entity = (SongSearchBean.ResultBean.SongsBean) baseQuickAdapter.getItem(i);
						String songUrl = HttpConstants.getSongPlayUrl(entity.getId());
						AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(entity.getId()), songUrl, entity.getName(), entity.getArtists().get(0).getName(), entity.getAlbum().getName(), entity.getAlbum().getName(), entity.getArtists().get(0).getPicUrl(), TimeUtil.getTimeNoYMDH(entity.getDuration())));
					}
				});
				//reload data
				mTvPlayNum.setText("(共" + result.size() + "首)");
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


	static class SongSearchAdapter extends BaseQuickAdapter<SongSearchBean.ResultBean.SongsBean, BaseViewHolder> {

		private String keywords;
		private NeteaseDelegate mDelegate;
		public SongSearchAdapter(String keyword, NeteaseDelegate delegate, @Nullable List<SongSearchBean.ResultBean.SongsBean> data) {
			super(R.layout.item_gedan_detail_song, data);
			this.keywords = keyword;
			this.mDelegate = delegate;
		}


		@Override
		protected void convert(@NonNull BaseViewHolder adapter, SongSearchBean.ResultBean.SongsBean item) {
			//不显示序号
			adapter.getView(R.id.item_play_no).setVisibility(View.GONE);
			if(item.getMvid() != 0){
				adapter.setVisible(R.id.iv_list_video, true);
			}

			adapter.setOnClickListener(R.id.iv_list_video, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					mDelegate.getSupportDelegate().start(MvDeatilDelegate.newInstance(String.valueOf(item.getMvid())));
				}
			});
			if (item.getName().contains(keywords)) {
				int start = item.getName().indexOf(keywords);
				int end = start + keywords.length();
				String resString = item.getName();
				SpannableStringBuilder style = new SpannableStringBuilder(resString);
				style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				adapter.setText(R.id.viewpager_list_toptext, style);
			} else {
				adapter.setText(R.id.viewpager_list_toptext, item.getName());
			}

			String artist = item.getArtists().get(0).getName();
			if (artist.contains(keywords)) {
				int start = artist.indexOf(keywords);
				int end = start + keywords.length();
				SpannableStringBuilder style = new SpannableStringBuilder(artist);
				style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				adapter.setText(R.id.viewpager_list_bottom_text, style);
			} else {
				adapter.setText(R.id.viewpager_list_bottom_text, artist);
			}

		}
	}
}
