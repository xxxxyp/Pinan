package com.msa.security.bean;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/21.
 */
public class MTBexInterface {

    private int id;
    private String bexCode;
    private String bexName;
    private String bexDesc;
    private String bexType;
    private String datasource;
    private String pageMode;
    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
    private String attr5;
    private String modifyOper;
    private Date modifyTime;
    private int bexCate;
    private int timeout;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBexCode() {
        return bexCode;
    }

    public void setBexCode(String bexCode) {
        this.bexCode = bexCode;
    }

    public String getBexName() {
        return bexName;
    }

    public void setBexName(String bexName) {
        this.bexName = bexName;
    }

    public String getBexDesc() {
        return bexDesc;
    }

    public void setBexDesc(String bexDesc) {
        this.bexDesc = bexDesc;
    }

    public String getBexType() {
        return bexType;
    }

    public void setBexType(String bexType) {
        this.bexType = bexType;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getPageMode() {
        return pageMode;
    }

    public void setPageMode(String pageMode) {
        this.pageMode = pageMode;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    public String getModifyOper() {
        return modifyOper;
    }

    public void setModifyOper(String modifyOper) {
        this.modifyOper = modifyOper;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getBexCate() {
        return bexCate;
    }

    public void setBexCate(int bexCate) {
        this.bexCate = bexCate;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "MTBexInterface{" +
                "id=" + id +
                ", bexCode='" + bexCode + '\'' +
                ", bexName='" + bexName + '\'' +
                ", bexDesc='" + bexDesc + '\'' +
                ", bexType='" + bexType + '\'' +
                ", datasource='" + datasource + '\'' +
                ", pageMode='" + pageMode + '\'' +
                ", attr1='" + attr1 + '\'' +
                ", attr2='" + attr2 + '\'' +
                ", attr3='" + attr3 + '\'' +
                ", attr4='" + attr4 + '\'' +
                ", attr5='" + attr5 + '\'' +
                ", modifyOper='" + modifyOper + '\'' +
                ", modifyTime=" + modifyTime +
                ", bexCate=" + bexCate +
                ", timeout=" + timeout +
                '}';
    }
}
