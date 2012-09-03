package com.github.acme.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpperCaseAspect {

    @Around("execution(String com.github..*.*(..))")
    public Object toUpperCase(ProceedingJoinPoint joinPoint) {
        String ret = null;
        try {
            ret = (String) joinPoint.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret.toUpperCase();
    }
}
