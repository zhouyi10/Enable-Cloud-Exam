package com.enableets.edu.enable.cloud.exam.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
@Entity
@Table(name = "exam_details_mark_assignee")
public class ExamDetailsMarkAssigneePO {
	
	/**
	 * 考试明细标识
	 */	
	@Id
	@Column(name="exam_details_id")
	private Long examDetailsId;

	/**
	 * 批阅者的userId
	 */	
	@Id
	@Column(name="user_id")
	private String userId;

	/**
	 * 创建者
	 */	
	@Column(name="creator")
	private String creator;

	/**
	 * 创建时间
	 */	
	@Column(name="create_time")
	private java.util.Date createTime;

	/**
	 * 修改者
	 */	
	@Column(name="updator")
	private String updator;

	/**
	 * 修改时间
	 */	
	@Column(name="update_time")
	private java.util.Date updateTime;

	
	
	 /**
	 * @return the examDetailsId
	 */	
	public Long getExamDetailsId() {
		return examDetailsId;
	}
	
	 /**
	 * @param examDetailsId the examDetailsId to set
	 */	
	public void setExamDetailsId(Long examDetailsId) {
		this.examDetailsId = examDetailsId;
	}
	
	 /**
	 * @return the userId
	 */	
	public String getUserId() {
		return userId;
	}
	
	 /**
	 * @param userId the userId to set
	 */	
	public void setUserId(String userId) {
		this.userId = userId;
	}


	 /**
	 * @return the creator
	 */		
	public String getCreator() {
		return creator;
	}
	
	 /**
	 * @param creator the creator to set
	 */	
	public void setCreator(String creator) {
		this.creator = creator;
	}

	 /**
	 * @return the createTime
	 */		
	public java.util.Date getCreateTime() {
		return createTime;
	}
	
	 /**
	 * @param createTime the createTime to set
	 */	
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	 /**
	 * @return the updator
	 */		
	public String getUpdator() {
		return updator;
	}
	
	 /**
	 * @param updator the updator to set
	 */	
	public void setUpdator(String updator) {
		this.updator = updator;
	}

	 /**
	 * @return the updateTime
	 */		
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	
	 /**
	 * @param updateTime the updateTime to set
	 */	
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

}
