package com.imooc.lib_api.model.notification;

import com.imooc.lib_api.model.user.UserEventBean;

import java.util.List;

public class PlaylistSubcribersBean {

    private long total;
    private int code;
    private boolean more;
    private List<UserEventBean.EventsBean.UserBean> subscribers;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

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

    public List<UserEventBean.EventsBean.UserBean> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<UserEventBean.EventsBean.UserBean> subscribers) {
        this.subscribers = subscribers;
    }
}
