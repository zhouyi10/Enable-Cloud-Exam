package com.enableets.edu.enable.cloud.sdk.exam.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 查询考试详情DTO信息
 * @author bruce_li@enable-ets.com
 * @since 2020/9/18
 */
@Data
@Accessors(chain = true)
public class QueryExamStatisticsV2DTO {

    /**
     * 学校id
     */
    private String schoolId;

    /**
     * 学期id
     */
    private String termId;

    /**
     * 班级标识 如有多个用','分隔
     */
    private String classIds;

    /**
     * 学科代码 如有多个用','分隔
     */
    private String subjectCodes;

    /**
     * 课程标识
     */
    private String courseId;

    private Integer offset;

    private Integer rows;

    /**
     * examName
     */
    private String examName;
}
