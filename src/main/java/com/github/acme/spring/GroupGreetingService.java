package com.github.acme.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("greetingService")
public class GroupGreetingService implements GreetingService {

    @Autowired
    private Person[] group;
    
    public void sayGreeting() {
        for (Person next : group) {
            System.out.println("Hi: " + next);
        }

    }

}
