package com.msa.security.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken implements java.io.Serializable {
    private String userPwd;

    public UserToken() {
    }

    public UserToken(String username, String pwd) {
        super(username,pwd);
        this.userPwd = pwd;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
