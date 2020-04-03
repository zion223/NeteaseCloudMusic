package com.imooc.imooc_voice.view.home.search.artist.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.event.ArtistIdEvent;
import com.imooc.imooc_voice.model.newapi.search.SingerAblumSearchBean;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 歌手专辑
 */
public class ArtistAlbumDelegate extends NeteaseLoadingDelegate {

	private RecyclerView mRecyclerView;
	private String artistId;
	private ArtistAlbumAdapter mAdapter;

	@Override
	public void initView() {
		if(TextUtils.isEmpty(artistId)){
			artistId = SharePreferenceUtil.getInstance(getContext()).getCurrentArtistId();
		}

		RequestCenter.getSingerAlbum(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				SingerAblumSearchBean bean = (SingerAblumSearchBean) responseObj;
				List<SingerAblumSearchBean.HotAlbumsBean> hotSongs = bean.getHotAlbums();
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
				mAdapter = new ArtistAlbumAdapter(hotSongs);
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
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}

	static class ArtistAlbumAdapter extends BaseQuickAdapter<SingerAblumSearchBean.HotAlbumsBean, BaseViewHolder>{

		ArtistAlbumAdapter(@Nullable List<SingerAblumSearchBean.HotAlbumsBean> data) {
			super(R.layout.item_mine_gedan_content, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, SingerAblumSearchBean.HotAlbumsBean item) {
			adapter.setVisible(R.id.iv_album_right_flag, true);
			adapter.setText(R.id.tv_item_gedan_content_toptext, item.getName());
			adapter.setText(R.id.tv_item_gedan_content_bottomtext, TimeUtil.getTimeStandardOnlyYMDWithDot(item.getPublishTime()) + " 歌曲"+item.getSize());
			ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_gedan_content_img), item.getPicUrl());
		}
	}
}
