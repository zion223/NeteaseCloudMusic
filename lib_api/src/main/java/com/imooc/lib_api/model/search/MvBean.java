package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 用来适配视频Adapter的Bean
 */
public class MvBean {
    private String coverUrl;

    private String title;

    private long duration;

    private int type;

    private List<CreatorBean> creator;

    private String vid;

    private long playTime;

    public static class CreatorBean {
        /**
         * userId : 11562
         * userName : F.I.R
         */

        private long userId;
        private String userName;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<CreatorBean> getCreator() {
        return creator;
    }

    public void setCreator(List<CreatorBean> creator) {
        this.creator = creator;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "MvBean{" +
                "coverUrl='" + coverUrl + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", creator=" + creator +
                ", vid='" + vid + '\'' +
                ", playTime=" + playTime +
                '}';
    }
}
