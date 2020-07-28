package com.imooc.lib_api.model.user;


import java.util.List;

/**
 * 首页动态的接口
 */
public class MainEventBean {

    /**
     * code : 200
     * more : true
     * event : [{"actName":null,"pendantData":null,"forwardCount":2,"lotteryEventData":null,"user":{"defaultAvatar":false,"province":110000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/GaT7wmicPzrRfwuAy6sujw==/18981968742175332.jpg","accountStatus":0,"gender":1,"city":110101,"birthday":-2209017600000,"userId":544437734,"userType":10,"nickname":"RMBCrew","signature":"RMBCrew是国内各大知名艺人音乐MV 、演唱会等的御用编舞、伴舞团队，也是国内多家卫视综艺栏目，大型音乐&影视颁奖盛典，跨年演唱会等的指定合作团队。多年来，团队一直活跃在各大齐舞赛事，并多次获得冠军，成为街舞行业内的标杆之一。","description":"舞蹈工作室RMBCrew","detailDescription":"舞蹈工作室RMBCrew","avatarImgId":18981968742175332,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":{"1":"舞蹈原创视频达人"},"djStatus":0,"vipType":0,"remarkName":null,"backgroundImgIdStr":"109951162868128395","avatarImgIdStr":"18981968742175332","urlAnalyze":false,"vipRights":null,"avatarImgId_str":"18981968742175332","followeds":11911},"uuid":null,"expireTime":0,"eventTime":1568898458684,"json":"{\"msg\":\"【RMB舞室】德太编舞《你的微笑》\",\"video\":{\"vid\":0,\"coverUrl\":\"http://p3.music.126.net/gUgLgifT3lI_33M5Wmq5Uw==/109951164325571107.jpg\",\"duration\":93,\"playTime\":1790,\"height\":1080,\"width\":1920,\"size\":13000949,\"state\":1,\"coverType\":0,\"urlInfo\":null,\"videoId\":\"30460127B5D3B0268056A2EB4A89A325\",\"threadId\":null,\"title\":\"【RMB舞室】德太编舞《你的微笑》\",\"description\":\"【RMB舞室】德太编舞《你的微笑》\",\"creator\":{\"defaultAvatar\":false,\"province\":110000,\"authStatus\":1,\"followed\":false,\"avatarUrl\":\"http://p1.music.126.net/GaT7wmicPzrRfwuAy6sujw==/18981968742175332.jpg\",\"accountStatus\":0,\"gender\":1,\"city\":110101,\"birthday\":-2209017600000,\"userId\":544437734,\"userType\":10,\"nickname\":\"RMBCrew\",\"signature\":\"RMBCrew是国内各大知名艺人音乐MV 、演唱会等的御用编舞、伴舞团队，也是国内多家卫视综艺栏目，大型音乐&影视颁奖盛典，跨年演唱会等的指定合作团队。多年来，团队一直活跃在各大齐舞赛事，并多次获得冠军，成为街舞行业内的标杆之一。\",\"description\":\"舞蹈工作室RMBCrew\",\"detailDescription\":\"舞蹈工作室RMBCrew\",\"avatarImgId\":18981968742175332,\"backgroundImgId\":109951162868128395,\"backgroundUrl\":\"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg\",\"authority\":0,\"mutual\":false,\"expertTags\":null,\"experts\":{\"1\":\"舞蹈原创视频达人\"},\"djStatus\":0,\"vipType\":0,\"remarkName\":null,\"backgroundImgIdStr\":\"109951162868128395\",\"avatarImgIdStr\":\"18981968742175332\",\"avatarImgId_str\":\"18981968742175332\"},\"videoStatus\":0,\"resolutions\":[{\"resolution\":0,\"size\":13000949},{\"resolution\":0,\"size\":22159186},{\"resolution\":0,\"size\":32602387},{\"resolution\":0,\"size\":63240966}],\"antisChecking\":false,\"durationms\":93653}}","rcmdInfo":{"reason":"优质动态推荐","alg":"default","type":1,"scene":"social","userReason":"11911粉丝"},"actId":0,"pics":[],"showTime":1566878056637,"tmplId":0,"id":7648367924,"type":39,"topEvent":false,"insiteForwardCount":2,"info":{"commentThread":{"id":"A_EV_2_7648367924_544437734","resourceInfo":null,"resourceType":2,"commentCount":3,"likedCount":11,"shareCount":2,"hotCount":0,"latestLikedUsers":[{"s":1313357723,"t":1568385467971},{"s":1705388288,"t":1568365410937},{"s":293446669,"t":1568275948970},{"s":314526479,"t":1567775131192},{"s":415132420,"t":1567343239258},{"s":92155591,"t":1567141726480},{"s":1402640099,"t":1567093394628},{"s":314681905,"t":1567007162747},{"s":413411246,"t":1566987587817},{"s":448738111,"t":1566892709194}],"resourceOwnerId":0,"resourceId":0,"resourceTitle":null},"latestLikedUsers":null,"liked":false,"comments":null,"resourceType":2,"resourceId":7648367924,"commentCount":3,"likedCount":11,"shareCount":2,"threadId":"A_EV_2_7648367924_544437734"}}]
     * lasttime : 1568898458684
     */

    private int code;
    private boolean more;
    private long lasttime;
    private List<UserEventBean.EventsBean> event;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public long getLasttime() {
        return lasttime;
    }

    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }

    public List<UserEventBean.EventsBean> getEvent() {
        return event;
    }

    public void setEvent(List<UserEventBean.EventsBean> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "MainEventBean{" +
                "code=" + code +
                ", more=" + more +
                ", lasttime=" + lasttime +
                ", event=" + event +
                '}';
    }
}
