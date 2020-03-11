package com.imooc.imooc_voice.view.discory.square.gedandetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.GedanDetailJson;
import com.imooc.imooc_voice.model.newapi.PlaylistDetailBean;
import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GedanDetailDelegate extends NeteaseDelegate {

	@BindView(R2.id.rv_gedan_detail_normal)
	RecyclerView mRecyclerViewGedan;
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
	@BindView(R2.id.tv_gedan_detail_share_count)
	TextView mTvShareCount;
	@BindView(R2.id.tv_gedan_detail_comment_count)
	TextView mTvCommentCount;

	private GedanDetailAdapter mAdapter;
	private ImageLoaderManager manager;

	private static final String ARGS_GEDAN_ID = "ARGS_GEDAN_ID";
	//歌单ID
	private String id;

	public static GedanDetailDelegate newInstance(String id){
		final Bundle args = new Bundle();
		args.putString(ARGS_GEDAN_ID, id);
		final GedanDetailDelegate delegate = new GedanDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			id = args.getString(ARGS_GEDAN_ID);
		}
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_gedan_detail;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

				//ToolBar标题变化
				if(Math.abs(i) > 220){
					mTvToolBarTitle.setText(mTvDetailTitle.getText());
				}else{
					mTvToolBarTitle.setText("歌单");
				}
				//mCollspsingToolbar 透明度变化 0- 660  i/660
				DecimalFormat df = new DecimalFormat("0.0");
				float num = (float)(Math.abs(i)) / (float)440;
				//float alpha = (1 - num) * 255;
				int alpha = (int) (num * 255);
				//int alphaa = Integer.parseInt(String.valueOf(s.split(".")[0]));
				//mCollspsingToolbar.setAlpha(alpha);
				mIvAppbarBackground.setImageAlpha(alpha);

			}
		});

		RequestCenter.getPlaylistDetail(id, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				PlaylistDetailBean json = (PlaylistDetailBean) responseObj;
				mTvDetailTitle.setText(json.getPlaylist().getName());
				mTvDetailDesc.setText(json.getPlaylist().getDescription());
				mTvDetailAvatarName.setText(json.getPlaylist().getCreator().getNickname());
				mTvGedanPlayNum.setText(json.getPlaylist().getPlayCount()/10000 + "万");
				manager.displayImageForCircle(mIvAvatarView, json.getPlaylist().getCreator().getAvatarUrl());

				manager.displayImageForCorner(mImageViewGedan, json.getPlaylist().getCoverImgUrl(), 5);
				mTvShareCount.setText(json.getPlaylist().getShareCount());
				mTvCommentCount.setText(json.getPlaylist().getCommentCount());
				//毛玻璃效果背景
				manager.displayImageForViewGroup(mAppBarLayout, json.getPlaylist().getCoverImgUrl(), 200);
				String params = "";
				List<PlaylistDetailBean.PlaylistBean.TrackIdsBean> trackIds = json.getPlaylist().getTrackIds();
				for(int i=0;i<trackIds.size();i++){
					params = trackIds.get(i).getId() + ",";
				}
				RequestCenter.getSongDetail(params, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						SongDetailBean bean = (SongDetailBean) responseObj;
						List<SongDetailBean.SongsBean> songs = bean.getSongs();
						mAdapter = new GedanDetailAdapter(songs);
						mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
							@Override
							public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
								SongDetailBean.SongsBean item = (SongDetailBean.SongsBean) adapter.getItem(position);

								//TODO 加入播放队列
							}
						});
						mRecyclerViewGedan.setAdapter(mAdapter);
						mRecyclerViewGedan.setLayoutManager(new LinearLayoutManager(getContext()));
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});

//				manager.displayImageForViewGroup(mIvAppbarBackground, json.getPic300(), 500);
//				ArrayList<GedanDetailJson.GeDanDetail> content = json.getContent();
//				mAdapter = new GedanDetailAdapter(content);
//				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//					@Override
//					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//						GedanDetailJson.GeDanDetail item = (GedanDetailJson.GeDanDetail) adapter.getItem(position);
//						String songId = item.getSongid();
//						//加入播放队列
//					}
//				});
//				mRecyclerViewGedan.setAdapter(mAdapter);
//				mRecyclerViewGedan.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}


	@OnClick(R2.id.img_gedan_detail_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}

	@Override
	public void post(Runnable runnable) {

	}
}
