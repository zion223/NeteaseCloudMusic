package com.imooc.lib_api.model.user;

import com.google.gson.annotations.SerializedName;
import com.imooc.lib_api.model.playlist.DailyRecommendBean;
import com.imooc.lib_api.model.search.AlbumSearchBean;

import java.util.List;

/**
 * 用户动态的json bean
 * msg里面是 content
 * 附带的bean 有 song（歌曲） video（视频） program（电台）
 * event（转发）
 */
public class UserEventJsonBean {


    /**
     * msg : Armin Van Buuren发推庆祝和他爱人的10年纪念日
     * song : {"name":"It Could Be","id":1391810715,"position":0,"alias":[],"status":0,"fee":8,"copyrightId":665010,"disc":"01","no":1,"artists":[{"name":"Armin van Buuren","id":27621,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},{"name":"Inner City","id":60435,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"album":{"name":"It Could Be","id":81750597,"type":"EP/Single","size":0,"picId":109951164372996407,"blurPicUrl":"http://p2.music.126.net/jKztNn2WzZ3bez6Rrez88Q==/109951164372996407.jpg","companyId":0,"pic":109951164372996407,"picUrl":"http://p2.music.126.net/jKztNn2WzZ3bez6Rrez88Q==/109951164372996407.jpg","publishTime":1568908800000,"description":"","tags":"","company":"Armada Music","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":1,"copyrightId":665010,"commentThreadId":"R_AL_3_81750597","artists":[{"name":"Armin van Buuren","id":27621,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},{"name":"Inner City","id":60435,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"img80x80":"https://p1.music.126.net/jKztNn2WzZ3bez6Rrez88Q==/109951164372996407.jpg?param=80x80x1"},"starred":false,"popularity":5,"score":5,"starredNum":0,"duration":157517,"playedNum":0,"dayPlays":0,"hearTime":0,"ringtone":"","crbt":null,"audition":null,"copyFrom":"","commentThreadId":"R_SO_4_1391810715","rtUrl":null,"ftype":0,"rtUrls":[],"copyright":1,"rtype":0,"rurl":null,"mvid":0,"bMusic":{"name":null,"id":3978676183,"size":2521173,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":157517,"volumeDelta":-63497},"mp3Url":null,"lMusic":{"name":null,"id":3978676183,"size":2521173,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":157517,"volumeDelta":-63497},"hMusic":{"name":null,"id":3978676181,"size":6302868,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":157517,"volumeDelta":-67359},"mMusic":{"name":null,"id":3978676182,"size":3781738,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":157517,"volumeDelta":-64960}}
     */

    private String msg;
    //歌曲
    private DailyRecommendBean.RecommendBean song;
    //视频
    private VideoBean video;
    //电台节目
    private ProgramBean program;
    //动态
    private UserEventBean event;
    //歌单
    private UserPlaylistBean.PlaylistBean playlist;
    //专辑
    private AlbumSearchBean.ResultBean.AlbumsBean album;

    @Override
    public String toString() {
        return "UserEventJsonBean{" +
                "msg='" + msg + '\'' +
                ", song=" + song +
                ", video=" + video +
                ", program=" + program +
                ", event=" + event +
                ", playlist=" + playlist +
                ", album=" + album +
                '}';
    }

