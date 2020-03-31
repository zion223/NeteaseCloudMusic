package com.imooc.imooc_voice.view.home.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.event.KeywordsEvent;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class NeteaseSearchLoadingDelegate extends NeteaseLoadingDelegate {

	public RecyclerView mRecyclerView;
	private String keywords ="";
	public BaseQuickAdapter mAdapter;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		EventBus.getDefault().register(this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		frameLayout = view.findViewById(com.imooc.lib_common_ui.R.id.loadframe);
		rootView = LayoutInflater.from(getContext()).inflate(setLoadingViewLayout(), frameLayout, false);
		addLoadingView();
		EventBus.getDefault().postSticky(new KeywordsEvent(keywords));
	}


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		keywords = "";
		EventBus.getDefault().unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
	public void onGetKeywordsEvent(KeywordsEvent event){
		if(!keywords.equals(event.getKeyword())){
			keywords = event.getKeyword();
			reloadSearchResult(keywords);
			if(event.isNeedLoading()){
				addLoadingView();
			}
			//addLoadingView();
		}
	}

	@Override
	public void initView() {
		//mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);
		EventBus.getDefault().postSticky(new KeywordsEvent(keywords));
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}

	public abstract void reloadSearchResult(String keyword);






}
