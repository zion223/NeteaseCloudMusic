package com.imooc.imooc_voice.view.discory.square;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SquareAdapter extends FragmentPagerAdapter {

	private CharSequence[] data;

	public SquareAdapter(FragmentManager fm, CharSequence[] channels) {
		super(fm);
		this.data = channels;
	}

	@Override
	public Fragment getItem(int i) {
		return GedanDelegate.newInstance(data[i].toString());
	}

	@Override
	public int getCount() {
		return data.length;
	}
}
