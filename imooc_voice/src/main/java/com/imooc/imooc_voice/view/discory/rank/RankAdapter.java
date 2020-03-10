package com.imooc.imooc_voice.view.discory.rank;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.model.json.BillListJson;

import java.util.List;

public class RankAdapter extends BaseMultiItemQuickAdapter<BillListJson.BillList, BaseViewHolder> {


	public RankAdapter(List<BillListJson.BillList> data) {
		super(data);
	}

	@Override
	protected void convert(@NonNull BaseViewHolder helper, BillListJson.BillList item) {
		switch (helper.getItemViewType()){

		}
	}
}
