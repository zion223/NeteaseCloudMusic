package com.imooc.lib_audio.mediaplayer.exception;

/**
 * 播放队列为空异常
 */
public class AudioQueueEmptyException extends RuntimeException {

	public AudioQueueEmptyException(String error) {
		super(error);
	}
}
