package com.imooc.lib_api.model.personal;

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
