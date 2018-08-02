package com.msa.security.util;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.BexResult;

import java.util.Set;

/**
 * Created by Administrator on 2018/5/8.
 */
public class BexParamUtil {

    public static BexResult ValidateLengt(BexParam bexParam) {
        BexResult bexResult = new BexResult();
        Set<String> keySet = bexParam.getParam().keySet();
        boolean b=true;
        for (String key : keySet) {
            if (key == "deptno") {
                if (bexParam.getParam().get(key).length() > 25) {
                    bexResult.setPrompt("机构编码长度不能超过25个字节");
                    b=false;
                }
            }
            if (key == "dept_name") {
                if (bexParam.getParam().get(key).length() > 135) {
                    bexResult.setPrompt("机构名称长度不能超过135个字节");
                    b=false;
                }
            }
            if (key == "enabled_flag") {
                if (bexParam.getParam().get(key).length() > 2) {
                    bexResult.setPrompt("有效标示长度不能超过2个字节");
                    b=false;
                }
            }
            if (key == "up_deptno") {
                if (bexParam.getParam().get(key).length() > 90) {
                    bexResult.setPrompt("上级机构编码长度不能超过90个字节");
                    b=false;
                }
            }
            if (key == "dept_abbr_name") {
                if (bexParam.getParam().get(key).length() > 35) {
                    bexResult.setPrompt("机构简称长度不能超过35个字节");
                    b=false;
                }
            }
            if (key == "data_state") {
                if (bexParam.getParam().get(key).length() > 2) {
                    bexResult.setPrompt("数据状态长度不能超过2个字节");
                    b=false;
                }
            }
            if (key == "arrangement") {
                if (bexParam.getParam().get(key).length() > 40) {
                    bexResult.setPrompt("层级长度不能超过40个字节");
                    b=false;
                }
            }
            if (key == "top_deptno") {
                if (bexParam.getParam().get(key).length() > 23) {
                    bexResult.setPrompt("专业公司代码不能超过23个字节");
                    b=false;
                }
            }
            if (key == "ps_uni_deptid") {
                if (bexParam.getParam().get(key).length() > 72) {
                    bexResult.setPrompt("PS系统唯一键不能超过72个字节");
                    b=false;
                }
            }
            if (key == "ps_top_deptid") {
                if (bexParam.getParam().get(key).length() > 23) {
                    bexResult.setPrompt("PS专业公司代码不能超过23个字节");
                    b=false;
                }
            }
            if (key == "arrangment") {
                if (bexParam.getParam().get(key).length() > 40) {
                    bexResult.setPrompt("层级不能超过40个字节");
                    b=false;
                }
            }
            if (key == "enableed_flag") {
                if (bexParam.getParam().get(key).length() > 2) {
                    bexResult.setPrompt("有效标示不能超过2个字节");
                    b=false;
                }
            }
            if (key == "fcu") {
                if (bexParam.getParam().get(key).length() > 45) {
                    bexResult.setPrompt("创建人不能超过45个字节");
                    b=false;
                }
            }
            if (key == "lcu") {
                if (bexParam.getParam().get(key).length() > 45) {
                    bexResult.setPrompt("修改人不能超过45个字节");
                    b=false;
                }
            }
            if (key == "menuid") {
                if (bexParam.getParam().get(key).length() > 20) {
                    bexResult.setPrompt("菜单编码不能超过20个字节");
                    b=false;
                }
            }
            if (key == "menuRoleId") {
                if (bexParam.getParam().get(key).length() > 20) {
                    bexResult.setPrompt("角色编码不能超过20个字节");
                    b=false;
                }
            }
            if (key == "userid") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("用户编码不能超过30个字节");
                    b=false;
                }
            }
            if (key == "subsystemId") {
                if (bexParam.getParam().get(key).length() > 1) {
                    bexResult.setPrompt("子系统ID不能超过1个字节");
                    b=false;
                }
            }
            if (key == "description") {
                if (bexParam.getParam().get(key).length() > 60) {
                    bexResult.setPrompt("名称不能超过60个字节");
                    b=false;
                }
            }
            if (key == "dataState") {
                if (bexParam.getParam().get(key).length() > 1) {
                    bexResult.setPrompt("数据状态不能超过1个字节");
                    b=false;
                }
            }
            if (key == "userId") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("用户编码不能超过30个字节");
                    b=false;
                }
            }
            if (key == "user_id") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("用户编码不能超过30个字节");
                    b=false;
                }
            }
            if (key == "mail") {
                if (bexParam.getParam().get(key).length() > 90) {
                    bexResult.setPrompt("邮箱不能超过90个字节");
                    b=false;
                }
            }
            if (key == "user_type") {
                if (bexParam.getParam().get(key).length() > 1) {
                    bexResult.setPrompt("用户类型不能超过1个字节");
                    b=false;
                }
            }
            if (key == "user_name") {
                if (bexParam.getParam().get(key).length() > 60) {
                    bexResult.setPrompt("用户名称不能超过60个字节");
                    b=false;
                }
            }
            if (key == "mobile") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("移动电话不能超过30个字节");
                    b=false;
                }
            }
            if (key == "valid_flag") {
                if (bexParam.getParam().get(key).length() > 1) {
                    bexResult.setPrompt("有效标识不能超过1个字节");
                    b=false;
                }
            }
            if (key == "user_position") {
                if (bexParam.getParam().get(key).length() > 300) {
                    bexResult.setPrompt("用户职位不能超过300个字节");
                    b=false;
                }
            }
            if (key == "id_code") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("身份证号码不能超过30个字节");
                    b=false;
                }
            }
            if (key == "tel") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("直线电话不能超过30个字节");
                    b=false;
                }
            }
            if (key == "ext") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("分机电话不能超过30个字节");
                    b=false;
                }
            }
            if (key == "fax") {
                if (bexParam.getParam().get(key).length() > 30) {
                    bexResult.setPrompt("传真不能超过30个字节");
                    b=false;
                }
            }
            if (key == "user_pwd") {
                if (bexParam.getParam().get(key).length() > 64) {
                    bexResult.setPrompt("登录密码不能超过64个字节");
                    b=false;
                }
            }
            if (key == "namepingyin") {
                if (bexParam.getParam().get(key).length() > 225) {
                    bexResult.setPrompt("用户名拼音不能超过225个字节");
                    b=false;
                }
            }
            if (key == "roleid") {
                if (bexParam.getParam().get(key).length() > 20) {
                    bexResult.setPrompt("角色编码不能超过20个字节");
                    b=false;
                }
            }
            if (key == "username") {
                if (bexParam.getParam().get(key).length() > 60) {
                    bexResult.setPrompt("用户名称不能超过60个字节");
                    b=false;
                }
            }
            if (key == "usertype") {
                if (bexParam.getParam().get(key).length() > 1) {
                    bexResult.setPrompt("用户类型不能超过1个字节");
                    b=false;
                }
            }
            if (key == "validflag") {
                if (bexParam.getParam().get(key).length() > 1) {
                    bexResult.setPrompt("有效标识不能超过1个字节");
                    b=false;
                }
            }
        }
        if(b){
            bexResult.setFlag("0");
        }
        return bexResult;
    }
}
