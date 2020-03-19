package com.imooc.imooc_voice.view.mine;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.R2;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.model.mine.SpecData;
import com.imooc.imooc_voice.model.newapi.LoginBean;
import com.imooc.imooc_voice.model.newapi.SubCountBean;
import com.imooc.imooc_voice.model.newapi.personal.UserPlayListEntity;
import com.imooc.imooc_voice.model.newapi.personal.UserPlaylistBean;
import com.imooc.imooc_voice.util.GsonUtil;
import com.imooc.imooc_voice.util.SharePreferenceUtil;
import com.imooc.imooc_voice.view.discory.square.gedandetail.GedanDetailDelegate;
import com.imooc.imooc_voice.view.mine.local.LocalMusicDelegate;
import com.imooc.imooc_voice.view.mine.radio.MineRadioDelegate;
import com.imooc.lib_common_ui.delegate.NeteaseDelegate;
import com.imooc.lib_common_ui.dialog.CreatePlayListDialog;
import com.imooc.lib_image_loader.app.ImageLoaderManager;
import com.imooc.lib_network.listener.DisposeDataListener;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineDelegate extends NeteaseDelegate {


	@BindView(R2.id.fragment_main_item_title)
	TextView mTvLocalMusic;
	@BindView(R2.id.rv_spec_mine)
	RecyclerView mSpecRecyclerView;
	@BindView(R2.id.rv_mine_create_gedan)
	RecyclerView mRvSectionGedan;
	@BindView(R2.id.fragment_main_item_radio_count)
	TextView mTvRadioCount;

	private SpecAdapter mSpecAdapter;

	private ImageLoaderManager manager;

	@Override
	public Object setLayout() {
		return R.layout.delegate_mine;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View view) throws Exception {
		initSpecIcon();
		manager = ImageLoaderManager.getInstance();
		//查询用户创建的歌单
		LoginBean loginBean = GsonUtil.fromJSON(SharePreferenceUtil.getInstance(getContext()).getUserInfo(""), LoginBean.class);
		int id = loginBean.getProfile().getUserId();
		final ArrayList<UserPlayListEntity> entities = new ArrayList<>();
		final ArrayList<UserPlayListEntity> no_create_entities = new ArrayList<>();
		RequestCenter.getUserPlaylist(id, new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				UserPlaylistBean bean = (UserPlaylistBean) responseObj;
				List<UserPlaylistBean.PlaylistBean> playlist = bean.getPlaylist();
				int subIndex = 0;
				for(int i=0;i<playlist.size();i++){
					if(playlist.get(i).isSubscribed()){
						subIndex = i;
						break;
					}
				}
				entities.add(new UserPlayListEntity(true, "创建的歌单", subIndex));
				no_create_entities.add(new UserPlayListEntity(true, "创建的歌单", subIndex));
				for(int j = 0 ; j < subIndex; j++){
					entities.add(new UserPlayListEntity(playlist.get(j)));
				}
				entities.add(new UserPlayListEntity(true, "收藏的歌单", playlist.size() - subIndex));
				no_create_entities.add(new UserPlayListEntity(true, "收藏的歌单", playlist.size() - subIndex));
				for(int k = subIndex; k < playlist.size(); k++){
					entities.add(new UserPlayListEntity(playlist.get(k)));
					no_create_entities.add(new UserPlayListEntity(playlist.get(k)));
				}
				final MultipleSectionGedanAdapter multipleSectionGedanAdapter = new MultipleSectionGedanAdapter(entities);

				multipleSectionGedanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(BaseQuickAdapter adapter, View view, int positon) {
						//点击到header则执行 隐藏或显示动作 否则就进入歌单详情
						UserPlayListEntity entity = (UserPlayListEntity) adapter.getItem(positon);
						ImageView changeView = view.findViewById(R.id.iv_mine_gedan_state);
						if(entity.isHeader){
							//是创建的还是收藏的

							//显示动画
							if((boolean)changeView.getTag()){
								final ObjectAnimator hideRotate = ObjectAnimator.ofFloat(changeView, "rotation", 270f, 180f);
								hideRotate.setDuration(300);
								hideRotate.start();
								changeView.setTag(false);
							}else{
								final ObjectAnimator showRotate = ObjectAnimator.ofFloat(changeView, "rotation", 180f, 270f);
								showRotate.setDuration(300);
								showRotate.start();
								changeView.setTag(true);
							}
							if(entity.header.contains("创建")){
								if((boolean)changeView.getTag()){
									//隐藏创建的歌单
									//adapter.replaceData(no_create_entities);
								}else{
									//显示创建的歌单
									//adapter.replaceData(entities);
								}
							}else{
								//收藏的歌单
								if((boolean)changeView.getTag()){
									//隐藏收藏的歌单
								}else{
									//显示收藏的歌单
								}
							}
						}else{
							getParentDelegate().getSupportDelegate().start(GedanDetailDelegate.newInstance(String.valueOf(entity.t.getId())));
						}

					}
				});
				mRvSectionGedan.setAdapter(multipleSectionGedanAdapter);
				mRvSectionGedan.setLayoutManager(new LinearLayoutManager(getContext()){
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

		/*
		 * 获取用户信息
		 */
		RequestCenter.getsubCount(new DisposeDataListener() {
			@Override
			public void onSuccess(Object responseObj) {
				SubCountBean bean = (SubCountBean) responseObj;
				mTvRadioCount.setText("("+bean.getDjRadioCount()+")");
			}

			@Override
			public void onFailure(Object reasonObj) {

			}
		});
	}


	@OnClick(R2.id.ll_mine_local_music)
	void onClickLocalMusic(){
		getParentDelegate().getSupportDelegate().start(new LocalMusicDelegate());
	}

	@OnClick(R2.id.ll_mine_radio)
	void onClickMineRadio(){
		getParentDelegate().getSupportDelegate().start(new MineRadioDelegate());
	}

	@Override
	public void post(Runnable runnable) {

	}

	private void initSpecIcon() {
		List<SpecData> specData = new ArrayList<>();
		SpecData spec1 = new SpecData(R.drawable.t_dragonball_icn_carplay, "驾驶模式");
		SpecData spec2 = new SpecData(R.drawable.t_dragonball_icn_classical, "古典模式");
		SpecData spec3 = new SpecData(R.drawable.t_dragonball_icn_look, "直播");
		SpecData spec4 = new SpecData(R.drawable.t_dragonball_icn_radio, "电台");
		SpecData spec5 = new SpecData(R.drawable.t_dragonball_icn_sati, "睡眠空间");
		SpecData spec6 = new SpecData(R.drawable.t_dragonball_icn_xiaoice, "小冰电台");
		SpecData spec7 = new SpecData(R.drawable.t_dragonball_icn_rank, "排行榜");
		SpecData spec8 = new SpecData(R.drawable.t_dragonball_icn_daily, "每日推荐");
		specData.add(spec6);
		specData.add(spec7);
		specData.add(spec8);
		specData.add(spec1);
		specData.add(spec2);
		specData.add(spec3);
		specData.add(spec4);
		specData.add(spec5);
		LinearLayoutManager manager = new LinearLayoutManager(getContext());
		manager.setOrientation(LinearLayoutManager.HORIZONTAL);
		mSpecAdapter = new SpecAdapter(specData);
		mSpecRecyclerView.setAdapter(mSpecAdapter);
		mSpecRecyclerView.setLayoutManager(manager);
	}

	static class SpecAdapter extends BaseQuickAdapter<SpecData, BaseViewHolder>{

		SpecAdapter(@Nullable List<SpecData> data) {
			super(R.layout.item_mine_spec,data);
		}

		@Override
		protected void convert(BaseViewHolder helper, SpecData item) {
			((ImageView)helper.getView(R.id.iv_mine_spec)).setImageResource(item.getDrawableId());
			((TextView)helper.getView(R.id.tv_spec_name)).setText(item.getText());
		}
	}

	class MultipleSectionGedanAdapter extends BaseSectionQuickAdapter<UserPlayListEntity, BaseViewHolder> {


		MultipleSectionGedanAdapter(List<UserPlayListEntity> data) {
			super(R.layout.item_mine_gedan_content, R.layout.item_mine_gedan_header, data);
		}

		@Override
		protected void convertHead(BaseViewHolder helper, UserPlayListEntity userPlayListEntity) {
			ImageView imageView = helper.getView(R.id.iv_item_gedan_new);
			helper.getView(R.id.iv_mine_gedan_state).setTag(true);
			if(userPlayListEntity.header.equals("收藏的歌单")){
				imageView.setVisibility(View.GONE);
			}
			helper.getView(R.id.iv_item_gedan_new).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					new XPopup.Builder(getContext())
							.asCustom(new CreatePlayListDialog(getContext(), new CreatePlayListDialog.OnConfirmListener() {
								@Override
								public void onConfirm(String name) {
									RequestCenter.createPlayList(name, new DisposeDataListener() {
										@Override
										public void onSuccess(Object responseObj) {
											UserPlaylistBean bean = (UserPlaylistBean) responseObj;
											//bean.getPlaylist().get(0).getName();
										}

										@Override
										public void onFailure(Object reasonObj) {

										}
									});
								}
							})).show();
				}
			});
			helper.setText(R.id.tv_item_gedan_header, userPlayListEntity.header);
			helper.setText(R.id.tv_item_gedan_header_playnum, "("+userPlayListEntity.playNum+")");

		}

		@Override
		protected void convert(@NonNull BaseViewHolder helper, UserPlayListEntity userPlayListEntity) {
			ImageView img = helper.getView(R.id.iv_item_gedan_content_img);
			manager.displayImageForCorner(img, userPlayListEntity.t.getCoverImgUrl(), 5);
			helper.setText(R.id.tv_item_gedan_content_name, userPlayListEntity.t.getName());
			helper.setText(R.id.tv_item_gedan_content_num, userPlayListEntity.t.getTrackCount()+"首");
			helper.setText(R.id.tv_item_gedan_content_num, userPlayListEntity.t.getTrackCount()+"首");
			TextView creater = helper.getView(R.id.tv_item_gedan_content_creator);
			if(userPlayListEntity.t.isSubscribed()){
				creater.setVisibility(View.VISIBLE);
				creater.setText("by "+userPlayListEntity.t.getCreator().getNickname());
			}
		}
	}

}
