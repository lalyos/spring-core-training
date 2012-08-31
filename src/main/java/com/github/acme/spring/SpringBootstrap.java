package com.github.acme.spring;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootstrap {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/*.xml");
        GreetingApp greetingApp = ctx.getBean(GreetingApp.class);
        greetingApp.greet();        
    }

}
