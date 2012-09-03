package com.github.acme.spring;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class GreetingApp {
    
    @Autowired
    @Qualifier("simple")
    private GreetingService greetingService;
    
    @Autowired
    private PrefixService prefixService;
    
    @Autowired
    @Qualifier("female")
    private Person fixPerson;
    
    public void greet() {
        greetingService.sayGreeting();
    }
    
    public void greet(String messsage) {
        String prefix = prefixService.getPrefix();
        System.out.println("### prefix type:" + prefixService.getClass());
        System.out.println("### person type:" + fixPerson.getClass());
        greetingService.sayGreeting(fixPerson, prefix + messsage);
    }
}
