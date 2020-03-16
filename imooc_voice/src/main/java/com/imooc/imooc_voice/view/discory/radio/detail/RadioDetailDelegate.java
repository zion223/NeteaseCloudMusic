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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.dj.DjDetailBean;
import com.imooc.imooc_voice.view.mine.tab.artist.ArtistDelegate;
import com.imooc.imooc_voice.view.mine.tab.music.MusicDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

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

public class RadioDetailDelegate extends NeteaseLoadingDelegate {

    @BindView(R2.id.loadframe)
    FrameLayout frameLayout;

    private TextView mTvRadioTitle;
    private TextView mTvRadioSubscrib;
    private ImageView mIvAppbarBackground;
    private MagicIndicator mRadioMagicIndicator;
    private ViewPager mRadioViewPager;
    private View rootView;

    private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";
    private ImageLoaderManager manager;
    private String id;
    private static CharSequence[] mTitleDataList = new CharSequence[2];

    static RadioDetailDelegate newInstance(String id){
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
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_empty;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
        super.onBindView(savedInstanceState, view);
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.delegate_empty, frameLayout, false);
        mTvRadioTitle = rootView.findViewById(R.id.tv_radio_detail_title);
        mTvRadioSubscrib = rootView.findViewById(R.id.tv_radio_detail_subscribed);
        mIvAppbarBackground = rootView.findViewById(R.id.iv_background_radio_detail);
        mRadioMagicIndicator = rootView.findViewById(R.id.magic_radio_indicator);
        mRadioViewPager = rootView.findViewById(R.id.view_pager_radio_detail);
        RequestCenter.getRadioDetail(id, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                DjDetailBean bean = (DjDetailBean) responseObj;
                mTvRadioTitle.setText(bean.getDjRadio().getName());
                mTvRadioSubscrib.setText(bean.getDjRadio().getSubCount() + "已订阅");
                manager.displayImageForView(mIvAppbarBackground, bean.getDjRadio().getPicUrl());
                mTitleDataList[0] = "主播";
                SpannableString msp = new SpannableString("节目(" + bean.getDjRadio().getSubCount()+")");
                msp.setSpan(new AbsoluteSizeSpan(11), 3, msp.toString().indexOf(")"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                mTitleDataList[1] = msp;
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
        //获取节目数量

        initMagicIndicator();
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
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
                colorTransitionPagerTitleView.setSelectedColor(Color.RED);
                colorTransitionPagerTitleView.setTextSize(14);
                colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
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
        ViewPagerHelper.bind(mRadioMagicIndicator, mRadioViewPager);
    }

    @Override
    public void post(Runnable runnable) {

    }
    @OnClick(R2.id.img_radio_detail_back)
    void onClickBack(){
        getSupportDelegate().pop();
    }


    static class RadioTabAdapter extends FragmentPagerAdapter {

        public RadioTabAdapter(FragmentManager fm) {
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
            return 2;
        }
    }
}
