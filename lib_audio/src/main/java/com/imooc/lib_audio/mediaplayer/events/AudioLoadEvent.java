package com.imooc.lib_audio.mediaplayer.events;

import com.imooc.lib_api.model.AudioBean;

public class AudioLoadEvent {
	public AudioBean mAudioBean;

	public AudioLoadEvent(AudioBean audioBean) {
		this.mAudioBean = audioBean;
	}
}
