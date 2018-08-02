package com.msa.security.controller;

import com.msa.core.bean.BexResult;
import com.msa.core.bean.Result;
import com.msa.core.emun.ErrorCode;
import com.msa.encoder.AESEncoder;
import com.msa.security.bean.LoginParam;
import com.msa.security.shiro.domain.User;
import com.msa.security.shiro.token.UserToken;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限控制层类
 * Created by Administrator on 2018/4/18.
 */
@Controller
public class AuthController {

    //private Logger logger = LoggerFactory.getLogger(AuthController.class);
    private AESEncoder aesEncoder = new AESEncoder();

    @RequestMapping("/login")
    @ResponseBody
    public BexResult doLogin(@RequestBody LoginParam loginParam) throws IOException {
        //对前端的加密密码进行还原
        String orignPwd = AESEncoder.decodePassword(loginParam.getPassword());
        UserToken token = new UserToken(loginParam.getUsername(), orignPwd);
        Subject subject = SecurityUtils.getSubject();

        //登录
        subject.login(token);
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //封装结果集
        BexResult retResult = new BexResult();
        retResult.setFlag(ErrorCode.AUTH_SUCCESS);
        retResult.setPrompt("登录成功");

        Result result = new Result();
        result.setRetcode(ErrorCode.AUTH_SUCCESS);
        result.setRetmsg("登录成功");
        Map<String, Object> userInfo = new HashMap<String, Object>();
        userInfo.put("loginID", loginParam.getUsername());
        userInfo.put("userName", loginParam.getUsername());
        userInfo.put("orgID", user.getDeptno());
        userInfo.put("orgName", user.getDeptName());
        userInfo.put("roleIds", user.getRoleIds());
        userInfo.put("roleNames", user.getRoleNames());
        result.getRecord().add(userInfo);
        retResult.getResults().add(result);

        return retResult;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public BexResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //封装结果集
        BexResult retResult = new BexResult();
        retResult.setFlag(ErrorCode.AUTH_SUCCESS);
        retResult.setPrompt("登出成功");

        Result result = new Result();
        result.setRetcode(ErrorCode.AUTH_SUCCESS);
        result.setRetmsg("登出成功");

        return retResult;
    }

    @RequestMapping("/")
    @ResponseBody
    public String unauth() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "-1");
        jsonObject.put("msg", "未登录");
        return jsonObject.toString();
    }

    @RequestMapping("/index")
    public String index(){
        return "/dist/index.html";
    }

}
