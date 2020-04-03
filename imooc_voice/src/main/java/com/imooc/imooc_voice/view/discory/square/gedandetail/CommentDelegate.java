package com.imooc.imooc_voice.view.discory.square.gedandetail;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.PlayListCommentEntity;
import com.imooc.imooc_voice.model.newapi.song.CommentLikeBean;
import com.imooc.imooc_voice.model.newapi.song.MusicCommentBean;
import com.imooc.imooc_voice.model.newapi.song.PlayListCommentBean;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;


public class CommentDelegate extends NeteaseLoadingDelegate implements View.OnClickListener{

	private ImageView mGedanImg;
	private TextView mGedanTitle;
	private TextView mGedanCreator;
	private TextView mTvGedanCommentTitle;
	private RelativeLayout mRlGedanHeader;
	private ImageView mBackView;

	private MultipleSectionGedanCommentAdapter mAdapter;
	private RecyclerView mRecyclerViewComment;

	private static final String ARGS_COMMENT_ID = "ARGS_COMMENT_ID";
	private static final String ARGS_COMMENT_TYPE = "ARGS_COMMENT_TYPE";
	private static final String ARGS_COMMENT_COUNT = "ARGS_COMMENT_COUNT";
	private static final String ARGS_COMMENT_HEADER_IMG = "ARGS_COMMENT_HEADER_IMG";
	private static final String ARGS_COMMENT_HEADER_TOP = "ARGS_COMMENT_HEADER_TOP";
	private static final String ARGS_COMMENT_HEADER_BOTTOM = "ARGS_COMMENT_HEADER_BOTTOM";


	public static final int SONG = 1;
	public static final int PLAYLIST = 2;
	public static final int ALBUM = 3;

	//歌单ID
	private String id;

	private int type;
	//评论数量
	private String count;
	//歌单图片
	private String headerImg;
	//歌单创建者
	private String headerTop;
	//歌单标题
	private String headerBottom;

	private ArrayList<PlayListCommentEntity> entities = new ArrayList<>();

