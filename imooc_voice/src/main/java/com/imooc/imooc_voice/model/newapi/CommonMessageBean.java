package com.imooc.imooc_voice.model.newapi;

public class CommonMessageBean {

    private String id;
    private int code;
    private String msg;
    private String message;

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
