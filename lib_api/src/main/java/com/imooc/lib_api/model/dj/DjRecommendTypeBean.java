package com.imooc.lib_api.model.dj;

import java.util.List;

public class DjRecommendTypeBean {

    /**
     * hasMore : true
     * code : 200
     */

    private boolean hasMore;
    private int code;
    private List<DjRecommendBean.DjRadiosBean> djRadios;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DjRecommendBean.DjRadiosBean> getDjRadios() {
        return djRadios;
    }

    public void setDjRadios(List<DjRecommendBean.DjRadiosBean> djRadios) {
        this.djRadios = djRadios;
    }

    @Override
    public String toString() {
        return "DjRecommendTypeBean{" +
                "hasMore=" + hasMore +
                ", code=" + code +
                ", djRadios=" + djRadios +
                '}';
    }
}
