package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 考试明细BO
 */
@Data
@Accessors(chain = true)
public class ExamDetailsInfoBO {

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
     * 文理科属性：理科;文科
     */
    private String courseAttribute;

    /**
     * 考试时间
     */
    private Date examTime;

    /**
     * 计划考试学生数
     */
    private Integer planStudentNumber;

    /**
     * 实际考试学生数
     */
    private Integer actualStudentNumber;

    /**
     * 试卷总分
     */
    private float totalScore;

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

    /** 录分老师*/
    private List<ExamPointInputSettingBO> teacherList;
    
	/** 任课老师*/
	private List<ExamPointInputSettingBO> courseTeacherList;

    private  List<ExamResultInfoBO> examResultInfoList;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 考试类别
     */
    private String type;
    
    /**
     * 考试类型代码
     */
    private String examTypeCode;

    /**
     * 学校标识
     */
    private String schoolId;

    /**
     * 老师标识
     */
    private String userId;

    /**
     * 学期标识
     */
    private String termId;
    
    private String termName;

    /**
     * 录分老师
     */
    private String teacherFullName;

    /**
     * 笔数
     */
    private Integer rows;
    /**
     * 当前页
     */
    private Integer offset;

    /**
     * 录分进度
     */
    private String progress;
    
    private Integer studentNumber;
    
    private String excludeTermId;
    
    private String schoolYear;
    
}
