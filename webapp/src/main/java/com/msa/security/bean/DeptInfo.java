package com.msa.security.bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 部门信息表
 * 部门与用户信息的关联是一对多的关联
 */
public class DeptInfo {
    private  String deptno;
    private  String deptName;
    private  String deptAbbrName;
    private  String upDeptno;
    private  String  DataState;
    private  String  fcu;
    @DateTimeFormat(pattern="yyyy-MM-dd hh-mm-ss")
    private  Date fcd;
    private  String lcu;
    @DateTimeFormat(pattern="yyyy-MM-dd hh-mm-ss")
    private  Date  lcd;
    private  String arrangement;
    private  String  enabledFlag;
    private  String  topDeptno;
    private  String  psUniDeptId;
    private  String  psTopDeptId;

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAbbrName() {
        return deptAbbrName;
    }

    public void setDeptAbbrName(String deptAbbrName) {
        this.deptAbbrName = deptAbbrName;
    }

    public String getUpDeptno() {
        return upDeptno;
    }

    public void setUpDeptno(String upDeptno) {
        this.upDeptno = upDeptno;
    }

    public String getDataState() {
        return DataState;
    }

    public void setDataState(String dataState) {
        DataState = dataState;
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

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getTopDeptno() {
        return topDeptno;
    }

    public void setTopDeptno(String topDeptno) {
        this.topDeptno = topDeptno;
    }

    public String getPsUniDeptId() {
        return psUniDeptId;
    }

    public void setPsUniDeptId(String psUniDeptId) {
        this.psUniDeptId = psUniDeptId;
    }

    public String getPsTopDeptId() {
        return psTopDeptId;
    }

    public void setPsTopDeptId(String psTopDeptId) {
        this.psTopDeptId = psTopDeptId;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "deptno='" + deptno + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptAbbrName='" + deptAbbrName + '\'' +
                ", upDeptno='" + upDeptno + '\'' +
                ", DataState='" + DataState + '\'' +
                ", fcu='" + fcu + '\'' +
                ", fcd=" + fcd +
                ", lcu='" + lcu + '\'' +
                ", lcd=" + lcd +
                ", arrangement='" + arrangement + '\'' +
                ", enabledFlag='" + enabledFlag + '\'' +
                ", topDeptno='" + topDeptno + '\'' +
                ", psUniDeptId='" + psUniDeptId + '\'' +
                ", psTopDeptId='" + psTopDeptId + '\'' +
                '}';
    }

    public DeptInfo() {
    }
}
