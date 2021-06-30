package com.enableets.edu.enable.cloud.exam.manager.core;

import com.enableets.edu.acm.menu.provider.IMenuProvider;
import com.enableets.edu.acm.menu.provider.bean.UserMenuBean;
import com.enableets.edu.sdk.school3.IUserIdentityService;
import com.enableets.edu.sdk.school3.dto.UserIdentityDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * controller增强器，加载menues
 *
 * @author walle_yu@enable-ets.com
 * @since 2017/11/6
 */
@ControllerAdvice(basePackages = "com.enableets.edu.enable.cloud.exam.manager")
public class MenuControllerAdvice {

    @Autowired
    private IMenuProvider menuProvider;

    @Autowired
    private IUserIdentityService userIdentityService;

    @Autowired
    private BaseInfoManager baseInfoManager;

    private static final String APP_EXAMINATION_50 = "EnableV50_Testing";
    private static final String APP_EXAMINATION_50_ID = "M5003";
    private static final String APP_HEADER_MENU_50 = "EnableV50_Header";
    private static final String APP_HEADER_USER_MENU_50 = "EnableV50_DropDown";
    private static final String SELECT_MENU_TOP_KEY = "_menu_50_top_key_";
    private static final String SELECT_MENU_CHILD_KEY = "_menu_50_child_key_";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<UserMenuBean> headMenuV5 = menuProvider.list(APP_HEADER_MENU_50);
        if (CollectionUtils.isEmpty(headMenuV5)) return;

		Cookie[] cookies = request.getCookies();

        model.addAttribute("menuJsonHeader", headMenuV5);
        model.addAttribute("menuHeaderId", APP_EXAMINATION_50_ID);


        List<UserMenuBean> navList = menuProvider.list(APP_EXAMINATION_50);
        if (CollectionUtils.isEmpty(navList)) return;
        model.addAttribute("menuJson", navList);
        if (!isCookieExist(cookies, navList, SELECT_MENU_CHILD_KEY)) {
            Cookie cookie = new Cookie(SELECT_MENU_CHILD_KEY, navList.get(0).getMenuId());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        List<UserMenuBean> userMenus = menuProvider.list(APP_HEADER_USER_MENU_50);
        model.addAttribute("userMenus", userMenus);
        List<UserIdentityDTO> identitys = userIdentityService.query(baseInfoManager.getUserId(), "", "", "", "", "", "", null, null);
        model.addAttribute("identitys", StringUtils.join(identitys.get(0).getIdentities()));
    }

    private Boolean isCookieExist(Cookie[] cookies, List<UserMenuBean> menuList, String key) {
        boolean isCookieExist = false;
        for (Cookie cookieTemp : cookies) {
            if (cookieTemp.getName().equals(key)) {
                for (UserMenuBean userMenuBean : menuList) {
                    if (userMenuBean.getMenuId().equals(cookieTemp.getValue())) {
                        isCookieExist = true;
                    }
                }
            }
        }
        return isCookieExist;
    }
}
