package com.msa.security.dao;

import com.msa.security.bean.RoleMenuRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
@Mapper
public interface RoleMenuRelationDao {

    public List<RoleMenuRelation> selectRoleMenuRelationByManyRoleId(List role_id_list);

    /**
     * 给角色赋予观看菜单的权限
     * @param roleMenuRelation
     * @return
     */
    int  addRoleMenuRelation(RoleMenuRelation  roleMenuRelation);

    int deleteAllRoleMenuRelation(RoleMenuRelation roleMenuRelation);

    int insertManyRoleMenuRelationForRoleId(List<RoleMenuRelation> roleMenuRelations);

}
