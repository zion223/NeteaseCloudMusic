package com.imooc.imooc_voice.view.home.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.search.HotSearchDetailBean;
import com.imooc.imooc_voice.view.home.search.artist.ArtistSortDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;


import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchDelegate extends NeteaseDelegate {


    @BindView(R2.id.rv_suggest_list)
    RecyclerView mRecyclerViewSuggest;
    @BindView(R2.id.tv_search_keyword)
    EditText mEtKeywords;

    private HotSearchAdapter mAdapter;

    @Override
    public Object setLayout() {
        return R.layout.delegate_search;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

        mEtKeywords.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                   getParentDelegate().getSupportDelegate().start(SearchResultDelegate.newInstance(mEtKeywords.getText().toString()));
                    //隐藏软键盘
                    getSupportDelegate().hideSoftInput();
                }
                return false;
            }
        });


        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        RequestCenter.getSearchHotDetail(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                HotSearchDetailBean bean = (HotSearchDetailBean) responseObj;
                List<HotSearchDetailBean.DataBean> data = bean.getData();
                mAdapter = new HotSearchAdapter(data);
                mAdapter.setHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.header_suggest, null));
                mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HotSearchDetailBean.DataBean entity = (HotSearchDetailBean.DataBean) adapter.getItem(position);
                        String searchword = entity.getSearchWord();
                        getParentDelegate().getSupportDelegate().start(SearchResultDelegate.newInstance(searchword));
                    }
                });
                mRecyclerViewSuggest.setAdapter(mAdapter);
                mRecyclerViewSuggest.setLayoutManager(manager);
            }

            @Override
            public void onFailure(Object reasonObj) {
                Toast.makeText(getContext(), "加载失败",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @OnClick(R2.id.img_search_artist)
    void onClickArtistSort(){
        getParentDelegate().getSupportDelegate().start(new ArtistSortDelegate());
    }

    @OnClick(R2.id.img_suggest_back)
    void onClickBack(){
        getSupportDelegate().pop();
    }

}
