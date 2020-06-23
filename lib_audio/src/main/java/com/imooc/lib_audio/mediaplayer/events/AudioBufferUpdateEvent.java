package com.imooc.lib_audio.mediaplayer.events;

public class AudioBufferUpdateEvent {
	public final int progress;

	public AudioBufferUpdateEvent(int progress) {
		this.progress = progress;
	}
}
