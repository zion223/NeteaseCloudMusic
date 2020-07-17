package com.imooc.lib_api.model.mv;

import java.util.List;

public class VideoUrlBean {

    //普通视频
    private List<Urls> urls;
    //MV
    private Urls data;
    private int code;


    public Urls getData() {
        return data;
    }

    public void setData(Urls data) {
        this.data = data;
    }

    public void setUrls(List<Urls> urls) {
        this.urls = urls;
    }

    public List<Urls> getUrls() {
        return urls;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static class Urls {

        private String id;
        private String url;
        private long size;
        private int validityTime;
        private boolean needPay;
        private String payInfo;
        private int r;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public long getSize() {
            return size;
        }

        public void setValidityTime(int validityTime) {
            this.validityTime = validityTime;
        }

        public int getValidityTime() {
            return validityTime;
        }

        public void setNeedPay(boolean needPay) {
            this.needPay = needPay;
        }

        public boolean getNeedPay() {
            return needPay;
        }

        public void setPayInfo(String payInfo) {
            this.payInfo = payInfo;
        }

        public String getPayInfo() {
            return payInfo;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getR() {
            return r;
        }

    }
}