package com.imooc.lib_api.model.dj;


import com.chad.library.adapter.base.entity.SectionEntity;

public class DjToplistEntity extends SectionEntity<DjRankListBean.List> {

    public DjToplistEntity(DjRankListBean.List list) {
        super(list);
    }

    public DjToplistEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }
}
