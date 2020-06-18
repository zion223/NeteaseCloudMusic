package com.imooc.imooc_voice.util;

import com.imooc.lib_api.model.song.SongDetailBean;

import java.util.List;

public class StringUtil {

	/**
	 * 	拼接歌曲Id参数
	 */
	public static String getSongSplitJoinString(List<SongDetailBean.SongsBean> list){
		StringBuilder tracks = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			//最后一个参数不加逗号
			if (i == list.size() - 1) {
				tracks.append(list.get(i).getId());
			} else {
				tracks.append(list.get(i).getId()).append(",");
			}
		}
		return tracks.toString();
	}
}
