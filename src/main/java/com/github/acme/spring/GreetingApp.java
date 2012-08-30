package com.github.acme.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class GreetingApp {
    private GreetingService greetingService;

    public GreetingApp(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
    public void greet() {
        greetingService.sayGreeting();
    }
}
