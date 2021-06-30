package com.enableets.edu.enable.cloud.exam.manager.paper.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公用map对象(只含有id和name字段)
 * @author walle_yu@enable-ets.com
 * @since 2018年3月13日
 */
@ApiModel(value = "IdNameMap", description = "标识-名字 对象")
public class IdNameMapVO {
	
	/** 标识  */
	@ApiModelProperty(value = "标识", required = false)
	private String id;
	
	/** 名称  */
	@ApiModelProperty(value = "名称", required = false)
	private String name;
	
	public IdNameMapVO() {
		
	}

	public IdNameMapVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

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
	
}
