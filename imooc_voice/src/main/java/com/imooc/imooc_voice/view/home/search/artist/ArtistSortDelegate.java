package com.imooc.imooc_voice.view.home.search.artist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.ArtistListBean;
import com.imooc.imooc_voice.model.newapi.TopListDetailBean;
import com.imooc.imooc_voice.model.newapi.dj.DjSubBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;


import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ArtistSortDelegate extends NeteaseDelegate {

	@BindView(R2.id.tv_artist_sort_china)
	TextView mTvSortChina;
	@BindView(R2.id.tv_artist_sort_west)
	TextView mTvSortWest;
	@BindView(R2.id.tv_artist_sort_japan)
	TextView mTvSortJapan;
	@BindView(R2.id.tv_artist_sort_korea)
	TextView mTvSortKorea;
	@BindView(R2.id.tv_artist_sort_other)
	TextView mTvSortOther;
	@BindView(R2.id.tv_artist_sort_male)
	TextView mTvSortMale;
	@BindView(R2.id.tv_artist_sort_female)
	TextView mTvSortFemale;
	@BindView(R2.id.tv_artist_sort_group)
	TextView mTvSortGroup;
	@BindView(R2.id.rv_artist_sort)
	RecyclerView mRvArtistSort;

	private int topPosition = -1;
	private int bottomPosition = -1;

	private TextView[] mTopTextViewArray = new TextView[5];
	private TextView[] mBottomTextViewArray = new TextView[4];

	private ArtistSortAdapter mAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_artist_sort;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		initSortView();

		RequestCenter.getHotSingerList(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				ArtistListBean bean = (ArtistListBean) responseObj;
				mAdapter = new ArtistSortAdapter(bean.getArtists());
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						TopListDetailBean.Artist entity = (TopListDetailBean.Artist) baseQuickAdapter.getItem(i);
						getSupportDelegate().start(ArtistDetailDelegate.newInstance(String.valueOf(entity.getId())));
					}
				});
				mRvArtistSort.setAdapter(mAdapter);
				mRvArtistSort.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

	}

	private void initSortView() {

		//area
		mTvSortChina.setTag(1);
		mTvSortWest.setTag(2);
		mTvSortJapan.setTag(3);
		mTvSortKorea.setTag(4);
		mTvSortOther.setTag(0);
		//type
		mTvSortMale.setTag(1);
		mTvSortFemale.setTag(2);
		mTvSortGroup.setTag(3);
		mTopTextViewArray[1] = mTvSortChina;
		mTopTextViewArray[2] = mTvSortWest;
		mTopTextViewArray[3] = mTvSortJapan;
		mTopTextViewArray[4] = mTvSortKorea;
		mTopTextViewArray[0] = mTvSortOther;
		mBottomTextViewArray[1] = mTvSortMale;
		mBottomTextViewArray[2] = mTvSortFemale;
		mBottomTextViewArray[3] = mTvSortGroup;
	}

	@OnClick(R2.id.img_artist_sort_back)
	void onClickPop(){
		getSupportDelegate().pop();
	}

	@OnClick({R2.id.tv_artist_sort_china, R2.id.tv_artist_sort_west,R2.id.tv_artist_sort_japan,R2.id.tv_artist_sort_korea,R2.id.tv_artist_sort_other})
	void onClickChooseTop(View view){
		TextView textView = (TextView) view;
		int top = (int) textView.getTag();
		topPosition = top;
		mTopTextViewArray[top].setTextColor(Color.RED);
		for(int i = 0; i < mTopTextViewArray.length; i++){
			if(mTopTextViewArray[i] != null && i != topPosition){
				mTopTextViewArray[i].setTextColor(Color.GRAY);
			}
		}
		if(bottomPosition == -1){
			//初始点击时
			bottomPosition = 1;
			mBottomTextViewArray[bottomPosition].setTextColor(Color.RED);
		}
		reloadArtistSortRecyclerView(topPosition, bottomPosition);
	}

	@OnClick({R2.id.tv_artist_sort_male, R2.id.tv_artist_sort_female,R2.id.tv_artist_sort_group})
	void onClickChooseBottom(View view){
		TextView textView = (TextView) view;
		int bottom = (int) textView.getTag();
		bottomPosition = bottom;
		mBottomTextViewArray[bottom].setTextColor(Color.RED);
		for(int i = 0; i < mBottomTextViewArray.length; i++){
			if(mBottomTextViewArray[i] != null && i != bottomPosition){
				mBottomTextViewArray[i].setTextColor(Color.GRAY);
			}
		}
		if(topPosition == -1){
			//初始点击时
			topPosition = 1;
			mTopTextViewArray[topPosition].setTextColor(Color.RED);
		}
		reloadArtistSortRecyclerView(topPosition, bottomPosition);
	}


	void reloadArtistSortRecyclerView(int top, int bottom){
		RequestCenter.getSingerList(bottom, top, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				ArtistListBean bean = (ArtistListBean) responseObj;
				mAdapter.setNewData(bean.getArtists());
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	static class ArtistSortAdapter extends BaseQuickAdapter<TopListDetailBean.Artist, BaseViewHolder>{

		ArtistSortAdapter(@Nullable List<TopListDetailBean.Artist> data) {
			super(R.layout.item_singer_normal, data);
		}

		@Override
		protected void convert(@NonNull final BaseViewHolder adapter, final TopListDetailBean.Artist item) {
			//是否已关注
			if(item.isFollowed()){
				adapter.setVisible(R.id.ll_singer_followed, true);
			}else{
				adapter.setVisible(R.id.ll_singer_follow, true);
			}
			adapter.setText(R.id.tv_singer_name,item.getName());

			ImageLoaderManager.getInstance().displayImageForCircle((ImageView) adapter.getView(R.id.iv_singer_avatar), item.getPicUrl());
			//取消关注
			adapter.setOnClickListener(R.id.ll_singer_followed, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					RequestCenter.getSubArtist(String.valueOf(item.getId()), false, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							DjSubBean bean = (DjSubBean) responseObj;
							if(bean.getCode() == 200){
								//取消成功
								adapter.setVisible(R.id.ll_singer_followed, false);
								adapter.setVisible(R.id.ll_singer_follow, true);
							}
						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});
				}
			});
			//关注歌手
			adapter.setOnClickListener(R.id.ll_singer_follow, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					RequestCenter.getSubArtist(String.valueOf(item.getId()), true, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							DjSubBean bean = (DjSubBean) responseObj;
							if(bean.getCode() == 200){
								//关注成功
								adapter.setVisible(R.id.ll_singer_followed, true);
								adapter.setVisible(R.id.ll_singer_follow, false);
							}
						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});
				}
			});
		}
	}


}
