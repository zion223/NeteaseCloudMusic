package com.imooc.lib_common_ui.delegate.web;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;


import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.web.route.RouteKeys;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class WebDelegate extends NeteaseDelegate {

	private WebView mWebView = null;
	private String mUrl = null;
	private final ReferenceQueue<WebView> WEB_VIEW_QUEUE = new ReferenceQueue<>();

	private boolean mIsWebViewAvilable = false;
	private NeteaseDelegate mTopDelegate = null;
	public WebDelegate(){

	}
	//在实现类中实现 提供 Initializer
	public abstract IWebViewInitializer setInitializer();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//WebDelegateImpl 中传入的URL
		final Bundle args = getArguments();
		mUrl = args.getString(RouteKeys.URL.name());
		initWebView();
	}

	@SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
	private void initWebView(){
		if(mWebView != null){
			mWebView.removeAllViews();
			mWebView.destroy();
		}else{
			//实现类中获取的initializer
			final IWebViewInitializer initializer = setInitializer();
			if(initializer != null){
				final WeakReference<WebView> webViewWeakReference =
						new WeakReference<>(new WebView(getContext()),WEB_VIEW_QUEUE);
				mWebView = webViewWeakReference.get();
				//初始化webView :WebViewInitializer.initialWebView(WebView webView)
				mWebView = initializer.initWebView(mWebView);
				//设置webViewClient
				mWebView.setWebViewClient(initializer.initWebViewClient());
				//设置webChromeClient
				mWebView.setWebChromeClient(initializer.initWebChromeClient());
				//注入JS接口  在Configurator中加载的
				mIsWebViewAvilable = true;
			}else{
				throw new NullPointerException("initializer is null");
			}


		}
	}

	public WebView getWebView(){
		if(mWebView == null){
			throw new NullPointerException("webview is null");
		}
		return mIsWebViewAvilable ? mWebView : null;
	}
	public String getUrl(){
		if(mUrl == null){
			throw new NullPointerException("Url is null");
		}
		return mUrl;
	}
	public void setTopDelegate(NeteaseDelegate delegate) {
		mTopDelegate = delegate;
	}

	public NeteaseDelegate getTopDelegate() {
		if (mTopDelegate == null) {
			mTopDelegate = this;
		}
		return mTopDelegate;
	}

	//生命周期绑定
	@Override
	public void onPause() {
		super.onPause();
		if(mWebView != null){
			mWebView.onPause();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if(mWebView != null){
			mWebView.onResume();
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mIsWebViewAvilable = false;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if(mWebView != null){
			mWebView.removeAllViews();
			mWebView.destroy();
			mWebView = null;
		}
	}
}
