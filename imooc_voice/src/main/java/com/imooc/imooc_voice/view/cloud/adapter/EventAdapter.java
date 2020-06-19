package com.imooc.imooc_voice.view.cloud.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.lib_common_ui.utils.GsonUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_api.HttpConstants;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.DailyRecommendBean;
import com.imooc.lib_api.model.VideoUrlBean;
import com.imooc.lib_api.model.personal.UserEventBean;
import com.imooc.lib_api.model.personal.UserEventJsonBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_audio.mediaplayer.model.AudioBean;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.imooc.lib_video.videoplayer.CustomJzVideoView;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;

import static com.imooc.lib_common_ui.utils.Constants.ALBUM;
import static com.imooc.lib_common_ui.utils.Constants.PLAYLIST;

//用户动态适配器
public class EventAdapter extends BaseQuickAdapter<UserEventBean.EventsBean, BaseViewHolder> implements View.OnClickListener {

	//图片加载
	private ImageLoaderManager manager;
	private NeteaseDelegate mDelegate;
	private List<ImageView> imgList = new ArrayList<>();

	public EventAdapter(NeteaseDelegate delegate, @Nullable List<UserEventBean.EventsBean> data) {
		super(R.layout.item_user_event, data);
		manager = ImageLoaderManager.getInstance();
		this.mDelegate = delegate;
	}

