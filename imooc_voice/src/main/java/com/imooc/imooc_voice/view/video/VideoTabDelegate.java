package com.imooc.imooc_voice.view.video;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.view.video.mv.MvDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.VideoGroupBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;
import com.imooc.lib_network.listener.DisposeDataListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;

public class VideoTabDelegate extends NeteaseDelegate {

	@BindView(R2.id.magic_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.view_pager_tab)
	ViewPager mTabViewPager;


	private VideoTabAdapter mAdapter;
	/**
	 *获取视频标签列表  eg. 推荐 为爱发声  MV
	 * 	获取视频标签下的视频
	 *
	 */
	@Override
	public Object setLayout() {
		return R.layout.delegate_video_tab;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		RequestCenter.getVideoGroup(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				VideoGroupBean bean = (VideoGroupBean) responseObj;
				List<VideoGroupBean.Data> data = bean.getData();

				// 根据ID查询视频 name为标题 tab数量最多为20个
				int tabSize = data.size();
				if(tabSize >= 20){
					tabSize = 20;
				}
				String[] mTitleData = new String[tabSize];
				long[] mVideoTabId = new long[tabSize];
				mVideoTabId[0] = 9999;
				mTitleData[0] = "推荐";
				for(int i = 1; i < tabSize; i++){
					VideoGroupBean.Data tab = data.get(i);
					String name = tab.getName();
					mTitleData[i] = name;
					mVideoTabId[i] = tab.getId();
				}

				mAdapter = new VideoTabAdapter(mVideoTabId, getChildFragmentManager());
				mTabViewPager.setAdapter(mAdapter);
				//mTabViewPager.setOffscreenPageLimit(mTitleData.length);


				mTabMagicIndicator.setBackgroundColor(Color.WHITE);
				CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), mTitleData, mTabViewPager);
				mTabMagicIndicator.setNavigator(commonNavigator);

				LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
				titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
				titleContainer.setDividerDrawable(new ColorDrawable() {
					@Override
					public int getIntrinsicWidth() {
						return UIUtil.dip2px(getContext(), 20);
					}
				});
				ViewPagerHelper.bind(mTabMagicIndicator, mTabViewPager);

			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	static class VideoTabAdapter extends FragmentPagerAdapter{

		private long[] mTabIdArray;

		VideoTabAdapter(long[] tabArray, FragmentManager fm) {
			super(fm);
			mTabIdArray = tabArray;
		}

		@Override
		public Fragment getItem(int i) {
			if(mTabIdArray[i] == 1000){
				return new MvDelegate();
			}else{
				return VideoDelegate.newInstance(mTabIdArray[i]);
			}
		}

		@Override
		public int getCount() {
			return mTabIdArray.length;
		}
	}
}
