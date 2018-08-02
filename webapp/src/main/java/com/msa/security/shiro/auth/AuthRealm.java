package com.msa.security.shiro.auth;

import com.msa.security.bean.MenuInfo;
import com.msa.security.bean.MenuRole;
import com.msa.security.bean.UserInfo;
import com.msa.security.service.MenuService;
import com.msa.security.service.RoleService;
import com.msa.security.service.UserService;
import com.msa.security.shiro.domain.User;
import com.msa.security.shiro.token.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AuthRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(AuthRealm.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserToken token = (UserToken) authenticationToken;
        logger.debug("验证当前Subject时获取到token为：" + token.toString());
        //查出是否有此用户
        UserInfo userInfo = userService.findUserById(token.getUsername());

            if (userInfo != null) {
            User user = new User();
            user.setUserId(token.getUsername());
            user.setUserName(userInfo.getUserName());
            user.setUserPwd(userInfo.getUserPwd());
            user.setMail(userInfo.getMail());
            user.setMobile(userInfo.getMobile());
            user.setDeptno(userInfo.getDeptno());
            //TODO:待处理用户所属部门信息
            user.setDeptName("");

            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user,
                    user.getUserPwd(),
//                    ByteSource.Util.bytes(getName()),
                    getName()
            );
            return authenticationInfo;
        } else {
            throw new AccountException("帐号或密码不正确！");
        }
    }

    /**
     * 权限认证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            //用户的角色集合
            List<MenuRole> userMenuRoles = roleService.findRoleByUserId(user.getUserId());
            if (userMenuRoles != null) {
                List<String> roleIds = new ArrayList<String>();
                for (MenuRole menuRole : userMenuRoles) {
                    roleIds.add(menuRole.getMenuRoleId());
                }
                info.addRoles(roleIds);
            }

            //用户的权限集合
            List<MenuInfo> userMenus = menuService.findMenuByUserId(user.getUserId());
            if (userMenus != null) {
                List<String> menuIds = new ArrayList<String>();
                for (MenuInfo userMenu : userMenus) {
                    menuIds.add(userMenu.getMenuId());
                }
                info.addStringPermissions(menuIds);
            }
            return info;
        }
        return null;
    }

    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
