package com.imooc.imooc_voice.view.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.imooc.imooc_voice.view.user.follow.UserFollowDelegate;
import com.imooc.imooc_voice.view.user.follow.UserFollowerDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;

import java.util.List;

// 我的好友
public class FriendsTabDelegate extends NeteaseTabDelegate {

    private static final String ARGS_USER_ID = "ARGS_USER_ID";


    private static final String[] mTitleDataList = {"关注", "粉丝", "添加好友"};

    private String userId;

    public static FriendsTabDelegate newInstance(String id) {
        final Bundle args = new Bundle();
        args.putString(ARGS_USER_ID, id);
        final FriendsTabDelegate delegate = new FriendsTabDelegate();
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
        return mTitleDataList;
    }

    @Override
    public CharSequence setLeftTitle() {
        return "我的好友";
    }

    @Override
    public List<NeteaseDelegate> setDelegateList() {
        mDelegateList.add(UserFollowDelegate.newInstance(userId));
        mDelegateList.add(UserFollowerDelegate.newInstance(userId));
        mDelegateList.add(UserFollowerDelegate.newInstance(userId));
        return mDelegateList;
    }
}
