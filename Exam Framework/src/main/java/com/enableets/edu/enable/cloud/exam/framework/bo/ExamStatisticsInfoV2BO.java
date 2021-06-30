package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: bruce_li@enable-ets.com
 * @Date: 2020/9/18
 * @Description: 考试明细BO
 */
@Data
@Accessors(chain = true)
public class ExamStatisticsInfoV2BO implements Serializable {

    /**
     * 总分
     */
    private Float totalScore;

    /**
     * 考试明细标识
     */
    private Long examDetailsId;

    /**
     * 考试标识
     */
    private Long examId;

    /**
     * 年级编码
     */
    private String gradeCode;

    /**
     * 年级名称
     */
    private String gradeName;

    /**
     * 学期名称
     */
    private String termName;

    /**
     * 考试类别
     */
    private String name;

    /**
     * 班级标识
     */
    private String classId;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学科代码
     */
    private String subjectCode;

    /**
     * 学科名称
     */
    private String subjectName;

    /**
     * 课程标识
     */
    private String courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者
     */
    private String updator;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 学校id
     */
    private String schoolId;

    /**
     * 学期id
     */
    private String termId;

    private  ExamDetailsStepTaskInfoBO stepTaskInfo;

    /**
     * 发布状态  0未发布  1已发布
     */
    private String publishStatus;

    /**
     * 考试类别
     */
    private String typeName;

    /**
     * 考试类型
     */
    private String type;

}
