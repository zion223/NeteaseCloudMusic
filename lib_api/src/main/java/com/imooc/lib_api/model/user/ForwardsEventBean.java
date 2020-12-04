package com.imooc.lib_api.model.user;

public class ForwardsEventBean {

    private String msg;
    private UserEventBean.EventsBean event;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserEventBean.EventsBean getEvent() {
        return event;
    }

    public void setEvent(UserEventBean.EventsBean event) {
        this.event = event;
    }
}
