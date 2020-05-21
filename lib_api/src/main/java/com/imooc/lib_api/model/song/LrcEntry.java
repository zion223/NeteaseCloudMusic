package com.imooc.lib_api.model.song;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

/**
 * 一行歌词的实体类,因为要按照时间排序，所以需要实现Comparable
 * 用它来画到View上
 */
public class LrcEntry implements Comparable<LrcEntry> {
    //歌词所对应的时间
    private long time;
    //第一种语言的歌词的内容
    private String text;
    //第二种语言的歌词内容，一开始是空的，需要设置
    private String secondText;
    //StaticLayout，可以自动换行
    private StaticLayout staticLayout;
    //这一行歌词距离视图顶部的距离
    private float offset = Float.MIN_VALUE;
    //歌词的居中/左/右显示
    public static final int GRAVITY_CENTER = 0;
    public static final int GRAVITY_LEFT = 1;
    public static final int GRAVITY_RIGHT = 2;

    public LrcEntry(long time, String text) {
        this.time = time;
        this.text = text;
    }

    /**
     * 绘制时每一行都要初始化其内容、宽度、绘制格式
     */
    public void init(TextPaint paint, int width, int gravity) {
        Layout.Alignment align;
        switch (gravity) {
            case GRAVITY_LEFT:
                align = Layout.Alignment.ALIGN_NORMAL;
                break;
            default:
            case GRAVITY_CENTER:
                align = Layout.Alignment.ALIGN_CENTER;
                break;
            case GRAVITY_RIGHT:
                align = Layout.Alignment.ALIGN_OPPOSITE;
                break;
        }
        staticLayout = new StaticLayout(getShowText(), paint, width, align, 1f, 0f, false);
        offset = Float.MIN_VALUE;
    }

    public StaticLayout getStaticLayout() {
        return staticLayout;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    /**
     * 获取歌词高度
     */
    public int getHeight() {
        if (staticLayout == null) {
            return 0;
        }
        return staticLayout.getHeight();
    }

    private String getShowText() {
        if (!TextUtils.isEmpty(secondText)) {
            return text + "\n" + secondText;
        }
        return text;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }

    public String getText() {
        return text;
    }

    public String getSecondText() {
        return secondText;
    }

    public float getOffset() {
        return offset;
    }

    public long getTime() {
        return time;
    }

    /**
     * 根据歌词时间来比较大小
     */
    @Override
    public int compareTo(LrcEntry entry) {
        if (entry == null) {
            return -1;
        }
        return (int) (time - entry.getTime());
    }
}
