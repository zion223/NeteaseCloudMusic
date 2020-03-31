package com.imooc.imooc_voice.model.newapi;


import java.util.List;

public class TopListDetailBean {

	private int code;
	private List<ListBean> list;
	private ArtistToplist artistToplist;
	private RewardToplist rewardToplist;

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setList(List<ListBean> list) {
		this.list = list;
	}

	public List<ListBean> getList() {
		return list;
	}

	public class ListBean {

		private List<String> subscribers;
		private String subscribed;
		private String creator;
		private String artists;
		private List<Tracks> tracks;
		private String updateFrequency;
		private int backgroundCoverId;
		private String backgroundCoverUrl;
		private int titleImage;
		private String titleImageUrl;
		private String englishTitle;
		private boolean opRecommend;
		private String recommendInfo;
		private int adType;
		private long trackNumberUpdateTime;
		private long createTime;
		private boolean highQuality;
		private int userId;
		private long updateTime;
		private long coverImgId;
		private boolean newImported;
		private boolean anonimous;
		private int specialType;
		private int totalDuration;
		private String coverImgUrl;
		private int trackCount;
		private String commentThreadId;
		private int privacy;
		private long trackUpdateTime;
		private long playCount;
		private long subscribedCount;
		private int cloudTrackCount;
		private boolean ordered;
		private List<String> tags;
		private String description;
		private int status;
		private String name;
		private long id;
		private String coverImgId_str;
		private String ToplistType;
		public void setSubscribers(List<String> subscribers) {
			this.subscribers = subscribers;
		}
		public List<String> getSubscribers() {
			return subscribers;
		}

		public void setSubscribed(String subscribed) {
			this.subscribed = subscribed;
		}
		public String getSubscribed() {
			return subscribed;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getCreator() {
			return creator;
		}

		public void setArtists(String artists) {
			this.artists = artists;
		}
		public String getArtists() {
			return artists;
		}

		public void setTracks(List<Tracks> tracks) {
			this.tracks = tracks;
		}
		public List<Tracks> getTracks() {
			return tracks;
		}

		public void setUpdateFrequency(String updateFrequency) {
			this.updateFrequency = updateFrequency;
		}
		public String getUpdateFrequency() {
			return updateFrequency;
		}

		public void setBackgroundCoverId(int backgroundCoverId) {
			this.backgroundCoverId = backgroundCoverId;
		}
		public int getBackgroundCoverId() {
			return backgroundCoverId;
		}

		public void setBackgroundCoverUrl(String backgroundCoverUrl) {
			this.backgroundCoverUrl = backgroundCoverUrl;
		}
		public String getBackgroundCoverUrl() {
			return backgroundCoverUrl;
		}

		public void setTitleImage(int titleImage) {
			this.titleImage = titleImage;
		}
		public int getTitleImage() {
			return titleImage;
		}

		public void setTitleImageUrl(String titleImageUrl) {
			this.titleImageUrl = titleImageUrl;
		}
		public String getTitleImageUrl() {
			return titleImageUrl;
		}

		public void setEnglishTitle(String englishTitle) {
			this.englishTitle = englishTitle;
		}
		public String getEnglishTitle() {
			return englishTitle;
		}

		public void setOpRecommend(boolean opRecommend) {
			this.opRecommend = opRecommend;
		}
		public boolean getOpRecommend() {
			return opRecommend;
		}

		public void setRecommendInfo(String recommendInfo) {
			this.recommendInfo = recommendInfo;
		}
		public String getRecommendInfo() {
			return recommendInfo;
		}

		public void setAdType(int adType) {
			this.adType = adType;
		}
		public int getAdType() {
			return adType;
		}

		public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
			this.trackNumberUpdateTime = trackNumberUpdateTime;
		}
		public long getTrackNumberUpdateTime() {
			return trackNumberUpdateTime;
		}

		public void setCreateTime(long createTime) {
			this.createTime = createTime;
		}
		public long getCreateTime() {
			return createTime;
		}

