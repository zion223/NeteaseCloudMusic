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
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.imooc_voice.view.home.search.artist.ArtistDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.search.SingerSearchBean;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class SingerSearchDelegate extends NeteaseSearchLoadingDelegate {


	@Override
	public void reloadSearchResult(final String keywords) {
			RequestCenter.getSingerSearch(keywords, 100, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					SingerSearchBean bean = (SingerSearchBean) responseObj;
					List<SingerSearchBean.ResultBean.ArtistsBean> artists = bean.getResult().getArtists();
					mAdapter = new SingerSearchAdapter(keywords, artists);
					mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
						@Override
						public void onItemClick(BaseQuickAdapter adapter, View view, int i) {
							SingerSearchBean.ResultBean.ArtistsBean entity = (SingerSearchBean.ResultBean.ArtistsBean) adapter.getItem(i);
							getParentDelegate().getSupportDelegate().start(ArtistDetailDelegate.newInstance(entity.getId()));
						}
					});
					mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
					mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
					mRecyclerView.setAdapter(mAdapter);
					addRootView();

				}

				@Override
				public void onFailure(Object reasonObj) {

				}
			});

	}


	public static class SingerSearchAdapter extends BaseQuickAdapter<SingerSearchBean.ResultBean.ArtistsBean, BaseViewHolder>{

		private String keywords;

		SingerSearchAdapter(String keyword,@Nullable List<SingerSearchBean.ResultBean.ArtistsBean> data) {
			super(R.layout.item_singer_normal, data);
			this.keywords = keyword;
		}

		public SingerSearchAdapter(@Nullable List<SingerSearchBean.ResultBean.ArtistsBean> data) {
			super(R.layout.item_singer_normal, data);
			this.keywords = "";
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, SingerSearchBean.ResultBean.ArtistsBean item) {

			adapter.setText(R.id.tv_singer_name, SearchUtil.getMatchingKeywords(item.getName(),keywords));
			if(item.getAlias() != null && item.getAlias().size() != 0){
				adapter.setText(R.id.tv_singer_alias, "("+SearchUtil.getMatchingKeywords(item.getAlias().get(0),keywords)+")");
			}
			ImageLoaderManager.getInstance().displayImageForCircle((ImageView) adapter.getView(R.id.iv_singer_avatar), item.getPicUrl());

		}
	}
}
