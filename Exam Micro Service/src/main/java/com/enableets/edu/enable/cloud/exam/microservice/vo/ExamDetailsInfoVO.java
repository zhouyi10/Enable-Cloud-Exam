package com.enableets.edu.enable.cloud.exam.microservice.vo;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 考试明细VO
 *
 */
public class ExamDetailsInfoVO {

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

    private float totalScore;

    /**
     * 计划考试学生数
     */
    private Integer planStudentNumber;

    /**
     * 实际考试学生数
     */
    private Integer actualStudentNumber;

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

    private List<ExamPointInputSettingVO> teacherList;

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public Long getExamDetailsId() {
        return examDetailsId;
    }

    public void setExamDetailsId(Long examDetailsId) {
        this.examDetailsId = examDetailsId;
    }

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

    public List<ExamPointInputSettingVO> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<ExamPointInputSettingVO> teacherList) {
        this.teacherList = teacherList;
    }
}
