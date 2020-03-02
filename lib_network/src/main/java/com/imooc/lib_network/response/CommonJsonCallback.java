package com.imooc.lib_network.response;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.imooc.lib_network.exception.OkHttpException;
import com.imooc.lib_network.listener.DisposeDataHandler;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.json.JSONException;
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

	protected final String RESULT_CODE = "ecode"; // 有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
	protected final int RESULT_CODE_VALUE = 0;
	protected final String ERROR_MSG = "emsg";
	private final String EMPTY_MSG = "";
	protected final String COOKIE_STORE = "Set-Cookie"; // decide the server it

	private static final Integer NETWORK_ERROR = -1;
	private static final Integer JSON_ERROR = -2;
	private static final Integer OTHER_ERROR = -3;

	public CommonJsonCallback(DisposeDataHandler handler){
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
		mDiveryHandler.post(new Runnable() {
			@Override
			public void run() {
				handleResponse(response);
			}
		});
	}

	/**
	 * 处理数据
	 * @param response
	 */
	private void handleResponse(Response response) {

		if(response.toString().trim().equals("")){
			mDisposeDataListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
			return;
		}
		try {
			String result = response.body().string();
			JSONObject resultJson = new JSONObject(result);
			if (mClass == null) {
				mDisposeDataListener.onSuccess(resultJson);
			} else {
				Object obj = new Gson().fromJson(result, mClass);
				if (obj != null) {
					mDisposeDataListener.onSuccess(obj);
				} else {
					mDisposeDataListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 *  4749-4749/com.imooc.imooc_voice I/QarthLog: [PatchStore] create disable file for com.imooc.imooc_voice uid is 10213
	 * 2020-02-23 14:14:06.067 4749-4749/com.imooc.imooc_voice E/AndroidRuntime: FATAL EXCEPTION: main
	 *     Process: com.imooc.imooc_voice, PID: 4749
	 *     java.lang.NoClassDefFoundError: Failed resolution of: Lcom/google/gson/Gson;
	 *         at com.imooc.lib_network.response.CommonJsonCallback.handleResponse(CommonJsonCallback.java:82)
	 *         at com.imooc.lib_network.response.CommonJsonCallback.access$100(CommonJsonCallback.java:20)
	 *         at com.imooc.lib_network.response.CommonJsonCallback$2.run(CommonJsonCallback.java:61)
	 *         at android.os.Handler.handleCallback(Handler.java:888)
	 *         at android.os.Handler.dispatchMessage(Handler.java:100)
	 *         at android.os.Looper.loop(Looper.java:213)
	 *         at android.app.ActivityThread.main(ActivityThread.java:8147)
	 *         at java.lang.reflect.Method.invoke(Native Method)
	 *         at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:513)
	 *         at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1101)
	 *      Caused by: java.lang.ClassNotFoundException: Didn't find class "com.google.gson.Gson" on path: DexPathList[[zip file "/data/app/com.imooc.imooc_voice-odLxrqbaGsyw7VMCY9GRdw==/base.apk"],nativeLibraryDirectories=[/data/app/com.imooc.imooc_voice-odLxrqbaGsyw7VMCY9GRdw==/lib/arm64, /system/lib64, /system/product/lib64, /hw_product/lib64, /system/product/lib64]]
	 *         at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:196)
	 *         at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
	 *         at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
	 *         at com.imooc.lib_network.response.CommonJsonCallback.handleResponse(CommonJsonCallback.java:82) 
	 *         at com.imooc.lib_network.response.CommonJsonCallback.access$100(CommonJsonCallback.java:20) 
	 *         at com.imooc.lib_network.response.CommonJsonCallback$2.run(CommonJsonCallback.java:61) 
	 *         at android.os.Handler.handleCallback(Handler.java:888) 
	 *         at android.os.Handler.dispatchMessage(Handler.java:100) 
	 *         at android.os.Looper.loop(Looper.java:213) 
	 *         at android.app.ActivityThread.main(ActivityThread.java:8147) 
	 *         at java.lang.reflect.Method.invoke(Native Method) 
	 *         at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:513) 
	 *         at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1101) 
	 *
	 */
}
