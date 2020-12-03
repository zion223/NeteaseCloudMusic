package com.imooc.lib_api.model.search;

/**
 * {
 *     "code": 200,
 *     "message": null,
 *     "data": {
 *         "showKeyword": "汪苏泷",
 *         "realkeyword": "汪苏泷",
 *         "searchType": 1018,
 *         "action": 0,
 *         "alg": "alg_a2q_artist_v2",
 *         "gap": 0,
 *         "source": null
 *     }
 * }
 */
public class DefaultSearchBean {

    private int code;
    private String message;
    private DefaultSearchData data;

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

    public DefaultSearchData getData() {
        return data;
    }

    public void setData(DefaultSearchData data) {
        this.data = data;
    }

    public static class DefaultSearchData{
        private String showKeyword;
        private String realkeyword;
        private int searchType;
        private int action;

        public String getShowKeyword() {
            return showKeyword;
        }

        public void setShowKeyword(String showKeyword) {
            this.showKeyword = showKeyword;
        }

        public String getRealkeyword() {
            return realkeyword;
        }

        public void setRealkeyword(String realkeyword) {
            this.realkeyword = realkeyword;
        }

        public int getSearchType() {
            return searchType;
        }

        public void setSearchType(int searchType) {
            this.searchType = searchType;
        }

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public int getGap() {
            return gap;
        }

        public void setGap(int gap) {
            this.gap = gap;
        }

        private int gap;

    }
}
