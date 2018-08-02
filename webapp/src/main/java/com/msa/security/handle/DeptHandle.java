package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.security.bean.DeptInfo;
import com.msa.security.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 部门的处理类
 */
@Component
public class DeptHandle {
    @Autowired
    private DeptInfoService deptService;

    /**
     * 根据部门编码来删除信息
     *
     * @param bexParam
     * @return
     */
    public Result delDeptInfo(BexParam bexParam) {
        Result rs = new Result();
        //获取部门编码
        String dpNo = bexParam.getParam().get("deptno");
        //判断下数据库有改编码
        List<Map<String, Object>> deptInfos = deptService.selectDeptInfo(dpNo);
        //判断是否有数据
        if (deptInfos != null) {
            //判断下删除操作结果
            int i = deptService.delDeptInfo(dpNo);
            if (i >= 1) {
                rs.setRetmsg("删除成功");
                rs.setRetcode("0");
            } else {
                rs.setRetmsg("删除失败");
                rs.setRetcode("-1");
            }
        } else {
            rs.setRetmsg("没有改部门编码" + dpNo);
            rs.setRetcode("-1");
        }
        return rs;
    }

    /**
     * 查询一个部门下的全部用户信息
     *
     * @param bexParam
     * @return
     */
    public Result selectDeptInfoAndUserInfoByDeptId(BexParam bexParam) {
        Result rs = new Result();
        //取出部门编码，返回部分部门与用户信息
        String dNo = bexParam.getParam().get("deptno");
        List<Map<String, Object>> dpInfo = deptService.selectDeptInfoAndUserInfoByDeptId(dNo);
        if (dpInfo != null) {
            rs.setRecord(dpInfo);
            rs.setRetmsg("调用部门查询成功");
            rs.setRetcode("0");
        } else {
            rs.setRetmsg("调用部门用户查询失败");
            rs.setRetcode("-1");
        }
        return rs;
    }

    /**
     * 添加部门信息的处理
     *
     * @param bexParam
     * @return
     */
    public Result addDeptInfo(BexParam bexParam) {
        DeptInfo di = new DeptInfo();
        Result rs = new Result();
        String dpNo = bexParam.getParam().get("deptno");
        if(dpNo!=null && !dpNo.equals("")){
            List<Map<String, Object>> deptInfo = deptService.selectDeptInfo(dpNo);
            if (deptInfo != null && !deptInfo.isEmpty()) {
                rs.setRetmsg("部门编号已经存在");
                rs.setRetcode("-1");
            } else {
                String dpName = bexParam.getParam().get("dept_name");
                String enfg = bexParam.getParam().get("enabled_flag");
                String updpNo = bexParam.getParam().get("up_deptno");
                String dpetabbr = bexParam.getParam().get("dept_abbr_name");
                String dtst = bexParam.getParam().get("data_state");
                String arrang = bexParam.getParam().get("arrangement");
                String topdp = bexParam.getParam().get("top_deptno");
                String psdp = bexParam.getParam().get("ps_uni_deptid");
                String pdtp = bexParam.getParam().get("ps_top_deptid");
                di.setDeptno(dpNo);
                di.setDeptName(dpName);
                if (enfg != null && !enfg.equals("")) {
                    di.setEnabledFlag(enfg);
                } else {
                    di.setEnabledFlag(" ");
                }
                if (updpNo != null && !updpNo.equals("")) {
                    di.setUpDeptno(updpNo);
                } else {
                    di.setUpDeptno("0");
                }
                if (dpetabbr != null && !dpetabbr.equals("")) {
                    di.setDeptAbbrName(dpetabbr);
                } else {
                    di.setDeptAbbrName(" ");
                }
                if (dtst != null && !dtst.equals("")) {
                    di.setDataState(dtst);
                } else {
                    di.setDataState(" ");
                }
                if (arrang != null && !arrang.equals("")) {
                    di.setArrangement(arrang);
                } else {
                    di.setArrangement(" ");
                }
                if (topdp != null && !topdp.equals("")) {
                    di.setTopDeptno(topdp);
                } else {
                    di.setTopDeptno(" ");
                }
                if (psdp != null && !psdp.equals("")) {
                    di.setPsUniDeptId(psdp);
                } else {
                    di.setPsUniDeptId(" ");
                }
                if (pdtp != null && !pdtp.equals("")) {
                    di.setPsTopDeptId(pdtp);
                } else {
                    di.setPsTopDeptId(" ");
                }
                di.setLcu(bexParam.getLoginUser().getUserId());
                di.setFcu(bexParam.getLoginUser().getUserId());
                di.setFcd(new Date());
                di.setLcd(new Date());
                int j = deptService.addDeptInfo(di);
                if (j >= 1) {
                    rs.setRetmsg("添加部门信息成功");
                    rs.setRetcode("0");
                } else {
                    rs.setRetmsg("添加部门信息失败");
                    rs.setRetcode("-1");
                }
            }
        }else{
            rs.setRetmsg("调用失败，部门编号为空！");
            rs.setRetcode("-1");
        }

        return rs;
    }

