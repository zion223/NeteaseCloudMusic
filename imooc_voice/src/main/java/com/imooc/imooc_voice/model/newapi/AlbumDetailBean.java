package com.imooc.imooc_voice.model.newapi;

import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;

import java.util.ArrayList;

public class AlbumDetailBean {

	private int code;
	private TopListDetailBean.Album album;
	private ArrayList<SongDetailBean.SongsBean> songs;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public TopListDetailBean.Album getAlbum() {
		return album;
	}

	public void setAlbum(TopListDetailBean.Album album) {
		this.album = album;
	}

	public ArrayList<SongDetailBean.SongsBean> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<SongDetailBean.SongsBean> songs) {
		this.songs = songs;
	}
}
