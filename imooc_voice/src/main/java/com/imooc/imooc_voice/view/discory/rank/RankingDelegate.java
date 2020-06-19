package com.imooc.imooc_voice.view.discory.rank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.TopListBean;
import com.imooc.lib_api.model.TopListDetailBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.imooc.lib_common_ui.utils.Constants.PLAYLIST;

public class RankingDelegate extends NeteaseDelegate {

	@BindView(R2.id.rv_rank_offical)
	RecyclerView mRvRankOffical;
	@BindView(R2.id.rv_rank_normal)
	RecyclerView mRvRankNoraml;

	private RankOfficalAdapter mRankOfficalAdapter;
	private RankNormalAdapter mRankNomalAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_rank;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		//官方榜单 带歌曲名
		RequestCenter.getTopListDetail(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				TopListDetailBean bean = (TopListDetailBean) responseObj;
				List<TopListDetailBean.ListBean> list = bean.getList();
				mRankOfficalAdapter = new RankOfficalAdapter(list.subList(0,4));
				mRvRankOffical.setAdapter(mRankOfficalAdapter);
				mRvRankOffical.setLayoutManager(new LinearLayoutManager(getContext()));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

		RequestCenter.getTopList(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				TopListBean bean = (TopListBean) responseObj;
				List<TopListBean.ListBean> list = bean.getList();
				mRankNomalAdapter = new RankNormalAdapter(list.subList(4, list.size()));
				mRvRankNoraml.setAdapter(mRankNomalAdapter);
				mRankNomalAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adpater, View view, int i) {
						TopListBean.ListBean entity = (TopListBean.ListBean) adpater.getItem(i);
						getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, entity.getId()));
					}
				});
				mRvRankNoraml.setLayoutManager(new GridLayoutManager(getContext(), 3));
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@OnClick(R2.id.img_rank_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}

	static class RankOfficalAdapter extends BaseQuickAdapter<TopListDetailBean.ListBean, BaseViewHolder>{
		private ImageLoaderManager manager;
		RankOfficalAdapter( @Nullable List<TopListDetailBean.ListBean> data) {
			super(R.layout.item_rank_offical, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, TopListDetailBean.ListBean item) {
			manager.displayImageForCorner(adapter.getView(R.id.iv_item_rank_cover_image), item.getCoverImgUrl());
			adapter.setText(R.id.tv_item_rank_update_frequency, item.getUpdateFrequency());
			adapter.setText(R.id.tv_item_rank_first_txt, "1." +item.getTracks().get(0).getFirst()+" - "+item.getTracks().get(0).getSecond());
			adapter.setText(R.id.tv_item_rank_second_txt, "2." +item.getTracks().get(1).getFirst()+" - "+item.getTracks().get(1).getSecond());
			adapter.setText(R.id.tv_item_rank_third_txt, "3." +item.getTracks().get(2).getFirst()+" - "+item.getTracks().get(2).getSecond());

		}
	}
	static class RankNormalAdapter extends BaseQuickAdapter<TopListBean.ListBean, BaseViewHolder>{
		private ImageLoaderManager manager;
		public RankNormalAdapter(@Nullable List<TopListBean.ListBean> data) {
			super(R.layout.item_rank_normal, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, TopListBean.ListBean item) {
			manager.displayImageForCorner(adapter.getView(R.id.iv_item_rank_cover_image), item.getCoverImgUrl());
			adapter.setText(R.id.tv_item_rank_update_frequency, item.getUpdateFrequency());
			adapter.setText(R.id.tv_item_rank_name, item.getName());

		}
	}
}
