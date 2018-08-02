package com.msa.security.service.impl;

import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.dao.MenuRoleDao;
import com.msa.security.dao.UserMenuRoleDao;
import com.msa.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private MenuRoleDao menuRoleDao;
    @Autowired
    private UserMenuRoleDao userMenuRoleDao;

    public List<MenuRole> findRoleByUserId(String user_id){

        List<UserMenuRole> userMenuRoleBeens=userMenuRoleDao.selectUserMenuRoleByUserId(user_id);
        if(userMenuRoleBeens!=null && !userMenuRoleBeens.isEmpty()){
            List<String> role_id_list=new ArrayList<String>();
            for(UserMenuRole userMenuRoleBean:userMenuRoleBeens){
                String menu_role_id=userMenuRoleBean.getMenuRoleId();
                role_id_list.add(menu_role_id);
            }
            List<MenuRole> menuRoleBeens = menuRoleDao.selectRoleByManyRoleId(role_id_list);
            return menuRoleBeens;
        }
        return null;
    }

}
