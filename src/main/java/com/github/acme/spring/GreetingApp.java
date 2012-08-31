package com.github.acme.spring;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
public class GreetingApp {
    
    @Autowired
    @Qualifier("group")
    private GreetingService greetingService;
    
    public void greet() {
        greetingService.sayGreeting();
    }
}
