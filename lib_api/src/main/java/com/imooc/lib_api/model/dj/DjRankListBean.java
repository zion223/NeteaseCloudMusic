package com.imooc.lib_api.model.dj;


public class DjRankListBean {

    private int code;
    private String msg;
    private Data data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public static class Data {

        private int total;
        private long updateTime;
        private java.util.List<List> list;

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal() {
            return total;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setList(java.util.List<List> list) {
            this.list = list;
        }

        public java.util.List<List> getList() {
            return list;
        }

    }

    public static class List {

        private long id;
        private int rank;
        private int lastRank;
        private long score;
        private String nickName;
        private String avatarUrl;
        private int userType;

        public void setId(long id) {
            this.id = id;
        }

        public String getId() {
            return String.valueOf(id);
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public void setLastRank(int lastRank) {
            this.lastRank = lastRank;
        }

        public int getLastRank() {
            return lastRank;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public long getScore() {
            return score;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getUserType() {
            return userType;
        }

    }
}
