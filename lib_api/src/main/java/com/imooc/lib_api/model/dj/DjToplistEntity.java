package com.imooc.lib_api.model.dj;


import com.chad.library.adapter.base.entity.SectionEntity;

public class DjToplistEntity extends SectionEntity<DjTopListBean.List> {

	public DjToplistEntity(DjTopListBean.List list) {
		super(list);
	}

	public DjToplistEntity(boolean isHeader, String header) {
		super(isHeader, header);
	}
}
