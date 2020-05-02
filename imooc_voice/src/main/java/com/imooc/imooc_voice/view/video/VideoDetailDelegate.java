package com.imooc.imooc_voice.view.video;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.api.VideoDetailBean;
import com.imooc.imooc_voice.api.VideoRelatedBean;
import com.imooc.imooc_voice.model.newapi.PlayListCommentEntity;
import com.imooc.imooc_voice.model.newapi.VideoBean;
import com.imooc.imooc_voice.model.newapi.VideoUrlBean;
import com.imooc.imooc_voice.model.newapi.search.FeedSearchBean;
import com.imooc.imooc_voice.model.newapi.song.PlayListCommentBean;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.view.discory.square.detail.CommentDelegate;
import com.imooc.imooc_voice.view.home.search.sort.VideoSearchDelegate;
import com.imooc.imooc_voice.view.user.UserDetailDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.imooc.lib_share.share.ShareContentData;
import com.imooc.lib_share.share.ShareDialog;
import com.imooc.lib_video.videoplayer.CustomJzVideoView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;

import static com.imooc.imooc_voice.Constants.VIDEO;


//视频详情
public class VideoDetailDelegate extends NeteaseLoadingDelegate {

	private static final String ARGS_VIDEO_ID = "ARGS_VIDEO_ID";

	@BindView(R2.id.tv_video_detail_toolbar_title)
	TextView mTvToolBarTitle;
	@BindView(R2.id.videoplayer)
	CustomJzVideoView mVideoView;
	@BindView(R2.id.tv_video_detail_title)
	TextView mTvTitle;
	@BindView(R2.id.tv_video_detail_playtime)
	TextView mTvPlayTime;
	@BindView(R2.id.iv_singer_avatar)
	ImageView mIvCreatorAvatar;
	@BindView(R2.id.tv_singer_name)
	TextView mTvCreatorName;
	@BindView(R2.id.tv_video_detail_praise_count)
	TextView mTvPraiseCount;
	@BindView(R2.id.tv_video_detail_collect_count)
	TextView mTvCollectCount;
	@BindView(R2.id.tv_video_detail_comment_count)
	TextView mTvCommentCount;
	@BindView(R2.id.tv_video_detail_share_count)
	TextView mTvShareCount;
	@BindView(R2.id.rl_singer)
	RelativeLayout mRlCrearor;
	@BindView(R2.id.ll_singer_follow)
	LinearLayout mLlFollow;
	@BindView(R2.id.ll_singer_followed)
	LinearLayout mLlFollowed;

	private RecyclerView mRvRelateVideo;
	private RecyclerView mRvVideoComment;

	private String videoId;

	private VideoBean.Creator creator;
	private ArrayList<PlayListCommentEntity> entities = new ArrayList<>();

	private CommentDelegate.MultipleSectionGedanCommentAdapter mCommentAdapter;
	private VideoSearchDelegate.VideoSearchAdapter mRelatedAdapter;


