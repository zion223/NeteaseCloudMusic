package com.imooc.imooc_voice.view.home.search.artist.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.event.ArtistIdEvent;
import com.imooc.imooc_voice.model.newapi.search.SimiSingerBean;
import com.imooc.imooc_voice.model.newapi.search.SingerSongSearchBean;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


/**
 * 歌手主页
 */
public class ArtistHomePageDelegate extends NeteaseLoadingDelegate {


	TextView mTvArtistBrief;
	RecyclerView mRvArtistHotSong;

	private String artistId;
	private ArtistHotSongAdapter mAdapter;

	@Override
	public void initView() {
		mTvArtistBrief = rootView.findViewById(R.id.tv_artist_homepage_brief);
		mRvArtistHotSong = rootView.findViewById(R.id.rv_artist_homepage_hot_song);
		if(TextUtils.isEmpty(artistId)){
			artistId = SharePreferenceUtil.getInstance(getContext()).getCurrentArtistId();
		}
		RequestCenter.getSingerInfo(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SingerSongSearchBean bean = (SingerSongSearchBean) responseObj;
				SingerSongSearchBean.ArtistBean artist = bean.getArtist();
				List<SingerSongSearchBean.HotSongsBean> hotSongs = bean.getHotSongs();
				mAdapter = new ArtistHotSongAdapter(hotSongs.subList(0,5));
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						SingerSongSearchBean.HotSongsBean entity = (SingerSongSearchBean.HotSongsBean) baseQuickAdapter.getItem(i);

					}
				});
				mRvArtistHotSong.setAdapter(mAdapter);
				mRvArtistHotSong.setLayoutManager(new LinearLayoutManager(getContext()));
				//简介
				mTvArtistBrief.setText(artist.getBriefDesc());
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		//相似歌手
		RequestCenter.getSimiSinger(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SimiSingerBean bean = (SimiSingerBean) responseObj;
				List<SimiSingerBean.ArtistsBean> simiArtists = bean.getArtists().subList(0, 3);

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_artist_homepage;
	}

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
	public void onGetArtistIdEvent(ArtistIdEvent event){
		artistId = event.getId();
	}

	static class ArtistHotSongAdapter extends BaseQuickAdapter<SingerSongSearchBean.HotSongsBean, BaseViewHolder> {

		ArtistHotSongAdapter(@Nullable List<SingerSongSearchBean.HotSongsBean> data) {
			super(R.layout.item_gedan_detail_song, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, SingerSongSearchBean.HotSongsBean item) {
			adapter.setText(R.id.item_play_no, String.valueOf(adapter.getLayoutPosition()+1));
			adapter.setText(R.id.viewpager_list_toptext, item.getName());
			adapter.setText(R.id.viewpager_list_bottom_text, item.getAr().get(0).getName() + "-" + item.getAl().getName());
			adapter.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
		}
	}

	static class SimiArtistAdapter extends BaseQuickAdapter<SimiSingerBean.ArtistsBean, BaseViewHolder>{

		public SimiArtistAdapter(int layoutResId, @Nullable List<SimiSingerBean.ArtistsBean> data) {
			super(layoutResId, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder baseViewHolder, SimiSingerBean.ArtistsBean artistsBean) {

		}
	}


}
