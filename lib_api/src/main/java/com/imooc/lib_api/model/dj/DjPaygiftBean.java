package com.imooc.lib_api.model.dj;

import java.util.List;

/**
 * 付费精选
 */
public class DjPaygiftBean {

    /**
     * code : 200
     * msg : null
     * data : {"hasMore":true,"list":[{"id":791646415,"name":"情绪紧急救助冥想","rcmdText":"心情急救箱 适用于你的每次不安","radioFeeType":2,"feeScope":0,"picUrl":"https://p1.music.126.net/oMC7XFuENtvMBZP-WGxvEg==/109951163546248655.jpg","programCount":6,"playCount":null,"alg":"featured","originalPrice":1200,"discountPrice":null,"lastProgramName":"【发刊词】控制好情绪的人，眼中的世界都自带光芒"}]}
     */

    private int code;
    private Object msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hasMore : true
         * list : [{"id":791646415,"name":"情绪紧急救助冥想","rcmdText":"心情急救箱 适用于你的每次不安","radioFeeType":2,"feeScope":0,"picUrl":"https://p1.music.126.net/oMC7XFuENtvMBZP-WGxvEg==/109951163546248655.jpg","programCount":6,"playCount":null,"alg":"featured","originalPrice":1200,"discountPrice":null,"lastProgramName":"【发刊词】控制好情绪的人，眼中的世界都自带光芒"}]
         */

        private boolean hasMore;
        private List<ListBean> list;

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 791646415
             * name : 情绪紧急救助冥想
             * rcmdText : 心情急救箱 适用于你的每次不安
             * radioFeeType : 2
             * feeScope : 0
             * picUrl : https://p1.music.126.net/oMC7XFuENtvMBZP-WGxvEg==/109951163546248655.jpg
             * programCount : 6
             * playCount : null
             * alg : featured
             * originalPrice : 1200
             * discountPrice : null
             * lastProgramName : 【发刊词】控制好情绪的人，眼中的世界都自带光芒
             */

            private long id;
            private String name;
            private String rcmdText;
            private int radioFeeType;
            private int feeScope;
            private String picUrl;
            private int programCount;
            private Object playCount;
            private String alg;
            private int originalPrice;
            private Object discountPrice;
            private String lastProgramName;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRcmdText() {
                return rcmdText;
            }

            public void setRcmdText(String rcmdText) {
                this.rcmdText = rcmdText;
            }

            public int getRadioFeeType() {
                return radioFeeType;
            }

            public void setRadioFeeType(int radioFeeType) {
                this.radioFeeType = radioFeeType;
            }

            public int getFeeScope() {
                return feeScope;
            }

            public void setFeeScope(int feeScope) {
                this.feeScope = feeScope;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getProgramCount() {
                return programCount;
            }

            public void setProgramCount(int programCount) {
                this.programCount = programCount;
            }

            public Object getPlayCount() {
                return playCount;
            }

            public void setPlayCount(Object playCount) {
                this.playCount = playCount;
            }

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public Object getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(Object discountPrice) {
                this.discountPrice = discountPrice;
            }

            public String getLastProgramName() {
                return lastProgramName;
            }

            public void setLastProgramName(String lastProgramName) {
                this.lastProgramName = lastProgramName;
            }
        }
    }
}
