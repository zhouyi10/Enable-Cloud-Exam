package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

/**
 * 题目类型
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/01 14:09
 **/

@Data
public class XKWQuestionTypeBO {

    private Integer canSplit;

    private Long id;

    private String name;

    private Long parentId;

    private Integer selectType;

}
