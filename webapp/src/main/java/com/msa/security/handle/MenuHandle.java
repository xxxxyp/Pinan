package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.security.bean.MenuInfo;
import com.msa.security.bean.MenuInfoView;
import com.msa.security.service.MenuService;
import com.msa.security.shiro.domain.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/24.
 */
@Component
public class MenuHandle {

    @Autowired
    private MenuService menuService;

    public Result findMenuByUserId(BexParam bexParam) {
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        List<MenuInfo> menuInfos = menuService.findMenuByUserId(user.getUserId());
        List<MenuInfoView> menuInfoViews=new ArrayList<MenuInfoView>();
        for (MenuInfo menuInfo : menuInfos) {
            MenuInfoView menuInfoView=new MenuInfoView();
            if(menuInfo.getMenuPosition().length()<=1){
                menuInfoView.setParentMenuId("1");
            }
            if(menuInfo.getMenuPosition().length()>=2){
                String position = menuInfo.getMenuPosition().substring(0, menuInfo.getMenuPosition().length() - 1);
                boolean b=false;
                for(int i=0;i<menuInfos.size();i++){
                    MenuInfo menuInfo123 = menuInfos.get(i);
                    if(menuInfo123.getMenuPosition().equals(position)){
                        menuInfoView.setParentMenuId(menuInfo123.getMenuId());
                        b=true;
                    }
                }
                if(!b){
                    menuInfoView.setParentMenuId("1");
                }
            }

            menuInfoView.setMenuId(menuInfo.getMenuId());
            menuInfoView.setSubsystemId(menuInfo.getSubsystemId());
            menuInfoView.setDescription(menuInfo.getDescription());
            menuInfoView.setMenuPosition(menuInfo.getMenuPosition());
            menuInfoView.setMenuUrl(menuInfo.getMenuUrl());
            menuInfoView.setMenuType(menuInfo.getMenuType());
            menuInfoView.setDataState(menuInfo.getDataState());
            menuInfoView.setFormSubmitFlag(menuInfo.getFormSubmitFlag());
            //menuInfoView.setParentMenuId(menuInfo.getParentMenuId());
            menuInfoViews.add(menuInfoView);
        }
        if (menuInfoViews != null) {
            result.setRecord(menuInfoViews);
            result.setRetmsg("服务调用成功！");
            result.setRetcode("0");
        }
        return result;
    }
    public Result findMenuByMenuId(BexParam bexParam) {
        Result result=new Result();
        String menuid = bexParam.getParam().get("menuid");
        if(menuid!=null){
            MenuInfo menuInfo = menuService.findMenuByMenuId(menuid);
            if(menuInfo!=null){
                result.getRecord().add(menuInfo);
                result.setRetmsg("服务调用成功！");
                result.setRetcode("0");
            }
        }

        return result;
    }


    public Result findAllMenu(BexParam bexParam) {
        Result result=new Result();
        List<MenuInfo> allMenu = menuService.findAllMenu();
        List<MenuInfoView> menuInfoViews=new ArrayList<MenuInfoView>();
        for (MenuInfo menuInfo : allMenu) {
            MenuInfoView menuInfoView=new MenuInfoView();
            if(menuInfo.getMenuPosition().length()<=1){
                menuInfoView.setParentMenuId("1");
            }
            if(menuInfo.getMenuPosition().length()>=2){
                String position = menuInfo.getMenuPosition().substring(0, menuInfo.getMenuPosition().length() - 1);
                boolean b=false;
                for(int i=0;i<allMenu.size();i++){
                    MenuInfo menuInfo123 = allMenu.get(i);
                    if(menuInfo123.getMenuPosition().equals(position)){
                        menuInfoView.setParentMenuId(menuInfo123.getMenuId());
                        b=true;
                    }
                }
                if(!b){
                    menuInfoView.setParentMenuId("1");
                }
            }

            menuInfoView.setMenuId(menuInfo.getMenuId());
            menuInfoView.setSubsystemId(menuInfo.getSubsystemId());
            menuInfoView.setDescription(menuInfo.getDescription());
            menuInfoView.setMenuPosition(menuInfo.getMenuPosition());
            menuInfoView.setMenuUrl(menuInfo.getMenuUrl());
            menuInfoView.setMenuType(menuInfo.getMenuType());
            menuInfoView.setDataState(menuInfo.getDataState());
            menuInfoView.setFormSubmitFlag(menuInfo.getFormSubmitFlag());
            //menuInfoView.setParentMenuId(menuInfo.getParentMenuId());
            menuInfoViews.add(menuInfoView);
        }
        if (menuInfoViews != null) {
            result.setRecord(menuInfoViews);
            result.setRetmsg("查询所有菜单成功！");
            result.setRetcode("0");
        }
        return result;
    }

    public Result findAllMenuAndShowRoleHad(BexParam bexParam) {
        Result result=new Result();
        String menuroleid = bexParam.getParam().get("menuRoleId");
        if(menuroleid!=null){
            List<Map<String, String>> allMenuAndShowRoleHad = menuService.findAllMenuAndShowRoleHad(menuroleid);
            for (Map MenuByRole:allMenuAndShowRoleHad) {
                String menuPosition = (String) MenuByRole.get("menuposition");
                if (menuPosition.length() <= 1) {
                    MenuByRole.put("parentmenuid", "1");
                }
                if (menuPosition.length() >= 2) {
                    String position = menuPosition.substring(0, menuPosition.length() - 1);
                    boolean b = false;
                    for (int i = 0; i < allMenuAndShowRoleHad.size(); i++) {
                        Map MenuByRole123 = allMenuAndShowRoleHad.get(i);
                        if (MenuByRole123.get("menuposition").equals(position)) {
                            MenuByRole.put("parentmenuid", MenuByRole.get("menuid"));
                            b = true;
                        }
                    }
                    if (!b) {
                        MenuByRole.put("parentmenuid", "1");
                    }

                }
            }
            result.setRecord(allMenuAndShowRoleHad);
            result.setRetmsg("查询菜单成功！");
            result.setRetcode("0");
        }else{
            result.setRetmsg("查询菜单失败！");
            result.setRetcode("-1");
        }



        return result;
    }

}
