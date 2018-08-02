package com.msa.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    /**
     * 返回码
     */
    private String retcode = "-1";
    /**
     * 返回消息
     */
    private String retmsg = "服务调用失败";
    /**
     * 返回数据
     */
    private List record = new ArrayList();
    /**
     * 其他附属参数，例如分页数据等等
     */
    private Map<String, Object> exdata = new HashMap<String, Object>();

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public List getRecord() {
        return record;
    }

    public void setRecord(List record) {
        this.record = record;
    }

    public Map<String, Object> getExdata() {
        return exdata;
    }

    public void setExdata(Map<String, Object> exdata) {
        this.exdata = exdata;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retcode='" + retcode + '\'' +
                ", retmsg='" + retmsg + '\'' +
                ", record=" + record +
                ", exdata=" + exdata +
                '}';
    }
}
