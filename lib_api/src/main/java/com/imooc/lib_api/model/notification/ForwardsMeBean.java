package com.imooc.lib_api.model.notification;

import java.util.ArrayList;

public class ForwardsMeBean {
    private int code;
    private int newCount;
    private long lasttime;
    private boolean more;
    private ArrayList<ForwardsMeData> forwards;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public long getLasttime() {
        return lasttime;
    }

    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public ArrayList<ForwardsMeData> getForwards() {
        return forwards;
    }

    public void setForwards(ArrayList<ForwardsMeData> forwards) {
        this.forwards = forwards;
    }

    public static class ForwardsMeData{
        // UserEventBean.EventsBean
        private String json;
        private String time;
        private long userId;
        private long id;
        private long type;

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getType() {
            return type;
        }

        public void setType(long type) {
            this.type = type;
        }
    }
}
