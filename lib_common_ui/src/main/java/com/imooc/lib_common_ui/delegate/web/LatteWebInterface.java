package com.imooc.lib_common_ui.delegate.web;


import android.webkit.JavascriptInterface;

//import com.alibaba.fastjson.JSON;
import com.imooc.lib_common_ui.delegate.web.event.Event;
import com.imooc.lib_common_ui.delegate.web.event.EventManager;

public class LatteWebInterface {

	private final WebDelegate DELEGATE;

	private LatteWebInterface(WebDelegate delegate) {
		DELEGATE = delegate;
	}
	public static LatteWebInterface create(WebDelegate delegate){
		return new LatteWebInterface(delegate);
	}

	@JavascriptInterface
	public String event(String params){
//		final String action = JSON.parseObject(params).getString("action");
//
//		final Event event = EventManager.getInstance().queryEvent(action);
//		if(event != null){
//			event.setAction(action);
//			event.setContent(DELEGATE.getContext());
//			event.setWebDelegate(DELEGATE);
//			event.setUrl(DELEGATE.getUrl());
//			return event.execute(params);
//		}
		return null;
	}
}
