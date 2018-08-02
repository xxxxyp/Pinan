package com.msa.security.service;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserMenuRole;

import java.util.List;
import java.util.Map;

public interface UserMenuRoleService {
    public List<UserMenuRole> selectUserMenuRoleByUserId(String user_id);
    /**
     * 根据用户id来删除用户角色的方法
     * @return
     */
    int  delUserMenuRole(UserMenuRole userMenuRole);

    /**
     * 根据id来查询信息的方法
     * @param userId
     * @return
     */
    List<UserMenuRole>  selectByUserId(String userId);

    /**
     * 赋予用户角色
     * @return
     */
    int giveRoleToUser(List<UserMenuRole> userMenuRoles);

}
