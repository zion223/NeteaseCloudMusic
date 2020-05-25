package com.imooc.imooc_voice.view.discory.radio.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.song.MusicCommentBean;
import com.imooc.lib_api.model.song.PlayListCommentBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//电台主页
public class RadioInfoDelegate extends NeteaseDelegate {

    @BindView(R2.id.iv_radio_info_img)
    ImageView mIvAvatar;
    @BindView(R2.id.tv_radio_info_name)
    TextView mTvRadioName;
    @BindView(R2.id.tv_radio_info_rcmd)
    TextView mTvRadioRcmd;
    @BindView(R2.id.tv_radio_info_desc)
    TextView mTvRadioInfo;
    @BindView(R2.id.tv_radio_info_sort)
    TextView mTvRadioSort;
    @BindView(R2.id.rv_hot_comment)
    RecyclerView mRvHotComment;

    private ImageLoaderManager manager;
    private RadioHotCommentAdapter mAdapter;

    private static final String ARGS_RADIO_IMG = "ARGS_RADIO_IMG";
    private static final String ARGS_USER_ID  = "ARGS_USER_ID";
    private static final String ARGS_RADIO_NAME = "ARGS_RADIO_NAME";
    private static final String ARGS_RADIO_RCMD = "ARGS_RADIO_RCMD";
    private static final String ARGS_RADIO_INFO = "ARGS_RADIO_INFO";
    private static final String ARGS_RADIO_SORT = "ARGS_RADIO_SORT";
    private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";

    private String userId;
    private String img;
    private String name;
    private String rcmd;
    private String info;
    private String sort;
    private String radioId;

    public static RadioInfoDelegate newInstance(String userId, String img, String name, String rcmd, String info, String sort, String radioId){
        final Bundle args = new Bundle();
        args.putString(ARGS_RADIO_IMG, img);
        args.putString(ARGS_USER_ID, userId);
        args.putString(ARGS_RADIO_NAME, name);
        args.putString(ARGS_RADIO_RCMD, rcmd);
        args.putString(ARGS_RADIO_INFO, info);
        args.putString(ARGS_RADIO_SORT, sort);
        args.putString(ARGS_RADIO_ID, radioId);
        final RadioInfoDelegate delegate = new RadioInfoDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            userId = args.getString(ARGS_USER_ID);
            img = args.getString(ARGS_RADIO_IMG);
            name = args.getString(ARGS_RADIO_NAME);
            rcmd = args.getString(ARGS_RADIO_RCMD);
            info = args.getString(ARGS_RADIO_INFO);
            sort = args.getString(ARGS_RADIO_SORT);
            radioId = args.getString(ARGS_RADIO_ID);
        }
        manager = ImageLoaderManager.getInstance();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_radio_info;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
        manager.displayImageForCircle(mIvAvatar, img);
        mTvRadioName.setText(name);
        mTvRadioRcmd.setText(rcmd);
        mTvRadioInfo.setText(info);
        mTvRadioSort.setText(sort);

        //电台热门评论 TODO 无法获取
        RequestCenter.getHotComment(radioId, 4, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                PlayListCommentBean bean = (PlayListCommentBean) responseObj;
                List<MusicCommentBean.CommentsBean> hotComments = bean.getHotComments();
                mAdapter = new RadioHotCommentAdapter(hotComments);
                mRvHotComment.setAdapter(mAdapter);
                mRvHotComment.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }


    @OnClick(R2.id.iv_radio_info_img)
    void onClickUserDetail(){
        getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(userId));
    }

    static class RadioHotCommentAdapter extends BaseQuickAdapter<MusicCommentBean.CommentsBean, BaseViewHolder>{

        RadioHotCommentAdapter(@Nullable List<MusicCommentBean.CommentsBean> data) {
            super(R.layout.item_radio_hot_comment, data);
        }


        @Override
        protected void convert(BaseViewHolder helper, MusicCommentBean.CommentsBean item) {

        }
    }
}