    public AlbumSearchBean.ResultBean.AlbumsBean getAlbum() {
        return album;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public DailyRecommendBean.RecommendBean getSong() {
        return song;
    }

    public void setSong(DailyRecommendBean.RecommendBean song) {
        this.song = song;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public ProgramBean getProgram() {
        return program;
    }

    public void setProgram(ProgramBean program) {
        this.program = program;
    }

    public UserPlaylistBean.PlaylistBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(UserPlaylistBean.PlaylistBean playlist) {
        this.playlist = playlist;
    }

    public static class VideoBean {
        /**
         * vid : 0
         * coverUrl : http://p4.music.126.net/sYzTtvaqErQJreMlI_gjqg==/109951164375596429.jpg
         * duration : 264
         * playTime : 21
         * height : 720
         * width : 1280
         * size : 57982295
         * state : 1
         * coverType : 0
         * urlInfo : null
         * videoId : 38021ABAB8C082ABEC9286D1D57B1B01
         * threadId : null
         * title : Yellow Claw新单《Let's Get Married》MV首播
         * description : 黄爪Yellow Claw新单《Let's Get Married》MV超清首播，全程撒狗粮！MV记录了一对情侣在黄爪演出现场求婚成功和结婚的故事。这对情侣在MV中表示是黄爪的音乐让他们在一起，音乐的魅力就是如此！
         * creator : {"defaultAvatar":false,"province":1000000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/KAw1_uQP354hY7BxfBTmfA==/109951164311340072.jpg","accountStatus":0,"gender":1,"city":1003100,"birthday":912268800000,"userId":45144541,"userType":10,"nickname":"泛电音","signature":"致力于分享电子音乐文化，合作请私信。","description":"音乐博主","detailDescription":"音乐博主","avatarImgId":109951164311340072,"backgroundImgId":109951164311196266,"backgroundUrl":"http://p1.music.126.net/EjXB-9S3AlZ3VNpJoTocJg==/109951164311196266.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951164311340072","backgroundImgIdStr":"109951164311196266","avatarImgId_str":"109951164311340072"}
         * videoStatus : 0
         * resolutions : [{"resolution":0,"size":57982295}]
         * antisChecking : false
         * durationms : 264290
         */

        private String vid;
        private String coverUrl;
        private int duration;
        private int playTime;
        private int height;
        private int width;
        private int size;
        private int state;
        private int coverType;
        private Object urlInfo;
        private String videoId;
        private Object threadId;
        private String title;
        private String description;
        private CreatorBean creator;
        private int videoStatus;
        private boolean antisChecking;
        private int durationms;
        private List<ResolutionsBean> resolutions;

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void setPlayTime(int playTime) {
            this.playTime = playTime;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getCoverType() {
            return coverType;
        }

        public void setCoverType(int coverType) {
            this.coverType = coverType;
        }

        public Object getUrlInfo() {
            return urlInfo;
        }

        public void setUrlInfo(Object urlInfo) {
            this.urlInfo = urlInfo;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public Object getThreadId() {
            return threadId;
        }

        public void setThreadId(Object threadId) {
            this.threadId = threadId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public int getVideoStatus() {
            return videoStatus;
        }

        public void setVideoStatus(int videoStatus) {
            this.videoStatus = videoStatus;
        }

        public boolean isAntisChecking() {
            return antisChecking;
        }

        public void setAntisChecking(boolean antisChecking) {
            this.antisChecking = antisChecking;
        }

        public int getDurationms() {
            return durationms;
        }

        public void setDurationms(int durationms) {
            this.durationms = durationms;
        }

        public List<ResolutionsBean> getResolutions() {
            return resolutions;
        }

        public void setResolutions(List<ResolutionsBean> resolutions) {
            this.resolutions = resolutions;
        }

        public static class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/KAw1_uQP354hY7BxfBTmfA==/109951164311340072.jpg
             * accountStatus : 0
             * gender : 1
             * city : 1003100
             * birthday : 912268800000
             * userId : 45144541
             * userType : 10
             * nickname : 泛电音
             * signature : 致力于分享电子音乐文化，合作请私信。
             * description : 音乐博主
             * detailDescription : 音乐博主
             * avatarImgId : 109951164311340072
             * backgroundImgId : 109951164311196266
             * backgroundUrl : http://p1.music.126.net/EjXB-9S3AlZ3VNpJoTocJg==/109951164311196266.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 10
             * vipType : 11
             * remarkName : null
             * avatarImgIdStr : 109951164311340072
             * backgroundImgIdStr : 109951164311196266
             * avatarImgId_str : 109951164311340072
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

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }

        public static class ResolutionsBean {
            /**
             * resolution : 0
             * size : 57982295
             */

            private int resolution;
            private int size;

            public int getResolution() {
                return resolution;
            }

            public void setResolution(int resolution) {
                this.resolution = resolution;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }
        }
    }


    public static class ProgramBean {
        /**
         * mainSong : null
         * songs : null
         * dj : {"defaultAvatar":false,"province":1000000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/w6o3OFlljKMxxAMSXbywOg==/109951163112568806.jpg","accountStatus":0,"gender":2,"city":1010000,"birthday":1527782400000,"userId":51721387,"userType":4,"nickname":"某微__JOKER","signature":"翻唱歌手，只要是我发布的都是我唱的。\n我没打算让所有人都满意。","description":"","detailDescription":"","avatarImgId":109951163112568806,"backgroundImgId":2002210674180204,"backgroundUrl":"http://p1.music.126.net/5L9yqWa_UnlHtlp7li5PAg==/2002210674180204.jpg","authority":0,"mutual":false,"expertTags":null,"experts":{"1":"音乐原创视频达人"},"djStatus":10,"vipType":11,"remarkName":null,"backgroundImgIdStr":"2002210674180204","avatarImgIdStr":"109951163112568806","avatarImgId_str":"109951163112568806","brand":"某微__JOKER的电台"}
         * blurCoverUrl : http://music.163.com/api/dj/img/blur/7743860394573149
         * radio : {"id":803001,"dj":null,"name":"某微__JOKER的电台","picUrl":"http://p2.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg","desc":"You should get away from me. Efehu vuruz apurisaz.","subCount":320,"programCount":40,"createTime":1422446203005,"categoryId":2001,"category":"创作|翻唱","radioFeeType":0,"feeScope":0,"buyed":true,"videos":null,"finished":false,"underShelf":false,"purchaseCount":0,"price":0,"originalPrice":0,"discountPrice":null,"lastProgramCreateTime":1564738801692,"lastProgramName":null,"lastProgramId":2062489999,"picId":7743860394573149,"rcmdText":"有辨识度的慵懒女声","composeVideo":false,"subed":true}
         * subscribedCount : 0
         * reward : false
         * mainTrackId : 1392321849
         * serialNum : 40
         * listenerCount : 0
         * name : summertime
         * id : 2063287172
         * createTime : 1569041132676
         * description : ✿原唱：cinnamons / evening cinema
         ✿翻唱/后期：JOKER（@某微__JOKER ）

         摸着夏天的尾巴给大家唱首甜甜的summertime
         * userId : 51721387
         * coverUrl : http://p2.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg
         * commentThreadId : A_DJ_1_2063287172
         * channels : []
         * titbits : null
         * titbitImages : null
         * pubStatus : 5
         * trackCount : 0
         * bdAuditStatus : 2
         * programFeeType : 0
         * buyed : false
         * programDesc : null
         * h5Links : []
         * coverId : 7743860394573149
         * adjustedPlayCount : 0
         * canReward : false
         * auditStatus : 10
         * publish : true
         * duration : 0
         * img80x80 : http://p1.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg?param=80x80x1
         */

        private Object mainSong;
        private Object songs;
        private DjBean dj;
        private String blurCoverUrl;
        private RadioBean radio;
        private int subscribedCount;
        private boolean reward;
        private int mainTrackId;
        private int serialNum;
        private int listenerCount;
        private String name;
        private long id;
        private long createTime;
        private String description;
        private long userId;
        private String coverUrl;
        private String commentThreadId;
        private Object titbits;
        private Object titbitImages;
        private int pubStatus;
        private int trackCount;
        private int bdAuditStatus;
        private int programFeeType;
        private boolean buyed;
        private Object programDesc;
        private long coverId;
        private int adjustedPlayCount;
        private boolean canReward;
        private int auditStatus;
        private boolean publish;
        private int duration;
        private String img80x80;
        private List<?> channels;
        private List<?> h5Links;

        public Object getMainSong() {
            return mainSong;
        }

        public void setMainSong(Object mainSong) {
            this.mainSong = mainSong;
        }

        public Object getSongs() {
            return songs;
        }

        public void setSongs(Object songs) {
            this.songs = songs;
        }

        public DjBean getDj() {
            return dj;
        }

        public void setDj(DjBean dj) {
            this.dj = dj;
        }

        public String getBlurCoverUrl() {
            return blurCoverUrl;
        }

        public void setBlurCoverUrl(String blurCoverUrl) {
            this.blurCoverUrl = blurCoverUrl;
        }

        public RadioBean getRadio() {
            return radio;
        }

        public void setRadio(RadioBean radio) {
            this.radio = radio;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public boolean isReward() {
            return reward;
        }

        public void setReward(boolean reward) {
            this.reward = reward;
        }

        public int getMainTrackId() {
            return mainTrackId;
        }

        public void setMainTrackId(int mainTrackId) {
            this.mainTrackId = mainTrackId;
        }

        public int getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(int serialNum) {
            this.serialNum = serialNum;
        }

        public int getListenerCount() {
            return listenerCount;
        }

        public void setListenerCount(int listenerCount) {
            this.listenerCount = listenerCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public Object getTitbits() {
            return titbits;
        }

        public void setTitbits(Object titbits) {
            this.titbits = titbits;
        }

        public Object getTitbitImages() {
            return titbitImages;
        }

        public void setTitbitImages(Object titbitImages) {
            this.titbitImages = titbitImages;
        }

        public int getPubStatus() {
            return pubStatus;
        }

        public void setPubStatus(int pubStatus) {
            this.pubStatus = pubStatus;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getBdAuditStatus() {
            return bdAuditStatus;
        }

        public void setBdAuditStatus(int bdAuditStatus) {
            this.bdAuditStatus = bdAuditStatus;
        }

        public int getProgramFeeType() {
            return programFeeType;
        }

        public void setProgramFeeType(int programFeeType) {
            this.programFeeType = programFeeType;
        }

        public boolean isBuyed() {
            return buyed;
        }

        public void setBuyed(boolean buyed) {
            this.buyed = buyed;
        }

        public Object getProgramDesc() {
            return programDesc;
        }

        public void setProgramDesc(Object programDesc) {
            this.programDesc = programDesc;
        }

        public long getCoverId() {
            return coverId;
        }

        public void setCoverId(long coverId) {
            this.coverId = coverId;
        }

        public int getAdjustedPlayCount() {
            return adjustedPlayCount;
        }

        public void setAdjustedPlayCount(int adjustedPlayCount) {
            this.adjustedPlayCount = adjustedPlayCount;
        }

        public boolean isCanReward() {
            return canReward;
        }

        public void setCanReward(boolean canReward) {
            this.canReward = canReward;
        }

        public int getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(int auditStatus) {
            this.auditStatus = auditStatus;
        }

        public boolean isPublish() {
            return publish;
        }

        public void setPublish(boolean publish) {
            this.publish = publish;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getImg80x80() {
            return img80x80;
        }

        public void setImg80x80(String img80x80) {
            this.img80x80 = img80x80;
        }

        public List<?> getChannels() {
            return channels;
        }

        public void setChannels(List<?> channels) {
            this.channels = channels;
        }

        public List<?> getH5Links() {
            return h5Links;
        }

        public void setH5Links(List<?> h5Links) {
            this.h5Links = h5Links;
        }

        public static class DjBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/w6o3OFlljKMxxAMSXbywOg==/109951163112568806.jpg
             * accountStatus : 0
             * gender : 2
             * city : 1010000
             * birthday : 1527782400000
             * userId : 51721387
             * userType : 4
             * nickname : 某微__JOKER
             * signature : 翻唱歌手，只要是我发布的都是我唱的。
             我没打算让所有人都满意。
             * description :
             * detailDescription :
             * avatarImgId : 109951163112568806
             * backgroundImgId : 2002210674180204
             * backgroundUrl : http://p1.music.126.net/5L9yqWa_UnlHtlp7li5PAg==/2002210674180204.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : {"1":"音乐原创视频达人"}
             * djStatus : 10
             * vipType : 11
             * remarkName : null
             * backgroundImgIdStr : 2002210674180204
             * avatarImgIdStr : 109951163112568806
             * avatarImgId_str : 109951163112568806
             * brand : 某微__JOKER的电台
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
            private ExpertsBean experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String backgroundImgIdStr;
            private String avatarImgIdStr;
            private String avatarImgId_str;
            private String brand;

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

            public long getUserId() {
                return userId;
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

            public ExpertsBean getExperts() {
                return experts;
            }

            public void setExperts(ExpertsBean experts) {
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

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public static class ExpertsBean {
                /**
                 * 1 : 音乐原创视频达人
                 */

                @SerializedName("1")
                private String _$1;

                public String get_$1() {
                    return _$1;
                }

                public void set_$1(String _$1) {
                    this._$1 = _$1;
                }
            }
        }

        public static class RadioBean {
            /**
             * id : 803001
             * dj : null
             * name : 某微__JOKER的电台
             * picUrl : http://p2.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg
             * desc : You should get away from me. Efehu vuruz apurisaz.
             * subCount : 320
             * programCount : 40
             * createTime : 1422446203005
             * categoryId : 2001
             * category : 创作|翻唱
             * radioFeeType : 0
             * feeScope : 0
             * buyed : true
             * videos : null
             * finished : false
             * underShelf : false
             * purchaseCount : 0
             * price : 0
             * originalPrice : 0
             * discountPrice : null
             * lastProgramCreateTime : 1564738801692
             * lastProgramName : null
             * lastProgramId : 2062489999
             * picId : 7743860394573149
             * rcmdText : 有辨识度的慵懒女声
             * composeVideo : false
             * subed : true
             */

            private long id;
            private Object dj;
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
            private boolean composeVideo;
            private boolean subed;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public Object getDj() {
                return dj;
            }

            public void setDj(Object dj) {
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

            public boolean isComposeVideo() {
                return composeVideo;
            }

            public void setComposeVideo(boolean composeVideo) {
                this.composeVideo = composeVideo;
            }

            public boolean isSubed() {
                return subed;
            }

            public void setSubed(boolean subed) {
                this.subed = subed;
            }
        }
    }

    public UserEventBean getEvent() {
        return event;
    }

    public void setEvent(UserEventBean event) {
        this.event = event;
    }
}
