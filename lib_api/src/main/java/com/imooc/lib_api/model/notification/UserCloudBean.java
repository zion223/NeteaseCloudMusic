package com.imooc.lib_api.model.notification;


import com.imooc.lib_api.model.song.SongDetailBean;

import java.util.ArrayList;

public class UserCloudBean {

    private int count;
    private int upgradeSign;
    private long size;
    private long maxSize;
    private boolean hasMore;
    private int code;
    private ArrayList<CloudSong> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUpgradeSign() {
        return upgradeSign;
    }

    public void setUpgradeSign(int upgradeSign) {
        this.upgradeSign = upgradeSign;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
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

    public ArrayList<CloudSong> getData() {
        return data;
    }

    public void setData(ArrayList<CloudSong> data) {
        this.data = data;
    }

    public static class CloudSong {
        private String album;
        private String artist;
        private String bitrate;
        private String coverId;
        private String songName;
        private long songId;
        private long addTime;
        private long fileSize;
        private String fileName;
        private SongDetailBean.SongsBean simpleSong;

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getBitrate() {
            return bitrate;
        }

        public void setBitrate(String bitrate) {
            this.bitrate = bitrate;
        }

        public String getCoverId() {
            return coverId;
        }

        public void setCoverId(String coverId) {
            this.coverId = coverId;
        }

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public long getSongId() {
            return songId;
        }

        public void setSongId(long songId) {
            this.songId = songId;
        }

        public long getAddTime() {
            return addTime;
        }

        public void setAddTime(long addTime) {
            this.addTime = addTime;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public SongDetailBean.SongsBean getSimpleSong() {
            return simpleSong;
        }

        public void setSimpleSong(SongDetailBean.SongsBean simpleSong) {
            this.simpleSong = simpleSong;
        }
    }
}
