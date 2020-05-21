package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 歌手专辑的bean
 */
public class SingerAblumSearchBean {

    /**
     * artist : {"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":88,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"}
     * hotAlbums : [{"songs":[],"paid":false,"onSale":false,"mark":0,"tags":"","status":0,"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"followed":false,"musicSize":0,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":0,"name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}],"alias":[],"company":"(P)King Record Co., Ltd.","copyrightId":756010,"picUrl":"https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg","blurPicUrl":"https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg","companyId":0,"commentThreadId":"R_AL_3_79880626","publishTime":1563292800000,"briefDesc":"","pic":109951164158415710,"subType":"录音室版","description":"","picId":109951164158415710,"artist":{"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":84,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"},"name":"METANOIA","id":79880626,"type":"EP/Single","size":3,"picId_str":"109951164158415714"},{"songs":[],"paid":false,"onSale":false,"mark":0,"tags":"","status":0,"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"followed":false,"musicSize":0,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":0,"name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}],"alias":[],"company":"(P)King Record Co., Ltd.","copyrightId":756010,"picUrl":"https://p1.music.126.net/ankcIREsX8yMplseQ02Qyg==/109951163811942476.jpg","blurPicUrl":"https://p1.music.126.net/ankcIREsX8yMplseQ02Qyg==/109951163811942476.jpg","companyId":0,"commentThreadId":"R_AL_3_75292586","publishTime":1548172800000,"briefDesc":"","pic":109951163811942480,"subType":"录音室版","description":"","picId":109951163811942480,"artist":{"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":84,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"},"name":"REBELLION","id":75292586,"type":"EP/Single","size":1,"picId_str":"109951163811942476"}]
     * more : true
     * code : 200
     */

    private ArtistBean artist;
    private boolean more;
    private int code;
    private List<HotAlbumsBean> hotAlbums;

    public ArtistBean getArtist() {
        return artist;
    }

