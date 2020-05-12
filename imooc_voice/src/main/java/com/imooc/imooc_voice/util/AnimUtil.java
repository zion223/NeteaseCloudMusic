package com.imooc.imooc_voice.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class AnimUtil {

	public static AnimatorSet getLikeAnim(ImageView view){
		AnimatorSet animatorSetsuofang = new AnimatorSet();//组合动画
		ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.5f, 1f);
		ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.5f, 1f);
		animatorSetsuofang.setDuration(500);
		animatorSetsuofang.setInterpolator(new DecelerateInterpolator());
		animatorSetsuofang.play(scaleX).with(scaleY);//两个动画同时开始
		return animatorSetsuofang;
	}
}
