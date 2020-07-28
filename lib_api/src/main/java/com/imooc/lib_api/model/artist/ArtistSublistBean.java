package com.imooc.lib_api.model.artist;


import com.imooc.lib_api.model.search.SingerSearchBean;

import java.util.List;

public class ArtistSublistBean {

    /**
     * data : [{"info":"新碟《戦姫絶唱シンフォギアXV キャラクターソング6》抢鲜上架","id":17028,"name":"水樹奈々","trans":"水树奈奈","alias":["Mizuki Nana"],"albumSize":89,"mvSize":3,"picId":109951164158292080,"picUrl":"https://p1.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg","img1v1Url":"https://p2.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg"},{"info":"","id":768306,"name":"网易云音乐","trans":null,"alias":[],"albumSize":11,"mvSize":41,"picId":2274889557915240,"picUrl":"https://p1.music.126.net/0R_1imPfGwoeT199iPa5dA==/2274889557915240.jpg","img1v1Url":"https://p2.music.126.net/0R_1imPfGwoeT199iPa5dA==/2274889557915240.jpg"}]
     * hasMore : false
     * count : 2
     * code : 200
     */

    private boolean hasMore;
    private int count;
    private int code;
    private List<SingerSearchBean.ResultBean.ArtistsBean> data;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SingerSearchBean.ResultBean.ArtistsBean> getData() {
        return data;
    }

    public void setData(List<SingerSearchBean.ResultBean.ArtistsBean> data) {
        this.data = data;
    }
}
