package com.imooc.imooc_voice.view.discory.square.detail;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.HttpConstants;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.AlbumDetailBean;
import com.imooc.imooc_voice.model.newapi.PlaylistDetailBean;
import com.imooc.imooc_voice.model.newapi.TopListDetailBean;
import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.home.search.artist.ArtistDetailDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 歌单和专辑详情
 */
public class SongListDetailDelegate extends NeteaseLoadingDelegate {

	private static final String TAG = "GedanDetailDelegate";

	@BindView(R2.id.appbar_gedan_detail)
	AppBarLayout mAppBarLayout;
	@BindView(R2.id.tv_gedan_detail_toolbar_title)
	TextView mTvToolBarTitle;
	@BindView(R2.id.tv_gedan_detail_title)
	TextView mTvDetailTitle;
	@BindView(R2.id.tv_gedan_detail_desc)
	TextView mTvDetailDesc;
	@BindView(R2.id.tv_gedan_detail_avatar_name)
	TextView mTvDetailAvatarName;
	@BindView(R2.id.toolbar_gedan_detail)
	Toolbar mToolBar;
	@BindView(R2.id.iv_gedan_detail_img)
	ImageView mImageViewGedan;
	@BindView(R2.id.iv_gedan_detail_playnum)
	ImageView mIvPlayNumIcon;
	@BindView(R2.id.rl_toolbar_gedan_detail)
	RelativeLayout mRlToolbar;
	@BindView(R2.id.collapsing_toolbar_layout)
	CollapsingToolbarLayout mCollspsingToolbar;
	@BindView(R2.id.iv_gedan_detail_img_cover)
	ImageView mIvAppbarBackground;
	@BindView(R2.id.iv_gedan_detail_avatar_img)
	ImageView mIvAvatarView;
	@BindView(R2.id.tv_gedan_detail_playnum)
	TextView mTvGedanPlayNum;
	@BindView(R2.id.tv_gedan_detail_toolbar_reason)
	TextView mTvCopyWriter;
	@BindView(R2.id.tv_gedan_detail_share_count)
	TextView mTvShareCount;
	@BindView(R2.id.tv_gedan_detail_comment_count)
	TextView mTvCommentCount;
	@BindView(R2.id.tv_gedan_detail_song_num)
	TextView mTvSongNum;
	@BindView(R2.id.tv_gedan_detail_collect_count)
	TextView mTvSongCollectCount;
	@BindView(R2.id.tv_gedan_detail_collect_count1)
	TextView mTvSongCollectCount1;
	@BindView(R2.id.ll_gedan_subscribe)
	LinearLayout mLlPlayListSubscribe;
	@BindView(R2.id.ll_gedan_subscribed)
	LinearLayout mLlPlayListSubscribed;
	@BindView(R2.id.iv_gedan_detail_album_tag)
	ImageView mIvAlbumAttachIcon;

	private PlayListAdapter mAdapter;
	private ImageLoaderManager manager;

	RecyclerView mRecyclerViewGedan;

	private static final String ARGS_SONGLIST_ID = "ARGS_SONGLIST_ID";
	private static final String ARGS_SONGLIST_TYPE = "ARGS_SONGLIST_TYPE";
	private static final String ARGS_SONGLIST_REASON = "ARGS_SONGLIST_REASON";


	public static final int TYPE_PLAYLIST = 0;
	public static final int TYPE_ALBUM = 1;

	//歌单ID
	private String songlistId;
	//推荐原因
	private String copyWriter;
	//专辑或者歌单
	private int type;
	//评论数量
	private String count;
	//歌单图片
	private String gedanImg;
	//歌单创建者
	private String gedanCreator;
	//歌单标题
	private String gedanTitle;
	//创建歌单的用户ID
	private String userId;

	final StringBuilder params = new StringBuilder();

	public static SongListDetailDelegate newInstance(int type, long id) {
		return newInstance(type, id, "");
	}

