package com.enableets.edu.enable.cloud.exam.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 分数等级模版PO
 */
@Entity
@Table(name="exam_level_template")
public class ExamLevelTemplatePO {

    /**
     * 分数等级名
     */
    @Id
    @Column(name = "level_name")
    private String levelName;

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

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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
