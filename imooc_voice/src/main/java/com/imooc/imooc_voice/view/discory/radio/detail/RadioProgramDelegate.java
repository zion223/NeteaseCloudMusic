package com.imooc.imooc_voice.view.discory.radio.detail;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.DjProgramBean;
import com.imooc.lib_api.model.song.SongUrlBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

//电台节目列表
public class RadioProgramDelegate extends NeteaseLoadingDelegate {

    private RecyclerView mRecyclerView;

    private static final String ARGS_RADIO_ID = "ARGS_RADIO_ID";
    private RadioProgramAdapter mAdapter;
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
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
        super.onBindView(savedInstanceState, view);
        mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public void initView() {
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                RequestCenter.getRadioProgram(id, new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        DjProgramBean bean  = (DjProgramBean) responseObj;
                        List<DjProgramBean.ProgramsBean> programs = bean.getPrograms();
                        mAdapter = new RadioProgramAdapter(programs);
                        //播放电台节目
                        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                DjProgramBean.ProgramsBean item = (DjProgramBean.ProgramsBean) adapter.getItem(position);
                                //获取电台节目播放地址 TODO 无法获取播放地址
                                RequestCenter.getSongUrl(item.getId(), new DisposeDataListener() {
                                    @Override
                                    public void onSuccess(Object responseObj) {
                                        SongUrlBean urlBean = (SongUrlBean) responseObj;
                                        String url = urlBean.getData().get(0).getUrl();
                                        AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), url, item.getName(), item.getDj().getNickname(), item.getRadio().getName(), item.getRadio().getName(), item.getRadio().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDuration())));
                                    }

                                    @Override
                                    public void onFailure(Object reasonObj) {

                                    }
                                });

                            }
                        });
                        mRecyclerView.setAdapter(mAdapter);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        addRootView();
                    }

                    @Override
                    public void onFailure(Object reasonObj) {

                    }
                });
                return null;
            }
        }.execute();

    }

    @Override
    public int setLoadingViewLayout() {
        return R.layout.delegate_recyclerview_normal;
    }

    static class RadioProgramAdapter extends BaseQuickAdapter<DjProgramBean.ProgramsBean, BaseViewHolder> {

        RadioProgramAdapter(@Nullable List<DjProgramBean.ProgramsBean> data) {
            super(R.layout.item_radio_program, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder adapter, DjProgramBean.ProgramsBean bean) {
            //节目名称
            adapter.setText(R.id.item_radio_program_toptext, bean.getName());
            //编号
            adapter.setText(R.id.item_radio_program_no, String.valueOf(adapter.getLayoutPosition() + 1));
            //创建时间
            adapter.setText(R.id.item_radio_program_createtime, TimeUtil.getTimeStandardOnlyYMD(bean.getCreateTime()));
            //播放数量
            int listenerCount = bean.getListenerCount();
            //播放数量
            adapter.setText(R.id.item_radio_program_playnum, SearchUtil.getCorresPondingString(listenerCount));
            //节目时间
            adapter.setText(R.id.item_radio_program_duration, TimeUtil.getTimeNoYMDH(bean.getDuration()));
        }

    }
}
