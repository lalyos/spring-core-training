package com.github.acme.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class TraceAspect {

    @Before("appMethods() || serviceMethods()")
    public void traceSomeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@@@ itt jartam ...: " + joinPoint.getSignature());
        
        Object[] args = joinPoint.getArgs();
        for (Object nextArg : args) {
            System.out.println("\t next Arg: " + nextArg);
        }
    }
    
    @Pointcut("execution(* com.github.acme.spring.GreetingService.sayGreeting(..))")
    public void serviceMethods() {}
    
    @Pointcut("execution(* com.github.acme.spring.GreetingApp.greet(..))")
    public void appMethods() {}
}
