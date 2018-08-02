package com.msa.security.service.impl;

import com.msa.security.bean.MTBexInterface;
import com.msa.security.dao.MTBexInterfaceDao;
import com.msa.security.service.MTBexInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/21.
 */
@Service
public class MTBexInterfaceServiceImpl implements MTBexInterfaceService{

    @Autowired
    private MTBexInterfaceDao mtBexInterfaceDao;

    public MTBexInterface findMethodAndClassByBexCode(String bexCode){

        return mtBexInterfaceDao.selectMTBexInterfaceByBexCode(bexCode);
    }

}
