package com.imooc.imooc_voice.view.discory.radio.rank;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjProgramTopListBean;
import com.imooc.lib_api.model.dj.DjProgramTopListHoursBean;
import com.imooc.lib_api.model.dj.DjRankListBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

//电台排行榜单详情
public class RankListDetailDelegate extends NeteaseLoadingDelegate {


	private RecyclerView recyclerView;
	private View mHeaderView;

	/**
	 *  主播榜 24小时榜  新人榜
	 *  节目榜 24小时榜
	 *  电台榜 付费精品榜
	 */

	@Override
	public void initView() {
		recyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		//更新时间
		mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.item_rank_dj_popular_header, null, false);

		//主播榜 - 24小时榜
		RequestCenter.getRadioTopHours(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjRankListBean bean = (DjRankListBean) responseObj;
				initDjTopView(bean);
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		//主播榜 - 新人榜
		RequestCenter.getRadioTopNewComer(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjRankListBean bean = (DjRankListBean) responseObj;
				initDjTopView(bean);
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

		//节目榜 - 24小时榜
		RequestCenter.getRadioProgramTopHours(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjProgramTopListHoursBean bean = (DjProgramTopListHoursBean) responseObj;
				//list
				ArrayList<DjProgramTopListBean.List> list = bean.getData().getList();
				ProgramRankDelegate.ProgramHoursRankAdapter mHoursAdapter = new ProgramRankDelegate.ProgramHoursRankAdapter(list);
				GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
				recyclerView.setLayoutManager(manager);
				mHoursAdapter.setHeaderView(mHeaderView);
				recyclerView.setAdapter(mHoursAdapter);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});


	}

	//主播榜 24小时榜 新人榜
	private void initDjTopView(DjRankListBean bean) {
		List<DjRankListBean.List> popularData = bean.getData().getList();
		DjRankDelegate.DjPopularAdapter mPopularAdapter = new DjRankDelegate.DjPopularAdapter(popularData);
		//mPopularAdapter.setOnItemClickListener(DjRankDelegate.this);
		mPopularAdapter.setHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.item_rank_dj_popular_header, null, false));
		recyclerView.setAdapter(mPopularAdapter);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
			@Override
			public boolean canScrollVertically() {
				return false;
			}
		};
		recyclerView.setLayoutManager(linearLayoutManager);
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}
}
