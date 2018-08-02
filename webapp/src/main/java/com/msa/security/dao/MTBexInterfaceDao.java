package com.msa.security.dao;

import com.msa.security.bean.MTBexInterface;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/4/21.
 */
@Mapper
public interface MTBexInterfaceDao {
    public MTBexInterface selectMTBexInterfaceByBexCode(@Param("bexCode")String bexCode);
}
