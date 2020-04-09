package com.imooc.imooc_voice.model.newapi.personal;

import com.chad.library.adapter.base.entity.SectionEntity;

public class UserPlayListEntity extends SectionEntity<UserPlaylistBean.PlaylistBean> {

	public int playNum;

	public UserPlayListEntity(boolean isHeader, String header, int num) {
		super(isHeader, header);
		playNum = num;
	}

	public UserPlayListEntity(UserPlaylistBean.PlaylistBean bean) {
		super(bean);
	}


}
