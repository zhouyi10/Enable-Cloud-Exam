package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 分数等级BO
 */
@Data
@Accessors(chain = true)
public class ExamLevelInfoBO {

    /**
     * 等级标识
     */

    private Integer levelId;

    /**
     * 等级名称
     */
    private String levelName;

    /**
     * 学校标识
     */
    private String schoolId;

    /**
     * 学校编码
     */
    private String schoolCode;

    /**
     * 年级编码
     */
    private String gradeCode;

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
