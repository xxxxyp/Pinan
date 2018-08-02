package com.msa.security.service;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserInfo;

import java.util.List;

/**
 * 用户操作服务层接口
 * Created by Administrator on 2018/4/18.
 */
public interface UserService {

    /*
     * 根据用户名称查找用户信息
     */
    public UserInfo findUserByName(String user_name);
    public UserInfo findUserById(String user_id);

}
