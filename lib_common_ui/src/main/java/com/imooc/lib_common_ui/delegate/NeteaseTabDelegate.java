package com.imooc.lib_common_ui.delegate;

import android.opengl.Visibility;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.lib_common_ui.R;
import com.imooc.lib_common_ui.R2;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class NeteaseTabDelegate extends NeteaseDelegate {

	@BindView(R2.id.delegate_magic_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.delegate_view_pager_tab)
	ViewPager mTabViewPager;
	@BindView(R2.id.delegate_tab_title)
	TextView mTvLeftTitle;
	@BindView(R2.id.delegate_tab_more)
	ImageView mIvMore;
	@BindView(R2.id.ll_delegate_title)
	LinearLayout mLlTitle;
	@BindView(R2.id.delegate_tab_search)
	ImageView mIvSearch;

	private MultiFragmentPagerAdapter mAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_tab;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		mTvLeftTitle.setText(setLeftTitle());

		mAdapter = new MultiFragmentPagerAdapter(getChildFragmentManager());
		mAdapter.init(setDelegateList());
		mTabViewPager.setAdapter(mAdapter);
		mTabViewPager.setOffscreenPageLimit(setTitleDataList().length);
		//mTabMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), setTitleDataList(), mTabViewPager);
		commonNavigator.setAdjustMode(true);
		mTabMagicIndicator.setNavigator(commonNavigator);
		ViewPagerHelper.bind(mTabMagicIndicator, mTabViewPager);

		setShowMoreView(View.GONE);
		setMoreViewOnClickListener(null);
		setToolBarVisiable(View.VISIBLE);
		setShowSearchView(View.VISIBLE);
	}

	public ImageView getIvMore() {
		return mIvMore;
	}

	public MagicIndicator getTabMagicIndicator() {
		return mTabMagicIndicator;
	}

	public ViewPager getTabViewPager() {
		return mTabViewPager;
	}

	public abstract CharSequence[] setTitleDataList();

	public abstract CharSequence setLeftTitle();

	public abstract List<NeteaseDelegate> setDelegateList();

	public void setShowMoreView(int vivisiable){
		mIvMore.setVisibility(vivisiable);
	}
	public void setShowSearchView(int vivisiable){
		mIvSearch.setVisibility(vivisiable);
	}
	public void setMoreViewOnClickListener(View.OnClickListener listener){
		mIvMore.setOnClickListener(listener);
	}
	public void setToolBarVisiable(int visiable){
		mLlTitle.setVisibility(visiable);
	}

	@OnClick(R2.id.delegate_tab_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}

}
