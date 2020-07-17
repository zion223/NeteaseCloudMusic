package com.imooc.lib_api.model.playlist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 从api获取的歌单分类Bean
 */
public class CatlistBean {

    /**
     * all : {"name":"全部歌单","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":4,"resourceType":0,"hot":false,"activity":false}
     * sub : [{"name":"流行","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":1,"resourceType":0,"hot":true,"activity":false},{"name":"影视原声","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":4,"resourceType":0,"hot":true,"activity":false},{"name":"华语","resourceCount":951,"imgId":0,"imgUrl":null,"type":0,"category":0,"resourceType":0,"hot":true,"activity":false},{"name":"清晨","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"怀旧","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":3,"resourceType":0,"hot":true,"activity":false},{"name":"摇滚","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":1,"resourceType":0,"hot":true,"activity":false},{"name":"夜晚","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":2,"resourceType":0,"hot":true,"activity":false},{"name":"清新","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":3,"resourceType":0,"hot":true,"activity":false},{"name":"ACG","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":4,"resourceType":0,"hot":true,"activity":false},{"name":"欧美","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":0,"resourceType":0,"hot":false,"activity":false},{"name":"儿童","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"学习","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":2,"resourceType":0,"hot":true,"activity":false},{"name":"民谣","resourceCount":810,"imgId":0,"imgUrl":null,"type":0,"category":1,"resourceType":0,"hot":true,"activity":false},{"name":"浪漫","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"日语","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":0,"resourceType":0,"hot":false,"activity":false},{"name":"工作","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"电子","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":1,"resourceType":0,"hot":true,"activity":false},{"name":"校园","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"性感","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"韩语","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":0,"resourceType":0,"hot":false,"activity":false},{"name":"午休","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"游戏","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"伤感","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"舞曲","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"粤语","resourceCount":659,"imgId":0,"imgUrl":null,"type":1,"category":0,"resourceType":0,"hot":false,"activity":false},{"name":"小语种","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":0,"resourceType":0,"hot":false,"activity":false},{"name":"下午茶","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"70后","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"说唱","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"治愈","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":3,"resourceType":0,"hot":true,"activity":false},{"name":"轻音乐","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":1,"resourceType":0,"hot":true,"activity":false},{"name":"80后","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"放松","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"地铁","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"爵士","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"90后","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"驾车","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"孤独","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"感动","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"运动","resourceCount":1000,"imgId":0,"imgUrl":null,"type":0,"category":2,"resourceType":0,"hot":true,"activity":false},{"name":"网络歌曲","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"乡村","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"兴奋","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"KTV","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"旅行","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"R&B/Soul","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"古典","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"快乐","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"散步","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"经典","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"翻唱","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"安静","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"民族","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"酒吧","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":2,"resourceType":0,"hot":false,"activity":false},{"name":"思念","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":3,"resourceType":0,"hot":false,"activity":false},{"name":"吉他","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"英伦","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"金属","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"钢琴","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"朋克","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"器乐","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"榜单","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"蓝调","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"雷鬼","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"00后","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":4,"resourceType":0,"hot":false,"activity":false},{"name":"世界音乐","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"拉丁","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"另类/独立","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"New Age","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"古风","resourceCount":911,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"后摇","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false},{"name":"Bossa Nova","resourceCount":1000,"imgId":0,"imgUrl":null,"type":1,"category":1,"resourceType":0,"hot":false,"activity":false}]
     * categories : {"0":"语种","1":"风格","2":"场景","3":"情感","4":"主题"}
     * code : 200
     */

    private AllBean all;
    private CategoriesBean categories;
    private int code;
    private List<SubBean> sub;

    public AllBean getAll() {
        return all;
    }

    public void setAll(AllBean all) {
        this.all = all;
    }

    public CategoriesBean getCategories() {
        return categories;
    }

    public void setCategories(CategoriesBean categories) {
        this.categories = categories;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SubBean> getSub() {
        return sub;
    }

    public void setSub(List<SubBean> sub) {
        this.sub = sub;
    }

    public static class AllBean {
        /**
         * name : 全部歌单
         * resourceCount : 1000
         * imgId : 0
         * imgUrl : null
         * type : 0
         * category : 4
         * resourceType : 01
         * hot : false
         * activity : false
         */

        private String name;
        private int resourceCount;
        private int imgId;
        private Object imgUrl;
        private int type;
        private int category;
        private int resourceType;
        private boolean hot;
        private boolean activity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getResourceCount() {
            return resourceCount;
        }

        public void setResourceCount(int resourceCount) {
            this.resourceCount = resourceCount;
        }

        public int getImgId() {
            return imgId;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

        public Object getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(Object imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public boolean isHot() {
            return hot;
        }

        public void setHot(boolean hot) {
            this.hot = hot;
        }

        public boolean isActivity() {
            return activity;
        }

        public void setActivity(boolean activity) {
            this.activity = activity;
        }
    }

    public static class CategoriesBean {
        /**
         * 0 : 语种
         * 1 : 风格
         * 2 : 场景
         * 3 : 情感
         * 4 : 主题
         */

        @SerializedName("0")
        private String _$0;
        @SerializedName("1")
        private String _$1;
        @SerializedName("2")
        private String _$2;
        @SerializedName("3")
        private String _$3;
        @SerializedName("4")
        private String _$4;

        public String get_$0() {
            return _$0;
        }

        public void set_$0(String _$0) {
            this._$0 = _$0;
        }

        public String get_$1() {
            return _$1;
        }

        public void set_$1(String _$1) {
            this._$1 = _$1;
        }

        public String get_$2() {
            return _$2;
        }

        public void set_$2(String _$2) {
            this._$2 = _$2;
        }

        public String get_$3() {
            return _$3;
        }

        public void set_$3(String _$3) {
            this._$3 = _$3;
        }

        public String get_$4() {
            return _$4;
        }

        public void set_$4(String _$4) {
            this._$4 = _$4;
        }
    }

    public static class SubBean {
        /**
         * name : 流行
         * resourceCount : 1000
         * imgId : 0
         * imgUrl : null
         * type : 0
         * category : 1
         * resourceType : 0
         * hot : true
         * activity : false
         */

        private String name;
        private int resourceCount;
        private int imgId;
        private Object imgUrl;
        private int type;
        private int category;
        private int resourceType;
        private boolean hot;
        private boolean activity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getResourceCount() {
            return resourceCount;
        }

        public void setResourceCount(int resourceCount) {
            this.resourceCount = resourceCount;
        }

        public int getImgId() {
            return imgId;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

        public Object getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(Object imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public boolean isHot() {
            return hot;
        }

        public void setHot(boolean hot) {
            this.hot = hot;
        }

        public boolean isActivity() {
            return activity;
        }

        public void setActivity(boolean activity) {
            this.activity = activity;
        }
    }
}
