package com.wxgzh.entiy;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-30
 **/
@Data
public class SubButtonBean extends BaseButton {
    /**
     * type : view
     * name : 搜索
     * url : http://www.soso.com/
     * appid : wx286b93c14bbf93aa
     * pagepath : pages/lunar/index
     * key : V1001_GOOD
     */


    private String url;
    private String appid;
    private String pagepath;


}
