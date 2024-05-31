package com.example.aop.aspect;

import io.micrometer.observation.annotation.Observed;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class APIAnalytics {
    @Before("execution(* com.example.aop.service.AccountServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(getClass().getName()+ " "+ joinPoint.getSignature());
    }
}
