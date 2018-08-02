package com.msa.security.dao;

import com.msa.security.bean.UserMenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
@Mapper
public interface UserMenuRoleDao {
    public List<UserMenuRole> selectUserMenuRoleByUserId(String user_id);
    /**
     * 根据用户id来删除用户角色的方法
     * @param userId
     * @return
     */
    int  delUserMenuRole(UserMenuRole userMenuRole);

    /**
     * 根据角色id来删除用户角色的方法
     * @return
     */
    int delUserMenuRoleByRoleId(String roleId);
    /**
     * 修改用户角色的方法
     * @return
     */
    int  updateUserMenuRole(List<UserMenuRole> userMenuRoles);
    /**
     * 根据id来查询信息的方法
     * @param userId
     * @return
     */
    List<UserMenuRole>  selectByUserId(String userId);

    int delUserMenuRoleByRoleIdAndUserId(@Param("roleId") String roleId,@Param("userId") String userId);
}
