package com.msa.security.service.impl;

import com.msa.security.bean.MenuInfo;
import com.msa.security.bean.RoleMenuRelation;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.dao.MenuInfoDao;
import com.msa.security.dao.RoleMenuRelationDao;
import com.msa.security.dao.UserMenuRoleDao;
import com.msa.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18.
 */
@Service
public class MenuServiceImpl  implements MenuService{

    @Autowired
    private MenuInfoDao menuInfoDao;
    @Autowired
    private UserMenuRoleDao userMenuRoleDao;
    @Autowired
    private RoleMenuRelationDao roleMenuRelationDao;

    public List<MenuInfo> findMenuByUserId(String user_id){
        //根据用户id查找用户对应的角色
        List<UserMenuRole> userMenuRoleBeens=userMenuRoleDao.selectUserMenuRoleByUserId(user_id);
        List<RoleMenuRelation> roleMenuRelationBeens=null;
        List<MenuInfo> menuInfoBeens=null;
        if(userMenuRoleBeens!=null && !userMenuRoleBeens.isEmpty()){
            List<String> role_id_list=new ArrayList<String>();
            for(UserMenuRole userMenuRoleBean:userMenuRoleBeens){
                String menu_role_id=userMenuRoleBean.getMenuRoleId();
                role_id_list.add(menu_role_id);
            }
            //根据角色id查找角色对应的菜单
            roleMenuRelationBeens = roleMenuRelationDao.selectRoleMenuRelationByManyRoleId(role_id_list);
        }

        if(roleMenuRelationBeens!=null && !roleMenuRelationBeens.isEmpty()){
            List<String> menu_id_list=new ArrayList<String>();
            for(RoleMenuRelation roleMenuRelationBeen:roleMenuRelationBeens){
                String menu_id=roleMenuRelationBeen.getMenuId();
                menu_id_list.add(menu_id);
            }
            //根据菜单id查找具体的菜单信息
            menuInfoBeens= menuInfoDao.selectMenuInfoByManyMenuId(menu_id_list);
            return menuInfoBeens;
        }
        return null;
    }

    public MenuInfo findMenuByMenuId(String menuId){
        MenuInfo selectInfo=new MenuInfo();
        selectInfo.setMenuId(menuId);
        MenuInfo menuInfo = menuInfoDao.selectMenuInfoByOneMenuId(selectInfo);
        if(menuInfo!=null){
            return menuInfo;
        }else{
            return null;
        }
    }

    public List<MenuInfo> findAllMenu(){

        return menuInfoDao.selectAllMenuInfo();
    }

    @Override
    public List<Map<String, String>> findAllMenuAndShowRoleHad(String roleId) {

        return menuInfoDao.selectAllMenuAndShowRoleHad(roleId);
    }

}
