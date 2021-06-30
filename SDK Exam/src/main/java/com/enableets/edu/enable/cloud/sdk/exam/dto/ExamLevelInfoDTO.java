package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Jack_Li@enable-ets.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class ExamLevelInfoDTO {

    // 分数等级主键
    private Integer levelId;
    // 等级名称
    private String levelName;
    // 学校标识
    private String schoolId;
    // 学校编码
    private String schoolCode;
    // 年级标识
    private String gradeCode;
    // 最低分
    private Float minPoint;
    // 最高分
    private Float maxPoint;
    // 顺序
    private Integer sequence;

}
