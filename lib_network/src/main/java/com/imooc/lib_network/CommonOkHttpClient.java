package com.imooc.lib_network;


import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.imooc.lib_network.app.OkHttpHelper;
import com.imooc.lib_network.listener.DisposeDataHandler;
import com.imooc.lib_network.response.CommonJsonCallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CommonOkHttpClient {

	private static final int TIME_OUT = 30;

	private static OkHttpClient mOkHttpClient;

	static{
		OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
		okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
		okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
		okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
		ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(OkHttpHelper.getContext()));
		okHttpClientBuilder.cookieJar(cookieJar);
		//重定向
		okHttpClientBuilder.followRedirects(true);
		okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		//添加拦截器

		okHttpClientBuilder.addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				final Request request = chain.request().newBuilder()
						.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36").build();
				return chain.proceed(request);
			}
		});

		mOkHttpClient = okHttpClientBuilder.build();

	}

	public static OkHttpClient getOkHttpClient() {
		return mOkHttpClient;
	}

	public static Call get(Request request, DisposeDataHandler handle) {
		Call call = mOkHttpClient.newCall(request);
		call.enqueue(new CommonJsonCallback(handle));
		return call;
	}

	public static Call post(Request request, DisposeDataHandler handle) {
		Call call = mOkHttpClient.newCall(request);
		call.enqueue(new CommonJsonCallback(handle));
		return call;
	}
}
