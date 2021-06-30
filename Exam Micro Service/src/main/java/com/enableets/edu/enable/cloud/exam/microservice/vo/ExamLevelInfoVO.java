package com.enableets.edu.enable.cloud.exam.microservice.vo;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 分数等级VO
 */
public class ExamLevelInfoVO {

    /**
     * 等级标识
     */

    private Integer levelId;

    /**
     * 等级名称
     */
    private String levelName;

    /**
     * 学校标识
     */
    private String schoolId;

    /**
     * 学校编码
     */
    private String schoolCode;

    /**
     * 年级编码
     */
    private String gradeCode;

    /**
     * 最低分
     */
    private Float minPoint;

    /**
     * 最高分
     */
    private Float maxPoint;

    /**
     * 顺序
     */
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
