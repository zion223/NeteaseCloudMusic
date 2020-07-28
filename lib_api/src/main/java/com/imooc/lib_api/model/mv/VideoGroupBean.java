package com.imooc.lib_api.model.mv;

import java.util.List;


public class VideoGroupBean {

    private int code;
    private String message;
    private List<Data> data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public static class Data {

        private long id;
        private String name;
        private String url;
        private String relatedVideoType;
        private boolean selectTab;
        private String abExtInfo;

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setRelatedVideoType(String relatedVideoType) {
            this.relatedVideoType = relatedVideoType;
        }

        public String getRelatedVideoType() {
            return relatedVideoType;
        }

        public void setSelectTab(boolean selectTab) {
            this.selectTab = selectTab;
        }

        public boolean getSelectTab() {
            return selectTab;
        }

        public void setAbExtInfo(String abExtInfo) {
            this.abExtInfo = abExtInfo;
        }

        public String getAbExtInfo() {
            return abExtInfo;
        }

    }
}
