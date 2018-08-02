package com.msa.security.service;

import com.msa.security.bean.MenuRole;

import java.util.List;

/**
 * 角色操作服务层接口类
 * Created by Administrator on 2018/4/18.
 */
public interface RoleService {

    /*
     * 根据用户ID查找用户对应的角色
     */
    public List<MenuRole> findRoleByUserId(String user_id);
}
