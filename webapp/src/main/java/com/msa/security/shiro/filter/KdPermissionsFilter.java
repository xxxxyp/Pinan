package com.msa.security.shiro.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.core.emun.ErrorCode;
import com.msa.security.util.WebUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KdPermissionsFilter extends PermissionsAuthorizationFilter {

    private static final Logger logger = LoggerFactory.getLogger(KdPermissionsFilter.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * shiro认证perms资源失败后回调方法
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (WebUtils.isAjaxRequest(httpServletRequest)) {//如果是ajax返回指定格式数据
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("flag", ErrorCode.NO_PERMISSIONS);
            result.put("prompt", "权限不足");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(result));
        } else {//如果是普通请求进行重定向
            saveRequestAndRedirectToLogin(servletRequest, servletResponse);
        }
        return false;
    }

}
