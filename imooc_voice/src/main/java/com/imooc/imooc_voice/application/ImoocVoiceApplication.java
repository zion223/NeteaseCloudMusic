package com.imooc.imooc_voice.application;

import android.app.Application;

import com.imooc.lib_audio.BuildConfig;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_share.share.ShareManager;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

public class ImoocVoiceApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.SHAKE)
                .debug(BuildConfig.DEBUG)
                // 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 建议在该回调处上传至我们的Crash监测服务器
                        // 以Bugtags为例子: 手动把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();
        AudioHelper.init(this);
        Netease.init(this)
                .configure();
        ShareManager.init(this);
    }

}
