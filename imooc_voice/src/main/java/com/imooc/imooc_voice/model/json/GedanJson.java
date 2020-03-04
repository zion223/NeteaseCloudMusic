package com.imooc.imooc_voice.model.json;

import java.util.ArrayList;
import java.util.List;

public class GedanJson {

	private int error_code;
	private int total;
	private int havemore;
	private ArrayList<GeDan> content = new ArrayList<>();

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getHavemore() {
		return havemore;
	}

	public void setHavemore(int havemore) {
		this.havemore = havemore;
	}

	public ArrayList<GeDan> getContent() {
		return content;
	}

	public void setContent(ArrayList<GeDan> content) {
		this.content = content;
	}

	public static class GeDan{
		private String listid;
		private String listenum;
		private String collectnum;
		private String title;
		private String pic_300;
		private String tag;
		private String desc;
		private String pic_W300;
		private String width;
		private String height;
		private List<String> songids;
		public void setListid(String listid) {
			this.listid = listid;
		}
		public String getListid() {
			return listid;
		}

		public void setListenum(String listenum) {
			this.listenum = listenum;
		}
		public String getListenum() {
			return listenum;
		}

		public void setCollectnum(String collectnum) {
			this.collectnum = collectnum;
		}
		public String getCollectnum() {
			return collectnum;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		public String getTitle() {
			return title;
		}

		public void setpic_300(String pic_300) {
			this.pic_300 = pic_300;
		}
		public String getpic_300() {
			return pic_300;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getTag() {
			return tag;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getDesc() {
			return desc;
		}

		public void setpic_W300(String pic_W300) {
			this.pic_W300 = pic_W300;
		}
		public String getpic_W300() {
			return pic_W300;
		}

		public void setWidth(String width) {
			this.width = width;
		}
		public String getWidth() {
			return width;
		}

		public void setHeight(String height) {
			this.height = height;
		}
		public String getHeight() {
			return height;
		}

		public void setSongids(List<String> songids) {
			this.songids = songids;
		}
		public List<String> getSongids() {
			return songids;
		}
	}
}
