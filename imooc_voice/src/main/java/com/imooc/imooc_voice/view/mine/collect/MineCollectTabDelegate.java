package com.imooc.imooc_voice.view.mine.collect;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.List;

//我的收藏
public class MineCollectTabDelegate extends NeteaseTabDelegate {


	private static final String[] mTitleDataList = {"专辑", "歌手", "视频", "专栏", "MLOG"};


	@Override
	public String[] setTitleDataList() {
		return mTitleDataList;
	}

	@Override
	public CharSequence setLeftTitle() {
		return "我的收藏";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		mDelegateList.add(new AlbumCollectDelegate());
		mDelegateList.add(new ArtistCollectDelegate());
		mDelegateList.add(new VideoCollectDelegate());
		//TODO 专栏和MLOG
		mDelegateList.add(new AlbumCollectDelegate());
		mDelegateList.add(new AlbumCollectDelegate());
		return mDelegateList;
	}



}
