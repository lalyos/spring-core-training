package com.github.acme.spring;

import java.util.Locale;

import lombok.Data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Data
@Component
public class I18NGreetingService implements GreetingService, ApplicationContextAware {

    
    private Locale locale = new Locale("de");
    private ApplicationContext applicationContext;
    
    public void sayGreeting() {
        String key = "msg";
        try {
            System.out.println(String.format("[%s] :  %s"
                , locale.getDisplayLanguage(), applicationContext.getMessage(key, null, locale)  ));
        }catch (NoSuchMessageException e) {
            System.out.println(applicationContext.getMessage("error.nosuchmessage", new Object[]{key}, locale));
        }

    }

}
