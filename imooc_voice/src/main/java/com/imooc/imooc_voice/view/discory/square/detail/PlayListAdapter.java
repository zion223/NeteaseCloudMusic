package com.imooc.imooc_voice.view.discory.square.detail;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.home.search.artist.ArtistDetailDelegate;
import com.imooc.imooc_voice.view.video.MvDeatilDelegate;
import com.imooc.lib_api.model.song.SongDetailBean;
import com.imooc.lib_audio.mediaplayer.view.MusicCollectDialog;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.dialog.MusicPopUpDialog;
import com.lxj.xpopup.XPopup;

import java.util.List;

import static com.imooc.imooc_voice.Constants.ALBUM;
import static com.imooc.imooc_voice.Constants.SONG;

//歌单的Adapter ArtistHomePage ArtistSong   创建的歌单、云盘中 中的单曲可删除
public class PlayListAdapter extends BaseQuickAdapter<SongDetailBean.SongsBean, BaseViewHolder> {

	private Context mContext;
	//是否有头布局 影响显示序号
	private Boolean hasHeader;
	private NeteaseDelegate mDelegate;

	public PlayListAdapter(Context context, NeteaseDelegate delegate, boolean hasHeader, @Nullable List<SongDetailBean.SongsBean> data) {
		super(R.layout.item_gedan_detail_song, data);
		this.mContext = context;
		this.mDelegate = delegate;
		this.hasHeader = hasHeader;
	}

	public PlayListAdapter(Context context, NeteaseDelegate delegate, @Nullable List<SongDetailBean.SongsBean> data) {
		super(R.layout.item_gedan_detail_song, data);
		this.mContext = context;
		this.mDelegate = delegate;
		this.hasHeader = false;
	}

	@Override
	protected void convert(BaseViewHolder helper, SongDetailBean.SongsBean item) {
		if(hasHeader){
			helper.setText(R.id.item_play_no, String.valueOf(helper.getAdapterPosition()));
		}else{
			helper.setText(R.id.item_play_no, String.valueOf(helper.getAdapterPosition() + 1));
		}
		//歌曲名
		helper.setText(R.id.viewpager_list_toptext, item.getName());
		//歌手名 - 专辑名
		helper.setText(R.id.viewpager_list_bottom_text, item.getAr().get(0).getName() + " - " + item.getAl().getName());
		//当前歌曲是否有MV
		if(item.getMv() != 0){
			helper.setVisible(R.id.iv_list_video, true);
		}
		//当前歌曲的视频
		helper.setOnClickListener(R.id.iv_list_video, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mDelegate.getSupportDelegate().start(MvDeatilDelegate.newInstance(String.valueOf(item.getMv())));
			}
		});
		helper.setOnClickListener(R.id.viewpager_list_button, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showMoreDialog(item);
			}
		});
	}


	private void showMoreDialog(SongDetailBean.SongsBean item) {
		new MusicPopUpDialog.Builder()
				.setContext(mContext)
				//是否显示删除选项
				.setDeleteViewInvisiable(true)
				.setmAlbumName(item.getAl().getName())
				.setmArtistName(item.getAr().get(0).getName())
				.setmAlbumPic(item.getAl().getPicUrl())
				.setmMusicName(item.getName())
				.setListener(new MusicPopUpDialog.OnClickItemListener() {
					//下一首播放
					@Override
					public void onClickNext() {

					}
					//收藏到歌单
					@Override
					public void onClickAddFav() {
						new XPopup.Builder(mContext)
								.asCustom(new MusicCollectDialog(mContext, String.valueOf(item.getId())))
								.show();
					}
					//分享
					@Override
					public void onClickShare() {

					}
					//删除
					@Override
					public void onClickDelete() {
						//删除创建的歌单的歌曲 删除云盘的歌曲

					}
					//歌手详情
					@Override
					public void onClickArtistDetail() {
						mDelegate.getSupportDelegate().start(ArtistDetailDelegate.newInstance(item.getAr().get(0).getId()));
					}
					//专辑详情
					@Override
					public void onClickAlbumDetail() {
						mDelegate.getSupportDelegate().start(SongListDetailDelegate.newInstance(ALBUM, item.getAl().getId()));
					}
					//歌曲评论
					@Override
					public void onClickComment() {
						mDelegate.getSupportDelegate().start(CommentDelegate.newInstance(String.valueOf(item.getId()), SONG, item.getAl().getPicUrl(), item.getAr().get(0).getName(), item.getAl().getName()));
					}
				})
				.build().show();
	}
}
