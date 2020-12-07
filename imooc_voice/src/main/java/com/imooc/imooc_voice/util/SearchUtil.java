package com.imooc.imooc_voice.util;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;

/*
 *	搜索工具类
 */
public class SearchUtil {

	public static CharSequence getMatchingKeywords(String content, String keywords){

		if(content.contains(keywords)){
			int start = content.indexOf(keywords);
			int end = start + keywords.length();
			SpannableStringBuilder style = new SpannableStringBuilder(content);
			style.setSpan(new ForegroundColorSpan(Color.parseColor("#2196f3")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			return style;
		}else{
			return content;
		}

	}

	public static String getCorresPondingString(int num){
		String text;
		//大于1亿
		if(num > 100000000){
			num = num / 100000000;
			text = num + "亿";
		//大于10万
		}else if (num >= 100000) {
			num = num / 10000;
			text = num + "万";
		} else {
			text = num + "";
		}
		return text;
	}

	public static String getCorresPondingString(long num){
		return getCorresPondingString(((Long)num).intValue());
	}

	//根据用户类型 设置不同的用户专属图标
	public static void setUserTypeImg(int type, int viewId, BaseViewHolder viewHolder){
		switch (type){
			//网易音乐人
			case 4:
				viewHolder.setVisible(viewId, true);
				((ImageView)viewHolder.getView(viewId)).setImageResource(R.drawable.ic_musician);
				break;
			//明星用户
			case 10:
			case 2:
				viewHolder.setVisible(viewId, true);
				((ImageView)viewHolder.getView(viewId)).setImageResource(R.drawable.ic_official);
				break;
			//音乐达人
			case 200:
			case 11:
				viewHolder.setVisible(viewId, true);
				((ImageView)viewHolder.getView(viewId)).setImageResource(R.drawable.ic_yellow_star);
				break;
			default:
				viewHolder.setVisible(viewId, false);
				break;
		}
	}


	public static String getEventType(int type ) {
		String eventType ="";

		switch (type) {
			case 18:
				eventType = "分享单曲：";
				break;
			case 19:
				eventType = "分享专辑：";
				break;
			case 17:
			case 28:
				eventType ="分享电台节目：";
				break;
			case 22:
				eventType = "转发：";
				break;
			case 39:
				eventType = "发布视频：";
				break;
			case 35:
				break;
			case 13:
				eventType = "分享歌单：";
				break;
			case 24:
				eventType = "分享专栏文章：";
				break;
			case 41:
			case 21:
				eventType = "分享视频：";
				break;
		}
		return eventType;
	}


}
