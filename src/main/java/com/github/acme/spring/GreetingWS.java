package com.github.acme.spring;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService
public class GreetingWS {

    @Autowired
    private SimpleGreetingService greetingService;
    
    public void greet(Person person, String message) {
        greetingService.sayGreeting(person, message);
    }
}
