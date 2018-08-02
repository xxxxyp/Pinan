package com.msa.security.service.impl;

import com.msa.security.bean.RoleMenuRelation;
import com.msa.security.dao.RoleMenuRelationDao;
import com.msa.security.service.RoleMenuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuRelationServiceImpl implements RoleMenuRelationService {
    @Autowired
    private RoleMenuRelationDao roleMenuDao;
    public List<RoleMenuRelation> selectRoleMenuRelationByManyRoleId(List role_id_list) {
        return roleMenuDao.selectRoleMenuRelationByManyRoleId(role_id_list);
    }

    public int addRoleMenuRelation(RoleMenuRelation roleMenuRelation) {
        return   roleMenuDao.addRoleMenuRelation(roleMenuRelation);
    }

    @Override
    public int deleteAllRoleMenuRelation(RoleMenuRelation roleMenuRelation) {
        return roleMenuDao.deleteAllRoleMenuRelation(roleMenuRelation);
    }

    @Override
    public int addMaryMenuForRole(List<RoleMenuRelation> roleMenuRelations) {
        return roleMenuDao.insertManyRoleMenuRelationForRoleId(roleMenuRelations);
    }


}
