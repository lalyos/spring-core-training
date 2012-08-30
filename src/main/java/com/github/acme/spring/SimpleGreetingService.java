package com.github.acme.spring;

import org.springframework.beans.factory.BeanNameAware;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setBeanName(String name) {
        System.out.println("### my name is:" + name);
        
    }

}
