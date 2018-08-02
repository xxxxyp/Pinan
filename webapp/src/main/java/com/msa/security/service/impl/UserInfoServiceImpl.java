package com.msa.security.service.impl;

import com.msa.security.bean.UserInfo;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.dao.UserInfoDao;
import com.msa.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl  implements UserInfoService{
    @Autowired
    private UserInfoDao userDao;
    public UserInfo selectUserInfoByName(String user_name) {
        return  userDao.selectUserInfoByName(user_name);
    }

    public UserInfo selectUserInfoById(String userId) {
        return userDao.selectUserInfoById(userId);
    }

    public int addUser(UserInfo user) {
        return userDao.addUser(user);
    }

    public int delUserById(String userId) {
        return userDao.delUserById(userId);
    }

    public int delUserMenuRoleByIds(List<String> userIds) {
        return userDao.delUserMenuRoleByIds(userIds);
    }

    public int updateUser(UserInfo user) {
        return userDao.updateUser(user);
    }

    public List<Map<String, Object>> selectDeptAndUser(String userId) {
        return userDao.selectDeptAndUser(userId);
    }

    public UserInfo selectByUserId(String userId) {
        return userDao.selectUserInfoById(userId);
    }

    public List<Map<String, Object>> selectRoleAndUser(String userId) {
        return  userDao.selectRoleAndUser(userId);
    }

    public int addUserMenuRole(List<UserMenuRole> userMenuRole) {
        return  userDao.addUserMenuRole(userMenuRole);
    }

    public List<UserInfo> selectInfo() {
        return userDao.selectInfo();
    }

    public UserInfo selectLoginUser(String userId) {
        return  userDao.selectLoginUser(userId);
    }

    public List<Map<String, Object>> selectUserAndRoleInfo() {
        return  userDao.selectUserAndRoleInfo();
    }

    @Override
    public List<Map<String, Object>> selectAll(Map<String, Object> map) {
        return  userDao.selectAll(map);
    }

}
