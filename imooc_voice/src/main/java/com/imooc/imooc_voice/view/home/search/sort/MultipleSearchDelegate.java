package com.imooc.imooc_voice.view.home.search.sort;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.HttpConstants;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.mine.SpecData;
import com.imooc.imooc_voice.model.newapi.search.MultipleSearchEntity;
import com.imooc.imooc_voice.model.newapi.search.SynthesisSearchBean;
import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.radio.detail.RadioDetailDelegate;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.home.search.NeteaseSearchLoadingDelegate;
import com.imooc.imooc_voice.view.home.search.artist.ArtistDetailDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.imooc_voice.view.video.VideoDetailDelegate;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import static com.imooc.imooc_voice.Constants.PLAYLIST;


/**
 * 综合搜索
 */
public class MultipleSearchDelegate extends NeteaseSearchLoadingDelegate implements GroupedRecyclerViewAdapter.OnFooterClickListener, GroupedRecyclerViewAdapter.OnChildClickListener {

	private MultipeSearchAdapter mAdapter;
	private ArrayList<MultipleSearchEntity> data = new ArrayList<>();
	private OnChangeViewerPagerPositionListener mListener;

	@Override
	public void reloadSearchResult(final String keywords) {

		RequestCenter.getSynthesisSearch(keywords, 1018, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SynthesisSearchBean bean = (SynthesisSearchBean) responseObj;
				data.clear();
				data.add(new MultipleSearchEntity(bean.getResult().getSong()));
				data.add(new MultipleSearchEntity(bean.getResult().getVideo()));
				data.add(new MultipleSearchEntity(bean.getResult().getPlayList()));
				data.add(new MultipleSearchEntity(bean.getResult().getDjRadio()));
				data.add(new MultipleSearchEntity(bean.getResult().getArtist()));
				data.add(new MultipleSearchEntity(bean.getResult().getUser()));

				mAdapter = new MultipeSearchAdapter(getContext(), data, keywords);
				mAdapter.setOnFooterClickListener(MultipleSearchDelegate.this);
				mAdapter.setOnChildClickListener(MultipleSearchDelegate.this);
				mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
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
	public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition, int childPosition) {
		switch (groupPosition) {
			case 0:
				//单曲
				SongDetailBean.SongsBean item = data.get(groupPosition).getSong().getSongs().get(childPosition);
				String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
				AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDt())));
				break;
			case 1:
				//视频
				SynthesisSearchBean.ResultBean.VideoBean.VideosBean videosBean = data.get(groupPosition).getVideo().getVideos().get(childPosition);
				getParentDelegate().getSupportDelegate().start(VideoDetailDelegate.newInstance(videosBean.getVid()));
				break;
			case 2:
				//歌单
				SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean playListsBean = data.get(groupPosition).getPlayList().getPlayLists().get(childPosition);
				getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, playListsBean.getId()));
				break;
			case 3:
				//电台
				SynthesisSearchBean.ResultBean.DjRadioBean.DjRadiosBean djRadiosBean = data.get(groupPosition).getDjRadio().getDjRadios().get(childPosition);
				getParentDelegate().getSupportDelegate().start(RadioDetailDelegate.newInstance(djRadiosBean.getId()));
				break;
			case 4:
				//歌手
				SynthesisSearchBean.ResultBean.ArtistBean.ArtistsBean artistsBean = data.get(groupPosition).getArtist().getArtists().get(childPosition);
				getParentDelegate().getSupportDelegate().start(ArtistDetailDelegate.newInstance(artistsBean.getId()));
				break;
			case 5:
				//用户
				SynthesisSearchBean.ResultBean.UserBean.UsersBean usersBean = data.get(groupPosition).getUser().getUsers().get(childPosition);
				getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(String.valueOf(usersBean.getUserId())));
				break;

		}
	}

	//尾布局
	@Override
	public void onFooterClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition) {
		if (mListener != null) {
			mListener.onChangePosition(groupPosition + 1);
		}
	}

	public void setListener(OnChangeViewerPagerPositionListener listener) {
		this.mListener = listener;
	}

	public interface OnChangeViewerPagerPositionListener {
		void onChangePosition(int position);
	}


	static class MultipeSearchAdapter extends GroupedRecyclerViewAdapter {

		private ArrayList<MultipleSearchEntity> mData;
		private ArrayList<SpecData> mDataType = new ArrayList<>();
		private String keyword;

		MultipeSearchAdapter(Context context, ArrayList<MultipleSearchEntity> data, String keywords) {
			super(context);
			this.mData = data;
			this.keyword = keywords;
			mDataType.add(new SpecData(R.layout.item_gedan_detail_song, "单曲"));
			mDataType.add(new SpecData(R.layout.item_video_normal, "视频"));
			mDataType.add(new SpecData(R.layout.item_mine_gedan_content, "歌单"));
			mDataType.add(new SpecData(R.layout.item_mine_gedan_content, "电台"));
			mDataType.add(new SpecData(R.layout.item_singer_normal, "歌手"));
			mDataType.add(new SpecData(R.layout.item_search_user, "用户"));
		}

		@Override
		public int getGroupCount() {
			return mDataType.size();
		}

		//中间布局的个数
		@Override
		public int getChildrenCount(int groupPosition) {
			return getChildLayoutCount(groupPosition);
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
			return R.layout.item_multiple_search_header;
		}

		@Override
		public int getFooterLayout(int viewType) {
			return R.layout.item_more_info;
		}

		@Override
		public int getChildLayout(int viewType) {
			return mDataType.get(viewType).getDrawableId();
		}

		@Override
		public void onBindHeaderViewHolder(BaseViewHolder holder, int groupPosition) {
			String headerTitle = mDataType.get(groupPosition).getText();
			holder.setText(R.id.tv_item_multiple_search_header, headerTitle);
		}

		@Override
		public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {
			holder.setText(R.id.tv_more_info, getFooterTitle(groupPosition));
		}

		@Override
		public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
			convertChildViewHolder(holder, groupPosition, childPosition);
		}

		/**
		 * 子布局的类型(单曲 歌单..)
		 */
		@Override
		public int getChildViewType(int groupPosition, int childPosition) {
			return groupPosition;
		}

		private int getChildLayoutCount(int groupPosition) {
			switch (groupPosition) {
				case 0:
					return mData.get(groupPosition).getSong().getSongs().size();
				case 1:
					return mData.get(groupPosition).getVideo().getVideos().size();
				case 2:
					return mData.get(groupPosition).getPlayList().getPlayLists().size();
				case 3:
					return mData.get(groupPosition).getDjRadio() != null ? mData.get(groupPosition).getDjRadio().getDjRadios().size() : 0;
				case 4:
					return mData.get(groupPosition).getArtist().getArtists().size();
				case 5:
					return mData.get(groupPosition).getUser().getUsers().size();

				default:
					return 0;
			}
		}

		private String getFooterTitle(int groupPosition) {
			switch (groupPosition) {
				case 0:
					return mData.get(groupPosition).getSong().getMoreText();
				case 1:
					return mData.get(groupPosition).getVideo().getMoreText();
				case 2:
					return mData.get(groupPosition).getPlayList().getMoreText();
				case 3:
					return mData.get(groupPosition).getDjRadio().getMoreText();
				case 4:
					return "查看全部" + mData.get(groupPosition).getArtist().getArtists().size() + "位歌手";
				case 5:
					return mData.get(groupPosition).getUser().getMoreText();
				default:
					return "";
			}
		}

		private void convertChildViewHolder(BaseViewHolder adapter, int groupPosition, int childPosition) {
			switch (groupPosition) {
				case 0:
					//单曲
					List<SongDetailBean.SongsBean> songs = mData.get(groupPosition).getSong().getSongs();
					final SongDetailBean.SongsBean item = songs.get(childPosition);
					adapter.get(R.id.item_play_no).setVisibility(View.GONE);
					if (item.getName().contains(keyword)) {
						int start = item.getName().indexOf(keyword);
						int end = start + keyword.length();
						String resString = item.getName();
						SpannableStringBuilder style = new SpannableStringBuilder(resString);
						style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
						((TextView) adapter.get(R.id.viewpager_list_toptext)).setText(style);
					} else {
						adapter.setText(R.id.viewpager_list_toptext, item.getName());
					}

					String artist = item.getAr().get(0).getName();
					if (artist.contains(keyword)) {
						int start = artist.indexOf(keyword);
						int end = start + keyword.length();
						SpannableStringBuilder style = new SpannableStringBuilder(artist);
						style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
						((TextView) adapter.get(R.id.viewpager_list_bottom_text)).setText(style);
					} else {
						adapter.setText(R.id.viewpager_list_bottom_text, artist);
					}
					break;
				case 1:
					//视频
					List<SynthesisSearchBean.ResultBean.VideoBean.VideosBean> videos = mData.get(groupPosition).getVideo().getVideos();
					final SynthesisSearchBean.ResultBean.VideoBean.VideosBean videoItem = videos.get(childPosition);

					//设置播放次数
					adapter.setText(R.id.tv_item_video_playnum, SearchUtil.getCorresPondingString(videoItem.getPlayTime()));
					//视频标题
					((TextView) adapter.get(R.id.tv_item_video_name)).setText(SearchUtil.getMatchingKeywords(videoItem.getTitle(), keyword));
					//视频描述
					String description = TimeUtil.getTimeNoYMDH(videoItem.getDurationms()) + " by " + videoItem.getCreator().get(0).getUserName();
					adapter.setText(R.id.tv_item_video_creator, description);
					ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.get(R.id.iv_item_video_cover), videoItem.getCoverUrl());
					break;
				case 2:
					//歌单
					List<SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean> playLists = mData.get(groupPosition).getPlayList().getPlayLists();
					final SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean platlistItem = playLists.get(childPosition);
					((TextView) adapter.get(R.id.tv_item_gedan_content_toptext)).setText(SearchUtil.getMatchingKeywords(platlistItem.getName(), keyword));

					int playListPlaycount = platlistItem.getPlayCount();
					//歌曲数量以及播放次数
					description = platlistItem.getTrackCount() + "首，by " + platlistItem.getCreator().getNickname() + "，播放" + SearchUtil.getCorresPondingString(playListPlaycount) + "次";
					adapter.setVisible(R.id.iv_item_gedan_more, false);
					((TextView) adapter.get(R.id.tv_item_gedan_content_bottomtext)).setText(SearchUtil.getMatchingKeywords(description, keyword));
					ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.get(R.id.iv_item_gedan_content_img), platlistItem.getCoverImgUrl());
					break;
				case 3:
					//电台
					List<SynthesisSearchBean.ResultBean.DjRadioBean.DjRadiosBean> djRadios = mData.get(groupPosition).getDjRadio().getDjRadios();
					SynthesisSearchBean.ResultBean.DjRadioBean.DjRadiosBean djRadioItem = djRadios.get(childPosition);
					((TextView) adapter.get(R.id.tv_item_gedan_content_toptext)).setText(SearchUtil.getMatchingKeywords(djRadioItem.getName(), keyword));
					((TextView) adapter.get(R.id.tv_item_gedan_content_bottomtext)).setText(SearchUtil.getMatchingKeywords(djRadioItem.getDj().getNickname(), keyword));
					ImageLoaderManager.getInstance().displayImageForCorner((ImageView) adapter.get(R.id.iv_item_gedan_content_img), djRadioItem.getPicUrl());
					adapter.setVisible(R.id.iv_item_gedan_more, false);
					break;
				case 4:
					//歌手
					List<SynthesisSearchBean.ResultBean.ArtistBean.ArtistsBean> artists = mData.get(groupPosition).getArtist().getArtists();
					SynthesisSearchBean.ResultBean.ArtistBean.ArtistsBean artistItem = artists.get(childPosition);
					((TextView) adapter.get(R.id.tv_singer_name)).setText(SearchUtil.getMatchingKeywords(artistItem.getName(), keyword));
					if (artistItem.getAlias() != null && artistItem.getAlias().size() != 0) {
						adapter.setText(R.id.tv_singer_alias, "(" + SearchUtil.getMatchingKeywords(artistItem.getAlias().get(0), keyword) + ")");
					}
					ImageLoaderManager.getInstance().displayImageForCircle((ImageView) adapter.get(R.id.iv_singer_avatar), artistItem.getPicUrl());
					break;
				case 5:
					//用户
					List<SynthesisSearchBean.ResultBean.UserBean.UsersBean> users = mData.get(groupPosition).getUser().getUsers();
					SynthesisSearchBean.ResultBean.UserBean.UsersBean userItem = users.get(childPosition);
					adapter.setText(R.id.tv_item_search_user_name, userItem.getNickname());

					//用户身份
					if (userItem.getUserType() == 4) {
						//网易音乐人
						adapter.setText(R.id.tv_item_search_user_description, "网易音乐人");
						adapter.setVisible(R.id.iv_item_search_user_tag, true);
						((ImageView) adapter.get(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_musician);

					} else if (userItem.getUserType() == 10) {
						//大V
						adapter.setVisible(R.id.iv_item_search_user_tag, true);
						((ImageView) adapter.get(R.id.iv_item_search_user_tag)).setImageResource(R.drawable.ic_official);
						adapter.setText(R.id.tv_item_search_user_description, userItem.getDescription());
					} else {
						adapter.setText(R.id.tv_item_search_user_description, userItem.getDescription());
					}
					//是否关注
					if (userItem.isFollowed()) {
						adapter.setVisible(R.id.ll_search_user_followed, true);
					} else {
						adapter.setVisible(R.id.ll_search_user_follow, true);
					}
					//性别
					if (userItem.getGender() == 1) {
						//男性
						adapter.setVisible(R.id.iv_item_search_user_gender, true);
						((ImageView) adapter.get(R.id.iv_item_search_user_gender)).setImageResource(R.drawable.ic_male);
					} else if (userItem.getGender() == 2) {
						//女性
						adapter.setVisible(R.id.iv_item_search_user_gender, true);
						((ImageView) adapter.get(R.id.iv_item_search_user_gender)).setImageResource(R.drawable.ic_female);
					}
					//用户头像
					ImageLoaderManager.getInstance().displayImageForCircle((ImageView) adapter.get(R.id.iv_item_search_user_avatar), userItem.getAvatarUrl());
					break;
			}
		}
	}


}
