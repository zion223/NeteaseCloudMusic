package com.imooc.lib_common_ui.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

public final class Netease {

    /**
     * 全局Context对象
     * @param context
     * @return Configurator
     */
    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.CONFIG_READY.name(),context.getApplicationContext());
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context);
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    /**
     * 全局Content对象
     * @return content
     */
    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER.name());
    }


}
