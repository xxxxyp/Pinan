package com.msa.security.service.impl;

import com.msa.security.bean.MenuInfo;
import com.msa.security.dao.MenuInfoDao;
import com.msa.security.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuInfoServiceImpl  implements MenuInfoService{
    @Autowired
    private MenuInfoDao  menuInfoDao;

    public List<MenuInfo> selectAllMenuInfo() {
        return menuInfoDao.selectAllMenuInfo();
    }

    public int updateMenuInfo(MenuInfo menuInfo) {
        return menuInfoDao.updateMenuInfo(menuInfo);
    }
}
