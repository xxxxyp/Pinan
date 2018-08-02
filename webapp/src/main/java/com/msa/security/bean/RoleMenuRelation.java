package com.msa.security.bean;

import java.util.Date;

public class RoleMenuRelation {
    public RoleMenuRelation (){};
    private String  menuId;
    private String  menuRoleId;
    private String  subsystemId;
    private String  dataState;
    private String  fcu;
    private Date    fcd;
    private String  lcu;
    private Date  lcd;
    private MenuRole  role;
    private MenuInfo  menu;

    public MenuRole getRole() {
        return role;
    }

    public void setRole(MenuRole role) {
        this.role = role;
    }

    public MenuInfo getMenu() {
        return menu;
    }

    public void setMenu(MenuInfo menu) {
        this.menu = menu;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

    public RoleMenuRelation(String menuId,MenuRole  role,MenuInfo  menu, String menuRoleId, String subsystemId, String dataState, String fcu, Date fcd, String lcu, Date lcd) {
        this.role=role;
        this.menu=menu;
        this.menuId = menuId;
        this.menuRoleId = menuRoleId;
        this.subsystemId = subsystemId;
        this.dataState = dataState;
        this.fcu = fcu;
        this.fcd = fcd;
        this.lcu = lcu;
        this.lcd = lcd;
    }
}
