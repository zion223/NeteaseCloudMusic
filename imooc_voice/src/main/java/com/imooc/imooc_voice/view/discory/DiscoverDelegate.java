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
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.util.SearchUtil;
import com.imooc.imooc_voice.util.TimeUtil;
import com.imooc.imooc_voice.view.discory.album.NewAlbumDelegate;
import com.imooc.imooc_voice.view.discory.daily.DailyRecommendDelegate;
import com.imooc.imooc_voice.view.discory.radio.RadioDelegate;
import com.imooc.imooc_voice.view.discory.rank.RankingDelegate;
import com.imooc.imooc_voice.view.discory.song.TopSongTabDelegate;
import com.imooc.imooc_voice.view.discory.square.GedanSquareDelegate;
import com.imooc.imooc_voice.view.discory.square.detail.SongListDetailDelegate;
import com.imooc.lib_api.HttpConstants;
import com.imooc.lib_api.RequestCenter;
import com.imooc.lib_api.model.album.AlbumOrSongBean;
import com.imooc.lib_api.model.banner.BannerBean;
import com.imooc.lib_api.model.playlist.DailyRecommendBean;
import com.imooc.lib_api.model.playlist.MainRecommendPlayListBean;
import com.imooc.lib_api.model.playlist.MyFmBean;
import com.imooc.lib_api.model.search.TopAlbumBean;
import com.imooc.lib_api.model.song.NewSongBean;
import com.imooc.lib_api.model.search.AlbumSearchBean;
import com.imooc.lib_api.model.song.SongDetailBean;
import com.imooc.lib_audio.app.AudioHelper;
import com.imooc.lib_api.model.song.AudioBean;
import com.imooc.lib_common_ui.bannder.BannerCreator;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.imooc.lib_common_ui.utils.Constants.ALBUM;
import static com.imooc.lib_common_ui.utils.Constants.PLAYLIST;
import static com.imooc.lib_common_ui.utils.Constants.SONG;

public class DiscoverDelegate extends NeteaseDelegate {

	private static final String TAG = "DiscoverDelegate";

