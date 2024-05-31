package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Logging {
    @Pointcut("execution(* com.example.aop.service.AccountServiceImpl.*(..))")
    public void accountServiceMethodsExpression(){};
    @Pointcut("execution(* com.example.aop.service.AccountServiceImpl.get*(..))")
    public void getterMethodExpression(){};
    @Pointcut("execution(* com.example.aop.service.AccountServiceImpl.set*(..))")
    public void setterMethodExpression(){};
    @Pointcut("accountServiceMethodsExpression() && !(getterMethodExpression()||setterMethodExpression())")
    public void pointcutExpression(){};
    /*
    *
    * the function logBefore() is called 'Advice'\
    * the location where this method is applied called 'JoinPoint' you can navigate to it*/
    //@Before("execution(* com.example.aop.service.AccountServiceImpl.*(..))")
    @Before("pointcutExpression()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(getClass().getName()+ " "+ joinPoint.getSignature());
    }
}
