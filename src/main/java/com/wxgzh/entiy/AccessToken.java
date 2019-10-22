package com.wxgzh.entiy;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-14
 **/
@Data
public class AccessToken {
    private String accessToken;
    private Long expiresIn;


    public boolean isExpired(){
        return System.currentTimeMillis()>expiresIn;
    }
    private AccessToken(){
    }
    public AccessToken (String accessToken, String expiresIn){
       this.accessToken = accessToken;
       this.expiresIn = System.currentTimeMillis()+Integer.parseInt(expiresIn)*1000;
    }

}
