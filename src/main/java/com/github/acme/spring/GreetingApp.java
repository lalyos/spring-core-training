package com.github.acme.spring;

public class GreetingApp {
    public static void main(String[] args) {
        GreetingService service = new SimpleGreetingService();
        
        service.sayGreeting();
    }
}
