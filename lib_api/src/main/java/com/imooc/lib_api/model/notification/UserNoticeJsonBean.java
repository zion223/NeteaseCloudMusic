package com.imooc.lib_api.model.notification;

import com.imooc.lib_api.model.search.SynthesisSearchBean;
import com.imooc.lib_api.model.search.UserSearchBean;
import com.imooc.lib_api.model.song.MusicCommentBean;

public class UserNoticeJsonBean {

    private int type;
    private UserSearchBean.ResultBean.UserprofilesBean user;

    //评论的通知
    private MusicCommentBean.CommentsBean comment;
    //歌单的通知
    private SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean playlist;
    // 常规通知
    private GeneralNotice generalNotice;

    public GeneralNotice getGeneralNotice() {
        return generalNotice;
    }

    public void setGeneralNotice(GeneralNotice generalNotice) {
        this.generalNotice = generalNotice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserSearchBean.ResultBean.UserprofilesBean getUser() {
        return user;
    }

    public void setUser(UserSearchBean.ResultBean.UserprofilesBean user) {
        this.user = user;
    }

    public MusicCommentBean.CommentsBean getComment() {
        return comment;
    }

    public void setComment(MusicCommentBean.CommentsBean comment) {
        this.comment = comment;
    }

    public SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean playlist) {
        this.playlist = playlist;
    }


    public static class GeneralNotice{
        private String actionDesc;
        private String content;
        private String webUrl;
        private String nativeUrl;
        private int type;
        private int resourceId;
        private Object specialResourceType;

        public String getActionDesc() {
            return actionDesc;
        }

        public void setActionDesc(String actionDesc) {
            this.actionDesc = actionDesc;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getNativeUrl() {
            return nativeUrl;
        }

        public void setNativeUrl(String nativeUrl) {
            this.nativeUrl = nativeUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getResourceId() {
            return resourceId;
        }

        public void setResourceId(int resourceId) {
            this.resourceId = resourceId;
        }

        public Object getSpecialResourceType() {
            return specialResourceType;
        }

        public void setSpecialResourceType(Object specialResourceType) {
            this.specialResourceType = specialResourceType;
        }
    }
}
