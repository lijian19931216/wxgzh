package com.wxgzh.entiy;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
@XStreamAlias("xml")
public class TestMessage extends Message {
    @XStreamAlias("Content")
    private String content ;

    public TestMessage() {

    }

    public TestMessage(Map<String,Object> map,String content) {
        super(map);
        setMsgType("text");
        this.content = content ;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TestMessage{" +
                "content='" + content + '\'' +
                "} " + super.toString();
    }

    public static void main(String[] args) {
      /*  Map map = new HashMap();
        map.put("FromUserName", "FromUserName");
        map.put("ToUserName", "ToUserName");
        map.put("MsgType", "MsgType");
        TestMessage testMessage = new TestMessage(map, "hihao");
        XStream xStream = new XStream();
        xStream.processAnnotations(TestMessage.class);
        System.out.println(xStream.toXML(testMessage));*/
      ButtonBean buttonBean= new ButtonBean();
      buttonBean.setKey("V1001_TODAY_MUSIC");
      buttonBean.setName("菜单1");
      buttonBean.setType("click");
      SubButtonBean subButtonBean= new SubButtonBean();
//      subButtonBean.setAppid("appid");
//      subButtonBean.setKey("subkey");
      subButtonBean.setName("子菜单1");
      subButtonBean.setType("view");
      subButtonBean.setUrl("http://www.soso.com/");
        List<SubButtonBean> list= new ArrayList<>();
        list.add(subButtonBean);
        buttonBean.setSubButton(list);

        List<ButtonBean> buttonBeans = new ArrayList<>();
        buttonBeans.add(buttonBean);
        Map map = new HashMap();
        map.put("button", buttonBeans);

        String jsonObject = JSON.toJSONString(map);
        System.out.println(jsonObject);
    }
}
