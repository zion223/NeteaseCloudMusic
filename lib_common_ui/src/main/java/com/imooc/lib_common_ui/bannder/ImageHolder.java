package com.imooc.lib_common_ui.bannder;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

public class ImageHolder implements Holder<String> {

    private AppCompatImageView mImageView;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        // 更新UI 使用图片加载库加载图片文件
        ImageLoaderManager.getInstance().displayImageForCorner(mImageView, data);
    }
}
