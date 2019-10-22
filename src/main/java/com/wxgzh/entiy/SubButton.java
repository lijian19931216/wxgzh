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
public class SubButton extends AbstractButton {

    private List<AbstractButton> sub_button = new ArrayList<>();

    public SubButton(String name) {
        super(name);
    }
    public SubButton() {
    }

}
