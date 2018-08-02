package com.msa.core.controller;

import com.google.gson.Gson;
import com.msa.core.bean.BexParam;
import com.msa.core.bean.BexResult;
import com.msa.core.dispatcher.CoreDispatcher;
import com.msa.security.shiro.domain.User;
import com.msa.security.util.BexParamUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/4/20.
 */
@RestController
public class CoreController {

    @Autowired
    private CoreDispatcher coreDispatcher;
    private Logger logger = LoggerFactory.getLogger(CoreController.class);

    @RequestMapping("/ajax_fm.do")
    public String select(@RequestBody BexParam bexParam) {
        logger.debug("-----------------bexParam:"+bexParam);
        //当前用户信息
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        bexParam.setLoginUser(loginUser);
        BexResult bexResult = BexParamUtil.ValidateLengt(bexParam);
        Gson gson =new Gson();
        if(bexResult.getFlag().equals("-1")){
            return gson.toJson(bexResult);
        }
        //调用业务分发处理器
        BexResult result = coreDispatcher.doDispatcher(bexParam);

        return gson.toJson(result);
    }


}
