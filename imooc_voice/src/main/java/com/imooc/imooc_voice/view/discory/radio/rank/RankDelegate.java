package com.imooc.imooc_voice.view.discory.radio.rank;

import android.view.View;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.ArrayList;
import java.util.List;


//主播电台排行榜
public class RankDelegate extends NeteaseTabDelegate {


	private static final String[] mTitleDataList = {"主播榜", "节目榜", "电台榜"};

	private ArrayList<NeteaseDelegate> mDelegateList = new ArrayList<>();


	@Override
	public CharSequence[] setTitleDataList() {
		return mTitleDataList;
	}

	@Override
	public CharSequence setLeftTitle() {
		return "主播电台排行榜";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		mDelegateList.add(new DjRankDelegate());
		mDelegateList.add(new ProgramRankDelegate());
		mDelegateList.add(new RadioRankDelegate());
		return mDelegateList;
	}

	@Override
	public void setShowSearchView(int vivisiable) {
		super.setShowSearchView(View.GONE);
	}
}
