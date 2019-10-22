package com.wxgzh;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entiy.*;
import com.example.demo.utils.HttpClientHelper;
import com.example.demo.utils.WeChatUtils;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-21
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        Button button = new Button();
        button.getButton().add(new ClickButton("key", "clickbutton"));
        button.getButton().add(new ViewButton("viewbutton", "http://www.baidu.com"));
        SubButton subButton = new SubButton("有子菜单");
        subButton.getSub_button().add(new PhotoButton("3.1", "111"));
        subButton.getSub_button().add(new ViewButton("wangyi", "http://www.sina.com"));

        button.getButton().add(subButton);
        System.out.println(JSONObject.toJSON(button));
        System.out.println(HttpClientHelper.sendPost(JSONObject.toJSON(button).toString(), "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + WeChatUtils.getToken()));

    }
}
