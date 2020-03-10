package com.imooc.imooc_voice.model.newapi;

import java.util.List;

public class ArtistSublistBean {

    /**
     * data : [{"info":"新碟《戦姫絶唱シンフォギアXV キャラクターソング6》抢鲜上架","id":17028,"name":"水樹奈々","trans":"水树奈奈","alias":["Mizuki Nana"],"albumSize":89,"mvSize":3,"picId":109951164158292080,"picUrl":"https://p1.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg","img1v1Url":"https://p2.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg"},{"info":"","id":768306,"name":"网易云音乐","trans":null,"alias":[],"albumSize":11,"mvSize":41,"picId":2274889557915240,"picUrl":"https://p1.music.126.net/0R_1imPfGwoeT199iPa5dA==/2274889557915240.jpg","img1v1Url":"https://p2.music.126.net/0R_1imPfGwoeT199iPa5dA==/2274889557915240.jpg"}]
     * hasMore : false
     * count : 2
     * code : 200
     */

    private boolean hasMore;
    private int count;
    private int code;
    private List<DataBean> data;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * info : 新碟《戦姫絶唱シンフォギアXV キャラクターソング6》抢鲜上架
         * id : 17028
         * name : 水樹奈々
         * trans : 水树奈奈
         * alias : ["Mizuki Nana"]
         * albumSize : 89
         * mvSize : 3
         * picId : 109951164158292080
         * picUrl : https://p1.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg
         * img1v1Url : https://p2.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg
         */

        private String info;
        private long id;
        private String name;
        private String trans;
        private int albumSize;
        private int mvSize;
        private long picId;
        private String picUrl;
        private String img1v1Url;
        private List<String> alias;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

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

        public String getTrans() {
            return trans;
        }

        public void setTrans(String trans) {
            this.trans = trans;
        }

        public int getAlbumSize() {
            return albumSize;
        }

        public void setAlbumSize(int albumSize) {
            this.albumSize = albumSize;
        }

        public int getMvSize() {
            return mvSize;
        }

        public void setMvSize(int mvSize) {
            this.mvSize = mvSize;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getImg1v1Url() {
            return img1v1Url;
        }

        public void setImg1v1Url(String img1v1Url) {
            this.img1v1Url = img1v1Url;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }
    }
}
