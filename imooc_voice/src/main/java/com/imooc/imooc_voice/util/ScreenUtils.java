package com.imooc.imooc_voice.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 屏幕工具
 */
public class ScreenUtils {

    /**
     * Set the status bar color.
     */
    public static void setStatusBarColor(Activity activity, int statusBarColor) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(statusBarColor);
    }

    /**
     * Set the status bar to dark.
     */
    public static void setStatusBarDarkFont(Activity activity, boolean darkFont) {
        if (setMIUIStatusBarFont(activity, darkFont)) {
            setDefaultStatusBarFont(activity, darkFont);
        } else if (setMeizuStatusBarFont(activity, darkFont)) {
            setDefaultStatusBarFont(activity, darkFont);
        } else {
            setDefaultStatusBarFont(activity, darkFont);
        }
    }

    private static boolean setMIUIStatusBarFont(Activity activity, boolean dark) {
        Window window = activity.getWindow();
        Class<?> clazz = window.getClass();
        try {
            @SuppressLint("PrivateApi") Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            int darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            if (dark) {
                extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
            } else {
                extraFlagField.invoke(window, 0, darkModeFlag);
            }
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    private static void setDefaultStatusBarFont(Activity activity, boolean dark) {
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        if (dark) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    private static boolean setMeizuStatusBarFont(Activity activity, boolean darkFont) {
        try {
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            darkFlag.setAccessible(true);
            meizuFlags.setAccessible(true);
            int bit = darkFlag.getInt(null);
            int value = meizuFlags.getInt(lp);
            if (darkFont) {
                value |= bit;
            } else {
                value &= ~bit;
            }
            meizuFlags.setInt(lp, value);
            activity.getWindow().setAttributes(lp);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }
}
