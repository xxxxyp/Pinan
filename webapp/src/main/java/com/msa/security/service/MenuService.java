package com.msa.security.service;

import com.msa.security.bean.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * 菜单操作服务层接口类
 * Created by Administrator on 2018/4/18.
 */
public interface MenuService {

    /**
     *根据用户ID查找用户能够查看的菜单
     */
    public List<MenuInfo> findMenuByUserId(String userId);

    public MenuInfo findMenuByMenuId(String menuId);

    public List<MenuInfo> findAllMenu();

    public List<Map<String, String>> findAllMenuAndShowRoleHad(String roleId);

}
