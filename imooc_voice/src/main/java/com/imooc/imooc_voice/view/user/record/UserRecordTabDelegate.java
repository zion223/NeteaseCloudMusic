package com.imooc.imooc_voice.view.user.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.List;

public class UserRecordTabDelegate extends NeteaseTabDelegate {

	private static final String ARGS_USER_ID = "ARGS_USER_ID";
	private static final String ARGS_USER_NAME = "ARGS_USER_NAME";


	private static final String[] mTitleDataList = {"最近一周", "全部时间"};

	private int userId;
	private String userNickName;

	public static UserRecordTabDelegate newInstance(int id, String name) {
		final Bundle args = new Bundle();
		args.putInt(ARGS_USER_ID, id);
		args.putString(ARGS_USER_NAME, name);
		final UserRecordTabDelegate delegate = new UserRecordTabDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			userId = args.getInt(ARGS_USER_ID);
			userNickName = args.getString(ARGS_USER_NAME);
		}
	}

	@Override
	public CharSequence[] setTitleDataList() {
		return mTitleDataList;
	}

	@Override
	public CharSequence setLeftTitle() {
		return userNickName + "的听歌排行";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		mDelegateList.add(UserRecordDelegate.newInstance(userId, 0));
		mDelegateList.add(UserRecordDelegate.newInstance(userId, 1));
		return mDelegateList;
	}

	@Override
	public void setShowSearchView(boolean vivisiable) {
		super.setShowSearchView(false);
	}

	@Override
	public void setShowMoreView(int vivisiable) {
		super.setShowMoreView(View.GONE);
	}
}
