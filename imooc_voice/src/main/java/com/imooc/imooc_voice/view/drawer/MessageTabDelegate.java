package com.imooc.imooc_voice.view.drawer;


import com.imooc.imooc_voice.view.drawer.notification.CommentDelegate;
import com.imooc.imooc_voice.view.drawer.notification.ForwardsMeDelegate;
import com.imooc.imooc_voice.view.drawer.notification.PrivateLetterDelegate;
import com.imooc.imooc_voice.view.drawer.notification.PrivateNoticeDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.List;


public class MessageTabDelegate extends NeteaseTabDelegate {


	private static final String[] mTitleDataList = {"私信", "评论", "@我", "通知"};

	/**
	 * 我的消息   标记已读
	 * 私信 评论 @我 通知
	 */


	@Override
	public CharSequence[] setTitleDataList() {
		return mTitleDataList;
	}

	//TODO 右边 标记已读
	@Override
	public CharSequence setLeftTitle() {
		return "我的消息";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		//私信
		mDelegateList.add(new PrivateLetterDelegate());
		//评论
		mDelegateList.add(new CommentDelegate());
		//@我
		mDelegateList.add(new ForwardsMeDelegate());
		//通知
		mDelegateList.add(new PrivateNoticeDelegate());
		return mDelegateList;
	}

	@Override
	public void setShowSearchView(boolean vivisiable) {
		super.setShowSearchView(false);
	}

}
