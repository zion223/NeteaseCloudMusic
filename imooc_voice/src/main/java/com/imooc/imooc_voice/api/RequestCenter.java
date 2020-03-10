package com.imooc.imooc_voice.api;


import com.imooc.imooc_voice.model.friend.BaseFriendModel;
import com.imooc.imooc_voice.model.json.ArtistJson;
import com.imooc.imooc_voice.model.json.BillListJson;
import com.imooc.imooc_voice.model.json.FocusJson;
import com.imooc.imooc_voice.model.json.GedanDetailJson;
import com.imooc.imooc_voice.model.json.GedanJson;
import com.imooc.imooc_voice.model.user.User;
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


    /**
     *  @GET("login/cellphone")
     *     Observable<LoginBean> login(@Query("phone") String phone, @Query("password") String password);
     *
     *     @GET("logout")
     *     Observable<LogoutBean> logout();
     *
     *     @GET("banner")
     *     Observable<BannerBean> getBanner(@Query("type") String type);
     *
     *     @GET("recommend/resource")
     *     Observable<MainRecommendPlayListBean> getRecommendPlayList();
     *
     *     @GET("recommend/songs")
     *     Observable<DailyRecommendBean> getDailyRecommend();
     *
     *     @GET("toplist")
     *     Observable<TopListBean> getTopList();
     *
     *     @GET("dj/recommend")
     *     Observable<DjRecommendBean> getRadioRecommend();
     *
     *     @GET("dj/recommend/type")
     *     Observable<DjRecommendTypeBean> getDjRecommend(@Query("type") int type);
     *
     *     @GET("top/playlist")
     *     Observable<RecommendPlayListBean> getPlayList(@Query("cat") String type, @Query("limit") int limit);
     *
     *     @GET("top/playlist/highquality")
     *     Observable<HighQualityPlayListBean> getHighquality(@Query("limit") int limit, @Query("before") long before);
     *
     *     @GET("playlist/catlist")
     *     Observable<CatlistBean> getCatlist();
     *
     *     @GET("playlist/detail")
     *     Observable<PlaylistDetailBean> getPlaylistDetail(@Query("id") long id);
     *
     *     @GET("check/music")
     *     Observable<MusicCanPlayBean> getMusicCanPlay(@Query("id") long id);
     *
     *     @GET("user/playlist")
     *     Observable<UserPlaylistBean> getUserPlaylist(@Query("uid") long uid);
     *
     *     @GET("user/event")
     *     Observable<UserEventBean> getUserEvent(@Query("uid") long uid, @Query("limit") int limit, @Query("lasttime") long time);
     *
     *     @GET("user/detail")
     *     Observable<UserDetailBean> getUserDetail(@Query("uid") long uid);
     *
     *     @GET("search/hot/detail")
     *     Observable<HotSearchDetailBean> getSearchHotDetail();
     *
     *     @GET("search")
     *     Observable<SongSearchBean> getSongSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<FeedSearchBean> getFeedSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<SingerSearchBean> getSingerSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<AlbumSearchBean> getAlbumSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<PlayListSearchBean> getPlayListSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<RadioSearchBean> getRadioSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<UserSearchBean> getUserSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("search")
     *     Observable<SynthesisSearchBean> getSynthesisSearch(@Query("keywords") String keywords, @Query("type") int type);
     *
     *     @GET("artists")
     *     Observable<SingerSongSearchBean> getSingerHotSong(@Query("id") long id);
     *
     *     @GET("artist/album")
     *     Observable<SingerAblumSearchBean> getSingerAlbum(@Query("id") long id);
     *
     *     @GET("artist/desc")
     *     Observable<SingerDescriptionBean> getSingerDesc(@Query("id") long id);
     *
     *     @GET("simi/artist")
     *     Observable<SimiSingerBean> getSimiSinger(@Query("id") long id);
     *
     *     @GET("likelist")
     *     Observable<LikeListBean> getLikeList(@Query("uid") long uid);
     *
     *     @GET("song/detail")
     *     Observable<SongDetailBean> getSongDetail(@Query("ids") long ids);
     *
     *     @GET("like")
     *     Observable<LikeMusicBean> likeMusice(@Query("id") long id);
     *
     *     @GET("comment/music")
     *     Observable<MusicCommentBean> getMusicComment(@Query("id") long id);
     *
     *     @GET("comment/like")
     *     Observable<CommentLikeBean> likeComment(@Query("id") long id, @Query("cid") long cid, @Query("t") int t, @Query("type") int type);
     *
     *     @GET("playmode/intelligence/list")
     *     Observable<PlayModeIntelligenceBean> getIntelligenceList(@Query("id") long id, @Query("pid") long pid);
     *
     *     @GET("album/sublist")
     *     Observable<AlbumSublistBean> getAlbumSublist();
     *
     *     @GET("artist/sublist")
     *     Observable<ArtistSublistBean> getArtistSublist();
     *
     *     @GET("mv/sublist")
     *     Observable<MvSublistBean> getMvSublist();
     *
     *     @GET("personal_fm")
     *     Observable<MyFmBean> getMyFm();
     *
     *     @GET("event")
     *     Observable<MainEventBean> getMainEvent();
     *
     *     @GET("lyric")
     *     Observable<LyricBean> getLyric(@Query("id") long id);
     *
     *     @GET("comment/playlist")
     *     Observable<PlayListCommentBean> getPlaylistComment(@Query("id") long id);
     *
     *     @GET("dj/paygift")
     *     Observable<DjPaygiftBean> getDjPaygift(@Query("limit") int limit, @Query("offset") int offset);
     *
     *     @GET("dj/category/recommend")
     *     Observable<DjCategoryRecommendBean> getDjCategoryRecommend();
     *
     *     @GET("dj/catelist")
     *     Observable<DjCatelistBean> getDjCatelist();
     *
     *     @GET("dj/sub")
     *     Observable<DjSubBean> subDj(@Query("rid") long rid, @Query("t") int isSub);
     *
     *     @GET("dj/program")
     *     Observable<DjProgramBean> getDjProgram(@Query("rid") long rid);
     *
     *     @GET("dj/detail")
     *     Observable<DjDetailBean> getDjDetail(@Query("rid") long rid);
     */

    //根据参数发送所有post请求
    private static void getRequest(String url, RequestParams params, DisposeDataListener listener,
                                   Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandler(listener, clazz));
    }

