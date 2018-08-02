package com.msa.security.service;

import com.msa.security.bean.MenuInfo;

import java.util.List;

public interface MenuInfoService {
    /**
     * 查询全部信息的方法
     * @return
     */
    List<MenuInfo> selectAllMenuInfo();

    /**
     * 修改菜单信息的方法
     * @param menuInfo
     * @return
     */
    int  updateMenuInfo(MenuInfo menuInfo);
}
