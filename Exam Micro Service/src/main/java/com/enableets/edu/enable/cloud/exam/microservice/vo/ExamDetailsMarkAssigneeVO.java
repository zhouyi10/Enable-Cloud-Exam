package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamDetailsMarkAssigneeVO {
	
	/**
	 * 考试明细标识
	 */	
	@ApiModelProperty(value = "考试明细标识")
	private Long examDetailsId;

	/**
	 * 批阅者的userId
	 */	
	@ApiModelProperty(value = "批阅者的userId")
	private String userId;
	
	/**
	 * classId
	 */	
	@ApiModelProperty(value = "班级标识")
	private String classId;

	
	
	 /**
	 * @return the examDetailsId
	 */	
	public Long getExamDetailsId() {
		return examDetailsId;
	}
	
	 /**
	 * @param examDetailsId the examDetailsId to set
	 */	
	public void setExamDetailsId(Long examDetailsId) {
		this.examDetailsId = examDetailsId;
	}
	
	 /**
	 * @return the userId
	 */	
	public String getUserId() {
		return userId;
	}
	
	 /**
	 * @param userId the userId to set
	 */	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}


}
