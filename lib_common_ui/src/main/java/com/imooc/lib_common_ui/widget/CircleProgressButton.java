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


	private int bgColor;
	private int progressColor;
	private int viewWidth;
	private int viewHeight;
	private float viewRoundWidth;
	private float progressValue = 0;
	private int progressMax = 100;
	private Paint paint;
	private RectF rectF;
	private Status playOrPause = Status.PLAY;

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
		//宽度和高度
		viewWidth = typedArray.getColor(R.styleable.CircleProgressButton_viewWidth, 15);
		viewHeight = typedArray.getColor(R.styleable.CircleProgressButton_viewHeight, 15);
		//外层圆环的宽度
		viewRoundWidth = typedArray.getColor(R.styleable.CircleProgressButton_viewRoundWidth, 4);
		typedArray.recycle();
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {

		//外层的圆
		canvas.save();
		int center = getWidth() / 2;
		int radius = (int) (center - viewRoundWidth / 2);
		paint.setColor(bgColor); //设置背景圆环的颜色
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
		if(playOrPause == Status.PLAY){
			//红色 两条竖线
			paint.setColor(Color.RED);
			paint.setStyle(Paint.Style.FILL);
			paint.setStrokeWidth(3f);
			canvas.drawLine(3*x/8, 5*x/16, 3*x/8,11*x/16, paint);
			canvas.drawLine(5*x/8, 5*x/16, 5*x/8,11*x/16, paint);
		}else if(playOrPause == Status.PAUSE){
			//灰色 三角形
			Path path = new Path();
			paint.setColor(Color.DKGRAY);
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(3f);
			path.moveTo(7*x/16,5*x/16);
			path.lineTo(7*x/16,11*x/16);
			path.lineTo(11*x/16,8*x/16);
			path.close();
			canvas.drawPath(path, paint);
		}

		super.onDraw(canvas);
	}

	//播放进度
	public void setProgressValue(float progressValue) {
		if(progressValue < 0 || progressValue > 100){
			throw new IllegalArgumentException("progressValue illegal");
		}
		this.progressValue = progressValue;
		postInvalidate();
	}

	//设置播放状态
	public void setPlayOrPause(Status status) {
		this.playOrPause = status;
		if(playOrPause == Status.PAUSE){
			bgColor = Color.DKGRAY;
		}else if(playOrPause == Status.PLAY){
			bgColor = Color.LTGRAY;
		}
		postInvalidate();
	}

	//播放状态
	public enum Status{
		PLAY,
		PAUSE
	}
}
