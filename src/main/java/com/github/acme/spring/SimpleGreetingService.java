package com.github.acme.spring;

import java.util.Random;

import javax.jws.WebService;

import lombok.Data;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.github.acme.spring.aop.ToRetry;
import com.github.acme.spring.event.GreetingEvent;


@Data
@Component
@Qualifier("simple")
public class SimpleGreetingService implements GreetingService, BeanNameAware, ApplicationEventPublisherAware {

    private Random rnd = new Random(System.currentTimeMillis());
    
    private String msg = "Hello Service!";
    @Value("10")
    private int count;

    @Value("Karl Robb")
    private Person person;
    
    private ApplicationEventPublisher applicationEventPublisher;
    
    public SimpleGreetingService(){};
    
    public SimpleGreetingService(String msg, int count) {
        this.msg = msg;
        this.count = count;
    }

    public void sayGreeting() {
        for(int i=0 ; i < count; i++) {
            System.out.println(msg + " " + person);
            GreetingEvent event = new GreetingEvent(this, person, null, msg);
            applicationEventPublisher.publishEvent(event);
        }

    }
    
    public void myInit() {
        System.out.println("reading from google translate ....");
    }

    public void setBeanName(String name) {
        System.out.println("### my name is:" + name);
        
    }

    @Override
    @ToRetry
    public void sayGreeting(Person person, String message) {
        GreetingEvent event = new GreetingEvent(this, person, null, message);
        applicationEventPublisher.publishEvent(event);

        int nextInt = rnd.nextInt(10);
        System.out.println("RANDOM: " + nextInt);
        if (nextInt < 5) {
            throw new RuntimeException("Baj van!");
        }
        System.out.println("=== " + message + "" + person);
    }
}
