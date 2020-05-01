package com.imooc.lib_common_ui.delegate.web.client;

import android.webkit.WebView;

import com.imooc.lib_common_ui.delegate.web.WebDelegate;
import com.imooc.lib_common_ui.delegate.web.route.Router;


public class WebViewClientImpl extends android.webkit.WebViewClient {

	private final WebDelegate DELEGATE;

	public WebViewClientImpl(WebDelegate delegate) {
		DELEGATE = delegate;
	}

	/**
	 * 接管要加载的 URL
	 * @param view
	 * @param url
	 * @return
	 */
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return Router.getInstance().handleWebUrl(DELEGATE, url);
	}


}
