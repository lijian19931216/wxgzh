package com.wxgzh.entiy;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-21
 **/
@Data
public class ClickButton extends AbstractButton {
    private String type = "click";
    private String key ;

    public ClickButton(String key,String name) {
        super(name);
        this.key = key;
    }

    public ClickButton() {

    }
}
