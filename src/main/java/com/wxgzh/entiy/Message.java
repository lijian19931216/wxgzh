package com.wxgzh.entiy;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
@XStreamAlias("xml")
public class Message {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public Message() {
    }

    public Message(Map<String,Object> map){
        this.toUserName = (String) map.get("FromUserName");
        this.fromUserName = (String) map.get("ToUserName");
        this.createTime = System.currentTimeMillis()/1000 +"";

    }

    @Override
    public String toString() {
        return "Message{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }


}
