package com.msa.security.service.impl;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserInfo;
import com.msa.security.dao.UserInfoDao;
import com.msa.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo findUserByName(String user_name){
        return userInfoDao.selectUserInfoByName(user_name);
    }

    public UserInfo findUserById(String userid){
        return userInfoDao.selectUserInfoById(userid);
    }


}
