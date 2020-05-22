package com.imooc.imooc_voice.view.mine.local.tab;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.info.FolderInfo;
import com.imooc.imooc_voice.model.info.MusicInfo;
import com.imooc.imooc_voice.util.IConstants;
import com.imooc.imooc_voice.util.MusicUtils;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.ArrayList;
import java.util.List;

public class FolderDelegate extends NeteaseLoadingDelegate {

	private RecyclerView recyclerView;
	private LinearLayoutManager linearLayoutManager;

	private FolderAdapter mAdapter;

	@Override
	public void initView() {
		recyclerView = rootView.findViewById(R.id.recyclerview);
		linearLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		mAdapter = new FolderAdapter(null);
		recyclerView.setAdapter(mAdapter);
		reloadFolerList();
	}

	@SuppressLint("StaticFieldLeak")
	private void reloadFolerList() {
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
				ArrayList<FolderInfo> folderList = (ArrayList) MusicUtils.queryFolder(getProxyActivity());
				for (int i = 0; i < folderList.size(); i++) {
					List<MusicInfo> albumList = MusicUtils.queryMusic(getContext(), folderList.get(i).folder_path, IConstants.START_FROM_FOLDER);
					folderList.get(i).folder_count = albumList.size();
				}
				mAdapter.addData(folderList);
				return null;
			}
		}.execute();
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_music_recyclerview;
	}

	static class FolderAdapter extends BaseQuickAdapter<FolderInfo, BaseViewHolder>{

		FolderAdapter(@Nullable List<FolderInfo> data) {
			super(R.layout.item_tab_common, data);
		}

		@Override
		protected void convert(BaseViewHolder helper, FolderInfo item) {
			//文件夹名
			helper.setText(R.id.viewpager_list_toptext, item.folder_name);
			//文件夹歌曲数量和文件的路径
			helper.setText(R.id.viewpager_list_bottom_text, item.folder_count + "首  " + item.folder_path);
			//文件夹封面
			ImageView img = ((ImageView)helper.getView(R.id.iv_tab));
			img.setImageResource(R.drawable.ic_folder);

			ViewGroup.LayoutParams layoutParams = ((ImageView) helper.getView(R.id.iv_tab)).getLayoutParams();
			layoutParams.width = UIUtil.dip2px(img.getContext(), 20);
			layoutParams.height = UIUtil.dip2px(img.getContext(), 20);
			img.setLayoutParams(layoutParams);
		}
	}
}
