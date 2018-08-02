package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.security.bean.RoleMenuRelation;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.service.MenuRoleService;
import com.msa.security.service.UserMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/27.
 */
@Component
public class RoleAndUserHandle {

    @Autowired
    UserMenuRoleService userMenuRoleService;

    public Result addUserMenuRole(BexParam bexParam){
        Result result=new Result();
        String userid = bexParam.getParam().get("userid");
        String menuroleids = bexParam.getParam().get("menuroleid");
        if(userid!=null && !userid.equals("") && menuroleids!=null && !menuroleids.equals("")){
            UserMenuRole userMenuRole_delete=new UserMenuRole();
            userMenuRole_delete.setUserId(userid);
            userMenuRole_delete.setMenuRoleId(menuroleids);
            userMenuRoleService.delUserMenuRole(userMenuRole_delete);
            String[] splitMessages = menuroleids.split("\\|");
            List<UserMenuRole> userMenuRoleList=new ArrayList<UserMenuRole>();
            for(String splitMessage:splitMessages){
                String[] splitMenuRoleIdMessage = splitMessage.split(",");
                    UserMenuRole userMenuRole=new UserMenuRole();
                    userMenuRole.setMenuRoleId(splitMenuRoleIdMessage[0]);
                    userMenuRole.setUserId(userid);
                    userMenuRole.setFcu(bexParam.getLoginUser().getUserId());
                    userMenuRole.setLcu(bexParam.getLoginUser().getUserId());
                    userMenuRole.setFcd(new Date());
                    userMenuRole.setLcd(new Date());
                    userMenuRoleList.add(userMenuRole);
            }
            int i = userMenuRoleService.giveRoleToUser(userMenuRoleList);
            if(i>0){
                result.setRetcode("0");
                result.setRetmsg("为用户分配角色成功！");
            }else{
                result.setRetcode("-1");
                result.setRetmsg("为用户分配角色失败！");
            }
        }else{
            result.setRetcode("-1");
            result.setRetmsg("调用失败,用户Id或者角色Id为空！");
        }

        return result;
    }

    public Result delUserMenuRole(BexParam bexParam){
        Result result=new Result();
        String userid = bexParam.getParam().get("userid");
        String menuroleid = bexParam.getParam().get("menuroleid");
        UserMenuRole userMenuRole_deleter=new UserMenuRole();
        userMenuRole_deleter.setUserId(userid);
        userMenuRole_deleter.setMenuRoleId(menuroleid);
        int i = userMenuRoleService.delUserMenuRole(userMenuRole_deleter);
        if(i>0){
            result.setRetcode("0");
            result.setRetmsg("为用户删除角色成功!");
        }else{
            result.setRetcode("-1");
            result.setRetmsg("为用户删除角色失败!");
        }
        return result;
    }

    public Result updateUserMenuRole(BexParam bexParam){
        Result result=new Result();


        return result;
    }


}
