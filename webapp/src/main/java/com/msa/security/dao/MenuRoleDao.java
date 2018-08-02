package com.msa.security.dao;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserMenuRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18.
 */
@Mapper
public interface MenuRoleDao {

    public List<MenuRole> selectRoleByManyRoleId(List role_id_list);
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
     * 查询所有角色
     * @return
     */
    List<MenuRole> selectAllRoles(MenuRole menuRole);

    /**
     * 为用户添加角色
     * @return
     */
    int giveRoleToUser(List<UserMenuRole> userMenuRoles);

    /**
     * 通过角色id查找菜单
     * @return
     */
    List<Map<String, String>> findAllMenuByRoleId(String roleId);
}
