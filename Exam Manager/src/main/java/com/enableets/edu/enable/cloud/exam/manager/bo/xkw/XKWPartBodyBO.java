package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

import java.util.List;

/**
 * 试卷卷别信息
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/01 13:51
 **/

@Data
public class XKWPartBodyBO {
    private List<XKWQuestionBO> questions;

    private XKWTypeBO type;
}
