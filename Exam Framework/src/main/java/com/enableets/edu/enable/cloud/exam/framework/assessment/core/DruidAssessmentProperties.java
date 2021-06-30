package com.enableets.edu.enable.cloud.exam.framework.assessment.core;

import com.enableets.edu.enable.cloud.exam.framework.core.DruidCustomProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只提供了常用的属性，如果有需要，自己添加
 *
 * @since 2017/2/5
 */
@Component
@ConfigurationProperties(prefix = "druid.assessment")
public class DruidAssessmentProperties extends DruidCustomProperties {
}
