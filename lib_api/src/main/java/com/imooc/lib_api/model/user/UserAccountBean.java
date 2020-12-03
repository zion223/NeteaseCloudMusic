package com.imooc.lib_api.model.user;

/**
 * {
 * "code": 200,
 * "account": {
 * "id": 123170560,
 * "userName": "1_********913",
 * "type": 1,
 * "status": 0,
 * "whitelistAuthority": 0,
 * "createTime": 1452661976029,
 * "tokenVersion": 4,
 * "ban": 0,
 * "baoyueVersion": 1,
 * "donateVersion": 0,
 * "vipType": 0,
 * "anonimousUser": false,
 * "paidFee": false
 * },
 * "profile": {
 * "userId": 123170560,
 * "userType": 0,
 * "nickname": "张张________",
 * "avatarImgId": 1364493969406099,
 * "avatarUrl": "http://p2.music.126.net/-hK85ZJCV5-jM5FDbLHFMg==/1364493969406099.jpg",
 * "backgroundImgId": 109951163114350380,
 * "backgroundUrl": "http://p1.music.126.net/QsCL3mKXKxYmSv_LLmhqTg==/109951163114350390.jpg",
 * "signature": "null",
 * "createTime": 1452662068804,
 * "userName": "1_********913",
 * "accountType": 1,
 * "shortUserName": "********913",
 * "birthday": 631123200000,
 * "authority": 0,
 * "gender": 1,
 * "accountStatus": 0,
 * "province": 450000,
 * "city": 450100,
 * "authStatus": 0,
 * "description": null,
 * "detailDescription": null,
 * "defaultAvatar": false,
 * "expertTags": null,
 * "experts": null,
 * "djStatus": 0,
 * "locationStatus": 10,
 * "vipType": 0,
 * "followed": false,
 * "mutual": false,
 * "authenticated": false,
 * "lastLoginTime": 1606961513744,
 * "lastLoginIP": "223.81.147.15",
 * "remarkName": null,
 * "viptypeVersion": 1579625380623,
 * "authenticationTypes": 0,
 * "avatarDetail": null,
 * "anchor": false
 * }
 * }
 */
public class UserAccountBean {

    private int code;
    private Account account;
    private Profile profile;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }


    public static class Account {

        private long id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private boolean anonimousUser;
        private boolean paidFee;

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBan() {
            return ban;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getVipType() {
            return vipType;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }

        public boolean getAnonimousUser() {
            return anonimousUser;
        }

        public void setPaidFee(boolean paidFee) {
            this.paidFee = paidFee;
        }

        public boolean getPaidFee() {
            return paidFee;
        }

    }

    public static class Profile {

        private long userId;
        private int userType;
        private String nickname;
        private long avatarImgId;
        private String avatarUrl;
        private long backgroundImgId;
        private String backgroundUrl;
        private String signature;
        private long createTime;
        private String userName;
        private int accountType;
        private String shortUserName;
        private long birthday;
        private int authority;
        private int gender;
        private int accountStatus;
        private long province;
        private long city;
        private int authStatus;
        private String description;
        private String detailDescription;
        private boolean defaultAvatar;
        private String expertTags;
        private String experts;
        private int djStatus;
        private int locationStatus;
        private int vipType;
        private boolean followed;
        private boolean mutual;
        private boolean authenticated;
        private long lastLoginTime;
        private String lastLoginIP;
        private String remarkName;
        private long viptypeVersion;
        private int authenticationTypes;
        private String avatarDetail;
        private boolean anchor;

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getUserType() {
            return userType;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getSignature() {
            return signature;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setAccountType(int accountType) {
            this.accountType = accountType;
        }

        public int getAccountType() {
            return accountType;
        }

        public void setShortUserName(String shortUserName) {
            this.shortUserName = shortUserName;
        }

        public String getShortUserName() {
            return shortUserName;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public int getAuthority() {
            return authority;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getGender() {
            return gender;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setProvince(long province) {
            this.province = province;
        }

        public long getProvince() {
            return province;
        }

        public void setCity(long city) {
            this.city = city;
        }

        public long getCity() {
            return city;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public boolean getDefaultAvatar() {
            return defaultAvatar;
        }

        public void setExpertTags(String expertTags) {
            this.expertTags = expertTags;
        }

        public String getExpertTags() {
            return expertTags;
        }

        public void setExperts(String experts) {
            this.experts = experts;
        }

        public String getExperts() {
            return experts;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setLocationStatus(int locationStatus) {
            this.locationStatus = locationStatus;
        }

        public int getLocationStatus() {
            return locationStatus;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getVipType() {
            return vipType;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public boolean getFollowed() {
            return followed;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public boolean getMutual() {
            return mutual;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public boolean getAuthenticated() {
            return authenticated;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginIP(String lastLoginIP) {
            this.lastLoginIP = lastLoginIP;
        }

        public String getLastLoginIP() {
            return lastLoginIP;
        }

        public void setRemarkName(String remarkName) {
            this.remarkName = remarkName;
        }

        public String getRemarkName() {
            return remarkName;
        }

        public void setViptypeVersion(long viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public long getViptypeVersion() {
            return viptypeVersion;
        }

        public void setAuthenticationTypes(int authenticationTypes) {
            this.authenticationTypes = authenticationTypes;
        }

        public int getAuthenticationTypes() {
            return authenticationTypes;
        }

        public void setAvatarDetail(String avatarDetail) {
            this.avatarDetail = avatarDetail;
        }

        public String getAvatarDetail() {
            return avatarDetail;
        }

        public void setAnchor(boolean anchor) {
            this.anchor = anchor;
        }

        public boolean getAnchor() {
            return anchor;
        }

    }
}
