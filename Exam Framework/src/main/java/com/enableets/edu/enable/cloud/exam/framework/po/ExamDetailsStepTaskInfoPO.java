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
@Table(name = "exam_details_step_task_info")
public class ExamDetailsStepTaskInfoPO {
	
	/**
	 * 考试详情标识
	 */	
	@Id
	@Column(name="exam_details_id")
	private Long examDetailsId;

	/**
	 * 考试发布后，考试详情对应的打卡任务的标识
	 */	
	@Column(name="activity_id")
	private String activityId;

	/**
	 * 试卷信息，json串
	 */	
	@Column(name="content_info")
	private String contentInfo;

	/**
	 * 0:指定时间发布 1：立即发布
	 */	
	@Column(name="publish_now")
	private String publishNow;

	/**
	 * 发布时间
	 */	
	@Column(name="publish_time")
	private java.util.Date publishTime;

	/**
	 * 状态 0:未派卷 1：已派卷 
	 */	
	@Column(name="status")
	private String status;

	/**
	 * 试卷下载时间，提前下载分钟数
	 */	
	@Column(name="download_in_advance_minutes")
	private Long downloadInAdvanceMinutes;

	/**
	 * 考试时长
	 */	
	@Column(name="minutes_of_exam")
	private Long minutesOfExam;

	/**
	 * 答卷开始时间
	 */	
	@Column(name="answer_start_time")
	private java.util.Date answerStartTime;

	/**
	 * 答卷结束时间
	 */	
	@Column(name="answer_end_time")
	private java.util.Date answerEndTime;

	/**
	 * 答卷后多少分钟可以交卷
	 */	
	@Column(name="minutes_after_the_start_to_hand_in")
	private Long minutesAfterTheStartToHandIn;

	/**
	 * 交卷结束时间
	 */	
	@Column(name="hand_in_end_time")
	private java.util.Date handInEndTime;

	/**
	 * 阅卷开始时间
	 */	
	@Column(name="mark_start_time")
	private java.util.Date markStartTime;

	/**
	 * 阅卷结束时间
	 */	
	@Column(name="mark_end_time")
	private java.util.Date markEndTime;

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
	 * @return the activityId
	 */		
	public String getActivityId() {
		return activityId;
	}
	
	 /**
	 * @param activityId the activityId to set
	 */	
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	 /**
	 * @return the contentInfo
	 */		
	public String getContentInfo() {
		return contentInfo;
	}
	
	 /**
	 * @param contentInfo the contentInfo to set
	 */	
	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}

	 /**
	 * @return the publishNow
	 */		
	public String getPublishNow() {
		return publishNow;
	}
	
	 /**
	 * @param publishNow the publishNow to set
	 */	
	public void setPublishNow(String publishNow) {
		this.publishNow = publishNow;
	}

	 /**
	 * @return the publishTime
	 */		
	public java.util.Date getPublishTime() {
		return publishTime;
	}
	
	 /**
	 * @param publishTime the publishTime to set
	 */	
	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}

	 /**
	 * @return the status
	 */		
	public String getStatus() {
		return status;
	}
	
	 /**
	 * @param status the status to set
	 */	
	public void setStatus(String status) {
		this.status = status;
	}

	 /**
	 * @return the downloadInAdvanceMinutes
	 */		
	public Long getDownloadInAdvanceMinutes() {
		return downloadInAdvanceMinutes;
	}
	
	 /**
	 * @param downloadInAdvanceMinutes the downloadInAdvanceMinutes to set
	 */	
	public void setDownloadInAdvanceMinutes(Long downloadInAdvanceMinutes) {
		this.downloadInAdvanceMinutes = downloadInAdvanceMinutes;
	}

	 /**
	 * @return the minutesOfExam
	 */		
	public Long getMinutesOfExam() {
		return minutesOfExam;
	}
	
	 /**
	 * @param minutesOfExam the minutesOfExam to set
	 */	
	public void setMinutesOfExam(Long minutesOfExam) {
		this.minutesOfExam = minutesOfExam;
	}

	 /**
	 * @return the answerStartTime
	 */		
	public java.util.Date getAnswerStartTime() {
		return answerStartTime;
	}
	
	 /**
	 * @param answerStartTime the answerStartTime to set
	 */	
	public void setAnswerStartTime(java.util.Date answerStartTime) {
		this.answerStartTime = answerStartTime;
	}

	 /**
	 * @return the answerEndTime
	 */		
	public java.util.Date getAnswerEndTime() {
		return answerEndTime;
	}
	
	 /**
	 * @param answerEndTime the answerEndTime to set
	 */	
	public void setAnswerEndTime(java.util.Date answerEndTime) {
		this.answerEndTime = answerEndTime;
	}

	 /**
	 * @return the minutesAfterTheStartToHandIn
	 */		
	public Long getMinutesAfterTheStartToHandIn() {
		return minutesAfterTheStartToHandIn;
	}
	
	 /**
	 * @param minutesAfterTheStartToHandIn the minutesAfterTheStartToHandIn to set
	 */	
	public void setMinutesAfterTheStartToHandIn(Long minutesAfterTheStartToHandIn) {
		this.minutesAfterTheStartToHandIn = minutesAfterTheStartToHandIn;
	}

	 /**
	 * @return the handInEndTime
	 */		
	public java.util.Date getHandInEndTime() {
		return handInEndTime;
	}
	
	 /**
	 * @param handInEndTime the handInEndTime to set
	 */	
	public void setHandInEndTime(java.util.Date handInEndTime) {
		this.handInEndTime = handInEndTime;
	}

	 /**
	 * @return the markStartTime
	 */		
	public java.util.Date getMarkStartTime() {
		return markStartTime;
	}
	
	 /**
	 * @param markStartTime the markStartTime to set
	 */	
	public void setMarkStartTime(java.util.Date markStartTime) {
		this.markStartTime = markStartTime;
	}

	 /**
	 * @return the markEndTime
	 */		
	public java.util.Date getMarkEndTime() {
		return markEndTime;
	}
	
	 /**
	 * @param markEndTime the markEndTime to set
	 */	
	public void setMarkEndTime(java.util.Date markEndTime) {
		this.markEndTime = markEndTime;
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
