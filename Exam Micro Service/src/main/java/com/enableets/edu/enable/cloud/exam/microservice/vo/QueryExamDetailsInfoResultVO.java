package com.enableets.edu.enable.cloud.exam.microservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 查询考试详情
 *
 * @author walle_yu@enable-ets.com
 * @since 2018/12/5
 */
@ApiModel(value="QueryExamDetailsInfoResultVO", description="查询考试详情")
public class QueryExamDetailsInfoResultVO {


	/** 考试详情标识*/
	@ApiModelProperty(value="考试详情标识")
	private String examDetailsId;

	/** 考试标识*/
	@ApiModelProperty(value="考试标识")
	private String examId;
	
	/** 年级编码*/
	@ApiModelProperty(value="年级编码")
	private String gradeCode;
	
	/** 年级名称*/
	@ApiModelProperty(value="年级名称")
	private String gradeName;
	
	/** 班级标识*/
	@ApiModelProperty(value="群组标识")
	private String classId;
	
	/** 班级名称*/
	@ApiModelProperty(value="群组名称")
	private String className;
	
	/** 科目编码*/
	@ApiModelProperty(value="科目编码")
	private String subjectCode;
	
	/** 科目名称*/
	@ApiModelProperty(value="科目名称")
	private String subjectName;

	/** 课程标识 */
	@ApiModelProperty(value = "课程标识")
	private String courseId;

	/** 课程名称 */
	@ApiModelProperty(value = "课程名称")
	private String courseName;

	/** */
	@ApiModelProperty(value = "文理科属性：理科;文科")
	private String courseAttribute;
	
	/** 考试时间*/
	@ApiModelProperty(value="考试时间")
	private Date examTime;
	
	/** 计划参加考试人数*/
	@ApiModelProperty(value="计划参加考试人数")
	private Integer planStudentNumber;
	
	/** 实际参加考试人数*/
	@ApiModelProperty(value="实际参加考试人数")
	private Integer actualStudentNumber;
	
	/** 实际参加考试人数*/
	@ApiModelProperty(value="总分")
	private Float totalScore;
	
	@ApiModelProperty(value="录分老师")
	private List<QueryExamPointInputSettingResultVO> teacherList;

	/**
	 * 考试名称
	 */
	@ApiModelProperty(value="考试名称")
	private String name;
	/**
	 * 考试类型
	 */
	@ApiModelProperty(value="考试类型")
	private String type;

	@ApiModelProperty(value="学校标识")
	private String schoolId;

	@ApiModelProperty(value="学期标识")
	private String termId;
	
	@ApiModelProperty(value="学期名称")
	private String termName;
	
	/**
	 * 录分进度
	 */
	@ApiModelProperty(value="录分进度")
	private String progress;
	/**
	 * 录分老师
	 */
	@ApiModelProperty(value="录分老师名称")
	private String teacherFullName;

	/**
	 * 录分老师标识
	 */
	@ApiModelProperty(value="录分老师标识")
	private String userId;

	@ApiModelProperty(value="考试成绩")
	private  List<ExamResultInfoVO> examResultInfoList;
	
	@ApiModelProperty(value="学生人数")
	private Integer studentNumber;
	
	@ApiModelProperty(value="当前学期标识")
	private String excludeTermId;
	
	@ApiModelProperty(value="学年")
	private String schoolYear;

	@ApiModelProperty(value="创建者")
	private String creator;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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

	public List<QueryExamPointInputSettingResultVO> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<QueryExamPointInputSettingResultVO> teacherList) {
		this.teacherList = teacherList;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public List<ExamResultInfoVO> getExamResultInfoList() {
		return examResultInfoList;
	}

	public void setExamResultInfoList(List<ExamResultInfoVO> examResultInfoList) {
		this.examResultInfoList = examResultInfoList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getTeacherFullName() {
		return teacherFullName;
	}

	public void setTeacherFullName(String teacherFullName) {
		this.teacherFullName = teacherFullName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getExcludeTermId() {
		return excludeTermId;
	}

	public void setExcludeTermId(String excludeTermId) {
		this.excludeTermId = excludeTermId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	/**
	 * @return the totalScore
	 */
	public Float getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}
	
}
