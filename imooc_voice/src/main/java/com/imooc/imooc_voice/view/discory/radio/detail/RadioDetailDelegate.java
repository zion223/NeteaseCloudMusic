package com.imooc.imooc_voice.view.discory.radio.detail;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjDetailBean;
import com.imooc.lib_common_ui.delegate.MultiFragmentPagerAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_common_ui.dialog.UnsubscribeRadioDialog;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.lxj.xpopup.XPopup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

public class RadioDetailDelegate extends NeteaseLoadingDelegate implements View.OnClickListener {

	private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";


	private TextView mTvRadioTitle;
	private TextView mTvRadioSubscribed;
	private TextView mTvRadioSubscrib;
	private ImageView mIvAppbarBackground;
	private ImageView mIvBack;
	private MagicIndicator mRadioMagicIndicator;
	private ViewPager mRadioViewPager;

	private String rid;
	private ImageLoaderManager manager;
	private MultiFragmentPagerAdapter mAdapter ;
	private static CharSequence[] mTitleDataList = new CharSequence[2];

	public static RadioDetailDelegate newInstance(long id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_RADIO_ID, String.valueOf(id));
		final RadioDetailDelegate delegate = new RadioDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			rid = args.getString(ARGS_RADIO_ID);
		}
		manager = ImageLoaderManager.getInstance();

	}




	@Override
	public void initView() {
		mTvRadioTitle = rootView.findViewById(R.id.tv_radio_detail_title);
		mTvRadioSubscribed = rootView.findViewById(R.id.tv_radio_detail_subscribed);
		mTvRadioSubscrib = rootView.findViewById(R.id.tv_radio_detail_subscrib);
		mTvRadioSubscrib.setOnClickListener(this);
		mIvBack = rootView.findViewById(R.id.img_radio_detail_back);
		mIvBack.setOnClickListener(this);
		mIvAppbarBackground = rootView.findViewById(R.id.iv_background_radio_detail);
		mIvAppbarBackground.setImageAlpha(125);
		mRadioMagicIndicator = rootView.findViewById(R.id.magic_radio_indicator);
		mRadioViewPager = rootView.findViewById(R.id.view_pager_radio_detail);


		RequestCenter.getRadioDetail(rid, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				DjDetailBean bean = (DjDetailBean) responseObj;
				//电台名称
				mTvRadioTitle.setText(bean.getDjRadio().getName());
				//订阅数
				int subCount = bean.getDjRadio().getSubCount();
				mTvRadioSubscribed.setText(SearchUtil.getCorresPondingString(subCount) + "人已订阅");
				manager.displayImageForView(mIvAppbarBackground, bean.getDjRadio().getPicUrl());
				boolean subed = bean.getDjRadio().isSubed();

				if (subed) {
					mTvRadioSubscrib.setText("已订阅");
					mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.border_radio_subscribed));
					mTvRadioSubscrib.setTag(true);
				} else {
					mTvRadioSubscrib.setText("订阅");
					mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.bg_round_red));
					mTvRadioSubscrib.setTag(false);
				}

				final List<NeteaseDelegate> mDelegates = new ArrayList<>();
				//添加电台主页
				mDelegates.add(RadioInfoDelegate.newInstance(rid));
				//
				mDelegates.add(RadioProgramDelegate.newInstance(rid));
				mAdapter = new MultiFragmentPagerAdapter(getChildFragmentManager());
				mAdapter.init(mDelegates);
				mRadioViewPager.setAdapter(mAdapter);
				mRadioViewPager.setCurrentItem(1);

				mTitleDataList[0] = "详情";
				SpannableString msp = new SpannableString("节目" + bean.getDjRadio().getProgramCount());
				msp.setSpan(new AbsoluteSizeSpan(30), 2, msp.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				mTitleDataList[1] = msp;
				initMagicIndicator();
				addRootView();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_radio_deatail;
	}

	private void initMagicIndicator() {
		mRadioMagicIndicator.setBackgroundColor(Color.WHITE);
		CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), mTitleDataList, mRadioViewPager);
		commonNavigator.setAdjustMode(true);
		mRadioMagicIndicator.setNavigator(commonNavigator);
		mRadioMagicIndicator.onPageSelected(1);
		ViewPagerHelper.bind(mRadioMagicIndicator, mRadioViewPager);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.img_radio_detail_back:
				getSupportDelegate().pop();
				break;
			case R.id.tv_radio_detail_subscrib:
				changeSubscribeState();
				break;

		}
	}

	private void changeSubscribeState() {
		//已经订阅 取消订阅需要确认
		if((boolean)mTvRadioSubscrib.getTag()){
			UnsubscribeRadioDialog dialog = new UnsubscribeRadioDialog(getContext(), new UnsubscribeRadioDialog.IConfirmUnsubscribeListener() {
				@Override
				public void onConfirm() {
					//已经订阅则取消订阅
					RequestCenter.getSubRadio(rid, false, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							mTvRadioSubscrib.setText("订阅");
							mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.bg_round_red));
							mTvRadioSubscrib.setTag(!(boolean) mTvRadioSubscrib.getTag());
						}

						@Override
						public void onFailure(Object reasonObj) {

						}
					});
				}
			});
			new XPopup.Builder(getContext())
					.asCustom(dialog)
					.show();
		}else{
			//订阅电台
			RequestCenter.getSubRadio(rid, true, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {

					mTvRadioSubscrib.setText("已订阅");
					mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.border_radio_subscribed));
					mTvRadioSubscrib.setTag(!(boolean) mTvRadioSubscrib.getTag());
				}

				@Override
				public void onFailure(Object reasonObj) {

				}
			});
		}


	}


}
