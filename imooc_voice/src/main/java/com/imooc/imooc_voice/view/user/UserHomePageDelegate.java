package com.imooc.imooc_voice.view.user;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.UserPlaylistEntity;
import com.imooc.lib_api.model.personal.UserDetailBean;
import com.imooc.lib_api.model.personal.UserPlaylistBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static com.imooc.imooc_voice.Constants.PLAYLIST;


public class UserHomePageDelegate extends NeteaseDelegate {

	private static final String ARGS_USER_DETAIL = "ARGS_USER_DETAIL";

	@BindView(R2.id.tv_user_detail_createtime)
	TextView mTvCreateTime;
	@BindView(R2.id.tv_user_detail_age)
	TextView mTvAge;
	@BindView(R2.id.tv_user_detail_area)
	TextView mTvArea;
	@BindView(R2.id.tv_user_info_toptext)
	TextView mTvListenRankTitle;
	@BindView(R2.id.tv_user_info_bottomtext)
	TextView mTvListenRankCount;
	@BindView(R2.id.tv_user_info_toplike)
	TextView mTvLikeMusicTitle;
	@BindView(R2.id.tv_user_info_bottomlike)
	TextView mTvLikeMusicInfo;
	@BindView(R2.id.iv_user_info_like)
	ImageView mIvLikeImg;
	@BindView(R2.id.rv_user_info_playlist)
	RecyclerView mRvUserPlaylist;

	private UserDetailBean mCurrentUser;
	private ImageLoaderManager manager;
	private UserHomePagePlayListAdapter mPlayListAdapter;

	private ArrayList<UserPlaylistEntity> playlistEntities = new ArrayList<>();

	//喜欢的音乐 歌单ID
	private long likeMusicId;

	private final int TYPE_CREATE = 0;
	private final int TYPE_SUBSCRIBE = 1;

	public static UserHomePageDelegate newInstance(UserDetailBean bean) {
		final Bundle args = new Bundle();
		args.putSerializable(ARGS_USER_DETAIL, bean);
		final UserHomePageDelegate delegate = new UserHomePageDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			mCurrentUser = (UserDetailBean) args.getSerializable(ARGS_USER_DETAIL);
		}
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_user_info;
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		//基本信息
		String createTime = TimeUtil.getTimeStandardOnlyYMD(mCurrentUser.getCreateTime());
		mTvCreateTime.setText("村龄: " + createTime + "注册");
		mTvAge.setText("年龄：出生日期" + TimeUtil.getTimeStandardOnlyYMD(mCurrentUser.getProfile().getBirthday()));
		mTvArea.setText("地区：地区码" + mCurrentUser.getProfile().getProvince() + " " + mCurrentUser.getProfile().getCity());
		//听歌排行
		mTvListenRankTitle.setText(mCurrentUser.getProfile().getNickname() + "的听歌排行");
		mTvListenRankCount.setText("累计听歌" + mCurrentUser.getListenSongs() + "首");
		mTvLikeMusicTitle.setText(mCurrentUser.getProfile().getNickname() + "喜欢的音乐");

