package com.imooc.lib_api.model.search;

import java.util.List;

public class PlayListSearchBean {

    /**
     * result : {"playlists":[{"id":52746318,"name":"「JOJO的奇妙冒险」OP ED OST","coverImgUrl":"https://p1.music.126.net/sicaanj9a2OIqBrh-KYCuQ==/7765850627343694.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":363,"userId":8892659,"playCount":6865719,"bookCount":108033,"description":"ジョジョの奇妙な冒険","highQuality":false,"alg":"alg_playlist_total_intervene_basic"},{"id":9515375,"name":"「JOJO的奇妙冒险」OP ED 处刑曲","coverImgUrl":"https://p1.music.126.net/93wbHgPDkGRUHdRPJt96Gw==/109951163982689178.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":58,"userId":8892659,"playCount":2894732,"bookCount":45866,"description":"その血の運命～JO～JO！","highQuality":false,"alg":"alg_playlist_total_intervene_basic"}],"playlistCount":300}
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
         * playlists : [{"id":52746318,"name":"「JOJO的奇妙冒险」OP ED OST","coverImgUrl":"https://p1.music.126.net/sicaanj9a2OIqBrh-KYCuQ==/7765850627343694.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":363,"userId":8892659,"playCount":6865719,"bookCount":108033,"description":"ジョジョの奇妙な冒険","highQuality":false,"alg":"alg_playlist_total_intervene_basic"},{"id":9515375,"name":"「JOJO的奇妙冒险」OP ED 处刑曲","coverImgUrl":"https://p1.music.126.net/93wbHgPDkGRUHdRPJt96Gw==/109951163982689178.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":58,"userId":8892659,"playCount":2894732,"bookCount":45866,"description":"その血の運命～JO～JO！","highQuality":false,"alg":"alg_playlist_total_intervene_basic"}]
         * playlistCount : 300
         */

        private int playlistCount;
        private List<PlaylistsBean> playlists;

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public List<PlaylistsBean> getPlaylists() {
            return playlists;
        }

        public void setPlaylists(List<PlaylistsBean> playlists) {
            this.playlists = playlists;
        }

        public static class PlaylistsBean {
            /**
             * id : 52746318
             * name : 「JOJO的奇妙冒险」OP ED OST
             * coverImgUrl : https://p1.music.126.net/sicaanj9a2OIqBrh-KYCuQ==/7765850627343694.jpg
             * creator : {"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null}
             * subscribed : false
             * trackCount : 363
             * userId : 8892659
             * playCount : 6865719
             * bookCount : 108033
             * description : ジョジョの奇妙な冒険
             * highQuality : false
             * alg : alg_playlist_total_intervene_basic
             */

            private long id;
            private String name;
            private String coverImgUrl;
            private CreatorBean creator;
            private boolean subscribed;
            private int trackCount;
            private long userId;
            private int playCount;
            private int bookCount;
            private String description;
            private boolean highQuality;
            private String alg;

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

            public String getCoverImgUrl() {
                return coverImgUrl;
            }

            public void setCoverImgUrl(String coverImgUrl) {
                this.coverImgUrl = coverImgUrl;
            }

            public CreatorBean getCreator() {
                return creator;
            }

            public void setCreator(CreatorBean creator) {
                this.creator = creator;
            }

            public boolean isSubscribed() {
                return subscribed;
            }

            public void setSubscribed(boolean subscribed) {
                this.subscribed = subscribed;
            }

            public int getTrackCount() {
                return trackCount;
            }

            public void setTrackCount(int trackCount) {
                this.trackCount = trackCount;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public int getPlayCount() {
                return playCount;
            }

            public void setPlayCount(int playCount) {
                this.playCount = playCount;
            }

            public int getBookCount() {
                return bookCount;
            }

            public void setBookCount(int bookCount) {
                this.bookCount = bookCount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isHighQuality() {
                return highQuality;
            }

            public void setHighQuality(boolean highQuality) {
                this.highQuality = highQuality;
            }

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public static class CreatorBean {
                /**
                 * nickname : 螃蟹与干脆面
                 * userId : 8892659
                 * userType : 200
                 * authStatus : 0
                 * expertTags : null
                 * experts : null
                 */

                private String nickname;
                private long userId;
                private int userType;
                private int authStatus;
                private Object expertTags;
                private Object experts;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public long getUserId() {
                    return userId;
                }

                public void setUserId(long userId) {
                    this.userId = userId;
                }

                public int getUserType() {
                    return userType;
                }

                public void setUserType(int userType) {
                    this.userType = userType;
                }

                public int getAuthStatus() {
                    return authStatus;
                }

                public void setAuthStatus(int authStatus) {
                    this.authStatus = authStatus;
                }

                public Object getExpertTags() {
                    return expertTags;
                }

                public void setExpertTags(Object expertTags) {
                    this.expertTags = expertTags;
                }

                public Object getExperts() {
                    return experts;
                }

                public void setExperts(Object experts) {
                    this.experts = experts;
                }
            }
        }
    }
}
