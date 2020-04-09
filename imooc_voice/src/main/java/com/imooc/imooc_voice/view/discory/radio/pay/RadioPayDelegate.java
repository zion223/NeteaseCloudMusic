package com.imooc.imooc_voice.view.discory.radio.pay;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.dj.DjPaygiftBean;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.List;

import butterknife.BindView;

public class RadioPayDelegate extends NeteaseLoadingDelegate {


	private ImageView backView;
	private RecyclerView recyclerView;

	private RadioPayAdapter mAdapter;


	@Override
	public void initView() {
		initRadioPayView();
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_radio_pay;
	}


	@SuppressLint("StaticFieldLeak")
	private void initRadioPayView() {
		recyclerView = rootView.findViewById(R.id.rv_radio_pay_normal);
		backView = rootView.findViewById(R.id.img_radio_pay_back);
		backView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getSupportDelegate().pop();
			}
		});
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
			}

			@Override
			protected Void doInBackground(Void... voids) {
				RequestCenter.getRadioPaygift(10, 0, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						DjPaygiftBean bean = (DjPaygiftBean) responseObj;
						List<DjPaygiftBean.DataBean.ListBean> list = bean.getData().getList();
						mAdapter = new RadioPayAdapter(list);
						mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener(){
							@Override
							public void onLoadMoreRequested() {
								//加载更多接口
								//RequestCenter.getRadioPaygift();
								recyclerView.post(new Runnable() {
									@Override
									public void run() {

									}
								});
							}
						}, recyclerView);
						recyclerView.setAdapter(mAdapter);
						recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
	public void post(Runnable runnable) {

	}

	static class RadioPayAdapter extends BaseQuickAdapter<DjPaygiftBean.DataBean.ListBean, BaseViewHolder> {

		private ImageLoaderManager manager;

		RadioPayAdapter( @Nullable List<DjPaygiftBean.DataBean.ListBean> data) {
			super(R.layout.item_radio_pay_normal, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder baseViewHolder, DjPaygiftBean.DataBean.ListBean bean) {
			baseViewHolder.setText(R.id.tv_radio_pay_title, bean.getName());
			baseViewHolder.setText(R.id.tv_radio_pay_desc, bean.getRcmdText());
			baseViewHolder.setText(R.id.tv_radio_pay_price, "￥" + String.valueOf(bean.getOriginalPrice()).substring(0, String.valueOf(bean.getOriginalPrice()).length() - 2));
			manager.displayImageForCorner((ImageView)baseViewHolder.getView(R.id.iv_radio_pay_img), bean.getPicUrl(),5);
		}
	}
}
