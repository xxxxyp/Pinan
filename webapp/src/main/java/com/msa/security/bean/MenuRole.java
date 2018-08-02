package com.msa.security.bean;

import java.util.Date;
import java.util.List;

/**
 * 角色实体类
 */
public class MenuRole {
    private String menuRoleId;
    private String subsystemId;
    private String description;
    private String arrangement;
    private String dataState;
    private String fcu;
    private Date fcd;
    private String lcu;
    private Date lcd;

    public MenuRole() {
    }
    public MenuRole(String menuRoleId,String subsystemId, String description, String arrangement, String dataState, String fcu, Date fcd, String lcu, Date lcd) {
        this.menuRoleId = menuRoleId;
        this.subsystemId = subsystemId;
        this.description = description;
        this.arrangement = arrangement;
        this.dataState = dataState;
        this.fcu = fcu;
        this.fcd = fcd;
        this.lcu = lcu;
        this.lcd = lcd;

    }

    public String getMenuRoleId() {
        return menuRoleId;
    }

    public void setMenuRoleId(String menuRoleId) {
        this.menuRoleId = menuRoleId;
    }

    public String getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(String subsystemId) {
        this.subsystemId = subsystemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getFcu() {
        return fcu;
    }

    public void setFcu(String fcu) {
        this.fcu = fcu;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public String getLcu() {
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }

}
