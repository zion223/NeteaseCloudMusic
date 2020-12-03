package com.imooc.lib_api.model.user;

/**
 * {
 * "full": false,
 * "data": {
 * "userId": 123170560,
 * "info": "60G音乐云盘免费容量$黑名单上限80$云音乐商城满100减9元优惠券$价值400云贝",
 * "progress": 0.925,当前等级进度
 * "nextPlayCount": 2000,
 * "nextLoginCount": 100,
 * "nowPlayCount": 1850, 听歌次数
 * "nowLoginCount": 100,
 * "level": 7 用户等级
 * },
 * "code": 200
 * }
 */
public class UserLevelBean {

    private int code;
    private boolean full;
    private Data data;

    public static class Data {

        private long userId;
        private String info;
        private double progress;
        private int nextPlayCount;
        private int nextLoginCount;
        private int nowPlayCount;
        private int nowLoginCount;
        private int level;

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getUserId() {
            return userId;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }

        public void setProgress(double progress) {
            this.progress = progress;
        }

        public double getProgress() {
            return progress;
        }

        public void setNextPlayCount(int nextPlayCount) {
            this.nextPlayCount = nextPlayCount;
        }

        public int getNextPlayCount() {
            return nextPlayCount;
        }

        public void setNextLoginCount(int nextLoginCount) {
            this.nextLoginCount = nextLoginCount;
        }

        public int getNextLoginCount() {
            return nextLoginCount;
        }

        public void setNowPlayCount(int nowPlayCount) {
            this.nowPlayCount = nowPlayCount;
        }

        public int getNowPlayCount() {
            return nowPlayCount;
        }

        public void setNowLoginCount(int nowLoginCount) {
            this.nowLoginCount = nowLoginCount;
        }

        public int getNowLoginCount() {
            return nowLoginCount;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
}
