package com.imooc.imooc_voice.view.discory.square;

import android.view.View;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;


public class GedanSquareDelegate extends NeteaseTabDelegate {


	//TODO 添加推荐 频道  精品 频道  /top/playlist/highquality
	private static final CharSequence[] CHANNELS = {"官方", "ACG", "华语", "影视原声", "摇滚", "经典", "电子", "流行", "怀旧"};


	@Override
	public CharSequence[] setTitleDataList() {
		return CHANNELS;
	}

	@Override
	public CharSequence setLeftTitle() {
		return "歌单广场";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		for (CharSequence channel : CHANNELS) {
			mDelegateList.add(GedanDelegate.newInstance(channel.toString()));
		}
		return mDelegateList;
	}

	@Override
	public void setShowSearchView(int vivisiable) {
		super.setShowSearchView(View.GONE);
	}

	@Override
	public void setDividerDrawable(CommonNavigator navigator, int dp) {
		super.setDividerDrawable(navigator, 18);
	}

	@Override
	public boolean setAdjustMode() {
		return false;
	}
}
