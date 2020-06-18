package com.imooc.imooc_voice.view.discory.radio.rank;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.discory.radio.detail.RadioDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjSubListBean;
import com.imooc.lib_api.model.dj.DjTopListBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;


public class RadioRankDelegate extends NeteaseLoadingDelegate {


	private RecyclerView mRecyclerView;

	private RadioRankAdapter mAdapter;


	@Override
	public void initView() {

		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		View mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.item_rank_dj_popular_header, null, false);
		((TextView)mHeaderView.findViewById(R.id.tv_item_dj_rank_hours_title)).setText("最热电台");

		RequestCenter.getDjToplist("hot", new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjTopListBean topListBean = (DjTopListBean) responseObj;
				ArrayList<DjSubListBean.DjRadios> toplist = topListBean.getToplist();
				mAdapter = new RadioRankAdapter(toplist);
                mAdapter.setOnItemClickListener((adapter, view, position) -> {
                    DjSubListBean.DjRadios entity = (DjSubListBean.DjRadios) adapter.getItem(position);
                    getParentDelegate().getSupportDelegate().start(RadioDetailDelegate.newInstance(entity.getId()));
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
		return R.layout.delegate_recyclerview_normal;
	}


	private static class RadioRankAdapter extends BaseQuickAdapter<DjSubListBean.DjRadios, BaseViewHolder>{

		public RadioRankAdapter(@Nullable List<DjSubListBean.DjRadios> data) {
			super(R.layout.item_radio_rank, data);
		}

		@Override
		protected void convert(BaseViewHolder adapter, DjSubListBean.DjRadios item) {

			adapter.setText(R.id.tv_item_radio_rank_rank, String.valueOf(item.getRank()));
			adapter.setText(R.id.tv_item_radio_name, item.getName());
			adapter.setText(R.id.iv_item_radio_rank_djname, item.getDj().getNickname());
			//分数
			adapter.setText(R.id.iv_item_radio_rank_score, String.valueOf(item.getScore()));

			//排名变化
			int diffRank = item.getLastRank() - item.getRank();
			if(diffRank != 0){
				if(diffRank > 0){
					adapter.setImageResource(R.id.iv_item_radio_diff, R.drawable.ic_rank_up);
				}else{
					adapter.setImageResource(R.id.iv_item_radio_diff, R.drawable.ic_rank_down);
				}
			}else{
				adapter.setImageResource(R.id.iv_item_radio_diff, R.drawable.ic_diff_none);
			}
			//排名
			if(item.getRank() < 4){
				adapter.setTextColor(R.id.tv_item_radio_rank_rank, Color.RED);
			}
			if(item.getRank() > 9){
				((TextView)adapter.getView(R.id.tv_item_radio_rank_rank)).setTextSize(16);
				((TextView)adapter.getView(R.id.tv_item_radio_rank_rank)).setTypeface(Typeface.DEFAULT);
			}

			//排名变化
			adapter.setText(R.id.tv_item_radio_rank_diff, String.valueOf(Math.abs(diffRank)));
			//节目封面
			ImageLoaderManager.getInstance().displayImageForCorner(adapter.getView(R.id.iv_item_radio_img), item.getPicUrl());

		}
	}

}
