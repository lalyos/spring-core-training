package com.github.acme.spring;

import org.springframework.stereotype.Component;

@Component
public class SimplePrefix implements PrefixService {

    @Override
    public String getPrefix() {
        // TODO Auto-generated method stub
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "[fix] ";
    }

}
