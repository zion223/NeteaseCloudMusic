package com.imooc.lib_api.model.user;

/**
 * 用来适配UserPlaylistAdapter、解耦的Bean
 */
public class PlayListItemBean {
    private long playlistId;

    private String coverUrl;

    private String playListName;

    //播放次数
    private long playCount;

    private String playlistCreator;

    private int songNumber;

    public int getSongNumber() {
        return songNumber;
    }

    public void setSongNumber(int songNumber) {
        this.songNumber = songNumber;
    }

    public long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(long playlistId) {
        this.playlistId = playlistId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    public String getPlaylistCreator() {
        return playlistCreator;
    }

    public void setPlaylistCreator(String playlistCreator) {
        this.playlistCreator = playlistCreator;
    }
}
