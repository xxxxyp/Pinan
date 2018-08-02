package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.encoder.MD5PasswordEncoder;
import com.msa.security.bean.UserInfo;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.dao.UserInfoDao;
import com.msa.security.dao.UserMenuRoleDao;
import com.msa.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 处理用户的类
 */
@Component
public class UserHandle {
    //自动注入一个UserInfo的dao层
    @Autowired
    private UserInfoService userInfoService;
    //注入一个用户与角色dao层，方便角色分配前对先删除用户id，再插入数据
    @Autowired
    private UserMenuRoleDao userRoleDao;

    /**
     * 根据用户id删除信息
     *
     * @param
     * @return
     */
    public Result delUserById(BexParam bexParam) {
        //从入参中获取用户Id
        String usId = bexParam.getParam().get("userId");
        //判断用户是否存在
        UserInfo userInfo = userInfoService.selectByUserId(usId);
        Result rs = new Result();
        if (userInfo != null) {
            //执行根据用户id删除方法
            int i = userInfoService.delUserById(usId);
            if (i == 1) {
                rs.setRetcode("0");
                rs.setRetmsg("删除成功");
            } else {
                rs.setRetcode("-1");
                rs.setRetmsg("删除失败");
            }
        } else {
            rs.setRetmsg("-1");
            rs.setRetmsg("不存在该用户Id" + usId);
        }
        //返回result类
        return rs;
    }

    /***
     * 根据Id来修改用户名，密码，部门编号等信息的处理
     *
     * @param
     * @return
     * @throws ParseException
     */
    public Result updateUser(BexParam bexParam) {
        UserInfo ui = new UserInfo();
        Result rs = new Result();
        String usid = bexParam.getParam().get("user_id");
        String ma = bexParam.getParam().get("mail");
        String ustp = bexParam.getParam().get("user_type");
        String das = bexParam.getParam().get("data_state");
        String usnm = bexParam.getParam().get("user_name");
        String updpno = bexParam.getParam().get("up_deptno");
        String mb = bexParam.getParam().get("mobile");
        String vlfg = bexParam.getParam().get("valid_flag");
        String dpno = bexParam.getParam().get("deptno");
        String usps = bexParam.getParam().get("user_position");
        String idcd = bexParam.getParam().get("id_code");
        String tel = bexParam.getParam().get("tel");
        String ext = bexParam.getParam().get("ext");
        String fax = bexParam.getParam().get("fax");
        String uspwd = bexParam.getParam().get("user_pwd");
        ui.setValidFlag(vlfg);
        ui.setUserId(usid);
        ui.setMail(ma);
        ui.setDataState(das);
        ui.setDeptno(dpno);
        ui.setUserName(usnm);
        ui.setUserType(ustp);
        ui.setUserPwd(uspwd);
        ui.setTel(tel);
        ui.setUserPosition(usps);
        ui.setIdCode(idcd);
        ui.setExt(ext);
        ui.setFax(fax);
        ui.setMobile(mb);
        ui.setUpDeptno(updpno);
        UserInfo userInfo = userInfoService.selectByUserId(usid);
        //判断是否有改用户
        if (userInfo == null) {
            rs.setRetmsg("不存在改用户");
        } else {
            int i = userInfoService.updateUser(ui);
            if (i >= 1) {
                rs.setRetcode("0");
                rs.setRetmsg("调用修改服务成功");
            } else {
                rs.setRetcode("-1");
                rs.setRetmsg("调用修改服务失败");
            }
        }
        return rs;
    }

    /**
     * 根据用户Id来查询出所属的部门与用户信息
     *
     * @return
     */
    public Result selectDeptAndUser(BexParam bexParam) {
        //获取用户id
        String usId = bexParam.getParam().get("userId");
        Result rs = new Result();
        //根据用户id来查询出所有的信息
        List<Map<String, Object>> maps = userInfoService.selectDeptAndUser(usId);
        rs.setRecord(maps);
        rs.setRetcode("0");
        rs.setRetmsg("查询用户信息成功");
        return rs;
    }

