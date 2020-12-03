package com.imooc.lib_api.model.user;

/**
 * {
 *     "code": 200,
 *     "data": {
 *         "msg": "测试内容",
 *         "eventId": 18692791021,
 *         "eventTime": 1606964266659
 *     }
 * }
 */
public class ForwardEventBean {

    private int code;
    private ForwardEventData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ForwardEventData getData() {
        return data;
    }

    public void setData(ForwardEventData data) {
        this.data = data;
    }

    public static class ForwardEventData{
        private String msg;
        private String eventId;
        private String eventTime;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getEventTime() {
            return eventTime;
        }

        public void setEventTime(String eventTime) {
            this.eventTime = eventTime;
        }
    }
}
