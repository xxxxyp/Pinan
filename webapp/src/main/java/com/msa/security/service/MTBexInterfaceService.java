package com.msa.security.service;

import com.msa.security.bean.MTBexInterface;

/**
 * Created by Administrator on 2018/4/21.
 */
public interface MTBexInterfaceService {

    /*
    * 根据bexcode查找应执行的类名和方法名
    * */
    public MTBexInterface findMethodAndClassByBexCode(String bexCode);

}
