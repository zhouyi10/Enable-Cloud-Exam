package com.enableets.edu.enable.cloud.exam.manager.core;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author walle_yu@enable-ets.com
 * @since 2020/09/03
 **/
@Component
@Data
public class PaperConfigReader {

    @Value("${security.oauth2.sso.client.clientId:wiedu_application_key}")
    private String ssoClientId;

    @Value("${security.oauth2.sso.client.clientSecret:wiedu_application_secret}")
    private String ssoSecret;

    @Value("${storage.host.upload-url}")
    private String uploadFileUrl;

    @Value("${xkw.enable:false}")
    private boolean xkwEnable;

    @Value("${xkw.make-paper-url:null}")
    private String xkwMakePaperUrl;

    @Value("${xkw.appId:null}")
    private String xkwAppId;

    @Value("${xkw.secret:null}")
    private String xkwSecret;

    @Value("${xkw.get-paper-url:null}")
    private String getPaperUrl;

    @Value("${xkw.imgUrlHost:http://static.zujuan.xkw.com/}")
    private String imgUrlHost;

    @Value("${xkw.service-auth-url:null}")
    private String serviceAuthUrl;

    @Value("${xkw.save-paper-callback-url:null}")
    private String savePaperCallbackUrl;

    @Value("${xkw.iframe-url:null}")
    private String iframeUrl;

    @Value("${onlinefile.url:null}")
    private String onlineFileUrl;
}
