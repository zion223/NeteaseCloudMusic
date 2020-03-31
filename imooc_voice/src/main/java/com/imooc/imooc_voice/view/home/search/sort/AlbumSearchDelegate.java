package com.imooc.imooc_voice.view.home.search.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.search.AlbumSearchBean;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class AlbumSearchDelegate extends NeteaseSearchLoadingDelegate {


	@Override
	public void reloadSearchResult(String keyword) {
		RequestCenter.getAlbumSearch(keyword, 10, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				AlbumSearchBean bean = (AlbumSearchBean) responseObj;
				List<AlbumSearchBean.ResultBean.AlbumsBean> albums = bean.getResult().getAlbums();
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
				//mAdapter = new AlbumSearchAdapter()
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	static class AlbumSearchAdapter extends BaseQuickAdapter<AlbumSearchBean.ResultBean.AlbumsBean, BaseViewHolder>{

		AlbumSearchAdapter(int layoutResId, @Nullable List<AlbumSearchBean.ResultBean.AlbumsBean> data) {
			super(layoutResId, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, AlbumSearchBean.ResultBean.AlbumsBean item) {
			String publishTime = TimeUtil.getTimeStandardOnlyYMDWithDot(item.getPublishTime());
			List<AlbumSearchBean.ResultBean.AlbumsBean.ArtistsBean> artists = item.getArtists();
			int artistSize = artists.size();
			String artistName = "";
			if(artistSize != 1){
				for(int i = 0; i < artistSize; i++){
					if(i ==artistSize-1){
						artistName += artists.get(i).getName();
					}else{
						artistName += artists.get(i).getName()+"\\";
					}
				}
			}else{
				artistName = item.getArtist().getName();
			}
			item.getBlurPicUrl();
		}
	}
}
