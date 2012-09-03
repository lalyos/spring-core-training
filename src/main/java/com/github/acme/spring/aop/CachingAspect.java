package com.github.acme.spring.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class CachingAspect {

    private Map<String, Object> returnCache = new HashMap<String, Object>();

    @Around("execution(String com.github..PrefixService.*(..))")
    public Object toUpperCase(ProceedingJoinPoint joinPoint) {
        String signature = joinPoint.getSignature().toString();
        Object ret = returnCache.get(signature);
        if (ret == null) {
            try {
                ret = joinPoint.proceed();
                returnCache.put(signature, ret);
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("### hitting cache ...");
        }
        return ret;
    }
}
