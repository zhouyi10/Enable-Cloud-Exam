package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class IdNameMapDTO {
	
	public IdNameMapDTO() {
	}
	
	public IdNameMapDTO(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	private String id;
	
	private String name;

	
	private String studentAmount;

	
}
