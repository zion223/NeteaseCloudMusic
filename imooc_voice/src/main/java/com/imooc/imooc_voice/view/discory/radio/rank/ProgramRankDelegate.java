package com.imooc.imooc_voice.view.discory.radio.rank;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjProgramTopListBean;
import com.imooc.lib_api.model.dj.DjProgramTopListHoursBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

//节目榜
public class ProgramRankDelegate extends NeteaseLoadingDelegate {

	//24小时榜
	//最热节目

	private View mProgramHotHeaderView;
	private View mProgramHoursHeaderView;

	private RecyclerView mRvProgramHot;
	private RecyclerView mRvProgramHours;

	private ProgramHoursRankAdapter mHoursAdapter;
	private ProgramRankAdapter mAdapter;

	@Override
	public void initView() {

		mProgramHotHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.item_rank_dj_popular_header, null, false);
		mProgramHoursHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.item_dj_rank_hours_header, null, false);

		((TextView)mProgramHotHeaderView.findViewById(R.id.tv_item_dj_rank_hours_title)).setText("最热节目");
		((TextView)mProgramHoursHeaderView.findViewById(R.id.tv_item_dj_rank_hours_title)).setText("24小时榜");

		mRvProgramHot = rootView.findViewById(R.id.rv_radio_dj_rank_popular);
		mRvProgramHours = rootView.findViewById(R.id.rv_radio_dj_rank_123);

		RequestCenter.getRadioProgramTopHours(3, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjProgramTopListHoursBean bean = (DjProgramTopListHoursBean) responseObj;
				//list
				ArrayList<DjProgramTopListBean.List> list = bean.getData().getList();
				mHoursAdapter = new ProgramHoursRankAdapter(list);
				GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
				mRvProgramHours.setLayoutManager(manager);
				mHoursAdapter.setHeaderView(mProgramHoursHeaderView);
				mRvProgramHours.setAdapter(mHoursAdapter);

				RequestCenter.getRadioProgramTopList(20, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						DjProgramTopListBean bean = (DjProgramTopListBean) responseObj;
						//toplist
						ArrayList<DjProgramTopListBean.List> list = bean.getToplist();
						mAdapter = new ProgramRankAdapter(list);
						mAdapter.addHeaderView(mProgramHotHeaderView);
						mRvProgramHot.setLayoutManager(new LinearLayoutManager(getContext()));
						mRvProgramHot.setAdapter(mAdapter);
						addRootView();
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});


	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_radio_dj_rank;
	}

	static class ProgramHoursRankAdapter extends BaseQuickAdapter<DjProgramTopListBean.List, BaseViewHolder> {

		ProgramHoursRankAdapter(@Nullable List<DjProgramTopListBean.List> data) {
			super(R.layout.item_program_rank_123, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, DjProgramTopListBean.List item) {
			ImageLoaderManager.getInstance().displayImageForCorner(adapter.getView(R.id.iv_item_program_rank_avatar), item.getProgram().getCoverUrl());
			adapter.setText(R.id.tv_item_rank_program_name, item.getProgram().getName());
		}
	}

	static class ProgramRankAdapter extends BaseQuickAdapter<DjProgramTopListBean.List, BaseViewHolder>{

		ProgramRankAdapter(@Nullable List<DjProgramTopListBean.List> data) {
			super(R.layout.item_program_rank_normal, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, DjProgramTopListBean.List item) {

			adapter.setText(R.id.tv_item_program_rank_rank, String.valueOf(item.getRank()));
			adapter.setText(R.id.tv_item_program_rank_name, item.getProgram().getName());
			adapter.setText(R.id.tv_item_program_rank_djname, item.getProgram().getDj().getNickname());
			//分数
			adapter.setText(R.id.tv_item_program_rank_score, String.valueOf(item.getScore()));

			//排名变化
			int diffRank = item.getLastRank() - item.getRank();
			if(diffRank != 0){
				if(diffRank > 0){
					adapter.setImageResource(R.id.iv_item_program_diff, R.drawable.ic_rank_up);
				}else{
					adapter.setImageResource(R.id.iv_item_program_diff, R.drawable.ic_rank_down);
				}
			}else{
				adapter.setImageResource(R.id.iv_item_program_diff, R.drawable.ic_diff_none);
			}
			//排名
			if(item.getRank() < 4){
				adapter.setTextColor(R.id.tv_item_program_rank_rank, Color.RED);
			}
			if(item.getRank() > 9){
				((TextView)adapter.getView(R.id.tv_item_program_rank_rank)).setTextSize(16);
				((TextView)adapter.getView(R.id.tv_item_program_rank_rank)).setTypeface(Typeface.DEFAULT);
			}

			//排名变化
			adapter.setText(R.id.tv_item_program_rank_diff, String.valueOf(Math.abs(diffRank)));
			//节目封面
			ImageLoaderManager.getInstance().displayImageForCorner(adapter.getView(R.id.iv_item_program_img), item.getProgram().getCoverUrl());
			ImageLoaderManager.getInstance().displayImageForCircle(adapter.getView(R.id.iv_item_program_rank_djavatar), item.getProgram().getDj().getAvatarUrl());


		}
	}
}
