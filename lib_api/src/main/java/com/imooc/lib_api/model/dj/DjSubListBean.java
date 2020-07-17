package com.imooc.lib_api.model.dj;

import java.util.List;

public class DjSubListBean {

    private int count;
    private List<DjRadios> djRadios;
    private long time;
    private boolean hasMore;
    private int code;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setDjRadios(List<DjRadios> djRadios) {
        this.djRadios = djRadios;
    }

    public List<DjRadios> getDjRadios() {
        return djRadios;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


    static public class DjRadios {

        private Dj dj;
        private String category;
        private boolean buyed;
        private int price;
        private int originalPrice;
        private String discountPrice;
        private int purchaseCount;
        private String lastProgramName;
        private String videos;
        private boolean finished;
        private boolean underShelf;
        private String liveInfo;
        private int programCount;
        private int radioFeeType;
        private int categoryId;
        private long createTime;
        private long picId;
        private long subCount;
        private long lastProgramCreateTime;
        private long lastProgramId;
        private int feeScope;
        private String picUrl;
        private String desc;
        private String name;
        private long id;
        private String rcmdtext;
        private int newProgramCount;
        private int rank;
        private int lastRank;
        private String score;

        public boolean isBuyed() {
            return buyed;
        }

        public boolean isFinished() {
            return finished;
        }

        public boolean isUnderShelf() {
            return underShelf;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getLastRank() {
            return lastRank;
        }

        public void setLastRank(int lastRank) {
            this.lastRank = lastRank;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setDj(Dj dj) {
            this.dj = dj;
        }

        public Dj getDj() {
            return dj;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategory() {
            return category;
        }

        public void setBuyed(boolean buyed) {
            this.buyed = buyed;
        }

        public boolean getBuyed() {
            return buyed;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setDiscountPrice(String discountPrice) {
            this.discountPrice = discountPrice;
        }

        public String getDiscountPrice() {
            return discountPrice;
        }

        public void setPurchaseCount(int purchaseCount) {
            this.purchaseCount = purchaseCount;
        }

        public int getPurchaseCount() {
            return purchaseCount;
        }

        public void setLastProgramName(String lastProgramName) {
            this.lastProgramName = lastProgramName;
        }

        public String getLastProgramName() {
            return lastProgramName;
        }

        public void setVideos(String videos) {
            this.videos = videos;
        }

        public String getVideos() {
            return videos;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public boolean getFinished() {
            return finished;
        }

        public void setUnderShelf(boolean underShelf) {
            this.underShelf = underShelf;
        }

        public boolean getUnderShelf() {
            return underShelf;
        }

        public void setLiveInfo(String liveInfo) {
            this.liveInfo = liveInfo;
        }

        public String getLiveInfo() {
            return liveInfo;
        }

        public void setProgramCount(int programCount) {
            this.programCount = programCount;
        }

        public int getProgramCount() {
            return programCount;
        }

        public void setRadioFeeType(int radioFeeType) {
            this.radioFeeType = radioFeeType;
        }

        public int getRadioFeeType() {
            return radioFeeType;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public long getPicId() {
            return picId;
        }

        public void setSubCount(long subCount) {
            this.subCount = subCount;
        }

        public long getSubCount() {
            return subCount;
        }

        public void setLastProgramCreateTime(long lastProgramCreateTime) {
            this.lastProgramCreateTime = lastProgramCreateTime;
        }

        public long getLastProgramCreateTime() {
            return lastProgramCreateTime;
        }

        public void setLastProgramId(long lastProgramId) {
            this.lastProgramId = lastProgramId;
        }

        public long getLastProgramId() {
            return lastProgramId;
        }

        public void setFeeScope(int feeScope) {
            this.feeScope = feeScope;
        }

        public int getFeeScope() {
            return feeScope;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setRcmdtext(String rcmdtext) {
            this.rcmdtext = rcmdtext;
        }

        public String getRcmdtext() {
            return rcmdtext;
        }

        public void setNewProgramCount(int newProgramCount) {
            this.newProgramCount = newProgramCount;
        }

        public int getNewProgramCount() {
            return newProgramCount;
        }

    }

    static public class Dj {

        private boolean defaultAvatar;
        private long province;
        private int authStatus;
        private boolean followed;
        private String avatarUrl;
        private int accountStatus;
        private int gender;
        private long city;
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
        private String expertTags;
        //{"1":"音乐原创视频达人"}
        private Object experts;
        private int djStatus;
        private int vipType;
        private String remarkName;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String avatarImgId_str;

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public boolean getDefaultAvatar() {
            return defaultAvatar;
        }

        public void setProvince(long province) {
            this.province = province;
        }

        public long getProvince() {
            return province;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public boolean getFollowed() {
            return followed;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getGender() {
            return gender;
        }

        public void setCity(long city) {
            this.city = city;
        }

        public long getCity() {
            return city;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getBirthday() {
            return birthday;
        }

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

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getSignature() {
            return signature;
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

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getAvatarImgId() {
            return avatarImgId;
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

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public int getAuthority() {
            return authority;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public boolean getMutual() {
            return mutual;
        }

        public void setExpertTags(String expertTags) {
            this.expertTags = expertTags;
        }

        public String getExpertTags() {
            return expertTags;
        }

        public void setExperts(Object experts) {
            this.experts = experts;
        }

        public Object getExperts() {
            return experts;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getVipType() {
            return vipType;
        }

        public void setRemarkName(String remarkName) {
            this.remarkName = remarkName;
        }

        public String getRemarkName() {
            return remarkName;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

    }

}
