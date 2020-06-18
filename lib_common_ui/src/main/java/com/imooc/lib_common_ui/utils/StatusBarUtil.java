package com.imooc.lib_common_ui.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtil {

	/**
	 * 修改状态栏为全透明
	 */
	public static void transparencyBar(Activity activity) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = activity.getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.getDecorView()
					.setSystemUiVisibility(
							View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window window = activity.getWindow();
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}

	/**
	 * 状态栏亮色模式，设置状态栏黑色文字、图标，
	 * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
	 *
	 * @return 1:MIUUI 2:Flyme 3:android6.0
	 */
	public static int statusBarLightMode(Activity activity) {
		int result = 0;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (miuiSetStatusBarLightMode(activity, true)) {
				result = 1;
			} else if (flymeSetStatusBarLightMode(activity.getWindow(), true)) {
				result = 2;
			} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
				activity.getWindow()
						.getDecorView()
						.setSystemUiVisibility(
								View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
				result = 3;
			}
		}
		return result;
	}

	/**
	 * 已知系统类型时，设置状态栏黑色文字、图标。
	 * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
	 *
	 * @param type 1:MIUUI 2:Flyme 3:android6.0
	 */
	public static void statusBarLightMode(Activity activity, int type) {
		if (type == 1) {
			miuiSetStatusBarLightMode(activity, true);
		} else if (type == 2) {
			flymeSetStatusBarLightMode(activity.getWindow(), true);
		} else if (type == 3) {
			activity.getWindow()
					.getDecorView()
					.setSystemUiVisibility(
							View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		}
	}

	/**
	 * 状态栏暗色模式，清除MIUI、flyme或6.0以上版本状态栏黑色文字、图标
	 */
	public static void StatusBarDarkMode(Activity activity, int type) {
		if (type == 1) {
			miuiSetStatusBarLightMode(activity, false);
		} else if (type == 2) {
			flymeSetStatusBarLightMode(activity.getWindow(), false);
		} else if (type == 3) {
			activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
		}
	}

	/**
	 * 设置状态栏图标为深色和魅族特定的文字风格
	 * 可以用来判断是否为Flyme用户
	 *
	 * @param window 需要设置的窗口
	 * @param dark   是否把状态栏文字及图标颜色设置为深色
	 * @return boolean 成功执行返回true
	 */
	public static boolean flymeSetStatusBarLightMode(Window window, boolean dark) {
		boolean result = false;
		if (window != null) {
			try {
				WindowManager.LayoutParams lp = window.getAttributes();
				Field darkFlag =
						WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
				Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
				darkFlag.setAccessible(true);
				meizuFlags.setAccessible(true);
				int bit = darkFlag.getInt(null);
				int value = meizuFlags.getInt(lp);
				if (dark) {
					value |= bit;
				} else {
					value &= ~bit;
				}
				meizuFlags.setInt(lp, value);
				window.setAttributes(lp);
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 需要MIUIV6以上
	 *
	 * @param dark 是否把状态栏文字及图标颜色设置为深色
	 * @return boolean 成功执行返回true
	 */
	public static boolean miuiSetStatusBarLightMode(Activity activity, boolean dark) {
		boolean result = false;
		Window window = activity.getWindow();
		if (window != null) {
			Class clazz = window.getClass();
			try {
				int darkModeFlag;
				Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
				Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
				darkModeFlag = field.getInt(layoutParams);
				//noinspection unchecked
				Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
				if (dark) {
					//状态栏透明且黑色字体
					extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
				} else {
					//清除黑色字体
					extraFlagField.invoke(window, 0, darkModeFlag);
				}
				result = true;

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					//开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
					if (dark) {
						activity.getWindow()
								.getDecorView()
								.setSystemUiVisibility(
										View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
					} else {
						activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//获取屏幕虚拟键高度
	public static int getVirtualBarHeight(Context context) {
		int vh = 0;
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics dm = new DisplayMetrics();
		try {
			@SuppressWarnings("rawtypes") Class c = Class.forName("android.view.Display");
			@SuppressWarnings("unchecked") Method method =
					c.getMethod("getRealMetrics", DisplayMetrics.class);
			method.invoke(display, dm);
			vh = dm.heightPixels - display.getHeight();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vh;
	}

	public static int getStatusBarHeight(Context context) {
		int height = 0;
		try {
			Class c = Class.forName("com.android.internal.R$dimen");
			Field f = c.getField("status_bar_height");
			int id = (int) f.get(null);
			height = context.getResources().getDimensionPixelSize(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return height;
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 获取手机的密度
	 */
	public static float getDensity(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.density;
	}
}
