package com.imooc.imooc_voice.view.user;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.view.user.follow.UserFriendTabDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.user.FollowBean;
import com.imooc.lib_api.model.user.UserDetailBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import butterknife.BindView;
import butterknife.OnClick;

public class UserDetailDelegate extends NeteaseDelegate {

	private static final String ARGS_USER_ID = "ARGS_USER_ID";

	@BindView(R2.id.iv_user_detail_background)
	ImageView mIvAppBarBg;
	@BindView(R2.id.iv_user_detail_background_cover)
	ImageView mIvAppBarBgCover;
	@BindView(R2.id.iv_user_detail_avatar)
	ImageView mIvUserAvatar;
	@BindView(R2.id.tv_user_detail_name)
	TextView mTvUserNickName;
	@BindView(R2.id.tv_user_detail_sub)
	TextView mTvUserSubAndFollow;
	@BindView(R2.id.iv_user_detail_vip)
	ImageView mIvUserVip;
	@BindView(R2.id.tv_user_level)
	TextView mTvUserLevel;
	@BindView(R2.id.ll_user_detail_follow)
	LinearLayout mLlFollowUser;
	@BindView(R2.id.tv_user_detail_send_msg)
	TextView mTvSendMsg;
	@BindView(R2.id.fl_user_detail_followed)
	FrameLayout mFlFollowedUser;
	@BindView(R2.id.magic_user_indicator)
	MagicIndicator mUserMagicIndicator;
	@BindView(R2.id.view_pager_user_detail)
	ViewPager mViewPager;

	private String userId;

	private ImageLoaderManager manager;
	private UserDetailBean currentUser;
	private static CharSequence[] mTitleDataList = new CharSequence[2];

	public static UserDetailDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_USER_ID, id);
		final UserDetailDelegate delegate = new UserDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			userId = args.getString(ARGS_USER_ID);
		}
		manager = ImageLoaderManager.getInstance();
	}


	@Override
	public Object setLayout() {
		return R.layout.delegate_user_detail;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {

		//发私信左边的图片
		Drawable drawable = getResources().getDrawable(R.drawable.ic_notification_msg_white);
		drawable.setBounds(5, 0, 50, 50);//第一个 0 是距左边距离，第二个 0 是距上边距离，40 分别是
		mTvSendMsg.setCompoundDrawables(drawable, null, null, null);

		//设置发私信透明度
		mTvSendMsg.getBackground().mutate().setAlpha(200);
		//查看粉丝和关注的人
		RequestCenter.getUserDetail(userId, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				UserDetailBean bean = (UserDetailBean) responseObj;
				currentUser = bean;
				mViewPager.setAdapter(new UserTabAdapter(getChildFragmentManager()));
				//顶部背景
				manager.displayImageForView(mIvAppBarBgCover, bean.getProfile().getBackgroundUrl());
				manager.displayImageForViewGroup(mIvAppBarBg, bean.getProfile().getBackgroundUrl(), 125);
				//用户头像
				manager.displayImageForCircle(mIvUserAvatar, bean.getProfile().getAvatarUrl());
				mTvUserNickName.setText(bean.getProfile().getNickname());
				//关注和粉丝数量
				int followed = bean.getProfile().getFolloweds();
				int follower = bean.getProfile().getFollows();
				mTvUserSubAndFollow.setText("关注 " + follower + "  粉丝 " + SearchUtil.getCorresPondingString(followed));

				//显示关注或者已关注
				boolean isFollowed = bean.getProfile().isFollowed();
				if(isFollowed){
					mFlFollowedUser.setVisibility(View.VISIBLE);
				}else{
					mLlFollowUser.setVisibility(View.VISIBLE);
				}
				mTvUserLevel.setText("Lv." + bean.getLevel());


				ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.GRAY);
				//动态数量
				SpannableString eventText;
				if(bean.getProfile().getEventCount() > 10000){
					eventText = new SpannableString("动态 99+" );
				}else{
					eventText = new SpannableString("动态 " + bean.getProfile().getEventCount());
				}

				eventText.setSpan(new AbsoluteSizeSpan(35), 3, eventText.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				eventText.setSpan(foregroundColorSpan, 3, eventText.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				mTitleDataList[0] = "主页";
				mTitleDataList[1] = eventText;

				CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), mTitleDataList, mViewPager);
				commonNavigator.setAdjustMode(true);
				mUserMagicIndicator.setNavigator(commonNavigator);
				ViewPagerHelper.bind(mUserMagicIndicator, mViewPager);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}



	/**
	 * 关注当前用户
	 */
	@OnClick(R2.id.ll_user_detail_follow)
	void onClickSubscribe() {

		RequestCenter.follow(userId, true, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				//关注用户成功
				FollowBean bean = (FollowBean) responseObj;
				if(bean.getCode() == 200){
					//提示关注成功toast
					Toast.makeText(getContext(), bean.getFollowContent(), Toast.LENGTH_SHORT).show();
					//显示关注天数 TODO
					String followTimeContent = bean.getFollowTimeContent();
					mLlFollowUser.setVisibility(View.INVISIBLE);
					mFlFollowedUser.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

	}

	/**
	 * 	取消关注
	 */
	@OnClick(R2.id.fl_user_detail_followed)
	void onClickCancleSubscribe() {

		RequestCenter.follow(userId, false, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {

				//取消关注用户成功
				FollowBean bean = (FollowBean) responseObj;
				if(bean.getCode() == 200){
					mLlFollowUser.setVisibility(View.VISIBLE);
					mFlFollowedUser.setVisibility(View.INVISIBLE);
				}
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

	}

	//查看粉丝和关注的人
	@OnClick(R2.id.tv_user_detail_sub)
	void onClickSubAndFollowDetail(){

		getSupportDelegate().start(UserFriendTabDelegate.newInstance(userId));
	}


	@OnClick(R2.id.img_user_detail_back)
	void onClickBack() {
		getSupportDelegate().pop();
	}

	class UserTabAdapter extends FragmentPagerAdapter {

		UserTabAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			switch (i) {
				case 0:
					if (currentUser != null) {
						return UserHomePageDelegate.newInstance(currentUser);
					} else {
						return null;
					}
				case 1:
					return UserEventDelegate.newInstance(userId);
				default:
					break;
			}
			return null;
		}

		@Override
		public int getCount() {
			return 2;
		}
	}
}
