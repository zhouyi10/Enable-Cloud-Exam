package com.enableets.edu.enable.cloud.exam.framework.po;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: bruce_li@enable-ets.com
 * @Date: 2020/9/18
 * @Description: 考试明细PO
 */
@Entity
@Table(name="exam_details_info")
public class ExamStatisticsInfoPO implements Serializable {

    /**
     * 总分
     */
    @Column(name = "total_score")
    private Float totalScore;

    /**
     * 考试明细标识
     */
    @Id
    @Column(name = "exam_details_id")
    private Long examDetailsId;

    /**
     * 考试标识
     */
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 年级编码
     */
    @Transient
    private String gradeCode;

    /**
     * 年级名称
     */
    @Transient
    private String gradeName;

    /**
     * 学期名称
     */
    @Transient
    private String termName;

    /**
     * 考试类别
     */
    @Transient
    private String name;

    /**
     * 班级标识
     */
    @Column(name = "class_id")
    private String classId;

    /**
     * 班级名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 学科代码
     */
    @Column(name = "subject_code")
    private String subjectCode;

    /**
     * 学科名称
     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * 课程标识
     */
    @Column(name = "course_id")
    private String courseId;

    /**
     * 课程名称
     */
    @Column(name = "course_name")
    private String courseName;

    /**
     * 创建者
     */
    @Column(name = "creator")
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 修改者
     */
    @Column(name = "updator")
    private String updator;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 学校id
     */
    @Transient
    private String schoolId;

    /**
     * 学期id
     */
    @Transient
    private String termId;

    @Transient
    private ExamDetailsStepTaskInfoPO stepTaskInfo;

    /**
     * 发布状态  0未发布  1已发布
     */
    @Transient
    private String publishStatus;

    /**
     * 考试类别
     */
    @Transient
    private String typeName;

    /**
     * 考试类型
     */
    @Transient
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

    public ExamDetailsStepTaskInfoPO getStepTaskInfo() {
        return stepTaskInfo;
    }

    public void setStepTaskInfo(ExamDetailsStepTaskInfoPO stepTaskInfo) {
        this.stepTaskInfo = stepTaskInfo;
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
