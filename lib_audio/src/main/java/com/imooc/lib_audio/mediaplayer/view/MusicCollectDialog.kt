package com.imooc.lib_audio.mediaplayer.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.imooc.lib_api.RequestCenter
import com.imooc.lib_api.model.CommonMessageBean
import com.imooc.lib_api.model.personal.UserPlaylistBean
import com.imooc.lib_audio.R
import com.imooc.lib_common_ui.utils.SharePreferenceUtil
import com.imooc.lib_image_loader.app.ImageLoaderManager
import com.imooc.lib_network.listener.DisposeDataListener
import com.lxj.xpopup.core.CenterPopupView

class MusicCollectDialog(context: Context, trackId: String) : CenterPopupView(context) {

    private var mContext:Context = context

    private var mTracks:String = trackId

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: PlayListAdapter

    override fun onCreate() {
        super.onCreate()
        mRecyclerView = findViewById(R.id.recycler_playlist)
        val userId:Int = SharePreferenceUtil.getInstance(mContext).userId
        RequestCenter.getUserPlaylist(userId.toLong(), object :DisposeDataListener{
            override fun onSuccess(responseObj: Any?) {
                val bean: UserPlaylistBean = responseObj as UserPlaylistBean
                val playlist:List<UserPlaylistBean.PlaylistBean> = bean.playlist
                var subIndex = 0
                for(index in 1..100){
                    if(playlist[index].creator.userId != userId.toLong()){
                        subIndex = index
                        break
                    }
                }
                //用户创建的歌单列表
                val createPlayList:List<UserPlaylistBean.PlaylistBean> = playlist.subList(0, subIndex)
                mAdapter = PlayListAdapter(createPlayList)
                mAdapter.setOnItemChildClickListener { adapter, view, position ->
                    val entity:UserPlaylistBean.PlaylistBean = adapter.getItem(position) as UserPlaylistBean.PlaylistBean
                    //收藏的歌单ID
                    val playlistId:Long = entity.id
                    RequestCenter.trackPlayList(true, playlistId, mTracks, object :DisposeDataListener{
                        override fun onSuccess(responseObj: Any?) {
                            val bean = responseObj as CommonMessageBean
                            if (bean.code == 200) {
                                Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "收藏失败或不支持收藏本地歌曲: " + bean.msg, Toast.LENGTH_SHORT).show()
                            }
                            dismiss()
                        }

                        override fun onFailure(reasonObj: Any?) {

                        }
                    })
                }
                mRecyclerView.adapter = mAdapter
                mRecyclerView.layoutManager = LinearLayoutManager(context)
            }

            override fun onFailure(reasonObj: Any?) {

            }
        })

    }

    override fun getImplLayoutId(): Int {
        return R.layout.dialog_collect_music
    }

    class PlayListAdapter(data: List<UserPlaylistBean.PlaylistBean>) : BaseQuickAdapter<UserPlaylistBean.PlaylistBean, BaseViewHolder>(R.layout.dialog_collect_music_item, data) {

        override fun convert(helper: BaseViewHolder?, item: UserPlaylistBean.PlaylistBean?) {
            helper!!.setText(R.id.tv_item_collect_content_toptext, item?.name)
            helper.setText(R.id.tv_item_collect_content_bottomtext, item?.trackCount.toString() + "首")
            ImageLoaderManager.getInstance().displayImageForCorner(helper.getView<View>(R.id.iv_item_collect_content_img) as ImageView, item!!.coverImgUrl, 5)

        }
    }
}