package com.imooc.lib_common_ui.dialog;

import android.annotation.SuppressLint;
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

import com.imooc.lib_common_ui.R;
import com.imooc.lib_image_loader.app.ImageLoaderManager;


public class MusicPopUpDialog implements View.OnClickListener {

	private AlertDialog mMusicMoreDialog;

	private String mArtistName;
	private String mAlbumName;
	private String mMusicName;
	private String mAlbumPic;
	private Boolean mDelViewInvisiable;
	private OnClickItemListener mListener;

	private MusicPopUpDialog(Builder builder) {
		this.mMusicMoreDialog = new AlertDialog.Builder(builder.context).create();
		this.mArtistName = builder.artistName;
		this.mAlbumName = builder.albumName;
		this.mAlbumPic = builder.albumPic;
		this.mMusicName = builder.musicName;
		this.mDelViewInvisiable = builder.deleteViewInvisiable;
		this.mListener = builder.listener;
	}

	public static final class Builder {
		private Context context;
		private String artistName;
		private String albumName;
		private String musicName;
		private String albumPic;
		private boolean deleteViewInvisiable;
		private OnClickItemListener listener;

		public Builder setListener(OnClickItemListener listener) {
			this.listener = listener;
			return this;
		}

		public Builder setDeleteViewInvisiable(boolean deleteViewInvisiable) {
			this.deleteViewInvisiable = deleteViewInvisiable;
			return this;
		}

		public Builder setContext(Context context) {
			this.context = context;
			return this;
		}

		public Builder setmArtistName(String mArtistName) {
			this.artistName = mArtistName;
			return this;
		}

		public Builder setmAlbumName(String mAlbumName) {
			this.albumName = mAlbumName;
			return this;
		}

		public Builder setmMusicName(String mMusicName) {
			this.musicName = mMusicName;
			return this;
		}

		public Builder setmAlbumPic(String mAlbumPic) {
			this.albumPic = mAlbumPic;
			return this;
		}

		public MusicPopUpDialog build() {
			return new MusicPopUpDialog(this);
		}

	}

	@SuppressLint("SetTextI18n")
	public void show() {
		mMusicMoreDialog.show();
		final Window window = mMusicMoreDialog.getWindow();
		if (window != null) {
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
			ImageLoaderManager.getInstance().displayImageForCorner(headerAlbum, mAlbumPic, 3);
			artist.setText("歌手:  " + mArtistName);
			album.setText("专辑:  " + mAlbumName);
			headerMusicName.setText("歌曲:  " + mMusicName);
			headerArtist.setText(mArtistName);
			window.findViewById(R.id.ll_addfav_dialog).setOnClickListener(this);
			window.findViewById(R.id.ll_share_dialog).setOnClickListener(this);
			window.findViewById(R.id.ll_comment_dialog).setOnClickListener(this);
			window.findViewById(R.id.ll_artist_dialog).setOnClickListener(this);
			window.findViewById(R.id.ll_album_dialog).setOnClickListener(this);

			window.findViewById(R.id.ll_delete_view).setVisibility(mDelViewInvisiable ? View.GONE : View.VISIBLE);
		}

	}


	@Override
	public void onClick(View v) {
		mMusicMoreDialog.dismiss();
		final int id = v.getId();
		//下一首播放
		if (id == R.id.tv_next_dialog) {
			mListener.onClickNext();
			//收藏到歌单
		} else if (id == R.id.ll_addfav_dialog) {
			mListener.onClickAddFav();
			//分享
		} else if (id == R.id.ll_share_dialog) {
			mListener.onClickShare();
			//删除歌曲
		} else if (id == R.id.ll_delete_view) {
			mListener.onClickDelete();
			//查看歌手
		} else if (id == R.id.ll_artist_dialog) {
			mListener.onClickArtistDetail();
			//查看专辑
		} else if (id == R.id.ll_album_dialog) {
			mListener.onClickAlbumDetail();
			//歌曲评论
		} else if (id == R.id.ll_comment_dialog) {
			mListener.onClickComment();
		}
	}

	public interface OnClickItemListener {
		void onClickNext();

		void onClickAddFav();

		void onClickShare();

		void onClickDelete();

		void onClickArtistDetail();

		void onClickAlbumDetail();

		void onClickComment();
	}

}
