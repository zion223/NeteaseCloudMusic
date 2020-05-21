package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 热搜建议的歌曲
 */
public class HotSearchDetailBean {

    /**
     * code : 200
     * data : [{"searchWord":"李现","score":996485,"content":"是亲爱的，热爱的李现！","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"坠落星空","score":972701,"content":"穿越星空，想要找到你","source":0,"iconType":5,"iconUrl":"https://p1.music.126.net/PtgUJbcvDAY0HKWpmOB2HA==/109951163967988470.png","url":"","alg":"alg_statistics"},{"searchWord":"摩登兄弟刘宇宁","score":967163,"content":"摩登兄弟刘宇宁最新单曲《十分喜欢》上线！","source":1,"iconType":2,"iconUrl":"https://p1.music.126.net/szWeddITZIVxpvQ0QywzcQ==/109951163967989323.png","url":"","alg":"featured"},{"searchWord":"岁月神偷","score":966550,"content":"金玟岐细腻声线温暖你心","source":0,"iconType":5,"iconUrl":"https://p1.music.126.net/PtgUJbcvDAY0HKWpmOB2HA==/109951163967988470.png","url":"","alg":"alg_statistics"},{"searchWord":"月牙湾","score":948923,"content":"飞儿乐队的经典神专，你还记得吗？","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"哪吒","score":910551,"content":"《哪吒之魔童降世》超燃来袭！！！","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"云烟成雨","score":895191,"content":"所有的相遇，都是久别重逢","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"宠坏","score":889629,"content":"小潘潘的又一首洗脑小甜歌~","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"罗云熙生日单曲","score":863380,"content":"来听罗云熙的《逆流而上》吧！","source":1,"iconType":0,"iconUrl":null,"url":"","alg":"featured"},{"searchWord":"邓紫棋","score":840510,"content":"唱功了得的新一代创作小天后！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"一笑倾城","score":832437,"content":"一笑倾城 一见自难忘","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"失眠症","score":822266,"content":"玩飞车的人都在找这首歌~","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"不谓侠","score":775549,"content":"凭我自由去 只做狂人不谓侠","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"亲爱的热爱的","score":747184,"content":"快来收听《亲爱的热爱的》OST吧！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"赤伶","score":725842,"content":"古风圈里的宝藏歌曲！","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"起风了","score":725428,"content":"吴青峰&买辣椒也用券重新演绎的热门歌曲！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"林俊杰","score":709426,"content":"林俊杰新歌《我们很好》已上线！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"拜拜","score":703103,"content":"拜拜，丢掉的过去不必悲哀","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"鱿小鱼","score":685255,"content":"超甜超可爱的鱿小鱼！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"走马","score":684140,"content":"你在对岸走马观花，我在这里永久牵挂。","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"}]
     * message : success
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * searchWord : 李现
         * score : 996485
         * content : 是亲爱的，热爱的李现！
         * source : 0
         * iconType : 1
         * iconUrl : https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png
         * url :
         * alg : alg_statistics
         */

        private String searchWord;
        private long score;
        private String content;
        private int source;
        private int iconType;
        private String iconUrl;
        private String url;
        private String alg;

        public String getSearchWord() {
            return searchWord;
        }

        public void setSearchWord(String searchWord) {
            this.searchWord = searchWord;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getIconType() {
            return iconType;
        }

        public void setIconType(int iconType) {
            this.iconType = iconType;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }
}
