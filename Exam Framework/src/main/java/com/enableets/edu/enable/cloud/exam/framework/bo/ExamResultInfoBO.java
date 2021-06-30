package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 考试成绩BO
 */
@Data
@Accessors(chain = true)
public class ExamResultInfoBO {

    /**
     * 考试明细标识
     */
    private Long examDetailsId;

    /**
     * 学生标识
     */
    private String studentUserId;

    /**
     * 学生名称
     */
    private String studentFullName;

    /**
     * 学籍号
     */
    private String studentCode;

    /**
     * 学号(座位号)
     */
    private String studentNo;

    /**
     * 1 正常 2缺考 3违纪 4补考
     */
    private String status;

    /**
     * 录分教师标识
     */
    private String teacherUserId;

    /**
     * 录分教师名称
     */
    private String teacherFullName;

    /**
     * A卷分
     */
    private Float aPoint;

    /**
     * B卷分
     */
    private Float bPoint;

    /**
     * 附加分
     */
    private Float additionalPoint;

    /**
     * 标准分
     */
    private Float standardPoint;

    /**
     * 总分
     */
    private Float totalPoint;

    /**
     * 分数等级
     */
    private String level;

    /**
     * 评语
     */
    private String comment;

    private String contentId;
    
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
    
    private String subjectCode;

    private String subjectName;

    private String courseId;

    private String courseName;

    private String gradeCode;
    
    private String classId;

    private String className;

    private String examId;

    private String termId;
    
    /**
     * 试卷总分
     */
    private Float totalScore;
    
    private String typeCode;

    private String type;

    private String examName;

    private String termName;

    private String avgScore;
    
}
