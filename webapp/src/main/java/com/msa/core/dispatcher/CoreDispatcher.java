package com.msa.core.dispatcher;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.BexResult;
import com.msa.core.bean.Result;
import com.msa.security.bean.MTBexInterface;
import com.msa.security.service.MTBexInterfaceService;
import com.msa.security.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/4/20.
 */
@Component
public class CoreDispatcher {

    @Autowired
    private MTBexInterfaceService mtBexInterfaceService;

    public BexResult doDispatcher(BexParam bexParam){
        BexResult bexResult=new BexResult();
        //根据bexcode查找对应的class和Method
        MTBexInterface methodAndClassById = mtBexInterfaceService.findMethodAndClassByBexCode(bexParam.getObj_code());
        if(methodAndClassById!=null){
            //使用sping工具类，获取实体类
            Object classBean = SpringUtil.getBean(methodAndClassById.getAttr2());
            try {
                Class<?> aClass = classBean.getClass();
                //获取实体类对应的方法
                Method method = aClass.getMethod(methodAndClassById.getAttr1(),BexParam.class);
                Result results =(Result) method.invoke(SpringUtil.getBean(aClass),bexParam);
                if(results!=null){
                    bexResult.setFlag(results.getRetcode());
                    bexResult.setPrompt(results.getRetmsg());
                    bexResult.getResults().add(results);
                }else{
                    bexResult.setFlag("-1");
                    bexResult.setPrompt("服务调用失败");
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }  catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return bexResult;
    }

}
