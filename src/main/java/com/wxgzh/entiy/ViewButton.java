package com.wxgzh.entiy;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-21
 **/
@Data
public class ViewButton extends AbstractButton {
    private String type = "view";
    private String url;

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }

    public ViewButton() {
    }
}
