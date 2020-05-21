package com.imooc.imooc_voice.view.video.mv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.MvBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.dialog.MvSortDialog;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//MV分类
public class MvSortDelegate extends NeteaseDelegate {


	//默认 全部 全部 上升最快
	@BindView(R2.id.rv_mv_sort)
	RecyclerView mRecyclerView;
	@BindView(R2.id.tv_mv_sort_title)
	TextView mTvSortTitle;
	private MvSortAdapter mAdapter;
	private BasePopupView mSortDialog;

	private String area = "全部";
	private String type = "全部";
	private String order = "上升最快";

	@Override
	public Object setLayout() {
		return R.layout.delegate_mv_sort;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		mSortDialog = new XPopup.Builder(getContext())
				.offsetY(100)
				.popupAnimation(PopupAnimation.TranslateFromTop)
				.asCustom(new MvSortDialog(getContext(), new MvSortDialog.OnItemChooseListener() {
					@Override
					public void onItemChoose(String area, String type, String order) {
						loadMvView(area, type, order);
					}
				}));
		loadMvView(area, type,order);
	}


	@SuppressLint("SetTextI18n")
	private void loadMvView(String areaa, String typee, String orderr){
		mTvSortTitle.setText(areaa + "•" +typee + "•" +orderr);
		RequestCenter.getAllMv(areaa, typee, orderr, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				MvBean bean = (MvBean) responseObj;
				ArrayList<MvBean.MvDetailBean> data = bean.getData();
				mAdapter = new MvSortAdapter(data);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int i) {
						MvBean.MvDetailBean entity = (MvBean.MvDetailBean) adapter.getItem(i);
						getParentDelegate().getSupportDelegate().start(MvDeatilDelegate.newInstance(entity.getId()));
					}
				});
				GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
				mRecyclerView.setLayoutManager(manager);
				mRecyclerView.setAdapter(mAdapter);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@OnClick(R2.id.tv_mv_sort_dialog)
	void onClickSort(){
		mSortDialog.show();
	}

	@OnClick(R2.id.img_tab_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}

	static class MvSortAdapter extends BaseQuickAdapter<MvBean.MvDetailBean, BaseViewHolder>{

		MvSortAdapter(@Nullable List<MvBean.MvDetailBean> data) {
			super(R.layout.item_mv_normal, data);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, MvBean.MvDetailBean item) {
			ImageLoaderManager.getInstance().displayImageForCorner(adapter.getView(R.id.iv_item_mv_cover), item.getCover());
			//播放量
			adapter.setText(R.id.tv_item_mv_playnum, SearchUtil.getCorresPondingString(item.getPlayCount()));
			//视频时间
			adapter.setText(R.id.tv_item_mv_time, TimeUtil.getTimeNoYMDH(item.getDuration()));
			//MV名字
			adapter.setText(R.id.tv_item_mv_name, item.getName());
			adapter.setText(R.id.tv_item_mv_creator, item.getArtistName());
		}
	}


}
