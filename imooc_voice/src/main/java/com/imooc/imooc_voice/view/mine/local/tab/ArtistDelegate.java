package com.imooc.imooc_voice.view.mine.local.tab;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.info.ArtistInfo;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.ArtistJson;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

public class ArtistDelegate extends NeteaseLoadingDelegate {

	private RecyclerView recyclerView;
	private LinearLayoutManager linearLayoutManager;

	/**
	 * data
	 */
	private int currentMusicPosition = -1;
	private ArtistAdapter mAdapter;
	private ImageLoaderManager imageLoaderManager;


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);
		imageLoaderManager = ImageLoaderManager.getInstance();
	}


	public void initView() {
		recyclerView = rootView.findViewById(R.id.recyclerview);
		linearLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		mAdapter = new ArtistAdapter(null);
		//添加头布局
		mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

//					final MusicInfo item = (MusicInfo) adapter.getItem(position);
//					assert item != null;
//					AudioController.getInstance().addAudio(new AudioBean(String.valueOf(item.songId), item.data, item.musicName, item.artist, item.albumName, item.albumData, item.albumData, String.valueOf(item.duration)));
//					//设置当前播放状态 取消上个播放状态
//					final ImageView playView = view.findViewById(R.id.play_state);
//					playView.setVisibility(View.VISIBLE);
//					if(currentMusicPosition != -1){
//						//mAdapter.notifyDataSetChanged();
//						mAdapter.notifyItemChanged(currentMusicPosition + 1);
//					}
				currentMusicPosition = position;
			}
		});
		recyclerView.setAdapter(mAdapter);
		reloadArtistList();

	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_music_recyclerview;
	}

	@SuppressLint("StaticFieldLeak")
	private void reloadArtistList() {
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {

			}

			@Override
			protected void onPostExecute(Void aVoid) {
				mAdapter.notifyDataSetChanged();
				addRootView();
			}

			@Override
			protected Void doInBackground(Void... voids) {
				ArrayList<ArtistInfo> artistList = (ArrayList) MusicUtils.queryArtist(getProxyActivity());
				mAdapter.addData(artistList);
				return null;
			}
		}.execute();

	}


	class ArtistAdapter extends BaseQuickAdapter<ArtistInfo, BaseViewHolder> {

		ArtistAdapter(@Nullable List<ArtistInfo> data) {
			super(R.layout.item_tab_common, data);
		}


		@Override
		public void onBindViewHolder(BaseViewHolder holder, int positions) {
			super.onBindViewHolder(holder, positions);
		}

		@SuppressLint("SetTextI18n")
		@Override
		protected void convert(final BaseViewHolder helper, final ArtistInfo item) {
			((TextView) helper.getView(R.id.viewpager_list_toptext)).setText(item.artist_name);
			final ImageView albumView = helper.getView(R.id.iv_tab);
			final long tag = item.artist_id;
			if (albumView.getTag(R.id.image_loader_tag) == null || !albumView.getTag(R.id.image_loader_tag).toString().equals("set")) {
				albumView.setTag(R.id.image_loader_tag, tag);
			}
			((TextView) helper.getView(R.id.viewpager_list_bottom_text)).setText(item.number_of_tracks + "首");

			//两个异步过程
			RequestCenter.queryAlbumPic(item.artist_name, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					if (albumView.getTag(R.id.image_loader_tag).toString().equals(String.valueOf(item.artist_id))) {
						albumView.setTag(R.id.image_loader_tag, "set");
						String pic = ((ArtistJson) responseObj).getResult().getArtists()[0].getImg1v1Url();
						Log.e(TAG, item.artist_name + " pic: " + pic + " tag: " + albumView.getTag(R.id.image_loader_tag).toString());
						imageLoaderManager.displayImageForCircle(albumView, pic);
					}
				}

				@Override
				public void onFailure(Object reasonObj) {
					imageLoaderManager.displayImageForCircle(albumView, "");
				}
			});

		}
	}
}
