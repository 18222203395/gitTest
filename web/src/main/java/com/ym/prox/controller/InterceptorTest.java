package com.ym.prox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by y64195 on 2017/6/5.
 */
@Controller
@RequestMapping("Interceptor")
public class InterceptorTest {

    @RequestMapping("init")
    @ResponseBody
    public String init(){
        System.out.print("DDDDDDDD");
        return "DDDDDD";
    }
}
