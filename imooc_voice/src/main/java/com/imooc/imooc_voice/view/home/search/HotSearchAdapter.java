package com.imooc.imooc_voice.view.home.search;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.newapi.search.HotSearchDetailBean;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.List;

public class HotSearchAdapter extends BaseQuickAdapter<HotSearchDetailBean.DataBean, BaseViewHolder> {

    private ImageLoaderManager manager;

    HotSearchAdapter(@Nullable List<HotSearchDetailBean.DataBean> data) {
        super(R.layout.item_search_suggest, data);
        manager = ImageLoaderManager.getInstance();
    }

    @Override
    protected void convert(BaseViewHolder helper, HotSearchDetailBean.DataBean item) {
        //TODO 最后一个数据显示错误
        final TextView tvRank = helper.getView(R.id.tv_suggest_rank);
        final ImageView mIvIcon = helper.getView(R.id.iv_suggest_icon);
        if(!TextUtils.isEmpty(item.getIconUrl())){
            manager.displayImageForView(mIvIcon, item.getIconUrl());
        }
        if(helper.getLayoutPosition() <= 3){
            helper.setTypeface(R.id.tv_suggest_name, Typeface.defaultFromStyle(Typeface.BOLD));
            tvRank.setTextColor(Color.parseColor("#FF4500"));
        }
        //关键字
        helper.setText(R.id.tv_suggest_name, item.getSearchWord());
        //内容
        helper.setText(R.id.tv_suggest_artist, item.getContent());
        //搜索热度
        helper.setText(R.id.tv_suggest_hot, String.valueOf(item.getScore()));
        //排名
        helper.setText(R.id.tv_suggest_rank, String.valueOf(helper.getLayoutPosition()));

    }
}
