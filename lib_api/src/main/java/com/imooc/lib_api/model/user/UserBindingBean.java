package com.imooc.lib_api.model.user;

import java.util.List;

/**
 * {
 * "code": 200,
 * "bindings": [
 * {
 * "bindingTime": 1575164974234,
 * "expired": false,
 * "url": "",
 * "userId": 123170560,
 * "tokenJsonStr": "{\"countrycode\":\"\",\"cellphone\":\"15269258913\",\"hasPassword\":true}",
 * "refreshTime": 1575164974,
 * "expiresIn": 2147483647,
 * "id": 7002259297,
 * "type": 1
 * },
 * {
 * "bindingTime": 1452661976184,
 * "expired": true,
 * "url": "",
 * "userId": 123170560,
 * "tokenJsonStr": "{\"access_token\":\"8ACF9B3DF729EC3634841F9F71EAE249\",\"refresh_token\":\"281AFB3CAA8820D7238277E038692D4B\",\"openid\":\"296102C52B71C8739B39A79961EC8C47\",\"nickname\":\";\",\"expires_in\":7776000}",
 * "refreshTime": 1568642255,
 * "expiresIn": 7776000,
 * "id": 60345070,
 * "type": 5
 * },
 * {
 * "bindingTime": 1516512526126,
 * "expired": true,
 * "url": "",
 * "userId": 123170560,
 * "tokenJsonStr": "{\"access_token\":\"30_H4RTd9_U4ksQbQyoinL9YLxUL1Ffb3AMnofV0PWeIJgVK9mfyiq3cCdcSSUo4FPN3GnRhZ6Bv-y60i4ZfxRzqbHapT544bgvoaeMH70fCxE\",\"refresh_token\":\"30_nFec6hdLWzc4BtCHiizsJ1d8-mNzu3cATTn2MA73FpJczJnLU3g6bvsKvcNmy8iE-meB43reL9EgtWSf9_AiX70F_-vax-G9CuG5E111_xc\",\"unionid\":\"oZoefuI3Z1q5i_szzM_4JFQM2Pck\",\"openid\":\"okvmMjs8ZpK2CjuhwgNFZ024rmUg\",\"scope\":\"snsapi_userinfo\",\"nickname\":\"张瑞平\",\"expires_in\":7200}",
 * "refreshTime": 1582454137,
 * "expiresIn": 7200,
 * "id": 6528560193,
 * "type": 10
 * }
 * ]
 * }
 */
public class UserBindingBean {

    private int code;
    private List<Bindings> bindings;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setBindings(List<Bindings> bindings) {
        this.bindings = bindings;
    }

    public List<Bindings> getBindings() {
        return bindings;
    }


    public static class Bindings {

        private long bindingTime;
        private boolean expired;
        private String url;
        private long userId;
        private String tokenJsonStr;
        private long refreshTime;
        private long expiresIn;
        private long id;
        private int type;

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public boolean getExpired() {
            return expired;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getUserId() {
            return userId;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setRefreshTime(long refreshTime) {
            this.refreshTime = refreshTime;
        }

        public long getRefreshTime() {
            return refreshTime;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

    }
}
