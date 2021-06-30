package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.enableets.edu.enable.cloud.exam.framework.core.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author duffy_ding
 * @since 2020/05/28
 */
@ApiModel(value="QueryExamDetailsResultV2VO", description="I_50_01_04_111")
public class QueryExamDetailsResultV2VO {

	/** 考试明细标识 */
	@ApiModelProperty(value = "I_50_01_04_048")
	private String examDetailsId;

	/** 考试标识 */
	@ApiModelProperty(value = "I_50_01_10_010")
	private String examId;

	/** 年级编码 */
	@ApiModelProperty(value = "I_50_01_18_007")
	private String gradeCode;

	/** 年级名称 */
	@ApiModelProperty(value = "I_50_01_18_008")
	private String gradeName;

	/** 学科代码 */
	@ApiModelProperty(value = "I_50_01_04_059")
	private String subjectCode;

	/** 学科名称 */
	@ApiModelProperty(value = "I_50_01_04_060")
	private String subjectName;

	/** 课程标识 */
	@ApiModelProperty(value = "I_50_01_04_026")
	private String courseId;

	/** 课程名称 */
	@ApiModelProperty(value = "I_50_01_04_027")
	private String courseName;

	/** 文理科属性：理科;文科 */
	@ApiModelProperty(value = "I_50_01_04_028")
	private String courseAttribute;

	/** 考试时间 */
	@ApiModelProperty(value = "I_50_01_04_029")
	@JsonFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	@DateTimeFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	private Date examTime;

	/** 计划考试学生数 */
	@ApiModelProperty(value = "I_50_01_10_011")
	private Integer planStudentNumber;

	/** 实际考试学生数 */
	@ApiModelProperty(value = "I_50_01_04_061")
	private Integer actualStudentNumber;

	/** 试卷总分 */
	@ApiModelProperty(value = "I_50_01_04_050")
	private Float totalScore;

	@ApiModelProperty(value = "I_50_01_10_012")
    private ExamDetailsStepTaskInfoVO stepTaskInfo;

	@ApiModelProperty(value = "I_50_01_10_013")
    private List<ExamDetailsMarkAssigneeVO> markAssignees;

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

	public ExamDetailsStepTaskInfoVO getStepTaskInfo() {
		return stepTaskInfo;
	}

	public void setStepTaskInfo(ExamDetailsStepTaskInfoVO stepTaskInfo) {
		this.stepTaskInfo = stepTaskInfo;
	}

	public List<ExamDetailsMarkAssigneeVO> getMarkAssignees() {
		return markAssignees;
	}

	public void setMarkAssignees(List<ExamDetailsMarkAssigneeVO> markAssignees) {
		this.markAssignees = markAssignees;
	}
}
