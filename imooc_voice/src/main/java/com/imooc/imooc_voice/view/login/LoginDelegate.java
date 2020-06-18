package com.imooc.imooc_voice.view.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import butterknife.OnClick;

public class LoginDelegate extends NeteaseDelegate {


	@Override
	public Object setLayout() {
		return R.layout.delegate_login;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {

	}

	//手机登录
	@OnClick(R2.id.login_phone)
	void onClickLoginPhone(){
		getSupportDelegate().start(new PhoneLoginDelegate());
	}


	@OnClick(R2.id.login_experience)
	void onClickExPerience(){
		//TODO 立即体验 需点击同意用户协议 checkbox 晃动
		//getSupportDelegate().startWithPop(new BaseDelegate());
	}



}
