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
}
