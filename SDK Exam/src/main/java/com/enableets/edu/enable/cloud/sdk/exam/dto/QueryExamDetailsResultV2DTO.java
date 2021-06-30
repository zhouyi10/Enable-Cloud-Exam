package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 查询考试详情结果信息
 * @author duffy_ding
 * @since 2020/05/28
 */
public class QueryExamDetailsResultV2DTO {

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

	public String getExamDetailsId() {
		return examDetailsId;
	}

	public void setExamDetailsId(String examDetailsId) {
		this.examDetailsId = examDetailsId;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseAttribute() {
		return courseAttribute;
	}

	public void setCourseAttribute(String courseAttribute) {
		this.courseAttribute = courseAttribute;
	}

	public Date getExamTime() {
		return examTime;
	}

	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}

	public Integer getPlanStudentNumber() {
		return planStudentNumber;
	}

	public void setPlanStudentNumber(Integer planStudentNumber) {
		this.planStudentNumber = planStudentNumber;
	}

	public Integer getActualStudentNumber() {
		return actualStudentNumber;
	}

	public void setActualStudentNumber(Integer actualStudentNumber) {
		this.actualStudentNumber = actualStudentNumber;
	}

	public Float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}

	public ExamDetailsStepTaskInfoDTO getStepTaskInfo() {
		return stepTaskInfo;
	}

	public void setStepTaskInfo(ExamDetailsStepTaskInfoDTO stepTaskInfo) {
		this.stepTaskInfo = stepTaskInfo;
	}

	public List<ExamDetailsMarkAssigneeDTO> getMarkAssignees() {
		return markAssignees;
	}

	public void setMarkAssignees(List<ExamDetailsMarkAssigneeDTO> markAssignees) {
		this.markAssignees = markAssignees;
	}
}
