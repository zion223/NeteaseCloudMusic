package com.imooc.imooc_voice.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpConstants {

	//private static final String ROOT_URL = "http://192.168.1.54:3000";
	private static final String ROOT_URL = "http://62.234.57.125:3000";

	static String LOGIN = ROOT_URL + "/login/cellphone";

	static String SIGNIN = ROOT_URL + "/daily_signin";

	static String SONG_URL = ROOT_URL + "/song/url";

	static String CAPTCHA_SEND = ROOT_URL + "/captcha/sent";

	static String CAPTCHA_VERITY = ROOT_URL + "/captcha/verify";

	static String REGISTER = ROOT_URL + "/register/cellphone";

	static String LOGOUT = ROOT_URL + "/logout";

	static String CREATE_PLAYLIST = ROOT_URL + "/playlist/create";

	static String DELETE_PLAYLIST = ROOT_URL + "/playlist/delete";

	static String FOLLOW = ROOT_URL + "/follow";

	static String PLAYLIST_SUBSCRIBE = ROOT_URL + "/playlist/subscribe";

	static String USER_SUBCOUNT = ROOT_URL + "/user/subcount";

	static String BANNER = ROOT_URL + "/banner";

	static String RADIO_BANNER = ROOT_URL + "/dj/banner";

	static String RECOMMAND_PLAYLIST = ROOT_URL + "/recommend/resource";

	static String DAILY_RECOMMAND = ROOT_URL + "/recommend/songs";

	static String TOP_LIST = ROOT_URL + "/toplist";

	static String TOP_LIST_DETAIL = ROOT_URL + "/toplist/detail";

	static String RADIO_RECOMMEND = ROOT_URL + "/dj/recommend";

	static String DJ_RECOMMEND_TYPE = ROOT_URL + "/dj/recommend/type";

	static String RECOMMEND_PLAY_LIST = ROOT_URL + "/top/playlist";

	static String RECOMMEND_PLAY_LIST_HIGHQUALITY = ROOT_URL + "/top/playlist/highquality";

	static String CAT_LIST = ROOT_URL + "/playlist/catlist";

	static String PLAY_LIST_DETAIL = ROOT_URL + "/playlist/detail";

	static String ALBUM_DETAIL = ROOT_URL + "/album";

	static String TOP_ALBUM = ROOT_URL + "/top/album";

	static String NEW_ALBUM = ROOT_URL + "/album/newest";

	static String TOP_SONG = ROOT_URL + "/top/song";

	static String MUSIC_CAN_PLAY = ROOT_URL + "/check/music";

	static String USER_PLAY_LIST = ROOT_URL + "/user/playlist";

	static String USER_EVENT = ROOT_URL + "/user/event";

	static String USER_DETAIL = ROOT_URL + "/user/detail";

	static String SEARCH_HOT = ROOT_URL + "/search/hot/detail";

	static String SEARCH = ROOT_URL + "/search";

	static String SINGER_HOT_SONG = ROOT_URL + "/artists";

	static String SINGER_ALBUM = ROOT_URL + "/artist/album";

	static String SINGER_VIDEO = ROOT_URL + "/artist/mv";

	static String SINGER_DESC = ROOT_URL + "/artist/desc";

	static String SINGER_LIST = ROOT_URL + "/artist/list";

	static String HOT_SINGER = ROOT_URL + "/top/artists";

	static String SINGER_SIMI = ROOT_URL + "/simi/artist";

	static String LIKE_LIST = ROOT_URL + "/likelist";

	static String SONG_DETAIL = ROOT_URL + "/song/detail";

	static String LIKE_MUSIC = ROOT_URL + "/like";

	static String MUSIC_COMMENT = ROOT_URL + "/comment/music";

	static String COMMENT_LIKE = ROOT_URL + "/comment/like";

	static String RESOURCE_LIKE = ROOT_URL + "/resource/like";

	static String INTELLIGANCE_LIST = ROOT_URL + "/playmode/intelligence/list";

	static String ALBUM_SUBLIST = ROOT_URL + "/album/sublist";

	static String ARTIST_SUBLIST = ROOT_URL + "/artist/sublist";

	static String MV_SUBLIST = ROOT_URL + "/mv/sublist";

	static String PERSONAL_FM = ROOT_URL + "/personal_fm";

	static String MAIN_EVENT = ROOT_URL + "/event";

	static String LYRIC = ROOT_URL + "/lyric";

	static String COMMENT_PLAYLIST = ROOT_URL + "/comment/playlist";

	static String COMMENT_ALBUM = ROOT_URL + "/comment/album";

	static String PAY_GIFT = ROOT_URL + "/dj/paygift";


	static String DJ_RECOMMEND = ROOT_URL + "/dj/recommend";

	static String DJ_CATLIST = ROOT_URL + "/dj/catelist";

	static String DJ_SUB = ROOT_URL + "/dj/sub";

	static String DJ_TOPLIST_HOURS = ROOT_URL + "/dj/toplist/hours";

	static String DJ_TOPLIST_NEWCOMER = ROOT_URL + "/dj/toplist/newcomer";

	static String DJ_TOPLIST_POPULAR = ROOT_URL + "/dj/toplist/popular";

	static String ARTIST_SUB = ROOT_URL + "/artist/sub";

	static String DJ_SUB_LIST = ROOT_URL + "/dj/sublist";

	static String DJ_PROGRAM = ROOT_URL + "/dj/program";

	static String DJ_PROGRAM_TOPLIST_HOURS = ROOT_URL + "/dj/program/toplist/hours";

	static String DJ_PROGRAM_TOPLIST = ROOT_URL + "/dj/program/toplist";

	static String DJ_DETAIL = ROOT_URL + "/dj/detail";

	static String VIDEO_GROUP = ROOT_URL + "/video/group/list";

	static String VIDEO_TAB = ROOT_URL + "/video/group";

	static String VIDEO_DETAIL = ROOT_URL + "/video/detail";

	static String VIDEO_SUB = ROOT_URL + "/video/sub";

	static String MV_DETAIL = ROOT_URL + "/mv/detail";

	static String MV_SUB = ROOT_URL + "/mv/sub";

	static String TOP_MV = ROOT_URL + "/top/mv";

	static String VIDEO_COMMENT = ROOT_URL + "/comment/video";

	static String MV_COMMENT = ROOT_URL + "/comment/mv";

	static String VIDEO_RELATED = ROOT_URL + "/related/allvideo";

	static String VIDEO_URL = ROOT_URL + "/video/url";

	static String MV_URL = ROOT_URL + "/mv/url";

	static String MV_ALL = ROOT_URL + "/mv/all";

	static String MV_FIRST = ROOT_URL + "/mv/first";

	static String MSG_PRIVATE = ROOT_URL + "/msg/private";

	static String MSG_COMMENT = ROOT_URL + "/msg/comments";

	static String MSG_NOTICE = ROOT_URL + "/msg/notices";

	static String USER_CLOUD = ROOT_URL + "/user/cloud";

	static String ARTIST_PIC = "http://music.163.com/api/search/get/web";


	public static String encode(String str) {
		if (str == null) return "";

		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String getSongPlayUrl(long id) {
		return "https://music.163.com/song/media/outer/url?id=" + id + ".mp3";
	}

}
