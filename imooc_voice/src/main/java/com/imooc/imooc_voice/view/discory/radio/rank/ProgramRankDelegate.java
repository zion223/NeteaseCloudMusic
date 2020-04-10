package com.imooc.imooc_voice.view.discory.radio.rank;

import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.dj.DjProgramTopListBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

//节目榜
public class ProgramRankDelegate extends NeteaseLoadingDelegate {

	//24小时榜
	//最热节目

	@Override
	public void initView() {
		RequestCenter.getRadioProgramTopHours(3, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjProgramTopListBean bean = (DjProgramTopListBean) responseObj;
				ArrayList<DjProgramTopListBean.List> list = bean.getData().getList();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return 0;
	}
}
