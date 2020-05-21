package com.imooc.lib_api.model;

public class LyricBean {
	private boolean sgc;
	private boolean sfy;
	private boolean qfy;
	private Lrc lrc;
	private Klyric klyric;
	private Tlyric tlyric;
	private int code;

	public void setSgc(boolean sgc) {
		this.sgc = sgc;
	}

	public boolean getSgc() {
		return sgc;
	}

	public void setSfy(boolean sfy) {
		this.sfy = sfy;
	}

	public boolean getSfy() {
		return sfy;
	}

	public void setQfy(boolean qfy) {
		this.qfy = qfy;
	}

	public boolean getQfy() {
		return qfy;
	}

	public void setLrc(Lrc lrc) {
		this.lrc = lrc;
	}

	public Lrc getLrc() {
		return lrc;
	}

	public void setKlyric(Klyric klyric) {
		this.klyric = klyric;
	}

	public Klyric getKlyric() {
		return klyric;
	}

	public void setTlyric(Tlyric tlyric) {
		this.tlyric = tlyric;
	}

	public Tlyric getTlyric() {
		return tlyric;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static class Lrc {

		private int version;
		private String lyric;

		public void setVersion(int version) {
			this.version = version;
		}

		public int getVersion() {
			return version;
		}

		public void setLyric(String lyric) {
			this.lyric = lyric;
		}

		public String getLyric() {
			return lyric;
		}

	}

	public static class Klyric {

		private int version;
		private String lyric;

		public void setVersion(int version) {
			this.version = version;
		}

		public int getVersion() {
			return version;
		}

		public void setLyric(String lyric) {
			this.lyric = lyric;
		}

		public String getLyric() {
			return lyric;
		}

	}

	public static class Tlyric {

		private int version;
		private String lyric;

		public void setVersion(int version) {
			this.version = version;
		}

		public int getVersion() {
			return version;
		}

		public void setLyric(String lyric) {
			this.lyric = lyric;
		}

		public String getLyric() {
			return lyric;
		}

	}

}
