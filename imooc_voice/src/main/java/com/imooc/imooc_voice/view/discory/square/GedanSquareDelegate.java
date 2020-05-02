package com.imooc.imooc_voice.view.discory.square;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import butterknife.BindView;
import butterknife.OnClick;


public class GedanSquareDelegate extends NeteaseDelegate {

	@BindView(R2.id.magic_square_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.view_square_pager_tab)
	ViewPager mTabViewPager;

	private SquareAdapter mAdapter;
	//TODO 添加官方 频道
	private static final CharSequence[] CHANNELS = {"民谣","ACG","华语","影视原声","摇滚","经典","电子"};

	@Override
	public Object setLayout() {
		return R.layout.delegate_gedan_square;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		mAdapter = new SquareAdapter(getChildFragmentManager(), CHANNELS);
		mTabViewPager.setAdapter(mAdapter);
		mTabViewPager.setOffscreenPageLimit(1);
		initMagicIndicator();
	}

	@Override
	public boolean onBackPressedSupport() {
		getSupportDelegate().pop();
		return super.onBackPressedSupport();
	}

	private void initMagicIndicator() {
		//mTabMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), CHANNELS, mTabViewPager);
		mTabMagicIndicator.setNavigator(commonNavigator);
//		LinearLayout titleContainer = commonNavigator.getTitleContainer();
//		titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//		//设置TAB的间距
//		titleContainer.setDividerDrawable(new ColorDrawable() {
//			@Override
//			public int getIntrinsicWidth() {
//				return UIUtil.dip2px(getContext(), 18);
//			}
//		});
		ViewPagerHelper.bind(mTabMagicIndicator, mTabViewPager);

	}


	@OnClick(R2.id.img_gedan_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}
}
