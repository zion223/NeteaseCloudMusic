package com.imooc.lib_video.videoplayer.utils;

import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale);
	}

	public static int getVisiblePercent(View pView) {
		if (pView != null && pView.isShown()) {
			DisplayMetrics displayMetrics = pView.getContext().getResources().getDisplayMetrics();
			int displayWidth = displayMetrics.widthPixels;
			Rect rect = new Rect();
			pView.getGlobalVisibleRect(rect);
			if ((rect.top > 0) && (rect.left < displayWidth)) {
				double areaVisible = rect.width() * rect.height();
				double areaTotal = pView.getWidth() * pView.getHeight();
				return (int) ((areaVisible / areaTotal) * 100);
			} else {
				return -1;
			}
		}
		return -1;
	}

	//is wifi connected
	public static boolean isWifiConnected(Context context) {
		if (context.checkCallingOrSelfPermission(permission.ACCESS_WIFI_STATE)
				!= PackageManager.PERMISSION_GRANTED) {
			return false;
		}
		ConnectivityManager connectivityManager =
				(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		return info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI;
	}

	//decide can autoplay the ad
	public static boolean canAutoPlay(Context context) {
		return isWifiConnected(context);
	}

	public static DisplayMetrics getDisplayMetrics(Context context) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		if (windowManager == null) {
			return displayMetrics;
		}
		windowManager.getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics;
	}

	public static BitmapDrawable decodeImage(String base64drawable) {
		byte[] rawImageData = Base64.decode(base64drawable, 0);
		return new BitmapDrawable(null, new ByteArrayInputStream(rawImageData));
	}

	public static boolean isPad(Context context) {

		//如果能打电话那可能是平板或手机，再根据配置判断
		if (canTelephone(context)) {
			//能打电话可能是手机也可能是平板
			return (context.getResources().getConfiguration().
					screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
					>= Configuration.SCREENLAYOUT_SIZE_LARGE;
		} else {
			return true; //不能打电话一定是平板
		}
	}

	private static boolean canTelephone(Context context) {
		TelephonyManager telephony =
				(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return telephony.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
	}

	public static boolean containString(String source, String destation) {

		if (source.equals("") || destation.equals("")) {
			return false;
		}

		return source.contains(destation);
	}

	/**
	 * 获取view的屏幕属性
	 *
	 * @return
	 */
	public static final String VIEW_INFO_EXTRA = "view_into_extra";
	public static final String PROPNAME_SCREENLOCATION_LEFT = "propname_sreenlocation_left";
	public static final String PROPNAME_SCREENLOCATION_TOP = "propname_sreenlocation_top";
	public static final String PROPNAME_WIDTH = "propname_width";
	public static final String PROPNAME_HEIGHT = "propname_height";

	public static Bundle getViewProperty(View view) {
		Bundle bundle = new Bundle();
		int[] screenLocation = new int[2];
		view.getLocationOnScreen(screenLocation); //获取view在整个屏幕中的位置
		bundle.putInt(PROPNAME_SCREENLOCATION_LEFT, screenLocation[0]);
		bundle.putInt(PROPNAME_SCREENLOCATION_TOP, screenLocation[1]);
		bundle.putInt(PROPNAME_WIDTH, view.getWidth());
		bundle.putInt(PROPNAME_HEIGHT, view.getHeight());

		Log.e("Utils", "Left: "
				+ screenLocation[0]
				+ " Top: "
				+ screenLocation[1]
				+ " Width: "
				+ view.getWidth()
				+ " Height: "
				+ view.getHeight());
		return bundle;
	}

	/**
	 * 把Bitmap保存成png文件
	 *
	 * @param dirpath  保存的目录
	 * @param filename 保存的文件名
	 * @param bitmap   要保存成文件的bitmap
	 */
	public static boolean saveBitmapToFile(String dirpath, String filename, Bitmap bitmap,
										   Bitmap.CompressFormat format) {
		if (TextUtils.isEmpty(dirpath) || TextUtils.isEmpty(filename) || bitmap == null)
			return false;

		if (format == null) format = Bitmap.CompressFormat.PNG;

		FileOutputStream out = null;
		try {
			File dir = new File(dirpath);
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					return false;
				}
			}

			File file = new File(dirpath, filename);
			if (file.exists()) file.delete();

			out = new FileOutputStream(file);
			if (bitmap.compress(format, 100, out)) {
				out.flush();
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
