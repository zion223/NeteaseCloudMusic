package com.imooc.imooc_voice.view.discory;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.model.json.BillListJson;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.List;

public class AlbumSongAdapter extends BaseQuickAdapter<BillListJson.BillList, BaseViewHolder> {

	private int type;
	private ImageLoaderManager manager;

	public AlbumSongAdapter(@Nullable List<BillListJson.BillList> data, int type) {
		super(R.layout.item_discover_album_song, data);
		this.type = type;
		manager = ImageLoaderManager.getInstance();
	}

	@Override
	protected void convert(BaseViewHolder helper, BillListJson.BillList item) {
		helper.setText(R.id.tv_item_album_song_name, item.getTitle());
		helper.setText(R.id.tv_item_album_song_artist, item.getAuthor());
		ImageView imageView = helper.getView(R.id.iv_item_album_song);
		manager.displayImageForCorner(imageView, item.getPic_big(), 5);
	}

	interface Type{
		int ALBUM = 0;
		int SONG = 1;
	}
}
