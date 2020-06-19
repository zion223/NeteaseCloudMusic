package com.imooc.lib_audio.mediaplayer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.lib_audio.R;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioPlayModeEvent;
import com.imooc.lib_audio.mediaplayer.events.AudioRemoveEvent;
import com.imooc.lib_api.model.AudioBean;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

//歌曲播放列表Dialog
public class MusicListDialog extends BottomPopupView {

    private Context mContext;
    /*
     * view
     */
    private ImageView mTipView;
    private TextView mPlayModeView;
    private TextView mPlayNumView;
    private TextView mFavouriteView;
    private RecyclerView mRecyclerView;
    private MusicListAdapter mMusicListAdapter;
    private ImageView mDeleteView;
    /*
     * data
     */
    private ArrayList<AudioBean> mQueue; //播放队列
    private AudioBean mAudioBean; //当前正在播放歌曲
    private AudioController.PlayMode mPlayMode;
    private StringBuilder tracks;

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

    @Override
    public int getAnimationDuration() {
        return 1000;
    }

    private void initData() {
        //当前播歌曲，用来初始化UI
        mQueue = AudioController.getInstance().getQueue();
        if(mQueue.size() != 0){
            mAudioBean = AudioController.getInstance().getNowPlaying();
            mPlayMode = AudioController.getInstance().getPlayMode();
        }
        //获取trackId
         tracks = new StringBuilder();

        for (int i = 0; i < mQueue.size(); i++) {
            //最后一个参数不加逗号
            if (i == mQueue.size() - 1) {
                tracks.append(mQueue.get(i).getId());
            } else {
                tracks.append(mQueue.get(i).getId()).append(",");
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void initView() {

        mTipView = findViewById(R.id.mode_image_view);
        mDeleteView = findViewById(R.id.delete_view);
        mFavouriteView = findViewById(R.id.favourite_view);

        //收藏歌曲到创建的歌单
        mFavouriteView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                new XPopup.Builder(getContext())
                        .asCustom(new MusicCollectDialog(getContext(), tracks.toString()))
                        .show();

            }
        });
        mDeleteView.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //清空播放列表 TODO 确认对话框
                AudioController.getInstance().removeAudio();
                dismiss();
            }
        });
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
        //定位当前播放的音乐的位置
        int currentPosition = mQueue.indexOf(mAudioBean);
        mMusicListAdapter = new MusicListAdapter(mQueue, mAudioBean);
        mMusicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AudioBean entity = (AudioBean) adapter.getItem(position);
                AudioHelper.addAudio(entity);
                dismiss();
            }
        });

        mRecyclerView.setAdapter(mMusicListAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //正在播放的音乐处于中间的位置
        mRecyclerView.scrollToPosition(currentPosition - 3);
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

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioRemoveEvent(AudioRemoveEvent event) {
        mQueue = AudioController.getInstance().getQueue();
        mPlayNumView.setText("(" + mQueue.size() + ")");
        mMusicListAdapter.setNewData(mQueue);
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

            helper.setOnClickListener(R.id.item_delete, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mCurrentBean == item){
                        //TODO 不可移除当前播放的歌曲
                        Toast.makeText(mContext, "不支持删除正在播放的音乐", Toast.LENGTH_SHORT).show();
                    }else{
                        AudioController.getInstance().removeAudio(item);
                    }
                }
            });
        }

        void updateAdapter(AudioBean mAudioBean) {
            this.mCurrentBean = mAudioBean;
            notifyDataSetChanged();
        }
    }
}
