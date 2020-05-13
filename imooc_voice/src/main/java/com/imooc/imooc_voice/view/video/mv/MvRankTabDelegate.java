package com.imooc.imooc_voice.view.video.mv;

import android.view.View;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.ArrayList;
import java.util.List;


public class MvRankTabDelegate extends NeteaseTabDelegate {


	private ArrayList<NeteaseDelegate> mDelegates = new ArrayList<>();

	private static final String[] mTitleDataList = {"内地", "港台", "欧美", "韩国", "日本"};


	@Override
	public CharSequence[] setTitleDataList() {
		return mTitleDataList;
	}

	@Override
	public CharSequence setLeftTitle() {
		return "MV排行榜";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		for (String s : mTitleDataList) {
			mDelegates.add(MvRankDelegate.newInstance(s));
		}
		return mDelegates;
	}

	@Override
	public void setShowSearchView(int vivisiable) {
		super.setShowSearchView(View.GONE);
	}
}