	public static CommentDelegate newInstance(String id, int type, String commentCount, String img, String creator, String title) {
		final Bundle args = new Bundle();
		args.putString(ARGS_COMMENT_ID, id);
		args.putString(ARGS_COMMENT_COUNT, commentCount);
		args.putString(ARGS_COMMENT_HEADER_IMG, img);
		args.putString(ARGS_COMMENT_HEADER_BOTTOM, creator);
		args.putString(ARGS_COMMENT_HEADER_TOP, title);
		args.putInt(ARGS_COMMENT_TYPE, type);
		final CommentDelegate delegate = new CommentDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			id = args.getString(ARGS_COMMENT_ID);
			count = args.getString(ARGS_COMMENT_COUNT);
			headerImg = args.getString(ARGS_COMMENT_HEADER_IMG);
			headerTop = args.getString(ARGS_COMMENT_HEADER_TOP);
			headerBottom = args.getString(ARGS_COMMENT_HEADER_BOTTOM);
			type = args.getInt(ARGS_COMMENT_TYPE);
		}
	}


	@Override
	public void initView() {
		initCommentView();
	}

	@Override
	public int setLoadingViewLayout() {
		return R.layout.delegate_gedan_detail_comment;
	}


	@SuppressLint({"StaticFieldLeak", "SetTextI18n"})
	private void initCommentView() {

		mRecyclerViewComment = rootView.findViewById(R.id.rv_gedan_comment_normal);
		mGedanTitle = rootView.findViewById(R.id.tv_gedan_detail_comment_title);
		mGedanCreator = rootView.findViewById(R.id.tv_gedan_detail_comment_creator);
		mRlGedanHeader = rootView.findViewById(R.id.rl_gedan_comment_header);
		mBackView = rootView.findViewById(R.id.img_gedan_comment_back);
		mTvGedanCommentTitle = rootView.findViewById(R.id.tv_gedan_detail_comment_num);

		mTvGedanCommentTitle.setText("评论(" + count + ")");
		mRlGedanHeader.setOnClickListener(this);
		mBackView.setOnClickListener(this);
		mGedanCreator.setText(headerBottom);
		mGedanTitle.setText(headerTop);

		ImageLoaderManager.getInstance().displayImageForCorner((ImageView)rootView.findViewById(R.id.iv_gedan_detail_comment_img), headerImg, 5);

		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
			}

			@Override
			protected Void doInBackground(Void... voids) {
				switch (type){
					case PLAYLIST:
						//歌单评论
						RequestCenter.getPlaylistComment(id, new DisposeDataListener() {
							@Override
							public void onSuccess(Object responseObj) {
								loadCommentList((PlayListCommentBean) responseObj);
							}

							@Override
							public void onFailure(Object reasonObj) {

							}
						});
						break;
					//专辑评论
					case ALBUM:
						break;


				}


				return null;
			}
		}.execute();
	}

	private void loadCommentList(PlayListCommentBean responseObj) {
		entities.add(new PlayListCommentEntity(true, "精彩评论", ""));
		for(int i = 0; i< responseObj.getHotComments().size(); i++){
			entities.add(new PlayListCommentEntity(responseObj.getHotComments().get(i)));
		}
		entities.add(new PlayListCommentEntity(true, "最新评论", count));
		for(int j = 0; j< responseObj.getComments().size(); j++){
			entities.add(new PlayListCommentEntity(responseObj.getComments().get(j)));
		}
		mAdapter = new MultipleSectionGedanCommentAdapter(entities);
		mRecyclerViewComment.setAdapter(mAdapter);
		mRecyclerViewComment.setLayoutManager(new LinearLayoutManager(getContext()){
			@Override
			public boolean canScrollVertically() {
				return false;
			}
		});
		addRootView();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.rl_gedan_comment_header:
			case R.id.img_gedan_comment_back:
				getSupportDelegate().pop();
				break;
			default:
				break;
		}
	}

	class MultipleSectionGedanCommentAdapter extends BaseSectionQuickAdapter<PlayListCommentEntity, BaseViewHolder> {

		private ImageLoaderManager manager;

		MultipleSectionGedanCommentAdapter(List<PlayListCommentEntity> data) {
			super(R.layout.item_gedan_detail_comment, R.layout.item_gedan_comment_header, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convertHead(BaseViewHolder baseViewHolder, PlayListCommentEntity playListCommentEntity) {
			baseViewHolder.setText(R.id.tv_gedan_detail_comment_header_title, playListCommentEntity.header);
			baseViewHolder.setText(R.id.tv_gedan_detail_comment_header_count, playListCommentEntity.getCount());
		}

		@Override
		protected void convert(@NonNull final BaseViewHolder baseViewHolder, PlayListCommentEntity playListCommentEntity) {
			final MusicCommentBean.CommentsBean bean = playListCommentEntity.t;
			ImageView avatarImg = baseViewHolder.getView(R.id.iv_item_gedan_comment_avatar_img);
			manager.displayImageForCircle(avatarImg, bean.getUser().getAvatarUrl());
			baseViewHolder.setText(R.id.tv_item_gedan_comment_avatar_name, bean.getUser().getNickname());
			if(bean.getLikedCount() != 0){
				baseViewHolder.setVisible(R.id.tv_item_gedan_comment_zan_count, true);
				baseViewHolder.setText(R.id.tv_item_gedan_comment_zan_count, String.valueOf(bean.getLikedCount()));
			}
			baseViewHolder.setText(R.id.tv_item_gedan_comment_content, bean.getContent());
			if(bean.getBeReplied().size() != 0){
				baseViewHolder.setVisible(R.id.tv_item_gedan_comment_replied, true);
				baseViewHolder.setText(R.id.tv_item_gedan_comment_replied, bean.getBeReplied().size() + "条回复");
			}
			baseViewHolder.setText(R.id.tv_item_gedan_comment_content, bean.getContent());
			final ImageView zanView = baseViewHolder.getView(R.id.iv_item_gedan_comment_zan);
			//tag : true 当前是赞 false当前不是赞
			zanView.setTag(false);
			baseViewHolder.setOnClickListener(R.id.iv_item_gedan_comment_zan, new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if(!(Boolean) zanView.getTag()){
						zanView.setImageResource(R.drawable.zan_red);
						//点赞
						AnimatorSet animatorSetsuofang = new AnimatorSet();//组合动画
						ObjectAnimator scaleX = ObjectAnimator.ofFloat(zanView, "scaleX", 1f, 1.5f,1f);
						ObjectAnimator scaleY = ObjectAnimator.ofFloat(zanView, "scaleY", 1f, 1.5f,1f);
						baseViewHolder.setText(R.id.tv_item_gedan_comment_zan_count, String.valueOf(bean.getLikedCount() + 1));
						baseViewHolder.setTextColor(R.id.tv_item_gedan_comment_zan_count, Color.parseColor("#FF3A3A"));
						RequestCenter.getlikeComment(id, bean.getCommentId(), 1, 2, new DisposeDataListener() {
							@Override
							public void onSuccess(Object responseObj) {
								CommentLikeBean bean = (CommentLikeBean) responseObj;
								if(bean.getCode() == 200){
									Toast.makeText(getContext(), "点赞成功",Toast.LENGTH_SHORT).show();
								}else{
									Toast.makeText(getContext(), "点赞失败",Toast.LENGTH_SHORT).show();
								}
							}

							@Override
							public void onFailure(Object reasonObj) {
								Toast.makeText(getContext(), "点赞失败",Toast.LENGTH_SHORT).show();
							}
						});
						animatorSetsuofang.setDuration(500);
						animatorSetsuofang.setInterpolator(new DecelerateInterpolator());
						animatorSetsuofang.play(scaleX).with(scaleY);//两个动画同时开始
						animatorSetsuofang.start();
						zanView.setTag(true);
					}else{
						baseViewHolder.setText(R.id.tv_item_gedan_comment_zan_count, String.valueOf(bean.getLikedCount()));
						zanView.setImageResource(R.drawable.zan);
						zanView.setTag(false);
						baseViewHolder.setTextColor(R.id.tv_item_gedan_comment_zan_count, Color.GRAY);
						RequestCenter.getlikeComment(id, bean.getCommentId(), 0, 2, new DisposeDataListener() {
							@Override
							public void onSuccess(Object responseObj) {
								CommentLikeBean bean = (CommentLikeBean) responseObj;
								if(bean.getCode() == 200){
									Toast.makeText(getContext(), "取消赞成功",Toast.LENGTH_SHORT).show();
								}else{
									Toast.makeText(getContext(), "取消赞失败",Toast.LENGTH_SHORT).show();
								}
							}

							@Override
							public void onFailure(Object reasonObj) {
								Toast.makeText(getContext(), "取消赞失败",Toast.LENGTH_SHORT).show();
							}
						});
					}
				}
			});
		}


	}
}
