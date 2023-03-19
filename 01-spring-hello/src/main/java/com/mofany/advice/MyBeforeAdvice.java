package com.mofany.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author MoFany-J
 * @date 2022/12/28
 * @description BeforeAdvice 自定义前置通知
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------------我是前置通知------------");
    }
}
