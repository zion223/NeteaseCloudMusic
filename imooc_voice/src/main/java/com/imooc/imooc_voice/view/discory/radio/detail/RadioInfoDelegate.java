package com.imooc.imooc_voice.view.discory.radio.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import butterknife.BindView;
import butterknife.OnClick;

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

    private ImageLoaderManager manager;

    private static final String ARGS_RADIO_IMG = "ARGS_RADIO_IMG";
    private static final String ARGS_RADIO_ID  = "ARGS_RADIO_ID";
    private static final String ARGS_RADIO_NAME = "ARGS_RADIO_NAME";
    private static final String ARGS_RADIO_RCMD = "ARGS_RADIO_RCMD";
    private static final String ARGS_RADIO_INFO = "ARGS_RADIO_INFO";
    private static final String ARGS_RADIO_SORT = "ARGS_RADIO_SORT";

    private String radioId;
    private String img;
    private String name;
    private String rcmd;
    private String info;
    private String sort;

    public static RadioInfoDelegate newInstance(String userId, String img, String name, String rcmd, String info, String sort){
        final Bundle args = new Bundle();
        args.putString(ARGS_RADIO_IMG, img);
        args.putString(ARGS_RADIO_ID, userId);
        args.putString(ARGS_RADIO_NAME, name);
        args.putString(ARGS_RADIO_RCMD, rcmd);
        args.putString(ARGS_RADIO_INFO, info);
        args.putString(ARGS_RADIO_SORT, sort);
        final RadioInfoDelegate delegate = new RadioInfoDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            radioId = args.getString(ARGS_RADIO_ID);
            img = args.getString(ARGS_RADIO_IMG);
            name = args.getString(ARGS_RADIO_NAME);
            rcmd = args.getString(ARGS_RADIO_RCMD);
            info = args.getString(ARGS_RADIO_INFO);
            sort = args.getString(ARGS_RADIO_SORT);
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
    }


    @OnClick(R2.id.iv_radio_info_img)
    void onClickUserDetail(){
        getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(radioId));
    }
}
