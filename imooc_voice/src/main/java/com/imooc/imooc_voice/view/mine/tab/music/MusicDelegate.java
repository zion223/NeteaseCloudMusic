package com.imooc.imooc_voice.view.mine.tab.music;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.info.MusicInfo;
import com.imooc.imooc_voice.util.IConstants;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MusicDelegate extends NeteaseDelegate {

	private static final String TAG = "MusicDelegate";
	/**
	 * ui
	 */
	@BindView(R2.id.loadframe)
	FrameLayout frameLayout;
	private View rootview;
	private View headerView;
	private RecyclerView recyclerView;
	private LinearLayoutManager linearLayoutManager;
	private MusicAdapter mAdapter;

	/**
	 * data
	 */
	private boolean isFirstLoad;
	private int currentMusicPosition = -1;

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
			mAdapter = new MusicAdapter(null);
			headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_music_header, null);
			//添加头布局
			mAdapter.setHeaderView(headerView);
			mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
				@Override
				public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

					final MusicInfo item = (MusicInfo) adapter.getItem(position);
					assert item != null;
					AudioController.getInstance().addAudio(new AudioBean(String.valueOf(item.songId), item.data, item.musicName, item.artist, item.albumName, item.albumData, item.albumData, String.valueOf(item.duration)));
					//设置当前播放状态 取消上个播放状态
					final ImageView playView = view.findViewById(R.id.play_state);
					playView.setVisibility(View.VISIBLE);
					if(currentMusicPosition != -1){
						//mAdapter.notifyDataSetChanged();
						mAdapter.notifyItemChanged(currentMusicPosition + 1);
					}
					currentMusicPosition = position;
				}
			});
			recyclerView.setAdapter(mAdapter);
			reloadMusicList();
		}
	}

	//加载歌曲列表
	@SuppressLint("StaticFieldLeak")
	private void reloadMusicList() {
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
				ArrayList<MusicInfo> songList = (ArrayList) MusicUtils.queryMusic(getProxyActivity(), IConstants.START_FROM_LOCAL);
				mAdapter.addData(songList);
				return null;
			}
		}.execute();

	}

	@Override
	public void post(Runnable runnable) {
	}


	class MusicAdapter extends BaseQuickAdapter<MusicInfo, BaseViewHolder> {

		MusicAdapter(@Nullable List<MusicInfo> data) {
			super(R.layout.item_music_common, data);
		}

		@Override
		protected void convert(BaseViewHolder helper, final MusicInfo item) {
			//歌曲名
			helper.setText(R.id.viewpager_list_toptext, item.musicName);
			helper.setText(R.id.viewpager_list_bottom_text, item.artist);
			final ImageView listView = helper.getView(R.id.viewpager_list_button);
			listView.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					//弹出菜单
					new MusicMoreDialog(getContext(), item).show();
				}
			});
			final ImageView playView = helper.getView(R.id.play_state);

			//当前音乐是正在播放的音乐
			if(AudioController.getInstance().getNowPlaying().getName().equals(item.musicName)){
				playView.setVisibility(View.VISIBLE);
			}else{
				playView.setVisibility(View.GONE);
			}

		}

	}
}
