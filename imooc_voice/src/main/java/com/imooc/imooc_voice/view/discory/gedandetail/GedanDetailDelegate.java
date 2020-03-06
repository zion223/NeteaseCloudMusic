package com.imooc.imooc_voice.view.discory.gedandetail;

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
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;

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
	@BindView(R2.id.tv_gedan_detail_tag)
	TextView mTvDetailTag;
	@BindView(R2.id.toolbar_gedan_detail)
	Toolbar mToolBar;
	@BindView(R2.id.iv_gedan_detail_img)
	ImageView mImageViewGedan;
	@BindView(R2.id.rl_toolbar_gedan_detail)
	RelativeLayout mRlToolbar;
	@BindView(R2.id.collapsing_toolbar_layout)
	CollapsingToolbarLayout mCollspsingToolbar;
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
				float alpha = (1 - num) * 255;
				mCollspsingToolbar.setAlpha(alpha);

			}
		});

		RequestCenter.queryGedanDetail(id, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				GedanDetailJson json = (GedanDetailJson) responseObj;
				mTvDetailTitle.setText(json.getTitle());
				mTvDetailDesc.setText(json.getDesc());
				mTvDetailTag.setText(json.getTag());
				manager.displayImageForCorner(mImageViewGedan, json.getPic300(), 5);
				//毛玻璃效果背景
				manager.displayImageForViewGroup(mCollspsingToolbar, json.getPic300(), 200);
				ArrayList<GedanDetailJson.GeDanDetail> content = json.getContent();
				mAdapter = new GedanDetailAdapter(content);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						GedanDetailJson.GeDanDetail item = (GedanDetailJson.GeDanDetail) adapter.getItem(position);
						String songId = item.getSongid();
						//加入播放队列
					}
				});
				mRecyclerViewGedan.setAdapter(mAdapter);
				mRecyclerViewGedan.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public void post(Runnable runnable) {

	}
}
