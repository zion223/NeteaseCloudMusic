package com.imooc.imooc_voice.view.mine.collect;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.AlbumSublistBean;
import com.imooc.imooc_voice.model.newapi.search.AlbumSearchBean;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import static com.imooc.imooc_voice.Constants.ALBUM;

//收藏的专辑
public class AlbumCollectDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;
	private AlbumCollectAdapter mAdapter;

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);

		RequestCenter.getAlbumSublist(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				AlbumSublistBean bean  = (AlbumSublistBean) responseObj;
				List<AlbumSearchBean.ResultBean.AlbumsBean> data = bean.getData();
				mAdapter = new AlbumCollectAdapter(data);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						AlbumSearchBean.ResultBean.AlbumsBean entity = (AlbumSearchBean.ResultBean.AlbumsBean) adapter.getItem(position);
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

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}

	static class AlbumCollectAdapter extends BaseQuickAdapter<AlbumSearchBean.ResultBean.AlbumsBean, BaseViewHolder> {

		private ImageLoaderManager manager;


		AlbumCollectAdapter(@Nullable List<AlbumSearchBean.ResultBean.AlbumsBean> data) {
			super(R.layout.item_mine_gedan_content, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, AlbumSearchBean.ResultBean.AlbumsBean item) {
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

			//显示图片右边的专辑特有的图片
			adapter.setVisible(R.id.iv_album_right_flag, true);

			adapter.setText(R.id.tv_item_gedan_content_toptext, item.getName());
			adapter.setText(R.id.tv_item_gedan_content_bottomtext, artistName + "  " + item.getSize() + "首");
			adapter.setVisible(R.id.iv_item_gedan_more, true);
			//专辑图片
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_gedan_content_img), item.getPicUrl());

		}
	}
}
