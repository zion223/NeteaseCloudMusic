package com.imooc.lib_api.model.search;

/**
 * 专门用来匹配专辑Adapter的bean
 */
public class AlbumAdapterBean {
    private String albumCoverUrl;
    private String albumName;
    private long createTime;
    private String singer;
    private int songCount;

    public String getAlbumCoverUrl() {
        return albumCoverUrl;
    }

    public void setAlbumCoverUrl(String ablumCoverUr) {
        this.albumCoverUrl = ablumCoverUr;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}
