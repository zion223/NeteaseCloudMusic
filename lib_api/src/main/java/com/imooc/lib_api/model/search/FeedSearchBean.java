package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 根据api获取的视频搜索结果
 */
public class FeedSearchBean {

    /**
     * result : {"videoCount":600,"videos":[{"coverUrl":"http://p1.music.126.net/R6pCjd9qmH4LQm1idWOZig==/109951163888857522.jpg","title":"《jojo的奇妙冒险》各部BOSS的精彩操作（大误）P3","durationms":468695,"playTime":714924,"type":1,"creator":[{"userId":1484858585,"userName":"TwoFlyCats"}],"aliaName":null,"transName":null,"vid":"E7324156176B933029D10CB5E92E5B3F","markTypes":[],"alg":"alg_video_a"},{"coverUrl":"http://p1.music.126.net/grzV0_AtUPoyTT-0lEuJFQ==/109951163918650420.jpg","title":"一起来跟着黑帮摇//","durationms":59000,"playTime":1120173,"type":1,"creator":[{"userId":266801423,"userName":"我还没玩死"}],"aliaName":null,"transName":null,"vid":"B48CB3849AC193321699BA76DCE3B822","markTypes":[],"alg":"alg_video_a"}]}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * videoCount : 600
         * videos : [{"coverUrl":"http://p1.music.126.net/R6pCjd9qmH4LQm1idWOZig==/109951163888857522.jpg","title":"《jojo的奇妙冒险》各部BOSS的精彩操作（大误）P3","durationms":468695,"playTime":714924,"type":1,"creator":[{"userId":1484858585,"userName":"TwoFlyCats"}],"aliaName":null,"transName":null,"vid":"E7324156176B933029D10CB5E92E5B3F","markTypes":[],"alg":"alg_video_a"},{"coverUrl":"http://p1.music.126.net/grzV0_AtUPoyTT-0lEuJFQ==/109951163918650420.jpg","title":"一起来跟着黑帮摇//","durationms":59000,"playTime":1120173,"type":1,"creator":[{"userId":266801423,"userName":"我还没玩死"}],"aliaName":null,"transName":null,"vid":"B48CB3849AC193321699BA76DCE3B822","markTypes":[],"alg":"alg_video_a"}]
         */

        private int videoCount;
        private List<VideosBean> videos;

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean {
            /**
             * coverUrl : http://p1.music.126.net/R6pCjd9qmH4LQm1idWOZig==/109951163888857522.jpg
             * title : 《jojo的奇妙冒险》各部BOSS的精彩操作（大误）P3
             * durationms : 468695
             * playTime : 714924
             * type : 1
             * creator : [{"userId":1484858585,"userName":"TwoFlyCats"}]
             * aliaName : null
             * transName : null
             * vid : E7324156176B933029D10CB5E92E5B3F
             * markTypes : []
             * alg : alg_video_a
             */

            private String coverUrl;
            private String title;
            private int durationms;
            private long playTime;
            private int type;
            private Object aliaName;
            private Object transName;
            private String vid;
            private String alg;
            private List<MvBean.CreatorBean> creator;
            private List<?> markTypes;

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getDurationms() {
                return durationms;
            }

            public void setDurationms(int durationms) {
                this.durationms = durationms;
            }

            public long getPlayTime() {
                return playTime;
            }

            public void setPlayTime(long playTime) {
                this.playTime = playTime;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getAliaName() {
                return aliaName;
            }

            public void setAliaName(Object aliaName) {
                this.aliaName = aliaName;
            }

            public Object getTransName() {
                return transName;
            }

            public void setTransName(Object transName) {
                this.transName = transName;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public List<MvBean.CreatorBean> getCreator() {
                return creator;
            }

            public void setCreator(List<MvBean.CreatorBean> creator) {
                this.creator = creator;
            }

            public List<?> getMarkTypes() {
                return markTypes;
            }

            public void setMarkTypes(List<?> markTypes) {
                this.markTypes = markTypes;
            }


            @Override
            public String toString() {
                return "VideosBean{" +
                        "coverUrl='" + coverUrl + '\'' +
                        ", title='" + title + '\'' +
                        ", durationms=" + durationms +
                        ", playTime=" + playTime +
                        ", type=" + type +
                        ", aliaName=" + aliaName +
                        ", transName=" + transName +
                        ", vid='" + vid + '\'' +
                        ", alg='" + alg + '\'' +
                        ", creator=" + creator +
                        ", markTypes=" + markTypes +
                        '}';
            }
        }
    }
}
