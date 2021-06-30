package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 查询考试详情结果信息
 * @author duffy_ding
 * @since 2020/05/28
 */
@Data
@Accessors(chain = true)
public class QueryExamDetailsResultDTO {

	/** 考试明细标识 */
	private String examDetailsId;

	/**
	 * 考试标识
	 */
	private String examId;

	/**
	 * 年级编码
	 */
	private String gradeCode;

	/**
	 * 年级名称
	 */
	private String gradeName;


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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    
    private ExamDetailsStepTaskInfoDTO stepTaskInfo;

    private List<ExamDetailsMarkAssigneeDTO> markAssignees;

}
