package com.enableets.edu.enable.cloud.exam.framework.core;

/**
 * 定义school微服务错误码和错误信息
 * @author leon_liu@enable-ets.com
 * @since 2017/08/16
 */
public class ErrorConstants {

	/**
	 * 错误码格式模版-系统级(1)、服务级(2)+模块编码(2位数字)+模块错误编码(2位数字)
	 */
	public static final String ERROR_CODE_FORMAT = "%s%s%s";

	/**
	 * 系统级错误编码
	 */
	public static final String SYSTEM_ERROR = "1";

	/**
	 * 服务级错误编码
	 */
	public static final String SERVICE_ERROR = "2";

	/**
	 * 必要参数缺失错误码
	 */
	public static final String ERROR_CODE_REQUIRED_PARAMETER_MISSING = String.format(ERROR_CODE_FORMAT, SYSTEM_ERROR, "00", "01");

	/**
	 * 日期格式错误码
	 */
	public static final String ERROR_CODE_DATE_TIME_FORMAT_ERROR = String.format(ERROR_CODE_FORMAT, SYSTEM_ERROR, "00", "02");

	/** 试卷不存在 */
	public static final String ERROR_CODE_EXAM_NOT_EXISTS = String.format(ERROR_CODE_FORMAT, SERVICE_ERROR, Constants.MODULE_EXAM, "01");
	public static final String ERROR_MESSAGE_EXAM_NOT_EXISTS = String.format(ErrorMsgTemplate.ERROR_MESSAGE_NOT_EXISTS_FORMAT, "试卷信息");
}
