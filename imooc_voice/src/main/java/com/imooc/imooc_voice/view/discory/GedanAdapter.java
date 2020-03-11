package com.imooc.imooc_voice.view.discory;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.json.GedanJson;
import com.imooc.imooc_voice.model.newapi.MainRecommendPlayListBean;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.List;

public class GedanAdapter extends BaseQuickAdapter<MainRecommendPlayListBean.RecommendBean, BaseViewHolder> {

	private ImageLoaderManager manager;

	public GedanAdapter(@Nullable List<MainRecommendPlayListBean.RecommendBean> data) {
		super(R.layout.item_discover_gedan, data);
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	protected void convert(BaseViewHolder helper, MainRecommendPlayListBean.RecommendBean item) {
		final ImageView geDanView = helper.getView(R.id.iv_item_discover);
		//显示圆角图片
		manager.displayImageForCorner(geDanView, item.getPicUrl(), 5);
		int playCount = item.getPlaycount();
		double playNum = (double)playCount/1000;
		helper.setText(R.id.tv_item_discover_playnum, playNum + "万");
		helper.setText(R.id.tv_item_discover_des, item.getName());
	}
}
