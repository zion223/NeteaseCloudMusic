package com.imooc.lib_api.model.user;

import com.imooc.lib_api.model.song.SongDetailBean;

import java.util.ArrayList;

public class UserRecordBean {

    private int code;
    private ArrayList<UserRecord> allData;
    private ArrayList<UserRecord> weekData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<UserRecord> getAllData() {
        return allData;
    }

    public void setAllData(ArrayList<UserRecord> allData) {
        this.allData = allData;
    }

    public ArrayList<UserRecord> getWeekData() {
        return weekData;
    }

    public void setWeekData(ArrayList<UserRecord> weekData) {
        this.weekData = weekData;
    }

    public static class UserRecord {
        private int score;
        private int playCount;
        private SongDetailBean.SongsBean song;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public SongDetailBean.SongsBean getSong() {
            return song;
        }

        public void setSong(SongDetailBean.SongsBean song) {
            this.song = song;
        }
    }
}