		public void setHighQuality(boolean highQuality) {
			this.highQuality = highQuality;
		}
		public boolean getHighQuality() {
			return highQuality;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getUserId() {
			return userId;
		}

		public void setUpdateTime(long updateTime) {
			this.updateTime = updateTime;
		}
		public long getUpdateTime() {
			return updateTime;
		}

		public void setCoverImgId(long coverImgId) {
			this.coverImgId = coverImgId;
		}
		public long getCoverImgId() {
			return coverImgId;
		}

		public void setNewImported(boolean newImported) {
			this.newImported = newImported;
		}
		public boolean getNewImported() {
			return newImported;
		}

		public void setAnonimous(boolean anonimous) {
			this.anonimous = anonimous;
		}
		public boolean getAnonimous() {
			return anonimous;
		}

		public void setSpecialType(int specialType) {
			this.specialType = specialType;
		}
		public int getSpecialType() {
			return specialType;
		}

		public void setTotalDuration(int totalDuration) {
			this.totalDuration = totalDuration;
		}
		public int getTotalDuration() {
			return totalDuration;
		}

		public void setCoverImgUrl(String coverImgUrl) {
			this.coverImgUrl = coverImgUrl;
		}
		public String getCoverImgUrl() {
			return coverImgUrl;
		}

		public void setTrackCount(int trackCount) {
			this.trackCount = trackCount;
		}
		public int getTrackCount() {
			return trackCount;
		}

		public void setCommentThreadId(String commentThreadId) {
			this.commentThreadId = commentThreadId;
		}
		public String getCommentThreadId() {
			return commentThreadId;
		}

		public void setPrivacy(int privacy) {
			this.privacy = privacy;
		}
		public int getPrivacy() {
			return privacy;
		}

		public void setTrackUpdateTime(long trackUpdateTime) {
			this.trackUpdateTime = trackUpdateTime;
		}
		public long getTrackUpdateTime() {
			return trackUpdateTime;
		}

		public void setPlayCount(long playCount) {
			this.playCount = playCount;
		}
		public long getPlayCount() {
			return playCount;
		}

		public void setSubscribedCount(long subscribedCount) {
			this.subscribedCount = subscribedCount;
		}
		public long getSubscribedCount() {
			return subscribedCount;
		}

		public void setCloudTrackCount(int cloudTrackCount) {
			this.cloudTrackCount = cloudTrackCount;
		}
		public int getCloudTrackCount() {
			return cloudTrackCount;
		}

		public void setOrdered(boolean ordered) {
			this.ordered = ordered;
		}
		public boolean getOrdered() {
			return ordered;
		}

		public void setTags(List<String> tags) {
			this.tags = tags;
		}
		public List<String> getTags() {
			return tags;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		public String getDescription() {
			return description;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		public int getStatus() {
			return status;
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

		public void setCoverImgId_str(String coverImgId_str) {
			this.coverImgId_str = coverImgId_str;
		}
		public String getCoverImgId_str() {
			return coverImgId_str;
		}

		public void setToplistType(String ToplistType) {
			this.ToplistType = ToplistType;
		}
		public String getToplistType() {
			return ToplistType;
		}

	}
	public void setArtistToplist(ArtistToplist artistToplist) {
		this.artistToplist = artistToplist;
	}

	public ArtistToplist getArtistToplist() {
		return artistToplist;
	}

	public void setRewardToplist(RewardToplist rewardToplist) {
		this.rewardToplist = rewardToplist;
	}

	public RewardToplist getRewardToplist() {
		return rewardToplist;
	}

	public class Tracks {

		private String first;
		private String second;

		public void setFirst(String first) {
			this.first = first;
		}

		public String getFirst() {
			return first;
		}

		public void setSecond(String second) {
			this.second = second;
		}

		public String getSecond() {
			return second;
		}

	}

	public class Artists {

		private String first;
		private String second;
		private long third;

		public void setFirst(String first) {
			this.first = first;
		}

		public String getFirst() {
			return first;
		}

		public void setSecond(String second) {
			this.second = second;
		}

		public String getSecond() {
			return second;
		}

		public void setThird(long third) {
			this.third = third;
		}

		public long getThird() {
			return third;
		}

	}


	public class ArtistToplist {

		private String coverUrl;
		private List<Artists> artists;
		private String name;
		private String upateFrequency;
		private int position;
		private String updateFrequency;
		public void setCoverUrl(String coverUrl) {
			this.coverUrl = coverUrl;
		}
		public String getCoverUrl() {
			return coverUrl;
		}

		public void setArtists(List<Artists> artists) {
			this.artists = artists;
		}
		public List<Artists> getArtists() {
			return artists;
		}

		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}

		public void setUpateFrequency(String upateFrequency) {
			this.upateFrequency = upateFrequency;
		}
		public String getUpateFrequency() {
			return upateFrequency;
		}

		public void setPosition(int position) {
			this.position = position;
		}
		public int getPosition() {
			return position;
		}

		public void setUpdateFrequency(String updateFrequency) {
			this.updateFrequency = updateFrequency;
		}
		public String getUpdateFrequency() {
			return updateFrequency;
		}

	}

	public class Artist {

		private String name;
		private int id;
		private boolean followed;
		private String picId;
		private String img1v1Id;
		private String briefDesc;
		private String picUrl;
		private String img1v1Url;
		private int albumSize;
		private List<String> alias;
		private String trans;
		private int musicSize;
		private int topicPerson;

		public boolean isFollowed() {
			return followed;
		}

		public void setFollowed(boolean followed) {
			this.followed = followed;
		}

		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}

		public void setId(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}

		public void setPicId(String picId) {
			this.picId = picId;
		}
		public String getPicId() {
			return picId;
		}

		public void setImg1v1Id(String img1v1Id) {
			this.img1v1Id = img1v1Id;
		}
		public String getImg1v1Id() {
			return img1v1Id;
		}

		public void setBriefDesc(String briefDesc) {
			this.briefDesc = briefDesc;
		}
		public String getBriefDesc() {
			return briefDesc;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}
		public String getPicUrl() {
			return picUrl;
		}

		public void setImg1v1Url(String img1v1Url) {
			this.img1v1Url = img1v1Url;
		}
		public String getImg1v1Url() {
			return img1v1Url;
		}

		public void setAlbumSize(int albumSize) {
			this.albumSize = albumSize;
		}
		public int getAlbumSize() {
			return albumSize;
		}

		public void setAlias(List<String> alias) {
			this.alias = alias;
		}
		public List<String> getAlias() {
			return alias;
		}

		public void setTrans(String trans) {
			this.trans = trans;
		}
		public String getTrans() {
			return trans;
		}

		public void setMusicSize(int musicSize) {
			this.musicSize = musicSize;
		}
		public int getMusicSize() {
			return musicSize;
		}

		public void setTopicPerson(int topicPerson) {
			this.topicPerson = topicPerson;
		}
		public int getTopicPerson() {
			return topicPerson;
		}

	}

	public class Album {

		private String name;
		private long id;
		private String type;
		private int size;
		private String picId;
		private String blurPicUrl;
		private int companyId;
		private long pic;
		private String picUrl;
		private long publishTime;
		private String description;
		private String tags;
		private String company;
		private String briefDesc;
		private Artist artist;
		private List<String> songs;
		private List<String> alias;
		private int status;
		private int copyrightId;
		private String commentThreadId;
		private List<Artists> artists;
		private String subType;
		private String transName;
		private int mark;
		private String picId_str;
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

		public void setType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}

		public void setSize(int size) {
			this.size = size;
		}
		public int getSize() {
			return size;
		}

		public void setPicId(String picId) {
			this.picId = picId;
		}
		public String getPicId() {
			return picId;
		}

		public void setBlurPicUrl(String blurPicUrl) {
			this.blurPicUrl = blurPicUrl;
		}
		public String getBlurPicUrl() {
			return blurPicUrl;
		}

		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		public int getCompanyId() {
			return companyId;
		}

		public void setPic(long pic) {
			this.pic = pic;
		}
		public long getPic() {
			return pic;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}
		public String getPicUrl() {
			return picUrl;
		}

		public void setPublishTime(long publishTime) {
			this.publishTime = publishTime;
		}
		public long getPublishTime() {
			return publishTime;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		public String getDescription() {
			return description;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}
		public String getTags() {
			return tags;
		}

		public void setCompany(String company) {
			this.company = company;
		}
		public String getCompany() {
			return company;
		}

		public void setBriefDesc(String briefDesc) {
			this.briefDesc = briefDesc;
		}
		public String getBriefDesc() {
			return briefDesc;
		}

		public void setArtist(Artist artist) {
			this.artist = artist;
		}
		public Artist getArtist() {
			return artist;
		}

		public void setSongs(List<String> songs) {
			this.songs = songs;
		}
		public List<String> getSongs() {
			return songs;
		}

		public void setAlias(List<String> alias) {
			this.alias = alias;
		}
		public List<String> getAlias() {
			return alias;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		public int getStatus() {
			return status;
		}

		public void setCopyrightId(int copyrightId) {
			this.copyrightId = copyrightId;
		}
		public int getCopyrightId() {
			return copyrightId;
		}

		public void setCommentThreadId(String commentThreadId) {
			this.commentThreadId = commentThreadId;
		}
		public String getCommentThreadId() {
			return commentThreadId;
		}

		public void setArtists(List<Artists> artists) {
			this.artists = artists;
		}
		public List<Artists> getArtists() {
			return artists;
		}

		public void setSubType(String subType) {
			this.subType = subType;
		}
		public String getSubType() {
			return subType;
		}

		public void setTransName(String transName) {
			this.transName = transName;
		}
		public String getTransName() {
			return transName;
		}

		public void setMark(int mark) {
			this.mark = mark;
		}
		public int getMark() {
			return mark;
		}

		public void setPicId_str(String picId_str) {
			this.picId_str = picId_str;
		}
		public String getPicId_str() {
			return picId_str;
		}

	}

	public class BMusic {

		private String name;
		private long id;
		private long size;
		private String extension;
		private int sr;
		private int dfsId;
		private long bitrate;
		private long playTime;
		private int volumeDelta;
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

		public void setSize(long size) {
			this.size = size;
		}
		public long getSize() {
			return size;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}
		public String getExtension() {
			return extension;
		}

		public void setSr(int sr) {
			this.sr = sr;
		}
		public int getSr() {
			return sr;
		}

		public void setDfsId(int dfsId) {
			this.dfsId = dfsId;
		}
		public int getDfsId() {
			return dfsId;
		}

		public void setBitrate(long bitrate) {
			this.bitrate = bitrate;
		}
		public long getBitrate() {
			return bitrate;
		}

		public void setPlayTime(long playTime) {
			this.playTime = playTime;
		}
		public long getPlayTime() {
			return playTime;
		}

		public void setVolumeDelta(int volumeDelta) {
			this.volumeDelta = volumeDelta;
		}
		public int getVolumeDelta() {
			return volumeDelta;
		}

	}

	public class Songs {

		private String name;
		private long id;
		private int position;
		private List<String> alias;
		private int status;
		private int fee;
		private int copyrightId;
		private String disc;
		private int no;
		private List<Artists> artists;
		private Album album;
		private boolean starred;
		private int popularity;
		private int score;
		private int starredNum;
		private long duration;
		private int playedNum;
		private int dayPlays;
		private int hearTime;
		private String ringtone;
		private String crbt;
		private String audition;
		private String copyFrom;
		private String commentThreadId;
		private String rtUrl;
		private int ftype;
		private List<String> rtUrls;
		private int copyright;
		private String transName;
		private String sign;
		private int mark;
		private int rtype;
		private String rurl;
		private int mvid;
		private String hMusic;
		private MMusic mMusic;
		private LMusic lMusic;
		private BMusic bMusic;
		private String mp3Url;
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

		public void setPosition(int position) {
			this.position = position;
		}
		public int getPosition() {
			return position;
		}

		public void setAlias(List<String> alias) {
			this.alias = alias;
		}
		public List<String> getAlias() {
			return alias;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		public int getStatus() {
			return status;
		}

		public void setFee(int fee) {
			this.fee = fee;
		}
		public int getFee() {
			return fee;
		}

		public void setCopyrightId(int copyrightId) {
			this.copyrightId = copyrightId;
		}
		public int getCopyrightId() {
			return copyrightId;
		}

		public void setDisc(String disc) {
			this.disc = disc;
		}
		public String getDisc() {
			return disc;
		}

		public void setNo(int no) {
			this.no = no;
		}
		public int getNo() {
			return no;
		}

		public void setArtists(List<Artists> artists) {
			this.artists = artists;
		}
		public List<Artists> getArtists() {
			return artists;
		}

		public void setAlbum(Album album) {
			this.album = album;
		}
		public Album getAlbum() {
			return album;
		}

		public void setStarred(boolean starred) {
			this.starred = starred;
		}
		public boolean getStarred() {
			return starred;
		}

		public void setPopularity(int popularity) {
			this.popularity = popularity;
		}
		public int getPopularity() {
			return popularity;
		}

		public void setScore(int score) {
			this.score = score;
		}
		public int getScore() {
			return score;
		}

		public void setStarredNum(int starredNum) {
			this.starredNum = starredNum;
		}
		public int getStarredNum() {
			return starredNum;
		}

		public void setDuration(long duration) {
			this.duration = duration;
		}
		public long getDuration() {
			return duration;
		}

		public void setPlayedNum(int playedNum) {
			this.playedNum = playedNum;
		}
		public int getPlayedNum() {
			return playedNum;
		}

		public void setDayPlays(int dayPlays) {
			this.dayPlays = dayPlays;
		}
		public int getDayPlays() {
			return dayPlays;
		}

		public void setHearTime(int hearTime) {
			this.hearTime = hearTime;
		}
		public int getHearTime() {
			return hearTime;
		}

		public void setRingtone(String ringtone) {
			this.ringtone = ringtone;
		}
		public String getRingtone() {
			return ringtone;
		}

		public void setCrbt(String crbt) {
			this.crbt = crbt;
		}
		public String getCrbt() {
			return crbt;
		}

		public void setAudition(String audition) {
			this.audition = audition;
		}
		public String getAudition() {
			return audition;
		}

		public void setCopyFrom(String copyFrom) {
			this.copyFrom = copyFrom;
		}
		public String getCopyFrom() {
			return copyFrom;
		}

		public void setCommentThreadId(String commentThreadId) {
			this.commentThreadId = commentThreadId;
		}
		public String getCommentThreadId() {
			return commentThreadId;
		}

		public void setRtUrl(String rtUrl) {
			this.rtUrl = rtUrl;
		}
		public String getRtUrl() {
			return rtUrl;
		}

		public void setFtype(int ftype) {
			this.ftype = ftype;
		}
		public int getFtype() {
			return ftype;
		}

		public void setRtUrls(List<String> rtUrls) {
			this.rtUrls = rtUrls;
		}
		public List<String> getRtUrls() {
			return rtUrls;
		}

		public void setCopyright(int copyright) {
			this.copyright = copyright;
		}
		public int getCopyright() {
			return copyright;
		}

		public void setTransName(String transName) {
			this.transName = transName;
		}
		public String getTransName() {
			return transName;
		}

		public void setSign(String sign) {
			this.sign = sign;
		}
		public String getSign() {
			return sign;
		}

		public void setMark(int mark) {
			this.mark = mark;
		}
		public int getMark() {
			return mark;
		}

		public void setRtype(int rtype) {
			this.rtype = rtype;
		}
		public int getRtype() {
			return rtype;
		}

		public void setRurl(String rurl) {
			this.rurl = rurl;
		}
		public String getRurl() {
			return rurl;
		}

		public void setMvid(int mvid) {
			this.mvid = mvid;
		}
		public int getMvid() {
			return mvid;
		}

		public void setHMusic(String hMusic) {
			this.hMusic = hMusic;
		}
		public String getHMusic() {
			return hMusic;
		}

		public void setMMusic(MMusic mMusic) {
			this.mMusic = mMusic;
		}
		public MMusic getMMusic() {
			return mMusic;
		}

		public void setLMusic(LMusic lMusic) {
			this.lMusic = lMusic;
		}
		public LMusic getLMusic() {
			return lMusic;
		}

		public void setBMusic(BMusic bMusic) {
			this.bMusic = bMusic;
		}
		public BMusic getBMusic() {
			return bMusic;
		}

		public void setMp3Url(String mp3Url) {
			this.mp3Url = mp3Url;
		}
		public String getMp3Url() {
			return mp3Url;
		}

	}

	public class RewardToplist {

		private String coverUrl;
		private List<Songs> songs;
		private String name;
		private int position;
		public void setCoverUrl(String coverUrl) {
			this.coverUrl = coverUrl;
		}
		public String getCoverUrl() {
			return coverUrl;
		}

		public void setSongs(List<Songs> songs) {
			this.songs = songs;
		}
		public List<Songs> getSongs() {
			return songs;
		}

		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}

		public void setPosition(int position) {
			this.position = position;
		}
		public int getPosition() {
			return position;
		}

	}

	public static class MMusic {

		private String name;
		private long id;
		private long size;
		private String extension;
		private int sr;
		private int dfsId;
		private long bitrate;
		private long playTime;
		private int volumeDelta;
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

		public void setSize(long size) {
			this.size = size;
		}
		public long getSize() {
			return size;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}
		public String getExtension() {
			return extension;
		}

		public void setSr(int sr) {
			this.sr = sr;
		}
		public int getSr() {
			return sr;
		}

		public void setDfsId(int dfsId) {
			this.dfsId = dfsId;
		}
		public int getDfsId() {
			return dfsId;
		}

		public void setBitrate(long bitrate) {
			this.bitrate = bitrate;
		}
		public long getBitrate() {
			return bitrate;
		}

		public void setPlayTime(long playTime) {
			this.playTime = playTime;
		}
		public long getPlayTime() {
			return playTime;
		}

		public void setVolumeDelta(int volumeDelta) {
			this.volumeDelta = volumeDelta;
		}
		public int getVolumeDelta() {
			return volumeDelta;
		}

	}

	public static class LMusic {

		private String name;
		private long id;
		private long size;
		private String extension;
		private int sr;
		private int dfsId;
		private long bitrate;
		private long playTime;
		private int volumeDelta;
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

		public void setSize(long size) {
			this.size = size;
		}
		public long getSize() {
			return size;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}
		public String getExtension() {
			return extension;
		}

		public void setSr(int sr) {
			this.sr = sr;
		}
		public int getSr() {
			return sr;
		}

		public void setDfsId(int dfsId) {
			this.dfsId = dfsId;
		}
		public int getDfsId() {
			return dfsId;
		}

		public void setBitrate(long bitrate) {
			this.bitrate = bitrate;
		}
		public long getBitrate() {
			return bitrate;
		}

		public void setPlayTime(long playTime) {
			this.playTime = playTime;
		}
		public long getPlayTime() {
			return playTime;
		}

		public void setVolumeDelta(int volumeDelta) {
			this.volumeDelta = volumeDelta;
		}
		public int getVolumeDelta() {
			return volumeDelta;
		}

	}
}

