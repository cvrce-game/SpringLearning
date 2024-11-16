package com.example.demo.propertyeditor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.example.demo.model.Person;

@Component
public class PersonEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] parts = text.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format. Expected 'name:age'.");
        }

        Person person = new Person();
        person.setName(parts[0].trim());
        person.setAge(Integer.parseInt(parts[1].trim()));

        setValue(person);
    }
}