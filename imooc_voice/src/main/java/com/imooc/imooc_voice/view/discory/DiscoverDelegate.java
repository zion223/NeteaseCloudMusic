package com.imooc.imooc_voice.view.discory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.FocusJson;
import com.imooc.lib_common_ui.bannder.BannerCreator;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

import butterknife.BindView;

public class DiscoverDelegate extends NeteaseDelegate {


	/**
	 * 发现页面
	 * 		轮播图
	 * 		每日推荐、歌单、排行榜、电台、私人FM
	 * 		推荐歌单
	 * 		新碟 新歌  新歌推荐
	 *
	 */

	@BindView(R2.id.banner_recycler_item)
	ConvenientBanner convenientBanner;

	@Override
	public Object setLayout() {
		return R.layout.delegate_discover;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		RequestCenter.queryBanner(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				FocusJson json = ((FocusJson)responseObj);
				ArrayList<FocusJson.Focus> pic = json.getPic();
				ArrayList<String> banner = new ArrayList<>();
				for(FocusJson.Focus item: pic){
					String itempic = item.getRandpic();
					banner.add(itempic);
				}
				BannerCreator.setDefault(convenientBanner, banner, null);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

	}


	@Override
	public void post(Runnable runnable) {

	}
}
