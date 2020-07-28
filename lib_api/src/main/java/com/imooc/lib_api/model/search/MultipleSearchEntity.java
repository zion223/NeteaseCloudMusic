package com.imooc.lib_api.model.search;

import java.util.List;

public class MultipleSearchEntity {

    private String header;
    private String footer;

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.SongBean song) {
        this.song = song;
    }

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.DjRadioBean djRadio) {
        this.djRadio = djRadio;
    }

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.ArtistBean artist) {
        this.artist = artist;
    }

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.PlayListBean playList) {
        this.playList = playList;
    }

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.AlbumBeanX album) {
        this.album = album;
    }

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.VideoBean video) {
        this.video = video;
    }

    public MultipleSearchEntity(SynthesisSearchBean.ResultBean.UserBean user) {
        this.user = user;
    }

    //单曲
    private SynthesisSearchBean.ResultBean.SongBean song;
    //电台
    private SynthesisSearchBean.ResultBean.DjRadioBean djRadio;
    //歌手
    private SynthesisSearchBean.ResultBean.ArtistBean artist;
    //歌单
    private SynthesisSearchBean.ResultBean.PlayListBean playList;
    //专辑
    private SynthesisSearchBean.ResultBean.AlbumBeanX album;
    //视频
    private SynthesisSearchBean.ResultBean.VideoBean video;
    //相关搜索
    private SynthesisSearchBean.ResultBean.SimQueryBean sim_query;
    //用户
    private SynthesisSearchBean.ResultBean.UserBean user;
    private Object rec_type;
    private List<String> rec_query;
    private List<String> order;

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

    public SynthesisSearchBean.ResultBean.SongBean getSong() {
        return song;
    }

    public void setSong(SynthesisSearchBean.ResultBean.SongBean song) {
        this.song = song;
    }

    public SynthesisSearchBean.ResultBean.DjRadioBean getDjRadio() {
        return djRadio;
    }

    public void setDjRadio(SynthesisSearchBean.ResultBean.DjRadioBean djRadio) {
        this.djRadio = djRadio;
    }

    public SynthesisSearchBean.ResultBean.ArtistBean getArtist() {
        return artist;
    }

    public void setArtist(SynthesisSearchBean.ResultBean.ArtistBean artist) {
        this.artist = artist;
    }

    public SynthesisSearchBean.ResultBean.PlayListBean getPlayList() {
        return playList;
    }

    public void setPlayList(SynthesisSearchBean.ResultBean.PlayListBean playList) {
        this.playList = playList;
    }

    public SynthesisSearchBean.ResultBean.AlbumBeanX getAlbum() {
        return album;
    }

    public void setAlbum(SynthesisSearchBean.ResultBean.AlbumBeanX album) {
        this.album = album;
    }

    public SynthesisSearchBean.ResultBean.VideoBean getVideo() {
        return video;
    }

    public void setVideo(SynthesisSearchBean.ResultBean.VideoBean video) {
        this.video = video;
    }

    public SynthesisSearchBean.ResultBean.SimQueryBean getSim_query() {
        return sim_query;
    }

    public void setSim_query(SynthesisSearchBean.ResultBean.SimQueryBean sim_query) {
        this.sim_query = sim_query;
    }

    public SynthesisSearchBean.ResultBean.UserBean getUser() {
        return user;
    }

    public void setUser(SynthesisSearchBean.ResultBean.UserBean user) {
        this.user = user;
    }

    public Object getRec_type() {
        return rec_type;
    }

    public void setRec_type(Object rec_type) {
        this.rec_type = rec_type;
    }

    public List<String> getRec_query() {
        return rec_query;
    }

    public void setRec_query(List<String> rec_query) {
        this.rec_query = rec_query;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }
}
