package com.imooc.imooc_voice.model.newapi;

public class MvInfoBean {
	private boolean subed;
	private MvBean.MvDetailBean data;
	private int code;

	public boolean isSubed() {
		return subed;
	}

	public void setSubed(boolean subed) {
		this.subed = subed;
	}

	public MvBean.MvDetailBean getData() {
		return data;
	}

	public void setData(MvBean.MvDetailBean data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
