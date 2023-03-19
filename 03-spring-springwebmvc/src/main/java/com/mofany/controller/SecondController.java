package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MoFany-J
 * @date 2023/1/2
 * @description SecondController 基于注解的Controller控制器
 */
@Controller
public class SecondController {
    @RequestMapping(value = "secondController")
    public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)throws ServletException{
        return new ModelAndView("welcome2");
    }
}
