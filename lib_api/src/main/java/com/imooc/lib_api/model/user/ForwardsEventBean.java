package com.imooc.lib_api.model.user;

import com.imooc.lib_api.model.playlist.DailyRecommendBean;
import com.imooc.lib_api.model.playlist.PlaylistDetailBean;
import com.imooc.lib_api.model.search.AlbumSearchBean;

public class ForwardsEventBean {

    private String msg;
    //歌曲
    private DailyRecommendBean.RecommendBean song;
    //动态
    private UserEventBean.EventsBean event;
    //歌单
    private PlaylistDetailBean.PlaylistBean playlist;
    //专辑
    private AlbumSearchBean.ResultBean.AlbumsBean album;
    //视频
    private UserEventJsonBean.VideoBean video;
    //电台节目
    private UserEventJsonBean.ProgramBean program;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DailyRecommendBean.RecommendBean getSong() {
        return song;
    }

    public void setSong(DailyRecommendBean.RecommendBean song) {
        this.song = song;
    }

    public UserEventBean.EventsBean getEvent() {
        return event;
    }

    public void setEvent(UserEventBean.EventsBean event) {
        this.event = event;
    }

    public PlaylistDetailBean.PlaylistBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistDetailBean.PlaylistBean playlist) {
        this.playlist = playlist;
    }

    public AlbumSearchBean.ResultBean.AlbumsBean getAlbum() {
        return album;
    }

    public void setAlbum(AlbumSearchBean.ResultBean.AlbumsBean album) {
        this.album = album;
    }

    public UserEventJsonBean.VideoBean getVideo() {
        return video;
    }

    public void setVideo(UserEventJsonBean.VideoBean video) {
        this.video = video;
    }

    public UserEventJsonBean.ProgramBean getProgram() {
        return program;
    }

    public void setProgram(UserEventJsonBean.ProgramBean program) {
        this.program = program;
    }
}
