package com.imooc.lib_api.model.playlist;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * 用来存储 日推 的greendao bean
 */
@Entity
public class DRGreenDaoBean {
    @Property
    private String songId;

    @Property
    private long duration;

    @Property
    private String songCover;

    @Property
    private String artist;

    @Property
    private String songName;

    @Property
    private String songUrl;

    @Property
    private String artistId;

    @Property
    private String artistAvatar;

    @Generated(hash = 262069606)
    public DRGreenDaoBean(String songId, long duration, String songCover,
            String artist, String songName, String songUrl, String artistId,
            String artistAvatar) {
        this.songId = songId;
        this.duration = duration;
        this.songCover = songCover;
        this.artist = artist;
        this.songName = songName;
        this.songUrl = songUrl;
        this.artistId = artistId;
        this.artistAvatar = artistAvatar;
    }

    @Generated(hash = 1046166768)
    public DRGreenDaoBean() {
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSongCover() {
        return songCover;
    }

    public void setSongCover(String songCover) {
        this.songCover = songCover;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistAvatar() {
        return artistAvatar;
    }

    public void setArtistAvatar(String artistAvatar) {
        this.artistAvatar = artistAvatar;
    }
}
