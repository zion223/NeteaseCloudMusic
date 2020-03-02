package com.imooc.lib_audio.mediaplayer.events;

import com.imooc.lib_audio.mediaplayer.core.AudioController;

/**
 * 播放模式切换事件
 */
public class AudioPlayModeEvent {

	private AudioController.PlayMode mPlayMode;

	public AudioPlayModeEvent(AudioController.PlayMode playMode) {
		this.mPlayMode = playMode;
	}
}
