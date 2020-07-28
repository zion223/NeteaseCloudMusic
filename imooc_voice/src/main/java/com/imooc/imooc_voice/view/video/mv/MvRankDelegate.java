package com.imooc.imooc_voice.view.video.mv;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.mv.MvTopBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

public class MvRankDelegate extends NeteaseLoadingDelegate {


	private static final String ARGS_MV_RANK_AREA = "ARGS_MV_RANK_AREA";


	//地区
	private String area;
	private	MvTopAdapter mAdapter;
	private RecyclerView mRecyclerView;

	public static MvRankDelegate newInstance(String area) {
		final Bundle args = new Bundle();
		args.putString(ARGS_MV_RANK_AREA, area);
		final MvRankDelegate delegate = new MvRankDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			area = args.getString(ARGS_MV_RANK_AREA);
		}
	}

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		final View headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_multiple_search_header, null, false);
		RequestCenter.getMvTop(area, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				MvTopBean bean = (MvTopBean) responseObj;
				ArrayList<MvTopBean.MvTopDetailBean> data = bean.getData();
				((TextView)headerView.findViewById(R.id.tv_item_multiple_search_header)).setText("更新时间: " + TimeUtil.getTimeStandardOnlyMDChinese(bean.getUpdateTime()));
				mAdapter = new MvTopAdapter(data);
				mAdapter.setHeaderView(headerView);
				//MV详情
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int i) {
						MvTopBean.MvTopDetailBean entity = (MvTopBean.MvTopDetailBean) adapter.getItem(i);
						getParentDelegate().getParentDelegate().getSupportDelegate().start(MvDeatilDelegate.newInstance(entity.getId()));
					}
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


	static class MvTopAdapter extends BaseQuickAdapter<MvTopBean.MvTopDetailBean, BaseViewHolder>{

		MvTopAdapter(@Nullable List<MvTopBean.MvTopDetailBean> data) {
			super(R.layout.item_mv_rank_normal, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, MvTopBean.MvTopDetailBean item) {
			//封面
			ImageLoaderManager.getInstance().displayImageForCorner(adapter.getView(R.id.iv_item_mv_rank_avatar), item.getCover());
			//播放次数
			adapter.setText(R.id.tv_item_mv_playnum, SearchUtil.getCorresPondingString(item.getPlayCount()));
			//MV名
			adapter.setText(R.id.tv_mv_rank_mv_name, item.getName());
			//歌手名
			adapter.setText(R.id.tv_mv_rank_artist_name, item.getArtistName());

			//排名
			int currentRank = adapter.getLayoutPosition();
			int diff = currentRank - item.getLastRank();

			if(diff != 0){
				if(diff > 0){
					adapter.setImageResource(R.id.iv_item_mv_rank_diff, R.drawable.ic_rank_up);
				}else{
					adapter.setImageResource(R.id.iv_item_mv_rank_diff, R.drawable.ic_rank_down);
				}
			}else{
				adapter.setImageResource(R.id.iv_item_mv_rank_diff, R.drawable.ic_diff_none);
			}
			adapter.setText(R.id.tv_item_mv_rank_diff, String.valueOf(Math.abs(diff)));
			//排行榜前三
			if(currentRank < 4){
				adapter.setTextColor(R.id.tv_mv_rank, Color.RED);
			}
			adapter.setText(R.id.tv_mv_rank, String.valueOf(currentRank));

		}
	}
}
