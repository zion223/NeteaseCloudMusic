package com.imooc.lib_api.model.dj;

/**
 * 用来适配电台列表Adapter的bean
 */
public class DjBean {
    long rid;
    String coverUrl;
    String djName;
    String rcmdName;
    int programCount;
    int registerCount;
    String artistName;
    int price;
    boolean subed;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDjName() {
        return djName;
    }

    public void setDjName(String djName) {
        this.djName = djName;
    }

    public String getRcmdName() {
        return rcmdName;
    }

    public void setRcmdName(String rcmdName) {
        this.rcmdName = rcmdName;
    }

    public int getProgramCount() {
        return programCount;
    }

    public void setProgramCount(int programCount) {
        this.programCount = programCount;
    }

    public int getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(int registerCount) {
        this.registerCount = registerCount;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSubed() {
        return subed;
    }

    @Override
    public String toString() {
        return "DjBean{" +
                "rid=" + rid +
                ", coverUrl='" + coverUrl + '\'' +
                ", djName='" + djName + '\'' +
                ", rcmdName='" + rcmdName + '\'' +
                ", programCount=" + programCount +
                ", registerCount=" + registerCount +
                ", artistName='" + artistName + '\'' +
                ", price=" + price +
                ", subed=" + subed +
                '}';
    }

    public void setSubed(boolean subed) {
        this.subed = subed;
    }

}
