package com.ms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ms_miao
 * @createTime 2020-05-31 21:07
 */
@Controller
public class UserController {

    /**
     * 测试controller
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("测试成功");
        return "ok";
    }

    /**
     * 去登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 去主页面
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    /**
     * 去添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    /**
     * 去更新页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "update";
    }


    /**
     * login 实现用户登录逻辑
     */

    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        /**
         * 使用shiro编写认证操作
         */
        //1-获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2-封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //3-执行登录方法
        try {
            subject.login(token);
            return "index";
            //3-1-用户名不存在--登录失败
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
            //3-2-密码错误--登录失败
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }


    /**
     * 去未授权页面
     * @return
     */
    @RequestMapping("/toUnauth")
    public String toUnauth(){
        return "unAuth";
    }


    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

}
