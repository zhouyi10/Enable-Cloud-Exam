package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.enableets.edu.enable.cloud.exam.framework.core.BaseVO;
import com.enableets.edu.module.service.core.MicroServiceException;

/**
 * 录分老师信息表
 *
 * @author walle_yu@enable-ets.com
 * @since 2018/12/5
 */
public class ExamPointInputSettingVO extends BaseVO {

	@Override
	public void validate() throws MicroServiceException {
		this.validate(this.examDetailsId, "examDetailsId");
		this.validate(this.userId, "userId");
		this.validate(this.fullName, "fullName");
	}
	/** */
	private String examDetailsId;
	
	/** */
	private String userId;
	
	/** */
	private String fullName;

	public String getExamDetailsId() {
		return examDetailsId;
	}

	public void setExamDetailsId(String examDetailsId) {
		this.examDetailsId = examDetailsId;
	}

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
	
}
