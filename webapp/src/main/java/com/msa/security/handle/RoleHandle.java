package com.msa.security.handle;

import com.msa.core.bean.BexParam;
import com.msa.core.bean.Result;
import com.msa.security.bean.MenuInfo;
import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserMenuRole;
import com.msa.security.service.MenuRoleService;
import com.msa.security.service.UserMenuRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色处理模块
 */
@Component
public class RoleHandle {
    @Autowired
    private MenuRoleService menuRoleService;
    @Autowired
    private UserMenuRoleService userMenuRoleService;
    private Logger logger = LoggerFactory.getLogger(RoleHandle.class);

    /**
     * 根据用户Id来删除角色信息
     *
     * @param bexParam
     * @return
     */
    public Result delMenuRoleById(BexParam bexParam) {
        Result rs = new Result();
        //获取用户Id
        String mnRoleId = bexParam.getParam().get("menuRoleId");
        //先判断一下数据库是否存在此角色编码
        List<MenuRole> menuRoles = menuRoleService.selectByMenuRoleId(mnRoleId);
        if (menuRoles != null && !menuRoles.isEmpty()) {
            //执行删除方法
            int i = menuRoleService.delMenuRoleById(mnRoleId);
            if (i >= 1) {
                rs.setRetmsg("删除成功");
                rs.setRetcode("0");
            } else {
                rs.setRetmsg("删除失败");
                rs.setRetcode("-1");
            }
        } else {
            rs.setRetmsg("该角色编码不存在");
            rs.setRetcode("-1");
        }
        return rs;
    }

    /**
     * 修改角色信息的处理
     *
     * @param bexParam
     * @return
     */
    public Result updateMenuRole(BexParam bexParam) {
        MenuRole mnRole = new MenuRole();
        Result rs = new Result();
        //获取各个的值然后再来进行处理
        String mnRoleId = bexParam.getParam().get("menuRoleId");
        String subId = bexParam.getParam().get("subsystemId");
        String decpt = bexParam.getParam().get("description");
        String arrange = bexParam.getParam().get("arrangement");
        //将获取的值传入到MenuRole类中
        boolean b=true;
        if(mnRoleId==null || mnRoleId.equals("")){
            b=false;
            rs.setRetmsg("角色编号不能为空");
            rs.setRetcode("-1");
        }else if(decpt==null || decpt.equals("")){
            b=false;
            rs.setRetmsg("角色名称不能为空");
            rs.setRetcode("-1");
        }
        if(b){
            mnRole.setMenuRoleId(mnRoleId);
            mnRole.setSubsystemId(subId);
            mnRole.setDescription(decpt);
            mnRole.setArrangement(arrange);
            mnRole.setLcd(new Date());
            mnRole.setLcu(bexParam.getLoginUser().getUserId());
            int i = menuRoleService.updateMenuRole(mnRole);
            if (i >= 1) {
                rs.setRetmsg("修改信息成功");
                rs.setRetcode("0");
            } else {
                rs.setRetmsg("修改信息失败");
                rs.setRetcode("-1");
            }
        }

        return rs;
    }

   /* */

    /**
     * 添加角色信息的处理
     * @param bexParam
     * @return
     */
    public Result addMenuRole(BexParam bexParam) {
        Result rs = new Result();
        MenuRole mnRole = new MenuRole();
        String mnRoleId = bexParam.getParam().get("menuRoleId");
        String subId = bexParam.getParam().get("subsystemId");
        String decpt = bexParam.getParam().get("description");
        String arrange = bexParam.getParam().get("arrangement");
        String dataSt = bexParam.getParam().get("dataState");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        boolean b=true;
        if(mnRoleId==null || mnRoleId.equals("")){
            rs.setRetmsg("角色编码不能为空！");
            rs.setRetcode("-1");
            b=false;
        }else if(decpt== null || decpt.equals("")){
            rs.setRetmsg("角色名称不能为空！");
            rs.setRetcode("-1");
            b=false;
        }
        if(b){
            List<MenuRole> menuRoles = menuRoleService.selectByMenuRoleId(mnRoleId);
            if(menuRoles ==null || menuRoles.isEmpty()){
                mnRole.setMenuRoleId(mnRoleId);
                mnRole.setSubsystemId(subId);
                mnRole.setDescription(decpt);
                mnRole.setFcu(bexParam.getLoginUser().getUserId());
                mnRole.setLcu(bexParam.getLoginUser().getUserId());
                mnRole.setArrangement(arrange);
                mnRole.setFcd(new Date());
                mnRole.setLcd(new Date());
                mnRole.setDataState(dataSt);
                int j = menuRoleService.addMenuRole(mnRole);
                if (j >= 1) {
                    rs.setRetmsg("添加角色成功！");
                    rs.setRetcode("0");
                } else {
                    rs.setRetmsg("添加角色失败！");
                    rs.setRetcode("-1");
                }
            }else{
                rs.setRetmsg("角色已经存在！");
                rs.setRetcode("-1");
            }
        }

        return rs;
    }

    /**
     * 查看全部的角色与用户的信息的处理
     * @return
     */
    public Result selectAllRoleAndUser() {
        Result rs = new Result();
        List<Map<String, Object>> maps = menuRoleService.selectAllRoleAndUser();
        if (maps != null) {
            rs.setRecord(maps);
        } else {
            rs.setRetcode("-1");
            rs.setRetmsg("查询用户和角色失败");
        }
        return rs;
    }

