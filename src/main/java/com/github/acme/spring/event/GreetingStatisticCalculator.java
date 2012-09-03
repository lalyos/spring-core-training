package com.github.acme.spring.event;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github.acme.spring.Person;

@Component
public class GreetingStatisticCalculator implements ApplicationListener<GreetingEvent>{

    @Getter
    private int totalGreetings = 0;
    
    @Getter
    private Map<String, Integer> wordStatistic = new HashMap<String, Integer>();
    
    @Getter
    private Map<String, Integer> firstNameCounter = new HashMap<String, Integer>();
    
    @Override
    public void onApplicationEvent(GreetingEvent event) {
        Person target = event.getTarget();
        if (target != null) {
            String firstName = target.getFirstName();
            Integer oldCounter = firstNameCounter.get(firstName);
            if (oldCounter == null) {
                oldCounter = 0;
            }
            firstNameCounter.put(firstName, oldCounter + 1); 
        }
        totalGreetings ++;
        
        String message = event.getMessage();
        if (message != null) {
            for (String nextWord : message.split(" ")) {
                Integer oldCounter = wordStatistic.get(nextWord);
                if (oldCounter == null) {
                    oldCounter = 0;
                }
                wordStatistic.put(nextWord, oldCounter + 1);
            }
        }
    }
    
    
}
