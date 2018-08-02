package com.msa.security.dao;

import com.msa.security.bean.DeptInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18.
 */
@Mapper
public interface DeptInfoDao {
    /**
     * 新增部门信息方法
     * @param dept
     * @return
     */
    int  addDeptInfo(DeptInfo  dept);

    /**
     * 修改部门信息的方法
     * @param dept
     * @return
     */
    int  updateDeptInfo(DeptInfo dept);

    /**
     * 根据部门编号删除部门信息方法
     * @param
     * @return
     */
    int  delDeptInfo(String deptno);
    /**
     *查询一个部门下的全部用户信息
     * @return
     */
    List<Map<String,Object>>   selectDeptInfoAndUserInfoByDeptId(@Param("deptno") String  deptno);

    /**
     * 查询一个用户信息
     * @param map
     * @return
     */
    List<Map<String,Object>>  selectUser(Map<String,Object> map);

    /**
     * 查询所有的部门信息
     * @return
     */
    List<Map<String,Object>>  selectDeptInfo(@Param("deptno") String deptno);
}
