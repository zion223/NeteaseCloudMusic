package com.imooc.imooc_voice.model.newapi;



import com.imooc.imooc_voice.model.newapi.search.MvBean;

import java.util.List;

public class MvSublistBean {

    /**
     * code : 200
     * data : [{"type":0,"title":"你的微笑","durationms":265000,"creator":[{"userId":11562,"userName":"F.I.R"}],"playTime":782783,"coverUrl":"http://p1.music.126.net/UIlOiMnUleUmaxyEXThmPw==/1426066585668185.jpg","vid":"5307442","aliaName":null,"transName":null,"alg":null,"markTypes":null},{"type":1,"title":"找到《往后余生》最好听的版本，配上这个MV，看哭了","durationms":269047,"creator":[{"userId":19389416,"userName":"全球趣音乐"}],"playTime":2969673,"coverUrl":"http://p1.music.126.net/6B4jCaJQtfn60wuGKltX7Q==/109951163842985266.jpg","vid":"4E673ABCA5B939B889FDE4A2B148C2BD","aliaName":null,"transName":null,"alg":null,"markTypes":[]}]
     * hasMore : false
     * count : 2
     */

    private int code;
    private boolean hasMore;
    private int count;
    private List<DataBean> data;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 0
         * title : 你的微笑
         * durationms : 265000
         * creator : [{"userId":11562,"userName":"F.I.R"}]
         * playTime : 782783
         * coverUrl : http://p1.music.126.net/UIlOiMnUleUmaxyEXThmPw==/1426066585668185.jpg
         * vid : 5307442
         * aliaName : null
         * transName : null
         * alg : null
         * markTypes : null
         */

        private int type;
        private String title;
        private long durationms;
        private int playTime;
        private String coverUrl;
        private String vid;
        private Object aliaName;
        private Object transName;
        private Object alg;
        private Object markTypes;
        private List<MvBean.CreatorBean> creator;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getDurationms() {
            return durationms;
        }

        public void setDurationms(long durationms) {
            this.durationms = durationms;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void setPlayTime(int playTime) {
            this.playTime = playTime;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public Object getAliaName() {
            return aliaName;
        }

        public void setAliaName(Object aliaName) {
            this.aliaName = aliaName;
        }

        public Object getTransName() {
            return transName;
        }

        public void setTransName(Object transName) {
            this.transName = transName;
        }

        public Object getAlg() {
            return alg;
        }

        public void setAlg(Object alg) {
            this.alg = alg;
        }

        public Object getMarkTypes() {
            return markTypes;
        }

        public void setMarkTypes(Object markTypes) {
            this.markTypes = markTypes;
        }

        public List<MvBean.CreatorBean> getCreator() {
            return creator;
        }

        public void setCreator(List<MvBean.CreatorBean> creator) {
            this.creator = creator;
        }

    }
}
