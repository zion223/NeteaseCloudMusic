package com.imooc.imooc_voice.view.login;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.event.RequestSuccessEvent;
import com.imooc.imooc_voice.model.newapi.CommonMessageBean;
import com.imooc.imooc_voice.model.newapi.LoginBean;
import com.imooc.imooc_voice.util.ScreenUtils;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.util.ValidateUtils;
import com.imooc.imooc_voice.view.home.BaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.widget.CaptchaView;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class PhoneLoginDelegate extends NeteaseDelegate {

	@BindView(R2.id.et_login_phone)
	TextInputEditText mPhone;
	@BindView(R2.id.rv_login_password)
	LinearLayout mLvPassword;
	@BindView(R2.id.rv_login_phone)
	RelativeLayout mRlPhone;
	@BindView(R2.id.et_login_password)
	EditText mEtPassword;
	@BindView(R2.id.tv_login_forget)
	TextView mTvForgetPass;
	@BindView(R2.id.tv_login_login)
	TextView mTvLogin;
	@BindView(R2.id.tv_login_title)
	TextView mTvTitle;
	@BindView(R2.id.captcha_view)
	CaptchaView mCaptchaView;
	@BindView(R2.id.tv_capcha_phone)
	TextView mTvCaptchaPhone;
	@BindView(R2.id.rl_captcha)
	RelativeLayout mRvCaptcha;
	@BindView(R2.id.tv_captcha_timer)
	TextView mTvTimer;

	private Timer timer;
	private TimerTask task;
	int seconds = 60;

	@Override
	public Object setLayout() {
		return R.layout.delegate_phone_login;
	}

	@Override
	public void onStart() {
		super.onStart();
		EventBus.getDefault().register(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		ScreenUtils.setStatusBarColor(getProxyActivity(), Color.parseColor("#ffffffff"));
		timer = new Timer();
		task = new TimerTask() {
			@Override
			public void run() {
				EventBus.getDefault().postSticky(new RequestSuccessEvent());
			}
		};
	}

	@SuppressLint("SetTextI18n")
	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
	public void timerArrived(RequestSuccessEvent event) {

		seconds = seconds - 1;
		if (seconds > 0) {
			mTvTimer.setText(seconds + "秒");
		} else {
			mTvTimer.setText("重新获取");
			timer.cancel();
		}
	}

	//下一步
	@OnClick(R2.id.tv_login_next)
	void onClickNext() {
		//TODO 判断手机号是否已经注册  若未注册过则直接注册
		if (ValidateUtils.isMobile(mPhone.getText().toString())) {
			mRlPhone.setVisibility(View.GONE);
			mLvPassword.setVisibility(View.VISIBLE);
		} else {
			Toast.makeText(getContext(), "请正确输入手机号", Toast.LENGTH_SHORT).show();
		}

	}

	//登录
	@OnClick(R2.id.tv_login_login)
	void onClickLogin() {
		final String phone = mPhone.getText().toString();
		final String password = mEtPassword.getText().toString();
		//中间四位是*
		final String phoneNumber = phone.substring(0, 3) + "****" + phone.substring(7);
		if (mTvLogin.getText().equals("下一步")) {
			//发送验证码 显示验证码输入界面
			RequestCenter.sendCaptcha(phone, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					CommonMessageBean bean = (CommonMessageBean) responseObj;
					if (bean.getCode() == 200) {
						//显示验证码发送至手机号
						mTvCaptchaPhone.setText(phoneNumber);
						mRvCaptcha.setVisibility(View.VISIBLE);

						mRlPhone.setVisibility(View.GONE);
						mLvPassword.setVisibility(View.GONE);
						//1分钟倒计时
						timer.schedule(task, 0, 1000);
					} else {
						Toast.makeText(getContext(), bean.getMessage(), Toast.LENGTH_SHORT).show();
					}


				}

				@Override
				public void onFailure(Object reasonObj) {

				}
			});
			//输入完毕验证码 进行登录并且修改密码
			mCaptchaView.setOnInputListener(new CaptchaView.OnInputListener() {
				@Override
				public void onSucess(String code) {
					RequestCenter.register(phone, code, password, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							LoginBean bean = (LoginBean) responseObj;
							if (bean.getCode() != 200) {
								//校验失败
								Toast.makeText(getContext(), bean.getMsg(), Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(getContext(), bean.getProfile().getNickname() + "登陆成功", Toast.LENGTH_LONG).show();
								SharePreferenceUtil.getInstance(getContext()).saveUserInfo(bean, phone);
								getSupportDelegate().start(new BaseDelegate());
							}

						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});
				}

				@Override
				public void onInput() {

				}
			});
		} else {

			RequestCenter.login(phone, password, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					LoginBean bean = (LoginBean) responseObj;
					if(bean.getCode() == 200){
						Toast.makeText(getContext(), bean.getProfile().getNickname() + "登陆成功", Toast.LENGTH_LONG).show();
						SharePreferenceUtil.getInstance(getContext()).saveUserInfo(bean, phone);
						getSupportDelegate().startWithPop(new BaseDelegate());
					}else{
						Toast.makeText(getContext(), bean.getMsg(), Toast.LENGTH_LONG).show();
					}

				}

				@Override
				public void onFailure(Object reasonObj) {
					Toast.makeText(getContext(), "密码或用户名输入错误", Toast.LENGTH_SHORT).show();
				}
			});
		}

	}


	//忘记密码
	@OnClick(R2.id.tv_login_forget)
	void onClickForget() {
		//更改密码 后发送验证码
		mTvForgetPass.setVisibility(View.GONE);
		mTvLogin.setText("下一步");
		mEtPassword.setHint("设置登录密码,密码不少于六位");
		mTvTitle.setText("忘记密码");
	}

	@OnClick(R2.id.img_tab_back)
	void onClickBack() {
		//当前状态  输入手机号界面 输入密码界面 忘记密码界面(输入新密码)
		if (mLvPassword.getVisibility() == View.VISIBLE) {
			//忘记密码界面
			if (mTvLogin.getText().equals("下一步")) {
				mTvForgetPass.setVisibility(View.VISIBLE);
				mTvLogin.setText("登录");
				mEtPassword.setHint("");
				mEtPassword.setText("");
				mTvTitle.setText("手机号登录");
			} else {
				//输入密码界面
				mRlPhone.setVisibility(View.VISIBLE);
				mLvPassword.setVisibility(View.GONE);
			}
		} else {
			//手机号界面
			getSupportDelegate().pop();
		}
	}

}
