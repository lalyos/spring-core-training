package com.github.acme.spring;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;

public class I18NGreetingService implements GreetingService, ApplicationContextAware {

    private Locale locale;
    private ApplicationContext ctx;
    
    public void sayGreeting() {
        String key = "__msg";
        try {
            
            System.out.println(String.format("[%s] :  %s"
                , locale.getDisplayLanguage(), ctx.getMessage(key, null, locale)  ));
        }catch (NoSuchMessageException e) {
            System.out.println(ctx.getMessage("error.nosuchmessage", new Object[]{key}, locale));
        }

    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
        
    }

}
