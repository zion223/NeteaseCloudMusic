package com.imooc.lib_api.model.mv;

import java.util.ArrayList;
import java.util.List;

public class MvBean {

    private int count;
    private int code;
    private boolean hasMore;
    private ArrayList<MvDetailBean> data;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public ArrayList<MvDetailBean> getData() {
        return data;
    }

    public void setData(ArrayList<MvDetailBean> data) {
        this.data = data;
    }

    public static class MvDetailBean {

        private long id;
        private String name;
        private int artistId;
        private String artistName;
        private String briefDesc;
        private String desc;
        private String cover;
        private long coverId;
        private long playCount;
        private int subCount;
        private int shareCount;
        private int likeCount;
        private int commentCount;
        private long duration;
        private int nType;
        private String publishTime;
        private boolean isReward;
        private String commentThreadId;
        private List<MvTopBean.Artists> artists;

        public void setId(long id) {
            this.id = id;
        }

        public String getId() {
            return String.valueOf(id);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArtistId() {
            return String.valueOf(artistId);
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public long getCoverId() {
            return coverId;
        }

        public void setCoverId(long coverId) {
            this.coverId = coverId;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public String getSubCount() {
            return String.valueOf(subCount);
        }

        public void setSubCount(int subCount) {
            this.subCount = subCount;
        }

        public String getShareCount() {
            return String.valueOf(shareCount);
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getLikeCount() {
            return String.valueOf(likeCount);
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getCommentCount() {
            return String.valueOf(commentCount);
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public int getnType() {
            return nType;
        }

        public void setnType(int nType) {
            this.nType = nType;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public boolean isReward() {
            return isReward;
        }

        public void setReward(boolean reward) {
            isReward = reward;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public List<MvTopBean.Artists> getArtists() {
            return artists;
        }

        public void setArtists(List<MvTopBean.Artists> artists) {
            this.artists = artists;
        }
    }
}
