package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.enableets.edu.enable.cloud.exam.framework.core.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 考试详情VO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddExamDetailsInfoV2VO {


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
	@DateTimeFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	@JsonFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
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
	@DateTimeFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	@JsonFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	private Date createTime;

	/**
	 * 修改者
	 */
	private String updator;

	/**
	 * 修改时间
	 */
	@DateTimeFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	@JsonFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
	private Date updateTime;
    
    private  ExamDetailsStepTaskInfoVO stepTaskInfo;

    
    private  List<ExamDetailsMarkAssigneeVO> markAssignees;

	/** assign question to be marked by special teacher */
	@ApiModelProperty(value = "the info of teachers who mark the questions")
	private List<AddQuestionMarkAssigneesVO> questionMarkAssignees;

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}


	public List<ExamDetailsMarkAssigneeVO> getMarkAssignees() {
		return markAssignees;
	}

	public void setMarkAssignees(List<ExamDetailsMarkAssigneeVO> markAssignees) {
		this.markAssignees = markAssignees;
	}

	public ExamDetailsStepTaskInfoVO getStepTaskInfo() {
		return stepTaskInfo;
	}

	public void setStepTaskInfo(ExamDetailsStepTaskInfoVO stepTaskInfo) {
		this.stepTaskInfo = stepTaskInfo;
	}

	public List<AddQuestionMarkAssigneesVO> getQuestionMarkAssignees() {
		return questionMarkAssignees;
	}

	public void setQuestionMarkAssignees(List<AddQuestionMarkAssigneesVO> questionMarkAssignees) {
		this.questionMarkAssignees = questionMarkAssignees;
	}
}
