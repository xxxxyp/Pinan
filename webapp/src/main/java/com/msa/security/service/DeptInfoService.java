package com.msa.security.service;

import com.msa.security.bean.DeptInfo;
import java.util.List;
import java.util.Map;

public interface DeptInfoService {
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
    List<Map<String,Object>>   selectDeptInfoAndUserInfoByDeptId(String  Deptno);

    /**
     * 查询所有的部门信息
     * @return
     */
    List<Map<String,Object>>  selectDeptInfo(String deptno);
}
