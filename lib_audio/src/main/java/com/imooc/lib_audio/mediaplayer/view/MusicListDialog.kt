package com.imooc.lib_audio.mediaplayer.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.imooc.lib_audio.R
import com.imooc.lib_audio.app.AudioHelper.Companion.addAudio
import com.imooc.lib_audio.mediaplayer.core.AudioController
import com.imooc.lib_audio.mediaplayer.core.AudioController.PlayMode
import com.imooc.lib_audio.mediaplayer.core.AudioController.getQueue
import com.imooc.lib_audio.mediaplayer.core.AudioController.removeAudio
import com.imooc.lib_audio.mediaplayer.core.AudioController.setPlayMode
import com.imooc.lib_audio.mediaplayer.events.AudioLoadEvent
import com.imooc.lib_audio.mediaplayer.events.AudioPlayModeEvent
import com.imooc.lib_audio.mediaplayer.events.AudioRemoveEvent
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BottomPopupView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*

class MusicListDialog(context:Context) : BottomPopupView(context) {

    private var mContext = context

    /**
     * View
     */
    private lateinit var mTipView: ImageView
    private lateinit var mPlayModeView: TextView
    private lateinit var mPlayNumView: TextView
    private lateinit var mFavouriteView: TextView
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mMusicListAdapter: MusicListAdapter
    private lateinit var mDeleteView: ImageView

    /**
     * data
     */
    private var mQueue: ArrayList<AudioBean>? = null //播放队列
    private var mAudioBean: AudioBean? = null //当前正在播放歌曲
    private var mPlayMode: PlayMode? = null //播放模式
    private val tracks: StringBuilder = StringBuilder() //歌曲id

    override fun onCreate() {
        super.onCreate()
        initData()
        initView()
        EventBus.getDefault().register(this)
    }

    override fun getImplLayoutId(): Int {
        return R.layout.dialog_bottom_sheet
    }

    //动画时间
    override fun getAnimationDuration(): Int {
        return 1000
    }

    private fun initData(){
        //播放歌曲队列
        mQueue = AudioController.getQueue()
        if(mQueue != null && mQueue?.size != 0){
            mAudioBean = AudioController.getNowPlaying()
            mPlayMode = AudioController.getPlayMode()
            //获取trackId
            for(i in 0..mQueue!!.size){
                if(i == mQueue!!.size -1){
                    tracks.append(mQueue!![i].id)
                }else{
                    tracks.append(mQueue!![i].id).append(",")
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun initView(){
        mTipView = findViewById(R.id.mode_image_view);
        mDeleteView = findViewById(R.id.delete_view);
        mFavouriteView = findViewById(R.id.favourite_view);
        //收藏歌曲到歌单
        mFavouriteView.setOnClickListener {
            XPopup.Builder(context)
                    .asCustom(MusicCollectDialog(context, tracks.toString()))
                    .show()

        }
        mDeleteView.setOnClickListener {
            //清空播放列表 TODO 确认对话框
            removeAudio()
            dismiss()
        }
        mPlayNumView = findViewById(R.id.num_text_view)
        mPlayNumView.text = "(" + mQueue!!.size + ")"
        mPlayModeView = findViewById(R.id.mode_text_view)
        //切换播放模式
        mPlayModeView.setOnClickListener {
            when(mPlayMode){
                PlayMode.LOOP -> {
                    setPlayMode(PlayMode.RANDOM)
                }
                PlayMode.RANDOM -> {
                    setPlayMode(PlayMode.REPEAT)
                }
                PlayMode.REPEAT -> {
                    setPlayMode(PlayMode.LOOP)
                }
            }
        }
        //更新界面
        updatePlayModeView()
        //初始化recycler
        mRecyclerView = findViewById(R.id.recycler)
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        mMusicListAdapter = MusicListAdapter(mQueue, mAudioBean!!)
        mMusicListAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val entity = adapter.getItem(position) as AudioBean?
            addAudio(entity!!)
            dismiss()
        }
        mRecyclerView.adapter = mMusicListAdapter
        mRecyclerView.layoutManager = linearLayoutManager
    }

    private fun updatePlayModeView() {
        when (mPlayMode) {
            PlayMode.LOOP -> {
                mTipView.setImageResource(R.mipmap.loop)
                mPlayModeView.text = "列表循环"
            }
            PlayMode.RANDOM -> {
                mTipView.setImageResource(R.mipmap.random)
                mPlayModeView.text = "随机播放"
            }
            PlayMode.REPEAT -> {
                mTipView.setImageResource(R.mipmap.once)
                mPlayModeView.text = "单曲循环"
            }
        }
    }

    private fun updateList() {
        mMusicListAdapter.updateAdapter(mAudioBean!!)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioLoadEvent(event: AudioLoadEvent) {
        mAudioBean = event.bean
        //更新列表
        updateList()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioPlayModeEvent(event: AudioPlayModeEvent) {
        mPlayMode = event.mPlayMode
        //更新播放模式
        updatePlayModeView()
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAudioRemoveEvent(event: AudioRemoveEvent?) {
        mQueue = getQueue()
        mPlayNumView.text = "(" + mQueue!!.size + ")"
        mMusicListAdapter.setNewData(mQueue)
    }

    override fun dismiss() {
        super.dismiss()
        EventBus.getDefault().unregister(this)
    }

    internal class MusicListAdapter(data: List<AudioBean?>?, private var mCurrentBean: AudioBean) : BaseQuickAdapter<AudioBean, BaseViewHolder>(R.layout.dialog_bottom_sheet_item, data) {

        override fun convert(helper: BaseViewHolder, item: AudioBean) {
            helper.setText(R.id.item_name, item.name)
            helper.setText(R.id.item_author, "- " + item.author)
            if (item.id == mCurrentBean.id) {
                //当前为正在播放的音乐
                helper.setVisible(R.id.tip_view, true)
                helper.setTextColor(R.id.item_name, Color.RED)
                helper.setTextColor(R.id.item_author, Color.RED)
            } else {
                helper.setVisible(R.id.tip_view, false)
                helper.setTextColor(R.id.item_name, Color.parseColor("#333333"))
                helper.setTextColor(R.id.item_author, Color.parseColor("#999999"))
            }
            helper.setOnClickListener(R.id.item_delete) {
                if (mCurrentBean === item) {
                    //TODO 不可移除当前播放的歌曲
                    Toast.makeText(mContext, "不支持删除正在播放的音乐", Toast.LENGTH_SHORT).show()
                } else {
                    removeAudio(item)
                }
            }
        }

        fun updateAdapter(mAudioBean: AudioBean) {
            mCurrentBean = mAudioBean
            notifyDataSetChanged()
        }

    }

}