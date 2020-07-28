package com.imooc.lib_api.model.song;

import java.util.List;

public class SongUrlBean {

    private List<SongUrl> data;
    private int code;

    public List<SongUrl> getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public static class SongUrl {
        private long id;
        private String url;
        private long br;
        private long size;
        private String md5;
        private int code;
        private int expi;
        private String type;
        private int gain;
        private int fee;
        private String uf;
        private int payed;
        private int flag;
        private boolean canExtend;
        private String freeTrialInfo;
        private String level;
        private String encodeType;

        public long getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public long getBr() {
            return br;
        }

        public long getSize() {
            return size;
        }

        public String getMd5() {
            return md5;
        }

        public int getCode() {
            return code;
        }

        public int getExpi() {
            return expi;
        }

        public String getType() {
            return type;
        }

        public int getGain() {
            return gain;
        }

        public int getFee() {
            return fee;
        }

        public String getUf() {
            return uf;
        }

        public int getPayed() {
            return payed;
        }

        public int getFlag() {
            return flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public String getFreeTrialInfo() {
            return freeTrialInfo;
        }

        public String getLevel() {
            return level;
        }

        public String getEncodeType() {
            return encodeType;
        }
    }
}
