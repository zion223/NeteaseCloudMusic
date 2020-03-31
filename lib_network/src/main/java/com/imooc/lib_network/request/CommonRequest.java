package com.imooc.lib_network.request;

import android.util.Log;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

public class CommonRequest {

	private static final String TAG = "CommonRequest";

	public static Request createPostRequest(String url, RequestParams params){
		return createPostRequest(url, params, null);
	}


	public static Request createPostRequest(String url, RequestParams params, RequestParams headers){
		FormBody.Builder mFormBodyBuild = new FormBody.Builder();
		if(params != null){
			for(Map.Entry<String, String> entry : params.urlParams.entrySet()){
				mFormBodyBuild.add(entry.getKey(), entry.getValue());
			}
		}
		//添加请求头
		Headers.Builder mHeaderBuild = new Headers.Builder();

		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
				mHeaderBuild.add(entry.getKey(), entry.getValue());
			}
		}
		FormBody mFormBody = mFormBodyBuild.build();
		Headers mHeader = mHeaderBuild.build();

		return new Request.Builder().url(url).post(mFormBody).headers(mHeader).build();
	}

	public static Request createGetRequest(String url, RequestParams params) {
		return createGetRequest(url, params, null);
	}


	public static Request createGetRequest(String url, RequestParams params, RequestParams headers) {
		StringBuilder urlBuilder = new StringBuilder(url).append("?");
		if (params != null) {
			for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
				urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
		}
		//添加请求头
		Headers.Builder mHeaderBuild = new Headers.Builder();
		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
				mHeaderBuild.add(entry.getKey(), entry.getValue());
			}
		}
		Headers mHeader = mHeaderBuild.build();
		Log.d(TAG, "requestUrl:" + urlBuilder.substring(0, urlBuilder.length() - 1));
		return new Request.Builder()
				.url(urlBuilder.substring(0, urlBuilder.length() - 1))
				.get()
				.headers(mHeader)
				.build();
	}


}
