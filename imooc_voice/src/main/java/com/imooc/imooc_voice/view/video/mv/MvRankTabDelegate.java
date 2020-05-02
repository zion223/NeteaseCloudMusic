package com.imooc.imooc_voice.view.video.mv;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.MultiFragmentPagerAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MvRankTabDelegate extends NeteaseDelegate {

	@BindView(R2.id.magic_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.view_pager_tab)
	ViewPager mTabViewPager;

	private MultiFragmentPagerAdapter mAdapter;
	private ArrayList<NeteaseDelegate> mDelegates = new ArrayList<>();

	private static final String[] mTitleDataList = {"内地", "港台", "欧美", "韩国", "日本"};

	@Override
	public Object setLayout() {
		return R.layout.delegate_mv_rank_tab;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		mAdapter = new MultiFragmentPagerAdapter(getChildFragmentManager());
		for (String s : mTitleDataList) {
			mDelegates.add(MvRankDelegate.newInstance(s));
		}
		mAdapter.init(mDelegates);
		mTabViewPager.setAdapter(mAdapter);
		mTabViewPager.setOffscreenPageLimit(4);
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
