package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 分数等级模版BO
 */
@Data
@Accessors(chain = true)
public class ExamLevelTemplateBO {

    /**
     * 分数等级名
     */
    private String levelName;

    /**
     * 最低分
     */
    private Float minPoint;

    /**
     * 最高分
     */
    private Float maxPoint;

    /**
     * 顺序
     */
    private Integer sequence;

}
