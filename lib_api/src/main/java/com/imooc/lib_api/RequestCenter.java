package com.imooc.lib_api;


import com.imooc.lib_api.model.album.AlbumDetailBean;
import com.imooc.lib_api.model.album.AlbumDynamicBean;
import com.imooc.lib_api.model.album.AlbumSublistBean;
import com.imooc.lib_api.model.artist.ArtistJson;
import com.imooc.lib_api.model.artist.ArtistListBean;
import com.imooc.lib_api.model.artist.ArtistSublistBean;
import com.imooc.lib_api.model.banner.BannerBean;
import com.imooc.lib_api.model.playlist.CatlistBean;
import com.imooc.lib_api.model.notification.CommonMessageBean;
import com.imooc.lib_api.model.playlist.DailyRecommendBean;
import com.imooc.lib_api.model.dj.DjBannerBean;
import com.imooc.lib_api.model.user.FollowBean;
import com.imooc.lib_api.model.playlist.HighQualityPlayListBean;
import com.imooc.lib_api.model.user.LikeListBean;
import com.imooc.lib_api.model.user.LoginBean;
import com.imooc.lib_api.model.user.MainEventBean;
import com.imooc.lib_api.model.playlist.MainRecommendPlayListBean;
import com.imooc.lib_api.model.mv.MvBean;
import com.imooc.lib_api.model.mv.MvInfoBean;
import com.imooc.lib_api.model.mv.MvSublistBean;
import com.imooc.lib_api.model.mv.MvTopBean;
import com.imooc.lib_api.model.playlist.MyFmBean;
import com.imooc.lib_api.model.song.NewSongBean;
import com.imooc.lib_api.model.playlist.PlayModeIntelligenceBean;
import com.imooc.lib_api.model.playlist.PlaylistDetailBean;
import com.imooc.lib_api.model.playlist.RecommendPlayListBean;
import com.imooc.lib_api.model.user.SubCountBean;
import com.imooc.lib_api.model.playlist.TopListBean;
import com.imooc.lib_api.model.playlist.TopListDetailBean;
import com.imooc.lib_api.model.user.UserFollowedBean;
import com.imooc.lib_api.model.user.UserFollowerBean;
import com.imooc.lib_api.model.user.UserRecordBean;
import com.imooc.lib_api.model.mv.VideoBean;
import com.imooc.lib_api.model.mv.VideoDetailBean;
import com.imooc.lib_api.model.mv.VideoGroupBean;
import com.imooc.lib_api.model.mv.VideoRelatedBean;
import com.imooc.lib_api.model.mv.VideoUrlBean;
import com.imooc.lib_api.model.dj.DjCatelistBean;
import com.imooc.lib_api.model.dj.DjDetailBean;
import com.imooc.lib_api.model.dj.DjPaygiftBean;
import com.imooc.lib_api.model.dj.DjProgramBean;
import com.imooc.lib_api.model.dj.DjProgramTopListBean;
import com.imooc.lib_api.model.dj.DjProgramTopListHoursBean;
import com.imooc.lib_api.model.dj.DjRecommendBean;
import com.imooc.lib_api.model.dj.DjRecommendTypeBean;
import com.imooc.lib_api.model.dj.DjSubBean;
import com.imooc.lib_api.model.dj.DjSubListBean;
import com.imooc.lib_api.model.dj.DjRankListBean;
import com.imooc.lib_api.model.dj.DjTopListBean;
import com.imooc.lib_api.model.song.MusicCanPlayBean;
import com.imooc.lib_api.model.notification.PrivateCommentBean;
import com.imooc.lib_api.model.notification.PrivateMsgBean;
import com.imooc.lib_api.model.notification.PrivateNoticeBean;
import com.imooc.lib_api.model.notification.UserCloudBean;
import com.imooc.lib_api.model.user.UserDetailBean;
import com.imooc.lib_api.model.user.UserEventBean;
import com.imooc.lib_api.model.user.UserPlaylistBean;
import com.imooc.lib_api.model.search.AlbumSearchBean;
import com.imooc.lib_api.model.search.FeedSearchBean;
import com.imooc.lib_api.model.search.HotSearchDetailBean;
import com.imooc.lib_api.model.search.PlayListSearchBean;
import com.imooc.lib_api.model.search.RadioSearchBean;
import com.imooc.lib_api.model.search.SimiSingerBean;
import com.imooc.lib_api.model.search.SingerAblumSearchBean;
import com.imooc.lib_api.model.search.SingerDescriptionBean;
import com.imooc.lib_api.model.search.SingerSearchBean;
import com.imooc.lib_api.model.search.SingerSongSearchBean;
import com.imooc.lib_api.model.search.SingerVideoSearchBean;
import com.imooc.lib_api.model.search.SongSearchBean;
import com.imooc.lib_api.model.search.SynthesisSearchBean;
import com.imooc.lib_api.model.search.UserSearchBean;
import com.imooc.lib_api.model.song.CommentLikeBean;
import com.imooc.lib_api.model.song.LikeMusicBean;
import com.imooc.lib_api.model.song.LyricBean;
import com.imooc.lib_api.model.song.PlayListCommentBean;
import com.imooc.lib_api.model.song.SongDetailBean;
import com.imooc.lib_api.model.song.SongUrlBean;
import com.imooc.lib_network.CommonOkHttpClient;
import com.imooc.lib_network.listener.DisposeDataHandler;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.imooc.lib_network.request.CommonRequest;
import com.imooc.lib_network.request.RequestParams;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 请求中心
 */
