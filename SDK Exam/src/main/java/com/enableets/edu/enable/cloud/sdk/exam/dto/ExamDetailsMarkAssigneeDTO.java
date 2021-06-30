package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
@Data
@Accessors(chain = true)
public class ExamDetailsMarkAssigneeDTO {
	
	/**
	 * 考试明细标识
	 */	
	private Long examDetailsId;
	
	/**
	 * classId
	 */	
	private String classId;

	/**
	 * 批阅者的userId
	 */	
	private String userId;

	/**
	 * 创建者
	 */	
	private String creator;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;

	/**
	 * 修改者
	 */	
	private String updator;

	/**
	 * 修改时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;

}
