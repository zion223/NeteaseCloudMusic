package com.imooc.lib_api.model.notification;


import com.imooc.lib_api.model.search.UserSearchBean;

import java.util.ArrayList;

public class PrivateCommentBean {

    private int code;
    private int total;
    private boolean more;

    private ArrayList<Comment> comments;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public static class Comment {
        private UserSearchBean.ResultBean.UserprofilesBean user;
        private UserSearchBean.ResultBean.UserprofilesBean beRepliedUser;
        private String beRepliedContent;
        private long time;
        private String content;
        private String combindId;
        private Object expressionUrl;
        private Object beRepliedExpressionUrl;
        private int commentLocationType;
        private int parentCommentId;
        private int resourceType;


        public UserSearchBean.ResultBean.UserprofilesBean getUser() {
            return user;
        }

        public void setUser(UserSearchBean.ResultBean.UserprofilesBean user) {
            this.user = user;
        }

        public UserSearchBean.ResultBean.UserprofilesBean getBeRepliedUser() {
            return beRepliedUser;
        }

        public void setBeRepliedUser(UserSearchBean.ResultBean.UserprofilesBean beRepliedUser) {
            this.beRepliedUser = beRepliedUser;
        }

        public String getBeRepliedContent() {
            return beRepliedContent;
        }

        public void setBeRepliedContent(String beRepliedContent) {
            this.beRepliedContent = beRepliedContent;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCombindId() {
            return combindId;
        }

        public void setCombindId(String combindId) {
            this.combindId = combindId;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public Object getBeRepliedExpressionUrl() {
            return beRepliedExpressionUrl;
        }

        public void setBeRepliedExpressionUrl(Object beRepliedExpressionUrl) {
            this.beRepliedExpressionUrl = beRepliedExpressionUrl;
        }

        public int getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(int commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public int getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(int parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }
    }
}
