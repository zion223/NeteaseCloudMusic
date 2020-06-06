package com.imooc.imooc_voice.view.user.record;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.discory.square.detail.PlayListAdapter;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.UserRecordBean;
import com.imooc.lib_api.model.song.SongDetailBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

public class UserRecordDelegate extends NeteaseLoadingDelegate {

	private static final String ARGS_USER_ID = "ARGS_USER_ID";
	private static final String ARGS_RECORD_TYPE = "ARGS_RECORD_TYPE";


	private TextView mTvMsg;

	private RecyclerView mRecyclerView;
	private PlayListAdapter mAdapter;
	private int userId;
	private int recordType;

	public static UserRecordDelegate newInstance(int id, int type) {
		final Bundle args = new Bundle();
		args.putInt(ARGS_USER_ID, id);
		args.putInt(ARGS_RECORD_TYPE, type);
		final UserRecordDelegate delegate = new UserRecordDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			userId = args.getInt(ARGS_USER_ID);
			recordType = args.getInt(ARGS_RECORD_TYPE);
		}
	}


	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		mTvMsg = rootView.findViewById(R.id.tv_msg_text);
		//获取用户播放记录
		RequestCenter.getUserRecord(userId, recordType, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				UserRecordBean bean = (UserRecordBean) responseObj;
				ArrayList<SongDetailBean.SongsBean> mSongList = new ArrayList<>();

				if (bean.getCode() != 200) {
					//不允许别人查看播放记录 显示内容
					mTvMsg.setVisibility(View.VISIBLE);
					mTvMsg.setText("由于对方设置你无法查看TA的听歌排行");
					mRecyclerView.setVisibility(View.GONE);
				} else if (bean.getCode() == 200 && recordType == 1 && bean.getWeekData() != null) {
					for (int i = 0; i < bean.getWeekData().size(); i++) {
						mSongList.add(bean.getWeekData().get(i).getSong());
					}
				} else if (bean.getCode() == 200 && recordType == 0 && bean.getAllData() != null) {
					for (int i = 0; i < bean.getAllData().size(); i++) {
						mSongList.add(bean.getAllData().get(i).getSong());
					}
				}
				mAdapter = new PlayListAdapter(getContext(), getParentDelegate(), false,false, mSongList);
				mRecyclerView.setAdapter(mAdapter);
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}
}
