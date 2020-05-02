package com.imooc.imooc_voice.model.newapi;

import com.chad.library.adapter.base.entity.SectionEntity;

public class MvMoreEntity extends SectionEntity<MvBean.MvDetailBean> {

	public MvMoreEntity(MvBean.MvDetailBean mvDetailBean) {
		super(mvDetailBean);
	}

	public MvMoreEntity(boolean isHeader, String header) {
		super(isHeader, header);
	}
}
