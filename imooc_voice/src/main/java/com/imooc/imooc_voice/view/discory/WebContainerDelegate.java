package com.imooc.imooc_voice.view.discory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.web.WebDelegateImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class WebContainerDelegate extends NeteaseDelegate {


	@BindView(R2.id.tv_webcontainer_title)
	TextView mTvTitle;

	private static final String ARGS_WEB_URL = "ARGS_WEB_URL";

	private String mUrl;

	public static WebContainerDelegate newInstance(String url) {
		final Bundle args = new Bundle();
		args.putString(ARGS_WEB_URL, url);
		final WebContainerDelegate delegate = new WebContainerDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			mUrl = args.getString(ARGS_WEB_URL);
		}
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_webcontainer;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		final WebDelegateImpl webDelegate = WebDelegateImpl.create(mUrl);
		webDelegate.setListener(title -> {
			mTvTitle.setText(title);
			mTvTitle.setSelected(true);
		});
		webDelegate.setTopDelegate(getParentDelegate());

		getSupportDelegate().loadRootFragment(R.id.frame_web, webDelegate);
	}

	@OnClick(R2.id.img_tab_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}
}
