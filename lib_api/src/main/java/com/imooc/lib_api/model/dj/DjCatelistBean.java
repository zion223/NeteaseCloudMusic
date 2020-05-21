package com.imooc.lib_api.model.dj;

import java.util.List;

public class DjCatelistBean {

    /**
     * categories : [{"picPCBlack":18996262393228948,"picWeb":19119407695444320,"pic84x84Id":18734578627472516,"pic56x56Id":18734578627472516,"pic96x96Id":19131502323477870,"picIPad":19036944323358116,"picPCWhite":18996262393228948,"pic56x56IdStr":"18734578627472515","pic96x96IdStr":"19131502323477870","pic84x84IdUrl":"https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg","picPCWhiteStr":"18996262393228949","picPCBlackStr":"18996262393228949","picWebStr":"19119407695444318","picIPadStr":"19036944323358115","picPCWhiteUrl":"https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg","picPCBlackUrl":"https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg","picWebUrl":"https://p1.music.126.net/cCogGBNagepu5uAd-OuCKQ==/19119407695444318.jpg","picIPadUrl":"https://p1.music.126.net/XQTJvk8i1vP21eCUUt8DwA==/19036944323358115.jpg","picMacId":"109951163921391989","picMacUrl":"https://p1.music.126.net/vUL2pw5_gcmJ8C8n-H_K7g==/109951163921391989.jpg","picUWPId":"19082024300200583","picUWPUrl":"https://p1.music.126.net/AYRhCEXW4StXLcS1Wa4j5g==/19082024300200583.jpg","pic56x56Url":"https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg","pic96x96Url":"https://p1.music.126.net/d4y8InBC-g23wE9ZyC_hgA==/19131502323477870.jpg","name":"创作|翻唱","id":2001},{"picPCBlack":1364493985405387,"picWeb":3389794351757648,"pic84x84Id":18734578627472520,"pic56x56Id":18734578627472520,"pic96x96Id":1379887094138436,"picIPad":3402988502531526,"picPCWhite":1364493985405387,"pic56x56IdStr":"18734578627472519","pic96x96IdStr":"1379887094138436","pic84x84IdUrl":"https://p1.music.126.net/uAYWhAiyE6O50JYAXOEeqg==/18734578627472519.jpg","picPCWhiteStr":"1364493985405387","picPCBlackStr":"1364493985405387","picWebStr":"3389794351757648","picIPadStr":"3402988502531526","picPCWhiteUrl":"https://p1.music.126.net/gu-88pW79Rptye4BQJXFTg==/1364493985405387.jpg","picPCBlackUrl":"https://p1.music.126.net/gu-88pW79Rptye4BQJXFTg==/1364493985405387.jpg","picWebUrl":"https://p1.music.126.net/BVIacbDdjw90QjU4z7mZIw==/3389794351757648.jpg","picIPadUrl":"https://p1.music.126.net/CygRxT-NBOfnYP3V4F17ww==/3402988502531526.jpg","picMacId":"109951163921394792","picMacUrl":"https://p1.music.126.net/Dw8fttHm3NgU_NEq4IUYwg==/109951163921394792.jpg","picUWPId":"1420569034620543","picUWPUrl":"https://p1.music.126.net/Jx3cJ3EQe2k0HGsP0gpLhg==/1420569034620543.jpg","pic56x56Url":"https://p1.music.126.net/uAYWhAiyE6O50JYAXOEeqg==/18734578627472519.jpg","pic96x96Url":"https://p1.music.126.net/Gg5zLIvvJu4FOL19apWnpA==/1379887094138436.jpg","name":"3D|电子","id":10002}]
     * code : 200
     */

