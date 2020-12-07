package com.imooc.imooc_voice.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
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

	public static Animation getShakeAnimation() {
		Animation rotateAnimation = new RotateAnimation(-20, 20, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setRepeatCount(2);
		rotateAnimation.setDuration(150);
		return rotateAnimation;
	}
}
