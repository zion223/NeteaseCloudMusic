package com.imooc.imooc_voice.view.home.search.artist.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.HttpConstants;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.event.ArtistIdEvent;
import com.imooc.imooc_voice.model.newapi.search.SingerSongSearchBean;
import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 歌手歌曲
 */
public class ArtistSongDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;
	private SongListDetailDelegate.PlayListAdapter mAdapter;

	private String artistId;

	private View headerView;
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);
		headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_artist_song_header, null, false);
	}

	@Override
	public void initView() {
		if(TextUtils.isEmpty(artistId)){
			artistId = SharePreferenceUtil.getInstance(getContext()).getCurrentArtistId();
		}
		RequestCenter.getSingerInfo(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				SingerSongSearchBean bean = (SingerSongSearchBean) responseObj;
				List<SongDetailBean.SongsBean> hotSongs = bean.getHotSongs();
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
				mAdapter = new SongListDetailDelegate.PlayListAdapter(getContext(), getParentDelegate(),true, hotSongs);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						SongDetailBean.SongsBean item = (SongDetailBean.SongsBean) adapter.getItem(position);
						String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
						AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDt())));

					}
				});
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

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
	public void onGetArtistIdEvent(ArtistIdEvent event){
		artistId = event.getId();
		SharePreferenceUtil.getInstance(getContext()).saveCurrentArtistId(artistId);
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}


}
