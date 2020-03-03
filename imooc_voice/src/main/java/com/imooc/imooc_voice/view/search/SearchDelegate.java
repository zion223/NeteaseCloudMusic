package com.imooc.imooc_voice.view.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.json.BillListJson;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;

import butterknife.BindView;

public class SearchDelegate extends NeteaseDelegate {


    @BindView(R2.id.rv_suggest_list)
    RecyclerView mRecyclerViewSuggest;


    private HotSearchAdapter mAdapter;

    @Override
    public Object setLayout() {
        return R.layout.delegate_search;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        RequestCenter.querySuggest(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                BillListJson data = (BillListJson)responseObj;
                ArrayList<BillListJson.BillList> list = data.getSong_list();
                mAdapter = new HotSearchAdapter(list);
                mRecyclerViewSuggest.setAdapter(mAdapter);
                mRecyclerViewSuggest.setLayoutManager(manager);
            }

            @Override
            public void onFailure(Object reasonObj) {
                Toast.makeText(getContext(), "加载失败",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void post(Runnable runnable) {

    }
}
