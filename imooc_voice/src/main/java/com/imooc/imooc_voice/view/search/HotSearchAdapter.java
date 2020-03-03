package com.imooc.imooc_voice.view.search;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.json.BillListJson;

import java.util.List;

public class HotSearchAdapter extends BaseQuickAdapter<BillListJson.BillList, BaseViewHolder> {


    public HotSearchAdapter(@Nullable List<BillListJson.BillList> data) {
        super(R.layout.item_search_suggest, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BillListJson.BillList item) {
        final TextView tvArtist = helper.getView(R.id.tv_suggest_artist);
        final TextView tvHot = helper.getView(R.id.tv_suggest_hot);
        final TextView tvSong = helper.getView(R.id.tv_suggest_name);
        final TextView tvRank = helper.getView(R.id.tv_suggest_rank);
        tvSong.setText(item.getTitle());
        tvArtist.setText(item.getAuthor());
        tvHot.setText(item.getHot());
        tvRank.setText(item.getRank());

    }
}
