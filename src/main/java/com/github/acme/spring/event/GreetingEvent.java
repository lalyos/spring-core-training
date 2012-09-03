package com.github.acme.spring.event;

import java.util.Locale;

import lombok.Data;

import org.springframework.context.ApplicationEvent;

import com.github.acme.spring.GreetingService;
import com.github.acme.spring.Person;

@Data
public class GreetingEvent extends ApplicationEvent {

    private Person target;
    private Locale locale;
    private String message;

    public GreetingEvent(GreetingService source, Person target, Locale locale, String message) {
        super(source);
        this.target = target;
        this.locale = locale;
        this.message = message;
    }
}
