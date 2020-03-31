package com.imooc.imooc_voice.view.discory;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.newapi.BannerBean;
import com.imooc.imooc_voice.model.newapi.LoginBean;
import com.imooc.imooc_voice.model.newapi.MainRecommendPlayListBean;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.view.discory.daily.DailyRecommendDelegate;
import com.imooc.imooc_voice.view.discory.radio.RadioDelegate;
import com.imooc.imooc_voice.view.discory.square.gedandetail.GedanDetailDelegate;
import com.imooc.imooc_voice.view.discory.square.GedanSquareDelegate;
import com.imooc.lib_common_ui.bannder.BannerCreator;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.exception.OkHttpException;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DiscoverDelegate extends NeteaseDelegate {


	/**
	 * 发现页面
	 * 		轮播图
	 * 		每日推荐、歌单、排行榜、电台、私人FM
	 * 		推荐歌单(6个歌单)   歌单广场
	 * 		新碟 新歌  新歌推荐
	 *
	 */

	@BindView(R2.id.banner_recycler_item)
	ConvenientBanner convenientBanner;
	@BindView(R2.id.rv_discover_gedan)
	RecyclerView mRecyclerViewGedan;
	@BindView(R2.id.rv_discover_album_song)
	RecyclerView mRecyclerViewAlbumSong;
	@BindView(R2.id.tv_discover_more_album_song)
	TextView mTvAlbumOrSong;
	@BindView(R2.id.tv_discover_new_album)
	TextView mTvCurrentAlbum;
	@BindView(R2.id.tv_discover_new_song)
	TextView mTvCurrentSong;

	private RecommendPlayListAdapter mGedanAdapter;

	private static final String TAG = "DiscoverDelegate";
	private int ALBUM_OR_SONG = 0;

	@Override
	public Object setLayout() {
		return R.layout.delegate_discover;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {

		final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
		LoginBean loginBean = GsonUtil.fromJSON(SharePreferenceUtil.getInstance(getContext()).getUserInfo(""), LoginBean.class);
		Log.e(TAG,"userId:" + loginBean.getProfile().getUserId());
		/*
		 * 查询轮播图
		 */
		RequestCenter.getBanner(2, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				BannerBean bannerBean = (BannerBean) responseObj;
				List<BannerBean.BannersBean> banners = bannerBean.getBanners();
				ArrayList<String> banner = new ArrayList<>();
				for(BannerBean.BannersBean item: banners){
					banner.add(item.getPic());
				}
				//TODO 设置Banner的点击事件
				BannerCreator.setDefault(convenientBanner, banner, null);
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
		/*
		 * 推荐歌单
		 */
		RequestCenter.getRecommendPlayList(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				MainRecommendPlayListBean bean = ((MainRecommendPlayListBean)responseObj);
				List<MainRecommendPlayListBean.RecommendBean> geDan = bean.getRecommend();
				geDan = geDan.subList(0, 6);
				mGedanAdapter = new RecommendPlayListAdapter(geDan);
				mRecyclerViewGedan.setAdapter(mGedanAdapter);
				mRecyclerViewGedan.setLayoutManager(gridLayoutManager);
				mGedanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						MainRecommendPlayListBean.RecommendBean item = (MainRecommendPlayListBean.RecommendBean) adapter.getItem(position);
						getParentDelegate().getSupportDelegate().start(GedanDetailDelegate.newInstance(String.valueOf(item.getId())));
					}
				});
			}

			@Override
			public void onFailure(Object reasonObj) {
				OkHttpException exception = (OkHttpException) reasonObj;
				Log.e(TAG, exception.getEmsg().toString());
			}
		});
		/*
		 * 新碟
		 */
