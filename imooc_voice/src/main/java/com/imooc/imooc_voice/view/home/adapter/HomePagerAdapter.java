package com.imooc.imooc_voice.view.home.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.imooc.imooc_voice.model.CHANNEL;
import com.imooc.imooc_voice.view.cloud.CloudVillageFragment;
import com.imooc.imooc_voice.view.discory.DiscoverDelegate;
import com.imooc.imooc_voice.view.mine.MineDelegate;
import com.imooc.imooc_voice.view.video.VideoTabDelegate;

public class HomePagerAdapter extends FragmentPagerAdapter {

	private CHANNEL[] data;

	public HomePagerAdapter(FragmentManager fm, CHANNEL[] channels) {
		super(fm);
		this.data = channels;
	}

	//初始化Fragment  在滑动时创建fragment 优化性能
	@Override
	public Fragment getItem(int position) {
		int type = data[position].getValue();
		switch (type) {
			case CHANNEL.MINE_ID:
				return new MineDelegate();
			case CHANNEL.DISCORY_ID:
				return new DiscoverDelegate();
			case CHANNEL.YUNCUN_ID:
				return new CloudVillageFragment();
			case CHANNEL.VIDEO_ID:
				return new VideoTabDelegate();
		}
		return null;
	}

	@Override
	public int getCount() {
		return data.length;
	}
}
