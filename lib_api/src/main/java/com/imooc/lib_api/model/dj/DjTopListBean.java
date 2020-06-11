package com.imooc.lib_api.model.dj;

import java.util.ArrayList;

public class DjTopListBean {

    private int code;
    private long updateTime;
    private ArrayList<DjSubListBean.DjRadios> toplist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public ArrayList<DjSubListBean.DjRadios> getToplist() {
        return toplist;
    }

    public void setToplist(ArrayList<DjSubListBean.DjRadios> toplist) {
        this.toplist = toplist;
    }
}
