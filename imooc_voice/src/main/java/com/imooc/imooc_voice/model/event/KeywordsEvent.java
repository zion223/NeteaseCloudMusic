package com.imooc.imooc_voice.model.event;

public class KeywordsEvent {


	private String keyword;
	private boolean needLoading;

	public void setNeedLoading(boolean needLoading) {
		this.needLoading = needLoading;
	}

	public boolean isNeedLoading() {
		return needLoading;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public KeywordsEvent(String keyword) {
		this.keyword = keyword;
	}
	public KeywordsEvent(String keyword, boolean needLoading) {
		this.keyword = keyword;
		this.needLoading = needLoading;
	}

	@Override
	public String toString() {
		return "KeywordsEvent{" +
				"keyword='" + keyword + '\'' +
				'}';
	}
}
