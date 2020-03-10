package com.imooc.imooc_voice.model.newapi;

import java.util.List;

public class AlbumSublistBean {


    /**
     * data : [{"subTime":1568863447079,"msg":[],"alias":["战姬绝唱SYMPHOGEAR XV 角色歌6"],"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"picId":0,"albumSize":0,"musicSize":0,"briefDesc":"","followed":false,"img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}],"picId":109951164342901890,"picUrl":"https://p1.music.126.net/68u951bt6jm-E4nCyuIuRw==/109951164342901886.jpg","name":"戦姫絶唱シンフォギアXV キャラクターソング6","id":81347636,"size":4,"transNames":[]}]
     * count : 1
     * hasMore : false
     * paidCount : 0
     * code : 200
     */

    private int count;
    private boolean hasMore;
    private int paidCount;
    private int code;
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(int paidCount) {
        this.paidCount = paidCount;
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
         * subTime : 1568863447079
         * msg : []
         * alias : ["战姬绝唱SYMPHOGEAR XV 角色歌6"]
         * artists : [{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"picId":0,"albumSize":0,"musicSize":0,"briefDesc":"","followed":false,"img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}]
         * picId : 109951164342901890
         * picUrl : https://p1.music.126.net/68u951bt6jm-E4nCyuIuRw==/109951164342901886.jpg
         * name : 戦姫絶唱シンフォギアXV キャラクターソング6
         * id : 81347636
         * size : 4
         * transNames : []
         */

        private long subTime;
        private long picId;
        private String picUrl;
        private String name;
        private long id;
        private int size;
        private List<?> msg;
        private List<String> alias;
        private List<ArtistsBean> artists;
        private List<?> transNames;

        public long getSubTime() {
            return subTime;
        }

        public void setSubTime(long subTime) {
            this.subTime = subTime;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public List<?> getMsg() {
            return msg;
        }

        public void setMsg(List<?> msg) {
            this.msg = msg;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public List<?> getTransNames() {
            return transNames;
        }

        public void setTransNames(List<?> transNames) {
            this.transNames = transNames;
        }

        public static class ArtistsBean {
            /**
             * img1v1Id : 18686200114669624
             * topicPerson : 0
             * alias : []
             * picId : 0
             * albumSize : 0
             * musicSize : 0
             * briefDesc :
             * followed : false
             * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * trans :
             * picUrl : https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * name : 水樹奈々
             * id : 17028
             * img1v1Id_str : 18686200114669622
             */

            private long img1v1Id;
            private int topicPerson;
            private long picId;
            private int albumSize;
            private int musicSize;
            private String briefDesc;
            private boolean followed;
            private String img1v1Url;
            private String trans;
            private String picUrl;
            private String name;
            private long id;
            private String img1v1Id_str;
            private List<?> alias;

            public long getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(long img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public int getTopicPerson() {
                return topicPerson;
            }

            public void setTopicPerson(int topicPerson) {
                this.topicPerson = topicPerson;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            @Override
            public String toString() {
                return "ArtistsBean{" +
                        "img1v1Id=" + img1v1Id +
                        ", topicPerson=" + topicPerson +
                        ", picId=" + picId +
                        ", albumSize=" + albumSize +
                        ", musicSize=" + musicSize +
                        ", briefDesc='" + briefDesc + '\'' +
                        ", followed=" + followed +
                        ", img1v1Url='" + img1v1Url + '\'' +
                        ", trans='" + trans + '\'' +
                        ", picUrl='" + picUrl + '\'' +
                        ", name='" + name + '\'' +
                        ", id=" + id +
                        ", img1v1Id_str='" + img1v1Id_str + '\'' +
                        ", alias=" + alias +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "subTime=" + subTime +
                    ", picId=" + picId +
                    ", picUrl='" + picUrl + '\'' +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", size=" + size +
                    ", msg=" + msg +
                    ", alias=" + alias +
                    ", artists=" + artists +
                    ", transNames=" + transNames +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AlbumSublistBean{" +
                "count=" + count +
                ", hasMore=" + hasMore +
                ", paidCount=" + paidCount +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
