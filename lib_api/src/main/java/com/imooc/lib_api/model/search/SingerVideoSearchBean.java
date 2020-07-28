package com.imooc.lib_api.model.search;

import java.util.List;

public class SingerVideoSearchBean {

    private List<Mvs> mvs;
    private long time;
    private boolean hasMore;
    private int code;

    public List<Mvs> getMvs() {
        return mvs;
    }

    public void setMvs(List<Mvs> mvs) {
        this.mvs = mvs;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public class Mvs {

        private long id;
        private String name;
        private int status;
        private String artistName;
        private String imgurl;
        private String imgurl16v9;
        private Artist artist;
        private long duration;
        private long playCount;
        private String publishTime;
        private boolean subed;

        public void setId(long id) {
            this.id = id;
        }

        public String getId() {
            return String.valueOf(id);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl16v9(String imgurl16v9) {
            this.imgurl16v9 = imgurl16v9;
        }

        public String getImgurl16v9() {
            return imgurl16v9;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public long getDuration() {
            return duration;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setSubed(boolean subed) {
            this.subed = subed;
        }

        public boolean getSubed() {
            return subed;
        }

    }

    public static class Artist {

        private long img1v1Id;
        private int topicPerson;
        private List<String> alias;
        private String img1v1Url;
        private int albumSize;
        private String trans;
        private int musicSize;
        private String picUrl;
        private String briefDesc;
        private int picId;
        private String name;
        private int id;
        private String img1v1Id_str;

        public void setImg1v1Id(long img1v1Id) {
            this.img1v1Id = img1v1Id;
        }

        public long getImg1v1Id() {
            return img1v1Id;
        }

        public void setTopicPerson(int topicPerson) {
            this.topicPerson = topicPerson;
        }

        public int getTopicPerson() {
            return topicPerson;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setImg1v1Url(String img1v1Url) {
            this.img1v1Url = img1v1Url;
        }

        public String getImg1v1Url() {
            return img1v1Url;
        }

        public void setAlbumSize(int albumSize) {
            this.albumSize = albumSize;
        }

        public int getAlbumSize() {
            return albumSize;
        }

        public void setTrans(String trans) {
            this.trans = trans;
        }

        public String getTrans() {
            return trans;
        }

        public void setMusicSize(int musicSize) {
            this.musicSize = musicSize;
        }

        public int getMusicSize() {
            return musicSize;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setPicId(int picId) {
            this.picId = picId;
        }

        public int getPicId() {
            return picId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setImg1v1Id_str(String img1v1Id_str) {
            this.img1v1Id_str = img1v1Id_str;
        }

        public String getImg1v1Id_str() {
            return img1v1Id_str;
        }

    }
}
