package com.imooc.imooc_voice.view.drawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.view.drawer.notification.CommentDelegate;
import com.imooc.imooc_voice.view.drawer.notification.PrivateLetterDelegate;
import com.imooc.lib_common_ui.delegate.MultiFragmentPagerAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageTabDelegate extends NeteaseDelegate {

	@BindView(R2.id.magic_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.view_pager_tab)
	ViewPager mTabViewPager;

	private MultiFragmentPagerAdapter mPagerAdapter;
	private ArrayList<NeteaseDelegate> mDelegateList = new ArrayList<>();
	private static final String[] mTitleDataList = {"私信", "评论", "@我", "通知"};

	/**
	 * 我的消息   标记已读
	 * 	私信 评论 @我 通知
	 */

	@Override
	public Object setLayout() {
		return R.layout.delegate_message_tab;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		//私信
		mDelegateList.add(new PrivateLetterDelegate());
		//评论
		mDelegateList.add(new CommentDelegate());
		//@我 TODO
		mDelegateList.add(new PrivateLetterDelegate());
		//通知 TODO
		mDelegateList.add(new PrivateLetterDelegate());

		mPagerAdapter = new MultiFragmentPagerAdapter(getChildFragmentManager());
		mPagerAdapter.init(mDelegateList);
		mTabViewPager.setAdapter(mPagerAdapter);
		mTabViewPager.setCurrentItem(0);
		mTabViewPager.setOffscreenPageLimit(3);
		initMagicIndicator();
	}

	private void initMagicIndicator() {
		mTabMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), mTitleDataList, mTabViewPager);
		commonNavigator.setAdjustMode(true);
		mTabMagicIndicator.setNavigator(commonNavigator);
		ViewPagerHelper.bind(mTabMagicIndicator, mTabViewPager);
	}

	@OnClick(R2.id.img_tab_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}
}
