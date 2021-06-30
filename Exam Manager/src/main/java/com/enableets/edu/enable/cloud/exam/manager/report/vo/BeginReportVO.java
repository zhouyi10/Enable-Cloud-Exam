package com.enableets.edu.enable.cloud.exam.manager.report.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author justice_zhou@enable-ets.com
 * @date 2021/6/22
 **/


public class BeginReportVO {

    /**
     * termId
     */
    private String termId;

    /**
     * gradeId
     */
    private String gradeId;

    /**
     * subjectId
     */
    private String subjectId;

    /**
     * testType
     */
    private String testType;

    /**
     * offset
     */
    private Integer offset;

    /**
     * rows
     */
    private Integer rows;

    public BeginReportVO() {
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
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
}