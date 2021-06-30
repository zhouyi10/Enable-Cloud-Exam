package com.enableets.edu.enable.cloud.exam.manager.core;

import com.enableets.edu.module.security.annotation.EnableETSOAuth2Sso;
import com.enableets.edu.module.security.authorization.annotation.EnableACMPrivilege;
import com.enableets.edu.module.security.oauth2.client.OAuth2LogoutHandler;
import com.enableets.edu.module.security.oauth2.client.configure.CustomSsoSecurityConfigurer;
import com.enableets.edu.web.framework.urlrewrite.handler.IUrlRewriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Login authentication
 * @author walle_yu@enable-ets.com
 * @since 2017/5/19
 */
@Configuration
@EnableETSOAuth2Sso
@EnableACMPrivilege
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Value("${security.oauth2.sso.logoutUri}")
	private String logout;
	
	@Value("${security.oauth2.sso.redirectUri}")
	private String indexUrl;

	@Value("${security.oauth2.sso.logoutPath:/oauth2ClientLogout}")
	private String logoutPath;

	@Value("${security.oauth2.sso.un-authenticated-matchers}")
	private String[] unAuthenticatedMatchers;

	/** url matchers of ignoreCsrf */
	@Value("${security.oauth2.sso.ignore-csrf-matchers}")
	private String[] ignoreCsrfMatchers;

	@Autowired
	private CustomSsoSecurityConfigurer customSsoSecurityConfigurer;

	@Autowired
	private IUrlRewriteHandler urlRewriteHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//By default, all requests are protected
		http.antMatcher("/**")
			.authorizeRequests()
			//Ajax, static resources and other requests are excluded,
			.antMatchers(unAuthenticatedMatchers).permitAll()
			// Other requests require user authentication
			.anyRequest().authenticated()
			.and()
			.logout().logoutUrl(Constants.CONTEXT_PATH + "/logout")
			//.addLogoutHandler(new OAuth2LogoutHandler(logout, indexUrl))
			.addLogoutHandler(new OAuth2LogoutHandler(logout, indexUrl, urlRewriteHandler))
			.logoutSuccessUrl("/").permitAll();
		http.headers().frameOptions().sameOrigin();
		customSsoSecurityConfigurer.configure(http);
		customSsoSecurityConfigurer.csrf(http, ignoreCsrfMatchers);
		http.csrf().disable();
	}
	

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}
	
}
