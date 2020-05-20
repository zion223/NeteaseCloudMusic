package com.imooc.lib_audio.mediaplayer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.lib_audio.R;
import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioPlayModeEvent;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.lxj.xpopup.core.BottomPopupView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MusicListDialog extends BottomPopupView {

    private Context mContext;
    /*
     * view
     */
    private ImageView mTipView;
    private TextView mPlayModeView;
    private TextView mPlayNumView;
    private RecyclerView mRecyclerView;
    private MusicListAdapter mMusicListAdapter;
    /*
     * data
     */
    private ArrayList<AudioBean> mQueue; //播放队列
    private AudioBean mAudioBean; //当前正在播放歌曲
    private AudioController.PlayMode mPlayMode;

    MusicListDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_bottom_sheet;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initData();
        initView();
    }

    private void initData() {
        //当前播歌曲，用来初始化UI
        mQueue = AudioController.getInstance().getQueue();
        mAudioBean = AudioController.getInstance().getNowPlaying();
        mPlayMode = AudioController.getInstance().getPlayMode();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {

        mTipView = findViewById(R.id.mode_image_view);
        mPlayNumView = findViewById(R.id.num_text_view);
        mPlayNumView.setText("(" + mQueue.size() + ")");
        mPlayModeView = findViewById(R.id.mode_text_view);
        mPlayModeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用切换播放模式事件
                switch (mPlayMode) {
                    case LOOP:
                        AudioController.getInstance().setPlayMode(AudioController.PlayMode.RANDOM);
                        break;
                    case RANDOM:
                        AudioController.getInstance().setPlayMode(AudioController.PlayMode.REPEAT);
                        break;
                    case REPEAT:
                        AudioController.getInstance().setPlayMode(AudioController.PlayMode.LOOP);
                        break;
                }
            }
        });
        //更新界面
        updatePlayModeView();
        //初始化recycler
        mRecyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mMusicListAdapter = new MusicListAdapter(mQueue, mAudioBean);
        mMusicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AudioBean entity = (AudioBean) adapter.getItem(position);
                AudioController.getInstance().addAudio(entity);
            }
        });
        mRecyclerView.setAdapter(mMusicListAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);

    }

    private void updatePlayModeView() {
        switch (mPlayMode) {
            case LOOP:
                mTipView.setImageResource(R.mipmap.loop);
                mPlayModeView.setText("列表循环");
                break;
            case RANDOM:
                mTipView.setImageResource(R.mipmap.random);
                mPlayModeView.setText("随机播放");
                break;
            case REPEAT:
                mTipView.setImageResource(R.mipmap.once);
                mPlayModeView.setText("单曲循环");
                break;
        }
    }

    private void updateList() {
        mMusicListAdapter.updateAdapter(mAudioBean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioLoadEvent(AudioLoadEvent event) {
        mAudioBean = event.mAudioBean;
        //更新列表
        updateList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioPlayModeEvent(AudioPlayModeEvent event) {
        mPlayMode = event.mPlayMode;
        //更新播放模式
        updatePlayModeView();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        EventBus.getDefault().unregister(this);
    }

    static class MusicListAdapter extends BaseQuickAdapter<AudioBean, BaseViewHolder>{

        private AudioBean mCurrentBean;

        MusicListAdapter(@Nullable List<AudioBean> data, AudioBean currentBean) {
            super(R.layout.dialog_bottom_sheet_item, data);
            mCurrentBean = currentBean;
        }

        @Override
        protected void convert(BaseViewHolder helper, final AudioBean item) {
            helper.setText(R.id.item_name, item.getName());
            helper.setText(R.id.item_author, "- " + item.getAuthor());
            if(item.getId().equals(mCurrentBean.getId())){
                //当前为正在播放的音乐
                helper.setVisible(R.id.tip_view, true);
                helper.setTextColor(R.id.item_name, Color.RED);
                helper.setTextColor(R.id.item_author, Color.RED);
            }else{
                helper.setVisible(R.id.tip_view, false);
                helper.setTextColor(R.id.item_name, Color.parseColor("#333333"));
                helper.setTextColor(R.id.item_author,  Color.parseColor("#999999"));
            }
            //TODO 删除队列中歌曲
            helper.setOnClickListener(R.id.item_delete, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AudioController.getInstance().removeAudio(item);
                }
            });
        }

        void updateAdapter(AudioBean mAudioBean) {
            this.mCurrentBean = mAudioBean;
            notifyDataSetChanged();
        }
    }
}
