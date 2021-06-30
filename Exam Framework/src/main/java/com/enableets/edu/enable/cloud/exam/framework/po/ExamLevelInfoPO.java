package com.enableets.edu.enable.cloud.exam.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 分数等级PO
 */
@Entity
@Table(name="exam_level_info")
public class ExamLevelInfoPO {

    /**
     * 等级标识
     */
    @Id
    @Column(name = "level_id")
    private Integer levelId;

    /**
     * 等级名称
     */
    @Column(name = "level_name")
    private String levelName;

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
     * 年级编码
     */
    @Column(name = "grade_code")
    private String gradeCode;

    /**
     * 最低分
     */
    @Column(name = "min_point")
    private Float minPoint;

    /**
     * 最高分
     */
    @Column(name = "max_point")
    private Float maxPoint;

    /**
     * 顺序
     */
    @Column(name = "sequence")
    private Integer sequence;

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public Float getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Float minPoint) {
        this.minPoint = minPoint;
    }

    public Float getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Float maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
