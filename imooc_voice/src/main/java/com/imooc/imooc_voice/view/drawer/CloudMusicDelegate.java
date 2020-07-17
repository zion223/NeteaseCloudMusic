package com.imooc.imooc_voice.view.drawer;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.square.detail.PlayListAdapter;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.notification.UserCloudBean;
import com.imooc.lib_api.model.song.SongDetailBean;
import com.imooc.lib_api.model.song.SongUrlBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_api.model.song.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

//音乐云盘
public class CloudMusicDelegate extends NeteaseLoadingDelegate {

	private static final long GB = 1024 * 1024 * 1024;

	private TextView mTvStorageRoom;
	private RecyclerView mRecyclerView;
	private PlayListAdapter mAdapter;

	@Override
	public void initView() {
		mTvStorageRoom = rootView.findViewById(R.id.tv_user_cloud_size);
		mRecyclerView = rootView.findViewById(R.id.rv_cloud_music);
		ImageView mIvBack = rootView.findViewById(R.id.img_cloud_back);
		//返回按钮
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
				//云盘剩余空间和总空间
				float leftSize = (float) bean.getSize();
				mTvStorageRoom.setText(Math.round(leftSize * 100) / 100 + " G/ " + bean.getMaxSize() / GB + "G");
				//头布局
				View headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_music_header, null, false);
				((TextView) headerView.findViewById(R.id.play_all_number)).setText("(共" + bean.getCount() + "首)");
				//云盘歌曲
				ArrayList<UserCloudBean.CloudSong> data = bean.getData();
				ArrayList<SongDetailBean.SongsBean> songData = new ArrayList<>();
				for (int i = 0; i < data.size(); i++) {
					songData.add(data.get(i).getSimpleSong());
				}
				mAdapter = new PlayListAdapter(getContext(), CloudMusicDelegate.this, true, songData);
				mAdapter.setHeaderView(headerView);
				mAdapter.setOnItemClickListener((adapter, view, i) -> {
					SongDetailBean.SongsBean item = (SongDetailBean.SongsBean) adapter.getItem(i);
					RequestCenter.getSongUrl(item.getId(), new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							SongUrlBean url = (SongUrlBean) responseObj;
							String songPlayUrl = url.getData().get(0).getUrl();
							if(!TextUtils.isEmpty(songPlayUrl)){
								AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDt())));
							}else{
								Toast.makeText(getContext(), "获取播放地址失败", Toast.LENGTH_SHORT).show();
							}
						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});

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


}
