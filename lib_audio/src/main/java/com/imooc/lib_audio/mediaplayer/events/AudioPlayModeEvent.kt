package com.imooc.lib_audio.mediaplayer.events

import com.imooc.lib_audio.mediaplayer.core.AudioController

/**
 * 播放模式切换事件
 */
data class AudioPlayModeEvent(var mPlayMode: AudioController.PlayMode)