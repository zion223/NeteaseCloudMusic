package com.imooc.lib_audio.mediaplayer.core;

import android.content.Context;
import android.media.AudioManager;

public class AudioFocusManager implements AudioManager.OnAudioFocusChangeListener {

	private static final String TAG = AudioFocusManager.class.getSimpleName();

	private final AudioFocusListener mAudioFocusListener;
	private final AudioManager audioManager;

	public AudioFocusManager(Context context, AudioFocusListener listener) {
		audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		mAudioFocusListener = listener;
	}

	public boolean requestAudioFocus() {
		return audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC,
				AudioManager.AUDIOFOCUS_GAIN) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
	}

	public void abandonAudioFocus() {
		audioManager.abandonAudioFocus(this);
	}

	@Override
	public void onAudioFocusChange(int focusChange) {
		switch (focusChange) {
			// 重新获得焦点
			case AudioManager.AUDIOFOCUS_GAIN:
				if (mAudioFocusListener != null)
					mAudioFocusListener.audioFocusGrant();
				break;
			// 永久丢失焦点，如被其他播放器抢占
			case AudioManager.AUDIOFOCUS_LOSS:
				if (mAudioFocusListener != null)
					mAudioFocusListener.audioFocusLoss();
				break;
			// 短暂丢失焦点，如来电
			case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
				if (mAudioFocusListener != null)
					mAudioFocusListener.audioFocusLossTransient();
				break;
			// 瞬间丢失焦点，如通知
			case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
				if (mAudioFocusListener != null)
					mAudioFocusListener.audioFocusLossDuck();
				break;
		}
	}

	/**
	 * 音频焦点改变,接口回调，
	 */
	public interface AudioFocusListener {
		//获得焦点回调处理
		void audioFocusGrant();

		//永久失去焦点回调处理
		void audioFocusLoss();

		//短暂失去焦点回调处理
		void audioFocusLossTransient();

		//瞬间失去焦点回调
		void audioFocusLossDuck();
	}
}

