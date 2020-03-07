package com.imooc.imooc_voice.view.friend.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.friend.FriendBodyValue;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_common_ui.MultiImageViewLayout;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.List;

public class FriendAdapter extends BaseMultiItemQuickAdapter<FriendBodyValue, BaseViewHolder> {

	public FriendAdapter(List<FriendBodyValue> data) {
		super(data);
		addItemType(FriendBodyValue.MUSIC, R.layout.item_friend_list_picture_layout);
		addItemType(FriendBodyValue.VIDEO, R.layout.item_friend_list_video_layout);
	}

	@Override
	protected void convert(BaseViewHolder helper, final FriendBodyValue item) {

		switch (helper.getItemViewType()){
			case FriendBodyValue.MUSIC:
				helper.setText(R.id.name_view, item.name + " 分享单曲:");
				helper.setText(R.id.fansi_view, item.fans + "粉丝");
				helper.setText(R.id.text_view, item.text);
				helper.setText(R.id.zan_view, item.zan);
				helper.setText(R.id.message_view, item.msg);
				helper.setText(R.id.audio_name_view, item.audioBean.getName());
				helper.setText(R.id.audio_author_view, item.audioBean.getAlbum());
				helper.setOnClickListener(R.id.album_layout, new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//调用播放器装饰类
						AudioHelper.addAudio((Activity) mContext, item.audioBean);
					}
				});
				helper.setOnClickListener(R.id.guanzhu_view, new View.OnClickListener() {
					@Override
					public void onClick(View v) {
//						if (!UserManager.getInstance().hasLogined()) {
//							//goto login
//							LoginActivity.start(mContext);
//						}
					}
				});
				ImageView avatar = helper.getView(R.id.photo_view);
				ImageLoaderManager.getInstance().displayImageForCircle(avatar, item.avatr);
				ImageView albumPicView = helper.getView(R.id.album_view);
				ImageLoaderManager.getInstance()
						.displayImageForView(albumPicView, item.audioBean. getAlbumPic());

				MultiImageViewLayout imageViewLayout = helper.getView(R.id.image_layout);
				imageViewLayout.setList(item.pics);

				break;
			case FriendBodyValue.VIDEO:
				RelativeLayout videoGroup = helper.getView(R.id.video_layout);
				//VideoAdContext mAdsdkContext = new VideoAdContext(videoGroup, recommandBodyValue.videoUrl);
				helper.setText(R.id.fansi_view, item.fans + "粉丝");
				helper.setText(R.id.name_view, item.name + " 分享视频");
				helper.setText(R.id.text_view, item.text);
				helper.setOnClickListener(R.id.guanzhu_view, new View.OnClickListener() {
					@Override
					public void onClick(View v) {
//						if (!UserManager.getInstance().hasLogined()) {
//							//goto login
//							LoginActivity.start(mContext);
//						}
					}
				});
				ImageView photoavatar = helper.getView(R.id.photo_view);
				ImageLoaderManager.getInstance().displayImageForCircle(photoavatar, item.avatr);
				break;
			default:
				break;

		}
	}
}
