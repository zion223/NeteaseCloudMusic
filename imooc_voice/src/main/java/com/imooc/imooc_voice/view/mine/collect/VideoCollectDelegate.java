package com.imooc.imooc_voice.view.mine.collect;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.MvSublistBean;
import com.imooc.imooc_voice.model.newapi.search.FeedSearchBean;
import com.imooc.imooc_voice.view.home.search.sort.VideoSearchDelegate;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.imooc_voice.view.video.VideoDetailDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

public class VideoCollectDelegate extends NeteaseLoadingDelegate {

	private RecyclerView mRecyclerView;
	private VideoSearchDelegate.VideoSearchAdapter mAdapter;

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_delegate_normal);

		RequestCenter.getMvSublist(new DisposeDataListener() {

			@Override
			public void onSuccess(Object responseObj) {
				MvSublistBean bean  = (MvSublistBean) responseObj;
				List<FeedSearchBean.ResultBean.VideosBean> data = bean.getData();
				mAdapter = new VideoSearchDelegate.VideoSearchAdapter(data);
				mAdapter.setOnItemClickListener((adapter, view, i) -> {
					FeedSearchBean.ResultBean.VideosBean entity = (FeedSearchBean.ResultBean.VideosBean) adapter.getItem(i);
					if(entity.getType() == 0){
						getParentDelegate().getSupportDelegate().start(MvDeatilDelegate.newInstance(entity.getVid()));
					}else{
						getParentDelegate().getSupportDelegate().start(VideoDetailDelegate.newInstance(entity.getVid()));
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
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_recyclerview_normal;
	}
}
