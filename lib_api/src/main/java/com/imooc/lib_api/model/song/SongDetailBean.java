package com.imooc.lib_api.model.song;

import java.util.List;

public class SongDetailBean {

    /**
     * songs : [{"name":"JoJo","id":27917548,"pst":0,"t":0,"ar":[{"id":48514,"name":"Boz Scaggs","tns":[],"alias":[]}],"alia":[],"pop":85,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":2694934,"name":"The Essential Boz Scaggs","picUrl":"https://p1.music.126.net/_YmTuIMoG0dh2OJSOE-LPw==/17829680556434243.jpg","tns":[],"pic_str":"17829680556434243","pic":17829680556434244},"dt":354746,"h":{"br":320000,"fid":0,"size":14220536,"vd":-2.65076E-4},"m":{"br":160000,"fid":0,"size":7123590,"vd":0.0324002},"l":{"br":96000,"fid":0,"size":4284811,"vd":-2.65076E-4},"a":null,"cd":"2","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"mv":0,"mst":9,"cp":7001,"rtype":0,"rurl":null,"publishTime":1382976000007}]
     * privileges : [{"id":27917548,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":256,"preSell":false}]
     * code : 200
     */

    private int code;
    private List<SongsBean> songs;
    private List<PrivilegesBean> privileges;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public List<PrivilegesBean> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegesBean> privileges) {
        this.privileges = privileges;
    }

    public static class SongsBean {
        /**
         * name : JoJo
         * id : 27917548
         * pst : 0
         * t : 0
         * ar : [{"id":48514,"name":"Boz Scaggs","tns":[],"alias":[]}]
         * alia : []
         * pop : 85
         * st : 0
         * rt :
         * fee : 8
         * v : 6
         * crbt : null
         * cf :
         * al : {"id":2694934,"name":"The Essential Boz Scaggs","picUrl":"https://p1.music.126.net/_YmTuIMoG0dh2OJSOE-LPw==/17829680556434243.jpg","tns":[],"pic_str":"17829680556434243","pic":17829680556434244}
         * dt : 354746
         * h : {"br":320000,"fid":0,"size":14220536,"vd":-2.65076E-4}
         * m : {"br":160000,"fid":0,"size":7123590,"vd":0.0324002}
         * l : {"br":96000,"fid":0,"size":4284811,"vd":-2.65076E-4}
         * a : null
         * cd : 2
         * no : 1
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * djId : 0
         * copyright : 1
         * s_id : 0
         * mark : 0
         * mv : 0
         * mst : 9
         * cp : 7001
         * rtype : 0
         * rurl : null
         * publishTime : 1382976000007
         */

        private String name;
        private long id;
        private int pst;
        private int t;
        private int pop;
        private int st;
        private String rt;
        private int fee;
        private int v;
        private Object crbt;
        private String cf;
        private AlBean al;
        //歌曲时间
        private long dt;
        private HBean h;
        private MBean m;
        private LBean l;
        private Object a;
        private String cd;
        private int no;
        private Object rtUrl;
        private int ftype;
        private int djId;
        private int copyright;
        private int s_id;
        private long mark;
        private long mv;
        private int mst;
        private int cp;
        private int rtype;
        private Object rurl;
        private long publishTime;
        private List<ArBean> ar;
        private List<?> alia;
        private List<?> rtUrls;

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

        public int getPst() {
            return pst;
        }

        public void setPst(int pst) {
            this.pst = pst;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        public int getPop() {
            return pop;
        }

        public void setPop(int pop) {
            this.pop = pop;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public String getRt() {
            return rt;
        }

        public void setRt(String rt) {
            this.rt = rt;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public Object getCrbt() {
            return crbt;
        }

        public void setCrbt(Object crbt) {
            this.crbt = crbt;
        }

        public String getCf() {
            return cf;
        }

        public void setCf(String cf) {
            this.cf = cf;
        }

        public AlBean getAl() {
            return al;
        }

        public void setAl(AlBean al) {
            this.al = al;
        }

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public HBean getH() {
            return h;
        }

        public void setH(HBean h) {
            this.h = h;
        }

        public MBean getM() {
            return m;
        }

        public void setM(MBean m) {
            this.m = m;
        }

        public LBean getL() {
            return l;
        }

        public void setL(LBean l) {
            this.l = l;
        }

        public Object getA() {
            return a;
        }

        public void setA(Object a) {
            this.a = a;
        }

        public String getCd() {
            return cd;
        }

        public void setCd(String cd) {
            this.cd = cd;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Object getRtUrl() {
            return rtUrl;
        }

        public void setRtUrl(Object rtUrl) {
            this.rtUrl = rtUrl;
        }

        public int getFtype() {
            return ftype;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
        }

        public int getDjId() {
            return djId;
        }

        public void setDjId(int djId) {
            this.djId = djId;
        }

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public int getS_id() {
            return s_id;
        }

        public void setS_id(int s_id) {
            this.s_id = s_id;
        }

        public long getMark() {
            return mark;
        }

        public void setMark(long mark) {
            this.mark = mark;
        }

        public long getMv() {
            return mv;
        }

        public void setMv(int mv) {
            this.mv = mv;
        }

        public int getMst() {
            return mst;
        }

        public void setMst(int mst) {
            this.mst = mst;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getRtype() {
            return rtype;
        }

        public void setRtype(int rtype) {
            this.rtype = rtype;
        }

        public Object getRurl() {
            return rurl;
        }

        public void setRurl(Object rurl) {
            this.rurl = rurl;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public List<ArBean> getAr() {
            return ar;
        }

        public void setAr(List<ArBean> ar) {
            this.ar = ar;
        }

        public List<?> getAlia() {
            return alia;
        }

        public void setAlia(List<?> alia) {
            this.alia = alia;
        }

        public List<?> getRtUrls() {
            return rtUrls;
        }

        public void setRtUrls(List<?> rtUrls) {
            this.rtUrls = rtUrls;
        }

        public static class AlBean {
            /**
             * id : 2694934
             * name : The Essential Boz Scaggs
             * picUrl : https://p1.music.126.net/_YmTuIMoG0dh2OJSOE-LPw==/17829680556434243.jpg
             * tns : []
             * pic_str : 17829680556434243
             * pic : 17829680556434244
             */

            private long id;
            private String name;
            private String picUrl;
            private String pic_str;
            private long pic;
            private List<?> tns;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getPic_str() {
                return pic_str;
            }

            public void setPic_str(String pic_str) {
                this.pic_str = pic_str;
            }

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public List<?> getTns() {
                return tns;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }
        }

        public static class HBean {
            /**
             * br : 320000
             * fid : 0
             * size : 14220536
             * vd : -2.65076E-4
             */

            private int br;
            private String fid;
            private int size;
            private double vd;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public double getVd() {
                return vd;
            }

            public void setVd(double vd) {
                this.vd = vd;
            }
        }

        public static class MBean {
            /**
             * br : 160000
             * fid : 0
             * size : 7123590
             * vd : 0.0324002
             */

            private int br;
            private String fid;
            private int size;
            private double vd;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public double getVd() {
                return vd;
            }

            public void setVd(double vd) {
                this.vd = vd;
            }
        }

        public static class LBean {
            /**
             * br : 96000
             * fid : 0
             * size : 4284811
             * vd : -2.65076E-4
             */

            private int br;
            private String fid;
            private int size;
            private double vd;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public double getVd() {
                return vd;
            }

            public void setVd(double vd) {
                this.vd = vd;
            }
        }

        public static class ArBean {
            /**
             * id : 48514
             * name : Boz Scaggs
             * tns : []
             * alias : []
             */

            private long id;
            private String name;
            private List<?> tns;
            private List<?> alias;

            public String getId() {
                return String.valueOf(id);
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<?> getTns() {
                return tns;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }

    public static class PrivilegesBean {
        /**
         * id : 27917548
         * fee : 8
         * payed : 0
         * st : 0
         * pl : 128000
         * dl : 0
         * sp : 7
         * cp : 1
         * subp : 1
         * cs : false
         * maxbr : 999000
         * fl : 128000
         * toast : false
         * flag : 256
         * preSell : false
         */

        private long id;
        private int fee;
        private int payed;
        private int st;
        private int pl;
        private int dl;
        private int sp;
        private int cp;
        private int subp;
        private boolean cs;
        private int maxbr;
        private int fl;
        private boolean toast;
        private int flag;
        private boolean preSell;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getPl() {
            return pl;
        }

        public void setPl(int pl) {
            this.pl = pl;
        }

        public int getDl() {
            return dl;
        }

        public void setDl(int dl) {
            this.dl = dl;
        }

        public int getSp() {
            return sp;
        }

        public void setSp(int sp) {
            this.sp = sp;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getSubp() {
            return subp;
        }

        public void setSubp(int subp) {
            this.subp = subp;
        }

        public boolean isCs() {
            return cs;
        }

        public void setCs(boolean cs) {
            this.cs = cs;
        }

        public int getMaxbr() {
            return maxbr;
        }

        public void setMaxbr(int maxbr) {
            this.maxbr = maxbr;
        }

        public int getFl() {
            return fl;
        }

        public void setFl(int fl) {
            this.fl = fl;
        }

        public boolean isToast() {
            return toast;
        }

        public void setToast(boolean toast) {
            this.toast = toast;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isPreSell() {
            return preSell;
        }

        public void setPreSell(boolean preSell) {
            this.preSell = preSell;
        }

        @Override
        public String toString() {
            return "PrivilegesBean{" +
                    "id=" + id +
                    ", fee=" + fee +
                    ", payed=" + payed +
                    ", st=" + st +
                    ", pl=" + pl +
                    ", dl=" + dl +
                    ", sp=" + sp +
                    ", cp=" + cp +
                    ", subp=" + subp +
                    ", cs=" + cs +
                    ", maxbr=" + maxbr +
                    ", fl=" + fl +
                    ", toast=" + toast +
                    ", flag=" + flag +
                    ", preSell=" + preSell +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SongDetailBean{" +
                "code=" + code +
                ", songs=" + songs +
                ", privileges=" + privileges +
                '}';
    }
}
