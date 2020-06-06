package com.imooc.imooc_voice.view.login;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.ScreenUtils;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.view.home.BaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

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
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		startCountDownTime();
	}

	private void startCountDownTime() {
		final CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
			@Override
			public void onTick(long millisUntilFinished) {

			}

			@Override
			public void onFinish() {
				String authToken = SharePreferenceUtil.getInstance(getContext()).getAuthToken("");
				if (TextUtils.isEmpty(authToken)) {
					getSupportDelegate().startWithPop(new LoginDelegate());
				} else {
					getSupportDelegate().startWithPop(new BaseDelegate());
				}

			}
		};
		countDownTimer.start();
	}

}
