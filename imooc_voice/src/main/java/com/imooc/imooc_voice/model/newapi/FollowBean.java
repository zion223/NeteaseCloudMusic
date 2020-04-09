package com.imooc.imooc_voice.model.newapi;



public class FollowBean {

	private String py;
	private User user;
	private String followTimeContent;
	private String followContent;
	private int code;
	public void setPy(String py) {
		this.py = py;
	}
	public String getPy() {
		return py;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	public void setFollowTimeContent(String followTimeContent) {
		this.followTimeContent = followTimeContent;
	}
	public String getFollowTimeContent() {
		return followTimeContent;
	}

	public void setFollowContent(String followContent) {
		this.followContent = followContent;
	}
	public String getFollowContent() {
		return followContent;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}

	public class User {

		private String description;
		private boolean followed;
		private String backgroundUrl;
		private boolean mutual;
		private int vipType;
		private long avatarImgId;
		private String avatarUrl;
		private int authStatus;
		private int userType;
		private int gender;
		private String expertTags;
		private String experts;
		private String nickname;
		private String remarkName;
		private long birthday;
		private long province;
		private long backgroundImgId;
		private int accountStatus;
		private long city;
		private String detailDescription;
		private boolean defaultAvatar;
		private int djStatus;
		private long userId;
		private String avatarImgIdStr;
		private String backgroundImgIdStr;
		private String signature;
		private int authority;
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDescription() {
			return description;
		}

		public void setFollowed(boolean followed) {
			this.followed = followed;
		}
		public boolean getFollowed() {
			return followed;
		}

		public void setBackgroundUrl(String backgroundUrl) {
			this.backgroundUrl = backgroundUrl;
		}
		public String getBackgroundUrl() {
			return backgroundUrl;
		}

		public void setMutual(boolean mutual) {
			this.mutual = mutual;
		}
		public boolean getMutual() {
			return mutual;
		}

		public void setVipType(int vipType) {
			this.vipType = vipType;
		}
		public int getVipType() {
			return vipType;
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

		public void setAuthStatus(int authStatus) {
			this.authStatus = authStatus;
		}
		public int getAuthStatus() {
			return authStatus;
		}

		public void setUserType(int userType) {
			this.userType = userType;
		}
		public int getUserType() {
			return userType;
		}

		public void setGender(int gender) {
			this.gender = gender;
		}
		public int getGender() {
			return gender;
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

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getNickname() {
			return nickname;
		}

		public void setRemarkName(String remarkName) {
			this.remarkName = remarkName;
		}
		public String getRemarkName() {
			return remarkName;
		}

		public void setBirthday(long birthday) {
			this.birthday = birthday;
		}
		public long getBirthday() {
			return birthday;
		}

		public void setProvince(long province) {
			this.province = province;
		}
		public long getProvince() {
			return province;
		}

		public void setBackgroundImgId(long backgroundImgId) {
			this.backgroundImgId = backgroundImgId;
		}
		public long getBackgroundImgId() {
			return backgroundImgId;
		}

		public void setAccountStatus(int accountStatus) {
			this.accountStatus = accountStatus;
		}
		public int getAccountStatus() {
			return accountStatus;
		}

		public void setCity(long city) {
			this.city = city;
		}
		public long getCity() {
			return city;
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

		public void setDjStatus(int djStatus) {
			this.djStatus = djStatus;
		}
		public int getDjStatus() {
			return djStatus;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}
		public long getUserId() {
			return userId;
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

		public void setSignature(String signature) {
			this.signature = signature;
		}
		public String getSignature() {
			return signature;
		}

		public void setAuthority(int authority) {
			this.authority = authority;
		}
		public int getAuthority() {
			return authority;
		}

	}

}
