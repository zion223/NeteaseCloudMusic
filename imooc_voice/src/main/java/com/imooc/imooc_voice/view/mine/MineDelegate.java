package com.imooc.imooc_voice.view.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.model.mine.SpecData;
import com.imooc.imooc_voice.view.mine.tab.TabDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineDelegate extends NeteaseDelegate {


	@BindView(R2.id.fragment_main_item_title)
	TextView mTvLocalMusic;
	@BindView(R2.id.rv_spec_mine)
	RecyclerView mSpecRecyclerView;

	private SpecAdapter mSpecAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_mine;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		List<SpecData> specData = new ArrayList<>();
		SpecData spec1 = new SpecData(R.drawable.t_dragonball_icn_carplay, "驾驶模式");
		SpecData spec2 = new SpecData(R.drawable.t_dragonball_icn_classical, "古典模式");
		SpecData spec3 = new SpecData(R.drawable.t_dragonball_icn_look, "直播");
		SpecData spec4 = new SpecData(R.drawable.t_dragonball_icn_radio, "电台");
		SpecData spec5 = new SpecData(R.drawable.t_dragonball_icn_sati, "睡眠空间");
		SpecData spec6 = new SpecData(R.drawable.t_dragonball_icn_xiaoice, "小冰电台");
		SpecData spec7 = new SpecData(R.drawable.t_dragonball_icn_rank, "排行榜");
		SpecData spec8 = new SpecData(R.drawable.t_dragonball_icn_daily, "每日推荐");
		specData.add(spec6);
		specData.add(spec7);
		specData.add(spec8);
		specData.add(spec1);
		specData.add(spec2);
		specData.add(spec3);
		specData.add(spec4);
		specData.add(spec5);
		LinearLayoutManager manager = new LinearLayoutManager(getContext());
		manager.setOrientation(LinearLayoutManager.HORIZONTAL);
		mSpecAdapter = new SpecAdapter(specData);
		mSpecRecyclerView.setAdapter(mSpecAdapter);
		mSpecRecyclerView.setLayoutManager(manager);
	}


	@OnClick(R2.id.ll_mine_local_music)
	void onClickLocalMusic(){
		getParentDelegate().getSupportDelegate().start(new TabDelegate());
	}


	@Override
	public void post(Runnable runnable) {

	}

	class SpecAdapter extends BaseQuickAdapter<SpecData, BaseViewHolder>{

		public SpecAdapter(@Nullable List<SpecData> data) {
			super(R.layout.item_mine_spec,data);
		}

		@Override
		protected void convert(BaseViewHolder helper, SpecData item) {
			((ImageView)helper.getView(R.id.iv_mine_spec)).setImageResource(item.getDrawableId());
			((TextView)helper.getView(R.id.tv_spec_name)).setText(item.getText());
		}
	}
}
