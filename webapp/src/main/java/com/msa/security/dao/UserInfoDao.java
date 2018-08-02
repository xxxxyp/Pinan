package com.msa.security.dao;

import com.msa.security.bean.UserInfo;
import com.msa.security.bean.UserMenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18.
 */
@Mapper
public interface UserInfoDao {
    public UserInfo selectUserInfoByName(@Param("userName") String user_name);
    public UserInfo selectUserInfoById(@Param("userId")String userId);
    /**
     *添加用户信息的方法
     * @param user
     * @return
     */
    int addUser(UserInfo  user);
    /**
     * 根据用户id来删除用户信息
     * @param userId
     * @return
     */
    int  delUserById(String userId);

    /**
     * 批量删除角色与用户表的信息
     * @param userIds
     * @return
     */
    int  delUserMenuRoleByIds(List<String> userIds);
    /**
     * 修改用户信息(不包括修改用户密码)
     * @param user
     * @return
     */
    int  updateUser(UserInfo  user);
    /**
     * 根据用户的id来查询部门信息的方法
     * @param
     * @return
     */
    List<Map<String, Object>> selectDeptAndUser(String userId);
    /**
     * 查询所有用户所属的角色与用户信息
     * @param
     * @return
     */
    List<Map<String, Object>> selectRoleAndUser(String  userId);
    /**
     * 批量添加用户角色分配
     * @param userMenuRole
     * @return
     */
     int addUserMenuRole(List<UserMenuRole>  userMenuRole);

    /**
     * 查询出所有的用户信息
     * @return
     */
    List<UserInfo>  selectInfo();

    /**
     * 查询用户登陆信息
     * @param userId
     * @return
     */
    UserInfo   selectLoginUser(String  userId);

    /**
     * 查询出所有的用户下的全部角色
     * @return
     */
    List<Map<String,Object>> selectUserAndRoleInfo();

    /**
     * 查询用户信息
     * @param map
     * @return
     */
    List<Map<String,Object>> selectAll(Map<String,Object>map);
}
