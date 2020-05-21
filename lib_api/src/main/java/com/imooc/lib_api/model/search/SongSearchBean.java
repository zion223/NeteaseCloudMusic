package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 通过API获取的搜索歌曲结果类
 */
public class SongSearchBean {

    /**
     * result : {"songs":[{"id":27917548,"name":"JoJo","artists":[{"id":48514,"name":"Boz Scaggs","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2694934,"name":"The Essential Boz Scaggs","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1383004800000,"size":32,"copyrightId":7001,"status":0,"picId":17829680556434244,"mark":0},"duration":354746,"copyrightId":7001,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":0},{"id":34072632,"name":"Save My Soul","artists":[{"id":60943,"name":"JoJo","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":3270985,"name":"III.","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1440086400007,"size":3,"copyrightId":0,"status":3,"picId":7974757838028840,"mark":0},"duration":224908,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":5269161,"fee":8,"rUrl":null,"mark":0}],"songCount":600}
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
         * songs : [{"id":27917548,"name":"JoJo","artists":[{"id":48514,"name":"Boz Scaggs","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2694934,"name":"The Essential Boz Scaggs","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1383004800000,"size":32,"copyrightId":7001,"status":0,"picId":17829680556434244,"mark":0},"duration":354746,"copyrightId":7001,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":0},{"id":34072632,"name":"Save My Soul","artists":[{"id":60943,"name":"JoJo","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":3270985,"name":"III.","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1440086400007,"size":3,"copyrightId":0,"status":3,"picId":7974757838028840,"mark":0},"duration":224908,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":5269161,"fee":8,"rUrl":null,"mark":0}]
         * songCount : 600
         */

        private int songCount;
        private List<SongsBean> songs;
        private List<SongsBean> data;

        public int getSongCount() {
            return songCount;
        }

        public void setSongCount(int songCount) {
            this.songCount = songCount;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
            /**
             * id : 27917548
             * name : JoJo
             * artists : [{"id":48514,"name":"Boz Scaggs","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}]
             * album : {"id":2694934,"name":"The Essential Boz Scaggs","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1383004800000,"size":32,"copyrightId":7001,"status":0,"picId":17829680556434244,"mark":0}
             * duration : 354746
             * copyrightId : 7001
             * status : 0
             * alias : []
             * rtype : 0
             * ftype : 0
             * mvid : 0
             * fee : 8
             * rUrl : null
             * mark : 0
             */

            private long id;
            private String name;
            private AlbumBean album;
            private int duration;
            private int copyrightId;
            private int status;
            private int rtype;
            private int ftype;
            //是否有MV
            private int mvid;
            private int fee;
            private Object rUrl;
            private long mark;
            private List<ArtistsBean> artists;
            private List<?> alias;

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

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public Object getRUrl() {
                return rUrl;
            }

            public void setRUrl(Object rUrl) {
                this.rUrl = rUrl;
            }

            public long getMark() {
                return mark;
            }

            public void setMark(long mark) {
                this.mark = mark;
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

            public static class AlbumBean {
                /**
                 * id : 2694934
                 * name : The Essential Boz Scaggs
                 * artist : {"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}
                 * publishTime : 1383004800000
                 * size : 32
                 * copyrightId : 7001
                 * status : 0
                 * picId : 17829680556434244
                 * mark : 0
                 */

                private int id;
                private String name;
                private ArtistBean artist;
                private long publishTime;
                private int size;
                private int copyrightId;
                private int status;
                private long picId;
                private long mark;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public ArtistBean getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBean artist) {
                    this.artist = artist;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public long getMark() {
                    return mark;
                }

                public void setMark(long mark) {
                    this.mark = mark;
                }

                public static class ArtistBean {
                    /**
                     * id : 0
                     * name :
                     * picUrl : null
                     * alias : []
                     * albumSize : 0
                     * picId : 0
                     * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1 : 0
                     * trans : null
                     */

                    private int id;
                    private String name;
                    private Object picUrl;
                    private int albumSize;
                    private int picId;
                    private String img1v1Url;
                    private int img1v1;
                    private Object trans;
                    private List<?> alias;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public Object getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(Object picUrl) {
                        this.picUrl = picUrl;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getImg1v1() {
                        return img1v1;
                    }

                    public void setImg1v1(int img1v1) {
                        this.img1v1 = img1v1;
                    }

                    public Object getTrans() {
                        return trans;
                    }

                    public void setTrans(Object trans) {
                        this.trans = trans;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }
            }

            public static class ArtistsBean {
                /**
                 * id : 48514
                 * name : Boz Scaggs
                 * picUrl : null
                 * alias : []
                 * albumSize : 0
                 * picId : 0
                 * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1 : 0
                 * trans : null
                 */

                private int id;
                private String name;
                private String picUrl;
                private int albumSize;
                private int picId;
                private String img1v1Url;
                private int img1v1;
                private Object trans;
                private List<?> alias;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(int img1v1) {
                    this.img1v1 = img1v1;
                }

                public Object getTrans() {
                    return trans;
                }

                public void setTrans(Object trans) {
                    this.trans = trans;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }

            @Override
            public String toString() {
                return "SongsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", album=" + album +
                        ", duration=" + duration +
                        ", copyrightId=" + copyrightId +
                        ", status=" + status +
                        ", rtype=" + rtype +
                        ", ftype=" + ftype +
                        ", mvid=" + mvid +
                        ", fee=" + fee +
                        ", rUrl=" + rUrl +
                        ", mark=" + mark +
                        ", artists=" + artists +
                        ", alias=" + alias +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "songCount=" + songCount +
                    ", songs=" + songs +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SongSearchBean{" +
                "result=" + result +
                ", code=" + code +
                '}';
    }
}
