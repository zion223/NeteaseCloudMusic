package com.imooc.imooc_voice.model.newapi;

import java.util.List;

public class LikeListBean {

    /**
     * ids : [297845,354601]
     * checkPoint : 1568605495978
     * code : 200
     */

    private long checkPoint;
    private int code;
    private List<Long> ids;

    public long getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(long checkPoint) {
        this.checkPoint = checkPoint;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "LikeListBean{" +
                "checkPoint=" + checkPoint +
                ", code=" + code +
                ", ids=" + ids +
                '}';
    }
}
