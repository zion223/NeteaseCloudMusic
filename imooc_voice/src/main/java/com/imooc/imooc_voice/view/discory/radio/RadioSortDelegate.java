package com.imooc.imooc_voice.view.discory.radio;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.dj.RadioSortEntity;
import com.imooc.lib_api.model.dj.DjCatelistBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RadioSortDelegate extends NeteaseDelegate {

	@BindView(R2.id.rv_radio_sort)
	RecyclerView mRvRadioSort;

	private RadioSortSectionAdapter mAdapter;

	private ArrayList<RadioSortEntity> entities = new ArrayList<>();

	@Override
	public Object setLayout() {
		return R.layout.delegate_radio_sort;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {
		RequestCenter.getRadioCatelist(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				DjCatelistBean bean = (DjCatelistBean) responseObj;
				List<DjCatelistBean.CategoriesBean> categories = bean.getCategories();
				entities.add(new RadioSortEntity(true, "热门分类"));
				for (int i = 0; i < 6; i++) {
					entities.add(new RadioSortEntity(categories.get(i)));
				}
				entities.add(new RadioSortEntity(true, "更多分类"));
				for (int j = 6; j < categories.size(); j++) {
					entities.add(new RadioSortEntity(categories.get(j)));
				}
				mAdapter = new RadioSortSectionAdapter(entities);
				mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
						RadioSortEntity entity = (RadioSortEntity) baseQuickAdapter.getItem(i);
						entity.t.getId();
					}
				});
				//先后顺序影响
				mRvRadioSort.setLayoutManager(new GridLayoutManager(getContext(), 2));
				mRvRadioSort.setAdapter(mAdapter);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}


	static class RadioSortSectionAdapter extends BaseSectionQuickAdapter<RadioSortEntity, BaseViewHolder> {

		public RadioSortSectionAdapter(List<RadioSortEntity> data) {
			super(R.layout.item_radio_sort_normal, R.layout.item_radio_sort_header, data);
		}

		@Override
		protected void convertHead(BaseViewHolder adapter, RadioSortEntity item) {
			adapter.setText(R.id.item_radio_header_title, item.header);
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, RadioSortEntity item) {
			adapter.setText(R.id.item_radio_sort_name, item.t.getName());
			ImageLoaderManager.getInstance().displayImageForView(adapter.getView(R.id.iv_radio_sort_img), item.t.getPic56x56Url());
		}
	}


	@OnClick(R2.id.img_radio_back)
	void onClickBack(){
		getSupportDelegate().pop();
	}
}
