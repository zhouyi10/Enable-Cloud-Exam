package com.enableets.edu.enable.cloud.sdk.exam.dto;

import java.io.Serializable;
import java.util.List;


public class QueryExamInfoResultV2DTO implements Serializable {

	/**
     * 考试标识
     */
    private String examId;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 考试类型
     */
    private String type;

    /**
     * 考试类型
     */
    private String typeName;

    /**
     * 学校标识
     */
    private String schoolId;

    /**
     * 学校编码
     */
    private String schoolCode;

    /**
     * 学年
     */
    private String schoolYear;

	/**
	 * 不包含的学期标识
	 */
	private String excludeTermId;

    /**
     * 学期标识
     */
    private String termId;

    /**
     * 学期名称
     */
    private String termName;

    /**
     * 学段
     */
    private String gradeStage;

    private String gradeCode;

    private String gradeName;

    /** exam publish status, default 0, if all details is published, it's 1, else 2 */
    private String publishStatus;

    /** 创建者*/
    private String creator;

    /**
     * 班级
     */
    private List<IdNameMapDTO> classes;

    private List<QueryExamDetailsResultV2DTO> details;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
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

    public String getExcludeTermId() {
        return excludeTermId;
    }

    public void setExcludeTermId(String excludeTermId) {
        this.excludeTermId = excludeTermId;
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

    public List<IdNameMapDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<IdNameMapDTO> classes) {
        this.classes = classes;
    }

    public List<QueryExamDetailsResultV2DTO> getDetails() {
        return details;
    }

    public void setDetails(List<QueryExamDetailsResultV2DTO> details) {
        this.details = details;
    }
}
