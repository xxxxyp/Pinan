package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.security.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestHandle {

    public Result testSelect(BexParam bexParam){
        //String username=bexParam.getParam().get("username");
        //a=userInfoDao.selectUserInfoByUserNameAndPassword();
        Result result=new Result();
        result.setRetcode("0");
        result.setRetmsg("服务调用成功");
        Map m=new HashMap();
        m.put("message","成功！");
        result.getRecord().add(m);
        return result;
    }

    public String test001(){

        return "测试成功！！！！！！！";
    }

}
