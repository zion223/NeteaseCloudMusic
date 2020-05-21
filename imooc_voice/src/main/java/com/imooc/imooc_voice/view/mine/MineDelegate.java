package com.imooc.imooc_voice.view.mine;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
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
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.info.MusicInfo;
import com.imooc.imooc_voice.model.mine.SpecData;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.IConstants;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.mine.collect.MineCollectTabDelegate;
import com.imooc.imooc_voice.view.mine.local.LocalMusicDelegate;
import com.imooc.imooc_voice.view.mine.radio.MineRadioDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.LoginBean;
import com.imooc.lib_api.model.SubCountBean;
import com.imooc.lib_api.model.personal.UserPlayListGroupEntity;
import com.imooc.lib_api.model.personal.UserPlaylistBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.dialog.CreatePlayListDialog;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.imooc.imooc_voice.Constants.PLAYLIST;

public class MineDelegate extends NeteaseDelegate {


	@BindView(R2.id.fragment_main_item_title)
	TextView mTvLocalMusic;
	@BindView(R2.id.rv_spec_mine)
	RecyclerView mSpecRecyclerView;
	@BindView(R2.id.rv_mine_create_gedan)
	RecyclerView mRvPlayList;
	@BindView(R2.id.fragment_main_item_radio_count)
	TextView mTvRadioCount;
	@BindView(R2.id.fragment_main_item_localmusic_count)
	TextView mTvLocalMusicCount;

	private SpecAdapter mSpecAdapter;

	private ImageLoaderManager manager;

	//歌单
	ArrayList<UserPlayListGroupEntity> playListEntities = new ArrayList<>();

