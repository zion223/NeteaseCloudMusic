package com.imooc.lib_api.model.search;

import java.util.List;

/**
 * 相似歌手的Bean
 */
public class SimiSingerBean {

    /**
     * artists : [{"img1v1Id":109951164204802770,"topicPerson":0,"alias":["Yui Horie"],"picId":109951164204800820,"albumSize":60,"briefDesc":"","musicSize":729,"img1v1Url":"https://p1.music.126.net/NhDr9qu2f7YkaFI-CA6X-A==/109951164204802761.jpg","trans":"","picUrl":"https://p1.music.126.net/oalCoLrzUWHCFCruzgbpvQ==/109951164204800817.jpg","followed":false,"name":"堀江由衣","id":16402,"picId_str":"109951164204800817","img1v1Id_str":"109951164204802761","alg":"itembased"},{"img1v1Id":881808325499528,"topicPerson":0,"alias":["Aya Hirano"],"picId":109951163113898830,"albumSize":44,"briefDesc":"","musicSize":369,"img1v1Url":"https://p1.music.126.net/yv75V_GIbhnGXN64nGWF6A==/881808325499528.jpg","trans":"平野绫","picUrl":"https://p1.music.126.net/l_ci3SeRiktZaz72sKIJ2A==/109951163113898834.jpg","followed":false,"name":"平野綾","id":16400,"picId_str":"109951163113898834","transNames":["平野绫"],"alg":"itembased"},{"img1v1Id":109951163006782060,"topicPerson":0,"alias":["かわだ まみ"],"picId":109951163543105390,"albumSize":32,"briefDesc":"","musicSize":350,"img1v1Url":"https://p1.music.126.net/6qTXi-EEjkmO1DzcSF6vcg==/109951163006782065.jpg","trans":"川田麻美","picUrl":"https://p1.music.126.net/2pUdlbH1mCFdDpxFp9rAVg==/109951163543105393.jpg","followed":false,"name":"川田まみ","id":16697,"picId_str":"109951163543105393","transNames":["川田麻美"],"img1v1Id_str":"109951163006782065","alg":"itembased"},{"img1v1Id":109951163368464110,"topicPerson":0,"alias":["コトコ"],"picId":109951163368463120,"albumSize":61,"briefDesc":"","musicSize":654,"img1v1Url":"https://p1.music.126.net/5AreMnJZysxR7SCqYgFytA==/109951163368464114.jpg","trans":"","picUrl":"https://p1.music.126.net/e4Auk_XxlN2KIeEc4c6Dcw==/109951163368463124.jpg","followed":false,"name":"KOTOKO","id":16691,"picId_str":"109951163368463124","img1v1Id_str":"109951163368464114","alg":"itembased"},{"img1v1Id":109951163905585820,"topicPerson":0,"alias":["にしかわ たかのり"],"picId":109951163905590690,"albumSize":55,"briefDesc":"","musicSize":511,"img1v1Url":"https://p1.music.126.net/nr060qCnOU4xOxUrWKh7yQ==/109951163905585827.jpg","trans":"西川贵教","picUrl":"https://p1.music.126.net/w7c5ZUTBCjAIFXdcCNSMRQ==/109951163905590693.jpg","followed":false,"name":"西川貴教","id":15557,"picId_str":"109951163905590693","transNames":["西川贵教"],"img1v1Id_str":"109951163905585827","alg":"itembased"},{"img1v1Id":3301833424618542,"topicPerson":0,"alias":["すあら"],"picId":3413983642789443,"albumSize":33,"briefDesc":"","musicSize":330,"img1v1Url":"https://p1.music.126.net/5kZS7k06Cl3oO0XZyI7xIg==/3301833424618542.jpg","trans":"巽明子","picUrl":"https://p1.music.126.net/5d_kaGybATa6zL9CxUdXHg==/3413983642789443.jpg","followed":false,"name":"Suara","id":17642,"transNames":["巽明子"],"alg":"itembased"},{"img1v1Id":109951163544628740,"topicPerson":0,"alias":["エリサ"],"picId":109951163544636030,"albumSize":29,"briefDesc":"","musicSize":300,"img1v1Url":"https://p1.music.126.net/GpYVl81Zz80ngtxnYVZvZw==/109951163544628738.jpg","trans":"","picUrl":"https://p1.music.126.net/XYvcWKfMD0pc-J1BSc_ypg==/109951163544636038.jpg","followed":false,"name":"ELISA","id":16271,"picId_str":"109951163544636038","img1v1Id_str":"109951163544628738","alg":"itembased"},{"img1v1Id":109951163223397220,"topicPerson":0,"alias":["Ito kanako"],"picId":109951163223391360,"albumSize":54,"briefDesc":"","musicSize":571,"img1v1Url":"https://p1.music.126.net/QSuy0QEu0tck0sS7BYuFFA==/109951163223397212.jpg","trans":"伊藤香奈子","picUrl":"https://p1.music.126.net/C3jEK0b8E5-b8JG4JGNSSA==/109951163223391355.jpg","followed":false,"name":"いとうかなこ","id":16277,"picId_str":"109951163223391355","transNames":["伊藤香奈子"],"img1v1Id_str":"109951163223397212","alg":"itembased"},{"img1v1Id":3261151489058319,"topicPerson":0,"alias":["リア"],"picId":3275445140229805,"albumSize":39,"briefDesc":"","musicSize":510,"img1v1Url":"https://p1.music.126.net/IRs4tHolGj7V7JCfnAlgRA==/3261151489058319.jpg","trans":"","picUrl":"https://p1.music.126.net/A70zasNFpDT98VLwc7BURg==/3275445140229805.jpg","followed":false,"name":"Lia","id":16993,"alg":"itembased"},{"img1v1Id":109951163142209400,"topicPerson":0,"alias":["きたむら えり","Eri Kitamura"],"picId":109951163142213150,"albumSize":34,"briefDesc":"","musicSize":384,"img1v1Url":"https://p1.music.126.net/FGAkAMwX2ZlRtCYkxjlILw==/109951163142209404.jpg","trans":"","picUrl":"https://p1.music.126.net/onnXD_ZCu6RQnn3FwPelcQ==/109951163142213155.jpg","followed":false,"name":"喜多村英梨","id":16758,"picId_str":"109951163142213155","img1v1Id_str":"109951163142209404","alg":"itembased"},{"img1v1Id":109951163050294300,"topicPerson":0,"alias":["ちょうちょ"],"picId":109951163448300110,"albumSize":30,"briefDesc":"","musicSize":213,"img1v1Url":"https://p2.music.126.net/J5W4mVup7cwIADGdKwKQbw==/109951163050294303.jpg","trans":"","picUrl":"https://p2.music.126.net/o18txKWHPi5jT5mU2YX0kg==/109951163448300108.jpg","followed":false,"name":"ChouCho","id":16138,"picId_str":"109951163448300108","img1v1Id_str":"109951163050294303","alg":"itembased"},{"img1v1Id":109951163955705730,"topicPerson":0,"alias":["Aoi Yuki"],"picId":109951163955701420,"albumSize":29,"briefDesc":"","musicSize":265,"img1v1Url":"https://p2.music.126.net/YCVkF9VAjxzW5muj-_3fjA==/109951163955705728.jpg","trans":"","picUrl":"https://p2.music.126.net/9t3jA_DViC-nl0oNPsOVYQ==/109951163955701422.jpg","followed":false,"name":"悠木碧","id":18269,"picId_str":"109951163955701422","img1v1Id_str":"109951163955705728","alg":"itembased"},{"img1v1Id":18738976674178824,"topicPerson":0,"alias":["カラフィナ"],"picId":109951163120491440,"albumSize":39,"briefDesc":"","musicSize":490,"img1v1Url":"https://p2.music.126.net/Thd2eIy9flYfykzUP15lWg==/18738976674178823.jpg","trans":"","picUrl":"https://p2.music.126.net/i5N-qc0FhzH24qQaYkCbqQ==/109951163120491436.jpg","followed":false,"name":"Kalafina","id":20032,"picId_str":"109951163120491436","img1v1Id_str":"18738976674178823","alg":"itembased"},{"img1v1Id":611328465070473,"topicPerson":0,"alias":["うえはられな","Uehara Rena"],"picId":930186837125910,"albumSize":9,"briefDesc":"","musicSize":164,"img1v1Url":"https://p2.music.126.net/JVnBQ84Ad1qdIb-P_mFtMA==/611328465070473.jpg","trans":"上原玲奈","picUrl":"https://p2.music.126.net/6S3fiGWr20FpM_ORIC5hKg==/930186837125910.jpg","followed":false,"name":"上原れな","id":18137,"transNames":["上原玲奈"],"alg":"itembased"},{"img1v1Id":109951163934764130,"topicPerson":0,"alias":["ユーフォニアス"],"picId":109951163934762220,"albumSize":46,"briefDesc":"","musicSize":369,"img1v1Url":"https://p2.music.126.net/wXyJVhB5C4OEl--TZQEr_g==/109951163934764125.jpg","trans":"","picUrl":"https://p2.music.126.net/apc0CtD7eLzdVRdMdjG-8w==/109951163934762227.jpg","followed":false,"name":"eufonius","id":19271,"picId_str":"109951163934762227","img1v1Id_str":"109951163934764125","alg":"itembased"},{"img1v1Id":109951164109814160,"topicPerson":0,"alias":["はやみさおり"],"picId":109951164109819000,"albumSize":37,"briefDesc":"","musicSize":459,"img1v1Url":"https://p2.music.126.net/kpR9G6kZH-3baz8v84q4cw==/109951164109814165.jpg","trans":"早见沙织","picUrl":"https://p2.music.126.net/vTKFaBE8pJz-H6wZMnLvrg==/109951164109819009.jpg","followed":false,"name":"早見沙織","id":16501,"picId_str":"109951164109819009","transNames":["早见沙织"],"img1v1Id_str":"109951164109814165","alg":"itembased"},{"img1v1Id":109951164268981920,"topicPerson":0,"alias":["Maaya Sakamoto"],"picId":109951163031215490,"albumSize":63,"briefDesc":"","musicSize":600,"img1v1Url":"https://p2.music.126.net/sznWSppOroXoDhycHVBlhQ==/109951164268981921.jpg","trans":"坂本真绫","picUrl":"https://p2.music.126.net/9Cv1n-e4RuOQMThamVkK9A==/109951163031215494.jpg","followed":false,"name":"坂本真綾","id":17636,"picId_str":"109951163031215494","transNames":["坂本真绫"],"img1v1Id_str":"109951164268981921","alg":"itembased"},{"img1v1Id":6062707115567823,"topicPerson":0,"alias":["ひかさ ようこ"],"picId":5798824325062188,"albumSize":34,"briefDesc":"","musicSize":322,"img1v1Url":"https://p2.music.126.net/2ExogZDMJp65-EY7La-ETQ==/6062707115567823.jpg","trans":"日笠阳子","picUrl":"https://p2.music.126.net/wSttpbCt7hEmp8fcQsLMlg==/5798824325062188.jpg","followed":false,"name":"日笠陽子","id":16495,"transNames":["日笠阳子"],"alg":"itembased"},{"img1v1Id":109951163982107740,"topicPerson":0,"alias":["とまつ はるか","Haruka Tomatsu"],"picId":109951164122636200,"albumSize":48,"briefDesc":"","musicSize":387,"img1v1Url":"https://p2.music.126.net/qcbCjHKJ1p9o_mxrUHvPfw==/109951163982107746.jpg","trans":"户松遥","picUrl":"https://p2.music.126.net/zt7s9BhQE9B4rA173Ws2KQ==/109951164122636185.jpg","followed":false,"name":"戸松遥","id":17905,"picId_str":"109951164122636185","transNames":["户松遥"],"img1v1Id_str":"109951163982107746","alg":"itembased"},{"img1v1Id":109951164260500960,"topicPerson":0,"alias":["Haruna Luna"],"picId":109951164260509660,"albumSize":27,"briefDesc":"","musicSize":137,"img1v1Url":"https://p2.music.126.net/BdGIc0l3FfBQXwRnu0cY4g==/109951164260500959.jpg","trans":"春奈露娜","picUrl":"https://p2.music.126.net/77DSsz0o5bNcddXvOiiaRg==/109951164260509670.jpg","followed":false,"name":"春奈るな","id":16569,"picId_str":"109951164260509670","transNames":["春奈露娜"],"img1v1Id_str":"109951164260500959","alg":"itembased"}]
     * code : 200
     */

