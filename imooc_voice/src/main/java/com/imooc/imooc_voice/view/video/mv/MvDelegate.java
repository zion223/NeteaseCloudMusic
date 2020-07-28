package com.imooc.imooc_voice.view.video.mv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.mv.MvTopBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import butterknife.BindView;
import butterknife.OnClick;

public class MvDelegate extends NeteaseDelegate {

	/**
	 * 	MV 精选 更多MV
	 * 	排行榜
	 * 	更多精彩MV MV分类MVSortDelagate 全部MV
	 *
	 */

	@BindView(R2.id.tv_mv_rank_time)
	TextView mTvRankUpdateTime;
	@BindView(R2.id.iv_mv_rank_img)
	ImageView mIvRankImg;

	@Override
	public Object setLayout() {
		return R.layout.delegate_mv_normal;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {

		//排行榜信息
		RequestCenter.getMvTop(new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				MvTopBean bean = (MvTopBean) responseObj;
				//更新时间
				mTvRankUpdateTime.setText("更新时间 : " + TimeUtil.getTimeStandardOnlyMDChinese(bean.getUpdateTime()));
				//排行榜右侧的图片
				ImageLoaderManager.getInstance().displayImageForView(mIvRankImg, bean.getData().get(0).getCover());
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}


	//MV排行榜
	@OnClick(R2.id.rl_mv_rank)
	void onClickRank(){
		getParentDelegate().getParentDelegate().getSupportDelegate().start(new MvRankTabDelegate());
	}


	//更多MV
	@OnClick(R2.id.tv_mv_more)
	void onClickMoreMv(){
		getParentDelegate().getParentDelegate().getSupportDelegate().start(new MvMoreDelegate());
	}

	//MV分类
	@OnClick(R2.id.tv_mv_sort)
	void onClickSort(){
		getParentDelegate().getParentDelegate().getSupportDelegate().start(new MvSortDelegate());
	}
}
