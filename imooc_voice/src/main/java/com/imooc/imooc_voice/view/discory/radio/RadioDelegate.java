package com.imooc.imooc_voice.view.discory.radio;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.BannerBean;
import com.imooc.imooc_voice.model.newapi.DjBannerBean;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.view.discory.radio.pay.RadioPayDelegate;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.bannder.BannerCreator;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RadioDelegate extends NeteaseLoadingDelegate {


	@BindView(R2.id.banner_radio_recycler_item)
	ConvenientBanner banner;
	@BindView(R2.id.loadframe)
	FrameLayout frameLayout;

	private View rootView;
	private RecyclerView mRecyclerViewRadio;

	@Override
	public Object setLayout() {
		return R.layout.delegate_radio;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);
		rootView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_radio_loading, frameLayout, false);

		RequestCenter.getRadioBanner(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				DjBannerBean bannerBean = (DjBannerBean) responseObj;
				List<DjBannerBean.BannersBean> banners = bannerBean.getBanners();
				ArrayList<String> bannerList = new ArrayList<>();
				for(DjBannerBean.BannersBean item: banners){
					bannerList.add(item.getPic());
				}
				BannerCreator.setDefault(banner, bannerList, null);
			}

			@Override
			public void onFailure(Object reasonObj) {
			}
		});
		initRadioView();

	}

	@SuppressLint("StaticFieldLeak")
	private void initRadioView() {
		new AsyncTask<Void,Void,Void>(){

			@Override
			protected Void doInBackground(Void... voids) {

				return null;
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
				Netease.getHandler().postDelayed(new Runnable() {
					@Override
					public void run() {
						frameLayout.removeAllViews();
						//framelayout 创建了新的实例
						ViewGroup p = (ViewGroup) rootView.getParent();
						if (p != null) {
							p.removeAllViewsInLayout();
						}
						frameLayout.addView(rootView);
					}
				}, 500);
			}
		}.execute();
	}

	@Override
	public void post(Runnable runnable) {

	}

	@OnClick(R2.id.ll_radio_pay)
	void onClickRadioPay(){
		//付费精品
		getSupportDelegate().start(new RadioPayDelegate());
	}

	@OnClick(R2.id.img_radio_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}
}
