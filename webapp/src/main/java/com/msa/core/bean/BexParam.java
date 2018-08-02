package com.msa.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.msa.security.shiro.domain.User;
import java.util.HashMap;
import java.util.Map;
public class BexParam {
    /**
     * 调用的功能编号
     */
    private String bexcode = "";
    /**
     * 调用的功能编号
     */
    private String obj_code = "";
    /**
     * 调用功能所需参数
     */
    private Map<String, String> param = new HashMap<String, String>();

    /**
     * 其他参数
     */
    private Map<String,String> ext_param = new HashMap<String, String>();
    /**
     * 当前登录用户
     */
    private User loginUser;

    public String getBexcode() {
        return bexcode;
    }

    public void setBexcode(String bexcode) {
        this.bexcode = bexcode;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

    public Map<String, String> getExt_param() {
        return ext_param;
    }

    public String getObj_code() {
        return obj_code;
    }

    public void setObj_code(String obj_code) {
        this.obj_code = obj_code;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public void setExt_param(Map<String, String> ext_param) {
        this.ext_param = ext_param;
    }

    @Override
    public String toString() {
        return "BexParam{" +
                "bexcode='" + bexcode + '\'' +
                ", obj_code='" + obj_code + '\'' +
                ", param=" + param +
                ", ext_param=" + ext_param +
                ", loginUser=" + loginUser +
                '}';
    }
}
