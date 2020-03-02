package com.imooc.imooc_voice.view.home.title;

import android.content.Context;
import android.graphics.Typeface;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/**
 * 滑动时切换文字Title大小
 */
public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {
	private float mMinScale = 0.75f;

	public ScaleTransitionPagerTitleView(Context context) {
		super(context);
	}

	@Override
	public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
		super.onEnter(index, totalCount, enterPercent, leftToRight);    // 实现颜色渐变
		setScaleX(mMinScale + (1.0f - mMinScale) * enterPercent);
		setScaleY(mMinScale + (1.0f - mMinScale) * enterPercent);
		setTypeface(Typeface.DEFAULT_BOLD); //选中后的字体样式,根据需求自己做修改
	}

	@Override
	public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
		super.onLeave(index, totalCount, leavePercent, leftToRight);    // 实现颜色渐变
		setScaleX(1.0f + (mMinScale - 1.0f) * leavePercent);
		setScaleY(1.0f + (mMinScale - 1.0f) * leavePercent);
		setTypeface(Typeface.DEFAULT);//未选中的字体样式,根据需求自己做修改
	}

	public float getMinScale() {
		return mMinScale;
	}

	public void setMinScale(float minScale) {
		mMinScale = minScale;
	}
}
