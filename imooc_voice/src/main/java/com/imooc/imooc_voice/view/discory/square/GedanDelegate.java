package com.imooc.imooc_voice.view.discory.square;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.RecommendPlayListBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import static com.imooc.lib_common_ui.utils.Constants.PLAYLIST;

public class GedanDelegate extends NeteaseLoadingDelegate {

	private static final String ARGS_GEDAN_TAG = "ARGS_GEDAN_TAG";
	private String tag;



	RecyclerView mRecyclerViewGedan;

	private GedanAdapter mAdapter;

	//每行加载3个
	private static final int INIT_LOAD_LINE = 3;
	//总共加载30行
	private static final int TOTAL_LOAD_LINE = 20;

	static GedanDelegate newInstance(String tag){
		final Bundle args = new Bundle();
		args.putString(ARGS_GEDAN_TAG, tag);
		final GedanDelegate delegate = new GedanDelegate();
		delegate.setArguments(args);
		return delegate;
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			tag = args.getString(ARGS_GEDAN_TAG);
		}
	}

	@Override
	public void initView() {
		mRecyclerViewGedan = rootView.findViewById(R.id.rv_delegate_normal);
		final GridLayoutManager manager = new GridLayoutManager(getContext(), INIT_LOAD_LINE);
		initGedanView(manager);
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}


	@SuppressLint("StaticFieldLeak")
	private void initGedanView(final GridLayoutManager manager) {
		new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected Boolean doInBackground(Void... voids) {
				RequestCenter.getPlayList(tag, INIT_LOAD_LINE * TOTAL_LOAD_LINE, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						RecommendPlayListBean bean = (RecommendPlayListBean) responseObj;
						List<RecommendPlayListBean.PlaylistsBean> playlists = bean.getPlaylists();
						mAdapter = new GedanAdapter(playlists);
						mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
							@Override
							public void onItemClick(BaseQuickAdapter adapter, View view, int i) {
								RecommendPlayListBean.PlaylistsBean entity = (RecommendPlayListBean.PlaylistsBean) adapter.getItem(i);
								getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, entity.getId()));
							}
						});
						mRecyclerViewGedan.setAdapter(mAdapter);
						mRecyclerViewGedan.setLayoutManager(manager);
						addRootView();
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
				return null;
			}

			@Override
			protected void onPostExecute(Boolean aBoolean) {
				super.onPostExecute(aBoolean);

			}
		}.execute();


	}



	static class GedanAdapter extends BaseQuickAdapter<RecommendPlayListBean.PlaylistsBean, BaseViewHolder>{
		private ImageLoaderManager manager;

		GedanAdapter(@Nullable List<RecommendPlayListBean.PlaylistsBean> data) {
			super(R.layout.item_discover_gedan, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder helper, RecommendPlayListBean.PlaylistsBean item) {
			final ImageView geDanView = helper.getView(R.id.iv_item_discover);
			//显示圆角图片
			manager.displayImageForCorner(geDanView, item.getCoverImgUrl(), 5);
			int playCount = item.getPlayCount();
			//播放数量
			helper.setText(R.id.tv_item_discover_playnum, SearchUtil.getCorresPondingString(playCount));
			helper.setText(R.id.tv_item_discover_des, item.getName());
		}
	}
}
