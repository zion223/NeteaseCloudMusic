package com.imooc.lib_api.model.mv;


import com.imooc.lib_api.model.search.FeedSearchBean;

import java.util.ArrayList;

public class VideoRelatedBean {

    private int code;
    private String message;
    private ArrayList<FeedSearchBean.ResultBean.VideosBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<FeedSearchBean.ResultBean.VideosBean> getData() {
        return data;
    }

    public void setData(ArrayList<FeedSearchBean.ResultBean.VideosBean> data) {
        this.data = data;
    }


}
