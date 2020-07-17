package com.imooc.imooc_voice.view.home.search.artist.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.event.ArtistIdEvent;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.square.detail.PlayListAdapter;
import com.imooc.lib_api.HttpConstants;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.search.SimiSingerBean;
import com.imooc.lib_api.model.search.SingerSongSearchBean;
import com.imooc.lib_api.model.song.SongDetailBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_api.model.song.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * 歌手主页
 */
public class ArtistHomePageDelegate extends NeteaseLoadingDelegate {


	TextView mTvArtistBrief;
	RecyclerView mRvArtistHotSong;

	private String artistId;
	private PlayListAdapter mAdapter;

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
				//热门歌曲
				List<SongDetailBean.SongsBean> hotSongs = bean.getHotSongs();
				if(hotSongs.size() > 5){
					mAdapter = new PlayListAdapter(getContext(), getParentDelegate(), false, hotSongs.subList(0, 5));
				}else{
					mAdapter = new PlayListAdapter(getContext(), getParentDelegate(), false, hotSongs);
				}
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						SongDetailBean.SongsBean item = (SongDetailBean.SongsBean) adapter.getItem(position);
						String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
						AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDt())));

					}
				});
				mRvArtistHotSong.setAdapter(mAdapter);
				mRvArtistHotSong.setLayoutManager(new LinearLayoutManager(getContext()));
				//歌手简介
				mTvArtistBrief.setText(artist.getBriefDesc());
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		//TODO 相似歌手   无粉丝数数据
		RequestCenter.getSimiSinger(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SimiSingerBean bean = (SimiSingerBean) responseObj;
				List<SimiSingerBean.ArtistsBean> simiArtists = new ArrayList<>();
				if(bean.getArtists().size() >= 3){
					 simiArtists = bean.getArtists().subList(0, 3);
				}else{
					simiArtists = bean.getArtists();
				}


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


	static class SimiArtistAdapter extends BaseQuickAdapter<SimiSingerBean.ArtistsBean, BaseViewHolder>{

		public SimiArtistAdapter(int layoutResId, @Nullable List<SimiSingerBean.ArtistsBean> data) {
			super(layoutResId, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder baseViewHolder, SimiSingerBean.ArtistsBean artistsBean) {

		}
	}


}
