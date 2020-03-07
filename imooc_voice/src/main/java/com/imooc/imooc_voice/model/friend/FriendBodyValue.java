package com.imooc.imooc_voice.model.friend;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.imooc.imooc_voice.model.BaseModel;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;

import java.util.ArrayList;

public class FriendBodyValue extends BaseModel implements MultiItemEntity {

	public int type;
	public String avatr;
	public String name;
	public String fans;
	public String text;
	public ArrayList<String> pics;
	public String videoUrl;
	public String zan;
	public String msg;
	public AudioBean audioBean;


	@Override
	public int getItemType() {
		return type;
	}

	public static final int VIDEO = 2;
	public static final int MUSIC = 1;

}
