package com.mofany.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MoFany-J
 * @date 2023/1/1
 * @description FirstController 自定义基于接口实现类的控制器类
 */
public class FirstController implements Controller {
    /**
     * ModelAndView 模型与视图
     * 模型就是数据库数据
     * 视图就是要显示的页面
     * */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("welcome1");
    }
}
