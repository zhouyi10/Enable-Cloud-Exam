package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
@Data
@Accessors(chain = true)
public class ExamDetailsMarkAssigneeBO {
	
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
	private java.util.Date createTime;

	/**
	 * 修改者
	 */	
	private String updator;

	/**
	 * 修改时间
	 */	
	private java.util.Date updateTime;

}
