package com.imooc.imooc_voice.model.newapi;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.imooc.imooc_voice.model.newapi.song.MusicCommentBean;

public class PlayListCommentEntity extends SectionEntity<MusicCommentBean.CommentsBean> {

	private String count;

	public PlayListCommentEntity(boolean isHeader, String header, String count) {
		super(isHeader, header);
		this.count = count;
	}

	public PlayListCommentEntity(MusicCommentBean.CommentsBean commentsBean) {
		super(commentsBean);
	}

	public String getCount() {
		return count;
	}
}