//		RequestCenter.queryNewAlbumList(0, 3, new DisposeDataListener() {
//			@Override
//			public void onSuccess(Object responseObj) {
//				BillListJson json = (BillListJson) responseObj;
//				ArrayList<BillListJson.BillList> song_list = json.getSong_list();
//
//			}
//
//			@Override
//			public void onFailure(Object reasonObj) {
//
//			}
//		});
//		/*
//		 *	新歌
//		 */
//		RequestCenter.queryNewSongList(0, 3, new DisposeDataListener() {
//			@Override
//			public void onSuccess(Object responseObj) {
//				BillListJson json = (BillListJson) responseObj;
//				ArrayList<BillListJson.BillList> song_list = json.getSong_list();
//				mAlbumSongAdapter = new AlbumSongAdapter(song_list, 0);
//				mRecyclerViewAlbumSong.setAdapter(mAlbumSongAdapter);
//				GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
//				mRecyclerViewAlbumSong.setLayoutManager(manager);
//			}
//
//			@Override
//			public void onFailure(Object reasonObj) {
//
//			}
//		});
		changeAlbumOrSong(ALBUM_OR_SONG);

	}

	@Override
	public void post(Runnable runnable) {

	}

	/*
	 * 歌单广场
	 */
	@OnClick(R2.id.tv_discover_gedan_square)
	void onClickGedanSquare(){
		getParentDelegate().getSupportDelegate().start(new GedanSquareDelegate());
	}

	@OnClick(R2.id.tv_discover_new_album)
	void onClickChooseAlbum(){
		ALBUM_OR_SONG = 0;
		changeAlbumOrSong(ALBUM_OR_SONG);
	}

	@OnClick(R2.id.tv_discover_new_song)
	void onClickChooseSong(){
		ALBUM_OR_SONG = 1;
		changeAlbumOrSong(ALBUM_OR_SONG);
	}

	//每日推荐
	@OnClick(R2.id.ll_discover_daily_recommend)
	void onClickDaliyRecommend(){
		getParentDelegate().getSupportDelegate().start(new DailyRecommendDelegate());
	}

	//歌单
	@OnClick(R2.id.ll_discover_gedan)
	void onClickGedanSquree(){
		getParentDelegate().getSupportDelegate().start(new GedanSquareDelegate());
	}

	//排行榜
	@OnClick(R2.id.ll_discover_rank)
	void onClickRank(){

	}

	//电台
	@OnClick(R2.id.ll_discover_radio)
	void onClickRadio(){
		getParentDelegate().getSupportDelegate().start(new RadioDelegate());
	}





	void changeAlbumOrSong(int type){
		if(type ==0){
			//当前是新碟
			mTvCurrentAlbum.setTextColor(getResources().getColor(R.color.black));
			mTvCurrentAlbum.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
			mTvCurrentAlbum.setTextSize(15);

			mTvCurrentSong.setTextColor(getResources().getColor(R.color.gray));
			mTvCurrentSong.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
			mTvCurrentSong.setTextSize(12);

			mTvAlbumOrSong.setText("更多新碟");

		}else{
			mTvCurrentSong.setTextColor(getResources().getColor(R.color.black));
			mTvCurrentSong.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
			mTvCurrentSong.setTextSize(15);

			mTvCurrentAlbum.setTextColor(getResources().getColor(R.color.gray));
			mTvCurrentAlbum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
			mTvCurrentAlbum.setTextSize(12);

			mTvAlbumOrSong.setText("新歌推荐");
		}
	}

	static class RecommendPlayListAdapter extends BaseQuickAdapter<MainRecommendPlayListBean.RecommendBean, BaseViewHolder> {

		private ImageLoaderManager manager;

		public RecommendPlayListAdapter(@Nullable List<MainRecommendPlayListBean.RecommendBean> data) {
			super(R.layout.item_discover_gedan, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(BaseViewHolder helper, MainRecommendPlayListBean.RecommendBean item) {
			final ImageView geDanView = helper.getView(R.id.iv_item_discover);
			//显示圆角图片
			manager.displayImageForCorner(geDanView, item.getPicUrl(), 5);
			int playCount = item.getPlaycount();
			double playNum = (double)playCount/1000;
			helper.setText(R.id.tv_item_discover_playnum, playNum + "万");
			helper.setText(R.id.tv_item_discover_des, item.getName());
		}
	}

}
