package com.github.acme.spring;

import lombok.Data;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Data
@Component
@Qualifier("simple")
public class SimpleGreetingService implements GreetingService, BeanNameAware {

    private String msg = "Hello Service!";
    @Value("1")
    private int count;

    @Value("Karl Robb")
    private Person person;
    
    public SimpleGreetingService(){};
    
    public SimpleGreetingService(String msg, int count) {
        this.msg = msg;
        this.count = count;
    }

    public void sayGreeting() {
        for(int i=0 ; i < count; i++) {
            System.out.println(msg + " " + person);
        }

    }
    
    public void myInit() {
        System.out.println("reading from google translate ....");
    }

    public void setBeanName(String name) {
        System.out.println("### my name is:" + name);
        
    }

}
