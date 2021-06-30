
package com.enableets.edu.enable.cloud.exam.framework.core;

import com.enableets.edu.framework.core.util.StringUtils;
import com.enableets.edu.module.service.core.MicroServiceException;

/**
 * VO抽象基类，定义了抽象方法验证VO参数
 * @author walle_yu@enable-ets.com
 * @since 2017/12/06
 */
public abstract class BaseVO {
	
	/**
	 * 验证参数
	 * @throws MicroServiceException
	 */
	public abstract void validate() throws MicroServiceException;
	
	/**
	 * 校验 string 类型属性非空
	 * 
	 * @param value
	 *            属性值
	 * @param name
	 *            属性名
	 */
	protected void validate(String value, String name) {
		if (StringUtils.isEmpty(value)) {
			throwRequiredParameterMissingException(name);
		}
	}

	/**
	 * 校验 Object 类型属性非空
	 *
	 * @param value
	 *            属性值
	 * @param name
	 *            属性名
	 */
	protected void validate(Object value, String name) {
		if (value == null) {
			throwRequiredParameterMissingException(name);
		}
	}

	/**
	 * 抛参数不能为空异常
	 * 
	 * @param name
	 *            参数名
	 */
	protected void throwRequiredParameterMissingException(String name) {
		throw new MicroServiceException(ErrorConstants.ERROR_CODE_REQUIRED_PARAMETER_MISSING,
				String.format(ErrorMsgTemplate.ERROR_MESSAGE_NULL_FORMAT, name));
	}
	
	
}

