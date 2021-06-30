package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

import java.util.List;

/**
 * 子题目
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/04 13:01
 **/

@Data
public class XKWChildQuestionBO {

    private String childAnswer;

    private String childBody;

    private Integer number;

    private List<XKWIdNameBO> childOptions;

}
