package com.github.acme.spring;

import java.util.Locale;

import lombok.Data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Data
@Qualifier("i18n")
@Component
public class I18NGreetingService implements GreetingService, ApplicationContextAware {

    @Value("${greeting.service.language}")
    private Locale locale;
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