    /**
     * 查询一个角色下的多个用户
     * @param bexParam
     * @return
     */
    public Result selectAllUserByRoleId(BexParam bexParam) {
        Result rs = new Result();
        //先获取到角色编码
        String mnRoleId = bexParam.getParam().get("menuRoleId");
        List<Map<String, Object>> maps = menuRoleService.selectAllUserByRoleId(mnRoleId);
        if (maps != null) {
            rs.setRetmsg("查询角色用户成功");
            rs.setRetcode("0");
            rs.setRecord(maps);
        } else {
            rs.setRetcode("-1");
            rs.setRetmsg("查询角色用户失败");
        }
        return rs;
    }

    /**
     * 查询一个用户下的角色信息
     * @param bexParam
     * @return
     */
    public  Result  selectAnUserRole(BexParam  bexParam){
        Result  rs=new Result();
        //获取用户id
        String usId= bexParam.getParam().get("userId");
        //执行查询操作
        List<MenuRole> menuRoles = menuRoleService.selectMenuRoleByUserId(usId);
        if(menuRoles!=null){
            rs.setRecord(menuRoles);
            rs.setRetmsg("查询用户角色信息成功");
            rs.setRetcode("0");
        }else{
            rs.setRetmsg("查询用户角色信息失败");
            rs.setRetcode("-1");
        }
        return   rs;
    }
    public Result findAllRole(BexParam  bexParam){
        Result result=new Result();
        String menuroleid = bexParam.getParam().get("menuroleid");
        String description= bexParam.getParam().get("description");
        MenuRole menuRole=new MenuRole();
        menuRole.setMenuRoleId(menuroleid);
        menuRole.setDescription(description);
        List<MenuRole> menuRoles = menuRoleService.selectAllRoles(menuRole);
        if(menuRoles!=null && !menuRoles.isEmpty()){
            result.setRecord(menuRoles);
            result.setRetcode("0");
            result.setRetmsg("查询全部角色成功！");
        }else{
            result.setRetcode("-1");
            result.setRetmsg("查询全部角色失败！");
        }

        return result;
    }

    public Result selectUserByRoleId(BexParam bexParam){
        Result result=new Result();
        String menuroleid = bexParam.getParam().get("menuRoleId");
        List<Map<String, Object>> maps = menuRoleService.selectAllUserByRoleId(menuroleid);
        if(maps!=null){
            result.setRecord(maps);
            result.setRetmsg("查询角色用户成功");
            result.setRetcode("0");
        }else{
            result.setRetmsg("查询角色用户失败");
            result.setRetcode("-1");
        }
        return result;
    }

    public Result addMarryUserForRole(BexParam bexParam){
        Result result=new Result();
        String userids = bexParam.getParam().get("userId");
        String menuroleid = bexParam.getParam().get("menuRoleId");
        if(userids!=null && menuroleid!=null){
            UserMenuRole userMenuRole_delete=new UserMenuRole();
            userMenuRole_delete.setMenuRoleId(menuroleid);
            int i1=userMenuRoleService.delUserMenuRole(userMenuRole_delete);
            //String[] splitMessages = userids.split("\\|");
            String[] splitUserId = userids.split(",");
            List<UserMenuRole> userMenuRoleList=new ArrayList<UserMenuRole>();
            for(String userId:splitUserId){
                //String[] splitUserIdMessage = splitMessage.split(",");
                    UserMenuRole userMenuRole=new UserMenuRole();
                    userMenuRole.setMenuRoleId(menuroleid);
                    userMenuRole.setUserId(userId);
                    userMenuRole.setFcu(bexParam.getLoginUser().getUserId());
                    userMenuRole.setLcu(bexParam.getLoginUser().getUserId());
                    userMenuRole.setFcd(new Date());
                    userMenuRole.setLcd(new Date());
                    userMenuRoleList.add(userMenuRole);
            }
            int i = userMenuRoleService.giveRoleToUser(userMenuRoleList);
            if(i>0){
                result.setRetcode("0");
                result.setRetmsg("为用户分配角色成功！");
            }else{
                result.setRetcode("-1");
                result.setRetmsg("为用户分配角色失败！");
            }
        }

        return result;
    }

    public Result selectAllMenuByRoleId(BexParam bexParam) {
        Result result = new Result();
        String menuroleid = bexParam.getParam().get("menuRoleId");
        if(menuroleid!=null){
            List<Map<String, String>> allMenuByRoleId = menuRoleService.findAllMenuByRoleId(menuroleid);
            logger.debug("------------allMenuByRoleId:"+allMenuByRoleId);
            for (Map MenuByRole:allMenuByRoleId) {
                logger.debug("------------position:" + MenuByRole.get("menuposition"));
                String menuPosition = (String) MenuByRole.get("menuposition");
                if (menuPosition.length() <= 1) {
                    MenuByRole.put("parentmenuid", "1");
                }
                if (menuPosition.length() >= 2) {
                    String position = menuPosition.substring(0, menuPosition.length() - 1);
                    boolean b = false;
                    for (int i = 0; i < allMenuByRoleId.size(); i++) {
                        Map MenuByRole123 = allMenuByRoleId.get(i);
                        if (MenuByRole123.get("menuposition").equals(position)) {
                            MenuByRole.put("parentmenuid", MenuByRole.get("menuid"));
                            b = true;
                        }
                    }
                    if (!b) {
                        MenuByRole.put("parentmenuid", "1");
                    }

                }
            }
            result.setRecord(allMenuByRoleId);
            result.setRetmsg("查询角色菜单成功！");
            result.setRetcode("0");
        }else{
            result.setRetmsg("查询角色菜单失败！");
            result.setRetcode("-1");
        }
        logger.debug("------------result:" + result);
        return result;
    }


}
