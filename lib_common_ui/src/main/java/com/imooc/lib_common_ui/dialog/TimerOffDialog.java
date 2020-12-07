package com.imooc.lib_common_ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.imooc.lib_common_ui.R;
import com.imooc.lib_common_ui.utils.SharePreferenceUtil;
import com.lxj.xpopup.core.CenterPopupView;

import java.util.HashMap;
import java.util.Map;

public class TimerOffDialog extends CenterPopupView implements View.OnClickListener {

    private OnSelectTimerListener listener;
    private HashMap<Integer, Integer> checkHashmap = new HashMap<>();
    private Context mContext;
    private int originTime;
    private int time;
    private SharePreferenceUtil preferenceUtil;

    public TimerOffDialog(@NonNull Context context, OnSelectTimerListener listener) {
        super(context);
        this.listener = listener;
        this.mContext = context;
        preferenceUtil = SharePreferenceUtil.getInstance(mContext);
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        checkHashmap.put(0, R.id.iv_notimer_check);
        checkHashmap.put(10, R.id.iv_10min_check);
        checkHashmap.put(20, R.id.iv_20min_check);
        checkHashmap.put(30, R.id.iv_30min_check);
        checkHashmap.put(45, R.id.iv_45min_check);
        checkHashmap.put(60, R.id.iv_60min_check);
        findViewById(R.id.ll_notimer).setOnClickListener(this);
        findViewById(R.id.ll_10timer).setOnClickListener(this);
        findViewById(R.id.ll_20timer).setOnClickListener(this);
        findViewById(R.id.ll_30timer).setOnClickListener(this);
        findViewById(R.id.ll_45timer).setOnClickListener(this);
        findViewById(R.id.ll_60timer).setOnClickListener(this);
        time = preferenceUtil.getTimerClock();
        originTime = time;
        for (Map.Entry<Integer, Integer> entry : checkHashmap.entrySet()) {
            if (time == entry.getKey()) {
                findViewById(entry.getValue()).setVisibility(View.VISIBLE);
                break;
            }
        }
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_timer_off;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_notimer) {
            time = 0;
        } else if (id == R.id.ll_10timer) {
            time = 10;
        } else if (id == R.id.ll_20timer) {
            time = 20;
        } else if (id == R.id.ll_30timer) {
            time = 30;
        } else if (id == R.id.ll_45timer) {
            time = 45;
        } else if (id == R.id.ll_60timer) {
            time = 60;
        }
        for (Map.Entry<Integer, Integer> entry : checkHashmap.entrySet()) {
            if (time == entry.getKey()) {
                findViewById(entry.getValue()).setVisibility(View.VISIBLE);
            } else {
                findViewById(entry.getValue()).setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (originTime != time) {
            preferenceUtil.setTimerClock(time);
            listener.OnSelect(time);
        }
    }

    public interface OnSelectTimerListener {
        void OnSelect(int time);
    }
}
