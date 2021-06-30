package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 录分老师信息
 *
 * @author walle_yu@enable-ets.com
 * @since 2018/12/5
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryExamPointInputSettingResultDTO {
	
	/** */
	private Long examDetailsId;
	
	/** */
	private String userId;
	
	/** */
	private String fullName;
	
}
