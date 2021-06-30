package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class ExamDetailsStepTaskInfoDTO {
	
	/**
	 * 考试详情标识
	 */	
	private Long examDetailsId;

	/**
	 * 考试发布后，考试详情对应的打卡任务的标识
	 */	
	private String activityId;

	/**
	 * 试卷信息，json串
	 */	
	private String contentInfo;

	/**
	 * 0:指定时间发布 1：立即发布
	 */	
	private String publishNow;

	/**
	 * 发布时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date publishTime;

	/**
	 * 状态 0:未派卷 1：已派卷 
	 */	
	private String status;

	/**
	 * 试卷下载时间，提前下载分钟数
	 */	
	private Long downloadInAdvanceMinutes;

	/**
	 * 考试时长
	 */	
	private Long minutesOfExam;

	/**
	 * 答卷开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date answerStartTime;

	/**
	 * 答卷结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date answerEndTime;

	/**
	 * 答卷后多少分钟可以交卷
	 */	
	private Long minutesAfterTheStartToHandIn;

	/**
	 * 交卷结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date handInEndTime;

	/**
	 * 阅卷开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date markStartTime;

	/**
	 * 阅卷结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date markEndTime;

	/**
	 * 创建者
	 */	
	private String creator;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;

	/**
	 * 修改者
	 */	
	private String updator;

	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;

}