    private int code;
    private List<CategoriesBean> categories;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class CategoriesBean {
        /**
         * picPCBlack : 18996262393228948
         * picWeb : 19119407695444320
         * pic84x84Id : 18734578627472516
         * pic56x56Id : 18734578627472516
         * pic96x96Id : 19131502323477870
         * picIPad : 19036944323358116
         * picPCWhite : 18996262393228948
         * pic56x56IdStr : 18734578627472515
         * pic96x96IdStr : 19131502323477870
         * pic84x84IdUrl : https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg
         * picPCWhiteStr : 18996262393228949
         * picPCBlackStr : 18996262393228949
         * picWebStr : 19119407695444318
         * picIPadStr : 19036944323358115
         * picPCWhiteUrl : https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg
         * picPCBlackUrl : https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg
         * picWebUrl : https://p1.music.126.net/cCogGBNagepu5uAd-OuCKQ==/19119407695444318.jpg
         * picIPadUrl : https://p1.music.126.net/XQTJvk8i1vP21eCUUt8DwA==/19036944323358115.jpg
         * picMacId : 109951163921391989
         * picMacUrl : https://p1.music.126.net/vUL2pw5_gcmJ8C8n-H_K7g==/109951163921391989.jpg
         * picUWPId : 19082024300200583
         * picUWPUrl : https://p1.music.126.net/AYRhCEXW4StXLcS1Wa4j5g==/19082024300200583.jpg
         * pic56x56Url : https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg
         * pic96x96Url : https://p1.music.126.net/d4y8InBC-g23wE9ZyC_hgA==/19131502323477870.jpg
         * name : 创作|翻唱
         * id : 2001
         */

        private long picPCBlack;
        private long picWeb;
        private long pic84x84Id;
        private long pic56x56Id;
        private long pic96x96Id;
        private long picIPad;
        private long picPCWhite;
        private String pic56x56IdStr;
        private String pic96x96IdStr;
        private String pic84x84IdUrl;
        private String picPCWhiteStr;
        private String picPCBlackStr;
        private String picWebStr;
        private String picIPadStr;
        private String picPCWhiteUrl;
        private String picPCBlackUrl;
        private String picWebUrl;
        private String picIPadUrl;
        private String picMacId;
        private String picMacUrl;
        private String picUWPId;
        private String picUWPUrl;
        private String pic56x56Url;
        private String pic96x96Url;
        private String name;
        private int id;

        public long getPicPCBlack() {
            return picPCBlack;
        }

        public void setPicPCBlack(long picPCBlack) {
            this.picPCBlack = picPCBlack;
        }

        public long getPicWeb() {
            return picWeb;
        }

        public void setPicWeb(long picWeb) {
            this.picWeb = picWeb;
        }

        public long getPic84x84Id() {
            return pic84x84Id;
        }

        public void setPic84x84Id(long pic84x84Id) {
            this.pic84x84Id = pic84x84Id;
        }

        public long getPic56x56Id() {
            return pic56x56Id;
        }

        public void setPic56x56Id(long pic56x56Id) {
            this.pic56x56Id = pic56x56Id;
        }

        public long getPic96x96Id() {
            return pic96x96Id;
        }

        public void setPic96x96Id(long pic96x96Id) {
            this.pic96x96Id = pic96x96Id;
        }

        public long getPicIPad() {
            return picIPad;
        }

        public void setPicIPad(long picIPad) {
            this.picIPad = picIPad;
        }

        public long getPicPCWhite() {
            return picPCWhite;
        }

        public void setPicPCWhite(long picPCWhite) {
            this.picPCWhite = picPCWhite;
        }

        public String getPic56x56IdStr() {
            return pic56x56IdStr;
        }

        public void setPic56x56IdStr(String pic56x56IdStr) {
            this.pic56x56IdStr = pic56x56IdStr;
        }

        public String getPic96x96IdStr() {
            return pic96x96IdStr;
        }

        public void setPic96x96IdStr(String pic96x96IdStr) {
            this.pic96x96IdStr = pic96x96IdStr;
        }

        public String getPic84x84IdUrl() {
            return pic84x84IdUrl;
        }

        public void setPic84x84IdUrl(String pic84x84IdUrl) {
            this.pic84x84IdUrl = pic84x84IdUrl;
        }

        public String getPicPCWhiteStr() {
            return picPCWhiteStr;
        }

        public void setPicPCWhiteStr(String picPCWhiteStr) {
            this.picPCWhiteStr = picPCWhiteStr;
        }

        public String getPicPCBlackStr() {
            return picPCBlackStr;
        }

        public void setPicPCBlackStr(String picPCBlackStr) {
            this.picPCBlackStr = picPCBlackStr;
        }

        public String getPicWebStr() {
            return picWebStr;
        }

        public void setPicWebStr(String picWebStr) {
            this.picWebStr = picWebStr;
        }

        public String getPicIPadStr() {
            return picIPadStr;
        }

        public void setPicIPadStr(String picIPadStr) {
            this.picIPadStr = picIPadStr;
        }

        public String getPicPCWhiteUrl() {
            return picPCWhiteUrl;
        }

        public void setPicPCWhiteUrl(String picPCWhiteUrl) {
            this.picPCWhiteUrl = picPCWhiteUrl;
        }

        public String getPicPCBlackUrl() {
            return picPCBlackUrl;
        }

        public void setPicPCBlackUrl(String picPCBlackUrl) {
            this.picPCBlackUrl = picPCBlackUrl;
        }

        public String getPicWebUrl() {
            return picWebUrl;
        }

        public void setPicWebUrl(String picWebUrl) {
            this.picWebUrl = picWebUrl;
        }

        public String getPicIPadUrl() {
            return picIPadUrl;
        }

        public void setPicIPadUrl(String picIPadUrl) {
            this.picIPadUrl = picIPadUrl;
        }

        public String getPicMacId() {
            return picMacId;
        }

        public void setPicMacId(String picMacId) {
            this.picMacId = picMacId;
        }

        public String getPicMacUrl() {
            return picMacUrl;
        }

        public void setPicMacUrl(String picMacUrl) {
            this.picMacUrl = picMacUrl;
        }

        public String getPicUWPId() {
            return picUWPId;
        }

        public void setPicUWPId(String picUWPId) {
            this.picUWPId = picUWPId;
        }

        public String getPicUWPUrl() {
            return picUWPUrl;
        }

        public void setPicUWPUrl(String picUWPUrl) {
            this.picUWPUrl = picUWPUrl;
        }

        public String getPic56x56Url() {
            return pic56x56Url;
        }

        public void setPic56x56Url(String pic56x56Url) {
            this.pic56x56Url = pic56x56Url;
        }

        public String getPic96x96Url() {
            return pic96x96Url;
        }

        public void setPic96x96Url(String pic96x96Url) {
            this.pic96x96Url = pic96x96Url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
