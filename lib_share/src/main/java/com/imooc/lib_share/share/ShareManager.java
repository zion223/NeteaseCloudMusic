package com.imooc.lib_share.share;

import android.content.Context;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

public class ShareManager {

	//分享到的平台
	private Platform mPlatForm;

	private static ShareManager mShareManager = new ShareManager();

	public static ShareManager getInstance(){
		return mShareManager;
	}

	/**
	 * 初始化ShareSDK
	 * @param context
	 */
	public static void init(Context context){
		ShareSDK.initSDK(context);
	}

	public void shareData(ShareData data, PlatformActionListener listener){
		switch (data.mPlatformType){
			case QQ:
				mPlatForm = ShareSDK.getPlatform(QQ.NAME);
				break;
			case QZone:
				mPlatForm = ShareSDK.getPlatform(QZone.NAME);
			case WeChat:
				mPlatForm = ShareSDK.getPlatform(Wechat.NAME);
				break;
			case WechatMoments:
				mPlatForm = ShareSDK.getPlatform(WechatMoments.NAME);
				break;
			default:
				break;

		}
		mPlatForm.setPlatformActionListener(listener);
		mPlatForm.share(data.mShareParams);
	}



	public enum PlatformType{
		QQ, QZone, WeChat, WechatMoments;
	}

}
