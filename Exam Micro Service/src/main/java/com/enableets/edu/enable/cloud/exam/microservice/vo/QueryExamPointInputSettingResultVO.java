package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.enableets.edu.enable.cloud.exam.framework.core.BaseVO;
import com.enableets.edu.module.service.core.MicroServiceException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 录分老师信息
 *
 * @author walle_yu@enable-ets.com
 * @since 2018/12/5
 */
@ApiModel(value="QueryExamPointInputSettingVO", description="录分老师信息")
public class QueryExamPointInputSettingResultVO extends BaseVO {

	@Override
	public void validate() throws MicroServiceException {
		this.validate(this.examDetailsId, "examDetailsId");
		this.validate(this.userId, "userId");
		this.validate(this.fullName, "fullName");
	}
	/** 考试详情标识 */
	@ApiModelProperty(value = "考试详情标识")
	private String examDetailsId;
	
	/** 用户标识*/
	@ApiModelProperty(value = "用户标识")
	private String userId;
	
	/** 用户名称*/
	@ApiModelProperty(value = "用户名称")
	private String fullName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getExamDetailsId() {
		return examDetailsId;
	}

	public void setExamDetailsId(String examDetailsId) {
		this.examDetailsId = examDetailsId;
	}
	
}
