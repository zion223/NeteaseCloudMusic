package com.imooc.lib_audio.mediaplayer.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.CommonMessageBean;
import com.imooc.lib_api.model.personal.UserPlaylistBean;
import com.imooc.lib_audio.R;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.lxj.xpopup.core.CenterPopupView;

import java.util.List;

//收藏音乐到创建的歌单
public class MusicCollectDialog extends CenterPopupView {

	private Context mContext;
	//歌曲ID 从外部传入
	private String mTracks;
	private RecyclerView mRecyclerView;
	private PlayListAdapter mAdapter;

	public MusicCollectDialog(@NonNull Context context, String trackId) {
		super(context);
		this.mContext = context;
		this.mTracks = trackId;
	}

	@Override
	protected void onCreate() {
		super.onCreate();
		mRecyclerView = findViewById(R.id.recycler_playlist);
		//获取当前用户ID
		final int userId = SharePreferenceUtil.getInstance(mContext).getUserId();

		RequestCenter.getUserPlaylist(userId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				UserPlaylistBean bean = (UserPlaylistBean) responseObj;
				List<UserPlaylistBean.PlaylistBean> playlist = bean.getPlaylist();
				int subIndex = 0;
				for (int i = 0; i < playlist.size(); i++) {
					if (playlist.get(i).getCreator().getUserId() != userId) {
						subIndex = i;
						break;
					}
				}
				//用户创建的歌单列表
				List<UserPlaylistBean.PlaylistBean> createPlayList = playlist.subList(0, subIndex);
				mAdapter = new PlayListAdapter(createPlayList);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						UserPlaylistBean.PlaylistBean entity = (UserPlaylistBean.PlaylistBean) adapter.getItem(position);
						//歌单ID
						long playlistId = entity.getId();

						RequestCenter.trackPlayList(true, playlistId, mTracks, new DisposeDataListener() {
							@Override
							public void onSuccess(Object responseObj) {
								CommonMessageBean bean = (CommonMessageBean) responseObj;
								if(bean.getCode() == 200){
									Toast.makeText(getContext(), "收藏成功", Toast.LENGTH_SHORT).show();
								}else{
									Toast.makeText(getContext(), "收藏失败或不支持收藏本地歌曲: " + bean.getMsg(), Toast.LENGTH_SHORT).show();
								}
								dismiss();
							}

							@Override
							public void onFailure(Object reasonObj) {

							}
						});
					}
				});
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	protected int getImplLayoutId() {
		return R.layout.dialog_collect_music;
	}


	static class PlayListAdapter extends BaseQuickAdapter<UserPlaylistBean.PlaylistBean, BaseViewHolder>{

		PlayListAdapter(@Nullable List<UserPlaylistBean.PlaylistBean> data) {
			super(R.layout.dialog_collect_music_item, data);
		}

		@Override
		protected void convert(BaseViewHolder helper, UserPlaylistBean.PlaylistBean item) {
			helper.setText(R.id.tv_item_collect_content_toptext, item.getName());
			helper.setText(R.id.tv_item_collect_content_bottomtext, item.getTrackCount() + "首");
			ImageLoaderManager.getInstance().displayImageForCorner((ImageView) helper.getView(R.id.iv_item_collect_content_img), item.getCoverImgUrl(), 5);
		}
	}
}
