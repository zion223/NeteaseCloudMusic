package com.imooc.imooc_voice.view.discory.radio;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.BannerBean;
import com.imooc.imooc_voice.model.newapi.DjBannerBean;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.view.discory.radio.pay.RadioPayDelegate;
import com.imooc.lib_common_ui.bannder.BannerCreator;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RadioDelegate extends NeteaseDelegate {


	@BindView(R2.id.banner_radio_recycler_item)
	ConvenientBanner banner;

	@Override
	public Object setLayout() {
		return R.layout.delegate_radio;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		RequestCenter.getRadioBanner(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				DjBannerBean bannerBean = (DjBannerBean) responseObj;
				List<DjBannerBean.BannersBean> banners = bannerBean.getBanners();
				ArrayList<String> bannerList = new ArrayList<>();
				for(DjBannerBean.BannersBean item: banners){
					bannerList.add(item.getPic());
				}
				//TODO 设置Banner的点击事件
				BannerCreator.setDefault(banner, bannerList, null);
			}

			@Override
			public void onFailure(Object reasonObj) {
			}
		});
	}

	@Override
	public void post(Runnable runnable) {

	}

	@OnClick(R2.id.ll_radio_pay)
	void onClickRadioPay(){
		//付费精品
		getSupportDelegate().start(new RadioPayDelegate());
	}
}
