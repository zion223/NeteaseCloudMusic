package com.imooc.lib_api.model.album;


import com.imooc.lib_api.model.search.AlbumSearchBean;
import com.imooc.lib_api.model.song.SongDetailBean;

import java.util.ArrayList;

public class AlbumDetailBean {

    private int code;
    private AlbumSearchBean.ResultBean.AlbumsBean album;
    private ArrayList<SongDetailBean.SongsBean> songs;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AlbumSearchBean.ResultBean.AlbumsBean getAlbum() {
        return album;
    }

    public void setAlbum(AlbumSearchBean.ResultBean.AlbumsBean album) {
        this.album = album;
    }

    public ArrayList<SongDetailBean.SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongDetailBean.SongsBean> songs) {
        this.songs = songs;
    }
}
