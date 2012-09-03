package com.github.acme.spring;

import org.springframework.stereotype.Component;

@Component
public class SimplePrefix implements PrefixService {

    @Override
    public String getPrefix() {
        // TODO Auto-generated method stub
        return "[fix] ";
    }

}
