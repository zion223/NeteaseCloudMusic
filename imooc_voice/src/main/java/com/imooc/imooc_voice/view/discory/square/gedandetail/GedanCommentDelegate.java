package com.imooc.imooc_voice.view.discory.square.gedandetail;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;

import butterknife.BindView;

public class GedanCommentDelegate extends NeteaseLoadingDelegate {

	@BindView(R2.id.loadframe)
	FrameLayout frameLayout;
	private View view;

	private static final String ARGS_GEDAN_ID = "ARGS_GEDAN_ID";
	//歌单ID
	private String id;


	public static GedanDetailDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_GEDAN_ID, id);
		final GedanDetailDelegate delegate = new GedanDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			id = args.getString(ARGS_GEDAN_ID);
		}
	}


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);
		initCommentView();
	}

	@SuppressLint("StaticFieldLeak")
	private void initCommentView() {
		view = LayoutInflater.from(getContext()).inflate(R.layout.delegate_gedan_detail_comment, frameLayout, false);
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
				frameLayout.removeAllViews();
				//framelayout 创建了新的实例
				ViewGroup p = (ViewGroup) view.getParent();
				if (p != null) {
					p.removeAllViewsInLayout();
				}
				frameLayout.addView(view);
			}

			@Override
			protected Void doInBackground(Void... voids) {

				return null;
			}
		}.execute();
	}

	@Override
	public void post(Runnable runnable) {

	}
}
