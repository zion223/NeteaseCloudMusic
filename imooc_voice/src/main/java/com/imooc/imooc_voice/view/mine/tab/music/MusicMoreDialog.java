package com.imooc.imooc_voice.view.mine.tab.music;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.info.MusicInfo;
import com.imooc.lib_image_loader.app.ImageLoaderManager;


class MusicMoreDialog implements View.OnClickListener{

	private AlertDialog mMusicMoreDialog;
	private MusicInfo info;

	MusicMoreDialog(Context context, MusicInfo info){
		this.mMusicMoreDialog = new AlertDialog.Builder(context).create();
		this.info = info;
	}

	void show(){
		mMusicMoreDialog.show();
		final Window window = mMusicMoreDialog.getWindow();
		if(window != null){
			window.setContentView(R.layout.dialog_music_more);
			window.setGravity(Gravity.BOTTOM);
			window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
			window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			final WindowManager.LayoutParams params = window.getAttributes();
			params.width = WindowManager.LayoutParams.MATCH_PARENT;
			params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
			window.setAttributes(params);
			//头部专辑图片
			ImageView headerAlbum = window.findViewById(R.id.img_album_head_dialog);
			//头部歌名
			TextView headerMusicName = window.findViewById(R.id.tv_music_name_head_dialog);
			//头部歌手名
			TextView headerArtist = window.findViewById(R.id.tv_artist_head_dialog);

			TextView artist = window.findViewById(R.id.tv_artist_dialog);
			TextView album = window.findViewById(R.id.tv_album_dialog);
			//专辑是圆角图片
			ImageLoaderManager.getInstance().displayImageForCorner(headerAlbum, info.albumData, 6);
			artist.setText("歌手: "+info.artist);
			album.setText("专辑: "+info.albumName);
			headerMusicName.setText("歌曲: "+info.musicName);
			headerArtist.setText(info.artist);
			window.findViewById(R.id.tv_next_dialog).setOnClickListener(this);
			window.findViewById(R.id.tv_addfav_dialog).setOnClickListener(this);
			window.findViewById(R.id.tv_share_dialog).setOnClickListener(this);
			window.findViewById(R.id.tv_detail_dialog).setOnClickListener(this);
			window.findViewById(R.id.tv_delete_dialog).setOnClickListener(this);
		}

	}

	@Override
	public void onClick(View v) {
		final int id = v.getId();
		switch (id){
			//下一首播放
			case R.id.tv_next_dialog:

				break;
			//收藏到歌单
			case R.id.tv_addfav_dialog:

				break;
			//分享
			case R.id.tv_share_dialog:

				break;
			//查看歌曲信息
			case R.id.tv_detail_dialog:

				break;
			//删除
			case R.id.tv_delete_dialog:

				break;
			default:
				break;
		}
	}
}
