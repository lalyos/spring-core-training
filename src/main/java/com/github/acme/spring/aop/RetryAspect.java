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
public class RetryAspect {

    @Around("execution(* com.github..Simple*.*(..))")
    public Object toUpperCase(ProceedingJoinPoint joinPoint) {
        Object ret = null;
        int retry = 0;
        while (retry < 3) {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                System.out.println("%%% retrying ...: " + ++retry);
            }
        }
        throw new RuntimeException("Too many Exception");
    }

}
