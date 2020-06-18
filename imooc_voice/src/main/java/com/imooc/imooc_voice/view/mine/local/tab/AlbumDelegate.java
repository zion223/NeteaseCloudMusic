package com.imooc.imooc_voice.view.mine.local.tab;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.info.AlbumInfo;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;

import java.util.ArrayList;

public class AlbumDelegate extends NeteaseLoadingDelegate {

	private AlbumAdapter mAdapter;
	//按照字母名排序
	private boolean isAZSort = true;

	@Override
	public void initView() {
		RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		mAdapter = new AlbumAdapter();
		recyclerView.setAdapter(mAdapter);
		reloadAlbumList();
	}

	@SuppressLint("StaticFieldLeak")
	private void reloadAlbumList() {
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {

			}

			@Override
			protected void onPostExecute(Void aVoid) {
				mAdapter.notifyDataSetChanged();
				addRootView();
			}

			@Override
			protected Void doInBackground(Void... voids) {
				//排序方式

				ArrayList<AlbumInfo> albumList = (ArrayList) MusicUtils.queryAlbums(getProxyActivity());
				mAdapter.addData(albumList);
				return null;
			}
		}.execute();

	}
	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_music_recyclerview;
	}

	static class AlbumAdapter extends BaseQuickAdapter<AlbumInfo, BaseViewHolder>{

		AlbumAdapter() {
			super(R.layout.item_tab_common, null);
		}

		@Override
		protected void convert(BaseViewHolder helper, AlbumInfo item) {
			//专辑名
			helper.setText(R.id.viewpager_list_toptext, item.album_name);
			//专辑歌曲数量和专辑的歌手
			helper.setText(R.id.viewpager_list_bottom_text, item.number_of_songs + "首  " + item.album_artist);
			//专辑封面
			((ImageView)helper.getView(R.id.iv_tab)).setImageURI(Uri.parse(item.album_art));

		}
	}
}
