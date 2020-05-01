package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {
    String template="Hello World,%s";
    @Override
    public String getGreeting(String firstName) {
        return String.format(template,firstName);
    }
}