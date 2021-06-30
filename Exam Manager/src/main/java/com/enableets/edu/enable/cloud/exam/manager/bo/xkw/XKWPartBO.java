package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

import java.util.List;

/**
 * 试卷主体
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/01 13:48
 **/

@Data
public class XKWPartBO {
    private List<XKWPartBodyBO> partBody;

    private XKWPartHeadBO partHead;
}
