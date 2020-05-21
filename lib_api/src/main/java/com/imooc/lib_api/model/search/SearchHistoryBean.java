package com.imooc.lib_api.model.search;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * 用于存放历史搜索的GreenDao Bean
 * Created By on 2019/8/3
 */
@Entity
public class SearchHistoryBean {

    @Property
    String keyowrds;

    @Generated(hash = 1649854464)
    public SearchHistoryBean(String keyowrds) {
        this.keyowrds = keyowrds;
    }

    @Generated(hash = 1570282321)
    public SearchHistoryBean() {
    }

    public String getKeyowrds() {
        return keyowrds;
    }

    public void setKeyowrds(String keyowrds) {
        this.keyowrds = keyowrds;
    }
}
