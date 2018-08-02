package com.msa.security.dao;

import com.msa.security.bean.MenuInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18.
 */
@Mapper
public interface MenuInfoDao {

    public MenuInfo selectMenuInfoByOneMenuId(MenuInfo MenuInfoBean);

    public List<MenuInfo> selectMenuInfoByManyMenuId(List menu_id_list);
    /**
     * 查询全部菜单信息的方法
     * @return
     */
    List<MenuInfo>  selectAllMenuInfo();
    /**
     * 修改菜单信息的方法
     * @param menuInfo
     * @return
     */
    int  updateMenuInfo(MenuInfo menuInfo);

    List<Map<String, String>> selectAllMenuAndShowRoleHad(String roleId);
}
