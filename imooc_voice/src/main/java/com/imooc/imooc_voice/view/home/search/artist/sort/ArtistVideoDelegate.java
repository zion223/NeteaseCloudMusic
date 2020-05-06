package com.imooc.imooc_voice.view.home.search.artist.sort;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.event.ArtistIdEvent;
import com.imooc.imooc_voice.model.newapi.search.SingerVideoSearchBean;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import static com.imooc.imooc_voice.Constants.ALBUM;


/**
 * 歌手视频
 */
public class ArtistVideoDelegate extends NeteaseLoadingDelegate {

	private RecyclerView mRecyclerView;
	private String artistId;
	private ArtistVideoAdapter mAdapter;

	@Override
	public void initView() {
		if (TextUtils.isEmpty(artistId)) {
			artistId = SharePreferenceUtil.getInstance(getContext()).getCurrentArtistId();
		}
		//歌手的视频 TODO 歌手的MV
		RequestCenter.getSingerVideo(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				SingerVideoSearchBean bean = (SingerVideoSearchBean) responseObj;
				List<SingerVideoSearchBean.Mvs> mvs = bean.getMvs();
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
				mAdapter = new ArtistVideoAdapter(mvs);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int i) {
						SingerVideoSearchBean.Mvs entity = (SingerVideoSearchBean.Mvs) adapter.getItem(i);
						getParentDelegate().getSupportDelegate().start(MvDeatilDelegate.newInstance(entity.getId()));
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

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
	public void onGetArtistIdEvent(ArtistIdEvent event) {
		artistId = event.getId();

	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}

	static class ArtistVideoAdapter extends BaseQuickAdapter<SingerVideoSearchBean.Mvs, BaseViewHolder> {


		ArtistVideoAdapter(@Nullable List<SingerVideoSearchBean.Mvs> data) {
			super(R.layout.item_video_normal, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, SingerVideoSearchBean.Mvs item) {


			//设置播放次数
			adapter.setText(R.id.tv_item_video_playnum, SearchUtil.getCorresPondingString(item.getPlayCount()));
			//视频标题
			adapter.setText(R.id.tv_item_video_name, item.getName());
			//视频描述

			adapter.setText(R.id.tv_item_video_creator, item.getPublishTime());
			ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.getView(R.id.iv_item_video_cover), item.getImgurl());


		}
	}
}
