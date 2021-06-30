package com.enableets.edu.enable.cloud.exam.microservice.annotation;

import com.enableets.edu.enable.cloud.exam.microservice.handler.ResponseResultInterceptor;
import com.enableets.edu.framework.core.util.token.CustomTokenGenerator;
import com.enableets.edu.framework.core.util.token.ITokenGenerator;
import com.enableets.edu.module.service.core.DefaultSwaggerConfiguration;
import com.enableets.edu.module.service.core.GlobalServiceExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/03/03
 **/
@ComponentScan(basePackages = {"com.enableets.edu.enable.cloud.exam.microservice", "com.enableets.edu.enable.cloud.exam.framework"},  nameGenerator = ExamMicroServiceConfig.CustomAnnotationBeanNameGenerator.class)
public class ExamMicroServiceConfig extends DefaultSwaggerConfiguration {

    @Value("${system-identifier.worker-id}")
    private String workerId;

    @Value("${system-identifier.datacenter-id}")
    private String datacenterId;

    // swagger - restful package
    public  static final String RESTFUL_BASE_PACKAGE = "com.enableets.edu.enable.cloud.exam.microservice.restful";

    // swagger - doc title
    private static final String TITLE = "Exam Service RESTful APIs";

    // swagger - description
    private static final String DESCRIPTION = "Exam RESTFUL API文档说明";

    // Swagger - contacts
    private static final String CONTACT = "Jason_Du@enable-ets.com";

    // swagger - doc version
    private static final String VERSION = "1.0.0";

    @Override
    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).contact(CONTACT).version(VERSION).build();
    }

    @Override
    protected String getRestfulControllerBasePackage() {
        return RESTFUL_BASE_PACKAGE;
    }

    /**
     * Twitter's distributed self incrementing ID primary key
     * @return
     */
    @Bean
    public ITokenGenerator getTokenGenerator(){
        ITokenGenerator tokenGenerator = new CustomTokenGenerator(Long.valueOf(this.workerId), Long.valueOf(this.datacenterId));
        return tokenGenerator;
    }

    /**
     * custom default bean name generator
     */
    public static class CustomAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator {

        @Override
        protected String buildDefaultBeanName(BeanDefinition definition) {
            return "exam_" + super.buildDefaultBeanName(definition);
        }
    }

    /**
     * Service global exception handling
     * @return GlobalServiceExceptionHandler
     */
    @Configuration
    @ControllerAdvice({RESTFUL_BASE_PACKAGE})
    public static class CustomGlobalServiceExceptionHandler extends GlobalServiceExceptionHandler {

    }
}
