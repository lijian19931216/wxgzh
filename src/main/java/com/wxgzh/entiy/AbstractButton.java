package com.wxgzh.entiy;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-21
 **/
@Data
public abstract class AbstractButton {
    private String name;

    public AbstractButton(String name) {
        this.name = name;
    }

    public AbstractButton() {
    }
}
