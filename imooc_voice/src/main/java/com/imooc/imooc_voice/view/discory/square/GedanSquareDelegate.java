package com.imooc.imooc_voice.view.discory.square;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.CHANNEL;
import com.imooc.imooc_voice.model.SquareCHANNEL;
import com.imooc.imooc_voice.view.mine.tab.TabAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import butterknife.BindView;
import butterknife.OnClick;


public class GedanSquareDelegate extends NeteaseDelegate {

	@BindView(R2.id.magic_square_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.view_square_pager_tab)
	ViewPager mTabViewPager;

	private SquareAdapter mAdapter;

	private static final SquareCHANNEL[] CHANNELS = new SquareCHANNEL[]{SquareCHANNEL.HUAYU,
			SquareCHANNEL.JIQING, SquareCHANNEL.ANJING,SquareCHANNEL.GUFENG,SquareCHANNEL.DIANZI,
			SquareCHANNEL.QINGCHUN, SquareCHANNEL.QINGYINYUE, SquareCHANNEL.YAOGUN, SquareCHANNEL.MINYAO};


	@Override
	public Object setLayout() {
		return R.layout.delegate_gedan_square;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		mAdapter = new SquareAdapter(getChildFragmentManager(), CHANNELS);
		mTabViewPager.setAdapter(mAdapter);
		initMagicIndicator();
	}

	@Override
	public boolean onBackPressedSupport() {
		getSupportDelegate().pop();
		return super.onBackPressedSupport();
	}

	private void initMagicIndicator() {
		//mTabMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = new CommonNavigator(getContext());
		commonNavigator.setAdapter(new CommonNavigatorAdapter() {
			@Override
			public int getCount() {
				return CHANNELS.length;
			}

			@Override
			public IPagerTitleView getTitleView(Context context, final int index) {
				ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
				colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
				colorTransitionPagerTitleView.setSelectedColor(Color.RED);
				colorTransitionPagerTitleView.setTextSize(15);
				colorTransitionPagerTitleView.setText(CHANNELS[index].getKey());
				colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						mTabViewPager.setCurrentItem(index);
					}
				});
				return colorTransitionPagerTitleView;
			}

			@Override
			public IPagerIndicator getIndicator(Context context) {
				LinePagerIndicator indicator = new LinePagerIndicator(context);
				indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
				indicator.setColors(Color.RED);
				return indicator;
			}

			@Override
			public float getTitleWeight(Context context, int index) {
				return 1f;
			}
		});
		mTabMagicIndicator.setNavigator(commonNavigator);
		LinearLayout titleContainer = commonNavigator.getTitleContainer();
		titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
		//设置TAB的间距
		titleContainer.setDividerDrawable(new ColorDrawable() {
			@Override
			public int getIntrinsicWidth() {
				return UIUtil.dip2px(getContext(), 18);
			}
		});
		ViewPagerHelper.bind(mTabMagicIndicator, mTabViewPager);

	}

	@Override
	public void post(Runnable runnable) {

	}
	@OnClick(R2.id.img_gedan_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}
}
