package com.github.acme.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("group")
@Component
public class GroupGreetingService implements GreetingService {

    @Autowired
    @Qualifier("male")
    private Person[] group;
    
    public void sayGreeting() {
        for (Person next : group) {
            System.out.println("Hi: " + next);
        }

    }

    @Override
    public void sayGreeting(Person person, String Message) {
        // TODO Auto-generated method stub
        
    }

}
