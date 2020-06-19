package com.imooc.lib_common_ui.utils;

public interface Constants {
	String SHARED_PREFERENCE_FILE_NAME = "NeteaseCloudMusic_sp";


	interface SpKey {
		String TAG_LANGUAGE = "languageSelect";

		String AUTH_TOKEN = "authToken";

		String USER_INFO = "userInfo";

		String USER_ID = "userId";

		String PHONE_NUMBER = "phoneNumber";

		String LATEST_SONG = "latestSong";

		String DAILY_UPDATE_TIME = "dailyUpdateTime";

		String CURRENT_ARTIST_ID = "currentArtistId";

		String DAILY_RECOMMEND = "dailyRecommend";

		String LIKE_LIST = "likeList";

		String LOCAL_MUSIC_COUNT = "LOCAL_MUSIC_COUNT";
	}

	int SONG = 0;
	int MV = 1;
	int PLAYLIST = 2;
	int ALBUM = 3;
	int RADIO = 4;
	int VIDEO = 5;
	int EVENT = 6;
}
