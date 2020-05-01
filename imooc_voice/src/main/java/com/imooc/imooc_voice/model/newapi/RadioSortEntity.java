package com.imooc.imooc_voice.model.newapi;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.imooc.imooc_voice.model.newapi.dj.DjCatelistBean;
import com.imooc.imooc_voice.model.newapi.song.MusicCommentBean;

public class RadioSortEntity extends SectionEntity<DjCatelistBean.CategoriesBean> {

	public RadioSortEntity(boolean isHeader, String header) {
		super(isHeader, header);
	}
	public RadioSortEntity(DjCatelistBean.CategoriesBean bean) {
		super(bean);
	}
}
