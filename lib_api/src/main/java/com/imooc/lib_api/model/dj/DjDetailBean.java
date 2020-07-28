package com.imooc.lib_api.model.dj;

import java.io.Serializable;
import java.util.List;

public class DjDetailBean implements Serializable {

    /**
     * djRadio : {"id":336355127,"dj":{"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg","accountStatus":0,"gender":1,"city":1002400,"birthday":-2209017600000,"userId":289680033,"userType":0,"nickname":"代码时间","signature":"代码时间是一个面向程序员的中文播客节目, 致力于通过语音的方式传播程序员的正能量. 节目的网站是: http://codetimecn.com | 新浪微博 ID: 代码时间 | 微信公众号 ID: 代码时间","description":"","detailDescription":"","avatarImgId":3442570909917251,"backgroundImgId":2002210674180199,"backgroundUrl":"http://p1.music.126.net/VTW4vsN08vwL3uSQqPyHqg==/2002210674180199.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"avatarImgIdStr":"3442570909917251","backgroundImgIdStr":"2002210674180199","rewardCount":0,"canReward":false},"name":"代码时间","picUrl":"https://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg","desc":"","subCount":15111,"programCount":36,"createTime":1465726085482,"categoryId":453052,"category":"科技科学","radioFeeType":0,"feeScope":0,"buyed":false,"videos":null,"finished":false,"underShelf":false,"purchaseCount":0,"price":0,"originalPrice":0,"discountPrice":null,"lastProgramCreateTime":1515962230660,"lastProgramName":null,"lastProgramId":1367665101,"picId":3442570909917251,"rcmdText":"程序员的中文播客节目","hightQuality":false,"whiteList":false,"liveInfo":null,"composeVideo":false,"shareCount":131,"subed":true,"likedCount":0,"commentDatas":[{"userProfile":{"defaultAvatar":false,"province":410000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg","accountStatus":0,"gender":1,"city":410100,"birthday":935252436559,"userId":303576830,"userType":0,"nickname":"Dear-Canon","signature":"alone.","description":"","detailDescription":"","avatarImgId":109951164105614420,"backgroundImgId":109951164216453310,"backgroundUrl":"http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164105614418","backgroundImgIdStr":"109951164216453318","avatarImgId_str":"109951164105614418"},"content":"声音太小，程序员都近视，听不清。","programName":"Visual Studio Code - 吕鹏","programId":1367665101,"commentId":1256331303}],"commentCount":0}
     * picId : 3442570909917251
     * code : 200
     */

    private DjRadioBean djRadio;
    private String picId;
    private int code;

    public DjRadioBean getDjRadio() {
        return djRadio;
    }

