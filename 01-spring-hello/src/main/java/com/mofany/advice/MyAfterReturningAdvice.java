package com.mofany.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author MoFany-J
 * @date 2022/12/28
 * @description MyAfterReturningAdvice 自定义后置返回通知
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------------我是后置返回通知------------\n");
    }
}
