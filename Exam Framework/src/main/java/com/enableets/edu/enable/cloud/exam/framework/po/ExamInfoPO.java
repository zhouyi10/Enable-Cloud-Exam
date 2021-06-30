package com.enableets.edu.enable.cloud.exam.framework.po;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam_info")
public class ExamInfoPO {

    /**
     * 考试标识
     */
    @Id
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 考试名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 考试类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 考试类型名称
     */
    @Transient
    private String typeName;

    /**
     * 计划考试学生数
     */
    @Column(name = "plan_student_number")
    private Integer planStudentNumber;

    /**
     * 实际考试学生数
     */
    @Column(name = "actual_student_number")
    private Integer actualStudentNumber;

    /**
     * 学校标识
     */
    @Column(name = "school_id")
    private String schoolId;

    /**
     * 学校编码
     */
    @Column(name = "school_code")
    private String schoolCode;

    /**
     * 学年
     */
    @Column(name = "school_year")
    private String schoolYear;

    /**
     * 学期标识
     */
    @Column(name = "term_id")
    private String termId;

    /**
     * 学期名称
     */
    @Column(name = "term_name")
    private String termName;

    /**
     * 哪一届的学生参考
     */
    @Column(name = "graduate_num")
    private String graduateNum;

    /**
     * 学段
     */
    @Column(name = "grade_stage")
    private String gradeStage;

    @Column(name = "grade_code")
    private String gradeCode;

    @Column(name = "grade_name")
    private String gradeName;

    /**
     * exam publish status, default 0, if all details is published, it's 1, else 2
     */
    @Column(name = "publish_status")
    private String publishStatus;

    /**
     * 创建者
     */
    @Column(name = "creator")
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
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
     * 考试详情
     */
    @Transient
    private List<ExamDetailsInfoPO> details;

    @Transient
    private String classId;

    @Transient
    private String className;

    @Transient
    private String progress;

    /**
     * 考试类型代码
     */
    @Transient
    private String examTypeCode;

    /**
     * 年级编码
     */
    ///@Transient
    //private String gradeCode;

    /**
     * 科目编码
     */
    //@Transient
    //private String gradeName;

    @Transient
    private Integer studentNumber;

    @Transient
    private Integer count;

    /**
     * 学生标识
     */
    @Transient
    private String studentUserId;

    /**
     * 学生姓名
     */
    @Transient
    private String studentFullName;

    /**
     * 评语
     */
    @Transient
    private String comment;

    /**
     * 注意事项
     */
    @Transient
    private String attentionContext;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
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

    public String getGraduateNum() {
        return graduateNum;
    }

    public void setGraduateNum(String graduateNum) {
        this.graduateNum = graduateNum;
    }

    public String getGradeStage() {
        return gradeStage;
    }

    public void setGradeStage(String gradeStage) {
        this.gradeStage = gradeStage;
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

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
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

    public List<ExamDetailsInfoPO> getDetails() {
        return details;
    }

    public void setDetails(List<ExamDetailsInfoPO> details) {
        this.details = details;
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

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getExamTypeCode() {
        return examTypeCode;
    }

    public void setExamTypeCode(String examTypeCode) {
        this.examTypeCode = examTypeCode;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(String studentUserId) {
        this.studentUserId = studentUserId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttentionContext() {
        return attentionContext;
    }

    public void setAttentionContext(String attentionContext) {
        this.attentionContext = attentionContext;
    }
}