    public void setDjRadio(DjRadioBean djRadio) {
        this.djRadio = djRadio;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DjRadioBean implements Serializable {
        /**
         * id : 336355127
         * dj : {"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg","accountStatus":0,"gender":1,"city":1002400,"birthday":-2209017600000,"userId":289680033,"userType":0,"nickname":"代码时间","signature":"代码时间是一个面向程序员的中文播客节目, 致力于通过语音的方式传播程序员的正能量. 节目的网站是: http://codetimecn.com | 新浪微博 ID: 代码时间 | 微信公众号 ID: 代码时间","description":"","detailDescription":"","avatarImgId":3442570909917251,"backgroundImgId":2002210674180199,"backgroundUrl":"http://p1.music.126.net/VTW4vsN08vwL3uSQqPyHqg==/2002210674180199.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"avatarImgIdStr":"3442570909917251","backgroundImgIdStr":"2002210674180199","rewardCount":0,"canReward":false}
         * name : 代码时间
         * picUrl : https://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg
         * desc :
         * subCount : 15111
         * programCount : 36
         * createTime : 1465726085482
         * categoryId : 453052
         * category : 科技科学
         * radioFeeType : 0
         * feeScope : 0
         * buyed : false
         * videos : null
         * finished : false
         * underShelf : false
         * purchaseCount : 0
         * price : 0
         * originalPrice : 0
         * discountPrice : null
         * lastProgramCreateTime : 1515962230660
         * lastProgramName : null
         * lastProgramId : 1367665101
         * picId : 3442570909917251
         * rcmdText : 程序员的中文播客节目
         * hightQuality : false
         * whiteList : false
         * liveInfo : null
         * composeVideo : false
         * shareCount : 131
         * subed : true
         * likedCount : 0
         * commentDatas : [{"userProfile":{"defaultAvatar":false,"province":410000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg","accountStatus":0,"gender":1,"city":410100,"birthday":935252436559,"userId":303576830,"userType":0,"nickname":"Dear-Canon","signature":"alone.","description":"","detailDescription":"","avatarImgId":109951164105614420,"backgroundImgId":109951164216453310,"backgroundUrl":"http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164105614418","backgroundImgIdStr":"109951164216453318","avatarImgId_str":"109951164105614418"},"content":"声音太小，程序员都近视，听不清。","programName":"Visual Studio Code - 吕鹏","programId":1367665101,"commentId":1256331303}]
         * commentCount : 0
         */

        private long id;
        private DjBean dj;
        private String name;
        private String picUrl;
        private String desc;
        private int subCount;
        private int programCount;
        private long createTime;
        private int categoryId;
        private String category;
        private int radioFeeType;
        private int feeScope;
        private boolean buyed;
        private Object videos;
        private boolean finished;
        private boolean underShelf;
        private int purchaseCount;
        private int price;
        private int originalPrice;
        private Object discountPrice;
        private long lastProgramCreateTime;
        private Object lastProgramName;
        private int lastProgramId;
        private long picId;
        private String rcmdText;
        private boolean hightQuality;
        private boolean whiteList;
        private Object liveInfo;
        private boolean composeVideo;
        private int shareCount;
        private boolean subed;
        private int likedCount;
        private int commentCount;
        //热门评论
        private List<CommentDatasBean> commentDatas;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public DjBean getDj() {
            return dj;
        }

        public void setDj(DjBean dj) {
            this.dj = dj;
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

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getSubCount() {
            return subCount;
        }

        public void setSubCount(int subCount) {
            this.subCount = subCount;
        }

        public int getProgramCount() {
            return programCount;
        }

        public void setProgramCount(int programCount) {
            this.programCount = programCount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getRadioFeeType() {
            return radioFeeType;
        }

        public void setRadioFeeType(int radioFeeType) {
            this.radioFeeType = radioFeeType;
        }

        public int getFeeScope() {
            return feeScope;
        }

        public void setFeeScope(int feeScope) {
            this.feeScope = feeScope;
        }

        public boolean isBuyed() {
            return buyed;
        }

        public void setBuyed(boolean buyed) {
            this.buyed = buyed;
        }

        public Object getVideos() {
            return videos;
        }

        public void setVideos(Object videos) {
            this.videos = videos;
        }

        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public boolean isUnderShelf() {
            return underShelf;
        }

        public void setUnderShelf(boolean underShelf) {
            this.underShelf = underShelf;
        }

        public int getPurchaseCount() {
            return purchaseCount;
        }

        public void setPurchaseCount(int purchaseCount) {
            this.purchaseCount = purchaseCount;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public Object getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(Object discountPrice) {
            this.discountPrice = discountPrice;
        }

        public long getLastProgramCreateTime() {
            return lastProgramCreateTime;
        }

        public void setLastProgramCreateTime(long lastProgramCreateTime) {
            this.lastProgramCreateTime = lastProgramCreateTime;
        }

        public Object getLastProgramName() {
            return lastProgramName;
        }

        public void setLastProgramName(Object lastProgramName) {
            this.lastProgramName = lastProgramName;
        }

        public int getLastProgramId() {
            return lastProgramId;
        }

        public void setLastProgramId(int lastProgramId) {
            this.lastProgramId = lastProgramId;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public String getRcmdText() {
            return rcmdText;
        }

        public void setRcmdText(String rcmdText) {
            this.rcmdText = rcmdText;
        }

        public boolean isHightQuality() {
            return hightQuality;
        }

        public void setHightQuality(boolean hightQuality) {
            this.hightQuality = hightQuality;
        }

        public boolean isWhiteList() {
            return whiteList;
        }

        public void setWhiteList(boolean whiteList) {
            this.whiteList = whiteList;
        }

        public Object getLiveInfo() {
            return liveInfo;
        }

        public void setLiveInfo(Object liveInfo) {
            this.liveInfo = liveInfo;
        }

        public boolean isComposeVideo() {
            return composeVideo;
        }

        public void setComposeVideo(boolean composeVideo) {
            this.composeVideo = composeVideo;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public boolean isSubed() {
            return subed;
        }

        public void setSubed(boolean subed) {
            this.subed = subed;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<CommentDatasBean> getCommentDatas() {
            return commentDatas;
        }

        public void setCommentDatas(List<CommentDatasBean> commentDatas) {
            this.commentDatas = commentDatas;
        }

        public static class DjBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg
             * accountStatus : 0
             * gender : 1
             * city : 1002400
             * birthday : -2209017600000
             * userId : 289680033
             * userType : 0
             * nickname : 代码时间
             * signature : 代码时间是一个面向程序员的中文播客节目, 致力于通过语音的方式传播程序员的正能量. 节目的网站是: http://codetimecn.com | 新浪微博 ID: 代码时间 | 微信公众号 ID: 代码时间
             * description :
             * detailDescription :
             * avatarImgId : 3442570909917251
             * backgroundImgId : 2002210674180199
             * backgroundUrl : http://p1.music.126.net/VTW4vsN08vwL3uSQqPyHqg==/2002210674180199.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 10
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 3442570909917251
             * backgroundImgIdStr : 2002210674180199
             * rewardCount : 0
             * canReward : false
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
            private int userId;
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
            private int rewardCount;
            private boolean canReward;

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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
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

            public int getRewardCount() {
                return rewardCount;
            }

            public void setRewardCount(int rewardCount) {
                this.rewardCount = rewardCount;
            }

            public boolean isCanReward() {
                return canReward;
            }

            public void setCanReward(boolean canReward) {
                this.canReward = canReward;
            }
        }

        public static class CommentDatasBean implements Serializable {
            /**
             * userProfile : {"defaultAvatar":false,"province":410000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg","accountStatus":0,"gender":1,"city":410100,"birthday":935252436559,"userId":303576830,"userType":0,"nickname":"Dear-Canon","signature":"alone.","description":"","detailDescription":"","avatarImgId":109951164105614420,"backgroundImgId":109951164216453310,"backgroundUrl":"http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164105614418","backgroundImgIdStr":"109951164216453318","avatarImgId_str":"109951164105614418"}
             * content : 声音太小，程序员都近视，听不清。
             * programName : Visual Studio Code - 吕鹏
             * programId : 1367665101
             * commentId : 1256331303
             */

            private UserProfileBean userProfile;
            private String content;
            private String programName;
            private long programId;
            private long commentId;

            public UserProfileBean getUserProfile() {
                return userProfile;
            }

            public void setUserProfile(UserProfileBean userProfile) {
                this.userProfile = userProfile;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getProgramName() {
                return programName;
            }

            public void setProgramName(String programName) {
                this.programName = programName;
            }

            public long getProgramId() {
                return programId;
            }

            public void setProgramId(long programId) {
                this.programId = programId;
            }

            public long getCommentId() {
                return commentId;
            }

            public void setCommentId(long commentId) {
                this.commentId = commentId;
            }

            public static class UserProfileBean {
                /**
                 * defaultAvatar : false
                 * province : 410000
                 * authStatus : 0
                 * followed : false
                 * avatarUrl : http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg
                 * accountStatus : 0
                 * gender : 1
                 * city : 410100
                 * birthday : 935252436559
                 * userId : 303576830
                 * userType : 0
                 * nickname : Dear-Canon
                 * signature : alone.
                 * description :
                 * detailDescription :
                 * avatarImgId : 109951164105614420
                 * backgroundImgId : 109951164216453310
                 * backgroundUrl : http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg
                 * authority : 0
                 * mutual : false
                 * expertTags : null
                 * experts : null
                 * djStatus : 0
                 * vipType : 0
                 * remarkName : null
                 * avatarImgIdStr : 109951164105614418
                 * backgroundImgIdStr : 109951164216453318
                 * avatarImgId_str : 109951164105614418
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

                public String getAvatarImgId_str() {
                    return avatarImgId_str;
                }

                public void setAvatarImgId_str(String avatarImgId_str) {
                    this.avatarImgId_str = avatarImgId_str;
                }
            }
        }
    }
}
