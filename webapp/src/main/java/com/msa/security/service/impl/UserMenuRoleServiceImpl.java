package com.msa.security.service.impl;

import com.msa.security.bean.UserMenuRole;
import com.msa.security.dao.UserMenuRoleDao;
import com.msa.security.service.UserMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
@Service
public class UserMenuRoleServiceImpl implements UserMenuRoleService{

    @Autowired
    UserMenuRoleDao userMenuRoleDao;

    @Override
    public List<UserMenuRole> selectUserMenuRoleByUserId(String user_id) {
        return null;
    }

    @Override
    public int delUserMenuRole(UserMenuRole userMenuRole) {
        return userMenuRoleDao.delUserMenuRole(userMenuRole);
    }

    @Override
    public List<UserMenuRole> selectByUserId(String userId) {
        return null;
    }

    @Override
    public int giveRoleToUser(List<UserMenuRole> userMenuRoles) {

        return userMenuRoleDao.updateUserMenuRole(userMenuRoles);
    }
}
