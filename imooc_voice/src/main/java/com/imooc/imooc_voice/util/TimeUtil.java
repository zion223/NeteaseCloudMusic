package com.imooc.imooc_voice.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 时间工具类
 */
public class TimeUtil {
    private static final String TAG = "TimeUtil";

    //判断是否超过当天造成7点（用来推日推）
    public static boolean isOver7am(long time) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 7);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long sevenOClock = c.getTimeInMillis();
        Log.d(TAG, "c : " + sevenOClock);
        return sevenOClock < time;
    }

    //输入时间戳，返回年月日时分秒的时间格式
    public static String getTimeStandard(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return format.format(time);
    }

    //输入时间戳，返回年月日的时间格式
    public static String getTimeStandardOnlyYMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return format.format(time);
    }
    public static String getTimeStandardOnlyYMDWithDot(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
        return format.format(time);
    }
    public static String getTimeStandardOnlyYMDChinese(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        return format.format(time);
    }
    //输入时间戳，返回分秒的时间格式
    public static String getTimeNoYMDH(long time){
        SimpleDateFormat format = new SimpleDateFormat("mm:ss", Locale.getDefault());
        return format.format(time);
    }

    //输入时间戳，返回月
    public static String getMonth(long time){
        SimpleDateFormat format = new SimpleDateFormat("MM",Locale.getDefault());
        return format.format(time);
    }

    //输入时间戳，返回日
    public static String getDay(long time){
        SimpleDateFormat format = new SimpleDateFormat("dd",Locale.getDefault());
        return format.format(time);
    }

}