	/**
	 * 发现页面
	 * 轮播图
	 * 每日推荐、歌单、排行榜、电台、私人FM
	 * 推荐歌单(6个歌单)   歌单广场
	 * 新碟(更多新碟) 新歌(新歌推荐)
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

	private RecommendPlayListAdapter mPlayListAdapter;
	private GridLayoutManager albumSongManager;



	private final ArrayList<AlbumOrSongBean> albumList = new ArrayList<>();
	private final ArrayList<AlbumOrSongBean> songList = new ArrayList<>();

	private AlbumSongAdapter mAlbumSongAdapter;

	@Override
	public Object setLayout() {
		return R.layout.delegate_discover;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) {

		albumSongManager = new GridLayoutManager(getContext(), 3);
		mRecyclerViewAlbumSong.setLayoutManager(albumSongManager);

		/*
		 * 查询轮播图
		 */
		RequestCenter.getBanner(2, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				BannerBean bannerBean = (BannerBean) responseObj;
				final List<BannerBean.BannersBean> banners = bannerBean.getBanners();
				ArrayList<String> banner = new ArrayList<>();
				for (BannerBean.BannersBean item : banners) {
					banner.add(item.getPic());
				}
				BannerCreator.setDefault(convenientBanner, banner, new OnItemClickListener() {
					@Override
					public void onItemClick(int position) {
						BannerBean.BannersBean item = banners.get(position);
						//歌曲
						if(item.getTargetType() == 4 || item.getTargetType() == 1){
							long songId = item.getTargetId();
							RequestCenter.getSongDetail(String.valueOf(songId), new DisposeDataListener() {
								@Override
								public void onSuccess(Object responseObj) {
									SongDetailBean songBean = (SongDetailBean) responseObj;
									//只有一首歌
									SongDetailBean.SongsBean bean = songBean.getSongs().get(0);
									String songPlayUrl = HttpConstants.getSongPlayUrl(bean.getId());
									AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(bean.getId()), songPlayUrl, bean.getName(), bean.getAr().get(0).getName(), bean.getAl().getName(), bean.getAl().getName(), bean.getAl().getPicUrl(), TimeUtil.getTimeNoYMDH(bean.getDt())));
								}

								@Override
								public void onFailure(Object reasonObj) {

								}
							});
						}else if(item.getTargetType() == 10){
							//专辑
							getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(ALBUM, item.getTargetId()));
						}
						//网页
						if(item.getUrl() != null ){
							getParentDelegate().getSupportDelegate().start(WebContainerDelegate.newInstance(item.getUrl()));
						}
					}
				});
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});


		final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
		/*
		 * 推荐歌单
		 */
		RequestCenter.getRecommendPlayList(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				MainRecommendPlayListBean bean = ((MainRecommendPlayListBean) responseObj);
				List<MainRecommendPlayListBean.RecommendBean> geDan = bean.getRecommend();
				geDan = geDan.subList(0, 6);
				mPlayListAdapter = new RecommendPlayListAdapter(geDan);
				mRecyclerViewGedan.setAdapter(mPlayListAdapter);
				mRecyclerViewGedan.setLayoutManager(gridLayoutManager);
				mPlayListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
						MainRecommendPlayListBean.RecommendBean item = (MainRecommendPlayListBean.RecommendBean) adapter.getItem(position);
						getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(PLAYLIST, item.getId(), item.getCopywriter()));
					}
				});
			}

			@Override
			public void onFailure(Object reasonObj) {
				Exception exception = (Exception) reasonObj;
				Log.e(TAG, exception.toString());
			}
		});
		/*
		 * 新碟上架  最新专辑
		 */
		RequestCenter.getTopAlbum(3, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				TopAlbumBean bean = (TopAlbumBean) responseObj;

				List<AlbumSearchBean.ResultBean.AlbumsBean> albums = bean.getWeekData();
				for (int i = 0; i < 3; i++) {
					String artistName = albums.get(i).getArtist().getName();
					String albumName = albums.get(i).getName();
					String picUrl = albums.get(i).getPicUrl();
					long id = albums.get(i).getId();
					albumList.add(new AlbumOrSongBean(String.valueOf(id), ALBUM, picUrl, albumName, artistName));
				}
				mAlbumSongAdapter = new AlbumSongAdapter(albumList);
				mAlbumSongAdapter.setOnItemClickListener((adpater, view1, i) -> {
					AlbumOrSongBean entity = (AlbumOrSongBean) adpater.getItem(i);
					//查看专辑
					if (entity != null && entity.getType() == ALBUM) {
						getParentDelegate().getSupportDelegate().start(SongListDetailDelegate.newInstance(ALBUM, entity.getId()));
					} else if(entity != null && entity.getType() == SONG){
						//播放歌曲
						long songId = entity.getId();
						RequestCenter.getSongDetail(String.valueOf(songId), new DisposeDataListener() {
							@Override
							public void onSuccess(Object responseObj) {
								SongDetailBean bean = (SongDetailBean) responseObj;
								//只有一首音乐
								SongDetailBean.SongsBean item = bean.getSongs().get(0);
								if(item != null){
									String songPlayUrl = HttpConstants.getSongPlayUrl(songId);
									AudioHelper.addAudio(getProxyActivity(), new AudioBean(String.valueOf(item.getId()), songPlayUrl, item.getName(), item.getAr().get(0).getName(), item.getAl().getName(), item.getAl().getName(), item.getAl().getPicUrl(), TimeUtil.getTimeNoYMDH(item.getDt())));
								}
							}

							@Override
							public void onFailure(Object reasonObj) {

							}
						});

					}
				});
				mRecyclerViewAlbumSong.setAdapter(mAlbumSongAdapter);
				//防止列表为空
				changeAlbumOrSong(ALBUM);
			}

			@Override
			public void onFailure(Object reasonObj) {
			}
		});
		/*
		 *	新歌  新歌速递
		 */
		RequestCenter.getTopSong(0, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				NewSongBean bean = (NewSongBean) responseObj;

				List<DailyRecommendBean.RecommendBean> data = bean.getData();
				for (int i = 0; i < 3; i++) {
					String artistName = data.get(i).getArtists().get(0).getName();
					String albumName = data.get(i).getName();
					String picUrl = data.get(i).getAlbum().getPicUrl();
					long id = data.get(i).getId();
					songList.add(new AlbumOrSongBean(String.valueOf(id), SONG, picUrl, albumName, artistName));
				}
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});


	}


	/*
	 * 歌单广场
	 */
	@OnClick(R2.id.tv_discover_gedan_square)
	void onClickGedanSquare() {
		getParentDelegate().getSupportDelegate().start(new GedanSquareDelegate());
	}

	//切换新歌和新碟
	@OnClick(R2.id.tv_discover_new_album)
	void onClickChooseAlbum() {
		changeAlbumOrSong(ALBUM);
	}

	//切换新歌和新碟
	@OnClick(R2.id.tv_discover_new_song)
	void onClickChooseSong() {
		changeAlbumOrSong(SONG);
	}

	//每日推荐
	@OnClick(R2.id.ll_discover_daily_recommend)
	void onClickDaliyRecommend() {
		getParentDelegate().getSupportDelegate().start(new DailyRecommendDelegate());
	}

	//歌单
	@OnClick(R2.id.ll_discover_gedan)
	void onClickGedanSquree() {
		getParentDelegate().getSupportDelegate().start(new GedanSquareDelegate());
	}

	// TODO 私人FM
	@OnClick(R2.id.ll_discover_myfm)
	void onClickMyFm(){
		/*
		 *	私人FM 不显示播放队列   播放队列的位置为显示"喜欢"图标
		 *	当请求的歌曲播放完毕后需要再次请求数据
		 *  播放过的歌曲就丢弃
		 *  ViewPager不可以左滑
		 *  没有左箭头 左箭头的位置是"喜欢"图标 左边是"不喜欢"图标  点击"不喜欢"图标 会切换下一首歌曲
		 *
		 */
		RequestCenter.getMyFm(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				MyFmBean bean = (MyFmBean) responseObj;
				//加入播放队列
				List<DailyRecommendBean.RecommendBean> fmData = bean.getData();
				//AudioHelper.addAudio();
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}

	//排行榜
	@OnClick(R2.id.ll_discover_rank)
	void onClickRank() {
		getParentDelegate().getSupportDelegate().start(new RankingDelegate());
	}

	//电台
	@OnClick(R2.id.ll_discover_radio)
	void onClickRadio() {
		getParentDelegate().getSupportDelegate().start(new RadioDelegate());
	}

	//新歌推荐或者更多新碟
	@OnClick(R2.id.tv_discover_more_album_song)
	void onClickAlbumOrSong() {
		if ((int) mTvAlbumOrSong.getTag() == ALBUM) {
			getParentDelegate().getSupportDelegate().start(new NewAlbumDelegate());
		}else{
			getParentDelegate().getSupportDelegate().start(new TopSongTabDelegate());
		}
	}



	void changeAlbumOrSong(int type) {
		switch (type){
			case ALBUM:
				//当前是新碟
				mTvCurrentAlbum.setTextColor(getResources().getColor(R.color.black));
				mTvCurrentAlbum.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
				mTvCurrentAlbum.setTextSize(15);

				mTvCurrentSong.setTextColor(getResources().getColor(R.color.gray));
				mTvCurrentSong.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
				mTvCurrentSong.setTextSize(12);

				mTvAlbumOrSong.setText("更多新碟");
				mAlbumSongAdapter.setNewData(albumList);
				mTvAlbumOrSong.setTag(ALBUM);
				break;
			case SONG:
				mTvCurrentSong.setTextColor(getResources().getColor(R.color.black));
				mTvCurrentSong.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
				mTvCurrentSong.setTextSize(15);

				mTvCurrentAlbum.setTextColor(getResources().getColor(R.color.gray));
				mTvCurrentAlbum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
				mTvCurrentAlbum.setTextSize(12);

				mTvAlbumOrSong.setText("新歌推荐");
				//addAll方法改变原数组内容
				mAlbumSongAdapter.setNewData(songList);
				mTvAlbumOrSong.setTag(SONG);
				break;
			default:
				break;
		}

	}

	static class RecommendPlayListAdapter extends BaseQuickAdapter<MainRecommendPlayListBean.RecommendBean, BaseViewHolder> {

		private ImageLoaderManager manager;

		RecommendPlayListAdapter(@Nullable List<MainRecommendPlayListBean.RecommendBean> data) {
			super(R.layout.item_discover_gedan, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(BaseViewHolder helper, MainRecommendPlayListBean.RecommendBean item) {
			final ImageView geDanView = helper.getView(R.id.iv_item_discover);
			//显示圆角图片
			manager.displayImageForCorner(geDanView, item.getPicUrl(), 5);
			//播放次数
			helper.setText(R.id.tv_item_discover_playnum, SearchUtil.getCorresPondingString(item.getPlaycount()));
			helper.setText(R.id.tv_item_discover_des, item.getName());
		}
	}

	static class AlbumSongAdapter extends BaseQuickAdapter<AlbumOrSongBean, BaseViewHolder> {
		private ImageLoaderManager manager;

		AlbumSongAdapter(@Nullable List<AlbumOrSongBean> data) {
			super(R.layout.item_discover_album_song, data);
			manager = ImageLoaderManager.getInstance();
		}

		@Override
		protected void convert(@NonNull BaseViewHolder adapter, AlbumOrSongBean entity) {
			//圆角图片
			manager.displayImageForCorner(adapter.getView(R.id.iv_item_album_song), entity.getPicUrl());
			adapter.setText(R.id.tv_item_album_song_name, entity.getTopText());
			adapter.setText(R.id.tv_item_album_song_artist, entity.getBottomText());
		}
	}

}
