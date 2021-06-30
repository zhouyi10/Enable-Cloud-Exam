package com.enableets.edu.enable.cloud.sdk.exam.annotation;

import com.enableets.edu.enable.cloud.sdk.exam.IExamDictionaryService;
import com.enableets.edu.enable.cloud.sdk.exam.IExamInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.IExamLevelInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.IExamResultInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamDictionaryServiceFeignClient;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamInfoServiceFeignClient;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamLevelInfoFeignClient;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamResultInfoServiceFeignClient;
import com.enableets.edu.enable.cloud.sdk.exam.impl.DefaultExamDictionaryService;
import com.enableets.edu.enable.cloud.sdk.exam.impl.DefaultExamInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.impl.DefaultExamLevelInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.impl.DefaultExamResultInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walle_yu@enable-ets.com
 * @since 2021/03/09
 **/
@Configuration
@EnableFeignClients(basePackages = {"com.enableets.edu.enable.cloud.sdk.exam.feign"})
public class CloudExamServiceSDKConfiguration {

    @Autowired
    public IExamInfoServiceFeignClient examInfoServiceFeignClient;

    @Autowired
    public IExamLevelInfoFeignClient examLevelInfoFeignClient;

    @Autowired
    private IExamResultInfoServiceFeignClient examResultInfoServiceFeignClient;

    @Autowired
    private IExamDictionaryServiceFeignClient examDictionaryServiceFeignClient;

    @Bean(name = "bookInfoServiceSDK")
    public IExamInfoService bookInfoServiceSDK(){
        return new DefaultExamInfoService(examInfoServiceFeignClient);
    }

    @Bean(name = "examLevelInfoServiceSDK")
    public IExamLevelInfoService examLevelInfoServiceSDK() {
        return new DefaultExamLevelInfoService(examLevelInfoFeignClient);
    }

    @Bean(name = "examResultInfoServiceSDK")
    public IExamResultInfoService examResultInfoServiceSDK() {
        return new DefaultExamResultInfoService(examResultInfoServiceFeignClient);
    }

    @Bean(name = "examDictionaryServiceSDK")
    public IExamDictionaryService examDictionaryServiceSDK() {
        return new DefaultExamDictionaryService(examDictionaryServiceFeignClient);
    }
}
