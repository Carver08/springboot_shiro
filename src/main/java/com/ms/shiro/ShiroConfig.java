package com.ms.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ms_miao
 * @createTime 2020-05-31 21:20
 */

/**
 * shiro可以分为以下三部分：
 *      Subject：用户主体（把操作交给SecurityManager）
 *      SecurityManager：安全管理器（关联realm）
 *      Realm：shiro连接数据的桥梁
 */

@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //添加shiro内置过滤器   第一次优先匹配原则
        /**
         * shiro内置过滤器，可以实现权限相关的拦截器
         *      常用的过滤器：
         *          anon:无需认证（登录）可以访问
         *          authc:必须认证才可以访问
         *          user:如果使用rememberMe的功能可以直接访问
         *          perms:该资源必须得到资源权限才可以访问
         *          role：该资源必须得到角色权限才可以访问
         */

        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/toLogin","anon");
        filterMap.put("/toIndex","anon");
        filterMap.put("/login","anon");
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到为授权的页面
        filterMap.put("/toAdd","perms[user:add]");
        filterMap.put("/toUpdate","perms[user:update]");

        filterMap.put("/**","authc");

        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/toUnauth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
