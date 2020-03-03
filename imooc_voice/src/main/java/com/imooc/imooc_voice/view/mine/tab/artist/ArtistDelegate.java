package com.imooc.imooc_voice.view.mine.tab.artist;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.ArtistJson;
import com.imooc.imooc_voice.model.info.ArtistInfo;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArtistDelegate extends NeteaseDelegate {


	private static final String TAG = "ArtistDelegate";

	@BindView(R2.id.loadframe)
	FrameLayout frameLayout;
	private View rootview;
	private RecyclerView recyclerView;
	private LinearLayoutManager linearLayoutManager;

	/**
	 * data
	 */
	private boolean isFirstLoad;
	private int currentMusicPosition = -1;
	private ArtistAdapter mAdapter;
	private ImageLoaderManager imageLoaderManager;

	@Override
	public Object setLayout() {
		return R.layout.delegate_music_load_framelayout;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		final View loadView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_normal_loading, frameLayout, false);
		ImageView anim1 = loadView.findViewById(R.id.anim_image2);
		ImageView anim2 = loadView.findViewById(R.id.anim_image);
		AnimationDrawable animationDrawable = (AnimationDrawable)anim1.getDrawable();
		AnimationDrawable animation2Drawable = (AnimationDrawable)anim2.getDrawable();
		animationDrawable.start();
		animation2Drawable.start();
		frameLayout.addView(loadView);
		imageLoaderManager = ImageLoaderManager.getInstance();

		//显示loading效果
		Netease.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				isFirstLoad = true;
				initView();
			}
		}, 100);
	}


	private void initView() {
		if(rootview == null){
			rootview = LayoutInflater.from(getContext()).inflate(R.layout.delegate_music_recyclerview, frameLayout, false);
			recyclerView = rootview.findViewById(R.id.recyclerview);
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
				if(isFirstLoad){
					frameLayout.removeAllViews();
					ViewGroup p = (ViewGroup) rootview.getParent();
					if (p != null) {
						p.removeAllViewsInLayout();
					}
					frameLayout.addView(rootview);
					isFirstLoad = false;
				}
			}

			@Override
			protected Void doInBackground(Void... voids) {
				ArrayList<ArtistInfo> artistList = (ArrayList) MusicUtils.queryArtist(getProxyActivity());
				mAdapter.addData(artistList);
				return null;
			}
		}.execute();

	}
	@Override
	public void post(Runnable runnable) {

	}

	class ArtistAdapter extends BaseQuickAdapter<ArtistInfo, BaseViewHolder>{

		ArtistAdapter(@Nullable List<ArtistInfo> data) {
			super(R.layout.item_tab_common, data);
		}


		@Override
		public void onBindViewHolder(BaseViewHolder holder, int positions) {
			super.onBindViewHolder(holder, positions);
		}

		@Override
		protected void convert(final BaseViewHolder helper, final ArtistInfo item) {
			((TextView)helper.getView(R.id.viewpager_list_toptext)).setText(item.artist_name);
			final ImageView albumView = helper.getView(R.id.iv_tab);
			final long tag = item.artist_id;
			if(albumView.getTag(R.id.image_loader_tag) == null || !albumView.getTag(R.id.image_loader_tag).toString().equals("set")){
				albumView.setTag(R.id.image_loader_tag, tag);
			}
			((TextView)helper.getView(R.id.viewpager_list_bottom_text)).setText(item.number_of_tracks+"首");

			//两个异步过程
			RequestCenter.queryAlbumPic(item.artist_name, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					if(albumView.getTag(R.id.image_loader_tag).toString().equals(String.valueOf(item.artist_id))){
						albumView.setTag(R.id.image_loader_tag, "set");
						String pic = ((ArtistJson)responseObj).getResult().getArtists()[0].getImg1v1Url();
						Log.e(TAG, item.artist_name + " pic: "+ pic +" tag: " + albumView.getTag(R.id.image_loader_tag).toString());
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