	@Override
	protected void convert(@NonNull BaseViewHolder adapter, UserEventBean.EventsBean item) {
		//用户头像
		ImageView avatarView = adapter.getView(R.id.iv_avatar);
		manager.displayImageForCircle(avatarView, item.getUser().getAvatarUrl());
		avatarView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//用户详情
				mDelegate.getSupportDelegate().start(UserDetailDelegate.newInstance(item.getUser().getUserId()));
			}
		});
		//昵称
		adapter.setText(R.id.tv_nickname, item.getUser().getNickname());
		//发布时间
		adapter.setText(R.id.tv_publish_time, TimeUtil.getTimeStandardOnlyYMDChinese(item.getShowTime()));
		//转发、评论、点赞 数量
		adapter.setText(R.id.tv_relayout_count, item.getInfo().getShareCount() == 0 ? "" : String.valueOf(item.getInfo().getShareCount()));
		adapter.setText(R.id.tv_comment_count, item.getInfo().getCommentCount() == 0 ? "" : String.valueOf(item.getInfo().getCommentCount()));
		adapter.setText(R.id.tv_like_count, item.getInfo().getLikedCount() == 0 ? "" : String.valueOf(item.getInfo().getLikedCount()));
		//初始化图片控件
		initImageView(adapter);
		//解析JSON
		String jsonEvnet = item.getJson();
		UserEventJsonBean userEventJsonBean = GsonUtil.fromJSON(jsonEvnet, UserEventJsonBean.class);
		if (userEventJsonBean != null) {
			Log.d(TAG, "JsonBean:" + userEventJsonBean);
			//显示msg内容
			if (!TextUtils.isEmpty(userEventJsonBean.getMsg())) {
				adapter.setVisible(R.id.tv_content, true);
				adapter.setText(R.id.tv_content, userEventJsonBean.getMsg());
			}
			//显示图片
			showImg(adapter, item);
			//显示分享组件的内容 歌曲、电台、歌单 、专辑等
			showShareLayout(adapter, userEventJsonBean);


			int type;
			if (item.getInfo().getCommentThread().getResourceInfo() == null) {
				type = item.getType();
			} else {
				type = item.getInfo().getCommentThread().getResourceInfo().getEventType();
			}

			//String resourceInfo = item.getInfo().getCommentThread().getResourceInfo().getName();
			//String title = resourceInfo.split(":")[0];
			//标题头
			//adapter.setText(R.id.tv_title, title + ":");

			switch (type) {
				case 18:
					adapter.setText(R.id.tv_title, "分享单曲：");
					break;
				case 19:
					adapter.setText(R.id.tv_title, "分享专辑：");
					break;
				case 17:
				case 28:
					adapter.setText(R.id.tv_title, "分享电台节目：");
					break;
				case 22:
					adapter.setText(R.id.tv_title, "转发：");
					break;
				case 39:
					adapter.setText(R.id.tv_title, "发布视频：");
					break;
				case 35:
					break;
				case 13:
					adapter.setText(R.id.tv_title, "分享歌单：");
					break;
				case 24:
					adapter.setText(R.id.tv_title, "分享专栏文章：");
					break;
				case 41:
				case 21:
					adapter.setText(R.id.tv_title, "分享视频：");
					break;

			}

		}
	}


	private void initImageView(BaseViewHolder adapter) {
		ImageView ivShow1 = adapter.getView(R.id.iv_img_1);
		ImageView ivShow2 = adapter.getView(R.id.iv_img_2);
		ImageView ivShow3 = adapter.getView(R.id.iv_img_3);
		ImageView ivShow4 = adapter.getView(R.id.iv_img_4);
		ImageView ivShow5 = adapter.getView(R.id.iv_img_5);
		ImageView ivShow6 = adapter.getView(R.id.iv_img_6);
		ImageView ivShow7 = adapter.getView(R.id.iv_img_7);
		ImageView ivShow8 = adapter.getView(R.id.iv_img_8);
		ImageView ivShow9 = adapter.getView(R.id.iv_img_9);

		imgList.add(ivShow1);
		imgList.add(ivShow2);
		imgList.add(ivShow3);
		imgList.add(ivShow4);
		imgList.add(ivShow5);
		imgList.add(ivShow6);
		imgList.add(ivShow7);
		imgList.add(ivShow8);
		imgList.add(ivShow9);
	}


	//显示图片
	private void showImg(BaseViewHolder adapter, UserEventBean.EventsBean item) {

		//转换图片list集合

		final ArrayList<Object> urlList = new ArrayList<>();

		for (int i = 0; i < item.getPics().size(); i++) {
			urlList.add(item.getPics().get(i).getRectangleUrl());
		}
		if (item.getPics() != null || item.getPics().size() != 0) {
			adapter.setVisible(R.id.rl_img, true);
			for (int i = 0; i < item.getPics().size(); i++) {
				if (i == 0) {
					adapter.setVisible(R.id.ll_img_group1, true);
				}
				if (i == 3) {
					adapter.setVisible(R.id.ll_img_group2, true);
				}
				if (i == 6) {
					adapter.setVisible(R.id.ll_img_group3, true);
				}
				manager.displayImageForCorner(imgList.get(i), item.getPics().get(i).getRectangleUrl());
				//每张图片的点击事件
				ImageView imageView = imgList.get(i);


				final int postion = i;
				//查看大图
				imgList.get(i).setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

						new XPopup.Builder(imageView.getContext()).asImageViewer(imageView, postion, urlList, new OnSrcViewUpdateListener() {
							@Override
							public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
								//RecyclerView rv = (RecyclerView) holder.itemView.getParent();
								//popupView.updateSrcView((ImageView)rv.getChildAt(position));
							}
						}, new ImageLoader())
								.show();
					}
				});
			}
		}
	}

	//分享 layout
	private void showShareLayout(BaseViewHolder adapter, UserEventJsonBean jsonBean) {
		//点击播放 音乐、电台内容 查看歌单和专辑
		adapter.setOnClickListener(R.id.rl_share, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(jsonBean.getSong() != null && !TextUtils.isEmpty(jsonBean.getSong().getName())){
					//播放歌曲
					DailyRecommendBean.RecommendBean item = jsonBean.getSong();
					String songPlayUrl = HttpConstants.getSongPlayUrl(item.getId());
					AudioHelper.Companion.addAudio(new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getArtists().get(0).getName(), item.getAlbum().getName(), item.getAlbum().getName(), item.getAlbum().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDuration())));
				}else if(jsonBean.getAlbum() != null){
					//查看专辑
					mDelegate.getSupportDelegate().start(SongListDetailDelegate.newInstance(ALBUM, jsonBean.getAlbum().getId()));
				}else if(jsonBean.getPlaylist() != null){
					//查看歌单
					mDelegate.getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, jsonBean.getPlaylist().getId()));
				}

			}
		});

		//单曲
		if (jsonBean != null && jsonBean.getSong() != null && !TextUtils.isEmpty(jsonBean.getSong().getName())) {
			adapter.setVisible(R.id.rl_share, true);
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getSong().getAlbum().getPicUrl());
			//单曲名
			adapter.setText(R.id.tv_songname, jsonBean.getSong().getName());
			//歌手名
			adapter.setText(R.id.tv_creator_name, jsonBean.getSong().getArtists().get(0).getName());

		//节目
		} else if (jsonBean != null && jsonBean.getProgram() != null && !TextUtils.isEmpty(jsonBean.getProgram().getName())) {
			adapter.setVisible(R.id.rl_share, true);
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getProgram().getCoverUrl());

			adapter.setText(R.id.tv_songname, jsonBean.getProgram().getName());
			//电台名称
			adapter.setText(R.id.tv_creator_name, jsonBean.getProgram().getRadio().getName());

		//视频
		} else if (jsonBean != null && jsonBean.getVideo() != null) {
			//不显示分享
			adapter.setVisible(R.id.rl_share, false);
			CustomJzVideoView jzvdStd = adapter.getView(R.id.videoplayer);
			//视频封面
			manager.displayImageForCorner(jzvdStd.posterImageView, jsonBean.getVideo().getCoverUrl());
			//获取视频播放地址
			RequestCenter.getVideoUrl(jsonBean.getVideo().getVideoId(), new DisposeDataListener() {
				@Override
				public void onSuccess(Object responseObj) {
					VideoUrlBean bean = (VideoUrlBean) responseObj;
					//视频播放View
					jzvdStd.setUp(bean.getUrls().get(0).getUrl(), "", Jzvd.SCREEN_NORMAL);
				}

				@Override
				public void onFailure(Object reasonObj) {

				}
			});
			adapter.setVisible(R.id.rl_video, true);
		//歌单
		} else if(jsonBean != null && jsonBean.getPlaylist() != null){
			adapter.setVisible(R.id.rl_share, true);
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getPlaylist().getCoverImgUrl());
			//歌单名称
			adapter.setText(R.id.tv_songname, jsonBean.getPlaylist().getName());
			//歌单创建者 名称
			adapter.setText(R.id.tv_creator_name, "by " + jsonBean.getPlaylist().getCreator().getNickname());
		//专辑
		}else if(jsonBean != null && jsonBean.getAlbum() != null){
			manager.displayImageForCorner((ImageView) adapter.getView(R.id.iv_song_cover), jsonBean.getAlbum().getPicUrl());
			//专辑名称
			adapter.setText(R.id.tv_songname, jsonBean.getAlbum().getName());
			//专辑的歌手
			adapter.setText(R.id.tv_creator_name, jsonBean.getAlbum().getArtist().getName());
			//专辑特有标志
			adapter.setVisible(R.id.iv_album_tag, true);

		}else{
			adapter.setVisible(R.id.rl_share, false);
		}
	}

	@Override
	public void onClick(View view) {

	}

	static class ImageLoader implements XPopupImageLoader {

		@Override
		public void loadImage(int position, @NonNull Object uri, @NonNull ImageView imageView) {
			ImageLoaderManager.getInstance().displayImageForView(imageView, uri.toString());
		}

		//必须实现这个方法，返回uri对应的缓存文件，可参照下面的实现，内部保存图片会用到。如果你不需要保存图片这个功能，可以返回null。
		@Override
		public File getImageFile(@NonNull Context context, @NonNull Object uri) {
			try {
				return ImageLoaderManager.getInstance().getImageFile(context, uri.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
