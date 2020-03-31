package com.imooc.imooc_voice.view.login;


public class UserManager {

	private static UserManager mInstance;

	/**
	 * double check locking 双重检查锁机制
	 */
	public static UserManager getInstance(){
		if(mInstance == null){
			synchronized (UserManager.class){
				if(mInstance == null){
					mInstance = new UserManager();
				}
			}
		}
		return mInstance;
	}


}
