package com.imooc.imooc_voice.view.friend.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.newapi.personal.UserEventBean;
import com.imooc.imooc_voice.model.newapi.personal.UserEventJsonBean;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends BaseQuickAdapter<UserEventBean.EventsBean, BaseViewHolder> {

    private ImageLoaderManager manager;
    private List<ImageView> imgList = new ArrayList<>();

    private ImageView ivShow1;
    private ImageView ivShow2;
    private ImageView ivShow3;
    private ImageView ivShow4;
    private ImageView ivShow5;
    private ImageView ivShow6;
    private ImageView ivShow7;
    private ImageView ivShow8;
    private ImageView ivShow9;

    public EventAdapter(@Nullable List<UserEventBean.EventsBean> data) {
        super(R.layout.item_user_event, data);
        manager = ImageLoaderManager.getInstance();
    }

    @Override
    protected void convert(@NonNull BaseViewHolder adapter, UserEventBean.EventsBean item) {
        //用户头像
        ImageView avatarView = adapter.getView(R.id.iv_avatar);
        manager.displayImageForCircle(avatarView, item.getUser().getAvatarUrl());
        adapter.setText(R.id.tv_nickname, item.getUser().getNickname());
        adapter.setText(R.id.tv_publish_time, TimeUtil.getTimeStandardOnlyYMD(item.getShowTime()));
        adapter.setText(R.id.tv_relayout_count, item.getInfo().getShareCount() == 0 ? "" : String.valueOf(item.getInfo().getShareCount()));
        adapter.setText(R.id.tv_comment_count, item.getInfo().getCommentCount() == 0 ? "" : String.valueOf(item.getInfo().getCommentCount()));
        adapter.setText(R.id.tv_like_count, item.getInfo().getLikedCount() == 0 ? "" : String.valueOf(item.getInfo().getLikedCount()));

        initImageView(adapter);

        String jsonEvnet = item.getJson();
        UserEventJsonBean userEventJsonBean = GsonUtil.fromJSON(jsonEvnet, UserEventJsonBean.class);
        if (userEventJsonBean != null) {
            Log.d(TAG, "jsonBean:" + userEventJsonBean);
            if (TextUtils.isEmpty(userEventJsonBean.getMsg())) {
                adapter.setVisible(R.id.tv_content, false);
            } else {
                adapter.setVisible(R.id.tv_content, true);
                adapter.setText(R.id.tv_content, userEventJsonBean.getMsg());
            }
            showImg(adapter, mContext, item);
            showShareLayout(adapter, mContext, userEventJsonBean);
            int type;
            if (item.getInfo().getCommentThread().getResourceInfo() == null) {
                type = item.getType();
            } else {
                type = item.getInfo().getCommentThread().getResourceInfo().getEventType();
            }

            switch (type){
                case 18:
                    adapter.setText(R.id.tv_title, "分享单曲：");
                    break;
                case 17:
                case 28:
                    adapter.setText(R.id.tv_title, "分享电台：");
                    showDjBean(userEventJsonBean);
                    break;
                case 22:
                    adapter.setText(R.id.tv_title, "转发：");
                    break;
                case 39:
                    adapter.setText(R.id.tv_title, "发布视频：");
                    showVideoBean(adapter, userEventJsonBean);
                    break;
                case 35:
                    break;
            }
        }


    }

    private void showVideoBean(@NonNull BaseViewHolder adapter, UserEventJsonBean userEventJsonBean) {
        adapter.setVisible(R.id.rl_video, true);
        adapter.setVisible(R.id.iv_vid, true);
        manager.displayImageForView((ImageView)adapter.getView(R.id.iv_vid), userEventJsonBean.getVideo().getCoverUrl());
    }

    private void initImageView(@NonNull BaseViewHolder adapter) {
        ivShow1 = adapter.getView(R.id.iv_img_1);
        ivShow2 = adapter.getView(R.id.iv_img_2);
        ivShow3 = adapter.getView(R.id.iv_img_3);
        ivShow4 = adapter.getView(R.id.iv_img_4);
        ivShow5 = adapter.getView(R.id.iv_img_5);
        ivShow6 = adapter.getView(R.id.iv_img_6);
        ivShow7 = adapter.getView(R.id.iv_img_7);
        ivShow8 = adapter.getView(R.id.iv_img_8);
        ivShow9 = adapter.getView(R.id.iv_img_9);
        imgList.add(ivShow1);
        imgList.add(ivShow2);
        imgList.add(ivShow3);
        imgList.add(ivShow4);
        imgList.add(ivShow5);
        imgList.add(ivShow6);
        imgList.add(ivShow7);
        imgList.add(ivShow8);
        imgList.add(ivShow9);
    }

    private void showDjBean(UserEventJsonBean jsonBean) {

    }



    //显示图片
    private void showImg(BaseViewHolder adapter, Context mContext, UserEventBean.EventsBean item) {
        if (item.getPics() != null || item.getPics().size() != 0) {
            adapter.setVisible(R.id.rl_img, true);
            Log.d(TAG, "size:" + item.getPics().size());
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
                //Glide.with(mContext).load(item.getPics().get(i).getRectangleUrl()).transition(new DrawableTransitionOptions().crossFade()).into(imgList.get(i));
            }
        }
    }

    //分享 layout
    private void showShareLayout(BaseViewHolder adapter, Context mContext, UserEventJsonBean jsonBean) {
        if (jsonBean != null && jsonBean.getSong() != null && !TextUtils.isEmpty(jsonBean.getSong().getName())) {
            adapter.setVisible(R.id.rl_share, true);
            manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getSong().getAlbum().getPicUrl());
            adapter.setText(R.id.tv_songname,jsonBean.getSong().getName());
            adapter.setText(R.id.tv_creator_name,jsonBean.getSong().getArtists().get(0).getName());

        } else if (jsonBean != null && jsonBean.getProgram() != null && !TextUtils.isEmpty(jsonBean.getProgram().getName())) {
            adapter.setVisible(R.id.rl_share, true);
            manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover),jsonBean.getProgram().getCoverUrl());
            adapter.setText(R.id.tv_songname,jsonBean.getSong().getName());
            adapter.setText(R.id.tv_creator_name,jsonBean.getSong().getArtists().get(0).getName());
        } else {
            adapter.setVisible(R.id.rl_share, false);
        }
    }

}
