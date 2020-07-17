package com.imooc.lib_api.model.album;

public class AlbumOrSongBean {

    private String id;
    private int type;
    private String picUrl;
    private String topText;
    private String bottomText;


    public AlbumOrSongBean(String id, int type, String picUrl, String topText, String bottomText) {
        this.id = id;
        this.type = type;
        this.picUrl = picUrl;
        this.topText = topText;
        this.bottomText = bottomText;
    }

    public long getId() {
        return Long.parseLong(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }
}
