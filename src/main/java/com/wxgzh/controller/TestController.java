package com.wxgzh.controller;


import com.wxgzh.utils.WeChatUtils;
import com.wxgzh.utils.XmlUtils;
import org.dom4j.DocumentHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
@RestController
@RequestMapping("/hh")
public class TestController {
    @RequestMapping("/hh")
    public String test(HttpServletRequest request){
        String signature = request.getParameter("signature");
        System.out.println(signature);
        String timestamp = request.getParameter("timestamp");
        System.out.println(timestamp);
        String nonce = request.getParameter("nonce");
        System.out.println(nonce);
        String echostr = request.getParameter("echostr");
        System.out.println(echostr);

        try {
            ServletInputStream inputStream = request.getInputStream();
            byte[] box = new byte[1024];
            int len = 0;
            StringBuilder builder = new StringBuilder();
            while(-1!=(len = inputStream.read(box))) {
                System.out.println(len);
                String msg = new String(box, 0, len);
                builder.append(msg);
            }
            System.out.println(builder.toString());
            Map<String, Object> map = XmlUtils.Dom2Map(DocumentHelper.parseText(builder.toString()));
            System.out.println(map);
            System.out.println(WeChatUtils.getResponse(map));
            return WeChatUtils.getResponse(map);

       /* String xml="<xml><ToUserName><![CDATA["+map.get("FromUserName")+"]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+map.get("ToUserName")+"]]></FromUserName>\n" +
                "<CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[this is a test]]></Content>\n" +
                "<MsgId>1234567890123456</MsgId>" +
                "</xml>" ;
        return  xml;*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(WeChatUtils.checParam(timestamp,nonce,signature)){

            System.out.println("chengongo");
            return echostr;
        }else {

        }
        System.out.println("hhhh");
        return null ;
    }
    @RequestMapping("/hhh")
    public void test(){
        System.out.println("hhhh");
    }
}
