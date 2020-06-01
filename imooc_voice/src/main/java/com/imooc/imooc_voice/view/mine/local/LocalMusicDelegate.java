package com.imooc.imooc_voice.view.mine.local;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.mine.local.tab.AlbumDelegate;
import com.imooc.imooc_voice.view.mine.local.tab.ArtistDelegate;
import com.imooc.imooc_voice.view.mine.local.tab.FolderDelegate;
import com.imooc.imooc_voice.view.mine.local.tab.MusicDelegate;
import com.imooc.imooc_voice.view.mine.local.view.SortPopupDialog;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseTabDelegate;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;


import java.util.List;

//本地音乐
public class LocalMusicDelegate extends NeteaseTabDelegate {


	private BasePopupView tabMoreDialog;

	private static final String[] mTitleDataList = {"单曲", "歌手", "专辑", "文件夹"};
	private static final SortPopupDialog.SortType[] mFramentType =
			{SortPopupDialog.SortType.SONG, SortPopupDialog.SortType.AITIST, SortPopupDialog.SortType.ALBUM, SortPopupDialog.SortType.FOLDER};


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);
		initDialog();
	}

	@Override
	public String[] setTitleDataList() {
		return mTitleDataList;
	}

	@Override
	public void setShowMoreView(int vivisiable) {
		super.setShowMoreView(View.VISIBLE);
	}


	@Override
	public CharSequence setLeftTitle() {
		return "本地音乐";
	}

	@Override
	public List<NeteaseDelegate> setDelegateList() {
		mDelegateList.add(new MusicDelegate());
		mDelegateList.add(new ArtistDelegate());
		mDelegateList.add(new AlbumDelegate());
		mDelegateList.add(new FolderDelegate());
		return mDelegateList;
	}


	private void initDialog() {
		tabMoreDialog = new XPopup.Builder(getContext())
				.atView(getIvMore())
				//背景不变灰色
				.hasShadowBg(false)
				.asAttachList(new String[]{"下载管理", "扫描本地音乐", "选择排序方式", "获取封面歌词"},
						new int[]{R.drawable.ic_dialog_more, R.drawable.ic_dialog_more, R.drawable.ic_dialog_more, R.drawable.ic_dialog_more},
						listener);

	}


	private OnSelectListener listener = new OnSelectListener() {
		@Override
		public void onSelect(int position, String text) {
			switch (position){
				case 0:
					//下载管理
					break;
				case 1:
					//扫描本地音乐
					break;
				case 2:
					//排序方式
					int currentItem = getTabViewPager().getCurrentItem();
					final BasePopupView sortDialog = new XPopup.Builder(getContext())
							.asCustom(new SortPopupDialog(getContext(), new SortPopupDialog.OnSelectMenuListener() {
								@Override
								public void onMenuSelected(String type) {
									//更新排序Adapter 发送reload事件

								}
							}, mFramentType[currentItem]));
					//根据当前Delegate判断显示不同的排序方式
					sortDialog.show();
					break;
				case 3:
					//获取封面歌词
					break;
				default:
					break;

			}
		}
	};

	@Override
	public void setMoreViewOnClickListener(View.OnClickListener listener) {
		super.setMoreViewOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tabMoreDialog.show();
			}
		});
	}



}
