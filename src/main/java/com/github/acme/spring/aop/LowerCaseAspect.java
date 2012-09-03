package com.github.acme.spring.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LowerCaseAspect {

    @Around("execution(String com.github..*.*(..))")
    public Object toUpperCase(ProceedingJoinPoint joinPoint) {
        String ret = null;
        try {
            ret = (String) joinPoint.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret.toLowerCase();
    }

}
