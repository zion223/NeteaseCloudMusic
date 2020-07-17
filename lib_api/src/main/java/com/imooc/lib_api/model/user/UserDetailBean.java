package com.imooc.lib_api.model.user;

import java.io.Serializable;
import java.util.List;

/**
 * 通过接口获取的用户个人信息Bean
 */
public class UserDetailBean implements Serializable {

    /**
     * level : 9
     * listenSongs : 12720
     * userPoint : {"userId":415560926,"balance":106,"updateTime":1564106670906,"version":10,"status":0,"blockBalance":0}
     * mobileSign : false
     * pcSign : false
     * profile : {"userId":415560926,"accountStatus":0,"djStatus":0,"province":440000,"vipType":0,"avatarImgId":18787355185828650,"birthday":887904000000,"gender":0,"nickname":"rikkatheworld","userType":0,"description":"","mutual":false,"followed":false,"remarkName":null,"authStatus":0,"detailDescription":"","experts":{},"expertTags":null,"city":440300,"defaultAvatar":false,"avatarUrl":"http://p1.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg","backgroundImgId":109951163710677230,"backgroundUrl":"http://p1.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg","avatarImgIdStr":"18787355185828647","backgroundImgIdStr":"109951163710677237","signature":"","authority":0,"avatarImgId_str":"18787355185828647","artistIdentity":[],"followeds":3,"follows":1,"cCount":0,"blacklist":false,"eventCount":0,"sDJPCount":0,"allSubscribedCount":0,"playlistCount":3,"playlistBeSubscribedCount":1,"sCount":0}
     * peopleCanSeeMyPlayRecord : true
     * bindings : [{"userId":415560926,"url":"","bindingTime":1486309535025,"tokenJsonStr":null,"expired":false,"expiresIn":2147483647,"refreshTime":1486309535,"id":2973312066,"type":1},{"userId":415560926,"url":"","bindingTime":1486309512369,"tokenJsonStr":null,"expired":false,"expiresIn":7776000,"refreshTime":1558957256,"id":2973299013,"type":5}]
     * adValid : true
     * code : 200
     * createTime : 1486309512362
     * createDays : 901
     */
    //等级LV.8
    private int level;
    private int listenSongs;
    private UserPointBean userPoint;
    private boolean mobileSign;
    private boolean pcSign;
    //个人资料
    private ProfileBean profile;
    private boolean peopleCanSeeMyPlayRecord;
    private boolean adValid;
    private int code;
    //村龄  时间戳
    private long createTime;
    private int createDays;
    //绑定的账号
    private List<BindingsBean> bindings;

    public static class UserPointBean implements Serializable {
        /**
         * userId : 415560926
         * balance : 106
         * updateTime : 1564106670906
         * version : 10
         * status : 0
         * blockBalance : 0
         */

        private long userId;
        private int balance;
        private long updateTime;
        private int version;
        private int status;
        private int blockBalance;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getBlockBalance() {
            return blockBalance;
        }

        public void setBlockBalance(int blockBalance) {
            this.blockBalance = blockBalance;
        }
    }

    public static class ProfileBean implements Serializable {
        /**
         * userId : 415560926
         * accountStatus : 0
         * djStatus : 0
         * province : 440000
         * vipType : 0
         * avatarImgId : 18787355185828650
         * birthday : 887904000000
         * gender : 0
         * nickname : rikkatheworld
         * userType : 0
         * description :
         * mutual : false
         * followed : false
         * remarkName : null
         * authStatus : 0
         * detailDescription :
         * experts : {}
         * expertTags : null
         * city : 440300
         * defaultAvatar : false
         * avatarUrl : http://p1.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg
         * backgroundImgId : 109951163710677230
         * backgroundUrl : http://p1.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg
         * avatarImgIdStr : 18787355185828647
         * backgroundImgIdStr : 109951163710677237
         * signature :
         * authority : 0
         * avatarImgId_str : 18787355185828647
         * artistIdentity : []
         * followeds : 3
         * follows : 1
         * cCount : 0
         * blacklist : false
         * eventCount : 0
         * sDJPCount : 0
         * allSubscribedCount : 0
         * playlistCount : 3
         * playlistBeSubscribedCount : 1
         * sCount : 0
         */

