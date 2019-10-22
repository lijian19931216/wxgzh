package com.wxgzh.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entiy.AccessToken;
import com.example.demo.entiy.Message;
import com.example.demo.entiy.PictureTextMessage;
import com.example.demo.entiy.TestMessage;
import com.thoughtworks.xstream.XStream;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-28
 **/
public class WeChatUtils {

    public static String token = "lijian" ;
    public static String appId = "wx35f57221ae1b48c7" ;
    public static String secret = "247dc698b23915209a843d338cdf90de" ;


    public static boolean checParam(String timestamp, String nonce, String signature) {
        String[] array = {token,timestamp,nonce};
        Arrays.sort(array);
        String result = array[0]+array[1]+array[2] ;

        String mysig = sha1(result);

        return mysig.equalsIgnoreCase(signature);

    }

    private static String sha1(String result)  {

        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(result.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";


    }

    public static String getResponse(Map<String, Object> map) {
        String MsgType= (String) map.get("MsgType");
        Message message = null ;
        switch (MsgType){
            case "text" : message = new TestMessage(map,"你要跟啥") ; break;
            case "image" : break;
            case "voice" : message = new PictureTextMessage(map) ;break;
            case "video" : break;
            case "shortvideo" : break;
            case "location" : break;
            case "event" : message=dealEvent(map);break;
        }
        return messageToString(message);
    }

    private static Message dealEvent(Map<String, Object> map) {
        String event = map.get("Event").toString();
        switch (event) {
            case "CLICK":return dealClick(map);
            default:break;
        }
        return null;

    }

    private static Message dealClick(Map<String, Object> map) {
        if ("key".equals(map.get("EventKey"))) {
            return new TestMessage(map,"0000000");
        }
        return  null;
    }

    private static String messageToString(Message message) {
        XStream xStream = new XStream();
        xStream.processAnnotations(TestMessage.class);
//        xStream.processAnnotations(PictureTextMessage.class);
        return xStream.toXML(message);
    }
    //获取token
    private static String getAccessTokenByInt()  {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&" +
                "appid="+appId+"&secret="+secret;
        try {
            return HttpClientHelper.sendGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private static AccessToken accessToken1;
    private static void getAccessToken()  {
        JSONObject jsonObject = JSONObject.parseObject(getAccessTokenByInt());
        String accessToken = jsonObject.getString("access_token");
        String expiresIn = jsonObject.getString("expires_in");
        accessToken1 = new AccessToken(accessToken, expiresIn);

    }
    //
    public static String getToken(){
        if (accessToken1==null||accessToken1.isExpired()){
          getAccessToken();
        }
        return accessToken1.getAccessToken();
    }

    public static void main(String[] args) {
        System.out.println(getToken());
    }

}
