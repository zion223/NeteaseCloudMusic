package com.imooc.lib_common_ui.delegate.web;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public interface IWebViewInitializer {

	WebView initWebView(WebView webView);

	WebViewClient initWebViewClient();

	WebChromeClient initWebChromeClient();
}
