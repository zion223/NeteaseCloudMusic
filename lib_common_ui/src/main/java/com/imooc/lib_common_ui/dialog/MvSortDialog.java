package com.imooc.lib_common_ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.imooc.lib_common_ui.R;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.util.XPopupUtils;

//MV分类Dialog
public class MvSortDialog extends PositionPopupView implements View.OnClickListener {


	//地区
	private TextView mTvAreaAll;
	private TextView mTvAreaInland;
	private TextView mTvAreaGang;
	private TextView mTvAreaEurope;
	private TextView mTvAreaKorea;
	private TextView mTvAreaJapan;
	//类型
	private TextView mTvTypeAll;
	private TextView mTvTypeGuan;
	private TextView mTvTypeYuan;
	private TextView mTvTypeScene;
	private TextView mTvTypeNetease;
	//排序
	private TextView mTvOrderFast;
	private TextView mTvOrderNew;
	private TextView mTvOrderHot;
	//完成
	private TextView mTvFinish;
	private TextView[] mAreaTextViewArray = new TextView[6];
	private TextView[] mTypeTextViewArray = new TextView[5];
	private TextView[] mOrderTextViewArray = new TextView[3];

	private int areaPos = 0;
	private int typePos = 0;
	private int orderPos = 0;

	private String area = "全部";
	private String type = "全部";
	private String order = "上升最快";

	private OnItemChooseListener mListener;

	public MvSortDialog(@NonNull Context context, OnItemChooseListener listener) {
		super(context);
		this.mListener = listener;
	}

	@Override
	protected void onCreate() {
		super.onCreate();
		initView();
	}

	@Override
	protected int getImplLayoutId() {
		return R.layout.dialog_mv_sort;
	}

	@Override
	protected int getPopupWidth() {
		return XPopupUtils.getWindowWidth(getContext());
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		TextView view = (TextView) v;
		//地区
		if (id == R.id.tv_mv_area_all || id == R.id.tv_mv_area_inland || id == R.id.tv_mv_area_gang
				|| id == R.id.tv_mv_area_europe || id == R.id.tv_mv_area_korea || id == R.id.tv_mv_area_japan) {
			areaPos = (int) v.getTag();
			view.setTextColor(Color.RED);
			for (int i = 0; i < mAreaTextViewArray.length; i++) {
				if (i != areaPos) {
					mAreaTextViewArray[i].setTextColor(Color.GRAY);
				}
			}
			area = view.getText().toString();
		//类型
		}else if(id == R.id.tv_mv_type_all || id == R.id.tv_mv_type_guan || id == R.id.tv_mv_type_yuansheng
				|| id == R.id.tv_mv_type_xianchang || id == R.id.tv_mv_type_netease){

			typePos = (int) v.getTag();
			view.setTextColor(Color.RED);
			for (int j = 0; j < mTypeTextViewArray.length; j++) {
				if (j != typePos) {
					mTypeTextViewArray[j].setTextColor(Color.GRAY);
				}
			}
			type = view.getText().toString();

			//排序
		}else if(id == R.id.tv_mv_order_fast || id == R.id.tv_mv_order_new || id == R.id.tv_mv_order_hot){
			orderPos = (int) v.getTag();
			view.setTextColor(Color.RED);
			for (int k = 0; k < mOrderTextViewArray.length; k++) {
				if (k != orderPos) {
					mOrderTextViewArray[k].setTextColor(Color.GRAY);
				}
			}
			order = view.getText().toString();

		}


		//取消弹窗
		if (id == R.id.tv_mv_finish) {
			dismiss();
			mListener.onItemChoose(area, type, order);
		}
	}

	private void initView() {
		mTvAreaAll = findViewById(R.id.tv_mv_area_all);
		mTvAreaAll.setTextColor(Color.RED);
		mTvAreaInland = findViewById(R.id.tv_mv_area_inland);
		mTvAreaGang = findViewById(R.id.tv_mv_area_gang);
		mTvAreaEurope = findViewById(R.id.tv_mv_area_europe);
		mTvAreaKorea = findViewById(R.id.tv_mv_area_korea);
		mTvAreaJapan = findViewById(R.id.tv_mv_area_japan);

		mTvAreaAll.setTag(0);
		mTvAreaInland.setTag(1);
		mTvAreaGang.setTag(2);
		mTvAreaEurope.setTag(3);
		mTvAreaKorea.setTag(4);
		mTvAreaJapan.setTag(5);

		mTvTypeAll = findViewById(R.id.tv_mv_type_all);
		mTvTypeAll.setTextColor(Color.RED);
		mTvTypeGuan = findViewById(R.id.tv_mv_type_guan);
		mTvTypeYuan = findViewById(R.id.tv_mv_type_yuansheng);
		mTvTypeScene = findViewById(R.id.tv_mv_type_xianchang);
		mTvTypeNetease = findViewById(R.id.tv_mv_type_netease);

		mTvTypeAll.setTag(0);
		mTvTypeGuan.setTag(1);
		mTvTypeYuan.setTag(2);
		mTvTypeScene.setTag(3);
		mTvTypeNetease.setTag(4);

		mTvOrderFast = findViewById(R.id.tv_mv_order_fast);
		mTvOrderFast.setTextColor(Color.RED);
		mTvOrderNew = findViewById(R.id.tv_mv_order_new);
		mTvOrderHot = findViewById(R.id.tv_mv_order_hot);

		mTvFinish = findViewById(R.id.tv_mv_finish);
		mTvFinish.setOnClickListener(this);

		mTvOrderFast.setTag(0);
		mTvOrderNew.setTag(1);
		mTvOrderHot.setTag(2);

		mTvAreaAll.setOnClickListener(this);
		mTvAreaInland.setOnClickListener(this);
		mTvAreaEurope.setOnClickListener(this);
		mTvAreaKorea.setOnClickListener(this);
		mTvAreaGang.setOnClickListener(this);
		mTvAreaJapan.setOnClickListener(this);
		mTvTypeAll.setOnClickListener(this);
		mTvTypeGuan.setOnClickListener(this);
		mTvTypeYuan.setOnClickListener(this);
		mTvTypeScene.setOnClickListener(this);
		mTvTypeNetease.setOnClickListener(this);
		mTvOrderFast.setOnClickListener(this);
		mTvOrderNew.setOnClickListener(this);
		mTvOrderHot.setOnClickListener(this);

		mAreaTextViewArray[0] = mTvAreaAll;
		mAreaTextViewArray[1] = mTvAreaInland;
		mAreaTextViewArray[2] = mTvAreaGang;
		mAreaTextViewArray[3] = mTvAreaEurope;
		mAreaTextViewArray[4] = mTvAreaKorea;
		mAreaTextViewArray[5] = mTvAreaJapan;

		mTypeTextViewArray[0] = mTvTypeAll;
		mTypeTextViewArray[1] = mTvTypeGuan;
		mTypeTextViewArray[2] = mTvTypeYuan;
		mTypeTextViewArray[3] = mTvTypeScene;
		mTypeTextViewArray[4] = mTvTypeNetease;

		mOrderTextViewArray[0] = mTvOrderFast;
		mOrderTextViewArray[1] = mTvOrderNew;
		mOrderTextViewArray[2] = mTvOrderHot;

	}

	public interface OnItemChooseListener{
		void onItemChoose(String area, String type, String order);
	}

}
