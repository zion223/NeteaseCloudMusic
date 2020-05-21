package com.imooc.imooc_voice.view.home.search.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.search.AlbumSearchBean;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import static com.imooc.imooc_voice.Constants.ALBUM;

public class AlbumSearchDelegate extends NeteaseSearchLoadingDelegate {


	@Override
	public void reloadSearchResult(final String keyword) {
		RequestCenter.getAlbumSearch(keyword, 10, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				AlbumSearchBean bean = (AlbumSearchBean) responseObj;
				List<AlbumSearchBean.ResultBean.AlbumsBean> albums = bean.getResult().getAlbums();
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
				mAdapter = new AlbumSearchAdapter(keyword, albums);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						AlbumSearchBean.ResultBean.AlbumsBean entity = (AlbumSearchBean.ResultBean.AlbumsBean) baseQuickAdapter.getItem(i);
						getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(ALBUM, entity.getId()));
					}
				});
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	public static class AlbumSearchAdapter extends BaseQuickAdapter<AlbumSearchBean.ResultBean.AlbumsBean, BaseViewHolder>{

		private String keywords;
		private ImageLoaderManager manager;

		public AlbumSearchAdapter(String keywords, @Nullable List<AlbumSearchBean.ResultBean.AlbumsBean> data) {
			super(R.layout.item_mine_gedan_content, data);
			this.keywords = keywords;
			manager = ImageLoaderManager.getInstance();
		}

		public AlbumSearchAdapter(@Nullable List<AlbumSearchBean.ResultBean.AlbumsBean> data) {
			super(R.layout.item_mine_gedan_content, data);
			this.keywords = "";
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, AlbumSearchBean.ResultBean.AlbumsBean item) {
			String publishTime = TimeUtil.getTimeStandardOnlyYMDWithDot(item.getPublishTime());
			List<AlbumSearchBean.ResultBean.AlbumsBean.ArtistsBean> artists = item.getArtists();
			int artistSize = artists.size();
			String artistName = "";
			if(artistSize != 1){
				for(int i = 0; i < artistSize; i++){
					if(i == artistSize-1){
						artistName += artists.get(i).getName();
					}else{
						artistName += artists.get(i).getName()+"\\";
					}
				}
			}else{
				if(item.getArtist() != null){
					artistName = item.getArtist().getName();
				}else{
					artistName = item.getArtists().get(0).getName();
				}
			}
			String bottomText = artistName + " " + publishTime;

			//显示图片右边的专辑特有的图片
			adapter.setVisible(R.id.iv_album_right_flag, true);

			adapter.setText(R.id.tv_item_gedan_content_toptext, SearchUtil.getMatchingKeywords(item.getName(),keywords));
			adapter.setText(R.id.tv_item_gedan_content_bottomtext, SearchUtil.getMatchingKeywords(bottomText,keywords));
			adapter.setVisible(R.id.iv_item_gedan_more, false);
			//专辑图片
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_gedan_content_img), item.getPicUrl());

		}
	}
}
