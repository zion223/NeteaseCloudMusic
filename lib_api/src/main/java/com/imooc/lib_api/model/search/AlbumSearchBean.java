package com.imooc.lib_api.model.search;

import java.util.List;

public class AlbumSearchBean {

    /**
     * result : {"albums":[{"name":"エッセンシャル・コレクション~ラスト・トレイン・ホーム","id":3136085,"type":"专辑","size":12,"picId":2929098977371317,"blurPicUrl":"http://p3.music.126.net/hR4C-30f8KJAqJLKWAC43w==/2929098977371317.jpg","companyId":0,"pic":2929098977371317,"picUrl":"http://p3.music.126.net/hR4C-30f8KJAqJLKWAC43w==/2929098977371317.jpg","publishTime":1425398400007,"description":"","tags":"","company":"华纳音乐","briefDesc":"","artist":{"name":"Pat Metheny Group","id":41216,"picId":755364488286118,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/zVmFaXWu2mVT6qIotf-J6Q==/755364488286118.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":25,"alias":[],"trans":"帕特梅思尼乐团","musicSize":225,"topicPerson":0,"transNames":["帕特梅思尼乐团"],"img1v1Id_str":"18686200114669622","alia":[]},"songs":null,"alias":[],"status":0,"copyrightId":0,"commentThreadId":"R_AL_3_3136085","artists":[{"name":"Pat Metheny Group","id":41216,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}],"paid":false,"onSale":false,"alg":"alg_album_basic_a","mark":0,"containedSong":""},{"name":"ジョジョの奇妙な冒険 スターダストクルセイダース O.S.T[Departure]","id":3101037,"type":"专辑","size":23,"picId":7873602766692554,"blurPicUrl":"http://p4.music.126.net/S3liZdT3hhoNjIyXdmYAxA==/7873602766692554.jpg","companyId":0,"pic":7873602766692554,"picUrl":"http://p3.music.126.net/S3liZdT3hhoNjIyXdmYAxA==/7873602766692554.jpg","publishTime":1406649600000,"description":"","tags":"","company":"华纳音乐","briefDesc":"","artist":{"name":"菅野祐悟","id":14472,"picId":109951163183675070,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p3.music.126.net/_2TTLiDvMJcwiANoWQIx5w==/109951163183675077.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":106,"alias":["かんの ゆうご"],"trans":"","musicSize":2705,"topicPerson":0,"picId_str":"109951163183675077","img1v1Id_str":"18686200114669622","alia":["かんの ゆうご"]},"songs":null,"alias":["TV动画《JOJO的奇妙冒险 星尘斗士》原声集1"],"status":0,"copyrightId":0,"commentThreadId":"R_AL_3_3101037","artists":[{"name":"菅野祐悟","id":14472,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}],"paid":false,"onSale":false,"alg":"alg_album_basic_a","mark":0,"containedSong":""}],"albumCount":586}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * albums : [{"name":"エッセンシャル・コレクション~ラスト・トレイン・ホーム","id":3136085,"type":"专辑","size":12,"picId":2929098977371317,"blurPicUrl":"http://p3.music.126.net/hR4C-30f8KJAqJLKWAC43w==/2929098977371317.jpg","companyId":0,"pic":2929098977371317,"picUrl":"http://p3.music.126.net/hR4C-30f8KJAqJLKWAC43w==/2929098977371317.jpg","publishTime":1425398400007,"description":"","tags":"","company":"华纳音乐","briefDesc":"","artist":{"name":"Pat Metheny Group","id":41216,"picId":755364488286118,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/zVmFaXWu2mVT6qIotf-J6Q==/755364488286118.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":25,"alias":[],"trans":"帕特梅思尼乐团","musicSize":225,"topicPerson":0,"transNames":["帕特梅思尼乐团"],"img1v1Id_str":"18686200114669622","alia":[]},"songs":null,"alias":[],"status":0,"copyrightId":0,"commentThreadId":"R_AL_3_3136085","artists":[{"name":"Pat Metheny Group","id":41216,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}],"paid":false,"onSale":false,"alg":"alg_album_basic_a","mark":0,"containedSong":""},{"name":"ジョジョの奇妙な冒険 スターダストクルセイダース O.S.T[Departure]","id":3101037,"type":"专辑","size":23,"picId":7873602766692554,"blurPicUrl":"http://p4.music.126.net/S3liZdT3hhoNjIyXdmYAxA==/7873602766692554.jpg","companyId":0,"pic":7873602766692554,"picUrl":"http://p3.music.126.net/S3liZdT3hhoNjIyXdmYAxA==/7873602766692554.jpg","publishTime":1406649600000,"description":"","tags":"","company":"华纳音乐","briefDesc":"","artist":{"name":"菅野祐悟","id":14472,"picId":109951163183675070,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p3.music.126.net/_2TTLiDvMJcwiANoWQIx5w==/109951163183675077.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":106,"alias":["かんの ゆうご"],"trans":"","musicSize":2705,"topicPerson":0,"picId_str":"109951163183675077","img1v1Id_str":"18686200114669622","alia":["かんの ゆうご"]},"songs":null,"alias":["TV动画《JOJO的奇妙冒险 星尘斗士》原声集1"],"status":0,"copyrightId":0,"commentThreadId":"R_AL_3_3101037","artists":[{"name":"菅野祐悟","id":14472,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}],"paid":false,"onSale":false,"alg":"alg_album_basic_a","mark":0,"containedSong":""}]
         * albumCount : 586
         */

