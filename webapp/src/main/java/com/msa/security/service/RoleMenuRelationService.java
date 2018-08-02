package com.msa.security.service;

import com.msa.security.bean.RoleMenuRelation;

import java.util.List;

/**
 * 给角色赋予菜单的权限
 */
public interface RoleMenuRelationService {
    public List<RoleMenuRelation> selectRoleMenuRelationByManyRoleId(List role_id_list);

    /**
     * 给角色赋予观看菜单的权限
     * @param roleMenuRelation
     * @return
     */
    int  addRoleMenuRelation(RoleMenuRelation  roleMenuRelation);

    int deleteAllRoleMenuRelation(RoleMenuRelation roleMenuRelation);

    int addMaryMenuForRole(List<RoleMenuRelation> roleMenuRelations);

}
