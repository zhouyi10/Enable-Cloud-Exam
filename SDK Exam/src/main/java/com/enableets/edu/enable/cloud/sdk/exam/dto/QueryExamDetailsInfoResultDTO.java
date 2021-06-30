package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;


/**
 * 查询考试详情
 *
 * @author walle_yu@enable-ets.com
 * @since 2018/12/5
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class QueryExamDetailsInfoResultDTO {

	/** 考试详情标识*/
	private Long examDetailsId;

	/** 考试标识*/
	private Long examId;
	
	/** 年级编码*/
	private String gradeCode;
	
	/** 年级名称*/
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
    private Float totalScore;
	
	private List<QueryExamPointInputSettingResultDTO> teacherList;

	/**
	 * 考试名称
	 */
	private String name;
	/**
	 * 考试类型
	 */
	private String type;

	private String schoolId;

	/**
	 * 录分进度
	 */
	private String progress;
	/**
	 * 录分老师
	 */
	private String teacherFullName;

	/**
	 * 录分老师标识
	 */
	private String userId;
	
	/**
	 * 学期标识
	 */
	private String termId;
	
	private String termName;
	
	private Integer studentNumber;
	
	private List<QueryExamResultInfoResultDTO> examResultInfoList;
	
	private String excludeTermId;
	
	private String schoolYear;
	
	/**
	 * 考试类型代码
	 */
	private String examTypeCode;

	private String creator;

}
