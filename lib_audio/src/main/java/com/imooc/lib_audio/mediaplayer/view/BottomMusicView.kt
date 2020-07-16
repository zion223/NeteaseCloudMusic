package com.imooc.lib_audio.mediaplayer.view

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.imooc.lib_audio.R
import com.imooc.lib_audio.mediaplayer.core.AudioController
import com.imooc.lib_audio.mediaplayer.events.AudioLoadEvent
import com.imooc.lib_audio.mediaplayer.events.AudioPauseEvent
import com.imooc.lib_audio.mediaplayer.events.AudioProgressEvent
import com.imooc.lib_audio.mediaplayer.events.AudioStartEvent
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.imooc.lib_common_ui.widget.CircleProgressButton
import com.imooc.lib_image_loader.app.ImageLoaderManager
import com.lxj.xpopup.XPopup
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class BottomMusicView : RelativeLayout {

    private var mContext: Context

    /**
     * View
     */
    private lateinit var mLeftView: ImageView
    private lateinit var mTitleView: TextView
    private lateinit var mAlbumView: TextView
    private lateinit var mRightView: ImageView
    private lateinit var mPlayView: CircleProgressButton

    /**
     * data
     */
    private var mAudioBean: AudioBean? = null

    /**
     * animation
     */
    private lateinit var mRotateAnimator: ObjectAnimator

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setBackgroundColor(resources.getColor(R.color.white))
        mContext = context
        EventBus.getDefault().register(this)
        initView()
    }

    fun initView() {
        val rootView: View = LayoutInflater.from(mContext).inflate(R.layout.bottom_view, this)
        rootView.setOnClickListener {
            MusicPlayerActivity.start(mContext as Activity?)
        }
        mLeftView = rootView.findViewById(R.id.album_view)
        //旋转动画
        mRotateAnimator = ObjectAnimator.ofFloat(mRotateAnimator, View.ROTATION.name, 0f, 360f)
        mRotateAnimator.duration = 10000
        mRotateAnimator.interpolator = LinearInterpolator()
        mRotateAnimator.repeatMode = ObjectAnimator.RESTART
        mRotateAnimator.repeatCount = ObjectAnimator.INFINITE
        //相关View
        mTitleView = rootView.findViewById(R.id.audio_name_view)
        mAlbumView = rootView.findViewById(R.id.audio_album_view)
        mPlayView = rootView.findViewById(R.id.play_view)
        //切换播放和暂停
        mPlayView.setOnClickListener {
            AudioController.playOrPause()
        }
        mRightView = rootView.findViewById(R.id.show_list_view)
        mRightView.setOnClickListener {
            if (AudioController.getQueue().size != 0) {
                XPopup.Builder(context)
                        .asCustom(MusicListDialog(context))
                        .show()
            } else {
                Toast.makeText(context, "当前播放队列没有歌曲", Toast.LENGTH_SHORT).show();
            }
        }

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onAudioLoadEvent(event: AudioLoadEvent) {
        //更新当前view为load状态
        mAudioBean = event.bean;
        showLoadView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onAudioPauseEvent(event: AudioPauseEvent) {
        //更新当前view为暂停状态
        showPauseView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onAudioStartEvent(event: AudioStartEvent) {

        //更新当前view为播放状态
        showPlayView()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onAudioProgrssEvent(event: AudioProgressEvent) {
        //更新播放进度
        mPlayView.setProgressValue((event.progress as Float / event.maxLength as Float) * 100)
    }

    //播放状态View
    private fun showPlayView() {
        if (mAudioBean != null) {
            ImageLoaderManager.getInstance().displayImageForCircle(mLeftView, mAudioBean!!.albumPic);
            mTitleView.text = mAudioBean!!.name
            mAlbumView.text = mAudioBean!!.album
            mPlayView.setPlayOrPause(CircleProgressButton.Status.PLAY)
        }
    }

    //加载状态View
    private fun showLoadView() {
        //目前loading状态的UI处理与pause逻辑一样，分开为了以后好扩展
        if (mAudioBean != null) {
            mPlayView.setPlayOrPause(CircleProgressButton.Status.PLAY);
        }
        if (mRotateAnimator.isPaused) {
            mRotateAnimator.resume();
        } else {
            mRotateAnimator.start();
        }
    }

    //暂停状态
    private fun showPauseView() {
        if (mAudioBean != null) {
            mPlayView.setPlayOrPause(CircleProgressButton.Status.PAUSE)
        }
        mRotateAnimator.pause();
    }
}