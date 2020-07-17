package com.imooc.lib_api.model.user;

public class SettingBean {


    private int code;
    private Setting setting;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    /*
     * {
     *     "setting": {
     *         "profileSetting": 0,
     *         "ageSetting": 0,
     *         "areaSetting": 0,
     *         "collegeSetting": 0,
     *         "villageAgeSetting": 0,
     *         "followSingerSetting": 0,
     *         "personalServiceSetting": 0,
     *         "newSongDiskSetting": null,
     *         "concertSetting": 0,
     *         "phoneFriendSetting": true,
     *         "userId": 123170560,
     *         "shareSetting": 0,
     *         "peopleNearbyCanSeeMe": true,
     *         "allowSubscriptionNotify": true,
     *         "allowLikedNotify": true,
     *         "allowNewFollowerNotify": true,
     *         "needRcmdEvent": true,
     *         "playRecordSetting": 0,
     *         "allowPlaylistShareNotify": true,
     *         "allowDJProgramShareNotify": true,
     *         "allowDJProgramSubscriptionNotify": true,
     *         "allowDJRadioSubscriptionNotify": true,
     *         "allowPeopleCanSeeMyPlayRecord": true,
     *         "allowOfflinePrivateMessageNotify": true,
     *         "allowOfflineForwardNotify": true,
     *         "allowOfflineCommentNotify": true,
     *         "allowOfflineCommentReplyNotify": true,
     *         "allowOfflineNotify": true,
     *         "allowVideoSubscriptionNotify": true,
     *         "sendMiuiMsg": false,
     *         "allowImportDoubanPlaylist": true,
     *         "importedDoubanPlaylist": false,
     *         "importedXiamiPlaylist": false,
     *         "allowImportXiamiPlaylist": true,
     *         "allowFollowedCanSeeMyPlayRecord": true,
     *         "finishedFollowGuide": true,
     *         "socialSetting": 0,
     *         "broadcastSetting": 2,
     *         "commentSetting": 2
     *     },
     *     "code": 200
     * }
     */
    public static class Setting {
        private boolean phoneFriendSetting;
        //可以再附近页看到我
        private boolean peopleNearbyCanSeeMe;
        //
        private boolean allowSubscriptionNotify;
        //收到赞
        private boolean allowLikedNotify;
        //新粉丝
        private boolean allowNewFollowerNotify;
        private boolean needRcmdEvent;
        //歌单被收藏
        private boolean allowPlaylistShareNotify;
        private boolean allowDJProgramShareNotify;
        private boolean allowDJProgramSubscriptionNotify;
        private boolean allowDJRadioSubscriptionNotify;
        private boolean allowPeopleCanSeeMyPlayRecord;
        private boolean allowOfflinePrivateMessageNotify;
        private boolean allowOfflineForwardNotify;
        private boolean allowOfflineCommentNotify;
        private boolean allowOfflineCommentReplyNotify;
        private boolean allowOfflineNotify;
        private boolean allowVideoSubscriptionNotify;
        private boolean sendMiuiMsg;
        private boolean allowImportDoubanPlaylist;
        private boolean importedDoubanPlaylist;
        private boolean importedXiamiPlaylist;
        private boolean allowImportXiamiPlaylist;
        private boolean allowFollowedCanSeeMyPlayRecord;
        private boolean finishedFollowGuide;
    }

}
