package com.imooc.imooc_voice.model.mine;

public class SpecData {
	private int drawableId;
	private String text;

	public SpecData(int drawableId, String text) {
		this.drawableId = drawableId;
		this.text = text;
	}

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
