package com.wxgzh.entiy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-21
 **/
@Data
public class PhotoButton extends AbstractButton {
    private String key;
    private String type = "pic_photo_or_album";
    private List<AbstractButton> sub_button = new ArrayList<>();

    public PhotoButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public PhotoButton() {
    }
}
