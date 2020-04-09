package com.imooc.imooc_voice.view.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.personal.UserDetailBean;
import com.imooc.imooc_voice.model.newapi.personal.UserPlaylistBean;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;



import butterknife.BindView;

public class UserInfoDelegate extends NeteaseDelegate {

	private static final String ARGS_USER_DETAIL = "ARGS_USER_DETAIL";

	@BindView(R2.id.tv_user_detail_createtime)
	TextView mTvCreateTime;
	@BindView(R2.id.tv_user_detail_age)
	TextView mTvAge;
	@BindView(R2.id.tv_user_detail_area)
	TextView mTvArea;
	@BindView(R2.id.tv_user_info_toptext)
	TextView mTvListenRankTitle;
	@BindView(R2.id.tv_user_info_bottomtext)
	TextView mTvListenRankCount;
	@BindView(R2.id.tv_user_info_toplike)
	TextView mTvLikeMusicTitle;
	@BindView(R2.id.tv_user_info_bottomlike)
	TextView mTvLikeMusicInfo;
	@BindView(R2.id.iv_user_info_like)
	ImageView mIvLikeImg;
	@BindView(R2.id.rv_user_info_create_gedan)
	RecyclerView mRvCreateGedan;
	@BindView(R2.id.rv_user_info_collect_gedan)
	RecyclerView mRvCollectGedan;
	@BindView(R2.id.tv_user_info_create_right)
	TextView mTvCreateRightText;
	@BindView(R2.id.tv_user_info_collect_right)
	TextView mTvCollectRightText;

	private UserDetailBean mCurrentUser;
	private ImageLoaderManager manager;


	public static UserInfoDelegate newInstance(UserDetailBean bean) {
		final Bundle args = new Bundle();
		args.putSerializable(ARGS_USER_DETAIL, bean);
		final UserInfoDelegate delegate = new UserInfoDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			mCurrentUser = (UserDetailBean) args.getSerializable(ARGS_USER_DETAIL);
		}
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_user_info;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		//基本信息
		String createTime = TimeUtil.getTimeStandardOnlyYMD(mCurrentUser.getCreateTime());
		mTvCreateTime.setText("村龄:  " + createTime + "注册");
		mTvAge.setText("年龄：  无法解析" + mCurrentUser.getProfile().getBirthday());
		mTvArea.setText("地区：  地区码" + mCurrentUser.getProfile().getProvince() + " " + mCurrentUser.getProfile().getCity());
		//听歌排行
		mTvListenRankTitle.setText(mCurrentUser.getProfile().getNickname() + "的听歌排行");
		mTvListenRankCount.setText("累计听歌" + mCurrentUser.getListenSongs() + "首");
		mTvLikeMusicTitle.setText(mCurrentUser.getProfile().getNickname()+"喜欢的音乐");
		//mTvCreateTime.setText();
		RequestCenter.getUserPlaylist(mCurrentUser.getProfile().getUserId(), new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				UserPlaylistBean bean = (UserPlaylistBean) responseObj;
				//喜欢的音乐
				UserPlaylistBean.PlaylistBean likeBean = bean.getPlaylist().get(0);
				mTvLikeMusicInfo.setText(likeBean.getTrackCount() + "首, 播放"+ likeBean.getPlayCount()+"次");
				manager.displayImageForCorner(mIvLikeImg, likeBean.getCoverImgUrl(),5);

				//创建的歌单  收藏的歌单  创建的电台   Mlog

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}





}
