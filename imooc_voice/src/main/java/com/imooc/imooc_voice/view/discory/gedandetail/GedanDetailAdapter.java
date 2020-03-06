package com.imooc.imooc_voice.view.discory.gedandetail;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.json.GedanDetailJson;

import java.util.List;

public class GedanDetailAdapter extends BaseQuickAdapter<GedanDetailJson.GeDanDetail, BaseViewHolder> {


    public GedanDetailAdapter(@Nullable List<GedanDetailJson.GeDanDetail> data) {
        super(R.layout.item_gedan_detail_song, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GedanDetailJson.GeDanDetail item) {
        helper.setText(R.id.item_play_no, String.valueOf(helper.getAdapterPosition()));
        helper.setText(R.id.viewpager_list_toptext, item.getTitle());
        helper.setText(R.id.viewpager_list_bottom_text, item.getAuthor());
        helper.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
