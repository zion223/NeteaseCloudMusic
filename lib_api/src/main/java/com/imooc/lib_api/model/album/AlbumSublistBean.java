package com.imooc.lib_api.model.album;


import com.imooc.lib_api.model.search.AlbumSearchBean;

import java.util.List;

public class AlbumSublistBean {


    /**
     * data : [{"subTime":1568863447079,"msg":[],"alias":["战姬绝唱SYMPHOGEAR XV 角色歌6"],"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"picId":0,"albumSize":0,"musicSize":0,"briefDesc":"","followed":false,"img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}],"picId":109951164342901890,"picUrl":"https://p1.music.126.net/68u951bt6jm-E4nCyuIuRw==/109951164342901886.jpg","name":"戦姫絶唱シンフォギアXV キャラクターソング6","id":81347636,"size":4,"transNames":[]}]
     * count : 1
     * hasMore : false
     * paidCount : 0
     * code : 200
     */

    private int count;
    private boolean hasMore;
    private int paidCount;
    private int code;
    private List<AlbumSearchBean.ResultBean.AlbumsBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(int paidCount) {
        this.paidCount = paidCount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public List<AlbumSearchBean.ResultBean.AlbumsBean> getData() {
        return data;
    }

    public void setData(List<AlbumSearchBean.ResultBean.AlbumsBean> data) {
        this.data = data;
    }
}
