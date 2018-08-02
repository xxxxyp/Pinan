package com.msa.security.service.impl;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.RoleMenuRelation;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.dao.MenuRoleDao;
import com.msa.security.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuRoleServiceImpl  implements MenuRoleService{
    @Autowired
    private MenuRoleDao  menuDao;

    public int addMenuRole(MenuRole menuRole) {
        return menuDao.addMenuRole(menuRole);
    }

    public int updateMenuRole(MenuRole menuRole) {
        return menuDao.updateMenuRole(menuRole);
    }

    public int delMenuRoleById(String menuRoleId) {
        return   menuDao.delMenuRoleById(menuRoleId);
    }

    public List<MenuRole> selectByMenuRoleId(String menuRoleId) {
        return  menuDao.selectByMenuRoleId(menuRoleId);
    }

    public List<Map<String, Object>> selectAllRoleAndUser() {
        return  menuDao.selectAllRoleAndUser();
    }

    public List<Map<String, Object>> selectAllUserByRoleId(String menuRoleId) {
        return  menuDao.selectAllUserByRoleId(menuRoleId);
    }

    public List<MenuRole> selectMenuRoleByUserId(String userId) {
        return menuDao.selectMenuRoleByUserId(userId);
    }

    public List<MenuRole> selectAllRoles(MenuRole menuRole){

        return menuDao.selectAllRoles(menuRole);
    }

    @Override
    public int giveRoleToUser(List<UserMenuRole> userMenuRoles) {

        menuDao.giveRoleToUser(userMenuRoles);

        return 0;
    }

    @Override
    public List<Map<String, String>> findAllMenuByRoleId(String roleid) {
        return menuDao.findAllMenuByRoleId(roleid);
    }
}