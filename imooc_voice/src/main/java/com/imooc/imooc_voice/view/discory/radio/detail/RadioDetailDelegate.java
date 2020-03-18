package com.imooc.imooc_voice.view.discory.radio.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.dj.DjDetailBean;
import com.imooc.imooc_voice.model.radio.RadioProgramLoadEvent;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_common_ui.dialog.UnsubscribeRadioDialog;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.lxj.xpopup.XPopup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class RadioDetailDelegate extends NeteaseLoadingDelegate implements View.OnClickListener {

	@BindView(R2.id.loadframe)
	FrameLayout frameLayout;

	private TextView mTvRadioTitle;
	private TextView mTvRadioSubscribed;
	private TextView mTvRadioSubscrib;
	private ImageView mIvAppbarBackground;
	private ImageView mIvBack;
	private MagicIndicator mRadioMagicIndicator;
	private ViewPager mRadioViewPager;
	private View rootView;

	private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";
	private ImageLoaderManager manager;
	private String id;
	// for InfoDelegate
	private String img;
	private String name;
	private String rcmd;
	private String info;
	private String sort;

	private static CharSequence[] mTitleDataList = new CharSequence[2];

	public static RadioDetailDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_RADIO_ID, id);
		final RadioDetailDelegate delegate = new RadioDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			id = args.getString(ARGS_RADIO_ID);
		}
		manager = ImageLoaderManager.getInstance();
		EventBus.getDefault().register(this);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		EventBus.getDefault().unregister(this);
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);

		rootView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_empty, frameLayout, false);
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


		RequestCenter.getRadioDetail(id, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjDetailBean bean = (DjDetailBean) responseObj;
				mTvRadioTitle.setText(bean.getDjRadio().getName());
				mTvRadioSubscribed.setText(bean.getDjRadio().getSubCount() + "人已订阅");
				manager.displayImageForView(mIvAppbarBackground, bean.getDjRadio().getPicUrl());
				boolean subed = bean.getDjRadio().isSubed();
				if (subed) {
					mTvRadioSubscrib.setText("已订阅");
					mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.border_radio_subscribed));
					mTvRadioSubscrib.setTag(true);
				} else {
					mTvRadioSubscrib.setText("订阅");
					mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.bg_collect));
					mTvRadioSubscrib.setTag(false);
				}
				img = bean.getDjRadio().getDj().getAvatarUrl();
				name = bean.getDjRadio().getDj().getNickname();
				rcmd = bean.getDjRadio().getDj().getSignature();
				info = bean.getDjRadio().getDesc();
				sort = bean.getDjRadio().getCategory();

				mRadioViewPager.setAdapter(new RadioTabAdapter(getChildFragmentManager()));
				mRadioViewPager.setCurrentItem(1);

				mTitleDataList[0] = "详情";
				SpannableString msp = new SpannableString("节目" + bean.getDjRadio().getProgramCount());
				msp.setSpan(new AbsoluteSizeSpan(30), 2, msp.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				mTitleDataList[1] = msp;
				initMagicIndicator();
				Netease.getHandler().postDelayed(new Runnable() {
					@Override
					public void run() {
						frameLayout.removeAllViews();
						//framelayout 创建了新的实例
						ViewGroup p = (ViewGroup) rootView.getParent();
						if (p != null) {
							p.removeAllViewsInLayout();
						}
						frameLayout.addView(rootView);
					}
				}, 500);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});


	}

	private void initMagicIndicator() {
		mRadioMagicIndicator.setBackgroundColor(Color.WHITE);

		CommonNavigator commonNavigator = new CommonNavigator(getContext());
		commonNavigator.setAdjustMode(true);
		commonNavigator.setAdapter(new CommonNavigatorAdapter() {
			@Override
			public int getCount() {
				return 2;
			}

			@Override
			public IPagerTitleView getTitleView(Context context, final int index) {
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				params.setMargins(0, 0, 0, 10);
				ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
				colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
				colorTransitionPagerTitleView.setSelectedColor(Color.RED);
				colorTransitionPagerTitleView.setTextSize(14);
				colorTransitionPagerTitleView.setLayoutParams(params);
				colorTransitionPagerTitleView.setText(mTitleDataList[index]);
				colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						mRadioViewPager.setCurrentItem(index);
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

		mRadioMagicIndicator.setNavigator(commonNavigator);
		mRadioMagicIndicator.onPageSelected(1);
		ViewPagerHelper.bind(mRadioMagicIndicator, mRadioViewPager);
	}

	@Override
	public void post(Runnable runnable) {

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
					RequestCenter.getSubRadio(id, false, new DisposeDataListener() {
						@Override
						public void onSuccess(Object responseObj) {
							mTvRadioSubscrib.setText("订阅");
							mTvRadioSubscrib.setBackground(getResources().getDrawable(R.drawable.bg_collect));
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
			RequestCenter.getSubRadio(id, true, new DisposeDataListener() {
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

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void loadProgramFinish(RadioProgramLoadEvent event) {

	}

	class RadioTabAdapter extends FragmentPagerAdapter {

		RadioTabAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			switch (i) {
				case 0:
					return RadioInfoDelegate.newInstance(img, name, rcmd, info, sort);
				case 1:
					return RadioProgramDelegate.newInstance(id);
				default:
					break;
			}
			return null;
		}

		@Override
		public int getCount() {
			return 2;
		}
	}
}
