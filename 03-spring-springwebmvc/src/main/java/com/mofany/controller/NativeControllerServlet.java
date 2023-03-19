package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author MoFany-J
 * @date 2023/1/3
 * @description NativeControllerServlet SpringMVC原生的Servlet表示
 * SpringMVC向页面展示数据以及处理请求的几种方法（自带的+Servlet的）
 */
@Controller
public class NativeControllerServlet {

    /**
     * 默认请求：以请求转发即请求跳转
     * */
    @RequestMapping(value = "request1")
    public ModelAndView requestHandler1(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("native1");
    }

    /**
     * get请求
     * */
    @GetMapping(value = "request2")
    public ModelAndView requestHandler2(){
        ModelAndView modelAndView=new ModelAndView("native1");
        return modelAndView;
    }

    /**
     * Post请求,不能访问Web-INF里的资源，Get请求可以
     * 同时请求转发可以访问Web-INF里的资源，而响应重定向无法访问Web-INF里的资源
     * */
    @PostMapping (value = "request3")
    public ModelAndView requestHandler3(){
        ModelAndView modelAndView=new ModelAndView("native1");
        return modelAndView;
    }

    /**
     * 处理请求的几种方式
     * */
    @GetMapping(value = "request4")
    public String requestHandler4(){
        //默认为请求转发（返回值必须是完整路径）
        return "native1";
    }
    /**
     * 等价于request4
     * */
    @GetMapping(value = "request5")
    public String requestHandler5(){
        //转发，默认（相对路径）
        return "forward:/nativejsp/native2.jsp";
        //请求转发可以访问WEB-INF下的内容，请求转发不能成功响应Post发起的访问WEB-INF内容的请求
//        return "forward:/WEB-INF/jsp/native1.jsp";
    }

    @GetMapping(value = "request6")
    public String requestHandler6(){
        //重定向（绝对路径）
        return "redirect:./nativejsp/native2.jsp";
        //重定向直接不能访问WEB-INF目录下的内容
//        return "redirect:./WEB-INF/jsp/native1.jsp";
    }

    @GetMapping(value = "request7")
    public void requestHandler7(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //请求转发,相对路径（默认）
        //带数据得通过设置请求的属性
        request.getRequestDispatcher("/nativejsp/native2.jsp").forward(request,response);
    }

    @GetMapping(value = "request8")
    public void requestHandler8(HttpServletResponse response) throws IOException {
        //响应重定向，绝对路径
        //带数据得通过会话的属性
        response.sendRedirect("./nativejsp/native2.jsp");
    }

    /**
     * 数据展示的几种方式
     *
     * 通过ModelAndView实例携带数据到页面
     * */
    @GetMapping (value = "request9")
    public ModelAndView requestHandler9(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("content","通过ModelAndView实例展示数据");
        modelAndView.setViewName("native1");
        return modelAndView;
    }

    /**
     * 通过Model实例携带数据到页面
     * */
    @GetMapping (value = "request10")
    public String requestHandler10(Model model){
        model.addAttribute("content","通过Model实例展示数据");
        return "native1";
    }

    /**
     * 使用Map集合携带数据到页面
     * */
    @GetMapping(value = "request11")
    public String requestHandler11(Map<String,Object>map){
        //通过map携带数据
        map.put("content","通过map展示数据");
        return "native1";
    }

    /**
     * 以请求转发的方式展示数据（请求属性）
     * */
    @GetMapping(value = "request12")
    public void requestHandler12(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content","通过request结合forward展示数据");
        request.getRequestDispatcher("/nativejsp/native2.jsp").forward(request,response );
    }

    /**
     * 以响应重定向的方式展示数据（会话属性）
     * */
    @GetMapping(value = "request13")
    public void requestHandler13(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("content","通过response结合session展示数据");
        response.sendRedirect("./nativejsp/native2.jsp");
    }
}
