package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

import java.util.List;

/**
 * 学科网试卷信息
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/01 13:46
 **/

@Data
public class XKWPaperBO {
    private Integer bankId;

    private List<XKWPartBO> body;

    private XKWPaperHeadBO head;
}
