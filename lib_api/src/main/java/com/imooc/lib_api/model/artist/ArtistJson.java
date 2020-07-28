package com.imooc.lib_api.model.artist;


public class ArtistJson {
    /**
     * "id": 30796254,
     * "name": "勃勃",
     * "picUrl": "http://p2.music.126.net/Pgoqw9ex_mZEObuWBmddqA==/109951163682857566.jpg",
     * "alias": [],
     * "albumSize": 1,
     * "picId": 109951163682857566,
     * "img1v1Url": "http://p2.music.126.net/AITCmhyiNQXNeHyYMB6OZg==/109951163682852742.jpg",
     * "accountId": 263104397,
     * "img1v1": 109951163682852742,
     * "mvSize": 0,
     * "followed": false,
     * "trans": null
     */

    private ArtistDtoInfo result;
    private String code;

    public ArtistDtoInfo getResult() {
        return result;
    }

    public void setResult(ArtistDtoInfo result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public class ArtistDtoInfo {
        String artistCount;
        info[] artists;

        public String getArtistCount() {
            return artistCount;
        }

        public void setArtistCount(String artistCount) {
            this.artistCount = artistCount;
        }

        public info[] getArtists() {
            return artists;
        }

        public void setArtists(info[] artists) {
            this.artists = artists;
        }
    }

    public static class info {
        long id;
        String name;
        String picUrl;
        Object alias;
        long picId;
        String img1v1Url;
        String accountId;
        long img1v1;
        boolean followed;
        Object trans;

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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public Object getAlias() {
            return alias;
        }

        public void setAlias(Object alias) {
            this.alias = alias;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public String getImg1v1Url() {
            return img1v1Url;
        }

        public void setImg1v1Url(String img1v1Url) {
            this.img1v1Url = img1v1Url;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public long getImg1v1() {
            return img1v1;
        }

        public void setImg1v1(long img1v1) {
            this.img1v1 = img1v1;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public Object getTrans() {
            return trans;
        }

        public void setTrans(Object trans) {
            this.trans = trans;
        }
    }
}
