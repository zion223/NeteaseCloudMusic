package com.imooc.imooc_voice.view.home.search;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.json.BillListJson;

import java.util.List;
import java.util.Random;

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
        //hot图标
        final ImageView ivHot = helper.getView(R.id.iv_suggest_hot);
        //向上图标
        final ImageView ivUp = helper.getView(R.id.iv_suggest_up);
        if(item.getRank().equals("1") || item.getRank().equals("2")  || item.getRank().equals("3") ){
            tvRank.setTextColor(Color.parseColor("#FF4500"));
            tvRank.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
        if(new Random().nextInt(3) == 2){
            ivHot.setVisibility(View.VISIBLE);
        }
        tvSong.setText(item.getTitle());
        tvArtist.setText(item.getAuthor());
        tvHot.setText(item.getHot());
        tvRank.setText(item.getRank());

    }
}
