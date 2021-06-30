package com.enableets.edu.enable.cloud.exam.microservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdNameMapVO", description = "id name键对")
public class IdNameMapVO {
	
	public IdNameMapVO(){}
	
	public IdNameMapVO(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	@ApiModelProperty(value = "标识")
	private String id;
	
	@ApiModelProperty(value = "名称")
	private String name;
	
	@ApiModelProperty(value = "学生人数")
	private String studentAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentAmount() {
		return studentAmount;
	}

	public void setStudentAmount(String studentAmount) {
		this.studentAmount = studentAmount;
	}
	
}
