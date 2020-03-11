package com.imooc.imooc_voice.view.discory.square.gedandetail;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.json.GedanDetailJson;
import com.imooc.imooc_voice.model.newapi.song.SongDetailBean;

import java.util.List;

public class GedanDetailAdapter extends BaseQuickAdapter<SongDetailBean.SongsBean, BaseViewHolder> {


    private int position = 1;

    public GedanDetailAdapter(@Nullable List<SongDetailBean.SongsBean> data) {
        super(R.layout.item_gedan_detail_song, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SongDetailBean.SongsBean item) {
        helper.setText(R.id.item_play_no, String.valueOf(position));
        helper.setText(R.id.viewpager_list_toptext, item.getName());
        helper.setText(R.id.viewpager_list_bottom_text, item.getAr().get(0).getName());
        helper.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        position += 1;
    }
}
