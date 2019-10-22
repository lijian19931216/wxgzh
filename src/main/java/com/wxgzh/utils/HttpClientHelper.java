package com.wxgzh.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-30
 **/



public class HttpClientHelper {
    public static String doPost(String url,Map<String,Object> param) throws IOException {
        // 获取默认的请求客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过HttpPost来发送post请求
        HttpPost httpPost = new HttpPost(url);
        /*
         * post带参数开始
         */
        // 第三步：构造list集合，往里面丢数据
        List<NameValuePair> list = new ArrayList<>();
        for (Map.Entry<String,Object> entry : param.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            list.add(new BasicNameValuePair(entry.getKey(),String.valueOf(entry.getValue())));
        }

        // 第二步：我们发现Entity是一个接口，所以只能找实现类，发现实现类又需要一个集合，集合的泛型是NameValuePair类型
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
        // 第一步：通过setEntity 将我们的entity对象传递过去
        httpPost.setEntity(formEntity);
        /*
         * post带参数结束
         */
        // HttpEntity
        // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
        // 通过client来执行请求，获取一个响应结果
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");
//        System.out.println(str);
        // 关闭
        response.close();
        return str;


    }

    public static String sendGet(String urlParam) throws HttpException, IOException {
        // 获取http客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过httpget方式来实现我们的get请求
        HttpGet httpGet = new HttpGet(urlParam);
        // 通过client调用execute方法，得到我们的执行结果就是一个response，所有的数据都封装在response里面了
        CloseableHttpResponse Response = client.execute(httpGet);
        // HttpEntity
        // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
        // 所有的响应的数据，也全部都是封装在HttpEntity里面
        HttpEntity entity = Response.getEntity();
        // 通过EntityUtils 来将我们的数据转换成字符串
        String str = EntityUtils.toString(entity, "UTF-8");
        // EntityUtils.toString(entity)
//        System.out.println(str);
        // 关闭
        Response.close();
        return str;

    }

    public static String sendPost(String toJson,String url) throws Exception {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(url);
        RequestEntity se = new StringRequestEntity(toJson ,"application/json" ,"UTF-8");
        // 设置post请求超时时间
        postMethod.setRequestEntity(se);
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        postMethod.addRequestHeader("Content-Type", "application/json");
        postMethod.setRequestEntity(se);
        httpClient.executeMethod(postMethod);

        String result = postMethod.getResponseBodyAsString();
        postMethod.releaseConnection();
        return result;
    }

    public static void main(String[] args) throws HttpException, IOException {
        String url1 =
 "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&" +
         "appid=wx35f57221ae1b48c7&secret=247dc698b23915209a843d338cdf90de";
      String  url = "https://api.weixin.qq.com/cgi-bin/token";

        Map<String,Object> map=new HashMap();
        map.put("grant_type","client_credential");
        map.put("appid","wx35f57221ae1b48c7");
        map.put("secret","247dc698b23915209a843d338cdf90de");
        System.out.println("======="+doPost(url,map));
        System.out.println("---------"+sendGet(url1));
    }


}
