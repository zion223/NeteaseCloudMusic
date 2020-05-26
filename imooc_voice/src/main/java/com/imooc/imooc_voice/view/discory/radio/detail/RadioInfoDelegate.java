package com.imooc.imooc_voice.view.discory.radio.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjDetailBean;
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

    private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";

    //电台Id
    private String rid;
    //电台Dj的Id
    private String djId;

    public static RadioInfoDelegate newInstance(String rid){
        final Bundle args = new Bundle();
        args.putString(ARGS_RADIO_ID, rid);
        final RadioInfoDelegate delegate = new RadioInfoDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            rid = args.getString(ARGS_RADIO_ID);
        }
        manager = ImageLoaderManager.getInstance();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_radio_info;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
        //获取电台详情
        RequestCenter.getRadioDetail(rid, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                DjDetailBean bean = (DjDetailBean) responseObj;
                manager.displayImageForCircle(mIvAvatar, bean.getDjRadio().getDj().getAvatarUrl());
                djId = String.valueOf(bean.getDjRadio().getDj().getUserId());
                mTvRadioName.setText(bean.getDjRadio().getDj().getNickname());
                mTvRadioRcmd.setText( bean.getDjRadio().getDj().getSignature());
                mTvRadioInfo.setText(bean.getDjRadio().getDesc());
                mTvRadioSort.setText(bean.getDjRadio().getCategory());
                //热门评论数据
                mAdapter = new RadioHotCommentAdapter(RadioInfoDelegate.this, bean.getDjRadio().getCommentDatas());
                //头布局 精彩评论
                View headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_gedan_comment_header, null, false);
                mAdapter.setHeaderView(headerView);
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
        getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(djId));
    }

    static class RadioHotCommentAdapter extends BaseQuickAdapter<DjDetailBean.DjRadioBean.CommentDatasBean, BaseViewHolder>{

        private NeteaseDelegate mDelegate;

        RadioHotCommentAdapter(NeteaseDelegate delegate, @Nullable List<DjDetailBean.DjRadioBean.CommentDatasBean> data) {
            super(R.layout.item_radio_hot_comment, data);
            mDelegate = delegate;
        }


        @Override
        protected void convert(BaseViewHolder helper, DjDetailBean.DjRadioBean.CommentDatasBean item) {
            //评论者昵称
            helper.setText(R.id.tv_item_hot_comment_avatar_name, item.getUserProfile().getNickname());
            //评论者头像
            ImageLoaderManager.getInstance().displayImageForCircle(helper.getView(R.id.iv_item_hot_comment_avatar_img), item.getUserProfile().getAvatarUrl());
            //评论内容
            helper.setText(R.id.tv_item_hot_comment_content, item.getContent());
            //评论来源
            helper.setText(R.id.tv_item_hot_comment_from, item.getProgramName());
            //点击用户的头像或者用户名 进入用户详情
            helper.setOnClickListener(R.id.tv_item_hot_comment_avatar_name, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //用户详情
                    mDelegate.getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(item.getUserProfile().getUserId()));
                }
            });
            helper.setOnClickListener(R.id.iv_item_hot_comment_avatar_img, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //用户详情
                    mDelegate.getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(item.getUserProfile().getUserId()));
                }
            });
        }
    }
}
