package com.imooc.imooc_voice.view.mine.local;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.imooc.imooc_voice.view.mine.local.artist.ArtistDelegate;
import com.imooc.imooc_voice.view.mine.local.music.MusicDelegate;

public class TabAdapter extends FragmentPagerAdapter {


	public TabAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i){
			case 0:
				return new MusicDelegate();
			case 1:
				return new ArtistDelegate();
			default:
				return new MusicDelegate();
		}
	}

	@Override
	public int getCount() {
		return 4;
	}
}
