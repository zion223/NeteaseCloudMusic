package com.imooc.lib_audio.mediaplayer.events;

/**
 * 收藏/取消收藏事件
 */
public class AudioFavouriteEvent {
	public boolean isFavourite;

	public AudioFavouriteEvent(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}
}
