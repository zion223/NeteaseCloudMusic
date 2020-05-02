package com.imooc.imooc_voice.model.newapi;

import java.util.ArrayList;
import java.util.List;

public class MvBean {

	private int count;
	private int code;
	private boolean hasMore;
	private ArrayList<MvDetailBean> data;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public ArrayList<MvDetailBean> getData() {
		return data;
	}

	public void setData(ArrayList<MvDetailBean> data) {
		this.data = data;
	}

	public static class MvDetailBean {

		private long id;
		private String cover;
		private String name;
		private int playCount;
		private String briefDesc;
		private String desc;
		private String artistName;
		private long artistId;
		private long duration;
		private int mark;
		private boolean subed;
		private List<MvTopBean.Artists> artists;

		public void setId(long id) {
			this.id = id;
		}

		public String getId() {
			return String.valueOf(id);
		}

		public void setCover(String cover) {
			this.cover = cover;
		}

		public String getCover() {
			return cover;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setPlayCount(int playCount) {
			this.playCount = playCount;
		}

		public int getPlayCount() {
			return playCount;
		}

		public void setBriefDesc(String briefDesc) {
			this.briefDesc = briefDesc;
		}

		public String getBriefDesc() {
			return briefDesc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}

		public String getArtistName() {
			return artistName;
		}

		public void setArtistId(long artistId) {
			this.artistId = artistId;
		}

		public long getArtistId() {
			return artistId;
		}

		public void setDuration(long duration) {
			this.duration = duration;
		}

		public long getDuration() {
			return duration;
		}

		public void setMark(int mark) {
			this.mark = mark;
		}

		public int getMark() {
			return mark;
		}

		public void setSubed(boolean subed) {
			this.subed = subed;
		}

		public boolean getSubed() {
			return subed;
		}

		public void setArtists(List<MvTopBean.Artists> artists) {
			this.artists = artists;
		}

		public List<MvTopBean.Artists> getArtists() {
			return artists;
		}


	}
}
