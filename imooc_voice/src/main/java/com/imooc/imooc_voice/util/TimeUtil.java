package com.imooc.imooc_voice.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

	public static String getTimeStandardOnlyMDChinese(long time) {
		SimpleDateFormat format = new SimpleDateFormat("MM月dd日", Locale.getDefault());
		String result = format.format(time);
		if(result.startsWith("0")){
			result = result.substring(1);
		}
		return result;
	}

	/**
	 * 获取私信界面时间
	 * 是否是同一天(昨天) 同一年
	 */
	public static String getPrivateMsgTime(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(time);
		Date old = null;
		Date now = null;
		try {
			old = sdf.parse(sdf.format(date));
			now = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long oldTime = old.getTime();
		long nowTime = now.getTime();

		long day = (nowTime - oldTime) / (24 * 60 * 60 * 1000);
		if (day < 1) {  //今天
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			String format1 = format.format(date);
			if(format1.startsWith("0")){
				format1 = format1.substring(1);
			}
			return format1;
		} else if (day == 1) {     //昨天
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			String format1 = format.format(date);
			if(format1.startsWith("0")){
				format1 = format1.substring(1);
			}
			return "昨天 " + format1;
		} else if(sdf.format(date).substring(0,4).equals(sdf.format(new Date()).substring(0,4))) {
			//是同一年
			return getTimeStandardOnlyMDChinese(time);
		}else{
			return getTimeStandardOnlyYMDChinese(time);
		}
	}

	public static String getTimeHms(long time) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		return format.format(time);
	}

	public static String getTimeHm(long time) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
		return format.format(time);
	}

	//输入时间戳，返回分秒的时间格式
	public static String getTimeNoYMDH(long time) {
		SimpleDateFormat format = new SimpleDateFormat("mm:ss", Locale.getDefault());
		return format.format(time);
	}

	//输入时间戳，返回月
	public static String getMonth(long time) {
		SimpleDateFormat format = new SimpleDateFormat("MM", Locale.getDefault());
		return format.format(time);
	}

	//输入时间戳，返回日
	public static String getDay(long time) {
		SimpleDateFormat format = new SimpleDateFormat("dd", Locale.getDefault());
		return format.format(time);
	}

	private static boolean isToday(String str, String formatStr) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		int year1 = c1.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH) + 1;
		int day1 = c1.get(Calendar.DAY_OF_MONTH);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());
		int year2 = c2.get(Calendar.YEAR);
		int month2 = c2.get(Calendar.MONTH) + 1;
		int day2 = c2.get(Calendar.DAY_OF_MONTH);
		return year1 == year2 && month1 == month2 && day1 == day2;
	}
}