		RequestCenter.getUserPlaylist(mCurrentUser.getProfile().getUserId(), new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				UserPlaylistBean bean = (UserPlaylistBean) responseObj;
				//喜欢的音乐  第一位数据
				UserPlaylistBean.PlaylistBean likeBean = bean.getPlaylist().get(0);
				mTvLikeMusicInfo.setText(likeBean.getTrackCount() + "首,  播放" + SearchUtil.getCorresPondingString(likeBean.getPlayCount()) + "次");
				manager.displayImageForCorner(mIvLikeImg, likeBean.getCoverImgUrl(), 5);
				likeMusicId = likeBean.getId();
				//创建的歌单  收藏的歌单
				int size = bean.getPlaylist().size();
				//创建和收藏歌单的分界
				int subIndex = 0;
				for (int i = 0; i < size; i++) {
					if(bean.getPlaylist().get(i).getCreator().getUserId() != mCurrentUser.getProfile().getUserId()){
						subIndex = i;
						break;
					}
				}
				//创建的歌单数量
				int createPlaylistSize = subIndex -1 ;
				playlistEntities.add(new UserPlaylistEntity("(" +createPlaylistSize +")", "更多歌单", bean.getPlaylist().subList(1, 4)));
				//收藏的歌单的数量
				int collectPlayListSize = size - subIndex;
				playlistEntities.add(new UserPlaylistEntity("(" +collectPlayListSize +")", "更多歌单", bean.getPlaylist().subList(subIndex, subIndex + 3)));

				mPlayListAdapter = new UserHomePagePlayListAdapter(playlistEntities, getContext());
				//子布局点击事件 歌单详情
				mPlayListAdapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
					@Override
					public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition, int childPosition) {
						UserPlaylistBean.PlaylistBean entity = playlistEntities.get(groupPosition).getPlaylist().get(childPosition);
						getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, entity.getId()));
					}
				});
				//更多歌单
				mPlayListAdapter.setOnFooterClickListener(new GroupedRecyclerViewAdapter.OnFooterClickListener() {
					@Override
					public void onFooterClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition) {
						if(groupPosition == TYPE_CREATE){
							//创建的歌单
						}else if(groupPosition ==TYPE_SUBSCRIBE){
							//收藏的歌单

						}
					}
				});
				mRvUserPlaylist.setAdapter(mPlayListAdapter);
				mRvUserPlaylist.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		//创建的电台   Mlog

	}


	//喜欢的音乐歌单
	@OnClick(R2.id.rl_user_info_likemusic)
	void onClickLikeMusicPlaylist(){
		getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, likeMusicId));
	}


	class UserHomePagePlayListAdapter extends GroupedRecyclerViewAdapter {

		private ArrayList<UserPlaylistEntity> mData;


		UserHomePagePlayListAdapter(ArrayList<UserPlaylistEntity> entities, Context context) {
			super(context);
			this.mData = entities;
		}


		@Override
		public int getGroupCount() {
			return mData.size();
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return mData.get(groupPosition).getPlaylist().size();
		}

		@Override
		public boolean hasHeader(int groupPosition) {
			return true;
		}

		@Override
		public boolean hasFooter(int groupPosition) {
			return true;
		}

		@Override
		public int getHeaderLayout(int viewType) {
			return R.layout.item_user_info_playlist_header;
		}

		@Override
		public int getFooterLayout(int viewType) {
			return R.layout.item_more_info;
		}

		@Override
		public int getChildLayout(int viewType) {
			return R.layout.item_mine_gedan_content;
		}

		@Override
		public void onBindHeaderViewHolder(BaseViewHolder holder, int groupPosition) {
			holder.setText(R.id.tv_user_info_create_right, mData.get(groupPosition).getHeader());
			if(groupPosition == TYPE_CREATE){
				holder.setText(R.id.tv_user_info_create_left, "创建的歌单");
			}else{
				holder.setText(R.id.tv_user_info_create_left, "收藏的歌单");
			}
		}

		@Override
		public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {
			holder.setText(R.id.tv_more_info, mData.get(groupPosition).getFooter());
		}

		@Override
		public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
			holder.setVisible(R.id.iv_item_gedan_more, false);

			UserPlaylistBean.PlaylistBean item = mData.get(groupPosition).getPlaylist().get(childPosition);
			//歌单名
			holder.setText(R.id.tv_item_gedan_content_toptext, item.getName());
			//歌单图片
			manager.displayImageForCorner((ImageView) holder.get(R.id.iv_item_gedan_content_img), item.getCoverImgUrl());
			if(groupPosition == TYPE_SUBSCRIBE){
				holder.setText(R.id.tv_item_gedan_content_bottomtext, item.getTrackCount() + "首,  by "+ item.getCreator().getNickname() +"  播放" + SearchUtil.getCorresPondingString(item.getPlayCount()) + "次");
			}else if(groupPosition == TYPE_CREATE){
				holder.setText(R.id.tv_item_gedan_content_bottomtext, item.getTrackCount() + "首,  播放" + SearchUtil.getCorresPondingString(item.getPlayCount()) + "次");

			}
		}
	}


}
