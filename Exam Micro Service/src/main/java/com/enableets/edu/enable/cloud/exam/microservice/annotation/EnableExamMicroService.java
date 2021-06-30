package com.enableets.edu.enable.cloud.exam.microservice.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/03/03
 **/

@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ExamMicroServiceConfig.class})
public @interface EnableExamMicroService {

}
