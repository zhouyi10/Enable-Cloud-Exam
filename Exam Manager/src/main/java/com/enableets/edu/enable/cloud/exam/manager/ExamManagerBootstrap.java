package com.enableets.edu.enable.cloud.exam.manager;

import com.enableets.edu.acm.menu.provider.IMenuProvider;
import com.enableets.edu.acm.menu.provider.IMenuProviderV2;
import com.enableets.edu.acm.menu.provider.impl.DefaultMenuProvider;
import com.enableets.edu.acm.menu.provider.impl.DefaultMenuProviderV2;
import com.enableets.edu.enable.cloud.exam.manager.core.Constants;
import com.enableets.edu.framework.core.bootstrap.ApplicationBootstrap;
import com.enableets.edu.framework.core.util.SpringBeanUtils;
import com.enableets.edu.module.service.EnableETSService;
import com.enableets.edu.sdk.account.v2.annotation.EnableAccountV2ServiceSDK;
import com.enableets.edu.sdk.acm.IUserMenuService;
import com.enableets.edu.sdk.activity.annotation.EnableActivityV2ServiceSDK;
import com.enableets.edu.sdk.assessment.annotation.EnableAssessmentServiceSDK;
import com.enableets.edu.sdk.content.annotation.EnableContentServiceSDK;
import com.enableets.edu.sdk.group.annotation.EnableGroupServiceSDK;
import com.enableets.edu.sdk.pakage.annotation.EnablePackageServiceSDK;
import com.enableets.edu.sdk.paper.annotation.EnablePaperServiceSDK;
import com.enableets.edu.sdk.school3.annotation.EnableSchoolServiceSDK;
import com.enableets.edu.sdk.school3.v2.annotation.EnableSchoolServiceV2SDK;
import com.enableets.edu.sdk.steptask.annotation.EnableStepV2ServiceSDK;
import com.enableets.edu.ueditor.manager.servlet.UEditorServlet;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Exam Manager Bootstrap
 *
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/13
 **/

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.enableets.edu.enable.cloud.exam.manager","com.enableets.edu.acm.menu.provider"})
@EnableETSService
@EnableSchoolServiceSDK
@EnableSchoolServiceV2SDK
@EnableContentServiceSDK
@EnableAccountV2ServiceSDK
@EnableActivityV2ServiceSDK
@EnableStepV2ServiceSDK
@EnablePackageServiceSDK
@EnableGroupServiceSDK
@EnableAssessmentServiceSDK
//@EnableCloudExamServiceSDK
@EnablePaperServiceSDK
public class ExamManagerBootstrap extends ApplicationBootstrap {
    @Value("${report.qps:10}")
    public double qps;

    private static final String APP_STUDY_TASK_50 = "APP_STUDY_TASK_50";
    private static final String APP_HEADER_MENU_50 = "EnableV50_Header";
    private static final String COOKIE_NAME_ENABLED_50_MENU = "enabled50Menu";
    private static final String REQUEST_PARAM_NAME_ENABLED_50_MENU = "enabled50Menu";

    public static void main(String[] args) {
        SpringApplication.run(ExamManagerBootstrap.class);
    }

    @Autowired
    private Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.CONTEXT_PATH + "/custom/**").addResourceLocations("classpath:/static/custom/");
        registry.addResourceHandler(Constants.CONTEXT_PATH + "/comm/**").addResourceLocations("classpath:/static/comm/");
    }

    @ControllerAdvice(basePackages = {"com.enableets.edu.teachingassistant.manager.controller"})
    public static class GlobalVariableController{

        @ModelAttribute
        public void get(Model model){
            Locale _locale = ((LocaleResolver) SpringBeanUtils.getBean(LocaleResolver.class)).resolveLocale((HttpServletRequest)null);
            model.addAttribute("_locale", _locale.toString());
            DynamicStringProperty stringProperty = DynamicPropertyFactory.getInstance().getStringProperty("build.version", "0002");
            model.addAttribute("_v", stringProperty.get());
            model.addAttribute("_contextPath", Constants.CONTEXT_PATH);
        }
    }

    /**
     * ueditor 访问类
     * @return
     */
    @Bean
    public ServletRegistrationBean uEditorServletRegistrationBean() {
        return new ServletRegistrationBean(new UEditorServlet("classpath:config.json"), Constants.CONTEXT_PATH + "/ueditor/execute");
    }

    @Bean
    public IMenuProviderV2 menuProviderV2(IUserMenuService userMenuService) {
        return new DefaultMenuProviderV2(userMenuService);
    }

    @Bean
    public IMenuProvider menuProvider(IUserMenuService userMenuService) {
        return new DefaultMenuProvider(userMenuService);
    }



}