	public static SongListDetailDelegate newInstance(int type, long id, String copyWriter) {
		final Bundle args = new Bundle();
		args.putString(ARGS_SONGLIST_ID, String.valueOf(id));
		args.putInt(ARGS_SONGLIST_TYPE, type);
		args.putString(ARGS_SONGLIST_REASON, copyWriter);
		final SongListDetailDelegate delegate = new SongListDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			songlistId = args.getString(ARGS_SONGLIST_ID);
			type = args.getInt(ARGS_SONGLIST_TYPE);
			copyWriter = args.getString(ARGS_SONGLIST_REASON, "");
		}
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_gedan_detail;
	}

	@Override
	public void initView() {
		mRecyclerViewGedan = rootView.findViewById(R.id.rv_gedan_detail_normal);
		switch (type){
			case TYPE_PLAYLIST:
				//歌单
				initPlayListView();
				break;
			case TYPE_ALBUM:
				//专辑
				initAlbumView();
				break;
			default:
				break;
		}
	}


	@Override
	public void onLazyInitView(@Nullable Bundle savedInstanceState) {
		super.onLazyInitView(savedInstanceState);
		mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

				//ToolBar标题变化
				if (Math.abs(i) > 220) {
					mTvToolBarTitle.setText(mTvDetailTitle.getText());
				} else {
					if(type == TYPE_ALBUM){
						mTvToolBarTitle.setText("专辑");
					}else{
						mTvToolBarTitle.setText("歌单");
					}
					mTvToolBarTitle.setFocusable(true);
				}
				//mCollspsingToolbar 透明度变化 0- 660  i/660
				DecimalFormat df = new DecimalFormat("0.0");
				float num = (float) (Math.abs(i)) / (float) 440;
				//float alpha = (1 - num) * 255;
				int alpha = (int) (num * 255);
				//int alphaa = Integer.parseInt(String.valueOf(s.split(".")[0]));
				//mCollspsingToolbar.setAlpha(alpha);
				//mIvAppbarBackground.setImageAlpha(alpha);

			}
		});
	}

	/**
	 * 初始化专辑
	 */
	private void initAlbumView() {
		//不显示播放数量
		mTvGedanPlayNum.setVisibility(View.GONE);
		mIvPlayNumIcon.setVisibility(View.GONE);
		//不显示头像
		mIvAvatarView.setVisibility(View.GONE);
		//显示专辑特有图标
		mIvAlbumAttachIcon.setVisibility(View.VISIBLE);
		RequestCenter.getAlbumDetail(songlistId, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				AlbumDetailBean bean = (AlbumDetailBean) responseObj;
				TopListDetailBean.Album album = bean.getAlbum();
				//专辑名称
				if(bean.getAlbum().getAlias().size() != 0){
					mTvDetailTitle.setText(bean.getAlbum().getName() + bean.getAlbum().getAlias().get(0));
				}else{
					mTvDetailTitle.setText(bean.getAlbum().getName());
				}
				//专辑图片
				manager.displayImageForCorner(mImageViewGedan, album.getPicUrl());
				//毛玻璃效果 Failed to allocate a 144000016 byte allocation with 25165824 free bytes and 95MB until OOM, target footprint 462221240, growth limit 536870912
				//manager.displayImageForViewGroup(mAppBarLayout, album.getBlurPicUrl(), 200);
				//显示歌手名
				mTvDetailAvatarName.setText("歌手:  " + album.getArtist().getName());
				mTvDetailDesc.setText("发行时间:" + TimeUtil.getTimeStandardOnlyYMD(album.getPublishTime())+"\n"+album.getDescription());
				//评论数量
				mTvCommentCount.setText(String.valueOf(album.getInfo().getCommentCount()));
				//分享数量
				mTvShareCount.setText(String.valueOf(album.getInfo().getShareCount()));
				//歌曲数量
				mTvSongNum.setText("(共"+bean.getSongs().size() + "首)");
				//
				mTvSongCollectCount.setText("收藏");
				mLlPlayListSubscribe.setVisibility(View.VISIBLE);
				//歌手ID
				userId = String.valueOf(bean.getAlbum().getArtist().getId());
				//用于评论Delegate数据

				count = String.valueOf(album.getInfo().getCommentCount());
				gedanImg = album.getPicUrl();
				gedanCreator = album.getArtist().getName();
				gedanTitle = album.getName();

				mAdapter = new PlayListAdapter(bean.getSongs());
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						SongDetailBean.SongsBean item = (SongDetailBean.SongsBean) adapter.getItem(position);
						String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
						AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), "3:00"));

					}
				});
				mRecyclerViewGedan.setAdapter(mAdapter);
				mRecyclerViewGedan.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}


	/**
	 * 初始化歌单
	 */
	private void initPlayListView() {

		//copyWeriter
		if(!TextUtils.isEmpty(copyWriter)){
			mTvCopyWriter.setText(copyWriter);
			mTvCopyWriter.setVisibility(View.VISIBLE);
		}
		RequestCenter.getPlaylistDetail(songlistId, new DisposeDataListener() {
			@SuppressLint({"SetTextI18n", "StaticFieldLeak"})
			@Override
			public void onSuccess(Object responseObj) {

				PlaylistDetailBean json = (PlaylistDetailBean) responseObj;
				final PlaylistDetailBean.PlaylistBean playlist = json.getPlaylist();
				mTvDetailTitle.setText(playlist.getName());
				mTvDetailDesc.setText(playlist.getDescription());
				mTvDetailAvatarName.setText(playlist.getCreator().getNickname());

				//播放数量
				mTvGedanPlayNum.setText(SearchUtil.getCorresPondingString(playlist.getPlayCount()));
				manager.displayImageForCircle(mIvAvatarView, playlist.getCreator().getAvatarUrl());

				manager.displayImageForCorner(mImageViewGedan, playlist.getCoverImgUrl(), 5);
				//评论和分享数量
				mTvShareCount.setText(String.valueOf(playlist.getShareCount()));
				mTvCommentCount.setText(String.valueOf(playlist.getCommentCount()));

				//传递给评论Delegate的数据
				count = String.valueOf(playlist.getCommentCount());
				gedanImg = String.valueOf(playlist.getCoverImgUrl());
				gedanCreator = playlist.getCreator().getNickname();
				//创建歌单的用户ID
				userId = String.valueOf(playlist.getCreator().getUserId());
				gedanTitle = playlist.getName();
				//收藏的数量
				mTvSongCollectCount.setText("收藏(" + SearchUtil.getCorresPondingString(playlist.getSubscribedCount()) + ")");

				mTvSongCollectCount1.setText(String.valueOf(playlist.getSubscribedCount()));

				if (playlist.isSubscribed()) {
					//已收藏
					mLlPlayListSubscribed.setVisibility(View.VISIBLE);
				} else {
					//未收藏
					mLlPlayListSubscribe.setVisibility(View.VISIBLE);
				}

				//毛玻璃效果背景
				manager.displayImageForViewGroup(mAppBarLayout, playlist.getCoverImgUrl(), 200);

				List<PlaylistDetailBean.PlaylistBean.TrackIdsBean> trackIds = playlist.getTrackIds();

				int trakIds = trackIds.size();
				mTvSongNum.setText("(共" + (trakIds - 1) + "首)");

				if(trakIds > 50){
					trakIds = 50;
				}
				for (int i = 0; i < trakIds; i++) {
					//最后一个参数不加逗号
					if (i == trakIds - 1) {
						params.append(trackIds.get(i).getId());
					} else {
						params.append(trackIds.get(i).getId()).append(",");
					}
				}
				new AsyncTask<Void,Void,Void>(){

					@Override
					protected Void doInBackground(Void... voids) {
						RequestCenter.getSongDetail(params.toString(), new DisposeDataListener() {
							@Override
							public void onSuccess(Object responseObj) {
								SongDetailBean bean = (SongDetailBean) responseObj;
								List<SongDetailBean.SongsBean> songs = bean.getSongs();
								mAdapter = new PlayListAdapter(songs);
								mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
									@Override
									public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
										SongDetailBean.SongsBean item = (SongDetailBean.SongsBean) adapter.getItem(position);
										String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
										AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), "3:00"));

									}
								});
								mRecyclerViewGedan.setAdapter(mAdapter);
								mRecyclerViewGedan.setLayoutManager(new LinearLayoutManager(getContext()));
								addRootView();
							}

							@Override
							public void onFailure(Object reasonObj) {

							}
						});
						return null;
					}
				}.execute();

				//manager.displayImageForViewGroup(mIvAppbarBackground, json.getPic300(), 500);



			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_gedan_loading_view;
	}

	@OnClick(R2.id.img_gedan_detail_back)
	void onClickBack() {
		getSupportDelegate().pop();
	}

	//查看评论 歌单评论 或者专辑评论
	@OnClick(R2.id.ll_gedan_detail_comment)
	void onClickGedanComment() {

		getSupportDelegate().start(CommentDelegate.newInstance(songlistId, type, count, gedanImg, gedanCreator, gedanTitle));

	}

	//查看用户详情或者歌手
	@OnClick(R2.id.tv_gedan_detail_avatar_name)
	void onClickUserInfo() {
		switch (type){
			case TYPE_ALBUM:
				//查看歌手
				getSupportDelegate().start(ArtistDetailDelegate.newInstance(userId));
				break;
			case TYPE_PLAYLIST:
				//查看用户
				getSupportDelegate().start(UserDetailDelegate.newInstance(userId));
				break;
		}

	}


	//歌单的Adapter
	static public class PlayListAdapter extends BaseQuickAdapter<SongDetailBean.SongsBean, BaseViewHolder> {

		PlayListAdapter(@Nullable List<SongDetailBean.SongsBean> data) {
			super(R.layout.item_gedan_detail_song, data);
		}

		@Override
		protected void convert(BaseViewHolder helper, SongDetailBean.SongsBean item) {

			helper.setText(R.id.item_play_no, String.valueOf(helper.getLayoutPosition()+1));
			helper.setText(R.id.viewpager_list_toptext, item.getName());
			helper.setText(R.id.viewpager_list_bottom_text, item.getAr().get(0).getName());
			helper.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
		}
	}


}
