package com.imooc.lib_common_ui.bannder;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.imooc.lib_common_ui.R;

import java.util.ArrayList;

public class BannerCreator{

    public static void setDefault(ConvenientBanner<String> convenientBanner,
								  ArrayList<String> banners,
								  OnItemClickListener listener){
        convenientBanner.setPages(new HolderCreator(), banners)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setPageTransformer(new DefaultTransformer())
                .setOnItemClickListener(listener)
                .setCanLoop(true);
    }

}
