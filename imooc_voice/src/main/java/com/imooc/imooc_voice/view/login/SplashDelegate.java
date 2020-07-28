package com.imooc.imooc_voice.view.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.ScreenUtils;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;
import com.imooc.imooc_voice.view.home.HomeDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SplashDelegate extends NeteaseDelegate {

	@Override
	public Object setLayout() {
		return R.layout.delegate_splash;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		ScreenUtils.setStatusBarColor(getProxyActivity(), Color.parseColor("#Db2C1F"));
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		Observable.timer(2, TimeUnit.SECONDS)
				.subscribe(new Observer<Long>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(Long aLong) {
						String authToken = SharePreferenceUtil.getInstance(getContext()).getAuthToken("");
						if (TextUtils.isEmpty(authToken)) {
							getSupportDelegate().startWithPop(new LoginDelegate());
						} else {
							getSupportDelegate().startWithPop(new HomeDelegate());
						}
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}


}
