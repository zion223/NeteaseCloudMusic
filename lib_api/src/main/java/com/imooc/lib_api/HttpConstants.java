package com.imooc.lib_api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpConstants {

	private static final String ROOT_URL = "http://62.234.57.125:3000";

	static final String LOGIN = ROOT_URL + "/login/cellphone";

	static final String SIGNIN = ROOT_URL + "/daily_signin";

	static final String SONG_URL = ROOT_URL + "/song/url";

	static final String CAPTCHA_SEND = ROOT_URL + "/captcha/sent";

	static final String CAPTCHA_VERITY = ROOT_URL + "/captcha/verify";

	static final String REGISTER = ROOT_URL + "/register/cellphone";

	static final String LOGOUT = ROOT_URL + "/logout";

	static final String CREATE_PLAYLIST = ROOT_URL + "/playlist/create";

	static final String DELETE_PLAYLIST = ROOT_URL + "/playlist/delete";

	static final String PLAYLIST_TRACK = ROOT_URL + "/playlist/tracks";

	static final String FOLLOW = ROOT_URL + "/follow";

	static final String PLAYLIST_SUBSCRIBE = ROOT_URL + "/playlist/subscribe";

	static final String ALBUM_SUBSCRIBE = ROOT_URL + "/album/sub";

	static final String ALBUM_DYNAMIC = ROOT_URL + "/album/detail/dynamic";

	static final String USER_SUBCOUNT = ROOT_URL + "/user/subcount";

	static final String USER_FOLLOWER = ROOT_URL + "/user/follows";

	static final String USER_FOLLOWED = ROOT_URL + "/user/followeds";

	static final String BANNER = ROOT_URL + "/banner";

	static final String RADIO_BANNER = ROOT_URL + "/dj/banner";

	static final String RECOMMAND_PLAYLIST = ROOT_URL + "/recommend/resource";

	static final String DAILY_RECOMMAND = ROOT_URL + "/recommend/songs";

	static final String TOP_LIST = ROOT_URL + "/toplist";

	static final String TOP_LIST_DETAIL = ROOT_URL + "/toplist/detail";

	static final String RADIO_RECOMMEND = ROOT_URL + "/dj/recommend";

	static final String DJ_RECOMMEND_TYPE = ROOT_URL + "/dj/recommend/type";

	static final String RECOMMEND_PLAY_LIST = ROOT_URL + "/top/playlist";

	static final String RECOMMEND_PLAY_LIST_HIGHQUALITY = ROOT_URL + "/top/playlist/highquality";

	static final String CAT_LIST = ROOT_URL + "/playlist/catlist";

	static final String PLAY_LIST_DETAIL = ROOT_URL + "/playlist/detail";

	static final String ALBUM_DETAIL = ROOT_URL + "/album";

	static final String TOP_ALBUM = ROOT_URL + "/top/album";

	static final String NEW_ALBUM = ROOT_URL + "/album/newest";

	static final String TOP_SONG = ROOT_URL + "/top/song";

	static final String MUSIC_CAN_PLAY = ROOT_URL + "/check/music";

	static final String USER_PLAY_LIST = ROOT_URL + "/user/playlist";

	static final String USER_EVENT = ROOT_URL + "/user/event";

	static final String USER_RECORD = ROOT_URL + "/user/record";

	static final String USER_DETAIL = ROOT_URL + "/user/detail";

	static final String SEARCH_HOT = ROOT_URL + "/search/hot/detail";

	static final String SEARCH = ROOT_URL + "/search";

	static final String SINGER_HOT_SONG = ROOT_URL + "/artists";

	static final String SINGER_ALBUM = ROOT_URL + "/artist/album";

	static final String SINGER_VIDEO = ROOT_URL + "/artist/mv";

	static final String SINGER_DESC = ROOT_URL + "/artist/desc";

	static final String SINGER_LIST = ROOT_URL + "/artist/list";

	static final String HOT_SINGER = ROOT_URL + "/top/artists";

	static final String SINGER_SIMI = ROOT_URL + "/simi/artist";

	static final String LIKE_LIST = ROOT_URL + "/likelist";

	static final String SONG_DETAIL = ROOT_URL + "/song/detail";

	static final String LYRIC = ROOT_URL + "/lyric";

	static final String LIKE_MUSIC = ROOT_URL + "/like";

	static final String MUSIC_COMMENT = ROOT_URL + "/comment/music";

	static final String COMMENT_LIKE = ROOT_URL + "/comment/like";

	static final String COMMENT_HOT = ROOT_URL + "/comment/hot";

	static final String RESOURCE_LIKE = ROOT_URL + "/resource/like";

	static final String INTELLIGANCE_LIST = ROOT_URL + "/playmode/intelligence/list";

	static final String ALBUM_SUBLIST = ROOT_URL + "/album/sublist";

	static final String ARTIST_SUBLIST = ROOT_URL + "/artist/sublist";

	static final String MV_SUBLIST = ROOT_URL + "/mv/sublist";

	static final String PERSONAL_FM = ROOT_URL + "/personal_fm";

	static final String MAIN_EVENT = ROOT_URL + "/event";

	static final String COMMENT_PLAYLIST = ROOT_URL + "/comment/playlist";

	static final String COMMENT_ALBUM = ROOT_URL + "/comment/album";

	static final String PAY_GIFT = ROOT_URL + "/dj/paygift";

	static final String DJ_RECOMMEND = ROOT_URL + "/dj/recommend";

	static final String DJ_CATLIST = ROOT_URL + "/dj/catelist";

	static final String DJ_SUB = ROOT_URL + "/dj/sub";

	static final String DJ_TOPLIST = ROOT_URL + "/dj/toplist";

	static final String DJ_TOPLIST_HOURS = ROOT_URL + "/dj/toplist/hours";

	static final String DJ_TOPLIST_NEWCOMER = ROOT_URL + "/dj/toplist/newcomer";

	static final String DJ_TOPLIST_POPULAR = ROOT_URL + "/dj/toplist/popular";

	static final String ARTIST_SUB = ROOT_URL + "/artist/sub";

	static final String DJ_SUB_LIST = ROOT_URL + "/dj/sublist";

	static final String DJ_PROGRAM = ROOT_URL + "/dj/program";

	static final String DJ_PROGRAM_TOPLIST_HOURS = ROOT_URL + "/dj/program/toplist/hours";

	static final String DJ_PROGRAM_TOPLIST = ROOT_URL + "/dj/program/toplist";

	static final String DJ_DETAIL = ROOT_URL + "/dj/detail";

	static final String VIDEO_GROUP = ROOT_URL + "/video/group/list";

	static final String VIDEO_TAB = ROOT_URL + "/video/group";

	static final String VIDEO_RECOMMEND = ROOT_URL + "/video/timeline/recommend";

	static final String VIDEO_DETAIL = ROOT_URL + "/video/detail";

	static final String VIDEO_SUB = ROOT_URL + "/video/sub";

	static final String MV_DETAIL = ROOT_URL + "/mv/detail";

	static final String MV_SUB = ROOT_URL + "/mv/sub";

	static final String TOP_MV = ROOT_URL + "/top/mv";

	static final String VIDEO_COMMENT = ROOT_URL + "/comment/video";

	static final String MV_COMMENT = ROOT_URL + "/comment/mv";

	static final String VIDEO_RELATED = ROOT_URL + "/related/allvideo";

	static final String VIDEO_URL = ROOT_URL + "/video/url";

	static final String MV_URL = ROOT_URL + "/mv/url";

	static final String MV_ALL = ROOT_URL + "/mv/all";

	static final String MV_FIRST = ROOT_URL + "/mv/first";

	static final String MSG_PRIVATE = ROOT_URL + "/msg/private";

	static final String MSG_COMMENT = ROOT_URL + "/msg/comments";

	static final String MSG_NOTICE = ROOT_URL + "/msg/notices";

	static final String USER_CLOUD = ROOT_URL + "/user/cloud";

	static final String ARTIST_PIC = "http://music.163.com/api/search/get/web";


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
