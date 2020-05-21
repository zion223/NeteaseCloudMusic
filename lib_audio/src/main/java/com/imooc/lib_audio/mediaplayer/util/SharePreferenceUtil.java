package com.imooc.lib_audio.mediaplayer.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.imooc.lib_api.model.LoginBean;

import java.util.List;
import java.util.Locale;



/**
 * 本地SharePreference工具
 */
public class SharePreferenceUtil {


	private static SharedPreferences sp;
	private static SharedPreferences.Editor editor;
	private static SharePreferenceUtil mInstance;

	private SharePreferenceUtil() {
	}

	@SuppressLint("CommitPrefEdits")
	private static void init(Context context) {
		if (sp == null) {
			sp = context.getSharedPreferences("NeteaseCloudMusic_sp", Context.MODE_PRIVATE);
		}
		editor = sp.edit();
	}

	public static SharePreferenceUtil getInstance(Context context) {
		if (mInstance == null) {
			synchronized (SharePreferenceUtil.class) {
				if (mInstance == null) {
					init(context);
					mInstance = new SharePreferenceUtil();
				}
			}
		}
		return mInstance;
	}

	//获取当前登录用户ID
	public int getUserId() {
		String userInfo = getString("userInfo", "");
		if(TextUtils.isEmpty(userInfo)){
			return 0;
		}
		LoginBean loginBean = GsonUtil.fromJSON(userInfo, LoginBean.class);
		return loginBean.getProfile().getUserId();
	}


	private String getString(String key, String defaultValue) {
		return sp.getString(key, defaultValue);
	}

}
