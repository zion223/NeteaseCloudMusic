package com.imooc.imooc_voice.api;


import com.imooc.imooc_voice.model.json.ArtistJson;
import com.imooc.imooc_voice.model.json.BillListJson;
import com.imooc.imooc_voice.model.json.FocusJson;
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
//    public static void requestFriendData(DisposeDataListener listener) {
//        RequestCenter.getRequest(HttpConstants.HOME_FRIEND, null, listener, BaseFriendModel.class);
//    }

    /**
     * 用户登陆请求
     */
    public static void login(DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("mb", "18734924592");
        params.put("pwd", "999999q");
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


}
