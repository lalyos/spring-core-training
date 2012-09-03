package com.github.acme.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

    @Around("serviceMethods()")
    public Object mesureExecution(ProceedingJoinPoint joinPoint) {
        Object ret = null;
        try {
            long start = System.currentTimeMillis();
            Object[] args = joinPoint.getArgs();
            ret = joinPoint.proceed(args);
            long end = System.currentTimeMillis();
            System.out.println(joinPoint.getSignature() 
                    + " ellapsed time [ms]:" + ((end-start)));
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "f@ck ";
    }
    
    @Pointcut("execution(String com.github..*.*())")
    public void serviceMethods() {}

}
