package com.imooc.imooc_voice.view.discory.song;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_api.HttpConstants;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.DailyRecommendBean;
import com.imooc.lib_api.model.NewSongBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import butterknife.BindView;

public class TopSongDelegate extends NeteaseLoadingDelegate {


	private static final String ARGS_SONGLIST_ID = "ARGS_SONGLIST_ID";

	@BindView(R2.id.iv_top_song_img_cover)
	ImageView mIvBackground;
	@BindView(R2.id.tv_top_song_all_play)
	TextView mTvPlayAll;
	@BindView(R2.id.tv_top_song_num)
	TextView mTvSongNum;

	private RecyclerView mRvTopSong;
	private TopSongAdapter mAdapter;
	// type 全部:0 华语:7  欧美:96 日本:8 韩国:16
	private int type;

	public static TopSongDelegate newInstance(int type) {
		final Bundle args = new Bundle();
		args.putInt(ARGS_SONGLIST_ID, type);
		final TopSongDelegate delegate = new TopSongDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			type = args.getInt(ARGS_SONGLIST_ID);
		}
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_top_song;
	}

	@Override
	public void initView() {
		setupBackgroundImg();

		mRvTopSong = rootView.findViewById(R.id.rv_gedan_detail_normal);
		RequestCenter.getTopSong(type, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				NewSongBean bean = (NewSongBean) responseObj;
				List<DailyRecommendBean.RecommendBean> songData = bean.getData();
				mTvSongNum.setText("(共" + songData.size() + "首)");
				mAdapter = new TopSongAdapter(getParentDelegate(), songData);
				//播放歌曲
				mAdapter.setOnItemClickListener((adapter, view, position) -> {
					DailyRecommendBean.RecommendBean item = (DailyRecommendBean.RecommendBean) adapter.getItem(position);
					String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
					AudioHelper.addAudio(new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getArtists().get(0).getName(), item.getAlbum().getName(), item.getAlbum().getName(), item.getAlbum().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDuration())));
				});
				mRvTopSong.setAdapter(mAdapter);
				mRvTopSong.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	private void setupBackgroundImg() {
		switch (type){
			case 0:
				mIvBackground.setImageResource(R.mipmap.top_recommend);
				break;
			case 7:
				mIvBackground.setImageResource(R.mipmap.top_china);
				break;
			case 96:
				mIvBackground.setImageResource(R.mipmap.top_europe);
				break;
			case 8:
				mIvBackground.setImageResource(R.mipmap.top_japan);
				break;
			case 16:
				mIvBackground.setImageResource(R.mipmap.top_korea);
				break;
			default:
				break;
		}
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_gedan_loading_view;
	}


	static class TopSongAdapter extends BaseQuickAdapter<DailyRecommendBean.RecommendBean, BaseViewHolder>{

		private NeteaseDelegate mDelegate;
		private ImageLoaderManager manager;

		TopSongAdapter(NeteaseDelegate delegate, @Nullable List<DailyRecommendBean.RecommendBean> data) {
			super(R.layout.item_top_song, data);
			this.mDelegate = delegate;
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(BaseViewHolder helper, DailyRecommendBean.RecommendBean item) {
			manager.displayImageForCorner(helper.getView(R.id.iv_song_img), item.getAlbum().getPicUrl());
			//歌曲名
			helper.setText(R.id.viewpager_list_toptext, item.getName());
			//歌手名 - 专辑名
			String artistName;
			if(item.getArtists().size() == 1){
				artistName = item.getArtists().get(0).getName();
			}else{
				artistName = item.getArtists().get(0).getName() + "/" + item.getArtists().get(1).getName();
			}
			helper.setText(R.id.viewpager_list_bottom_text, artistName + " - " + item.getAlbum().getName());
			//当前歌曲是否有MV
			if(item.getMvid() != 0){
				helper.setVisible(R.id.iv_list_video, true);
			}
			//当前歌曲的视频
			helper.setOnClickListener(R.id.iv_list_video, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					mDelegate.getSupportDelegate().start(MvDeatilDelegate.newInstance(String.valueOf(item.getMvid())));
				}
			});
			helper.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//showMoreDialog(item);
				}
			});
		}
	}
}
