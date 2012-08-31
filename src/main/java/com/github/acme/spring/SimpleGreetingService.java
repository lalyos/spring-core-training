package com.github.acme.spring;

import lombok.Data;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;


@Data
@Component
public class SimpleGreetingService implements GreetingService, BeanNameAware {

    private String msg = "Hello Service!";
    private int count;
    
    public SimpleGreetingService(){};
    
    public SimpleGreetingService(String msg, int count) {
        this.msg = msg;
        this.count = count;
    }

    public void sayGreeting() {
        for(int i=0 ; i < count; i++) {
            System.out.println(msg);
        }

    }
    
    public void myInit() {
        System.out.println("reading from google translate ....");
    }

    public void setBeanName(String name) {
        System.out.println("### my name is:" + name);
        
    }

}
