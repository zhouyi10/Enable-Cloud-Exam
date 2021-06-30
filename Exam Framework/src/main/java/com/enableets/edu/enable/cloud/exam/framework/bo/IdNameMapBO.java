package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class IdNameMapBO {
	
	public IdNameMapBO() {
	}
	
	public IdNameMapBO(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	private String id;
	
	private String name;
	
	private String studentAmount;
	
}
