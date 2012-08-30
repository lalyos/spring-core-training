package com.github.acme.spring;

public class SimpleGreetingService implements GreetingService {

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

}