//    public static void requestRecommandData(DisposeDataListener listener) {
//        RequestCenter.getRequest(HttpConstants.HOME_RECOMMAND, null, listener,
//                BaseRecommandModel.class);
//    }
//
//    public static void requestRecommandMore(DisposeDataListener listener) {
//        RequestCenter.getRequest(HttpConstants.HOME_RECOMMAND_MORE, null, listener,
//                BaseRecommandMoreModel.class);
//    }
//

    /**
     * 用户登陆请求
     */
    public static void login(String phone, String password, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("phone", phone);
        params.put("password", password);
        RequestCenter.getRequest(HttpConstants.LOGIN, params, listener, User.class);
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

    /**
     * 查询热搜榜
     */
    public static void querySuggest(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.Billboard.billSongList(2, 0, 20), null, listener, BillListJson.class);
    }

    /*
     * 查询发现页面轮播图
     */
    public static void queryBanner(DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.focusPic(10), null, listener, FocusJson.class);
    }

    /*
     *  查询歌单列表
     */
    public static void queryGedan(int pageNo, int pageSize, DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.GeDan.geDan(pageNo, pageSize + 1), null, listener, GedanJson.class);
    }

    /*
     *  根据标签查询歌单
     */
    public static void queryGeDanByTag(String tag, int pageNo, int pageSize, DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.GeDan.geDanByTag(tag, pageNo, pageSize +1), null, listener, GedanJson.class);
    }

    /*
     *  新歌速递
     */
    public static void queryNewSongList(int pageNo, int pageSize, DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.Song.getNewSong(pageNo, pageSize), null, listener, BillListJson.class);
    }
    /*
     *  新碟
     */
    public static void queryNewAlbumList(int pageNo, int pageSize, DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.Song.recommendAlbum(pageNo, pageSize +1), null, listener, BillListJson.class);
    }

    /*
     *  歌单详情
     */
    public static void queryGedanDetail(String id , DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.GeDan.geDanInfo(id), null, listener, GedanDetailJson.class);
    }

    /*
     *  查询榜单歌曲(3首)
     */
    public static void queryRankingSong(int type , DisposeDataListener listener){
        RequestCenter.getRequest(HttpConstants.Billboard.billSongList(type, 0, 3), null, listener, GedanDetailJson.class);
    }

    public static void requestFriendData(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_FRIEND, null, listener, BaseFriendModel.class);
    }

}