        private int userId;
        private int accountStatus;
        private int djStatus;
        private int province;
        private int vipType;
        private long avatarImgId;
        private long birthday;
        private int gender;
        private String nickname;
        private int userType;
        private String description;
        private boolean mutual;
        private boolean followed;
        private Object remarkName;
        private int authStatus;
        private String detailDescription;
        private ExpertsBean experts;
        private Object expertTags;
        private int city;
        private boolean defaultAvatar;
        private String avatarUrl;
        private long backgroundImgId;
        private String backgroundUrl;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String signature;
        private int authority;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int cCount;
        private boolean blacklist;
        private int eventCount;
        private int sDJPCount;
        private int allSubscribedCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;
        private int sCount;
        private List<?> artistIdentity;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getCCount() {
            return cCount;
        }

        public void setCCount(int cCount) {
            this.cCount = cCount;
        }

        public boolean isBlacklist() {
            return blacklist;
        }

        public void setBlacklist(boolean blacklist) {
            this.blacklist = blacklist;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getSDJPCount() {
            return sDJPCount;
        }

        public void setSDJPCount(int sDJPCount) {
            this.sDJPCount = sDJPCount;
        }

        public int getAllSubscribedCount() {
            return allSubscribedCount;
        }

        public void setAllSubscribedCount(int allSubscribedCount) {
            this.allSubscribedCount = allSubscribedCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public int getSCount() {
            return sCount;
        }

        public void setSCount(int sCount) {
            this.sCount = sCount;
        }

        public List<?> getArtistIdentity() {
            return artistIdentity;
        }

        public void setArtistIdentity(List<?> artistIdentity) {
            this.artistIdentity = artistIdentity;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean implements Serializable {

        @Override
        public String toString() {
            return "BindingsBean{" +
                    "userId=" + userId +
                    ", url='" + url + '\'' +
                    ", bindingTime=" + bindingTime +
                    ", tokenJsonStr=" + tokenJsonStr +
                    ", expired=" + expired +
                    ", expiresIn=" + expiresIn +
                    ", refreshTime=" + refreshTime +
                    ", id=" + id +
                    ", type=" + type +
                    '}';
        }

        /**
         * userId : 415560926
         * url :
         * bindingTime : 1486309535025
         * tokenJsonStr : null
         * expired : false
         * expiresIn : 2147483647
         * refreshTime : 1486309535
         * id : 2973312066
         * type : 1
         */

        private long userId;
        private String url;
        private long bindingTime;
        private Object tokenJsonStr;
        private boolean expired;
        private long expiresIn;
        private long refreshTime;
        private long id;
        private int type;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public Object getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(Object tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(long refreshTime) {
            this.refreshTime = refreshTime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getListenSongs() {
        return listenSongs;
    }

    public void setListenSongs(int listenSongs) {
        this.listenSongs = listenSongs;
    }

    public UserPointBean getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(UserPointBean userPoint) {
        this.userPoint = userPoint;
    }

    public boolean isMobileSign() {
        return mobileSign;
    }

    public void setMobileSign(boolean mobileSign) {
        this.mobileSign = mobileSign;
    }

    public boolean isPcSign() {
        return pcSign;
    }

    public void setPcSign(boolean pcSign) {
        this.pcSign = pcSign;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public boolean isPeopleCanSeeMyPlayRecord() {
        return peopleCanSeeMyPlayRecord;
    }

    public void setPeopleCanSeeMyPlayRecord(boolean peopleCanSeeMyPlayRecord) {
        this.peopleCanSeeMyPlayRecord = peopleCanSeeMyPlayRecord;
    }

    public boolean isAdValid() {
        return adValid;
    }

    public void setAdValid(boolean adValid) {
        this.adValid = adValid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getCreateDays() {
        return createDays;
    }

    public void setCreateDays(int createDays) {
        this.createDays = createDays;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }
}
