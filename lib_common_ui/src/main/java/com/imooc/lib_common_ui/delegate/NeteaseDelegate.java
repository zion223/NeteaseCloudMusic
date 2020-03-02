package com.imooc.lib_common_ui.delegate;

public abstract class NeteaseDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends NeteaseDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
