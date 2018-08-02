package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.security.bean.RoleMenuRelation;
import com.msa.security.service.RoleMenuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */
@Component
public class RoleAndMenuHandle {

    @Autowired
    private RoleMenuRelationService roleMenuRelationService;

    public Result giveMenuToRole(BexParam bexParam){
        Result result=new Result();
        String roleId = bexParam.getParam().get("menuRoleId");
        String menuIds=bexParam.getParam().get("menurights1");
        if(roleId!=null && !roleId.equals("") && menuIds!=null && !menuIds.equals("")){
            //roleMenuRelationService.deleteAllRoleMenuRelationByRoleId(roleId);
            String[] splitMessages = menuIds.split("\\|");
            List<RoleMenuRelation> menuIdList=new ArrayList<RoleMenuRelation>();
            int i=0;
            for(String splitMessage:splitMessages){
                String[] splitMenuIdMessage = splitMessage.split(",");
                    RoleMenuRelation roleMenuRelation=new RoleMenuRelation();
                    roleMenuRelation.setMenuId(splitMenuIdMessage[0]);
                    roleMenuRelation.setMenuRoleId(roleId);
                    roleMenuRelation.setFcu(bexParam.getLoginUser().getUserId());
                    roleMenuRelation.setFcd(new Date());
                    roleMenuRelation.setLcu(bexParam.getLoginUser().getUserId());
                    roleMenuRelation.setLcd(new Date());
                    if(splitMenuIdMessage[1].equals("D")){
                        i = roleMenuRelationService.deleteAllRoleMenuRelation(roleMenuRelation);
                    }else if (splitMenuIdMessage[1].equals("A")){
                        menuIdList.add(roleMenuRelation);
                    }
            }
            if(menuIdList!=null && !menuIdList.isEmpty()){
                i=roleMenuRelationService.addMaryMenuForRole(menuIdList);
            }

            if(i>0){
                result.setRetcode("0");
                result.setRetmsg("角色添加菜单成功！");
            }else{
                result.setRetcode("-1");
                result.setRetmsg("角色添加失败！");
            }
        }
        return result;
    }

}
