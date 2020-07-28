package com.imooc.lib_api.model.user;

import java.util.List;

/**
 * 通过login接口返回来的bean
 */
public class LoginBean {


    /**
     * loginType : 1
     * code : 200
     * account : {"id":415560926,"userName":"1_13272136221","type":1,"status":0,"whitelistAuthority":0,"createTime":1486309512362,"salt":"[B@3c3d6a89","tokenVersion":0,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * profile : {"detailDescription":"","followed":false,"userId":415560926,"defaultAvatar":false,"avatarUrl":"https://p3.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg","nickname":"rikkatheworld","birthday":887904000000,"avatarImgId":18787355185828650,"province":440000,"accountStatus":0,"vipType":0,"gender":0,"djStatus":0,"avatarImgIdStr":"18787355185828647","backgroundImgIdStr":"109951163710677237","experts":{},"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"backgroundImgId":109951163710677230,"userType":0,"city":440300,"signature":"","authority":0,"description":"","backgroundUrl":"https://p4.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg","avatarImgId_str":"18787355185828647","followeds":3,"follows":1,"eventCount":0,"playlistCount":3,"playlistBeSubscribedCount":1}
     * bindings : [{"refreshTime":1486309535,"url":"","userId":415560926,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"13272136221\",\"hasPassword\":true}","id":2973312066,"type":1,"expiresIn":2147483647,"bindingTime":1486309535025,"expired":false},{"refreshTime":1558957256,"url":"","userId":415560926,"tokenJsonStr":"{\"access_token\":\"A73ACD9A247F38479247AD3BA69488BB\",\"refresh_token\":\"3DDEE9EA1955B12F72682A71CC2E95C8\",\"openid\":\"CFA63F441F4BA6BF4999A0182698EC62\",\"nickname\":\"RikkaTheWorld\",\"expires_in\":7776000}","id":2973299013,"type":5,"expiresIn":7776000,"bindingTime":1486309512369,"expired":false}]
     */
    private String msg;
    private int loginType;
    private int code;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 415560926
         * userName : 1_13272136221
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1486309512362
         * salt : [B@3c3d6a89
         * tokenVersion : 0
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */

        private long id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private double viptypeVersion;
        private boolean anonimousUser;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public double getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }

        @Override
        public String toString() {
            return "AccountBean{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", type=" + type +
                    ", status=" + status +
                    ", whitelistAuthority=" + whitelistAuthority +
                    ", createTime=" + createTime +
                    ", salt='" + salt + '\'' +
                    ", tokenVersion=" + tokenVersion +
                    ", ban=" + ban +
                    ", baoyueVersion=" + baoyueVersion +
                    ", donateVersion=" + donateVersion +
                    ", vipType=" + vipType +
                    ", viptypeVersion=" + viptypeVersion +
                    ", anonimousUser=" + anonimousUser +
                    '}';
        }
    }

    public static class ProfileBean {
        /**
         * detailDescription :
         * followed : false
         * userId : 415560926
         * defaultAvatar : false
         * avatarUrl : https://p3.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg
         * nickname : rikkatheworld
         * birthday : 887904000000
         * avatarImgId : 18787355185828650
         * province : 440000
         * accountStatus : 0
         * vipType : 0
         * gender : 0
         * djStatus : 0
         * avatarImgIdStr : 18787355185828647
         * backgroundImgIdStr : 109951163710677237
         * experts : {}
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * backgroundImgId : 109951163710677230
         * userType : 0
         * city : 440300
         * signature :
         * authority : 0
         * description :
         * backgroundUrl : https://p4.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg
         * avatarImgId_str : 18787355185828647
         * followeds : 3
         * follows : 1
         * eventCount : 0
         * playlistCount : 3
         * playlistBeSubscribedCount : 1
         */

        private String detailDescription;
        private boolean followed;
        private int userId;
        private boolean defaultAvatar;
        private String avatarUrl;
        private String nickname;
        private long birthday;
        private long avatarImgId;
        private int province;
        private int accountStatus;
        private int vipType;
        private int gender;
        private int djStatus;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private ExpertsBean experts;
        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private int authStatus;
        private long backgroundImgId;
        private int userType;
        private int city;
        private String signature;
        private int authority;
        private String description;
        private String backgroundUrl;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int eventCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
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

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
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

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
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

        public static class ExpertsBean {
        }

        @Override
        public String toString() {
            return "ProfileBean{" +
                    "detailDescription='" + detailDescription + '\'' +
                    ", followed=" + followed +
                    ", userId=" + userId +
                    ", defaultAvatar=" + defaultAvatar +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", birthday=" + birthday +
                    ", avatarImgId=" + avatarImgId +
                    ", province=" + province +
                    ", accountStatus=" + accountStatus +
                    ", vipType=" + vipType +
                    ", gender=" + gender +
                    ", djStatus=" + djStatus +
                    ", avatarImgIdStr='" + avatarImgIdStr + '\'' +
                    ", backgroundImgIdStr='" + backgroundImgIdStr + '\'' +
                    ", experts=" + experts +
                    ", mutual=" + mutual +
                    ", remarkName=" + remarkName +
                    ", expertTags=" + expertTags +
                    ", authStatus=" + authStatus +
                    ", backgroundImgId=" + backgroundImgId +
                    ", userType=" + userType +
                    ", city=" + city +
                    ", signature='" + signature + '\'' +
                    ", authority=" + authority +
                    ", description='" + description + '\'' +
                    ", backgroundUrl='" + backgroundUrl + '\'' +
                    ", avatarImgId_str='" + avatarImgId_str + '\'' +
                    ", followeds=" + followeds +
                    ", follows=" + follows +
                    ", eventCount=" + eventCount +
                    ", playlistCount=" + playlistCount +
                    ", playlistBeSubscribedCount=" + playlistBeSubscribedCount +
                    '}';
        }
    }

    public static class BindingsBean {
        /**
         * refreshTime : 1486309535
         * url :
         * userId : 415560926
         * tokenJsonStr : {"countrycode":"","cellphone":"13272136221","hasPassword":true}
         * id : 2973312066
         * type : 1
         * expiresIn : 2147483647
         * bindingTime : 1486309535025
         * expired : false
         */

        private int refreshTime;
        private String url;
        private int userId;
        private String tokenJsonStr;
        private long id;
        private int type;
        private int expiresIn;
        private long bindingTime;
        private boolean expired;

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
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

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        @Override
        public String toString() {
            return "BindingsBean{" +
                    "refreshTime=" + refreshTime +
                    ", url='" + url + '\'' +
                    ", userId=" + userId +
                    ", tokenJsonStr='" + tokenJsonStr + '\'' +
                    ", id=" + id +
                    ", type=" + type +
                    ", expiresIn=" + expiresIn +
                    ", bindingTime=" + bindingTime +
                    ", expired=" + expired +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "loginType=" + loginType +
                ", code=" + code +
                ", account=" + account +
                ", profile=" + profile +
                ", bindings=" + bindings +
                '}';
    }
}
