package com.github.acme.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class GreetingApp {
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/META-INF/spring/application.xml"));
        GreetingService service = (GreetingService) factory.getBean("greetingService");
        service.sayGreeting();
    }
}
