package com.imooc.lib_api.model.artist;

import com.imooc.lib_api.model.playlist.TopListDetailBean;

import java.util.ArrayList;

public class ArtistListBean {

    private int code;
    private boolean more;
    private ArrayList<TopListDetailBean.Artist> artists;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public ArrayList<TopListDetailBean.Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<TopListDetailBean.Artist> artists) {
        this.artists = artists;
    }
}
