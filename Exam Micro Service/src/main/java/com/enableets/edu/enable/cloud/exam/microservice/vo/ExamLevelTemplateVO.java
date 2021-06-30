package com.enableets.edu.enable.cloud.exam.microservice.vo;


import com.enableets.edu.enable.cloud.exam.framework.core.BaseVO;
import com.enableets.edu.module.service.core.MicroServiceException;

/**
 * 考试等级模板VO
 */
public class ExamLevelTemplateVO extends BaseVO {

	@Override
	public void validate() throws MicroServiceException {
		this.validate(this.levelName, "levelName");
		this.validate(this.minPoint, "minPoint");
		this.validate(this.maxPoint, "maxPoint");
		this.validate(this.sequence, "sequence");

	}
	/** 等级名称*/	
	private String levelName;
	/** 最低分 */
	private Float minPoint;
	/** 最高分 */
	private Float maxPoint;
	/** 顺序 */
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
