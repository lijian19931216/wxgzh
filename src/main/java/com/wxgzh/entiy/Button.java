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
public class Button {
    private List<AbstractButton> button = new ArrayList<>();
}