	@Override
	public Object setLayout() {
		return R.layout.delegate_mine;
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		initSpecIcon();
		manager = ImageLoaderManager.getInstance();

		final int userId = SharePreferenceUtil.getInstance(getContext()).getUserId();

		//本地音乐数量
		int localMusicCount = SharePreferenceUtil.getInstance(getContext()).getLocalMusicCount();
		if (SharePreferenceUtil.getInstance(getContext()).getLocalMusicCount() == 0) {
			ArrayList<MusicInfo> songList = (ArrayList) MusicUtils.queryMusic(getProxyActivity(), IConstants.START_FROM_LOCAL);
			SharePreferenceUtil.getInstance(getContext()).saveLocalMusicCount(songList.size());
			mTvLocalMusicCount.setText("(" + songList.size() + ")");
		} else {
			mTvLocalMusicCount.setText("(" + localMusicCount + ")");
		}

		//TODO 最近播放数量

		//下载管理


		//用户创建的歌单 和收藏的歌单
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
				playListEntities.add(new UserPlayListGroupEntity(true, "创建的歌单", subIndex, playlist.subList(0, subIndex)));
				playListEntities.add(new UserPlayListGroupEntity(true, "收藏的歌单", playlist.size() - subIndex, playlist.subList(subIndex, playlist.size())));

				final MultipleGroupPlaylistAdapter mPlayListAdapter = new MultipleGroupPlaylistAdapter(playListEntities, getContext());
				mPlayListAdapter.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
					@Override
					public void onHeaderClick(GroupedRecyclerViewAdapter adapter, com.donkingliang.groupedadapter.holder.BaseViewHolder holder, int groupPosition) {
						changePlayListVisibleStatus(adapter, holder, groupPosition);
					}
				});
				//查看歌单详情
				mPlayListAdapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
					@Override
					public void onChildClick(GroupedRecyclerViewAdapter adapter, com.donkingliang.groupedadapter.holder.BaseViewHolder holder, int groupPosition, int childPosition) {
						getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, playListEntities.get(groupPosition).getBean().get(childPosition).getId()));
					}
				});

				mRvPlayList.setAdapter(mPlayListAdapter);
				mRvPlayList.setLayoutManager(new LinearLayoutManager(getContext()) {
					@Override
					public boolean canScrollVertically() {
						return false;
					}
				});
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

		/*
		 * 获取用户信息
		 */
		RequestCenter.getsubCount(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SubCountBean bean = (SubCountBean) responseObj;
				//我的电台 数量
				mTvRadioCount.setText("(" + bean.getDjRadioCount() + ")");

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

		//我的收藏数量
	}

	/**
	 * 改变歌单的显示状态
	 */
	private void changePlayListVisibleStatus(GroupedRecyclerViewAdapter adapter, com.donkingliang.groupedadapter.holder.BaseViewHolder holder, int groupPosition) {
		//点击到header则执行 隐藏或显示动作 否则就进入歌单详情
		ImageView changeView = holder.get(R.id.iv_mine_gedan_state);
		//是创建的还是收藏的
		MultipleGroupPlaylistAdapter expandableAdapter = (MultipleGroupPlaylistAdapter) adapter;

		//显示动画
		if ((boolean) changeView.getTag()) {
			final ObjectAnimator hideRotate = ObjectAnimator.ofFloat(changeView, "rotation", 270f, 180f);
			hideRotate.setDuration(300);
			hideRotate.start();
			expandableAdapter.collapseGroup(groupPosition, true);
			changeView.setTag(false);
		} else {
			final ObjectAnimator showRotate = ObjectAnimator.ofFloat(changeView, "rotation", 180f, 270f);
			showRotate.setDuration(300);
			showRotate.start();
			expandableAdapter.expandGroup(groupPosition, true);
			changeView.setTag(true);
		}
	}

	//本地音乐
	@OnClick(R2.id.ll_mine_local_music)
	void onClickLocalMusic() {
		getParentDelegate().getSupportDelegate().start(new LocalMusicDelegate());
	}

	//我的电台
	@OnClick(R2.id.ll_mine_radio)
	void onClickMineRadio() {
		getParentDelegate().getSupportDelegate().start(new MineRadioDelegate());
	}

	//我的收藏
	@OnClick(R2.id.ll_mine_collect)
	void onClickCollect(){
		getParentDelegate().getSupportDelegate().start(new MineCollectTabDelegate());
	}

	private void initSpecIcon() {
		List<SpecData> specData = new ArrayList<>();
		specData.add(new SpecData(R.drawable.t_dragonball_icn_carplay, "驾驶模式"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_classical, "古典模式"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_look, "直播"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_radio, "电台"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_sati, "睡眠空间"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_xiaoice, "小冰电台"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_rank, "排行榜"));
		specData.add(new SpecData(R.drawable.t_dragonball_icn_daily, "每日推荐"));
		LinearLayoutManager manager = new LinearLayoutManager(getContext());
		manager.setOrientation(LinearLayoutManager.HORIZONTAL);
		mSpecAdapter = new SpecAdapter(specData);
		mSpecRecyclerView.setAdapter(mSpecAdapter);
		mSpecRecyclerView.setLayoutManager(manager);
	}

	static class SpecAdapter extends BaseQuickAdapter<SpecData, BaseViewHolder> {

		SpecAdapter(@Nullable List<SpecData> data) {
			super(R.layout.item_mine_spec, data);
		}

		@Override
		protected void convert(BaseViewHolder helper, SpecData item) {
			((ImageView) helper.getView(R.id.iv_mine_spec)).setImageResource(item.getDrawableId());
			((TextView) helper.getView(R.id.tv_spec_name)).setText(item.getText());
		}
	}


	class MultipleGroupPlaylistAdapter extends GroupedRecyclerViewAdapter {

		private ArrayList<UserPlayListGroupEntity> mData;
		private int setTagTimes = 0;
		MultipleGroupPlaylistAdapter(ArrayList<UserPlayListGroupEntity> entities, Context context) {
			super(context);
			this.mData = entities;
		}

		@Override
		public int getGroupCount() {
			return mData.size();
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			if (!isExpand(groupPosition)) {
				return 0;
			}
			return mData.get(groupPosition).getBean().size();
		}

		@Override
		public boolean hasHeader(int groupPosition) {
			return true;
		}

		@Override
		public boolean hasFooter(int groupPosition) {
			return false;
		}

		@Override
		public int getHeaderLayout(int viewType) {
			return R.layout.item_mine_gedan_header;
		}

		@Override
		public int getFooterLayout(int viewType) {
			return 0;
		}

		@Override
		public int getChildLayout(int viewType) {
			return R.layout.item_mine_gedan_content;
		}

		@Override
		public void onBindHeaderViewHolder(com.donkingliang.groupedadapter.holder.BaseViewHolder helper, int groupPosition) {
			ImageView imageView = helper.get(R.id.iv_item_gedan_new);
			//执行动画标识
			if(setTagTimes < 3){
				helper.get(R.id.iv_mine_gedan_state).setTag(true);
			}
			setTagTimes += 1;

			if (groupPosition == 1) {
				imageView.setVisibility(View.GONE);
			}
			//新建歌单
			helper.get(R.id.iv_item_gedan_new).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					new XPopup.Builder(getContext())
							.asCustom(new CreatePlayListDialog(getContext(), new CreatePlayListDialog.OnConfirmListener() {
								@Override
								public void onConfirm(String name) {
									RequestCenter.createPlayList(name, new DisposeDataListener() {
										@Override
										public void onSuccess(Object responseObj) {
											UserPlaylistBean bean = (UserPlaylistBean) responseObj;
											//bean.getPlaylist().get(0).getName();
										}

										@Override
										public void onFailure(Object reasonObj) {

										}
									});
								}
							})).show();
				}
			});
			helper.setText(R.id.tv_item_gedan_header_lefttitle, mData.get(groupPosition).getHeader());
			helper.setText(R.id.tv_item_gedan_header_righttext, "(" + mData.get(groupPosition).getPlayNum() + ")");
		}

		@Override
		public void onBindFooterViewHolder(com.donkingliang.groupedadapter.holder.BaseViewHolder holder, int groupPosition) {

		}

		@SuppressLint("SetTextI18n")
		@Override
		public void onBindChildViewHolder(com.donkingliang.groupedadapter.holder.BaseViewHolder holder, int groupPosition, int childPosition) {
			UserPlaylistBean.PlaylistBean item = mData.get(groupPosition).getBean().get(childPosition);
			Log.e("aaa", item.getName() + "==" + item.getId());
			ImageView img = holder.get(R.id.iv_item_gedan_content_img);
			manager.displayImageForCorner(img, item.getCoverImgUrl(), 5);
			holder.setText(R.id.tv_item_gedan_content_toptext, item.getName());
			TextView bottomText = holder.get(R.id.tv_item_gedan_content_bottomtext);
			holder.setText(R.id.tv_item_gedan_content_bottomtext, item.getTrackCount() + "首");

			if (item.isSubscribed()) {
				bottomText.setText(item.getTrackCount() + "首 " + "by " + item.getCreator().getNickname());
			} else {
				bottomText.setText(item.getTrackCount() + "首");
			}
		}

		/**
		 * 判断当前组是否展开
		 *
		 * @param groupPosition
		 * @return
		 */
		boolean isExpand(int groupPosition) {
			UserPlayListGroupEntity entity = mData.get(groupPosition);
			return entity.isExpand();
		}

		/**
		 * 展开一个组
		 *
		 * @param groupPosition
		 */
		void expandGroup(int groupPosition) {
			expandGroup(groupPosition, false);
		}

		/**
		 * 展开一个组
		 *
		 * @param groupPosition
		 * @param animate
		 */
		void expandGroup(int groupPosition, boolean animate) {
			UserPlayListGroupEntity entity = mData.get(groupPosition);
			entity.setExpand(true);
			if (animate) {
				notifyChildrenInserted(groupPosition);
			} else {
				notifyDataChanged();
			}
		}

		/**
		 * 收起一个组
		 *
		 * @param groupPosition
		 */
		void collapseGroup(int groupPosition) {
			collapseGroup(groupPosition, false);
		}

		/**
		 * 收起一个组
		 *
		 * @param groupPosition
		 * @param animate
		 */
		void collapseGroup(int groupPosition, boolean animate) {
			UserPlayListGroupEntity entity = mData.get(groupPosition);
			entity.setExpand(false);
			if (animate) {
				notifyChildrenRemoved(groupPosition);
			} else {
				notifyDataChanged();
			}
		}
	}

}
