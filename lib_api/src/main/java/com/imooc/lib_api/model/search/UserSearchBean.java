package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 通过api返回的搜索用户的bean
 */
public class UserSearchBean {

    /**
     * result : {"userprofiles":[{"defaultAvatar":false,"province":310000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/MlJ9Pnz7iFi7n8Dqw4aezg==/3308430489754999.jpg","accountStatus":0,"gender":1,"city":310108,"birthday":1374508800000,"userId":3701993,"userType":0,"nickname":"___JoJo","signature":"uoye voli","description":"","detailDescription":"","avatarImgId":3308430489754999,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"3308430489754999","backgroundImgIdStr":"109951162868126486","alg":"alg_user_basic","avatarImgId_str":"109951163417777007"},{"defaultAvatar":false,"province":520000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/nqWDvxz9U7snuRh7Zqm11A==/109951163417777007.jpg","accountStatus":0,"gender":1,"city":520100,"birthday":945446400000,"userId":131050600,"userType":0,"nickname":"jojo-_-_-_","signature":"","description":"","detailDescription":"","avatarImgId":109951163417777010,"backgroundImgId":109951163417817860,"backgroundUrl":"http://p1.music.126.net/mgm9dWGhMT3iZUBZRy7LlQ==/109951163417817855.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163417777007","backgroundImgIdStr":"109951163417817855","avatarImgId_str":"109951163417777007","alg":"alg_user_basic"}],"userprofileCount":300}
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
         * userprofiles : [{"defaultAvatar":false,"province":310000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/MlJ9Pnz7iFi7n8Dqw4aezg==/3308430489754999.jpg","accountStatus":0,"gender":1,"city":310108,"birthday":1374508800000,"userId":3701993,"userType":0,"nickname":"___JoJo","signature":"uoye voli","description":"","detailDescription":"","avatarImgId":3308430489754999,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"3308430489754999","backgroundImgIdStr":"109951162868126486","alg":"alg_user_basic"},{"defaultAvatar":false,"province":520000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/nqWDvxz9U7snuRh7Zqm11A==/109951163417777007.jpg","accountStatus":0,"gender":1,"city":520100,"birthday":945446400000,"userId":131050600,"userType":0,"nickname":"jojo-_-_-_","signature":"","description":"","detailDescription":"","avatarImgId":109951163417777010,"backgroundImgId":109951163417817860,"backgroundUrl":"http://p1.music.126.net/mgm9dWGhMT3iZUBZRy7LlQ==/109951163417817855.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163417777007","backgroundImgIdStr":"109951163417817855","avatarImgId_str":"109951163417777007","alg":"alg_user_basic"}]
         * userprofileCount : 300
         */

        private int userprofileCount;
        private List<UserprofilesBean> userprofiles;

        public int getUserprofileCount() {
            return userprofileCount;
        }

        public void setUserprofileCount(int userprofileCount) {
            this.userprofileCount = userprofileCount;
        }

        public List<UserprofilesBean> getUserprofiles() {
            return userprofiles;
        }

        public void setUserprofiles(List<UserprofilesBean> userprofiles) {
            this.userprofiles = userprofiles;
        }

        public static class UserprofilesBean {
            /**
             * defaultAvatar : false
             * province : 310000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/MlJ9Pnz7iFi7n8Dqw4aezg==/3308430489754999.jpg
             * accountStatus : 0
             * gender : 1
             * city : 310108
             * birthday : 1374508800000
             * userId : 3701993
             * userType : 0
             * nickname : ___JoJo
             * signature : uoye voli
             * description :
             * detailDescription :
             * avatarImgId : 3308430489754999
             * backgroundImgId : 109951162868126480
             * backgroundUrl : http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 3308430489754999
             * backgroundImgIdStr : 109951162868126486
             * alg : alg_user_basic
             * avatarImgId_str : 109951163417777007
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private long userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private String alg;
            private String avatarImgId_str;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public String getUserId() {
                return String.valueOf(userId);
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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
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

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
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

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
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

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }
    }
}
