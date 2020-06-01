package com.ms.shiro;

import com.ms.entity.User;
import com.ms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ms_miao
 * @createTime 2020-05-31 21:25
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("++++++++++执行授权逻辑++++++++++");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();

        User dbUser = userService.findById(user.getId());

        info.addStringPermission(dbUser.getPerms());

        return info;
    }

    @Autowired
    private UserService userService;
    /**
     * 执行认证逻辑
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        System.out.println("-------------执行认证逻辑-------------");

        UsernamePasswordToken token = (UsernamePasswordToken) authToken;

        User dbUser = userService.findByName(token.getUsername());

        //如果用户名不存在
        if(dbUser == null){
            return null;//shiro会自动抛出UnknownAccountException
        }

        /**
         * Object principal, 真实用户对象(数据库中的)
         * Object credentials,真实的密码(数据库中的)
         * String realmName 当前realm的名称
         */
        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),this.getName());
    }
}
