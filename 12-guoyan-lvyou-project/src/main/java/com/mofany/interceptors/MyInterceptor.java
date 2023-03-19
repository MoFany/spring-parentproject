package com.mofany.interceptors;


import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description MyInterceptor 自定义编码拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 控制器处理方法前调用
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }
}
