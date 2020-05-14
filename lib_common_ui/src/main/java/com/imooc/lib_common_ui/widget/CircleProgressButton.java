package com.imooc.lib_common_ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.imooc.lib_common_ui.R;

public class CircleProgressButton extends View {


	public static final int PLAY = 0;
	public static final int PAUSE = 1;

	private int bgColor;
	private int progressColor;
	private int viewWidth;
	private int viewHeight;
	private float viewRoundWidth;
	private int progressValue = 0;
	private int progressMax = 100;
	private Paint paint;
	private RectF rectF;
	private int playOrPause = PLAY;

	public CircleProgressButton(Context context) {
		this(context, null, 0);
	}

	public CircleProgressButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CircleProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		paint = new Paint();
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressButton);
		//背景环颜色
		bgColor = typedArray.getColor(R.styleable.CircleProgressButton_bgColor, Color.GRAY);
		//进度环的颜色
		progressColor = typedArray.getColor(R.styleable.CircleProgressButton_progressColor, Color.RED);
		viewWidth = typedArray.getColor(R.styleable.CircleProgressButton_viewWidth, 15);
		viewHeight = typedArray.getColor(R.styleable.CircleProgressButton_viewHeight, 15);

		viewRoundWidth = typedArray.getColor(R.styleable.CircleProgressButton_viewRoundWidth, 2);
		typedArray.recycle();
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {

		//外层的圆
		canvas.save();
		int center = getWidth() / 2;
		int radius = (int) (center - viewRoundWidth / 2);
		paint.setColor(bgColor); //设置圆环的颜色
		paint.setStyle(Paint.Style.STROKE); //设置空心
		paint.setStrokeWidth(viewRoundWidth); //设置圆环的宽度
		paint.setAntiAlias(true);  //消除锯齿
		paint.setDither(true);  // 设置抖动
		canvas.drawCircle(center, center, radius, paint); //画出圆环
		canvas.save();
		//进度层的圆
		paint.setColor(progressColor);
		paint.setStrokeWidth(viewRoundWidth);
		rectF = new RectF(center - radius, center - radius, center
				+ radius, center + radius);
		canvas.drawArc(rectF, -90, (float) 360 * progressValue / progressMax, false, paint);

		//画播放和暂停
		int x = getWidth();
		if(playOrPause == PLAY){
			//红色
			paint.setColor(Color.RED);
			paint.setStyle(Paint.Style.FILL);
			paint.setStrokeWidth(1.5f);
			canvas.drawLine(3*x/8, 2*x/8, 3*x/8,6*x/8, paint);
			//canvas.drawLine(4*x/8, 4*x/8, 4*x/8,6*x/8, paint);
			canvas.drawLine(5*x/8, 2*x/8, 5*x/8,6*x/8, paint);
		}else if(playOrPause == PAUSE){
			//灰色
			Path path = new Path();
			paint.setColor(Color.GRAY);
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1.5f);
			path.moveTo(3*x/8,3*x/8);
			path.lineTo(3*x/8,5*x/8);
			path.lineTo(5*x/8,4*x/8);
			path.close();
			canvas.drawPath(path, paint);
		}

		super.onDraw(canvas);
	}

	public int getProgressValue() {
		return progressValue;
	}

	public void setProgressValue(int progressValue) {
		if(progressValue < 0 || progressValue > 100){
			throw new IllegalArgumentException("progressValue illegal");
		}
		this.progressValue = progressValue;
		postInvalidate();
	}

	public int getPlayOrPause() {
		return playOrPause;
	}

	public void setPlayOrPause(int playOrPause) {
		this.playOrPause = playOrPause;
		postInvalidate();
	}

	/*
	 *     <declare-styleable name="ProgressButton">
	 *         <attr name="bgColor" format="color"/>
	 *         <attr name="progressColor" format="color"/>
	 *         <attr name="viewWidth" format="dimension"/>
	 *         <attr name="viewHeight" format="dimension"/>
	 *         <attr name="viewRoundWidth" format="dimension"/>
	 *     </declare-styleable>
	 */
}
