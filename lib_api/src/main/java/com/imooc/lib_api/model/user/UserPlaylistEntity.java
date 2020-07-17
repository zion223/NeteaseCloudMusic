package com.imooc.lib_api.model.user;


import java.util.List;

public class UserPlaylistEntity {

    private String header;
    private String footer;
    private List<UserPlaylistBean.PlaylistBean> playlist;

    public UserPlaylistEntity(String header, String footer, List<UserPlaylistBean.PlaylistBean> playlist) {
        this.header = header;
        this.footer = footer;
        this.playlist = playlist;
    }

    public void setPlaylist(List<UserPlaylistBean.PlaylistBean> playlist) {
        this.playlist = playlist;
    }

    public List<UserPlaylistBean.PlaylistBean> getPlaylist() {
        return playlist;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }


}
