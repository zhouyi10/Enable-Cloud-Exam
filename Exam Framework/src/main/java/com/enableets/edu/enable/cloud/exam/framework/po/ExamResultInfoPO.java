package com.enableets.edu.enable.cloud.exam.framework.po;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="exam_result_info")
public class ExamResultInfoPO {

    /**
     * 考试明细标识
     */
    @Id
    @Column(name = "exam_details_id")
    private Long examDetailsId;

    /**
     * 学生标识
     */
    @Id
    @Column(name = "student_user_id")
    private String studentUserId;

    /**
     * 学生名称
     */
    @Column(name = "student_full_name")
    private String studentFullName;

    /**
     * 学籍号
     */
    @Column(name = "student_code")
    private String studentCode;

    /**
     * 学号(座位号)
     */
    @Column(name = "student_no")
    private String studentNo;

    /**
     * 1 正常 2缺考 3违纪 4补考
     */
    @Column(name = "status")
    private String status;

    /**
     * 录分教师标识
     */
    @Column(name = "teacher_user_id")
    private String teacherUserId;

    /**
     * 录分教师名称
     */
    @Column(name = "teacher_full_name")
    private String teacherFullName;

    /**
     * A卷分
     */
    @Column(name = "a_point")
    private Float aPoint;

    /**
     * B卷分
     */
    @Column(name = "b_point")
    private Float bPoint;

    /**
     * 附加分
     */
    @Column(name = "additional_point")
    private Float additionalPoint;

    /**
     * 标准分
     */
    @Column(name = "standard_point")
    private Float standardPoint;

    /**
     * 总分
     */
    @Column(name = "total_point")
    private Float totalPoint;

    /**
     * 分数等级
     */
    @Column(name = "level")
    private String level;

    /**
     * 评语
     */
    @Column(name = "comment")
    private String comment;

    @Column(name = "content_id")
    private String contentId;
    
    @Column(name = "creator")
    private String creator;
    
    @Column(name = "create_time")
    private java.util.Date createTime;
    
    @Column(name = "updator")
    private String updator;
    
    @Column(name = "update_time")
    private java.util.Date updateTime;

    @Transient
    private String subjectCode;
    
    @Transient
    private String subjectName;
    
    @Transient
    private String courseId;

    @Transient
    private String courseName;

    @Transient
    private String classId;
    
    @Transient
    private String gradeCode;

    @Transient
    private String examId;

    @Transient
    private String termId;
    
    /**
     * 试卷总分
     */
    @Transient
    private Float totalScore;

    @Transient
    private String typeCode;
    
    @Transient
    private String type;

    @Transient
    private String examName;

    @Transient
    private String termName;

    @Transient
    private String avgScore;

    public Long getExamDetailsId() {
        return examDetailsId;
    }

    public void setExamDetailsId(Long examDetailsId) {
        this.examDetailsId = examDetailsId;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
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

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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

    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }
}
