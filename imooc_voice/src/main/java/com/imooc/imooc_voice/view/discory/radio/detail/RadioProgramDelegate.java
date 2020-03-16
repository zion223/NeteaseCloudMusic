package com.imooc.imooc_voice.view.discory.radio.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.dj.DjProgramBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import butterknife.BindView;

public class RadioProgramDelegate extends NeteaseDelegate {

    @BindView(R2.id.rv_delegate_normal)
    RecyclerView mRecyclerView;

    private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";
    private String id;

    static RadioProgramDelegate newInstance(String id){
        final Bundle args = new Bundle();
        args.putString(ARGS_RADIO_ID, id);
        final RadioProgramDelegate delegate = new RadioProgramDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            id = args.getString(ARGS_RADIO_ID);
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_recyclerview_normal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
        RequestCenter.getRadioProgram(id, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                DjProgramBean bean  = (DjProgramBean) responseObj;
                List<DjProgramBean.ProgramsBean> programs = bean.getPrograms();

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }

    @Override
    public void post(Runnable runnable) {

    }

    static class RadioProgramAdapter extends BaseQuickAdapter<DjProgramBean.ProgramsBean, BaseViewHolder>{

        public RadioProgramAdapter(@Nullable List<DjProgramBean.ProgramsBean> data) {
            super(R.layout.item_radio_program, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder adapter, DjProgramBean.ProgramsBean bean) {

        }
    }
}
