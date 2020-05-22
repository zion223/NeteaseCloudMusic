package com.imooc.imooc_voice.view.mine.local.tab;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.info.MusicInfo;
import com.imooc.imooc_voice.util.IConstants;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;

import java.util.ArrayList;
import java.util.List;

public class MusicDelegate extends NeteaseLoadingDelegate {

	private static final String TAG = "MusicDelegate";
	/**
	 * ui
	 */
	private View headerView;
	private RecyclerView recyclerView;
	private LinearLayoutManager linearLayoutManager;
	private MusicAdapter mAdapter;

	/**
	 * data  TODO 持久化存储  重新进入界面后 currentMusicPosition 重置
	 */
	private int currentMusicPosition = -1;


	@SuppressLint("SetTextI18n")
	public void initView() {

		recyclerView = rootView.findViewById(R.id.recyclerview);
		linearLayoutManager = new LinearLayoutManager(getContext());

		ArrayList<MusicInfo> songList = (ArrayList) MusicUtils.queryMusic(getProxyActivity(), IConstants.START_FROM_LOCAL);
		mAdapter = new MusicAdapter(songList);
		headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_music_header, null, false);
		((TextView) headerView.findViewById(R.id.play_all_number)).setText("(共" + songList.size() + "首)");
		//添加头布局
		mAdapter.setHeaderView(headerView);
		mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

				final MusicInfo item = (MusicInfo) adapter.getItem(position);
				assert item != null;
				AudioHelper.addAudio(new AudioBean(String.valueOf(item.songId), item.data,
						item.musicName, item.artist, item.albumName, item.albumData, item.albumData, TimeUtil.getTimeNoYMDH(Long.parseLong(String.valueOf(item.duration)))));
				//设置当前播放状态 取消上个播放状态
				final ImageView playView = view.findViewById(R.id.play_state);
				playView.setVisibility(View.VISIBLE);
				if (currentMusicPosition != -1) {
					mAdapter.notifyItemChanged(currentMusicPosition + 1);
				}
				currentMusicPosition = position;
			}
		});
		recyclerView.setAdapter(mAdapter);
		recyclerView.setLayoutManager(linearLayoutManager);
		addRootView();
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_music_recyclerview;
	}


	static class MusicAdapter extends BaseQuickAdapter<MusicInfo, BaseViewHolder> {

		MusicAdapter(@Nullable List<MusicInfo> data) {
			super(R.layout.item_music_common, data);
		}

		@Override
		protected void convert(BaseViewHolder helper, final MusicInfo item) {
			//歌曲名
			helper.setText(R.id.viewpager_list_toptext, item.musicName);
			helper.setText(R.id.viewpager_list_bottom_text, item.artist + " - " + item.albumName);
			final ImageView listView = helper.getView(R.id.viewpager_list_button);
			listView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//弹出菜单
				}
			});
			//播放状态
			helper.setVisible(R.id.play_state, false);
			if(AudioController.getInstance().getNowPlaying() != null && AudioController.getInstance().getNowPlaying().getName().equals(item.musicName)){
				helper.setVisible(R.id.play_state, true);
			}else{
				helper.setVisible(R.id.play_state, false);
			}
		}

	}
}
