package com.imooc.lib_common_ui.delegate.web;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.imooc.lib_common_ui.delegate.web.chromclient.WebChromClientImpl;
import com.imooc.lib_common_ui.delegate.web.client.WebViewClientImpl;
import com.imooc.lib_common_ui.delegate.web.route.RouteKeys;
import com.imooc.lib_common_ui.delegate.web.route.Router;

public class WebDelegateImpl extends WebDelegate implements IWebViewInitializer{

	private OnInitWebTitleListener mListener;

	public static WebDelegateImpl create(String url){
		final Bundle args = new Bundle();
		args.putString(RouteKeys.URL.name(), url);
		WebDelegateImpl webDelegate = new WebDelegateImpl();
		webDelegate.setArguments(args);
		return webDelegate;
	}

	@Override
	public IWebViewInitializer setInitializer() {
		return this;
	}

	@Override
	public Object setLayout() {
		return getWebView();
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		//跳转URL
		if(getUrl() != null){
			//原生的webView 方法进行加载
			Router.getInstance().loadPage(this, getUrl());
		}
	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public WebView initWebView(WebView webView) {
		return new WebViewInitializer().initialWebView(webView);
	}

	@Override
	public WebViewClient initWebViewClient() {
		return new WebViewClientImpl(this);
	}

	@Override
	public WebChromeClient initWebChromeClient() {
		return new WebChromClientImpl(){
			@Override
			public void onReceivedTitle(WebView view, String title) {
				if(mListener != null){
					mListener.onInitTitle(title);
				}
				super.onReceivedTitle(view, title);
			}
		};
	}

	public void setListener(OnInitWebTitleListener mListener) {
		this.mListener = mListener;
	}

	public interface OnInitWebTitleListener{
		void onInitTitle(String title);
	}
}
