package com.imooc.lib_common_ui.delegate.web.chromclient;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebChromClientImpl extends WebChromeClient {
	@Override
	public void onReceivedTitle(WebView view, String title) {
		super.onReceivedTitle(view, title);
	}
}
