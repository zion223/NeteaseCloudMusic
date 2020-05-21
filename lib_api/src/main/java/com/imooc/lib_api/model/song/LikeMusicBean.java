package com.imooc.lib_api.model.song;

import java.util.List;

public class LikeMusicBean {

    /**
     * songs : []
     * playlistId : 2882298677
     * code : 200
     */

    private long playlistId;
    private int code;
    private List<?> songs;

    public long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(long playlistId) {
        this.playlistId = playlistId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<?> getSongs() {
        return songs;
    }

    public void setSongs(List<?> songs) {
        this.songs = songs;
    }
}
