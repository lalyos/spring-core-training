package com.github.acme.spring;

import java.util.Locale;

public class I18NGreetingService implements GreetingService {

    private Locale locale;
    
    public void sayGreeting() {
        System.out.println(String.format("[%s] hello"
                , locale.getDisplayLanguage()));

    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