    /**
     * 根据用户Id查询出角色与用户信息
     *
     * @return
     */
    public Result selectRoleAndUser(BexParam bexParam) {
        String usId = bexParam.getParam().get("userId");
        Result rs = new Result();
        List<Map<String, Object>> maps = userInfoService.selectRoleAndUser(usId);
        rs.setRecord(maps);
        rs.setRetmsg("查询用户与角色成功");
        rs.setRetcode("0");
        return rs;
    }

    /**
     * 添加用户信息的处理
     *
     * @param bexParam
     * @return
     */
    public Result addUser(BexParam bexParam) {
        UserInfo ui = new UserInfo();
        Result rs = new Result();
        String usId = bexParam.getParam().get("user_id");
        String usPwd = bexParam.getParam().get("user_pwd");
        String dpNo = bexParam.getParam().get("deptno");
        UserInfo userInfo = userInfoService.selectUserInfoById(usId);
        if (userInfo != null) {
            rs.setRetcode("-1");
            rs.setRetmsg("用户已经存在！");
        } else {
            String usName = bexParam.getParam().get("user_name");
            String ustp = bexParam.getParam().get("user_type");
            String vafg = bexParam.getParam().get("valid_flag");
            String idcD = bexParam.getParam().get("id_code");
            String fax = bexParam.getParam().get("fax");
            String tel = bexParam.getParam().get("tel");
            String ext = bexParam.getParam().get("ext");
            String mb = bexParam.getParam().get("mobile");
            String ma = bexParam.getParam().get("mail");
            String pldate = bexParam.getParam().get("paic_leave_date");
            String nmPy = bexParam.getParam().get("namepingyin");
            String usPs = bexParam.getParam().get("user_position");
            String pwd = MD5PasswordEncoder.encode(usPwd);
            ui.setUserPwd(pwd);
            ui.setUserId(usId);
            ui.setUserName(usName);
            ui.setDeptno(dpNo);
            if (ustp != null && !ustp.equals("")) {
                ui.setUserType(ustp);
            } else {
                ui.setUserType("  ");
            }
            if (vafg != null && !vafg.equals("")) {
                ui.setValidFlag(vafg);
            } else {
                ui.setValidFlag(" ");
            }
            if (idcD != null && !idcD.equals("")) {
                ui.setIdCode(idcD);
            } else {
                ui.setIdCode(" ");
            }
            if (fax != null && !fax.equals("")) {
                ui.setFax(fax);
            } else {
                ui.setFax(" ");
            }
            if (tel != null && !tel.equals("")) {
                ui.setTel(tel);
            } else {
                ui.setTel(" ");
            }
            if (ma != null && !ma.equals("")) {
                ui.setMail(ma);
            } else {
                ui.setMail(" ");
            }
            if (mb != null && !mb.equals("")) {
                ui.setMobile(mb);
            } else {
                ui.setMobile(" ");
            }
            if (ext != null && !ext.equals("")) {
                ui.setExt(ext);
            } else {
                ui.setExt(" ");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                ui.setPaicLeaveDate(sdf.parse(pldate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (usPs != null && !usPs.equals("")) {
                ui.setUserPosition(usPs);
            } else {
                ui.setUserPosition(" ");
            }
            ui.setFcu(bexParam.getLoginUser().getUserId());
            try {
                ui.setFcd(new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ui.setLcu(bexParam.getLoginUser().getUserId());
            try {
                ui.setLcd(new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ui.setPaicLeaveDate(new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ui.setDataState("1");
            ui.setUpDeptno("1");
            if (nmPy != null && !nmPy.equals("")) {
                ui.setNamePingyin(nmPy);
            } else {
                ui.setNamePingyin(" ");
            }
            int j = userInfoService.addUser(ui);
            if (j == 1) {
                rs.setRetcode("0");
                rs.setRetmsg("添加用户成功");
            } else {
                rs.setRetcode("-1");
                rs.setRetmsg("添加用户失败");
            }
        }
        return rs;
    }

    /**
     * 用户角色分配
     *
     * @param bexParam
     * @return
     */
    public Result addUserMenuRole(BexParam bexParam) {
        Result rs = new Result();
        //获取到数组元素
        String userid = bexParam.getParam().get("userid");
        String roleId = bexParam.getParam().get("roleid");
        List<UserMenuRole> list = new ArrayList<UserMenuRole>();
        UserMenuRole userRole_delete = new UserMenuRole();
        userRole_delete.setUserId(userid);
        userRole_delete.setMenuRoleId(roleId);
        //先删除用户对应的roleid与其余信息，然后在插入信息
        int j = userRoleDao.delUserMenuRole(userRole_delete);
        //时间格式通过返回给前端的时间数据格式为yyyy-MM-dd  HH:mm;ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserMenuRole userRole = new UserMenuRole();
        if (j >= 1) {
            String[] role = roleId.split(",");
            //遍历出所有的roleId,利用userMenuRole设置值
            for (String rl : role) {
                userRole.setUserId(userid);
                userRole.setMenuRoleId(rl);
                try {
                    userRole.setFcd(sdf.parse(new Date().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    userRole.setLcd(sdf.parse(new Date().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                userRole.setFcu(bexParam.getLoginUser().getUserId());
                userRole.setLcu(bexParam.getLoginUser().getUserId());
            }
        } else {
            rs.setRetmsg("删除失败");
            rs.setRetcode("-1");
        }
        list.add(userRole);
        int i = userInfoService.addUserMenuRole(list);
        if (i >= 1) {
            rs.setRetcode("0");
            rs.setRetmsg("批量添加成功");
        } else {
            rs.setRetcode("-1");
            rs.setRetmsg("批量添加失败");
        }
        return rs;
    }

    /**
     * 查询全部的用户信息
     *
     * @return
     */
    public Result selectInfo(BexParam bexParam) {
        Result rs = new Result();
        //执行查询全部用户的操作
        List<UserInfo> userInfos = userInfoService.selectInfo();
        if (userInfos != null) {
            rs.setRecord(userInfos);
            rs.setRetcode("0");
            rs.setRetmsg("查询全部用户信息成功");
        } else {
            rs.setRetcode("-1");
            rs.setRetmsg("查询用户信息失败");
        }
        return rs;
    }

    /**
     * 查询登陆信息的功能
     *
     * @param bexParam
     * @return
     */
    public Result selectLoginUser(BexParam bexParam) {
        Result rs = new Result();
        //获取登陆用户的用户id
        String userId = bexParam.getLoginUser().getUserId();
        //执行查询里面的方法
        UserInfo userInfo = userInfoService.selectLoginUser(userId);
        //new  一个Map对象
        if (userInfo != null) {
            Map<String, Object> map = new HashMap();
            map.put("loginUserInfo", userInfo);
            rs.setExdata(map);
        } else {
            rs.setRetmsg("查询登陆用户信息失败");
            rs.setRetcode("-1");
        }
        return rs;
    }

    public Result selectUserAndRoleInfo() {
        //定义一个出参类
        Result rs = new Result();
        List<Map<String, Object>> maps = userInfoService.selectUserAndRoleInfo();
        if (maps != null) {
            rs.setRecord(maps);
            rs.setRetcode("0");
            rs.setRetmsg("查看角色信息成功");
        } else {
            rs.setRetcode("-1");
            rs.setRetmsg("查看角色信息失败");
        }
        return rs;
    }

    /**
     * 查询一个人的信息
     *
     * @param bexParam
     * @return
     */
    public Result selectAll(BexParam bexParam) {
        Result rs = new Result();
        String usid = bexParam.getParam().get("userid");
        String usnm = bexParam.getParam().get("username");
        String dpno = bexParam.getParam().get("deptno");
        String ustp = bexParam.getParam().get("usertype");
        String vafg = bexParam.getParam().get("validflag");
        Map<String, Object> map = new HashMap();
        map.put("userId", usid);
        map.put("userName", usnm);
        map.put("deptno", dpno);
        map.put("userType", ustp);
        map.put("validFlag", vafg);
        List<Map<String, Object>> maps = userInfoService.selectAll(map);
        System.out.println(maps);
        if (maps != null) {
            rs.setRecord(maps);
            rs.setRetmsg("查询用户信息成功");
            rs.setRetcode("0");
        } else {
            rs.setRetmsg("查询用户信息失败");
            rs.setRetcode("-1");
        }
        return rs;
    }
}




















