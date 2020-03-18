package com.imooc.imooc_voice.view.mine.local.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.util.PreferencesUtil;
import com.imooc.imooc_voice.util.SortOrder;
import com.lxj.xpopup.core.CenterPopupView;


public class SortPopupDialog extends CenterPopupView {

	private OnSelectMenuListener mListener;
	private SortType mType;
	private Context mContext;
	public SortPopupDialog(@NonNull Context context, OnSelectMenuListener listener, SortType type) {
		super(context);
		this.mListener = listener;
		this.mType = type;
		this.mContext = context;
	}


	/**
	 * 排序方式
	 *   --单曲
	 * 		添加时间
	 * 		单曲名
	 * 		专辑名
	 * 		歌手名
	 * 	 --歌手
	 * 	 	按歌手名
	 * 	    歌曲数量
	 * 	 --专辑
	 * 	 	专辑名
	 * 	 	歌曲数量
	 * 	 --文件夹
	 * 	 	文件夹名
	 * 	 	歌曲数量
	 */

	@Override
	protected int getImplLayoutId() {
		return R.layout.dialog_tab_sort;
	}
	// 执行初始化操作，比如：findView，设置点击，或者任何你弹窗内的业务逻辑
	@Override
	protected void onCreate() {
		super.onCreate();

		final PreferencesUtil preferencesUtil = PreferencesUtil.getInstance(mContext);
		switch (mType){
			case ALBUM:
				String albumSortOrder = preferencesUtil.getAlbumSortOrder();
				ImageView albumCheckView = findViewById(R.id.iv_album_check);
				ImageView numberCheckView = findViewById(R.id.iv_number_check);
				//设置勾选状态
				if(albumSortOrder.equals(SortOrder.AlbumSortOrder.ALBUM_A_Z)){
					albumCheckView.setVisibility(VISIBLE);
				}else{
					numberCheckView.setVisibility(VISIBLE);
				}
				//设置显示内容
				findViewById(R.id.ll_dialog_sort_album).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_number).setVisibility(VISIBLE);
				//设置回调
				findViewById(R.id.ll_dialog_sort_album).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setAlbumSortOrder(SortOrder.AlbumSortOrder.ALBUM_A_Z);
						mListener.onMenuSelected(SortOrder.AlbumSortOrder.ALBUM_A_Z);
						dismiss();
					}
				});
				findViewById(R.id.ll_dialog_sort_number).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setAlbumSortOrder(SortOrder.AlbumSortOrder.ALBUM_NUMBER_OF_SONGS);
						mListener.onMenuSelected(SortOrder.AlbumSortOrder.ALBUM_NUMBER_OF_SONGS);
						dismiss();
					}
				});
				break;
			case SONG:
				String songSortOrder = preferencesUtil.getSongSortOrder();

				ImageView songalbumCheckView = findViewById(R.id.iv_album_check);
				ImageView songartistCheckView = findViewById(R.id.iv_artist_check);
				ImageView songmusicCheckView = findViewById(R.id.iv_music_check);
				ImageView songtimeCheckView = findViewById(R.id.iv_time_check);
				if(songSortOrder.equals(SortOrder.SongSortOrder.SONG_ALBUM)){
					songalbumCheckView.setVisibility(VISIBLE);
				}else if(songSortOrder.equals(SortOrder.SongSortOrder.SONG_ARTIST)){
					songartistCheckView.setVisibility(VISIBLE);
				}else if(songSortOrder.equals(SortOrder.SongSortOrder.SONG_A_Z)){
					songmusicCheckView.setVisibility(VISIBLE);
				}else{
					songtimeCheckView.setVisibility(VISIBLE);
				}
				findViewById(R.id.ll_dialog_sort_album).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_artist).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_music).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_time).setVisibility(VISIBLE);
				//单曲排序 监听回调
				findViewById(R.id.ll_dialog_sort_album).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setSongSortOrder(SortOrder.SongSortOrder.SONG_ALBUM);
						mListener.onMenuSelected(SortOrder.SongSortOrder.SONG_ALBUM);
						dismiss();
					}
				});
				findViewById(R.id.ll_dialog_sort_artist).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setSongSortOrder(SortOrder.SongSortOrder.SONG_ARTIST);
						mListener.onMenuSelected(SortOrder.SongSortOrder.SONG_ARTIST);
						dismiss();
					}
				});
				findViewById(R.id.ll_dialog_sort_music).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setSongSortOrder(SortOrder.SongSortOrder.SONG_A_Z);
						mListener.onMenuSelected(SortOrder.SongSortOrder.SONG_A_Z);
						dismiss();
					}
				});
				findViewById(R.id.ll_dialog_sort_time).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setSongSortOrder(SortOrder.SongSortOrder.SONG_DATE);
						mListener.onMenuSelected(SortOrder.SongSortOrder.SONG_DATE);
						dismiss();
					}
				});
				break;
			case AITIST:
				String artistSortOrder = preferencesUtil.getArtistSortOrder();

				ImageView artistartistCheckView = findViewById(R.id.iv_artist_check);
				ImageView artistnumberCheckView = findViewById(R.id.iv_number_check);
				if(artistSortOrder.equals(SortOrder.ArtistSortOrder.ARTIST_A_Z)){
					artistartistCheckView.setVisibility(VISIBLE);
				}else{
					artistnumberCheckView.setVisibility(VISIBLE);
				}
				findViewById(R.id.ll_dialog_sort_artist).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_number).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_artist).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setArtistSortOrder(SortOrder.ArtistSortOrder.ARTIST_A_Z);
						mListener.onMenuSelected(SortOrder.ArtistSortOrder.ARTIST_A_Z);
						dismiss();
					}
				});
				findViewById(R.id.ll_dialog_sort_number).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setArtistSortOrder(SortOrder.ArtistSortOrder.ARTIST_NUMBER_OF_SONGS);
						mListener.onMenuSelected(SortOrder.ArtistSortOrder.ARTIST_NUMBER_OF_SONGS);
						dismiss();
					}
				});
				break;
			case FOLDER:
				String folderSortOrder = preferencesUtil.getFoloerSortOrder();
				ImageView folderfolderCheckView = findViewById(R.id.iv_folder_check);
				ImageView foldernumberCheckView = findViewById(R.id.iv_number_check);
				if(folderSortOrder.equals(SortOrder.FolderSortOrder.FOLDER_A_Z)){
					folderfolderCheckView.setVisibility(VISIBLE);
				}else{
					foldernumberCheckView.setVisibility(VISIBLE);
				}
				findViewById(R.id.ll_dialog_sort_folder).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_number).setVisibility(VISIBLE);
				findViewById(R.id.ll_dialog_sort_folder).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setFolerSortOrder(SortOrder.FolderSortOrder.FOLDER_A_Z);
						mListener.onMenuSelected(SortOrder.FolderSortOrder.FOLDER_A_Z);
						dismiss();
					}
				});
				findViewById(R.id.ll_dialog_sort_number).setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						preferencesUtil.setFolerSortOrder(SortOrder.FolderSortOrder.FOLDER_NUMBER);
						mListener.onMenuSelected(SortOrder.FolderSortOrder.FOLDER_NUMBER);
						dismiss();
					}
				});


		}

	}


	public interface OnSelectMenuListener{
		void onMenuSelected(String type);
	}

	public enum SortType{
		SONG, AITIST, ALBUM, FOLDER
	}


}
