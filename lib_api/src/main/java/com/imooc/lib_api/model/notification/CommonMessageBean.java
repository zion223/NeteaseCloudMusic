package com.imooc.lib_api.model.notification;

public class CommonMessageBean {

    private String id;
    private int code;
    //签到积分
    private int point;
    private String msg;
    private String message;


    public int getPoint() {
        return point;
    }

    public String getMessage() {
        return message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
