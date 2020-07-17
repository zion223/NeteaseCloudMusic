package com.imooc.lib_api.model.user;

import com.imooc.lib_api.model.search.UserSearchBean;

import java.util.ArrayList;

public class UserFollowedBean {

    private int code;
    private boolean more;
    private ArrayList<UserSearchBean.ResultBean.UserprofilesBean> followeds;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public ArrayList<UserSearchBean.ResultBean.UserprofilesBean> getFolloweds() {
        return followeds;
    }

    public void setFolloweds(ArrayList<UserSearchBean.ResultBean.UserprofilesBean> followeds) {
        this.followeds = followeds;
    }
}
