package com.imooc.imooc_voice.model.newapi;


public class VideoDetailBean {

	private int code;
	private String message;
	private VideoBean.Data data;

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

	public VideoBean.Data getData() {
		return data;
	}

	public void setData(VideoBean.Data data) {
		this.data = data;
	}
}
