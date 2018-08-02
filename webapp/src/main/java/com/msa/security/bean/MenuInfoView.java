package com.msa.security.bean;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/24.
 */
public class MenuInfoView {

    private String menuId;
    private String subsystemId;
    private String description;
    private String menuPosition;
    private String menuUrl;
    private String menuType;
    private String dataState;
    private String formSubmitFlag;
    private String parentMenuId;
    private String isChoose;

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuPosition() {
        return menuPosition;
    }

    public void setMenuPosition(String menuPosition) {
        this.menuPosition = menuPosition;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(String subsystemId) {
        this.subsystemId = subsystemId;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getFormSubmitFlag() {
        return formSubmitFlag;
    }

    public void setFormSubmitFlag(String formSubmitFlag) {
        this.formSubmitFlag = formSubmitFlag;
    }

    public String getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(String isChoose) {
        this.isChoose = isChoose;
    }

    @Override
    public String toString() {
        return "MenuInfoView{" +
                "menuId='" + menuId + '\'' +
                ", subsystemId='" + subsystemId + '\'' +
                ", description='" + description + '\'' +
                ", menuPosition='" + menuPosition + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuType='" + menuType + '\'' +
                ", dataState='" + dataState + '\'' +
                ", formSubmitFlag='" + formSubmitFlag + '\'' +
                ", parentMenuId='" + parentMenuId + '\'' +
                '}';
    }
}
