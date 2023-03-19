package com.mofany.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MoFany-J
 * @date 2023/1/26
 * @description MyInterceptor 自定义拦截器
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 在Controller处理方法调用前执行
     * 返回值为true时才会继续执行postHandle与afterHandle
     * 多个拦截器Interceptor里的preHandle()方法都会在Controller方法调用前率先调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }

    /**
     * 在Controller处理方法完成逻辑处理后，且在返回ModelAndView之前执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在Controller处理方法调用后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
