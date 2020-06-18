package com.imooc.lib_audio.mediaplayer.events

import com.imooc.lib_audio.mediaplayer.core.CustomMediaPlayer

data class AudioProgressEvent(var mStatus: CustomMediaPlayer.Status, var progress: Int, var maxLength: Int)