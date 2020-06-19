package com.imooc.imooc_voice.view.home.search.artist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.event.ArtistIdEvent;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;
import com.imooc.imooc_voice.view.home.search.artist.sort.ArtistAlbumDelegate;
import com.imooc.imooc_voice.view.home.search.artist.sort.ArtistHomePageDelegate;
import com.imooc.imooc_voice.view.home.search.artist.sort.ArtistSongDelegate;
import com.imooc.imooc_voice.view.home.search.artist.sort.ArtistVideoDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjSubBean;
import com.imooc.lib_api.model.search.SingerSongSearchBean;
import com.imooc.lib_common_ui.delegate.MultiFragmentPagerAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ArtistDetailDelegate extends NeteaseDelegate {


	private static final String ARGS_ARTIST_ID = "ARGS_ARTIST_ID";


	@BindView(R2.id.magic_artist_indicator)
	MagicIndicator mArtistMagicIndicator;
	@BindView(R2.id.view_pager_artist_detail)
	ViewPager mArtistViewPager;
	@BindView(R2.id.tv_artist_name)
	TextView mTvArtistName;
	@BindView(R2.id.iv_artist_detail_background)
	ImageView mIvArtistBackground;
	@BindView(R2.id.fl_artist_detail_followed)
	FrameLayout mFlArtistFollowed;
	@BindView(R2.id.ll_artist_detail_follow)
	LinearLayout mLlArtistFollow;

	private String artistId;
	private MultiFragmentPagerAdapter mPageAdapter;
	private final List<NeteaseDelegate> mDelegateList = new ArrayList<>();
	private static final CharSequence[] mTitleDataList = new CharSequence[4];

	/**
	 * 	主页 热门歌曲 简介
	 * 	歌曲
	 * 	专辑
	 * 	视频
	 */
	public static ArtistDetailDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_ARTIST_ID, String.valueOf(id));
		final ArtistDetailDelegate delegate = new ArtistDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			artistId = args.getString(ARGS_ARTIST_ID);
		}
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_artist_detail;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		mTitleDataList[0] = "主页";
		mTitleDataList[1] = "歌曲";

		//主页 歌曲 专辑 视频
		mPageAdapter = new MultiFragmentPagerAdapter(getChildFragmentManager());
		mDelegateList.add(new ArtistHomePageDelegate());
		mDelegateList.add(new ArtistSongDelegate());
		mDelegateList.add(new ArtistAlbumDelegate());
		mDelegateList.add(new ArtistVideoDelegate());
		mPageAdapter.init(mDelegateList);

		RequestCenter.getSingerInfo(artistId, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SingerSongSearchBean bean = (SingerSongSearchBean) responseObj;
				SingerSongSearchBean.ArtistBean artist = bean.getArtist();

				//歌手姓名
				mTvArtistName.setText(artist.getName());
				//歌手粉丝数暂无

				//是否关注此歌手
				if(artist.isFollowed()){
					mFlArtistFollowed.setVisibility(View.VISIBLE);
				}else{
					mLlArtistFollow.setVisibility(View.VISIBLE);
				}

				ImageLoaderManager.getInstance().displayImageForCorner(mIvArtistBackground, artist.getImg1v1Url() + "?param=200y200");

				SpannableString albumString = new SpannableString("专辑" + bean.getArtist().getAlbumSize());
				albumString.setSpan(new AbsoluteSizeSpan(30), 2, albumString.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				SpannableString videoString = new SpannableString("视频" + bean.getArtist().getMvSize());
				videoString.setSpan(new AbsoluteSizeSpan(30), 2, videoString.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				mTitleDataList[2] = albumString;
				mTitleDataList[3] = videoString;

				initMagicIndicator();

				SharePreferenceUtil.getInstance(getContext()).saveCurrentArtistId(artistId);
				EventBus.getDefault().postSticky(new ArtistIdEvent(artistId, artist.getName()));

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});

	}

	private void initMagicIndicator() {
		mArtistViewPager.setAdapter(mPageAdapter);
		mArtistViewPager.setCurrentItem(1);
		mArtistViewPager.setOffscreenPageLimit(3);

		mArtistMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), mTitleDataList, mArtistViewPager);
		commonNavigator.setAdjustMode(true);
		mArtistMagicIndicator.setNavigator(commonNavigator);
		mArtistMagicIndicator.onPageSelected(1);
		ViewPagerHelper.bind(mArtistMagicIndicator, mArtistViewPager);
	}

	//返回
	@OnClick(R2.id.img_artist_detail_back)
	void OnClickPop(){
		getSupportDelegate().pop();
		SharePreferenceUtil.getInstance(getContext()).removeCurrentArtistId();
	}

	//关注或取消关注歌手
	@OnClick({R2.id.fl_artist_detail_followed, R2.id.ll_artist_detail_follow})
	void onClickSubscribeArtist(View view){
		int id = view.getId();
		//关注歌手
		final boolean follow = (id == R.id.ll_artist_detail_follow);
		RequestCenter.getSubArtist(artistId, follow, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjSubBean bean = (DjSubBean) responseObj;
				if(bean.getCode() == 200){
					if(follow){
						mFlArtistFollowed.setVisibility(View.VISIBLE);
						mLlArtistFollow.setVisibility(View.INVISIBLE);
					}else{
						mFlArtistFollowed.setVisibility(View.INVISIBLE);
						mLlArtistFollow.setVisibility(View.VISIBLE);
					}
				}
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}
}
