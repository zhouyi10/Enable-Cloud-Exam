package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryExamResultInfoResultDTO {

	/**
	 * 考试记录标识
	 */
	private String examDetailsId;

	/**
	 * 学生标识
	 */
	private String studentUserId;

	/**
	 * 学生姓名
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
	 * 参考情况
	 */
	private String status;

	/**
	 * 录分老师标识
	 */
	private String teacherUserId;

	/**
	 * 录分老师名称
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

	/**
	* 创建者
	*/
	private String creator;

	/**
	* 创建时间
	*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	/**
	* 更新者
	*/
	private String updator;

	/**
	* 更新时间
	*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	/**
	 * 资源标识
	 */
	private String contentId;

	private List<FileInfoDTO> files;

	private String subjectCode;

	private String subjectName;

	private String courseId;

	private String courseName;

	private String gradeCode;

	private String classId;

	private String className;

	/**
	 * 试卷总分
	 */
	private Float totalScore;

	private String typeCode;

	private String type;

	private String examName;

	private String termName;

	private String examId;

	private String termId;
	
	/**
	 * 是否显示考试名称
	 */
	private String isShowTitle;

	private String avgScore;

	public List<FileInfoDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileInfoDTO> files) {
		this.files = files;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	public String getIsShowTitle() {
		return isShowTitle;
	}

	public void setIsShowTitle(String isShowTitle) {
		this.isShowTitle = isShowTitle;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public Float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getExamDetailsId() {
		return examDetailsId;
	}

	public void setExamDetailsId(String examDetailsId) {
		this.examDetailsId = examDetailsId;
	}

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeacherUserId() {
		return teacherUserId;
	}

	public void setTeacherUserId(String teacherUserId) {
		this.teacherUserId = teacherUserId;
	}

	public String getStudentFullName() {
		return studentFullName;
	}

	public void setStudentFullName(String studentFullName) {
		this.studentFullName = studentFullName;
	}

	public String getTeacherFullName() {
		return teacherFullName;
	}

	public void setTeacherFullName(String teacherFullName) {
		this.teacherFullName = teacherFullName;
	}

	public Float getaPoint() {
		return aPoint;
	}

	public void setaPoint(Float aPoint) {
		this.aPoint = aPoint;
	}

	public Float getbPoint() {
		return bPoint;
	}

	public void setbPoint(Float bPoint) {
		this.bPoint = bPoint;
	}

	public Float getAdditionalPoint() {
		return additionalPoint;
	}

	public void setAdditionalPoint(Float additionalPoint) {
		this.additionalPoint = additionalPoint;
	}

	public Float getStandardPoint() {
		return standardPoint;
	}

	public void setStandardPoint(Float standardPoint) {
		this.standardPoint = standardPoint;
	}

	public Float getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Float totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	
}
