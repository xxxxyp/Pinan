package com.msa.security.bean;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/26.
 */
public class MenuRoleView {

    private String menuroleid;
    private String subsystemid;
    private String description;
    private String arrangement;
    private String datastate;

    @Override
    public String toString() {
        return "MenuRoleView{" +
                "menuroleid='" + menuroleid + '\'' +
                ", subsystemid='" + subsystemid + '\'' +
                ", description='" + description + '\'' +
                ", arrangement='" + arrangement + '\'' +
                ", datastate='" + datastate + '\'' +
                '}';
    }
}
