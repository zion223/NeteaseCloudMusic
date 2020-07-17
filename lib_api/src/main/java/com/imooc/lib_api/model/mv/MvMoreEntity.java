package com.imooc.lib_api.model.mv;

import com.chad.library.adapter.base.entity.SectionEntity;

public class MvMoreEntity extends SectionEntity<MvBean.MvDetailBean> {

	public MvMoreEntity(MvBean.MvDetailBean mvDetailBean) {
		super(mvDetailBean);
	}

	public MvMoreEntity(boolean isHeader, String header) {
		super(isHeader, header);
	}
}
