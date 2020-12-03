package com.imooc.imooc_voice.view.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.CHANNEL;
import com.imooc.imooc_voice.model.event.LoginEvent;
import com.imooc.imooc_voice.util.ScreenUtils;
import com.imooc.lib_common_ui.utils.GsonUtil;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;
import com.imooc.imooc_voice.view.drawer.CloudMusicDelegate;
import com.imooc.imooc_voice.view.drawer.MessageTabDelegate;
import com.imooc.imooc_voice.view.home.adapter.HomePagerAdapter;
import com.imooc.imooc_voice.view.home.title.ScaleTransitionPagerTitleView;
import com.imooc.imooc_voice.view.login.LoginDelegate;
import com.imooc.imooc_voice.view.home.search.SearchDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.user.LoginBean;
import com.imooc.lib_common_ui.VerticalItemView;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import butterknife.BindView;
import butterknife.OnClick;

public class HomeDelegate extends NeteaseDelegate{


	//首页的卡片
	private static final CHANNEL[] CHANNELS =
			new CHANNEL[]{CHANNEL.MY, CHANNEL.DISCORY, CHANNEL.YUNCUN, CHANNEL.VIDEO};

	/*
	 * View
	 */
	@BindView(R2.id.search_view)
	View mSearchView;
	@BindView(R2.id.view_pager)
	ViewPager mViewPager;
	@BindView(R2.id.magic_indicator)
	MagicIndicator magicIndicator;
	@BindView(R2.id.base_drawer_layout)
	DrawerLayout mDrawerLayout;
	@BindView(R2.id.avatr_view)
	ImageView mIvAvatarView;
	@BindView(R2.id.avatar_name)
	TextView mTvAvatarName;
	@BindView(R2.id.rl_main_avatar)
	RelativeLayout mRlAvatar;
	@BindView(R2.id.unloggin_layout)
	LinearLayout mLlUnLoggin;
	@BindView(R2.id.icon_notification_listen)
	VerticalItemView mVerItemViewListen;
	@BindView(R2.id.tv_user_level)
	TextView mTvLevel;

	private SharePreferenceUtil sharePreferenceUtil;

	private LoginBean loginBean;

	@Override
	public Object setLayout() {
		return R.layout.delegate_main;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		ScreenUtils.setStatusBarColor(getProxyActivity(), Color.TRANSPARENT);
		initView();
		sharePreferenceUtil = SharePreferenceUtil.getInstance(getContext());
		loginBean = GsonUtil.fromJSON(sharePreferenceUtil.getUserInfo(""), LoginBean.class);
		if(loginBean != null){
			//TODO 用户等级
			//mTvLevel.setText("LV." + loginBean.getProfile().get);
			mRlAvatar.setVisibility(View.VISIBLE);
			mLlUnLoggin.setVisibility(View.GONE);
			ImageLoaderManager.getInstance().displayImageForCircle(mIvAvatarView, loginBean.getProfile().getAvatarUrl());
			mTvAvatarName.setText(loginBean.getProfile().getNickname());
		}else{
			mRlAvatar.setVisibility(View.GONE);
			mLlUnLoggin.setVisibility(View.VISIBLE);
		}

	}


	//初始化控件
	private void initView() {
		HomePagerAdapter mAdapter = new HomePagerAdapter(getChildFragmentManager(), CHANNELS);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOffscreenPageLimit(4);
		initMagicIndicator();
	}

	private void initMagicIndicator() {
		magicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = new CommonNavigator(getContext());
		commonNavigator.setAdjustMode(true);
		commonNavigator.setAdapter(new CommonNavigatorAdapter() {
			@Override
			public int getCount() {
				return CHANNELS.length;
			}

			@Override
			public IPagerTitleView getTitleView(Context context, final int index) {
				final SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
				simplePagerTitleView.setText(CHANNELS[index].getKey());
				simplePagerTitleView.setTextSize(19);
				simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
				simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));
				simplePagerTitleView.setSelectedColor(Color.parseColor("#333333"));
				simplePagerTitleView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						mViewPager.setCurrentItem(index);
					}
				});
				return simplePagerTitleView;
			}

			@Override
			public IPagerIndicator getIndicator(Context context) {
				return null;
			}

			@Override
			public float getTitleWeight(Context context, int index) {
				return 1.0f;
			}
		});
		magicIndicator.setNavigator(commonNavigator);
		ViewPagerHelper.bind(magicIndicator, mViewPager);
		mViewPager.setCurrentItem(1);
	}


	@OnClick(R2.id.unloggin_layout)
	void onClickLogin(){
		if (TextUtils.isEmpty(sharePreferenceUtil.getAuthToken(""))) {
			//跳转到LoginActivity
			getSupportDelegate().start(new LoginDelegate());
		} else {
			mDrawerLayout.closeDrawer(Gravity.LEFT);
		}
	}

	@OnClick(R2.id.avatar_name)
	void onClickUserDetail(){
		mDrawerLayout.closeDrawer(Gravity.LEFT);
		getSupportDelegate().start(UserDetailDelegate.newInstance(String.valueOf(loginBean.getProfile().getUserId())));
	}

	@OnClick(R2.id.search_view)
	void onClickSearch(){
		getSupportDelegate().start(new SearchDelegate());
	}

	//查看通知
	@OnClick(R2.id.icon_notification_msg)
	void onClickShowNotification(){
		mDrawerLayout.closeDrawer(Gravity.LEFT);
		getSupportDelegate().start(new MessageTabDelegate());
	}

	//主线程执行
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onLoginEvent(LoginEvent event) {
		//登陆成功
		//unLogginLayout.setVisibility(View.GONE);
		//mPhotoView.setVisibility(View.VISIBLE);
		//ImageLoaderManager.getInstance()
				//.displayImageForCircle(mPhotoView, UserManager.getInstance().getUser().data.photoUrl);
	}

	//退出登录
	@OnClick(R2.id.exit_layout)
	void onClickQuit(){

		RequestCenter.logout(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				sharePreferenceUtil.removeUserInfo();
				getSupportDelegate().start(new LoginDelegate());
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@OnClick(R2.id.icon_cloud_music)
	void onClickMusic(){
		mDrawerLayout.closeDrawer(Gravity.LEFT);
		getSupportDelegate().start(new CloudMusicDelegate());
	}

	@OnClick(R2.id.toggle_view)
	void ClickToggle(){
		if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
			mDrawerLayout.closeDrawer(Gravity.LEFT);
		} else {
			mDrawerLayout.openDrawer(Gravity.LEFT);
			//听歌识曲图标左右晃动
			mVerItemViewListen.getIconView().setAnimation(shakeAnimation());
		}
	}

	//签到
	@OnClick(R2.id.avatar_check)
	void onClickSignin(){
		//TODO 签到标志位
//		RequestCenter.signIn(new DisposeDataListener() {
//			@Override
//			public void onSuccess(Object responseObj) {
//				CommonMessageBean bean = (CommonMessageBean) responseObj;
//
//			}
//
//			@Override
//			public void onFailure(Object reasonObj) {
//
//			}
//		});
	}
	public static Animation shakeAnimation() {
		Animation rotateAnimation = new RotateAnimation(-20, 20, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setRepeatCount(2);
		rotateAnimation.setDuration(150);
		return rotateAnimation;
	}
}