    public void setArtist(ArtistBean artist) {
        this.artist = artist;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<HotAlbumsBean> getHotAlbums() {
        return hotAlbums;
    }

    public void setHotAlbums(List<HotAlbumsBean> hotAlbums) {
        this.hotAlbums = hotAlbums;
    }

    public static class ArtistBean {
        /**
         * img1v1Id : 18686200114669624
         * topicPerson : 0
         * alias : ["Mizuki Nana"]
         * trans : 水树奈奈
         * picUrl : https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg
         * albumSize : 88
         * followed : false
         * musicSize : 739
         * briefDesc :
         * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
         * picId : 109951164158280930
         * name : 水樹奈々
         * id : 17028
         * picId_str : 109951164158280936
         * transNames : ["水树奈奈"]
         * img1v1Id_str : 18686200114669622
         */

        private long img1v1Id;
        private long topicPerson;
        private String trans;
        private String picUrl;
        private int albumSize;
        private boolean followed;
        private int musicSize;
        private String briefDesc;
        private String img1v1Url;
        private long picId;
        private String name;
        private long id;
        private String picId_str;
        private String img1v1Id_str;
        private List<String> alias;
        private List<String> transNames;

        public long getImg1v1Id() {
            return img1v1Id;
        }

        public void setImg1v1Id(long img1v1Id) {
            this.img1v1Id = img1v1Id;
        }

        public long getTopicPerson() {
            return topicPerson;
        }

        public void setTopicPerson(long topicPerson) {
            this.topicPerson = topicPerson;
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

        public int getAlbumSize() {
            return albumSize;
        }

        public void setAlbumSize(int albumSize) {
            this.albumSize = albumSize;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
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

        public String getImg1v1Url() {
            return img1v1Url;
        }

        public void setImg1v1Url(String img1v1Url) {
            this.img1v1Url = img1v1Url;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
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

        public String getPicId_str() {
            return picId_str;
        }

        public void setPicId_str(String picId_str) {
            this.picId_str = picId_str;
        }

        public String getImg1v1Id_str() {
            return img1v1Id_str;
        }

        public void setImg1v1Id_str(String img1v1Id_str) {
            this.img1v1Id_str = img1v1Id_str;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public List<String> getTransNames() {
            return transNames;
        }

        public void setTransNames(List<String> transNames) {
            this.transNames = transNames;
        }
    }

    public static class HotAlbumsBean {
        /**
         * songs : []
         * paid : false
         * onSale : false
         * mark : 0
         * tags :
         * status : 0
         * artists : [{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"followed":false,"musicSize":0,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":0,"name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}]
         * alias : []
         * company : (P)King Record Co., Ltd.
         * copyrightId : 756010
         * picUrl : https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg
         * blurPicUrl : https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg
         * companyId : 0
         * commentThreadId : R_AL_3_79880626
         * publishTime : 1563292800000
         * briefDesc :
         * pic : 109951164158415710
         * subType : 录音室版
         * description :
         * picId : 109951164158415710
         * artist : {"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":84,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"}
         * name : METANOIA
         * id : 79880626
         * type : EP/Single
         * size : 3
         * picId_str : 109951164158415714
         */

        private boolean paid;
        private boolean onSale;
        private int mark;
        private String tags;
        private int status;
        private String company;
        private int copyrightId;
        private String picUrl;
        private String blurPicUrl;
        private int companyId;
        private String commentThreadId;
        private long publishTime;
        private String briefDesc;
        private long pic;
        private String subType;
        private String description;
        private long picId;
        private ArtistBeanX artist;
        private String name;
        private int id;
        private String type;
        private int size;
        private String picId_str;
        private List<?> songs;
        private List<ArtistsBean> artists;
        private List<?> alias;

        public boolean isPaid() {
            return paid;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }

        public boolean isOnSale() {
            return onSale;
        }

        public void setOnSale(boolean onSale) {
            this.onSale = onSale;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public int getCopyrightId() {
            return copyrightId;
        }

        public void setCopyrightId(int copyrightId) {
            this.copyrightId = copyrightId;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getBlurPicUrl() {
            return blurPicUrl;
        }

        public void setBlurPicUrl(String blurPicUrl) {
            this.blurPicUrl = blurPicUrl;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public long getPic() {
            return pic;
        }

        public void setPic(long pic) {
            this.pic = pic;
        }

        public String getSubType() {
            return subType;
        }

        public void setSubType(String subType) {
            this.subType = subType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public ArtistBeanX getArtist() {
            return artist;
        }

        public void setArtist(ArtistBeanX artist) {
            this.artist = artist;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getPicId_str() {
            return picId_str;
        }

        public void setPicId_str(String picId_str) {
            this.picId_str = picId_str;
        }

        public List<?> getSongs() {
            return songs;
        }

        public void setSongs(List<?> songs) {
            this.songs = songs;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public List<?> getAlias() {
            return alias;
        }

        public void setAlias(List<?> alias) {
            this.alias = alias;
        }

        public static class ArtistBeanX {
            /**
             * img1v1Id : 18686200114669624
             * topicPerson : 0
             * alias : ["Mizuki Nana"]
             * trans : 水树奈奈
             * picUrl : https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg
             * albumSize : 84
             * followed : false
             * musicSize : 739
             * briefDesc :
             * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * picId : 109951164158280930
             * name : 水樹奈々
             * id : 17028
             * picId_str : 109951164158280936
             * transNames : ["水树奈奈"]
             * img1v1Id_str : 18686200114669622
             */

            private long img1v1Id;
            private int topicPerson;
            private String trans;
            private String picUrl;
            private int albumSize;
            private boolean followed;
            private int musicSize;
            private String briefDesc;
            private String img1v1Url;
            private long picId;
            private String name;
            private int id;
            private String picId_str;
            private String img1v1Id_str;
            private List<String> alias;
            private List<String> transNames;

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

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
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

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPicId_str() {
                return picId_str;
            }

            public void setPicId_str(String picId_str) {
                this.picId_str = picId_str;
            }

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public List<String> getAlias() {
                return alias;
            }

            public void setAlias(List<String> alias) {
                this.alias = alias;
            }

            public List<String> getTransNames() {
                return transNames;
            }

            public void setTransNames(List<String> transNames) {
                this.transNames = transNames;
            }
        }

        public static class ArtistsBean {
            /**
             * img1v1Id : 18686200114669624
             * topicPerson : 0
             * alias : []
             * trans :
             * picUrl : https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * albumSize : 0
             * followed : false
             * musicSize : 0
             * briefDesc :
             * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * picId : 0
             * name : 水樹奈々
             * id : 17028
             * img1v1Id_str : 18686200114669622
             */

            private long img1v1Id;
            private int topicPerson;
            private String trans;
            private String picUrl;
            private int albumSize;
            private boolean followed;
            private int musicSize;
            private String briefDesc;
            private String img1v1Url;
            private int picId;
            private String name;
            private int id;
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

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
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

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
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
        }
    }
}
