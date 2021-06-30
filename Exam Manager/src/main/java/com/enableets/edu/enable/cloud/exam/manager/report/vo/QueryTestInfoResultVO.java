package com.enableets.edu.enable.cloud.exam.manager.report.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Query Test Info
 * @author walle_yu@enable-ets.com
 * @since 2020/08/31
 */
@Data
public class QueryTestInfoResultVO {

	/** Test ID*/
	private String testId;

	/** Test Document File ID*/
	private String fileId;

	private String stepId;

	/** Activity ID*/
	private String activityId;

	/** School ID*/
	private String schoolId;

	/** School Name*/
	private String schoolName;

	/** Term ID*/
	private String termId;

	/** Term Name*/
	private String termName;

	/** Grade Code*/
	private String gradeCode;

	/** Grade Name*/
	private String gradeName;

	/** Subject Code*/
	private String subjectCode;

	/** Subject Name*/
	private String subjectName;

	/** Test Name*/
	private String testName;

	/** Exam ID*/
	private String examId;

	/** Exam Name*/
	private String examName;

	/** Exam Type*/
	private String examType;

	/** Score*/
	private Float score;

	/** Test Begin Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/** Test End Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/** Test Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date testTime;

	/** Start Submit Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startSubmitTime;

	/** End Submit Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endSubmitTime;

	/** Send Paper User ID*/
	private String sender;

	/** Send Paper User Name*/
	private String senderName;

	/** Test Cost Time*/
	private Float testCostTime;

	/** Time allowed for late submission*/
	private Integer delaySubmit;

	/** Maximum number of submissions*/
	private Integer resubmit;

	/** Creator*/
	private String creator;

	/** Create Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/** Updater*/
	private String updator;

	/** Update Time*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	private String processInstantId;

}
