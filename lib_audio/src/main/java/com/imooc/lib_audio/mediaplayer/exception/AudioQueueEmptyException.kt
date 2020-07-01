package com.imooc.lib_audio.mediaplayer.exception

/**
 * 播放队列为空异常
 */
class AudioQueueEmptyException(error: String) : RuntimeException(error)