    /**
     * 查询全部的部门信息
     *
     * @return
     */
    public Result selectDept(BexParam bexParam) {
        Result rs = new Result();
        String deptno = bexParam.getParam().get("deptno");
        List<Map<String, Object>> deptInfos = deptService.selectDeptInfo(deptno);
        if (deptInfos != null) {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for(Map<String, Object> deptMap:deptInfos){
                Date lcd_date =(Date) deptMap.get("lcd");
                Date fcd_date =(Date) deptMap.get("fcd");
                deptMap.put("lcd",format.format(lcd_date));
                deptMap.put("fcd",format.format(fcd_date));
            }

            rs.setRecord(deptInfos);
            rs.setRetcode("0");
            rs.setRetmsg("查询全部的部门信息成功");
        } else {
            rs.setRetcode("-1");
            rs.setRetmsg("查询全部的部门信息失败");
        }
        return rs;
    }

    public Result updateDeptInfo(BexParam bexParam) {
        DeptInfo deptInfo = new DeptInfo();
        Result rs = new Result();
        String arrag = bexParam.getParam().get("arrangment");
        String dtst = bexParam.getParam().get("data_state");
        String dpab = bexParam.getParam().get("dept_abbr_name");
        String dpnm = bexParam.getParam().get("dept_name");
        String dpno = bexParam.getParam().get("deptno");
        String enab = bexParam.getParam().get("enableed_flag");
        String fcd = bexParam.getParam().get("fcd");
        String fcu = bexParam.getParam().get("fcu");
        String lcd = bexParam.getParam().get("lcd");
        String lcu = bexParam.getParam().get("lcu");
        String pstp = bexParam.getParam().get("ps_top_deptid");
        String psuni = bexParam.getParam().get("ps_uni_deptid");
        String updeptno = bexParam.getParam().get("up_deptno");
        deptInfo.setArrangement(arrag);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            deptInfo.setLcd(sdf.parse(lcd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            deptInfo.setFcd(sdf.parse(fcd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        deptInfo.setFcu(bexParam.getLoginUser().getUserId());
        deptInfo.setLcu(bexParam.getLoginUser().getUserId());
        if (dtst != null && !dtst.equals("")) {
            deptInfo.setDataState(dtst);
        } else {
            deptInfo.setDataState(" ");
        }
        if (dpab != null && !dpab.equals("")) {
            deptInfo.setDeptAbbrName(dpab);
        } else {
            deptInfo.setDeptAbbrName(" ");
        }
        if (dpnm != null && !dpnm.equals("")) {
            deptInfo.setDeptName(dpnm);
        } else {
            deptInfo.setDeptName(" ");
        }
        if (enab != null && !enab.equals("")) {
            deptInfo.setEnabledFlag(enab);
        } else {
            deptInfo.setEnabledFlag(" ");
        }
        if (pstp != null && !pstp.equals("")) {
            deptInfo.setPsTopDeptId(pstp);
        } else {
            deptInfo.setPsTopDeptId(" ");
        }
        if (psuni != null && !psuni.equals("")) {
            deptInfo.setPsUniDeptId(psuni);
        } else {
            deptInfo.setPsUniDeptId(" ");
        }


        if (dpno != null && !dpno.equals("")) {
            deptInfo.setDeptno(dpno);
        } else {
            deptInfo.setDeptno(dpno);
        }
        if (fcu != null && !fcu.equals("")) {
            deptInfo.setFcu(fcu);
        } else {
            deptInfo.setFcu(bexParam.getLoginUser().getUserId());
        }
        if (lcu != null && !lcu.equals("")) {
            deptInfo.setLcu(lcu);
        } else {
            deptInfo.setLcu(bexParam.getLoginUser().getUserId());
        }
        if (updeptno != null && !updeptno.equals("")) {
            deptInfo.setUpDeptno(updeptno);
        }else {
            deptInfo.setUpDeptno("0");
        }
        if (pstp != null && !pstp.equals("")) {
            deptInfo.setPsTopDeptId(pstp);
        } else {
            deptInfo.setPsTopDeptId(" ");
        }

        int i = deptService.updateDeptInfo(deptInfo);
        if (i >= 1) {
            rs.setRetcode("0");
            rs.setRetmsg("修改成功");
        } else {
            rs.setRetmsg("修改失败");
            rs.setRetcode("-1");
        }
        return rs;
    }
}

