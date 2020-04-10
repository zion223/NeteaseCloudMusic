package com.imooc.imooc_voice.view.discory.radio.rank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;

public class RadioDjRankDelegate extends NeteaseLoadingDelegate {


    @Override
    public void initView() {

    }

    @Override
    public int setLoadingViewLayout() {
        return R.layout.delegate_radio_dj_rank;
    }
}
