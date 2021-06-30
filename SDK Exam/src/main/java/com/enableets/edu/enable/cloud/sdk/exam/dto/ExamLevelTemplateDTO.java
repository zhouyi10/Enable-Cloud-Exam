package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class ExamLevelTemplateDTO {
	
	/** 等级名称*/	
	private String levelName;
	/** 最低分 */
	private Float minPoint;
	/** 最高分 */
	private Float maxPoint;
	/** 顺序 */
	private Integer sequence;

}
