package com.imooc.imooc_voice.view.mine.tab;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.PreferencesUtil;
import com.imooc.imooc_voice.util.SortOrder;
import com.imooc.imooc_voice.view.mine.tab.view.SortPopupDialog;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import butterknife.BindView;
import butterknife.OnClick;

public class TabDelegate extends NeteaseDelegate{


	@BindView(R2.id.magic_indicator_tab)
	MagicIndicator mTabMagicIndicator;
	@BindView(R2.id.view_pager_tab)
	ViewPager mTabViewPager;
	@BindView(R2.id.img_tab_more)
	ImageView mTabMore;



	private TabAdapter mAdapter;
	private BasePopupView tabMoreDialog;
	private PreferencesUtil preferencesUtil;
	private static final String[] mTitleDataList = {"单曲","歌手","专辑","文件夹"};
	private static final SortPopupDialog.SortType[] mFramentType =
			{SortPopupDialog.SortType.SONG, SortPopupDialog.SortType.AITIST, SortPopupDialog.SortType.ALBUM, SortPopupDialog.SortType.FOLDER};
	@Override
	public Object setLayout() {
		return R.layout.delegate_tab;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		mAdapter = new TabAdapter(getChildFragmentManager());
		mTabViewPager.setAdapter(mAdapter);
		initMagicIndicator();
		initDialog();
		preferencesUtil = PreferencesUtil.getInstance(getContext());
	}

	private void initMagicIndicator() {
		mTabMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = new CommonNavigator(getContext());
		commonNavigator.setAdjustMode(true);
		commonNavigator.setAdapter(new CommonNavigatorAdapter() {
			@Override
			public int getCount() {
				return 4;
			}

			@Override
			public IPagerTitleView getTitleView(Context context, final int index) {
				ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
				colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
				colorTransitionPagerTitleView.setSelectedColor(Color.RED);
				colorTransitionPagerTitleView.setTextSize(14);
				colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
				colorTransitionPagerTitleView.setText(mTitleDataList[index]);
				colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						mTabViewPager.setCurrentItem(index);
					}
				});
				return colorTransitionPagerTitleView;
			}

			@Override
			public IPagerIndicator getIndicator(Context context) {
				LinePagerIndicator indicator = new LinePagerIndicator(context);
				indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
				indicator.setColors(Color.RED);
				return indicator;
			}

			@Override
			public float getTitleWeight(Context context, int index) {
				return 1.0f;
			}
		});
		mTabMagicIndicator.setNavigator(commonNavigator);
		ViewPagerHelper.bind(mTabMagicIndicator, mTabViewPager);

	}

	private void initDialog() {
		tabMoreDialog = new XPopup.Builder(getContext())
				.atView(mTabMore)
				//背景不变灰色
				.hasShadowBg(false)
				.asAttachList(new String[]{"下载管理", "扫描本地音乐", "选择排序方式", "获取封面歌词"},
						new int[]{R.drawable.a0g, R.drawable.b9f, R.drawable.b9f, R.drawable.b9f},
						new OnSelectListener() {
							@Override
							public void onSelect(int position, String text) {
								switch (position){
									case 0:
										break;
									case 1:
										break;
									case 2:

										int currentItem = mTabViewPager.getCurrentItem();
										final BasePopupView sortDialog = new XPopup.Builder(getContext())
												.asCustom(new SortPopupDialog(getContext(), new SortPopupDialog.OnSelectMenuListener() {
													@Override
													public void onMenuSelected(String type) {
														//更新排序Adapter

													}
												}, mFramentType[currentItem]));
										//根据当前Delegate判断显示不同的排序方式
										sortDialog.show();
										break;
									case 3:
										break;
									default:
										break;

								}
							}
						});

	}

	@Override
	public void post(Runnable runnable) {

	}

	@OnClick(R2.id.img_tab_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}

	@OnClick(R2.id.img_tab_more)
	void onClickMore(){
		tabMoreDialog.show();
	}




}
