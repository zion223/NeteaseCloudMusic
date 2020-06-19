package com.imooc.lib_network.response;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.imooc.lib_network.exception.OkHttpException;
import com.imooc.lib_network.listener.DisposeDataHandler;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CommonJsonCallback implements Callback {

	//处理线程
	private final Handler mDiveryHandler;
	//处理回调
	private final DisposeDataListener mDisposeDataListener;
	//转成实体类
	private final Class<?> mClass;

	private final String RESULT_CODE = "code"; // 有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
	protected final int RESULT_CODE_VALUE = 0;
	protected final String ERROR_MSG = "emsg";
	private final String EMPTY_MSG = "";
	private final String NEED_LOGIN = "NEED_LOGIN";
	protected final String COOKIE_STORE = "Set-Cookie"; // decide the server it

	private static final Integer NETWORK_ERROR = -1;
	private static final Integer JSON_ERROR = -2;
	private static final Integer OTHER_ERROR = -3;

	public CommonJsonCallback(DisposeDataHandler handler) {
		this.mDisposeDataListener = handler.mListener;
		this.mDiveryHandler = new Handler(Looper.getMainLooper());
		mClass = handler.mClass;
	}


	@Override
	public void onFailure(Call call, final IOException e) {
		mDiveryHandler.post(new Runnable() {
			@Override
			public void run() {
				mDisposeDataListener.onFailure(e);
			}
		});
	}

	@Override
	public void onResponse(Call call, final Response response) throws IOException {
		final String result = response.body().string();
		mDiveryHandler.post(new Runnable() {
			@Override
			public void run() {
				handleResponse(result);
			}
		});
	}

	/**
	 * 处理数据
	 *
	 * @param response
	 */
	private void handleResponse(Object response) {

		if (response.toString().trim().equals("")) {
			mDisposeDataListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
			return;
		}
		try {
			JSONObject resultJson = new JSONObject(response.toString());
			if (mClass == null) {
				mDisposeDataListener.onSuccess(resultJson);
			} else {
				Object obj = new Gson().fromJson(response.toString(), mClass);
				if (obj != null) {
					mDisposeDataListener.onSuccess(obj);
				} else {
					mDisposeDataListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			mDisposeDataListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
		}

	}
}