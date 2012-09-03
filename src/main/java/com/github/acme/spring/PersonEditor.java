package com.github.acme.spring;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

public class PersonEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        Person person = new Person();
        String firstName = "NONAME";
        String lastName = "NONAME";
        
        int spaceIndex = value.indexOf(" ");
        if (spaceIndex > 0) {
            firstName = value.substring(0, spaceIndex);
            lastName = value.substring(spaceIndex + 1);
        } else {
            firstName = value;
        }
        
        person.setFirstName(firstName);
        person.setLastName(lastName);
        setValue(person);
    }

}
