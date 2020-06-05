package com.imooc.imooc_voice.view.user.follow;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.List;

//用户的粉丝和关注列表
public class UserFriendTabDelegate extends NeteaseTabDelegate {

	private static final String ARGS_USER_ID = "ARGS_USER_ID";

	private static final CharSequence[] CHANNELS = {"关注", "粉丝"};

	private String userId;

	public static UserFriendTabDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_USER_ID, id);
		final UserFriendTabDelegate delegate = new UserFriendTabDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			userId = args.getString(ARGS_USER_ID);
		}
	}
	@Override
	public CharSequence[] setTitleDataList() {
		return CHANNELS;
	}

	@Override
	public CharSequence setLeftTitle() {
		return "TA的好友";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		mDelegateList.add(UserFollowDelegate.newInstance(userId));
		mDelegateList.add(UserFollowerDelegate.newInstance(userId));
		return mDelegateList;
	}

	@Override
	public void setShowSearchView(boolean vivisiable) {
		super.setShowSearchView(false);
	}
}
