package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MoFany-J
 * @date 2023/1/25
 * @description MyController 自定义登录注册请求控制器
 */
@Controller
public class MyController {

    /**
     * 处理登录页跳转请求（支持跨域）
     * */
    @CrossOrigin
    @GetMapping("login")
    public ModelAndView requestLogin(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * 处理注册页跳转请求（支持跨域）
     * */
    @CrossOrigin
    @GetMapping("register")
    public ModelAndView requestRegister(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
