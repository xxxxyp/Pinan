package com.msa.security.shiro.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.core.emun.ErrorCode;
import com.msa.security.util.WebUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiongwei on 2018/4/24.
 */
public class KdAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(KdAuthenticationFilter.class);
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " + "Authentication url [" + getLoginUrl() + "]");
            }
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            if (WebUtils.isAjaxRequest(httpServletRequest)) {//如果是ajax返回指定格式数据
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("flag", ErrorCode.UNAUTHENTICATE);
                result.put("prompt", "会话失效或未登录");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(result));
            } else {//如果是普通请求进行重定向
                saveRequestAndRedirectToLogin(request, response);
            }
            return false;
        }
    }
}