	public static VideoDetailDelegate newInstance(String id) {
		final Bundle args = new Bundle();
		args.putString(ARGS_VIDEO_ID, id);
		final VideoDetailDelegate delegate = new VideoDetailDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			videoId = args.getString(ARGS_VIDEO_ID);
		}
	}


	@Override
	public boolean onBackPressedSupport() {
		if (Jzvd.backPress()) {
			return false;
		} else {
			return super.onBackPressedSupport();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		Jzvd.releaseAllVideos();
	}

	@Override
	public Object setLayout() {
		return R.layout.delegate_video_detail;
	}

	@Override
	public void initView() {

		mRvRelateVideo = rootView.findViewById(R.id.rv_video_related);
		mRvVideoComment = rootView.findViewById(R.id.rv_video_comment);

		RequestCenter.getVideoDetail(videoId, new DisposeDataListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onSuccess(Object responseObj) {
				VideoDetailBean bean = (VideoDetailBean) responseObj;
				VideoBean.Data data = bean.getData();
				mTvToolBarTitle.setText(data.getTitle());
				mTvTitle.setText(data.getTitle());
				mTvPlayTime.setText(SearchUtil.getCorresPondingString(data.getPlaytime()) + "次观看");
				//视频创作者 头像
				ImageLoaderManager.getInstance().displayImageForCircle(mIvCreatorAvatar, data.getCreator().getAvatarurl());
				//名字
				mTvCreatorName.setText(data.getCreator().getNickname());
				creator = data.getCreator();
				//是否已经关注
				if (creator.getFollowed()) {
					//已关注
					mLlFollowed.setVisibility(View.VISIBLE);
				} else {
					//未关注
					mLlFollow.setVisibility(View.VISIBLE);
				}
				//是否已经收藏或者点赞
				if (data.getPraised()) {
					//已经点赞过
				} else {

				}

				if (data.getSubscribed()) {
					//已经收藏过
				} else {

				}
				//点赞收藏评论分享 数量
				mTvPraiseCount.setText(data.getPraisedcount());
				mTvCollectCount.setText(data.getSubscribeCount());
				mTvCommentCount.setText(data.getCommentcount());
				mTvShareCount.setText(data.getSharecount());

				//播放url
				RequestCenter.getVideoUrl(data.getVid(), new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						VideoUrlBean item = (VideoUrlBean) responseObj;
						//视频播放View
						ImageLoaderManager.getInstance().displayImageForView(mVideoView.posterImageView, data.getCoverurl());
						mVideoView.setUp(item.getUrls().get(0).getUrl(), "", Jzvd.SCREEN_NORMAL);
						//自动播放
						mVideoView.startVideo();
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
				//加载 相关视频和评论
				RequestCenter.getVideoRelated(videoId, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						VideoRelatedBean videoRelatedBean = (VideoRelatedBean) responseObj;
						ArrayList<FeedSearchBean.ResultBean.VideosBean> relatedVideos = videoRelatedBean.getData();
						View relatedHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.item_gedan_comment_header, null, false);
						((TextView) relatedHeaderView.findViewById(R.id.tv_gedan_detail_comment_header_title)).setText("相关视频");
						relatedHeaderView.findViewById(R.id.tv_gedan_detail_comment_header_count).setVisibility(View.INVISIBLE);
						mRelatedAdapter = new VideoSearchDelegate.VideoSearchAdapter(relatedVideos);
						mRelatedAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
							@Override
							public void onItemClick(BaseQuickAdapter adapter, View view, int i) {
								FeedSearchBean.ResultBean.VideosBean entity = (FeedSearchBean.ResultBean.VideosBean) adapter.getItem(i);
								getParentDelegate().getSupportDelegate().start(VideoDetailDelegate.newInstance(entity.getVid()));
							}
						});
						mRelatedAdapter.setHeaderView(relatedHeaderView);
						mRvRelateVideo.setAdapter(mRelatedAdapter);
						mRvRelateVideo.setLayoutManager(new LinearLayoutManager(getContext()));

					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
				//加载评论
				RequestCenter.getVideoComment(videoId, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						PlayListCommentBean bean = (PlayListCommentBean) responseObj;
						entities.add(new PlayListCommentEntity(true, "精彩评论", ""));
						for (int i = 0; i < bean.getHotComments().size(); i++) {
							entities.add(new PlayListCommentEntity(bean.getHotComments().get(i)));
						}
						entities.add(new PlayListCommentEntity(true, "最新评论", String.valueOf(bean.getComments().size())));
						for (int j = 0; j < bean.getComments().size(); j++) {
							entities.add(new PlayListCommentEntity(bean.getComments().get(j)));
						}
						mCommentAdapter = new CommentDelegate.MultipleSectionGedanCommentAdapter(videoId, VIDEO, getContext(), entities);
						mRvVideoComment.setAdapter(mCommentAdapter);
						mRvVideoComment.setLayoutManager(new LinearLayoutManager(getContext()) {
							@Override
							public boolean canScrollVertically() {
								return false;
							}
						});
						addRootView();
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});


			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_video_detail_loading_view;
	}


	//给视频点赞或取消点赞
	@OnClick(R2.id.iv_video_detail_praise)
	void onClickPraise() {

	}

	//收藏该视频或取消收藏
	@OnClick(R2.id.iv_video_detail_collect)
	void onClickCollect() {

	}

	//滚动到评论处
	@OnClick(R2.id.iv_video_detail_comment)
	void onClickComment() {

	}

	//分享组件
	@OnClick(R2.id.iv_video_detail_share)
	void onClickShare() {
		ShareContentData shareContentData = ShareContentData.Builder().shareSite("")
				.shareType(5)
				.shareSite("imooc")
				.shareTileUrl("http://www.imooc.com")
				.shareText("慕课网");

		ShareDialog shareDialog = new ShareDialog(getContext(), false, shareContentData);
		shareDialog.show();
	}


	//视频作者
	@OnClick(R2.id.rl_singer)
	void onClickCreator() {
		if (creator != null) {
			getParentDelegate().getSupportDelegate().start(UserDetailDelegate.newInstance(String.valueOf(creator.getUserid())));
		}
	}

	@OnClick(R2.id.img_video_detail_back)
	void onClickBack() {
		getSupportDelegate().pop();
	}
}
