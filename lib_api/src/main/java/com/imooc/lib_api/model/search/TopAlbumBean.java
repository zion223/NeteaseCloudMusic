package com.imooc.lib_api.model.search;

import java.util.ArrayList;

public class TopAlbumBean {
    private int code;
    private boolean hasMore;
    private ArrayList<AlbumSearchBean.ResultBean.AlbumsBean> weekData;
    private ArrayList<AlbumSearchBean.ResultBean.AlbumsBean> monthData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public ArrayList<AlbumSearchBean.ResultBean.AlbumsBean> getWeekData() {
        return weekData;
    }

    public void setWeekData(ArrayList<AlbumSearchBean.ResultBean.AlbumsBean> weekData) {
        this.weekData = weekData;
    }

    public ArrayList<AlbumSearchBean.ResultBean.AlbumsBean> getMonthData() {
        return monthData;
    }

    public void setMonthData(ArrayList<AlbumSearchBean.ResultBean.AlbumsBean> monthData) {
        this.monthData = monthData;
    }
}
