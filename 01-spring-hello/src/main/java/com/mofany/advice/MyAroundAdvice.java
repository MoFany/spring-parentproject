package com.mofany.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author MoFany-J
 * @date 2022/12/27
 * @description MyAroundAdvice 自定义环绕通知(方法拦截器)
 */
public class MyAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("\n===========开启事务===========");
        Object result=invocation.proceed();
        System.out.println("===========提交事务===========\n");
        return result;
    }
}
