package com.imooc.imooc_voice.view.home.search;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.event.KeywordsEvent;
import com.imooc.imooc_voice.view.home.search.sort.AlbumSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.MultipleSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.PlayListSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.RadioSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.SingerSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.SongSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.UserSearchDelegate;
import com.imooc.imooc_voice.view.home.search.sort.VideoSearchDelegate;
import com.imooc.lib_common_ui.delegate.MultiFragmentPagerAdapter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.navigator.CommonNavigatorCreater;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchResultDelegate extends NeteaseDelegate {

	@BindView(R2.id.tv_search_result_text)
	EditText mEtKeywords;
	@BindView(R2.id.magic_indicator_search_result)
	MagicIndicator mMagicIndicator;
	@BindView(R2.id.vp_search_result)
	ViewPager mViewPager;

	private static final String ARGS_KEYWORD = "ARGS_KEYWORD";

	private String[] mTitleData = {"综合","单曲","歌单","视频","歌手","专辑","主播电台","用户"};

	private String keywords;

	private List<NeteaseDelegate> mSearchResultDelegates = new ArrayList<>();

	public static SearchResultDelegate newInstance(String keyword) {
		final Bundle args = new Bundle();
		args.putString(ARGS_KEYWORD, keyword);
		final SearchResultDelegate delegate = new SearchResultDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			keywords = args.getString(ARGS_KEYWORD);
		}
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_search_result;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		//添加搜索结果Delegate
		//综合1018 单曲√ 云村 视频√ 歌手√ 专辑 歌单√ 主播电台√ 用户√
		MultipleSearchDelegate multipleSearchDelegate = new MultipleSearchDelegate();
		multipleSearchDelegate.setListener(new MultipleSearchDelegate.OnChangeViewerPagerPositionListener() {
			@Override
			public void onChangePosition(int position) {
				//切换Item
				mViewPager.setCurrentItem(position, true);
			}
		});
		mSearchResultDelegates.add(multipleSearchDelegate);
		mSearchResultDelegates.add(new SongSearchDelegate());
		mSearchResultDelegates.add(new PlayListSearchDelegate());
		mSearchResultDelegates.add(new VideoSearchDelegate());
		mSearchResultDelegates.add(new SingerSearchDelegate());
		mSearchResultDelegates.add(new AlbumSearchDelegate());
		mSearchResultDelegates.add(new RadioSearchDelegate());
		mSearchResultDelegates.add(new UserSearchDelegate());

		mEtKeywords.setText(keywords);
		mEtKeywords.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					EventBus.getDefault().postSticky(new KeywordsEvent(mEtKeywords.getText().toString(), true));
					//隐藏软键盘
					getSupportDelegate().hideSoftInput();
				}
				return false;
			}
		});

		MultiFragmentPagerAdapter searchResultPagerAdapter = new MultiFragmentPagerAdapter(getChildFragmentManager());
		searchResultPagerAdapter.init(mSearchResultDelegates);

		mViewPager.setAdapter(searchResultPagerAdapter);
		//mViewPager.setOffscreenPageLimit(5);

		//发送搜索关键字事件
		EventBus.getDefault().postSticky(new KeywordsEvent(keywords));
		CommonNavigator commonNavigator = CommonNavigatorCreater.setDefaultNavigator(getContext(), mTitleData, mViewPager);
		commonNavigator.setSmoothScroll(true);
		mMagicIndicator.setNavigator(commonNavigator);

		LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
		titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
		titleContainer.setDividerDrawable(new ColorDrawable() {
			@Override
			public int getIntrinsicWidth() {
				return UIUtil.dip2px(getContext(), 20);
			}
		});
		ViewPagerHelper.bind(mMagicIndicator, mViewPager);
	}

	@OnClick(R2.id.img_search_result_back)
	void onClickPop(){
		getSupportDelegate().hideSoftInput();
		getSupportDelegate().pop();
	}


}