public class RequestCenter {


    //根据参数发送所有post请求
    private static void getRequest(String url, RequestParams params, DisposeDataListener listener,
                                   Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandler(listener, clazz));
    }

    /**
     * 用户登陆请求
     */
    public static void login(String phone, String password, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("phone", phone);
        params.put("password", password);
        RequestCenter.getRequest(HttpConstants.LOGIN, params, listener, LoginBean.class);
    }

    /**
     * 用户签到
     */
    public static void signIn(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.SIGNIN, null, listener, CommonMessageBean.class);
    }

    /**
     * 获取音乐播放url
     */
    public static void getSongUrl(long id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SONG_URL, params, listener, SongUrlBean.class);
    }

    /**
     * 发送验证码
     */
    public static void sendCaptcha(String phone, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("phone", phone);
        RequestCenter.getRequest(HttpConstants.CAPTCHA_SEND, params, listener, CommonMessageBean.class);
    }

    /**
     * 验证验证码
     */
    public static void verifyCaptcha(String phone, String captcha, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("phone", phone);
        params.put("captcha", captcha);
        RequestCenter.getRequest(HttpConstants.CAPTCHA_VERITY, params, listener, CommonMessageBean.class);
    }

    /**
     * 注册(修改密码)
     * PS.captcha: 验证码 phone : 手机号码 password: 密码 nickname: 昵
     */
    public static void register(String phone, String captcha, String password, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("phone", phone);
        params.put("captcha", captcha);
        params.put("password", password);
        RequestCenter.getRequest(HttpConstants.REGISTER, params, listener, LoginBean.class);
    }


    /**
     * 获取用户信息 , 歌单，收藏，mv, dj 数量
     */
    public static void getsubCount(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.USER_SUBCOUNT, null, listener, SubCountBean.class);
    }

    /**
     * 获取用户粉丝列表
     */
    public static void getUserFollower(String uid, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        RequestCenter.getRequest(HttpConstants.USER_FOLLOWED, params, listener, UserFollowedBean.class);
    }

    /**
     * 获取用户关注列表
     */
    public static void getUserFollowed(String uid, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        RequestCenter.getRequest(HttpConstants.USER_FOLLOWER, params, listener, UserFollowerBean.class);
    }

    /**
     * 用户登出请求
     */
    public static void logout(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.LOGOUT, null, listener, CommonMessageBean.class);
    }

    /**
     * 获取发现页面Banner
     * PS. 0: pc 1: android 2: iphone 3: ipad
     */
    public static void getBanner(int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("type", String.valueOf(type));
        RequestCenter.getRequest(HttpConstants.BANNER, params, listener, BannerBean.class);
    }

    /**
     * 获取电台Banner
     */
    public static void getRadioBanner(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.RADIO_BANNER, null, listener, DjBannerBean.class);
    }

    /**
     * 首页推荐歌单的ban 需要登录
     */
    public static void getRecommendPlayList(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.RECOMMAND_PLAYLIST, null, listener, MainRecommendPlayListBean.class);
    }

    /**
     * 每日推荐
     */
    public static void getDailyRecommend(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.DAILY_RECOMMAND, null, listener, DailyRecommendBean.class);
    }

    /**
     * 所有榜单
     */
    public static void getTopList(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.TOP_LIST, null, listener, TopListBean.class);
    }

    /**
     * 所有榜单内容摘要 - 排行榜页面
     */
    public static void getTopListDetail(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.TOP_LIST_DETAIL, null, listener, TopListDetailBean.class);
    }

    /**
     * 推荐电台
     */
    public static void getRadioRecommend(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.RADIO_RECOMMEND, null, listener, DjRecommendBean.class);
    }

    /**
     * 电台 分类推荐
     * PS. type: 电台类型 , 数字 , 可通过/dj/catelist获取 , 对应关系为 id 对应 此接口的 type, name 对应类型
     */
    public static void getRadioRecommend(int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("type", String.valueOf(type));
        RequestCenter.getRequest(HttpConstants.DJ_RECOMMEND_TYPE, params, listener, DjRecommendTypeBean.class);
    }

    /**
     * 歌单模块
     */
    public static void getPlayList(String type, int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("cat", type);
        params.put("limit", String.valueOf(limit));
        RequestCenter.getRequest(HttpConstants.RECOMMEND_PLAY_LIST, params, listener, RecommendPlayListBean.class);
    }

    /**
     * 获取精品歌单
     */
    public static void getHighquality(int limit, long before, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        params.put("before", before);
        RequestCenter.getRequest(HttpConstants.RECOMMEND_PLAY_LIST_HIGHQUALITY, params, listener, HighQualityPlayListBean.class);
    }

    public static void getCatList(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.CAT_LIST, null, listener, CatlistBean.class);
    }

    /**
     * 歌单详情
     */
    public static void getPlaylistDetail(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.PLAY_LIST_DETAIL, params, listener, PlaylistDetailBean.class);
    }

    /**
     * 专辑详情
     */
    public static void getAlbumDetail(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.ALBUM_DETAIL, params, listener, AlbumDetailBean.class);
    }

    /**
     * 专辑动态信息
     */
    public static void getAlbumDynamic(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.ALBUM_DYNAMIC, params, listener, AlbumDynamicBean.class);
    }

    /**
     * 新碟上架
     */
    public static void getTopAlbum(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", String.valueOf(limit));
        RequestCenter.getRequest(HttpConstants.TOP_ALBUM, params, listener, AlbumSearchBean.ResultBean.class);
    }

    /**
     * 最新专辑
     */
    public static void getNewAlbum(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.NEW_ALBUM, null, listener, AlbumSearchBean.ResultBean.class);
    }

    /**
     * 新歌速递
     * PS.全部:0 华语:7  欧美:96 日本:8 韩国:16
     */
    public static void getTopSong(int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("type", type);
        RequestCenter.getRequest(HttpConstants.TOP_SONG, params, listener, NewSongBean.class);
    }

    /**
     * 音乐是否可用
     */
    public static void getMusicCanPlay(long id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.MUSIC_CAN_PLAY, params, listener, MusicCanPlayBean.class);
    }

    /**
     * 用户的歌单 创建的歌单和收藏的歌单
     */
    public static void getUserPlaylist(long uid, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        RequestCenter.getRequest(HttpConstants.USER_PLAY_LIST, params, listener, UserPlaylistBean.class);
    }

    /**
     * 用户动态 lasttime默认-1
     */
    public static void getUserEvent(String uid, int limit, long time, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        params.put("limit", limit);
        params.put("lasttime", time);
        RequestCenter.getRequest(HttpConstants.USER_EVENT, params, listener, UserEventBean.class);
    }

    /**
     * 用户播放记录
     * type : type=1 时只返回 weekData, type=0 时返回 allData
     */
    public static void getUserRecord(int uid, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        params.put("type", type);
        RequestCenter.getRequest(HttpConstants.USER_RECORD, params, listener, UserRecordBean.class);
    }

    /**
     * 用户动态
     */
    public static void getUserEvent(String uid, DisposeDataListener listener) {
        getUserEvent(uid, 30, -1, listener);
    }

    /**
     * 用户详情
     */
    public static void getUserDetail(String uid, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        RequestCenter.getRequest(HttpConstants.USER_DETAIL, params, listener, UserDetailBean.class);
    }

    /**
     * 热搜列表 详细
     */
    public static void getSearchHotDetail(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.SEARCH_HOT, null, listener, HotSearchDetailBean.class);
    }

    /**
     * 搜索
     * PS.type: 搜索类型；默认为 1 即单曲 , 取值意义 :
     * 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单,
     * 1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台,
     * 1014: 视频, 1018:综合
     */
    public static void getSongSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, SongSearchBean.class);
    }

    public static void getAlbumSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 10);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, AlbumSearchBean.class);
    }

    public static void getSingerSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 100);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, SingerSearchBean.class);
    }

    public static void getPlayListSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1000);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, PlayListSearchBean.class);
    }

    public static void getUserSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1002);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, UserSearchBean.class);
    }

    public static void getVideoSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1014);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, FeedSearchBean.class);
    }

    public static void getRadioSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1009);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, RadioSearchBean.class);
    }

    public static void getSynthesisSearch(String keywords, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1018);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, SynthesisSearchBean.class);
    }

    /**
     * 歌手分类
     * type 1:男歌手 2:女歌手 3:乐队
     * area  -1:全部 7:华语(1) 96:欧美(2) 8:日本(3) 16韩国(4) 0:其他
     */
    public static void getSingerList(int type, int area, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        if (area == 1) {
            area = 7;
        } else if (area == 2) {
            area = 96;
        } else if (area == 3) {
            area = 8;
        } else if (area == 4) {
            area = 16;
        }
        params.put("type", type);
        params.put("area", area);
        RequestCenter.getRequest(HttpConstants.SINGER_LIST, params, listener, ArtistListBean.class);
    }

    /**
     * 获取热门歌手
     */
    public static void getHotSingerList(DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        RequestCenter.getRequest(HttpConstants.HOT_SINGER, params, listener, ArtistListBean.class);
    }

    /**
     * 获取歌手单曲 部分歌手简介
     */
    public static void getSingerInfo(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_HOT_SONG, params, listener, SingerSongSearchBean.class);
    }

    /**
     * 歌手专辑
     */
    public static void getSingerAlbum(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_ALBUM, params, listener, SingerAblumSearchBean.class);
    }

    /**
     * 歌手视频
     */
    public static void getSingerVideo(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_VIDEO, params, listener, SingerVideoSearchBean.class);
    }

    /**
     * 歌手描述
     */
    public static void getSingerDesc(long id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_DESC, params, listener, SingerDescriptionBean.class);
    }

    /**
     * 相似歌手
     */
    public static void getSimiSinger(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_SIMI, params, listener, SimiSingerBean.class);
    }

    /**
     * 喜欢音乐列表
     * uid 用户ID
     */
    public static void getLikeList(long id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", id);
        RequestCenter.getRequest(HttpConstants.LIKE_LIST, params, listener, LikeListBean.class);
    }

    /**
     * 获取歌曲详情
     * PS.调用此接口 , 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情(注意:歌曲封面现在需要通过专辑内容接口获取)
     */
    public static void getSongDetail(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("ids", id);
        RequestCenter.getRequest(HttpConstants.SONG_DETAIL, params, listener, SongDetailBean.class);
    }

    /**
     * 喜欢音乐
     */
    public static void getlikeMusic(String id, boolean like, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("like", like);
        RequestCenter.getRequest(HttpConstants.LIKE_MUSIC, params, listener, LikeMusicBean.class);
    }

    /**
     * 歌曲评论
     */
    public static void getMusicComment(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.MUSIC_COMMENT, params, listener, PlayListCommentBean.class);
    }

    /**
     * 给评论点赞
     * id : 资源 id, 如歌曲 id, mv id
     * cid : 评论 id
     * t : 是否点赞 ,1 为点赞 ,0 为取消点赞
     * tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * 0: 歌曲   1: mv 2: 歌单 3: 专辑 4: 电台 5: 视频 6: 动态
     */
    public static void getlikeComment(String id, long cid, boolean praise, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("cid", cid);
        params.put("t", praise ? 1 : 0);
        params.put("type", type);
        RequestCenter.getRequest(HttpConstants.COMMENT_LIKE, params, listener, CommentLikeBean.class);
    }

    /**
     * 获取热门评论
     * id : 资源 id
     * type: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * PS. 0: 歌曲 1: mv 2: 歌单 3: 专辑 4: 电台 5: 视频
     */
    public static void getHotComment(String id, int type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("type", type);
        RequestCenter.getRequest(HttpConstants.COMMENT_HOT, params, listener, PlayListCommentBean.class);
    }

    /**
     * 给资源点赞
     * type : 资源类型 1: mv 4: 电台 5: 视频 6: 动态
     * t : 是否点赞 ,1 为点赞 ,0 为取消点赞
     * id: 资源 id
     */
    public static void getlikeResource(String id, int type, boolean praise, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("t", praise ? 1 : 0);
        params.put("type", type);
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.RESOURCE_LIKE, params, listener, CommentLikeBean.class);
    }

    /**
     * 心动模式
     * id : 歌曲id
     * pid : 歌单 id
     * 可选参数 : sid : 要开始播放的歌曲的 id
     */
    public static void getIntelligenceList(long id, long pid, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("pid", pid);
        RequestCenter.getRequest(HttpConstants.INTELLIGANCE_LIST, params, listener, PlayModeIntelligenceBean.class);
    }

    /**
     * 获取已收藏专辑列表
     */
    public static void getAlbumSublist(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.ALBUM_SUBLIST, null, listener, AlbumSublistBean.class);
    }

    /**
     * 收藏的歌手列表
     */
    public static void getArtistSublist(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.ARTIST_SUBLIST, null, listener, ArtistSublistBean.class);
    }

    /**
     * 收藏的MV
     */
    public static void getMvSublist(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.MV_SUBLIST, null, listener, MvSublistBean.class);
    }

    /**
     * 私人FM
     */
    public static void getMyFm(DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("timestamp", System.currentTimeMillis());
        RequestCenter.getRequest(HttpConstants.PERSONAL_FM, params, listener, MyFmBean.class);
    }

    /**
     * 动态
     */
    public static void getMainEvent(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.MAIN_EVENT, null, listener, MainEventBean.class);
    }

    /**
     * 获取歌曲歌词
     */
    public static void getLyric(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.LYRIC, params, listener, LyricBean.class);
    }

    /**
     * 歌单评论
     */
    public static void getPlaylistComment(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.COMMENT_PLAYLIST, params, listener, PlayListCommentBean.class);
    }

    /**
     * 专辑评论
     */
    public static void getAlbumComment(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.COMMENT_ALBUM, params, listener, PlayListCommentBean.class);
    }

    /**
     * 电台-付费精选
     */
    public static void getRadioPaygift(int limit, int offset, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        params.put("offset", offset);
        RequestCenter.getRequest(HttpConstants.PAY_GIFT, params, listener, DjPaygiftBean.class);
    }

    public static void getRadioCategoryRecommend(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.DJ_RECOMMEND, null, listener, PlayListCommentBean.class);
    }

    /**
     * 电台分类
     */
    public static void getRadioCatelist(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.DJ_CATLIST, null, listener, DjCatelistBean.class);
    }

    /**
     * 订阅电台
     */
    public static void getSubRadio(String rid, boolean isSub, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("rid", rid);
        params.put("t", isSub ? 1 : 0);
        RequestCenter.getRequest(HttpConstants.DJ_SUB, params, listener, DjSubBean.class);
    }

    /**
     * 新晋电台榜/热门电台榜
     * type: 榜单类型, new 为新晋电台榜,hot为热门电台榜
     */
    public static void getDjToplist(String type, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        if ("new".equals(type) || "hot".equals(type)) {
            params.put("type", type);
            RequestCenter.getRequest(HttpConstants.DJ_TOPLIST, params, listener, DjTopListBean.class);
        } else {
            throw new IllegalArgumentException("type can only be new or hot");
        }

    }

    /**
     * 关注歌手
     */
    public static void getSubArtist(String rid, boolean isSub, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", rid);
        params.put("t", isSub ? 1 : 0);
        RequestCenter.getRequest(HttpConstants.ARTIST_SUB, params, listener, DjSubBean.class);
    }

    /**
     * 已经订阅的电台
     */
    public static void getSubRadioList(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.DJ_SUB_LIST, null, listener, DjSubListBean.class);
    }

    /**
     * 电台节目
     * PS.说明 : 登陆后调用此接口 , 传入rid, 可查看对应电台的电台节目以及对应的 id,
     * 需要 注意的是这个接口返回的 mp3Url 已经无效 , 都为 null, 但是通过调用 /song/url 这 个接口 ,
     * 传入节目 id 仍然能获取到节目音频 , 如 /song/url?id=478446370 获取代码时间的一个节目的音频
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * asc : 排序方式,默认为 false (新 => 老 ) 设置 true 可改为 老 => 新
     */
    public static void getRadioProgram(String rid, DisposeDataListener listener) {
        getRadioProgram(rid, false, listener);
    }

    /**
     * asc 为true
     */
    public static void getRadioProgram(String rid, boolean asc, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("rid", rid);
        params.put("asc", asc);
        RequestCenter.getRequest(HttpConstants.DJ_PROGRAM, params, listener, DjProgramBean.class);
    }

    /**
     * 电台 - 24小时主播榜
     */
    public static void getRadioTopHours(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.DJ_TOPLIST_HOURS, params, listener, DjRankListBean.class);
    }

    /**
     * 电台 - 24小时主播榜
     */
    public static void getRadioTopHours(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.DJ_TOPLIST_HOURS, null, listener, DjRankListBean.class);
    }

    /**
     * 电台 - 24小时节目榜
     */
    public static void getRadioProgramTopHours(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.DJ_PROGRAM_TOPLIST_HOURS, params, listener, DjProgramTopListHoursBean.class);
    }


    /**
     * 电台 - 24小时节目榜
     */
    public static void getRadioProgramTopHours(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.DJ_PROGRAM_TOPLIST_HOURS, null, listener, DjProgramTopListHoursBean.class);
    }

    /**
     * 电台 - 节目榜
     */
    public static void getRadioProgramTopList(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.DJ_PROGRAM_TOPLIST, params, listener, DjProgramTopListBean.class);
    }

    /**
     * 电台 - 新人榜
     */
    public static void getRadioTopNewComer(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.DJ_TOPLIST_NEWCOMER, params, listener, DjRankListBean.class);
    }

    /**
     * 电台 - 新人榜
     */
    public static void getRadioTopNewComer(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.DJ_TOPLIST_NEWCOMER, null, listener, DjRankListBean.class);
    }

    /**
     * 电台 - 最热主播榜
     */
    public static void getRadioTopPopular(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.DJ_TOPLIST_POPULAR, params, listener, DjRankListBean.class);
    }

    /**
     * 电台详情
     */
    public static void getRadioDetail(String rid, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("rid", rid);
        RequestCenter.getRequest(HttpConstants.DJ_DETAIL, params, listener, DjDetailBean.class);
    }

    /**
     * 创建歌单
     * 参数:歌单名称
     */
    public static void createPlayList(String name, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("name", name);
        RequestCenter.getRequest(HttpConstants.CREATE_PLAYLIST, params, listener, UserPlaylistBean.class);
    }

    /**
     * 删除歌单
     * 参数:歌单ID
     */
    public static void deletePlayList(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.DELETE_PLAYLIST, params, listener, CommonMessageBean.class);
    }

    /**
     * 对歌单添加或删除歌曲
     * 参数:op: 从歌单增加单曲为 add, 删除为 del
     * pid: 歌单 id
     * tracks: 歌曲 id,可多个,用逗号隔开
     */
    public static void trackPlayList(boolean add, long pid, String tracks, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("op", add ? "add" : "del");
        params.put("pid", pid);
        params.put("tracks", tracks);
        RequestCenter.getRequest(HttpConstants.PLAYLIST_TRACK, params, listener, CommonMessageBean.class);
    }

    /**
     * 关注或取消关注用户
     */
    public static void follow(String id, boolean follow, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", follow ? 1 : 2);
        RequestCenter.getRequest(HttpConstants.FOLLOW, params, listener, FollowBean.class);
    }

    /**
     * 收藏或取消收藏歌单
     */
    public static void subscribePlayList(String id, boolean sub, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", sub ? 1 : 2);
        RequestCenter.getRequest(HttpConstants.PLAYLIST_SUBSCRIBE, params, listener, CommonMessageBean.class);
    }

    /**
     * 收藏或取消收藏
     */
    public static void subscribeAlbum(String id, boolean sub, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", sub ? 1 : 2);
        RequestCenter.getRequest(HttpConstants.ALBUM_SUBSCRIBE, params, listener, CommonMessageBean.class);
    }

    /**
     * 获取视频标签列表
     */
    public static void getVideoGroup(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.VIDEO_GROUP, null, listener, VideoGroupBean.class);
    }

    /**
     * 获取视频标签下的视频
     */
    public static void getVideoTab(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        if ("9999".equals(id)) {
            getVideoRecommend(listener);
        } else {
            params.put("id", id);
            RequestCenter.getRequest(HttpConstants.VIDEO_TAB, params, listener, VideoBean.class);
        }
    }

    /**
     * 获取推荐视频
     */
    public static void getVideoRecommend(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.VIDEO_RECOMMEND, null, listener, VideoBean.class);
    }

    /**
     * 获取视频详情
     */
    public static void getVideoDetail(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.VIDEO_DETAIL, params, listener, VideoDetailBean.class);
    }

    /**
     * 收藏和取消收藏视频
     */
    public static void getVideoSub(String id, Boolean sub, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", sub ? 1 : 0);
        RequestCenter.getRequest(HttpConstants.VIDEO_SUB, params, listener, CommentLikeBean.class);
    }

    /**
     * 收藏和取消收藏MV
     */
    public static void getMvSub(String id, Boolean sub, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", sub ? 1 : 0);
        RequestCenter.getRequest(HttpConstants.MV_SUB, params, listener, CommentLikeBean.class);
    }

    /**
     * 获取MV详情
     */
    public static void getMVDetail(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("mvid", id);
        RequestCenter.getRequest(HttpConstants.MV_DETAIL, params, listener, MvInfoBean.class);
    }

    /**
     * 获取MV排行
     */
    public static void getMvTop(String area, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("area", area);
        RequestCenter.getRequest(HttpConstants.TOP_MV, params, listener, MvTopBean.class);
    }

    /**
     * 获取MV排行
     */
    public static void getMvTop(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.TOP_MV, null, listener, MvTopBean.class);
    }

    /**
     * 获取视频评论
     */
    public static void getVideoComment(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.VIDEO_COMMENT, params, listener, PlayListCommentBean.class);
    }

    /**
     * 获取MV评论
     */
    public static void getMvComment(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.MV_COMMENT, params, listener, PlayListCommentBean.class);
    }

    /**
     * 获取相关视频详情
     */
    public static void getVideoRelated(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.VIDEO_RELATED, params, listener, VideoRelatedBean.class);
    }

    /**
     * 获取视频播放地址
     */
    public static void getVideoUrl(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.VIDEO_URL, params, listener, VideoUrlBean.class);
    }

    /**
     * 获取MV播放地址
     */
    public static void getMvPlayUrl(String id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.MV_URL, params, listener, VideoUrlBean.class);
    }

    /**
     * 获取全部MV
     * area: 地区,可选值为全部,内地,港台,欧美,日本,韩国,不填则为全部
     * type: 类型,可选值为全部,官方版,原生,现场版,网易出品,不填则为全部
     * order: 排序,可选值为上升最快,最热,最新,不填则为上升最快
     * limit: 取出数量 , 默认为 30
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值 , 默认 为 0
     */
    public static void getAllMv(String area, String type, String order, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("area", area);
        params.put("order", order);
        params.put("type", type);
        //TODO 分页
        params.put("limit", 30);
        RequestCenter.getRequest(HttpConstants.MV_ALL, params, listener, MvBean.class);
    }

    /**
     * 获取最新MV
     * area: 地区,可选值为全部,内地,港台,欧美,日本,韩国,不填则为全部
     */
    public static void getFirstMv(String area, int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("area", area);
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.MV_FIRST, params, listener, MvBean.class);
    }

    /**
     * 获取私信
     */
    public static void getPrivateMsg(int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        RequestCenter.getRequest(HttpConstants.MSG_PRIVATE, params, listener, PrivateMsgBean.class);
    }

    /**
     * 获取评论
     */
    public static void getPrivateComment(int id, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("uid", id);
        RequestCenter.getRequest(HttpConstants.MSG_COMMENT, params, listener, PrivateCommentBean.class);
    }

    /**
     * 获取通知
     */
    public static void getPrivateNotice(DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        RequestCenter.getRequest(HttpConstants.MSG_NOTICE, params, listener, PrivateNoticeBean.class);
    }

    /**
     * 获取云盘数据
     */
    public static void getUserCloud(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.USER_CLOUD, null, listener, UserCloudBean.class);
    }

    /**
     * 查询歌手图片
     * eg. http://music.163.com/api/search/get/web?s=邓紫棋&type=100
     */
    public static void queryAlbumPic(String artist, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        try {
            String encode = URLEncoder.encode(artist, "utf-8");
            params.put("s", encode);
            params.put("type", "100");
            RequestCenter.getRequest(HttpConstants.ARTIST_PIC, params, listener, ArtistJson.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
