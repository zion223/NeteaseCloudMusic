package com.imooc.imooc_voice.view.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.CHANNEL;
import com.imooc.imooc_voice.model.login.LoginEvent;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.view.home.adapter.HomePagerAdapter;
import com.imooc.imooc_voice.view.home.title.ScaleTransitionPagerTitleView;
import com.imooc.imooc_voice.view.login.LoginActivity;
import com.imooc.imooc_voice.view.login.UserManager;
import com.imooc.imooc_voice.view.search.SearchDelegate;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeDelegate extends NeteaseDelegate implements View.OnClickListener {


	//首页的卡片
	private static final CHANNEL[] CHANNELS =
			new CHANNEL[]{CHANNEL.MY, CHANNEL.DISCORY, CHANNEL.FRIEND};

	/*
	 * View
	 */
	@BindView(R2.id.search_view)
	View mSearchView;
	@BindView(R2.id.view_pager)
	ViewPager mViewPager;
	@BindView(R2.id.magic_indicator)
	MagicIndicator magicIndicator;
	@BindView(R2.id.base_drawer_layout)
	DrawerLayout mDrawerLayout;

	private SharePreferenceUtil sharePreferenceUtil;

	private HomePagerAdapter mAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_main;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		initView();
		initData();
		sharePreferenceUtil = SharePreferenceUtil.getInstance(getContext());
	}

	private void initData() {
		ArrayList<AudioBean> mLists = new ArrayList<>();
		mLists.add(
				new AudioBean("100002", "http://sq-sycdn.kuwo.cn/resource/n1/98/51/3777061809.mp3", "勇气",
						"梁静茹", "勇气", "华语流行乐女歌手梁静茹演唱的一首疗伤情歌",
						"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559698193627&di=711751f16fefddbf4cbf71da7d8e6d66&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D213168965%2C1040740194%26fm%3D214%26gp%3D0.jpg",
						"4:40"));
		mLists.add(
				new AudioBean("100003", "http://sp-sycdn.kuwo.cn/resource/n2/52/80/2933081485.mp3", "灿烂如你",
						"汪峰", "春天里", "摇滚歌手汪峰演唱的歌曲",
						"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559698239736&di=3433a1d95c589e31a36dd7b4c176d13a&imgtype=0&src=http%3A%2F%2Fpic.zdface.com%2Fupload%2F201051814737725.jpg",
						"3:20"));
		mLists.add(
				new AudioBean("100004", "http://sr-sycdn.kuwo.cn/resource/n2/33/25/2629654819.mp3", "小幸运",
						"田馥甄", "小幸运", "田馥甄 演唱的歌曲",
						"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559698289780&di=5146d48002250bf38acfb4c9b4bb6e4e&imgtype=0&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20131220%2Fbki-20131220170401-1254350944.jpg",
						"2:45"));
		AudioHelper.startMusicService(mLists);
	}


	//初始化控件
	private void initView() {
		mSearchView.setOnClickListener(this);
		mAdapter = new HomePagerAdapter(getChildFragmentManager(), CHANNELS);
		mViewPager.setAdapter(mAdapter);
		initMagicIndicator();
	}

	private void initMagicIndicator() {
		magicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = new CommonNavigator(getContext());
		commonNavigator.setAdjustMode(true);
		commonNavigator.setAdapter(new CommonNavigatorAdapter() {
			@Override
			public int getCount() {
				return CHANNELS.length;
			}

			@Override
			public IPagerTitleView getTitleView(Context context, final int index) {
				final SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
				simplePagerTitleView.setText(CHANNELS[index].getKey());
				simplePagerTitleView.setTextSize(19);
				simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
				simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));
				simplePagerTitleView.setSelectedColor(Color.parseColor("#333333"));
				simplePagerTitleView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						mViewPager.setCurrentItem(index);
					}
				});
				return simplePagerTitleView;
			}

			@Override
			public IPagerIndicator getIndicator(Context context) {
				return null;
			}

			@Override
			public float getTitleWeight(Context context, int index) {
				return 1.0f;
			}
		});
		magicIndicator.setNavigator(commonNavigator);
		ViewPagerHelper.bind(magicIndicator, mViewPager);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.unloggin_layout:
				if (sharePreferenceUtil.getAuthToken("").equals("")) {
					//跳转到LoginActivity
					LoginActivity.start(getContext());
				} else {
					mDrawerLayout.closeDrawer(Gravity.LEFT);
				}
				break;
			case R.id.search_view:
				getSupportDelegate().start(new SearchDelegate());
				break;
			default:
				break;

		}
	}

	//主线程执行
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onLoginEvent(LoginEvent event) {
		//登陆成功
		//unLogginLayout.setVisibility(View.GONE);
		//mPhotoView.setVisibility(View.VISIBLE);
		//ImageLoaderManager.getInstance()
				//.displayImageForCircle(mPhotoView, UserManager.getInstance().getUser().data.photoUrl);
	}

	@Override
	public void post(Runnable runnable) {

	}

	@OnClick(R2.id.toggle_view)
	void ClickToggle(){
		if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
			mDrawerLayout.closeDrawer(Gravity.LEFT);
			BaseDelegate.musicView.getBackground().setAlpha(255);
		} else {
			mDrawerLayout.openDrawer(Gravity.LEFT);
			BaseDelegate.musicView.getBackground().setAlpha(122);
		}
	}
}
