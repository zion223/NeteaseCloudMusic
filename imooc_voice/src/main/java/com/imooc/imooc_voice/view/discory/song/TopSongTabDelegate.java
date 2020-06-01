package com.imooc.imooc_voice.view.discory.song;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.List;

//新歌速递
public class TopSongTabDelegate extends NeteaseTabDelegate {

	private static final CharSequence[] CHANNELS = {"推荐", "华语", "欧美", "日本", "韩国"};


	@Override
	public CharSequence[] setTitleDataList() {
		return CHANNELS;
	}

	@Override
	public CharSequence setLeftTitle() {
		return "最新音乐";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		mDelegateList.add(TopSongDelegate.newInstance(0));
		mDelegateList.add(TopSongDelegate.newInstance(7));
		mDelegateList.add(TopSongDelegate.newInstance(96));
		mDelegateList.add(TopSongDelegate.newInstance(8));
		mDelegateList.add(TopSongDelegate.newInstance(16));
		return mDelegateList;
	}

	@Override
	public void setShowSearchView(boolean vivisiable) {
		super.setShowSearchView(false);
	}
}
