package com.imooc.lib_network.app;

import android.content.Context;


public final class OkHttpHelper {

	private static Context mContext;

	public static void init(Context context){
		mContext = context;
	}

	public static Context getContext(){
		return mContext;
	}


}
