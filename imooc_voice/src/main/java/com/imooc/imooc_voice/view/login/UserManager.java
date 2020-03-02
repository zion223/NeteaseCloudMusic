package com.imooc.imooc_voice.view.login;

import com.imooc.imooc_voice.model.user.User;

public class UserManager {

	private static UserManager mInstance;
	private User mUser;

	/**
	 * double check locking 双重检查锁机制
	 * @return
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

	public void saveUser(User user){
		mUser = user;
		saveLocal(mUser);
	}

	public User getUser(){
		return mUser;
	}
	/**
	 * 保存到数据库:持久化
	 * @param user
	 */
	private void saveLocal(User user){

	}

	private User getLocal(){
		return null;
	}

	public boolean hasLogin(){
		return getUser() != null;
	}

	public void removeUser(){
		mUser = null;
		removeLocal();
	}
	private void removeLocal(){

	}
}
