package com.imooc.lib_common_ui.navigator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

public class CommonNavigatorCreater {

	public static CommonNavigator setDefaultNavigator(Context context, final CharSequence[] title, final ViewPager viewPager) {

		CommonNavigator commonNavigator = new CommonNavigator(context);

		commonNavigator.setAdapter(new CommonNavigatorAdapter() {
			@Override
			public int getCount() {
				return title.length;
			}

			@Override
			public IPagerTitleView getTitleView(Context context, final int index) {
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				params.setMargins(0, 0, 0, 10);
				ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
				colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
				colorTransitionPagerTitleView.setSelectedColor(Color.RED);
				colorTransitionPagerTitleView.setTextSize(14);
				colorTransitionPagerTitleView.setLayoutParams(params);
				colorTransitionPagerTitleView.setText(title[index]);
				colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						viewPager.setCurrentItem(index);
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
				return 1.0f;
			}
		});
		return commonNavigator;
	}


}
