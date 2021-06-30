package com.enableets.edu.enable.cloud.sdk.exam.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author walle_yu@enable-ets.com
 * @since 2021/03/09
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CloudExamServiceSDKConfiguration.class})
public @interface EnableCloudExamServiceSDK {
}
