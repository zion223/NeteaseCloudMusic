package com.imooc.lib_api.model.album;


public class AlbumDynamicBean {

    /**
     * "onSale": false,
     * "albumGameInfo": null,
     * "commentCount": 1766,
     * "likedCount": 0,
     * "shareCount": 1870,
     * "isSub": false,
     * "subTime": 0,
     * "subCount": 20431,
     * "code": 200
     */
    private int code;
    private boolean onSale;
    private boolean isSub;
    private long subTime;
    private Object albumGameInfo;
    private int commentCount;
    private int likedCount;
    private int shareCount;
    private int subCount;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isSub() {
        return isSub;
    }

    public void setSub(boolean sub) {
        isSub = sub;
    }

    public long getSubTime() {
        return subTime;
    }

    public void setSubTime(long subTime) {
        this.subTime = subTime;
    }

    public Object getAlbumGameInfo() {
        return albumGameInfo;
    }

    public void setAlbumGameInfo(Object albumGameInfo) {
        this.albumGameInfo = albumGameInfo;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getSubCount() {
        return subCount;
    }

    public void setSubCount(int subCount) {
        this.subCount = subCount;
    }
}
