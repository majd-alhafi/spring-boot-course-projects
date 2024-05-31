package com.example.TODOapp.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.example.TODOapp.services.*.*(..))")
    public void servicesExpression(){};
    /*@AfterReturning(pointcut = "servicesExpression()",returning = "result")
    public void afterReturningLogging(JoinPoint joinPoint,Object result){
        System.out.println("*** afterReturningLogging *** " );
    }
    @AfterThrowing(pointcut = "servicesExpression()",throwing = "exc")
    public void afterThrowingLogging(JoinPoint joinPoint,Throwable exc){
        System.out.println("*** afterThrowingLogging ***");
    }
    @After("servicesExpression()")
    public void afterLogging(JoinPoint joinPoint){
        System.out.println("*** afterLogging ***");
    }*/
    @Around("servicesExpression()")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("*** aroundLogging ***");
        Object result = null;
        try {
            result = joinPoint.proceed(); //to execute the target method.
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //throw e;
            result = null;
        }
        return result;
    }
}
