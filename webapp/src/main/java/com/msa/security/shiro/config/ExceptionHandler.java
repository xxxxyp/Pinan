package com.msa.security.shiro.config;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.msa.core.emun.ErrorCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> errMap = new HashMap<String, Object>();
        if (e instanceof UnauthenticatedException) {
            errMap.put("flag", ErrorCode.INCORRECT_CREDENTIALS);
            errMap.put("prompt", "用户信息或密码错误");
        } else if (e instanceof IncorrectCredentialsException) {
            errMap.put("flag", ErrorCode.INCORRECT_CREDENTIALS);
            errMap.put("prompt", "用户信息或密码错误");
        } else if (e instanceof UnauthorizedException) {
            errMap.put("flag", ErrorCode.NO_PERMISSIONS);
            errMap.put("prompt", "您无权操作");
        } else {
            errMap.put("flag", ErrorCode.UN_EXCEPTION);
            errMap.put("prompt", "未知错误:" + e.getMessage());
        }

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(errMap);
        mv.setView(view);
        return mv;
    }
}
