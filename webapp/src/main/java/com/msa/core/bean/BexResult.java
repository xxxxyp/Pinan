package com.msa.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class BexResult {
    /**
     * 成功标识，0为成功，其他为异常
     */
    private String flag = "-1";
    /**
     * 提示信息
     */
    private String prompt = "调用服务失败";
    /**
     *  每个Bex请求结果
     */
    private List<Result> results = new ArrayList<Result>();

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BexResult{" +
                "flag='" + flag + '\'' +
                ", prompt='" + prompt + '\'' +
                ", results=" + results +
                '}';
    }
}
