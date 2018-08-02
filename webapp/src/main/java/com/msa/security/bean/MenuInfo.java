package com.msa.security.bean;

import java.util.Date;
import java.util.List;

/**
 * 菜单信息表
 */
public class MenuInfo {
    public MenuInfo() {
    }
    private String menuId;
    private String subsystemId;
    private String description;
    private String menuPosition;
    private String menuUrl;
    private String frameHeight;
    private String menuType;
    private String dataState;
    private String fcu;
    private Date fcd;
    private String lcu;
    private Date lcd;
    private String formSubmitFlag;
    private String tableName;
    private String parentMenuId;
    public String getMenuId() {

        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

    public String getMenuPosition() {
        return menuPosition;
    }

    public void setMenuPosition(String menuPosition) {
        this.menuPosition = menuPosition;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(String frameHeight) {
        this.frameHeight = frameHeight;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
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

    public String getFormSubmitFlag() {
        return formSubmitFlag;
    }

    public void setFormSubmitFlag(String formSubmitFlag) {
        this.formSubmitFlag = formSubmitFlag;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public MenuInfo(String menuId, String subsystemId, String description, String menuPosition, String menuUrl, String frameHeight, String menuType, String dataState, String fcu, Date fcd, String lcu, Date lcd, String formSubmitFlag, String tableName) {
        this.menuId = menuId;
        this.subsystemId = subsystemId;
        this.description = description;
        this.menuPosition = menuPosition;
        this.menuUrl = menuUrl;
        this.frameHeight = frameHeight;
        this.menuType = menuType;
        this.dataState = dataState;
        this.fcu = fcu;
        this.fcd = fcd;
        this.lcu = lcu;
        this.lcd = lcd;
        this.formSubmitFlag = formSubmitFlag;
        this.tableName = tableName;
    }
}
