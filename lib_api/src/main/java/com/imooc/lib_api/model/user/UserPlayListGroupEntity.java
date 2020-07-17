package com.imooc.lib_api.model.user;

import java.util.List;

public class UserPlayListGroupEntity {

    private boolean isExpand;
    private String header;
    private int playNum;
    private List<UserPlaylistBean.PlaylistBean> bean;


    public UserPlayListGroupEntity(boolean isExpand, String header, int playNum, List<UserPlaylistBean.PlaylistBean> bean) {
        this.isExpand = isExpand;
        this.header = header;
        this.playNum = playNum;
        this.bean = bean;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<UserPlaylistBean.PlaylistBean> getBean() {
        return bean;
    }

    public void setBean(List<UserPlaylistBean.PlaylistBean> bean) {
        this.bean = bean;
    }
}
