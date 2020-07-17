package com.imooc.lib_api.model.dj;


import com.imooc.lib_api.model.playlist.TopListDetailBean;

import java.util.ArrayList;

public class DjProgramTopListBean {


    private int code;
    private String updateTime;
    private ArrayList<List> list;
    private ArrayList<List> toplist;

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public ArrayList<List> getToplist() {
        return toplist;
    }

    public void setToplist(ArrayList<List> toplist) {
        this.toplist = toplist;
    }

    public class List {

        private Program program;
        private int rank;
        private int lastRank;
        private long score;
        private int programFeeType;

        public void setProgram(Program program) {
            this.program = program;
        }

        public Program getProgram() {
            return program;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public void setLastRank(int lastRank) {
            this.lastRank = lastRank;
        }

        public int getLastRank() {
            return lastRank;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public long getScore() {
            return score;
        }

        public void setProgramFeeType(int programFeeType) {
            this.programFeeType = programFeeType;
        }

        public int getProgramFeeType() {
            return programFeeType;
        }

    }

    public class Program {

        private MainSong mainSong;
        private String songs;
        private DjSubListBean.Dj dj;
        private String blurCoverUrl;
        private DjProgramBean.ProgramsBean.RadioBean radio;
        private long duration;
        private boolean buyed;
        private String programDesc;
        private String h5Links;
        private boolean canReward;
        private int auditStatus;
        private String videoInfo;
        private int score;
        private String liveInfo;
        private String alg;
        private String description;
        private String commentThreadId;
        private int smallLanguageAuditStatus;
        private long createTime;
        private int serialNum;
        private int feeScope;
        private int pubStatus;
        private String coverUrl;
        private int bdAuditStatus;
        private ArrayList<String> channels;
        private long listenerCount;
        private boolean reward;
        private int subscribedCount;
        private String titbits;
        private int programFeeType;
        private long mainTrackId;
        private String titbitImages;
        private boolean isPublish;
        private int trackCount;
        private String name;
        private long id;
        private boolean subscribed;
        private int shareCount;
        private int likedCount;
        private int commentCount;

        public void setMainSong(MainSong mainSong) {
            this.mainSong = mainSong;
        }

        public MainSong getMainSong() {
            return mainSong;
        }

        public void setSongs(String songs) {
            this.songs = songs;
        }

        public String getSongs() {
            return songs;
        }

        public void setDj(DjSubListBean.Dj dj) {
            this.dj = dj;
        }

        public DjSubListBean.Dj getDj() {
            return dj;
        }

        public void setBlurCoverUrl(String blurCoverUrl) {
            this.blurCoverUrl = blurCoverUrl;
        }

        public String getBlurCoverUrl() {
            return blurCoverUrl;
        }

        public void setRadio(DjProgramBean.ProgramsBean.RadioBean radio) {
            this.radio = radio;
        }

        public DjProgramBean.ProgramsBean.RadioBean getRadio() {
            return radio;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public long getDuration() {
            return duration;
        }

        public void setBuyed(boolean buyed) {
            this.buyed = buyed;
        }

        public boolean getBuyed() {
            return buyed;
        }

        public void setProgramDesc(String programDesc) {
            this.programDesc = programDesc;
        }

        public String getProgramDesc() {
            return programDesc;
        }

        public void setH5Links(String h5Links) {
            this.h5Links = h5Links;
        }

        public String getH5Links() {
            return h5Links;
        }

        public void setCanReward(boolean canReward) {
            this.canReward = canReward;
        }

        public boolean getCanReward() {
            return canReward;
        }

        public void setAuditStatus(int auditStatus) {
            this.auditStatus = auditStatus;
        }

        public int getAuditStatus() {
            return auditStatus;
        }

        public void setVideoInfo(String videoInfo) {
            this.videoInfo = videoInfo;
        }

        public String getVideoInfo() {
            return videoInfo;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public void setLiveInfo(String liveInfo) {
            this.liveInfo = liveInfo;
        }

        public String getLiveInfo() {
            return liveInfo;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getAlg() {
            return alg;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setSmallLanguageAuditStatus(int smallLanguageAuditStatus) {
            this.smallLanguageAuditStatus = smallLanguageAuditStatus;
        }

        public int getSmallLanguageAuditStatus() {
            return smallLanguageAuditStatus;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setSerialNum(int serialNum) {
            this.serialNum = serialNum;
        }

        public int getSerialNum() {
            return serialNum;
        }

        public void setFeeScope(int feeScope) {
            this.feeScope = feeScope;
        }

        public int getFeeScope() {
            return feeScope;
        }

        public void setPubStatus(int pubStatus) {
            this.pubStatus = pubStatus;
        }

        public int getPubStatus() {
            return pubStatus;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setBdAuditStatus(int bdAuditStatus) {
            this.bdAuditStatus = bdAuditStatus;
        }

        public int getBdAuditStatus() {
            return bdAuditStatus;
        }

        public void setChannels(ArrayList<String> channels) {
            this.channels = channels;
        }

        public ArrayList<String> getChannels() {
            return channels;
        }

        public void setListenerCount(long listenerCount) {
            this.listenerCount = listenerCount;
        }

        public long getListenerCount() {
            return listenerCount;
        }

        public void setReward(boolean reward) {
            this.reward = reward;
        }

        public boolean getReward() {
            return reward;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setTitbits(String titbits) {
            this.titbits = titbits;
        }

        public String getTitbits() {
            return titbits;
        }

        public void setProgramFeeType(int programFeeType) {
            this.programFeeType = programFeeType;
        }

        public int getProgramFeeType() {
            return programFeeType;
        }

        public void setMainTrackId(long mainTrackId) {
            this.mainTrackId = mainTrackId;
        }

        public long getMainTrackId() {
            return mainTrackId;
        }

        public void setTitbitImages(String titbitImages) {
            this.titbitImages = titbitImages;
        }

        public String getTitbitImages() {
            return titbitImages;
        }

        public void setIsPublish(boolean isPublish) {
            this.isPublish = isPublish;
        }

        public boolean getIsPublish() {
            return isPublish;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getTrackCount() {
            return trackCount;
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

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public boolean getSubscribed() {
            return subscribed;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

    }

    public static class MainSong {

        private String name;
        private long id;
        private int position;
        private ArrayList<String> alias;
        private int status;
        private int fee;
        private int copyrightId;
        private String disc;
        private int no;
        private ArrayList<TopListDetailBean.Artists> artists;
        private TopListDetailBean.Album album;
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
        private ArrayList<String> rtUrls;
        private TopListDetailBean.HMusicBean hMusic;
        private TopListDetailBean.MMusic mMusic;
        private TopListDetailBean.LMusic lMusic;
        private TopListDetailBean.BMusic bMusic;
        private String mp3Url;
        private int rtype;
        private String rurl;
        private int mvid;

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

        public void setAlias(ArrayList<String> alias) {
            this.alias = alias;
        }

        public ArrayList<String> getAlias() {
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

        public void setArtists(ArrayList<TopListDetailBean.Artists> artists) {
            this.artists = artists;
        }

        public ArrayList<TopListDetailBean.Artists> getArtists() {
            return artists;
        }

        public void setAlbum(TopListDetailBean.Album album) {
            this.album = album;
        }

        public TopListDetailBean.Album getAlbum() {
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

        public void setRtUrls(ArrayList<String> rtUrls) {
            this.rtUrls = rtUrls;
        }

        public ArrayList<String> getRtUrls() {
            return rtUrls;
        }

        public void setHMusic(TopListDetailBean.HMusicBean hMusic) {
            this.hMusic = hMusic;
        }

        public TopListDetailBean.HMusicBean getHMusic() {
            return hMusic;
        }

        public void setMMusic(TopListDetailBean.MMusic mMusic) {
            this.mMusic = mMusic;
        }

        public TopListDetailBean.MMusic getMMusic() {
            return mMusic;
        }

        public void setLMusic(TopListDetailBean.LMusic lMusic) {
            this.lMusic = lMusic;
        }

        public TopListDetailBean.LMusic getLMusic() {
            return lMusic;
        }

        public void setBMusic(TopListDetailBean.BMusic bMusic) {
            this.bMusic = bMusic;
        }

        public TopListDetailBean.BMusic getBMusic() {
            return bMusic;
        }

        public void setMp3Url(String mp3Url) {
            this.mp3Url = mp3Url;
        }

        public String getMp3Url() {
            return mp3Url;
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

    }

}
