package com.imooc.lib_audio.mediaplayer.util;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

public class Utils {

	public static String formatTime(long time) {
		String min = (time / (1000 * 60)) + "";
		String second = (time % (1000 * 60) / 1000) + "";
		if (min.length() < 2) {
			min = 0 + min;
		}
		if (second.length() < 2) {
			second = 0 + second;
		}
		return min + ":" + second;
	}

	//获取屏幕的宽度
	public static int getScreenWidth(Context context) {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getWidth();
	}

	//获取屏幕的高度
	public static int getScreenHeight(Context context) {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getHeight();
	}
}
