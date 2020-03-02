package com.imooc.lib_common_ui.app;

import android.app.Activity;
import android.os.Handler;


import java.util.HashMap;


public class Configurator {

    public static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();
    public static final Handler HANDLER = new Handler();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
        LATTE_CONFIGS.put(ConfigType.HANDLER.name(), HANDLER);
    }
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    final HashMap<String, Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }
    private static class Holder {
        public static final Configurator INSTANCE = new Configurator();
    }
    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready ");
        }

    }
    final <T> T getConfiguration(Object key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    public final Configurator withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigType.ACTIVITY.name(), activity);
        return this;
    }
    public final Configurator withJavascriptInterface(String name) {
        LATTE_CONFIGS.put(ConfigType.JAVASCRIPT_INTERFACE.name(),name);
        return this;
    }

}
