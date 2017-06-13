package com.ym.prox.controller;

import com.ym.prox.modules.User;
import com.ym.prox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by y64195 on 2017/6/5.
 */
@Controller
@RequestMapping("User")
public class InterceptorTest {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll(){
        List<User> users = userService.findAll();
        System.out.println(users.size() + users.get(0).getUserName());
        return users;
    }
}
