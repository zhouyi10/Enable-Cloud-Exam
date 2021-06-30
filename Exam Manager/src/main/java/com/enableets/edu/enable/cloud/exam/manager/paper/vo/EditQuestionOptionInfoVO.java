package com.enableets.edu.enable.cloud.exam.manager.paper.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 题目选项信息vo
 * @author duffy_ding
 * @since 2017/12/29
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditQuestionOptionInfoVO {
	
	/** 选项标识*/
	private String optionId;
	
	/** 选项标题  */
	private String alias;
	
	/** 选项内容  */
	private String lable;
	
	/** 选项排序  */
	private String sequencing;

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getSequencing() {
		return sequencing;
	}

	public void setSequencing(String sequencing) {
		this.sequencing = sequencing;
	}
}