        private int albumCount;
        private List<AlbumsBean> albums;
        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getAlbumCount() {
            return albumCount;
        }

        public void setAlbumCount(int albumCount) {
            this.albumCount = albumCount;
        }

        public List<AlbumsBean> getAlbums() {
            return albums;
        }

        public void setAlbums(List<AlbumsBean> albums) {
            this.albums = albums;
        }

        public static class AlbumsBean {
            /**
             * name : エッセンシャル・コレクション~ラスト・トレイン・ホーム
             * id : 3136085
             * type : 专辑
             * size : 12
             * picId : 2929098977371317
             * blurPicUrl : http://p3.music.126.net/hR4C-30f8KJAqJLKWAC43w==/2929098977371317.jpg
             * companyId : 0
             * pic : 2929098977371317
             * picUrl : http://p3.music.126.net/hR4C-30f8KJAqJLKWAC43w==/2929098977371317.jpg
             * publishTime : 1425398400007
             * description :
             * tags :
             * company : 华纳音乐
             * briefDesc :
             * artist : {"name":"Pat Metheny Group","id":41216,"picId":755364488286118,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/zVmFaXWu2mVT6qIotf-J6Q==/755364488286118.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":25,"alias":[],"trans":"帕特梅思尼乐团","musicSize":225,"topicPerson":0,"transNames":["帕特梅思尼乐团"],"img1v1Id_str":"18686200114669622","alia":[]}
             * songs : null
             * alias : []
             * status : 0
             * copyrightId : 0
             * commentThreadId : R_AL_3_3136085
             * artists : [{"name":"Pat Metheny Group","id":41216,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}]
             * paid : false
             * onSale : false
             * alg : alg_album_basic_a
             * mark : 0
             * containedSong :
             */

            private String name;
            private long id;
            private String type;
            private int size;
            private long picId;
            private String blurPicUrl;
            private int companyId;
            private long pic;
            private String picUrl;
            private long publishTime;
            private String description;
            private String tags;
            private String company;
            private String briefDesc;
            private ArtistBean artist;
            private Object songs;
            private int status;
            private int copyrightId;
            private String commentThreadId;
            private boolean paid;
            private boolean onSale;
            private String alg;
            private int mark;
            private String containedSong;
            private List<?> alias;
            private List<ArtistsBean> artists;

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

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
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

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public ArtistBean getArtist() {
                return artist;
            }

            public void setArtist(ArtistBean artist) {
                this.artist = artist;
            }

            public Object getSongs() {
                return songs;
            }

            public void setSongs(Object songs) {
                this.songs = songs;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

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

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public int getMark() {
                return mark;
            }

            public void setMark(int mark) {
                this.mark = mark;
            }

            public String getContainedSong() {
                return containedSong;
            }

            public void setContainedSong(String containedSong) {
                this.containedSong = containedSong;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public static class ArtistBean {
                /**
                 * name : Pat Metheny Group
                 * id : 41216
                 * picId : 755364488286118
                 * img1v1Id : 18686200114669624
                 * briefDesc :
                 * picUrl : http://p4.music.126.net/zVmFaXWu2mVT6qIotf-J6Q==/755364488286118.jpg
                 * img1v1Url : http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                 * albumSize : 25
                 * alias : []
                 * trans : 帕特梅思尼乐团
                 * musicSize : 225
                 * topicPerson : 0
                 * transNames : ["帕特梅思尼乐团"]
                 * img1v1Id_str : 18686200114669622
                 * alia : []
                 */

                private String name;
                private int id;
                private long picId;
                private long img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private int topicPerson;
                private String img1v1Id_str;
                private List<?> alias;
                private List<String> transNames;
                private List<?> alia;

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

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
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

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
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

                public List<String> getTransNames() {
                    return transNames;
                }

                public void setTransNames(List<String> transNames) {
                    this.transNames = transNames;
                }

                public List<?> getAlia() {
                    return alia;
                }

                public void setAlia(List<?> alia) {
                    this.alia = alia;
                }
            }

            public static class ArtistsBean {
                /**
                 * name : Pat Metheny Group
                 * id : 41216
                 * picId : 0
                 * img1v1Id : 18686200114669624
                 * briefDesc :
                 * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 * topicPerson : 0
                 * img1v1Id_str : 18686200114669622
                 */

                private String name;
                private int id;
                private int picId;
                private long img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private int topicPerson;
                private String img1v1Id_str;
                private List<?> alias;

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

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
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

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
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
}
