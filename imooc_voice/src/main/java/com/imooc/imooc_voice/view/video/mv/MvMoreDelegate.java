package com.imooc.imooc_voice.view.video.mv;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.event.RequestSuccessEvent;
import com.imooc.imooc_voice.model.newapi.MvBean;
import com.imooc.imooc_voice.model.newapi.MvMoreEntity;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.view.video.VideoDetailDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

//MV精选
public class MvMoreDelegate extends NeteaseLoadingDelegate {

	private ImageView mIvBack;
	private RecyclerView mRecyclerView;

	private MvMoreAdapter mAdapter;

	private String[] mDataArray = new String[]{"内地", "港台", "欧美", "日本", "韩国"};

	private ArrayList<MvMoreEntity> mEntities = new ArrayList<>();
	private ArrayList<MvMoreEntity> mEntities1 = new ArrayList<>();
	private ArrayList<MvMoreEntity> mEntities2 = new ArrayList<>();
	private ArrayList<MvMoreEntity> mEntities3 = new ArrayList<>();
	private ArrayList<MvMoreEntity> mEntities4 = new ArrayList<>();
	private ArrayList<MvMoreEntity> mEntities5 = new ArrayList<>();

	private int successTime = 0;

	@Override
	public void initView() {
		mRecyclerView = rootView.findViewById(R.id.rv_mv_more);
		mIvBack = rootView.findViewById(R.id.img_tab_back);
		//返回
		mIvBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getSupportDelegate().pop();
			}
		});
		for (String header : mDataArray) {
			RequestCenter.getFirstMv(header, 4, new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					MvBean bean = (MvBean) responseObj;
					ArrayList<MvBean.MvDetailBean> data = bean.getData();
					if(header.equals(mDataArray[0])){
						mEntities1.add(new MvMoreEntity(true, header));
						for (int j = 0; j < data.size(); j++) {
							mEntities1.add(new MvMoreEntity(data.get(j)));
						}
					}else if(header.equals(mDataArray[1])){
						mEntities2.add(new MvMoreEntity(true, header));
						for (int j = 0; j < data.size(); j++) {
							mEntities2.add(new MvMoreEntity(data.get(j)));
						}
					}else if(header.equals(mDataArray[2])){
						mEntities3.add(new MvMoreEntity(true, header));
						for (int j = 0; j < data.size(); j++) {
							mEntities3.add(new MvMoreEntity(data.get(j)));
						}
					}else if(header.equals(mDataArray[3])){
						mEntities4.add(new MvMoreEntity(true, header));
						for (int j = 0; j < data.size(); j++) {
							mEntities4.add(new MvMoreEntity(data.get(j)));
						}
					}else if(header.equals(mDataArray[4])){
						mEntities5.add(new MvMoreEntity(true, header));
						for (int j = 0; j < data.size(); j++) {
							mEntities5.add(new MvMoreEntity(data.get(j)));
						}
					}

					EventBus.getDefault().postSticky(new RequestSuccessEvent());

				}

				@Override
				public void onFailure(Object reasonObj) {

				}
			});
		}

	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_mv_more;
	}

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
	public void requestDataSuccess(RequestSuccessEvent event){
		successTime += 1;
		if(successTime == 5){

			mEntities.addAll(mEntities1);
			mEntities.addAll(mEntities2);
			mEntities.addAll(mEntities3);
			mEntities.addAll(mEntities4);
			mEntities.addAll(mEntities5);
			mAdapter = new MvMoreAdapter(mEntities);
			mAdapter.setOnItemChildClickListener((adapter, view, i) -> {
				MvMoreEntity entity = (MvMoreEntity) adapter.getItem(i);
				getParentDelegate().getParentDelegate().getSupportDelegate().start(VideoDetailDelegate.newInstance(entity.t.getId()));
			});
			mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
			mRecyclerView.setAdapter(mAdapter);
			addRootView();
		}
	}



	static class MvMoreAdapter extends BaseSectionQuickAdapter<MvMoreEntity, BaseViewHolder> {

		MvMoreAdapter(List<MvMoreEntity> data) {
			super(R.layout.item_mv_normal, R.layout.item_multiple_search_header, data);
		}

		@Override
		protected void convertHead(BaseViewHolder adapter, MvMoreEntity entity) {
			adapter.setText(R.id.tv_item_multiple_search_header, entity.header);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, MvMoreEntity entity) {

			adapter.setVisible(R.id.iv_play_num, false);
			adapter.setVisible(R.id.tv_item_mv_time, false);

			MvBean.MvDetailBean item = entity.t;
			//封面
			ImageLoaderManager.getInstance().displayImageForCorner(adapter.getView(R.id.iv_item_mv_cover), item.getCover());
			//MV名
			adapter.setText(R.id.tv_item_mv_name, item.getName());
			//播放次数
			adapter.setText(R.id.tv_item_mv_playnum, SearchUtil.getCorresPondingString(item.getPlayCount()));
			//歌手名
			adapter.setText(R.id.tv_item_mv_creator, item.getArtistName());

		}
	}
}
