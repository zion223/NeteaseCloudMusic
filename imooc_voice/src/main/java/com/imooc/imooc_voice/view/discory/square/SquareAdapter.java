package com.imooc.imooc_voice.view.discory.square;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.imooc.imooc_voice.model.SquareCHANNEL;

public class SquareAdapter extends FragmentPagerAdapter {

	private SquareCHANNEL[] data;

	public SquareAdapter(FragmentManager fm, SquareCHANNEL[] channels) {
		super(fm);
		this.data = channels;
	}

	@Override
	public Fragment getItem(int i) {
		String tag = data[i].getKey();
		return GedanDelegate.newInstance(tag);
	}

	@Override
	public int getCount() {
		return data.length;
	}
}
