package com.imooc.imooc_voice.view.mine.collect;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.home.search.artist.ArtistDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.artist.ArtistSublistBean;
import com.imooc.lib_api.model.search.SingerSearchBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class ArtistCollectDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;
	private ArtistCollectAdapter mAdapter;

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);

		RequestCenter.getArtistSublist(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				ArtistSublistBean bean = (ArtistSublistBean) responseObj;
				List<SingerSearchBean.ResultBean.ArtistsBean> data = bean.getData();
				mAdapter = new ArtistCollectAdapter(data);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						SingerSearchBean.ResultBean.ArtistsBean entity = (SingerSearchBean.ResultBean.ArtistsBean) adapter.getItem(position);
						getParentDelegate().getSupportDelegate().start(ArtistDetailDelegate.newInstance(entity.getId()));
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


	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}

	static class ArtistCollectAdapter extends BaseQuickAdapter<SingerSearchBean.ResultBean.ArtistsBean, BaseViewHolder>{
		private final ImageLoaderManager manager;

		ArtistCollectAdapter(@Nullable List<SingerSearchBean.ResultBean.ArtistsBean> data) {
			super(R.layout.item_singer_collect, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(BaseViewHolder helper, SingerSearchBean.ResultBean.ArtistsBean item) {
			//头像
			manager.displayImageForCircle(helper.getView(R.id.iv_singer_avatar), item.getPicUrl());

			helper.setText(R.id.tv_item_singer_toptext, item.getName());
			String bottomText = "";
			if(item.getAlbumSize() != 0){
				bottomText = "专辑: " + item.getAlbumSize();
			}
			if(item.getMvSize() != 0){
				bottomText = bottomText + " MV: " + item.getMvSize();
			}

			helper.setText(R.id.tv_item_singer_bottomtext, bottomText);
		}
	}
}
