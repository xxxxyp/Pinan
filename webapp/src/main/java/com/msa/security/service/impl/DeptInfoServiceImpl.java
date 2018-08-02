package com.msa.security.service.impl;

import com.msa.security.bean.DeptInfo;
import com.msa.security.dao.DeptInfoDao;
import com.msa.security.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class DeptInfoServiceImpl  implements DeptInfoService {
    @Autowired
    private DeptInfoDao   deptDao;


    public int addDeptInfo(DeptInfo dept) {
        return deptDao.addDeptInfo(dept);
    }

    public int updateDeptInfo(DeptInfo dept) {
        return  deptDao.updateDeptInfo(dept);
    }

    public int delDeptInfo(String deptno) {
        return   deptDao.delDeptInfo(deptno);
    }

    public List<Map<String, Object>> selectDeptInfoAndUserInfoByDeptId(String Deptno) {
        return  deptDao.selectDeptInfoAndUserInfoByDeptId(Deptno);
    }
    public List<Map<String,Object>> selectDeptInfo(String deptno) {
        return  deptDao.selectDeptInfo(deptno);
    }
}
