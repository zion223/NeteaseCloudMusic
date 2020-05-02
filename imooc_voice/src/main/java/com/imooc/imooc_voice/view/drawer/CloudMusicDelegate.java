package com.imooc.imooc_voice.view.drawer;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.notification.UserCloudBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//音乐云盘
public class CloudMusicDelegate extends NeteaseLoadingDelegate {

	private static final long GB = 1024 * 1024 * 1024;

	private TextView mTvStorageRoom;
	private ImageView mIvBack;
	private RecyclerView mRecyclerView;
	private CloudMusicAdapter mAdapter;

	@Override
	public void initView() {
		mTvStorageRoom = rootView.findViewById(R.id.tv_user_cloud_size);
		mRecyclerView = rootView.findViewById(R.id.rv_cloud_music);
		mIvBack = rootView.findViewById(R.id.img_cloud_back);
		//返回
		mIvBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getSupportDelegate().pop();
			}
		});
		RequestCenter.getUserCloud(new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				UserCloudBean bean = (UserCloudBean) responseObj;
				//云盘空间
				mTvStorageRoom.setText(new DecimalFormat("#.00").format((float)bean.getSize()/GB)  + " G/ " + bean.getMaxSize()/GB + "G");
				View headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_music_header, null, false);
				((TextView)headerView.findViewById(R.id.play_all_number)).setText("(共" + bean.getCount() +"首)");
				//云盘歌曲
				ArrayList<UserCloudBean.CloudSong> data = bean.getData();
				mAdapter = new CloudMusicAdapter(data);
				mAdapter.setHeaderView(headerView);
				mAdapter.setOnItemClickListener((adapter, view, i) -> {
					//TODO 加入播放队列
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
		return R.layout.delegate_user_cloud;
	}

	static class CloudMusicAdapter extends BaseQuickAdapter<UserCloudBean.CloudSong, BaseViewHolder>{

		CloudMusicAdapter(@Nullable List<UserCloudBean.CloudSong> data) {
			super(R.layout.item_gedan_detail_song, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder helper, UserCloudBean.CloudSong item) {
			//排序
			helper.setText(R.id.item_play_no, String.valueOf(helper.getLayoutPosition()));
			//歌曲名
			helper.setText(R.id.viewpager_list_toptext, item.getSimpleSong().getName());
			//歌手名 - 专辑名
			helper.setText(R.id.viewpager_list_bottom_text, item.getSimpleSong().getAr().get(0).getName() + "-" + item.getAlbum());
			helper.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
		}
	}
}
