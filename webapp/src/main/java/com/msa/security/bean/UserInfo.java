package com.msa.security.bean;

import java.util.Date;
import java.util.List;

/**
 * 用户信息类
 * 用户信息与部门信息的关联是一对多的关联
 */
public class UserInfo {
    public UserInfo() { };
    private String userId;
    private String userPwd;
    private String userName;
    private String mobile;
    private String mail;
    private String dataState;
    private String fcu;
    private Date fcd;
    private String lcu;
    private Date lcd;
    private String idCode;
    private String fax;
    private String tel;
    private String ext;
    private String validFlag;
    private String userType;
    private Date paicLeaveDate;
    private String namePingyin;
    private String userPosition;
    private String  deptno;
    private  String  upDeptno;
    private  String valiflag;

    public String getValiflag() {
        return valiflag;
    }

    public void setValiflag(String valiflag) {
        this.valiflag = valiflag;
    }

    public String getUpDeptno() {
        return upDeptno;
    }

    public void setUpDeptno(String upDeptno) {
        this.upDeptno = upDeptno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getDeptno() {
        return deptno;
    }
    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getPaicLeaveDate() {

        return paicLeaveDate;
    }

    public void setPaicLeaveDate(Date paicLeaveDate) {
        this.paicLeaveDate = paicLeaveDate;
    }

    public String getNamePingyin() {
        return namePingyin;
    }

    public void setNamePingyin(String namePingyin) {
        this.namePingyin = namePingyin;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }
    public UserInfo(String userId,String userPwd, String deptno, String userName, String mobile, String mail, String dataState, String fcu, Date fcd, String lcu, Date lcd, String idCode, String fax, String tel, String ext, String validFlag, String userType, Date paicLeaveDate, String namePingyin, String userPosition) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.deptno = deptno;
        this.userName = userName;
        this.mobile = mobile;
        this.mail = mail;
        this.dataState = dataState;
        this.fcu = fcu;
        this.fcd = fcd;
        this.lcu = lcu;
        this.lcd = lcd;
        this.idCode = idCode;
        this.fax = fax;
        this.tel = tel;
        this.ext = ext;
        this.validFlag = validFlag;
        this.userType = userType;
        this.paicLeaveDate = paicLeaveDate;
        this.namePingyin = namePingyin;
        this.userPosition = userPosition;
    }
}
