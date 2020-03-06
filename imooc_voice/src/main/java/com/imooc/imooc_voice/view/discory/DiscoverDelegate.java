package com.imooc.imooc_voice.view.discory;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.BillListJson;
import com.imooc.imooc_voice.model.json.FocusJson;
import com.imooc.imooc_voice.model.json.GedanJson;
import com.imooc.imooc_voice.view.discory.gedandetail.GedanDetailDelegate;
import com.imooc.imooc_voice.view.discory.square.GedanSquareDelegate;
import com.imooc.lib_common_ui.bannder.BannerCreator;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class DiscoverDelegate extends NeteaseDelegate {


	/**
	 * 发现页面
	 * 		轮播图
	 * 		每日推荐、歌单、排行榜、电台、私人FM
	 * 		推荐歌单(6个歌单)   歌单广场
	 * 		新碟 新歌  新歌推荐
	 *
	 */

	@BindView(R2.id.banner_recycler_item)
	ConvenientBanner convenientBanner;
	@BindView(R2.id.rv_discover_gedan)
	RecyclerView mRecyclerViewGedan;
	@BindView(R2.id.rv_discover_album_song)
	RecyclerView mRecyclerViewAlbumSong;
	@BindView(R2.id.tv_discover_more_album_song)
	TextView mTvAlbumOrSong;
	@BindView(R2.id.tv_discover_new_album)
	TextView mTvCurrentAlbum;
	@BindView(R2.id.tv_discover_new_song)
	TextView mTvCurrentSong;

	private GedanAdapter mGedanAdapter;
	private AlbumSongAdapter mAlbumSongAdapter;


	private int ALBUM_OR_SONG = 0;

	@Override
	public Object setLayout() {
		return R.layout.delegate_discover;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
		/*
		 * 查询轮播图
		 */
		RequestCenter.queryBanner(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				FocusJson json = ((FocusJson)responseObj);
				ArrayList<FocusJson.Focus> pic = json.getPic();
				ArrayList<String> banner = new ArrayList<>();
				for(FocusJson.Focus item: pic){
					String itempic = item.getRandpic();
					banner.add(itempic);
				}
				BannerCreator.setDefault(convenientBanner, banner, null);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		/*
		 * 推荐歌单
		 */
		RequestCenter.queryGedan(1, 5, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				GedanJson json = ((GedanJson)responseObj);
				ArrayList<GedanJson.GeDan> geDan = json.getContent();

				mGedanAdapter = new GedanAdapter(geDan);
				mRecyclerViewGedan.setAdapter(mGedanAdapter);
				mRecyclerViewGedan.setLayoutManager(gridLayoutManager);
				mGedanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						final GedanJson.GeDan item = (GedanJson.GeDan) adapter.getItem(position);
						//跳入歌单详情
						final String listId = item.getListid();
						getParentDelegate().getSupportDelegate().start(GedanDetailDelegate.newInstance(listId));
					}
				});
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});


		/*
		 * 新碟
		 */
		RequestCenter.queryNewAlbumList(0, 3, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				BillListJson json = (BillListJson) responseObj;
				ArrayList<BillListJson.BillList> song_list = json.getSong_list();

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		/*
		 *	新歌
		 */
		RequestCenter.queryNewSongList(0, 3, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				BillListJson json = (BillListJson) responseObj;
				ArrayList<BillListJson.BillList> song_list = json.getSong_list();
				mAlbumSongAdapter = new AlbumSongAdapter(song_list, 0);
				mRecyclerViewAlbumSong.setAdapter(mAlbumSongAdapter);
				GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
				mRecyclerViewAlbumSong.setLayoutManager(manager);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		changeAlbumOrSong(ALBUM_OR_SONG);

	}

	@Override
	public void onLazyInitView(@Nullable Bundle savedInstanceState) {
		super.onLazyInitView(savedInstanceState);
	}

	@Override
	public void post(Runnable runnable) {

	}

	/*
	 * 歌单广场
	 */
	@OnClick(R2.id.tv_discover_gedan_square)
	void onClickGedanSquare(){
		getParentDelegate().getSupportDelegate().start(new GedanSquareDelegate());
	}
	@OnClick(R2.id.ll_discover_gedan)
	void onClickGedanSquree(){
		getParentDelegate().getSupportDelegate().start(new GedanSquareDelegate());
	}

	@OnClick(R2.id.tv_discover_new_album)
	void onClickChooseAlbum(){
		ALBUM_OR_SONG = 0;
		changeAlbumOrSong(ALBUM_OR_SONG);
	}

	@OnClick(R2.id.tv_discover_new_song)
	void onClickChooseSong(){
		ALBUM_OR_SONG = 1;
		changeAlbumOrSong(ALBUM_OR_SONG);
	}


	void changeAlbumOrSong(int type){
		if(type ==0){
			//当前是新碟
			mTvCurrentAlbum.setTextColor(getResources().getColor(R.color.black));
			mTvCurrentAlbum.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
			mTvCurrentAlbum.setTextSize(15);

			mTvCurrentSong.setTextColor(getResources().getColor(R.color.gray));
			mTvCurrentSong.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
			mTvCurrentSong.setTextSize(12);

			mTvAlbumOrSong.setText("更多新碟");

		}else{
			mTvCurrentSong.setTextColor(getResources().getColor(R.color.black));
			mTvCurrentSong.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
			mTvCurrentSong.setTextSize(15);

			mTvCurrentAlbum.setTextColor(getResources().getColor(R.color.gray));
			mTvCurrentAlbum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
			mTvCurrentAlbum.setTextSize(12);

			mTvAlbumOrSong.setText("新歌推荐");
		}
	}
}
