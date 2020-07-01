package com.imooc.lib_audio.mediaplayer.view.adapter

import android.content.Context
import android.graphics.PointF
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class IndictorViewPager :ViewPager {

    private val pointF: PointF = PointF()
    private lateinit var listener: OnSingleTouchListener

    constructor(context: Context):super(context)

    constructor(context: Context, attr: AttributeSet):super(context, attr)


    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> {
                pointF.x = ev.x
                pointF.y = ev.y
                if(childCount > 1){
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }
            MotionEvent.ACTION_UP -> {
                if(PointF.length(ev.x - pointF.x, ev.y - pointF.y) < 5.0){
                    listener.onSingleTouch(ev)
                    return true
                }
            }
        }
        return super.onTouchEvent(ev)
    }

    fun setOnSingleTouchListener(listener: OnSingleTouchListener){
        this.listener = listener
    }

    interface OnSingleTouchListener{
        fun onSingleTouch(event: MotionEvent)
    }
}