package com.imooc.lib_common_ui.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


import com.imooc.lib_api.model.song.AudioBean;
import com.imooc.lib_api.model.user.LoginBean;

import java.util.List;
import java.util.Locale;



/**
 * 本地SharePreference工具
 */
public class SharePreferenceUtil {

	private static final String TAG = "SharePreferenceUtil";

	private static SharedPreferences sp;
	private static SharedPreferences.Editor editor;
	private static SharePreferenceUtil mInstance;
	private Locale systemCurrentLocal = Locale.CHINESE;

	private SharePreferenceUtil() {
	}

	@SuppressLint("CommitPrefEdits")
	private static void init(Context context) {
		if (sp == null) {
			sp = context.getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
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

	int getSelectLanguage() {
		return getInt(Constants.SpKey.TAG_LANGUAGE, 0);
	}

	Locale getSystemCurrentLocal() {
		return systemCurrentLocal;
	}

	public int getLocalMusicCount() {
		return Integer.parseInt(getString(Constants.SpKey.LOCAL_MUSIC_COUNT, "0"));
	}

	public void saveLocalMusicCount(int count) {
		saveString(Constants.SpKey.LOCAL_MUSIC_COUNT, String.valueOf(count));
	}

	/**
	 * 保存用户的信息以及电话号码（因为bean里的电话号码要处理字符串，所以这里直接暴力传比较高效）
	 *
	 * @param bean
	 */
	public void saveUserInfo(LoginBean bean, String phoneNumber) {
		if (bean.getBindings().size() > 1) {
			saveAuthToken(bean.getBindings().get(1).getTokenJsonStr());
		}
		saveUserId(String.valueOf(bean.getProfile().getUserId()));
		saveAccountNum(phoneNumber);
		saveString(Constants.SpKey.USER_INFO, GsonUtil.toJson(bean));
	}

	//获取当前登录用户信息
	public String getUserInfo(String defaultValue) {
		return getString(Constants.SpKey.USER_INFO, defaultValue);
	}

	//获取当前登录用户ID
	public int getUserId() {
		String userInfo = getString(Constants.SpKey.USER_INFO, "");
		if(TextUtils.isEmpty(userInfo)){
			return 0;
		}
		LoginBean loginBean = GsonUtil.fromJSON(userInfo, LoginBean.class);
		return loginBean.getProfile().getUserId();
	}
	//退出登录 移除已登录用户信息
	public void removeUserInfo() {
		remove(Constants.SpKey.USER_INFO);
		saveAuthToken("");
	}

	private void saveAccountNum(String phoneNumber) {
		saveString(Constants.SpKey.PHONE_NUMBER, phoneNumber);
	}

	private void saveUserId(String id) {
		saveString(Constants.SpKey.USER_ID, id);
	}

	private void getUserId(String id) {
		getString(Constants.SpKey.USER_ID, id);
	}

	public String getAccountNum() {
		return getString(Constants.SpKey.PHONE_NUMBER, "");
	}

	private void saveAuthToken(String token) {
		saveString(Constants.SpKey.AUTH_TOKEN, token);
	}

	/**
	 * 获取AuthToken
	 */
	public String getAuthToken(String defaultValue) {
		return getString(Constants.SpKey.AUTH_TOKEN, defaultValue);
	}


	/*
	 * 存储最近一次听过的歌曲
	 */
    public void saveLatestSong(AudioBean songInfo) {
        String song = GsonUtil.toJson(songInfo);
        saveString(Constants.SpKey.LATEST_SONG, song);
    }

    public AudioBean getLatestSong() {
        return GsonUtil.fromJSON(getString(Constants.SpKey.LATEST_SONG, ""), AudioBean.class);
    }

	/**
	 * 保存上次获取日推的时间
	 */
	public void saveDailyUpdateTime(long updateTime) {
		saveLong(Constants.SpKey.DAILY_UPDATE_TIME, updateTime);
	}

	/**
	 * 存储当前歌手ID
	 */
	public void saveCurrentArtistId(String id) {
		saveString(Constants.SpKey.CURRENT_ARTIST_ID, id);
	}

	public void removeCurrentArtistId() {
		remove(Constants.SpKey.CURRENT_ARTIST_ID);
	}

	public String getCurrentArtistId() {
		return getString(Constants.SpKey.CURRENT_ARTIST_ID, "");
	}

	public long getDailyUpdateTime() {
		return getLong(Constants.SpKey.DAILY_UPDATE_TIME, 0);
	}

	/**
	 * 保存播放歌曲列表
	 */
	public void saveMusicList(List<AudioBean> likeList) {
		String likeListString = GsonUtil.toJson(likeList);
		saveString(Constants.SpKey.LIKE_LIST, likeListString);
	}

	/**
	 * 	获取播放列表
	 */
	public List<AudioBean> getMusicList() {
		String likeListString = getString(Constants.SpKey.LIKE_LIST, "");
		return GsonUtil.fromAudioJSON(likeListString);
	}

	private void remove(String key) {
		editor.remove(key).apply();
	}

	private String getString(String key, String defaultValue) {
		return sp.getString(key, defaultValue);
	}

	private void saveLong(String key, long values) {
		editor.putLong(key, values);
	}

	private long getLong(String key, long defaultValue) {
		return sp.getLong(key, defaultValue);
	}

	private int getInt(String key, int defaultValue) {
		return sp.getInt(key, defaultValue);
	}

	private void saveString(String key, String value) {
		editor.putString(key, value).apply();
	}
}
