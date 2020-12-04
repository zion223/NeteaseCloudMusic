package com.imooc.imooc_voice.view.drawer.notification;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.cloud.adapter.EventAdapter;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.lib_api.HttpConstants;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.mv.VideoUrlBean;
import com.imooc.lib_api.model.notification.ForwardsMeBean;
import com.imooc.lib_api.model.playlist.DailyRecommendBean;
import com.imooc.lib_api.model.song.AudioBean;
import com.imooc.lib_api.model.user.ForwardsEventBean;
import com.imooc.lib_api.model.user.UserEventBean;
import com.imooc.lib_api.model.user.UserEventJsonBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_common_ui.utils.GsonUtil;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.imooc.lib_video.videoplayer.CustomJzVideoView;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;

import static com.imooc.lib_common_ui.utils.Constants.ALBUM;
import static com.imooc.lib_common_ui.utils.Constants.PLAYLIST;

public class ForwardsMeDelegate extends NeteaseLoadingDelegate {

    private RecyclerView mRecyclerView;
    private ForwardsMeAdapter mAdapter;
    @Override
    public void initView() {
        mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
        // 获取@我数据
        RequestCenter.getForwardsMe(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                ForwardsMeBean bean = (ForwardsMeBean) responseObj;
                mAdapter = new ForwardsMeAdapter(ForwardsMeDelegate.this, bean.getForwards());
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mRecyclerView.setAdapter(mAdapter);
                addRootView();
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });


    }

    @Override
    public int setLoadingViewLayout() {
        return R.layout.delegate_recyclerview_normal;
    }


    private static class ForwardsMeAdapter extends BaseQuickAdapter<ForwardsMeBean.ForwardsMeData, BaseViewHolder>{
        private ImageLoaderManager manager;
        private NeteaseDelegate mDelegate;
        private List<ImageView> imgList = new ArrayList<>();

        public ForwardsMeAdapter(NeteaseDelegate delegate, @Nullable List<ForwardsMeBean.ForwardsMeData> data) {
            super(R.layout.item_forwards_me, data);
            manager = ImageLoaderManager.getInstance();
            this.mDelegate = delegate;
        }

        @Override
        protected void convert(BaseViewHolder adapter, ForwardsMeBean.ForwardsMeData item) {
            UserEventBean.EventsBean eventsBean = GsonUtil.fromJSON(item.getJson(), UserEventBean.EventsBean.class);
            ForwardsEventBean forwardsEventBean = GsonUtil.fromJSON(eventsBean.getJson(), ForwardsEventBean.class);
            UserEventJsonBean userEventJsonBean = GsonUtil.fromJSON(forwardsEventBean.getEvent().getJson(),UserEventJsonBean.class);
            //时间
            adapter.setText(R.id.forward_time, TimeUtil.getPrivateMsgTime(item.getTime()));
            // @我的人头像
            ImageLoaderManager.getInstance().displayImageForCircle(adapter.getView(R.id.forward_avater), eventsBean.getUser().getAvatarUrl());
            // @我的人昵称
            adapter.setText(R.id.forward_nickname, eventsBean.getUser().getNickname());
            // @我的人内容
            adapter.setText(R.id.forward_content, forwardsEventBean.getMsg());
            // @我的人发布@类型
            adapter.setText(R.id.forward_type, SearchUtil.getEventType(eventsBean.getType()));

            // @我的人转载的动态的内容

            if (!TextUtils.isEmpty(userEventJsonBean.getMsg())) {
                adapter.setVisible(R.id.tv_title, true);
                adapter.setText(R.id.tv_title, userEventJsonBean.getMsg());
            }

            adapter.setText(R.id.tv_nickname, "@" + forwardsEventBean.getEvent().getUser().getNickname() + ":");
            //显示图片
            //showImg(adapter, eventsBean);
            //显示分享组件的内容 歌曲、电台、歌单 、专辑等
            showShareLayout(adapter, userEventJsonBean);

        }
        //显示图片
        private void showImg(BaseViewHolder adapter, UserEventBean.EventsBean item) {

            //转换图片list集合

            final ArrayList<Object> urlList = new ArrayList<>();

            for (int i = 0; i < item.getPics().size(); i++) {
                urlList.add(item.getPics().get(i).getRectangleUrl());
            }
            if (item.getPics() != null || item.getPics().size() != 0) {
                adapter.setVisible(R.id.rl_img, true);
                for (int i = 0; i < item.getPics().size(); i++) {
                    if (i == 0) {
                        adapter.setVisible(R.id.ll_img_group1, true);
                    }
                    if (i == 3) {
                        adapter.setVisible(R.id.ll_img_group2, true);
                    }
                    if (i == 6) {
                        adapter.setVisible(R.id.ll_img_group3, true);
                    }
                    manager.displayImageForCorner(imgList.get(i), item.getPics().get(i).getRectangleUrl());
                    //每张图片的点击事件
                    ImageView imageView = imgList.get(i);


                    final int postion = i;
                    //查看大图
                    imgList.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            new XPopup.Builder(imageView.getContext()).asImageViewer(imageView, postion, urlList, new OnSrcViewUpdateListener() {
                                @Override
                                public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
                                    //RecyclerView rv = (RecyclerView) holder.itemView.getParent();
                                    //popupView.updateSrcView((ImageView)rv.getChildAt(position));
                                }
                            }, new EventAdapter.ImageLoader())
                                    .show();
                        }
                    });
                }
            }
        }

        //分享 layout
        private void showShareLayout(BaseViewHolder adapter, UserEventJsonBean jsonBean) {
            //点击播放 音乐、电台内容 查看歌单和专辑
            adapter.setOnClickListener(R.id.rl_share, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(jsonBean.getSong() != null && !TextUtils.isEmpty(jsonBean.getSong().getName())){
                        //播放歌曲
                        DailyRecommendBean.RecommendBean item = jsonBean.getSong();
                        String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
                        AudioHelper.addAudio(new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getArtists().get(0).getName(), item.getAlbum().getName(), item.getAlbum().getName(), item.getAlbum().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDuration())));
                    }else if(jsonBean.getAlbum() != null){
                        //查看专辑
                        mDelegate.getSupportDelegate().start(SongListDetailDelegate.newInstance(ALBUM, jsonBean.getAlbum().getId()));
                    }else if(jsonBean.getPlaylist() != null){
                        //查看歌单
                        mDelegate.getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, jsonBean.getPlaylist().getId()));
                    }

                }
            });

            //单曲
            if (jsonBean != null && jsonBean.getSong() != null && !TextUtils.isEmpty(jsonBean.getSong().getName())) {
                adapter.setVisible(R.id.rl_share, true);
                manager.displayImageForCorner(adapter.getView(R.id.iv_song_cover), jsonBean.getSong().getAlbum().getPicUrl());
                //单曲名
                adapter.setText(R.id.tv_songname, jsonBean.getSong().getName());
                //歌手名
                adapter.setText(R.id.tv_creator_name, jsonBean.getSong().getArtists().get(0).getName());

                //节目
            } else if (jsonBean != null && jsonBean.getProgram() != null && !TextUtils.isEmpty(jsonBean.getProgram().getName())) {
                adapter.setVisible(R.id.rl_share, true);
                manager.displayImageForCorner(adapter.getView(R.id.iv_song_cover), jsonBean.getProgram().getCoverUrl());

                adapter.setText(R.id.tv_songname, jsonBean.getProgram().getName());
                //电台名称
                adapter.setText(R.id.tv_creator_name, jsonBean.getProgram().getRadio().getName());

                //视频
            } else if (jsonBean != null && jsonBean.getVideo() != null) {
                //不显示分享
                adapter.setVisible(R.id.rl_share, false);
                CustomJzVideoView jzvdStd = adapter.getView(R.id.videoplayer);
                //视频封面
                manager.displayImageForCorner(jzvdStd.posterImageView, jsonBean.getVideo().getCoverUrl());
                //获取视频播放地址
                RequestCenter.getVideoUrl(jsonBean.getVideo().getVideoId(), new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        VideoUrlBean bean = (VideoUrlBean) responseObj;
                        //视频播放View
                        jzvdStd.setUp(bean.getUrls().get(0).getUrl(), "", Jzvd.SCREEN_NORMAL);
                    }

                    @Override
                    public void onFailure(Object reasonObj) {

                    }
                });
                adapter.setVisible(R.id.rl_video, true);
                //歌单
            } else if(jsonBean != null && jsonBean.getPlaylist() != null){
                adapter.setVisible(R.id.rl_share, true);
                manager.displayImageForCorner(adapter.getView(R.id.iv_song_cover), jsonBean.getPlaylist().getCoverImgUrl());
                //歌单名称
                adapter.setText(R.id.tv_songname, jsonBean.getPlaylist().getName());
                //歌单创建者 名称
                adapter.setText(R.id.tv_creator_name, "by " + jsonBean.getPlaylist().getCreator().getNickname());
                //专辑
            }else if(jsonBean != null && jsonBean.getAlbum() != null){
                manager.displayImageForCorner(adapter.getView(R.id.iv_song_cover), jsonBean.getAlbum().getPicUrl());
                //专辑名称
                adapter.setText(R.id.tv_songname, jsonBean.getAlbum().getName());
                //专辑的歌手
                adapter.setText(R.id.tv_creator_name, jsonBean.getAlbum().getArtist().getName());
                //专辑特有标志
                adapter.setVisible(R.id.iv_album_tag, true);

            }else{
                adapter.setVisible(R.id.rl_share, false);
            }
        }
    }
}
