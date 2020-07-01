package com.imooc.lib_audio.mediaplayer.view.adapter

import android.animation.ObjectAnimator
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.imooc.lib_audio.R
import com.imooc.lib_audio.mediaplayer.core.AudioController
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.imooc.lib_image_loader.app.ImageLoaderManager

class MusicPagerAdapter(queue: ArrayList<AudioBean>, context: Context) : PagerAdapter() {

    private var mData: ArrayList<AudioBean> = queue
    private var mContext: Context = context

    private val mAnims: SparseArray<ObjectAnimator> = SparseArray()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val rootView: View = LayoutInflater.from(mContext).inflate(R.layout.indictor_item_view, null)
        val imageView: ImageView = rootView.findViewById(R.id.circle_view);
        container.addView(rootView)
        ImageLoaderManager.getInstance().displayImageForCircle(imageView, mData[position].albumPic)
        mAnims.put(position, createAnim(imageView))
        return super.instantiateItem(container, position)
    }


    private fun createAnim(imageView: ImageView): ObjectAnimator{
        imageView.rotation = 0f
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(imageView, View.ROTATION.name, 0f, 360f)
        animator.duration = 10000
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = -1
        if(AudioController.isStartState()){
            animator.start()
        }
        return animator
    }

    fun getAnims(position: Int): ObjectAnimator? {
        return mAnims[position]
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun getCount(): Int {
       return mData.size
    }
}