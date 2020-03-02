package com.imooc.imooc_voice.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.login.LoginEvent;
import com.imooc.imooc_voice.model.user.User;
import com.imooc.lib_common_ui.base.BaseActivity;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends BaseActivity {

	public static void start(Context context) {
		Intent intent = new Intent(context, LoginActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delegate_login);
		findViewById(R.id.login_view).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RequestCenter.login(new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						User user = (User) responseObj;
						UserManager.getInstance().saveUser(user);
						EventBus.getDefault().post(new LoginEvent());
						finish();
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
			}
		});
	}
}
