package com.msa.security.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/21.
 */
public class LoginParam implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
