package com.imooc.lib_common_ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.imooc.lib_common_ui.R;
import com.lxj.xpopup.core.CenterPopupView;

//取消订阅电台
public class UnsubscribeRadioDialog extends CenterPopupView {

    IConfirmUnsubscribeListener listener;

    public UnsubscribeRadioDialog(@NonNull Context context, IConfirmUnsubscribeListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_radio_unsubscribe;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.tv_radio_sub_cancel).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.tv_radio_sub_confirm).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onConfirm();
            }
        });
    }

    public interface IConfirmUnsubscribeListener{
        void onConfirm();
    }
}