    private int code;
    private List<ArtistsBean> artists;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public static class ArtistsBean {
        /**
         * img1v1Id : 109951164204802770
         * topicPerson : 0
         * alias : ["Yui Horie"]
         * picId : 109951164204800820
         * albumSize : 60
         * briefDesc :
         * musicSize : 729
         * img1v1Url : https://p1.music.126.net/NhDr9qu2f7YkaFI-CA6X-A==/109951164204802761.jpg
         * trans :
         * picUrl : https://p1.music.126.net/oalCoLrzUWHCFCruzgbpvQ==/109951164204800817.jpg
         * followed : false
         * name : 堀江由衣
         * id : 16402
         * picId_str : 109951164204800817
         * img1v1Id_str : 109951164204802761
         * alg : itembased
         * transNames : ["平野绫"]
         */

        private long img1v1Id;
        private int topicPerson;
        private long picId;
        private int albumSize;
        private String briefDesc;
        private int musicSize;
        private String img1v1Url;
        private String trans;
        private String picUrl;
        private boolean followed;
        private String name;
        private long id;
        private String picId_str;
        private String img1v1Id_str;
        private String alg;
        private List<String> alias;
        private List<String> transNames;

        public long getImg1v1Id() {
            return img1v1Id;
        }

        public void setImg1v1Id(long img1v1Id) {
            this.img1v1Id = img1v1Id;
        }

        public int getTopicPerson() {
            return topicPerson;
        }

        public void setTopicPerson(int topicPerson) {
            this.topicPerson = topicPerson;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public int getAlbumSize() {
            return albumSize;
        }

        public void setAlbumSize(int albumSize) {
            this.albumSize = albumSize;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public int getMusicSize() {
            return musicSize;
        }

        public void setMusicSize(int musicSize) {
            this.musicSize = musicSize;
        }

        public String getImg1v1Url() {
            return img1v1Url;
        }

        public void setImg1v1Url(String img1v1Url) {
            this.img1v1Url = img1v1Url;
        }

        public String getTrans() {
            return trans;
        }

        public void setTrans(String trans) {
            this.trans = trans;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPicId_str() {
            return picId_str;
        }

        public void setPicId_str(String picId_str) {
            this.picId_str = picId_str;
        }

        public String getImg1v1Id_str() {
            return img1v1Id_str;
        }

        public void setImg1v1Id_str(String img1v1Id_str) {
            this.img1v1Id_str = img1v1Id_str;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public List<String> getTransNames() {
            return transNames;
        }

        public void setTransNames(List<String> transNames) {
            this.transNames = transNames;
        }
    }

    @Override
    public String toString() {
        return "SimiSingerBean{" +
                "code=" + code +
                ", artists=" + artists +
                '}';
    }
}
