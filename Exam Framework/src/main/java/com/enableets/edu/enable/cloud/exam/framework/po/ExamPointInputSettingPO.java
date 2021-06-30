package com.enableets.edu.enable.cloud.exam.framework.po;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 录分老师安排PO
 */
@Entity
@Table(name="exam_point_input_setting")
public class ExamPointInputSettingPO {

    /**
     * 考试明细标识
     */
    //@Id
    @Column(name = "exam_details_id")
    private Long examDetailsId;

    /**
     * 老师标识
     */
    //@Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 老师名称
     */
    @Column(name = "full_name")
    private String fullName;
    
    
    @Transient
    private String classId;
    
    @Transient
    private String className;
    
    
    @Transient
    private String gradeCode;

    public Long getExamDetailsId() {
        return examDetailsId;
    }

    public void setExamDetailsId(Long examDetailsId) {
        this.examDetailsId = examDetailsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }
}
