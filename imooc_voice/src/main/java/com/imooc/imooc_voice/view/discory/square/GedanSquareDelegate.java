package com.imooc.imooc_voice.view.discory.square;

import android.view.View;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.ArrayList;
import java.util.List;


public class GedanSquareDelegate extends NeteaseTabDelegate {


	//TODO 添加官方 频道
	private static final CharSequence[] CHANNELS = {"民谣", "ACG", "华语", "影视原声", "摇滚", "经典", "电子"};

	private List<NeteaseDelegate> mDelegateList = new ArrayList<>();

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
}
