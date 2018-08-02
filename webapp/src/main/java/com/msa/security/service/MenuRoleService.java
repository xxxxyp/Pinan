package com.msa.security.service;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.RoleMenuRelation;
import com.msa.security.bean.UserMenuRole;

import java.util.List;
import java.util.Map;

public interface MenuRoleService {
    /**
     * 新增角色的方法
     * @param menuRole
     * @return
     */
    int  addMenuRole(MenuRole menuRole);

    /**
     * 修改角色的方法
     * @param menuRole
     * @return
     */
    int  updateMenuRole(MenuRole menuRole);
    /**
     * 根据id来删除角色信息的方法
     * @param menuRoleId
     * @return
     */
    int  delMenuRoleById(String menuRoleId);
    /**
     * 根据角色id来查询出数据库中有无
     * @param menuRoleId
     * @return
     */
    List<MenuRole> selectByMenuRoleId(String  menuRoleId);
    /**
     * 查询出所有的角色与用户
     * @return
     */
    List<Map<String,Object>>  selectAllRoleAndUser();
    /**
     * 查询出一个角色下的所有用户
     */
    List<Map<String,Object>> selectAllUserByRoleId(String  menuRoleId);

    /**
     * 查询一个用户的多个角色
     * @param userId
     * @return
     */
    List<MenuRole> selectMenuRoleByUserId(String userId);

    /**
     * 查询全部的角色
     */
    List<MenuRole> selectAllRoles(MenuRole menuRole);

    int giveRoleToUser(List<UserMenuRole> userMenuRoles);

    List<Map<String,String>> findAllMenuByRoleId(String roleid);

}
