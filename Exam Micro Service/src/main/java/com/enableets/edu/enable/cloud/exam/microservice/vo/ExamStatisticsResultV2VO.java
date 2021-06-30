package com.enableets.edu.enable.cloud.exam.microservice.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 查询考试详情结果信息
 * @author bruce_li@enable-ets.com
 * @since 2020/9/18
 */
public class ExamStatisticsResultV2VO {

    /**
     * 总分
     */
    private Float totalScore;

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
     * 学期名称
     */
    private String termName;

    /**
     * 考试类别
     */
    private String name;

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

    /**
     * 学校id
     */
    private String schoolId;

    /**
     * 学期id
     */
    private String termId;

    @ApiModelProperty(value = "任务信息")
    private ExamDetailsStepTaskInfoVO stepTaskInfo;

    private Integer offset;

    private Integer rows;

    /**
     * 发布状态  0未发布  1已发布
     */
    private String publishStatus;

    /**
     * 考试类别
     */
    private String typeName;

    /**
     * 考试类型
     */
    private String type;

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
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

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public ExamDetailsStepTaskInfoVO getStepTaskInfo() {
        return stepTaskInfo;
    }

    public void setStepTaskInfo(ExamDetailsStepTaskInfoVO stepTaskInfo) {
        this.stepTaskInfo = stepTaskInfo;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
