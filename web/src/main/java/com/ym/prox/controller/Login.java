package com.ym.prox.controller;

import com.ym.prox.modules.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by y64195 on 2017/7/4.
 */
@Controller
@RequestMapping("/")
public class Login {

    @RequestMapping("login")
    public String login(){
        return "login/login";
    }

    @RequestMapping("loginSubmit")
    public Map<String, Object> loginSubmit(User user){
        System.out.println(user.getUserName() + user.getPassWord());

        Map<String, Object> result = new HashMap<String, Object>();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user
                .getUserName(), user.getPassWord().toCharArray());
        token.setRememberMe(true);
        String error;
        try {
            subject.login(token);
            result.put("success", true);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
            result.put("success", false);
            result.put("error", error);

        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
            result.put("success", false);
            result.put("error", error);

        } catch (AuthenticationException e) {
            error = "用户名/密码错误";
            result.put("error", error);
            result.put("success", false);
        }

        return result;
    }
}
