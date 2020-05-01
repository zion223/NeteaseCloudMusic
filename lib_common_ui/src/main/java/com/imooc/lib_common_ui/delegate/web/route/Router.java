package com.imooc.lib_common_ui.delegate.web.route;

import android.webkit.WebView;

import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.web.WebDelegate;
import com.imooc.lib_common_ui.delegate.web.WebDelegateImpl;


public class Router {
	private Router() {

	}

	private static class Holder {
		private static final Router INSTANCE = new Router();
	}

	public static Router getInstance() {
		return Holder.INSTANCE;
	}

	public final boolean handleWebUrl(WebDelegate delegate, String url) {

		//针对不同的协议进行处理
		if (url.contains("tel:")) {
			//拨打电话
			return true;
		}
		final NeteaseDelegate topDelegate = delegate.getTopDelegate();
		final WebDelegateImpl webDelegate = WebDelegateImpl.create(url);

		topDelegate.getSupportDelegate().start(webDelegate);
		return true;
	}

	public final void loadPage(WebView webView,String url){

		//判断本地路径 OR 远程路径
		loadLocalPage(webView,url);
	}
	//重载方法
	public final void loadPage(WebDelegate delegate,String url){
		loadPage(delegate.getWebView(),url);
	}

	//加载url页面
	private void loadWebPage(WebView webView, String url){
		if(webView != null){
			webView.loadUrl(url);
		}else{
			throw new NullPointerException("webview is null");
		}
	}
	private void loadLocalPage(WebView webView, String url){
		loadWebPage(webView, url);
	}

}
