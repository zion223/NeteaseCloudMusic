package com.imooc.imooc_voice.api;


import com.imooc.imooc_voice.model.json.ArtistJson;
import com.imooc.imooc_voice.model.newapi.AlbumDetailBean;
import com.imooc.imooc_voice.model.newapi.AlbumSublistBean;
import com.imooc.imooc_voice.model.newapi.ArtistListBean;
import com.imooc.imooc_voice.model.newapi.ArtistSublistBean;
import com.imooc.imooc_voice.model.newapi.BannerBean;
import com.imooc.imooc_voice.model.newapi.CatlistBean;
import com.imooc.imooc_voice.model.newapi.DailyRecommendBean;
import com.imooc.imooc_voice.model.newapi.DjBannerBean;
import com.imooc.imooc_voice.model.newapi.FollowBean;
import com.imooc.imooc_voice.model.newapi.HighQualityPlayListBean;
import com.imooc.imooc_voice.model.newapi.LikeListBean;
import com.imooc.imooc_voice.model.newapi.LoginBean;
import com.imooc.imooc_voice.model.newapi.CommonMessageBean;
import com.imooc.imooc_voice.model.newapi.MainEventBean;
import com.imooc.imooc_voice.model.newapi.MainRecommendPlayListBean;
import com.imooc.imooc_voice.model.newapi.MvSublistBean;
import com.imooc.imooc_voice.model.newapi.MyFmBean;
import com.imooc.imooc_voice.model.newapi.PlayModeIntelligenceBean;
import com.imooc.imooc_voice.model.newapi.PlaylistDetailBean;
import com.imooc.imooc_voice.model.newapi.RecommendPlayListBean;
import com.imooc.imooc_voice.model.newapi.SubCountBean;
import com.imooc.imooc_voice.model.newapi.TopListBean;
import com.imooc.imooc_voice.model.newapi.TopListDetailBean;
import com.imooc.imooc_voice.model.newapi.VideoBean;
import com.imooc.imooc_voice.model.newapi.VideoGroupBean;
import com.imooc.imooc_voice.model.newapi.VideoUrlBean;
import com.imooc.imooc_voice.model.newapi.dj.DjCatelistBean;
import com.imooc.imooc_voice.model.newapi.dj.DjDetailBean;
import com.imooc.imooc_voice.model.newapi.dj.DjPaygiftBean;
import com.imooc.imooc_voice.model.newapi.dj.DjProgramBean;
import com.imooc.imooc_voice.model.newapi.dj.DjRecommendBean;
import com.imooc.imooc_voice.model.newapi.dj.DjRecommendTypeBean;
import com.imooc.imooc_voice.model.newapi.dj.DjSubBean;
import com.imooc.imooc_voice.model.newapi.dj.DjSubListBean;
import com.imooc.imooc_voice.model.newapi.manager.MusicCanPlayBean;
import com.imooc.imooc_voice.model.newapi.personal.UserDetailBean;
import com.imooc.imooc_voice.model.newapi.personal.UserEventBean;
import com.imooc.imooc_voice.model.newapi.personal.UserPlaylistBean;
import com.imooc.imooc_voice.model.newapi.search.AlbumSearchBean;
import com.imooc.imooc_voice.model.newapi.search.FeedSearchBean;
import com.imooc.imooc_voice.model.newapi.search.HotSearchDetailBean;
import com.imooc.imooc_voice.model.newapi.search.PlayListSearchBean;
import com.imooc.imooc_voice.model.newapi.search.RadioSearchBean;
import com.imooc.imooc_voice.model.newapi.search.SimiSingerBean;
import com.imooc.imooc_voice.model.newapi.search.SingerAblumSearchBean;
import com.imooc.imooc_voice.model.newapi.search.SingerDescriptionBean;
import com.imooc.imooc_voice.model.newapi.search.SingerSearchBean;
import com.imooc.imooc_voice.model.newapi.search.SingerSongSearchBean;
import com.imooc.imooc_voice.model.newapi.search.SingerVideoSearchBean;
import com.imooc.imooc_voice.model.newapi.search.SongSearchBean;
import com.imooc.imooc_voice.model.newapi.search.SynthesisSearchBean;
import com.imooc.imooc_voice.model.newapi.search.UserSearchBean;
import com.imooc.imooc_voice.model.newapi.song.CommentLikeBean;
import com.imooc.imooc_voice.model.newapi.song.LikeMusicBean;
import com.imooc.imooc_voice.model.newapi.song.LyricBean;
import com.imooc.imooc_voice.model.newapi.song.PlayListCommentBean;
import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;
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
     * 获取用户信息 , 歌单，收藏，mv, dj 数量
     */
    public static void getsubCount(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.USER_SUBCOUNT, null, listener, SubCountBean.class);
    }

    /**
     *  用户登出请求
     */
    public static void logout(DisposeDataListener listener) {

        RequestCenter.getRequest(HttpConstants.LOGOUT, null, listener, CommonMessageBean.class);
    }

    /**
     *  获取发现页面Banner
     *   PS. 0: pc 1: android 2: iphone 3: ipad
     */
    public static void getBanner(int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("type", String.valueOf(type));
        RequestCenter.getRequest(HttpConstants.BANNER, params, listener, BannerBean.class);
    }

    /**
     *  获取电台Banner
     */
    public static void getRadioBanner( DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.RADIO_BANNER, null, listener, DjBannerBean.class);
    }

    /**
     *  首页推荐歌单的ban 需要登录
     */
    public static void getRecommendPlayList(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.RECOMMAND_PLAYLIST, null, listener, MainRecommendPlayListBean.class);
    }

    /**
     *  每日推荐
     */
    public static void getDailyRecommend(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.DAILY_RECOMMAND, null, listener, DailyRecommendBean.class);
    }

    /**
     *  所有榜单
     */
    public static void getTopList(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.TOP_LIST, null, listener, TopListBean.class);
    }

    /**
     *  所有榜单内容摘要 - 排行榜页面
     */
    public static void getTopListDetail(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.TOP_LIST_DETAIL, null, listener, TopListDetailBean.class);
    }

    /**
     *  推荐电台
     */
    public static void getRadioRecommend(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.RADIO_RECOMMEND, null, listener, DjRecommendBean.class);
    }

    /**
     *  电台 分类推荐
     *      PS. type: 电台类型 , 数字 , 可通过/dj/catelist获取 , 对应关系为 id 对应 此接口的 type, name 对应类型
     */
    public static void getRadioRecommend(int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("type", String.valueOf(type));
        RequestCenter.getRequest(HttpConstants.DJ_RECOMMEND_TYPE, params, listener, DjRecommendTypeBean.class);
    }

    /**
     *  歌单模块
     */
    public static void getPlayList(String type, int limit, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("cat", type);
        params.put("limit", String.valueOf(limit));
        RequestCenter.getRequest(HttpConstants.RECOMMEND_PLAY_LIST, params, listener, RecommendPlayListBean.class);
    }

    /**
     *  获取精品歌单
     */
    public static void getHighquality(int limit, long before, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        params.put("before", before);
        RequestCenter.getRequest(HttpConstants.RECOMMEND_PLAY_LIST_HIGHQUALITY, params, listener, HighQualityPlayListBean.class);
    }

    public static void getCatList(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.CAT_LIST, null, listener, CatlistBean.class);
    }

    /**
     *  歌单详情
     */
    public static void getPlaylistDetail(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.PLAY_LIST_DETAIL, params, listener, PlaylistDetailBean.class);
    }

    /**
     *  专辑详情
     */
    public static void getAlbumDetail(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.ALBUM_DETAIL, params, listener, AlbumDetailBean.class);
    }
    /**
     *  音乐是否可用
     */
    public static void getMusicCanPlay(long id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.MUSIC_CAN_PLAY, params, listener, MusicCanPlayBean.class);
    }

    /**
     *  用户的歌单 创建的歌单和收藏的歌单
     */
    public static void getUserPlaylist(long uid, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        RequestCenter.getRequest(HttpConstants.USER_PLAY_LIST, params, listener, UserPlaylistBean.class);
    }

    /**
     *  用户动态 lasttime默认-1
     */
    public static void getUserEvent(String uid, int limit, long time, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        params.put("limit", limit);
        params.put("lasttime", time);
        RequestCenter.getRequest(HttpConstants.USER_EVENT, params, listener, UserEventBean.class);
    }

    /**
     *   用户动态
     */
    public static void getUserEvent(String uid, DisposeDataListener listener){
        getUserEvent(uid,30,-1, listener);
    }

    /**
     *  用户详情
     */
    public static void getUserDetail(String uid, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("uid", uid);
        RequestCenter.getRequest(HttpConstants.USER_DETAIL, params, listener, UserDetailBean.class);
    }

    /**
     *  热搜列表 详细
     */
    public static void getSearchHotDetail(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.SEARCH_HOT, null, listener, HotSearchDetailBean.class);
    }

    /**
     *  搜索
     *      PS.type: 搜索类型；默认为 1 即单曲 , 取值意义 :
     *      1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单,
     *      1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台,
     *      1014: 视频, 1018:综合
     */
    public static void getSongSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, SongSearchBean.class);
    }

    public static void getAlbumSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 10);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, AlbumSearchBean.class);
    }

    public static void getSingerSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 100);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, SingerSearchBean.class);
    }

    public static void getPlayListSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1000);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, PlayListSearchBean.class);
    }

    public static void getUserSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1002);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, UserSearchBean.class);
    }

    public static void getVideoSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1014);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, FeedSearchBean.class);
    }

    public static void getRadioSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1009);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, RadioSearchBean.class);
    }

    public static void getSynthesisSearch(String keywords, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("keywords", keywords);
        params.put("type", 1018);
        RequestCenter.getRequest(HttpConstants.SEARCH, params, listener, SynthesisSearchBean.class);
    }

    /**
     *  歌手分类
     *   PS.入驻歌手 5001
     *  华语男歌手 1001 华语女歌手 1002 华语组合/乐队 1003
     *  欧美男歌手 2001 欧美女歌手 2002 欧美组合/乐队 2003
     *  日本男歌手 6001 日本女歌手 6002 日本组合/乐队 6003
     *  韩国男歌手 7001 韩国女歌手 7002 韩国组合/乐队 7003
     *  其他男歌手 4001 其他女歌手 4002 其他组合/乐队 4003
     *
     */
    public static void getSingerList(String type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("cat", type);
        RequestCenter.getRequest(HttpConstants.SINGER_LIST, params, listener, ArtistListBean.class);
    }

    /**
     *  获取热门歌手
     */
    public static void getHotSingerList(DisposeDataListener listener){
        RequestParams params = new RequestParams();
        RequestCenter.getRequest(HttpConstants.HOT_SINGER, params, listener, ArtistListBean.class);
    }

    /**
     *  获取歌手单曲 部分歌手简介
     */
    public static void getSingerInfo(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_HOT_SONG, params, listener, SingerSongSearchBean.class);
    }

    /**
     *  歌手专辑
     */
    public static void getSingerAlbum(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_ALBUM, params, listener, SingerAblumSearchBean.class);
    }

    /**
     *  歌手视频
     */
    public static void getSingerVideo(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_VIDEO, params, listener, SingerVideoSearchBean.class);
    }
    /**
     *  歌手描述
     */
    public static void getSingerDesc(long id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_DESC, params, listener, SingerDescriptionBean.class);
    }

    /**
     *  相似歌手
     */
    public static void getSimiSinger(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.SINGER_SIMI, params, listener, SimiSingerBean.class);
    }

    /**
     *  喜欢音乐列表
     */
    public static void getLikeList(long id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.LIKE_LIST, params, listener, LikeListBean.class);
    }

    /**
     * 获取歌曲详情
     *  PS.调用此接口 , 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情(注意:歌曲封面现在需要通过专辑内容接口获取)
     */
    public static void getSongDetail(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("ids", id);
        RequestCenter.getRequest(HttpConstants.SONG_DETAIL, params, listener, SongDetailBean.class);
    }

    /**
     *  喜欢音乐
     */
    public static void getlikeMusic(long id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.LIKE_MUSIC, params, listener, LikeMusicBean.class);
    }

    /**
     *  歌曲评论
     */
    public static void getMusicComment(long id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.MUSIC_COMMENT, params, listener, LikeMusicBean.class);
    }

    /**
     *  给评论点赞
     *  id : 资源 id, 如歌曲 id, mv id
     *  cid : 评论 id
     *  t : 是否点赞 ,1 为点赞 ,0 为取消点赞
     *  tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     *  0: 歌曲   1: mv 2: 歌单 3: 专辑 4: 电台 5: 视频 6: 动态
     *
     */
    public static void getlikeComment(String id, long cid, int t, int type, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("cid", cid);
        params.put("t", t);
        params.put("type", type);
        RequestCenter.getRequest(HttpConstants.COMMENT_LIKE, params, listener, CommentLikeBean.class);
    }

    /**
     *  心动模式
     *  pid : 歌单 id
     *  可选参数 : sid : 要开始播放的歌曲的 id
     */
    public static void getIntelligenceList(long id, long pid, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("pid", pid);
        RequestCenter.getRequest(HttpConstants.INTELLIGANCE_LIST, params, listener, PlayModeIntelligenceBean.class);
    }

    /**
     * 获取已收藏专辑列表
     */
    public static void getAlbumSublist(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.ALBUM_SUBLIST, null, listener, AlbumSublistBean.class);
    }

    /**
     *  收藏的歌手列表
     */
    public static void getArtistSublist(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.ARTIST_SUBLIST, null, listener, ArtistSublistBean.class);
    }

    /**
     *  收藏的MV
     */
    public static void getMvSublist(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.MV_SUBLIST, null, listener, MvSublistBean.class);
    }

    /**
     * 私人FM
     */
    public static void getMyFm(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.PERSONAL_FM, null, listener, MyFmBean.class);
    }

    /**
     *  动态
     */
    public static void getMainEvent(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.MAIN_EVENT, null, listener, MainEventBean.class);
    }

    public static void getLyric(long id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.LYRIC, params, listener, LyricBean.class);
    }

    /**
     *  歌单评论
     */
    public static void getPlaylistComment(String id, DisposeDataListener listener){
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
     *  电台-付费精选
     */
    public static void getRadioPaygift(int limit, int offset, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("limit", limit);
        params.put("offset", offset);
        RequestCenter.getRequest(HttpConstants.PAY_GIFT, params, listener, DjPaygiftBean.class);
    }

    public static void getRadioCategoryRecommend(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.DJ_RECOMMEND, null, listener, PlayListCommentBean.class);
    }

    /**
     *  电台分类
     */
    public static void getRadioCatelist(DisposeDataListener listener){

        RequestCenter.getRequest(HttpConstants.DJ_CATLIST, null, listener, DjCatelistBean.class);
    }

    /**
     *  订阅电台
     */
    public static void getSubRadio(String rid, boolean isSub, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("rid", rid);
        params.put("t", isSub ? 1:0);
        RequestCenter.getRequest(HttpConstants.DJ_SUB, params, listener, DjSubBean.class);
    }

    /**
     *  关注歌手
     */
    public static void getSubArtist(String rid, boolean isSub, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", rid);
        params.put("t", isSub ? 1:0);
        RequestCenter.getRequest(HttpConstants.ARTIST_SUB, params, listener, DjSubBean.class);
    }

    /**
     *  已经订阅的电台
     */
    public static void getSubRadioList(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.DJ_SUB_LIST, null, listener, DjSubListBean.class);
    }
    /**
     *  电台节目
     *  PS.说明 : 登陆后调用此接口 , 传入rid, 可查看对应电台的电台节目以及对应的 id,
     *  需要 注意的是这个接口返回的 mp3Url 已经无效 , 都为 null, 但是通过调用 /song/url 这 个接口 ,
     *  传入节目 id 仍然能获取到节目音频 , 如 /song/url?id=478446370 获取代码时间的一个节目的音频
     *   limit : 返回数量 , 默认为 30
     *   offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     *   asc : 排序方式,默认为 false (新 => 老 ) 设置 true 可改为 老 => 新
     */
    public static void getRadioProgram(String rid, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("rid", rid);
        RequestCenter.getRequest(HttpConstants.DJ_PROGRAM, params, listener, DjProgramBean.class);
    }

    /**
     *  电台详情
     */
    public static void getRadioDetail(String rid, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("rid", rid);
        RequestCenter.getRequest(HttpConstants.DJ_DETAIL, params, listener, DjDetailBean.class);
    }

    /**
     *  创建歌单
     *      参数:歌单名称
     */
    public static void createPlayList(String name, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("name", name);
        RequestCenter.getRequest(HttpConstants.CREATE_PLAYLIST, params, listener, UserPlaylistBean.class);
    }

    /**
     *  删除歌单
     *      参数:歌单ID
     */
    public static void deletePlayList(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.DELETE_PLAYLIST, params, listener, CommonMessageBean.class);
    }

    /**
     *  关注或取消关注用户
     */
    public static void follow(String id, boolean follow, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", follow ? 1 : 2);
        RequestCenter.getRequest(HttpConstants.FOLLOW, params, listener, FollowBean.class);
    }
    /**
     *  收藏或取消收藏
     *
     */
    public static void subscribePlayList(String id, boolean sub, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("t", sub ? 1 : 2);
        RequestCenter.getRequest(HttpConstants.PLAYLIST_SUBSCRIBE, params, listener, CommonMessageBean.class);
    }

    /**
     *  获取视频标签列表
     */
    public static void getVideoGroup(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.VIDEO_GROUP, null, listener, VideoGroupBean.class);
    }

    /**
     *  获取视频标签下的视频
     */
    public static void getVideoTab(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.VIDEO_TAB, params, listener, VideoBean.class);
    }

    /**
     *  获取视频标签下的视频
     */
    public static void getVideoUrl(String id, DisposeDataListener listener){
        RequestParams params = new RequestParams();
        params.put("id", id);
        RequestCenter.getRequest(HttpConstants.VIDEO_URL, params, listener, VideoUrlBean.class);
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
