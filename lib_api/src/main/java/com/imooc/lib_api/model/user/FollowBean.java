package com.imooc.lib_api.model.user;


import com.imooc.lib_api.model.search.UserSearchBean;

public class FollowBean {

    private String py;
    private UserSearchBean.ResultBean.UserprofilesBean user;
    private String followTimeContent;
    private String followContent;
    private int code;

    public void setPy(String py) {
        this.py = py;
    }

    public String getPy() {
        return py;
    }

    public UserSearchBean.ResultBean.UserprofilesBean getUser() {
        return user;
    }

    public void setUser(UserSearchBean.ResultBean.UserprofilesBean user) {
        this.user = user;
    }

    public void setFollowTimeContent(String followTimeContent) {
        this.followTimeContent = followTimeContent;
    }

    public String getFollowTimeContent() {
        return followTimeContent;
    }

    public void setFollowContent(String followContent) {
        this.followContent = followContent;
    }

    public String getFollowContent() {
        return followContent;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
