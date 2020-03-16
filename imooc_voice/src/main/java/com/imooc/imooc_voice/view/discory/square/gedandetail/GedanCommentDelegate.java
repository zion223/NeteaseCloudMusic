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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.PlayListCommentEntity;
import com.imooc.imooc_voice.model.newapi.song.CommentLikeBean;
import com.imooc.imooc_voice.model.newapi.song.MusicCommentBean;
import com.imooc.imooc_voice.model.newapi.song.PlayListCommentBean;
import com.imooc.lib_common_ui.app.Netease;
import com.imooc.lib_common_ui.delegate.NeteaseLoadingDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GedanCommentDelegate extends NeteaseLoadingDelegate implements View.OnClickListener{

	@BindView(R2.id.loadframe)
	FrameLayout frameLayout;

	private View view;

	RecyclerView mRecyclerViewGedanComment;
	private ImageView mGedanImg;
	private TextView mGedanTitle;
	private TextView mGedanCreator;
	private TextView mTvGedanCommentTitle;
	private RelativeLayout mRlGedanHeader;
	private ImageView mBackView;
	private MultipleSectionGedanCommentAdapter mAdapter;

	private static final String ARGS_GEDAN_ID = "ARGS_GEDAN_ID";
	private static final String ARGS_GEDAN_COMMENT_COUNT = "ARGS_GEDAN_COMMENT_COUNT";
	private static final String ARGS_GEDAN_COMMENT_IMG = "ARGS_GEDAN_COMMENT_IMG";
	private static final String ARGS_GEDAN_COMMENT_CREATOR = "ARGS_GEDAN_COMMENT_CREATOR";
	private static final String ARGS_GEDAN_COMMENT_TITLE = "ARGS_GEDAN_COMMENT_TITLE";

	//歌单ID
	private String id;
	//评论数量
	private String count;
	//歌单图片
	private String gedanImg;
	//歌单创建者
	private String gedanCreator;
	//歌单标题
	private String gedanTitle;


	public static GedanCommentDelegate newInstance(String id, String commentCount, String img, String creator, String title) {
		final Bundle args = new Bundle();
		args.putString(ARGS_GEDAN_ID, id);
		args.putString(ARGS_GEDAN_COMMENT_COUNT, commentCount);
		args.putString(ARGS_GEDAN_COMMENT_IMG, img);
		args.putString(ARGS_GEDAN_COMMENT_CREATOR, creator);
		args.putString(ARGS_GEDAN_COMMENT_TITLE, title);
		final GedanCommentDelegate delegate = new GedanCommentDelegate();
		delegate.setArguments(args);
		return delegate;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle args = getArguments();
		if (args != null) {
			id = args.getString(ARGS_GEDAN_ID);
			count = args.getString(ARGS_GEDAN_COMMENT_COUNT);
			gedanImg = args.getString(ARGS_GEDAN_COMMENT_IMG);
			gedanCreator = args.getString(ARGS_GEDAN_COMMENT_CREATOR);
			gedanTitle = args.getString(ARGS_GEDAN_COMMENT_TITLE);
		}
	}


	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		super.onBindView(savedInstanceState, view);
		initCommentView();
	}


	@SuppressLint("StaticFieldLeak")
	private void initCommentView() {
		final ArrayList<PlayListCommentEntity> entities = new ArrayList<>();
		view = LayoutInflater.from(getContext()).inflate(R.layout.delegate_gedan_detail_comment, frameLayout, false);
		mRecyclerViewGedanComment = view.findViewById(R.id.rv_gedan_comment_normal);
		mGedanTitle = view.findViewById(R.id.tv_gedan_detail_comment_title);
		mGedanCreator = view.findViewById(R.id.tv_gedan_detail_comment_creator);
		mRlGedanHeader = view.findViewById(R.id.rl_gedan_comment_header);
		mBackView = view.findViewById(R.id.img_gedan_comment_back);
		mTvGedanCommentTitle = view.findViewById(R.id.tv_gedan_detail_comment_num);
		mTvGedanCommentTitle.setText("评论(" + count + ")");
		mRlGedanHeader.setOnClickListener(this);
		mBackView.setOnClickListener(this);
		mGedanCreator.setText(gedanCreator);
		mGedanTitle.setText(gedanTitle);
		ImageLoaderManager.getInstance().displayImageForCorner((ImageView)view.findViewById(R.id.iv_gedan_detail_comment_img), gedanImg, 5);

		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
				Netease.getHandler().postDelayed(new Runnable() {
					@Override
					public void run() {
						frameLayout.removeAllViews();
						//framelayout 创建了新的实例
						ViewGroup p = (ViewGroup) view.getParent();
						if (p != null) {
							p.removeAllViewsInLayout();
						}
						frameLayout.addView(view);
					}
				}, 500);

			}

			@Override
			protected Void doInBackground(Void... voids) {
				RequestCenter.getPlaylistComment(id, new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						PlayListCommentBean bean = (PlayListCommentBean) responseObj;
						entities.add(new PlayListCommentEntity(true, "精彩评论", ""));
						for(int i=0;i<bean.getHotComments().size();i++){
							entities.add(new PlayListCommentEntity(bean.getHotComments().get(i)));
						}
						entities.add(new PlayListCommentEntity(true, "最新评论", count));
						for(int j=0;j<bean.getComments().size();j++){
							entities.add(new PlayListCommentEntity(bean.getComments().get(j)));
						}
						mAdapter = new MultipleSectionGedanCommentAdapter(entities);
						mRecyclerViewGedanComment.setAdapter(mAdapter);
						mRecyclerViewGedanComment.setLayoutManager(new LinearLayoutManager(getContext()){
							@Override
							public boolean canScrollVertically() {
								return false;
							}
						});
					}

					@Override
					public void onFailure(Object reasonObj) {

					}
				});
				return null;
			}
		}.execute();
	}

	@Override
	public void post(Runnable runnable) {

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
		ImageView zanView;

		public MultipleSectionGedanCommentAdapter(List<PlayListCommentEntity> data) {
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
