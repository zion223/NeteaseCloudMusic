package com.imooc.lib_api.model.dj;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.imooc.lib_api.model.dj.DjCatelistBean;

public class RadioSortEntity extends SectionEntity<DjCatelistBean.CategoriesBean> {

    public RadioSortEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public RadioSortEntity(DjCatelistBean.CategoriesBean bean) {
        super(bean);
    }
}
