package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDto;
import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    GreetingService service;

    @GetMapping("/greeting")
    public GreetingDto greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new GreetingDto(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public GreetingDto getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new GreetingDto(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/post")
    public GreetingDto postGreeting(@RequestBody UserDto user) {
        return new GreetingDto(counter.incrementAndGet(),
                String.format(template, user.getFirstName() + " " + user.getLastName()));
    }

    @PutMapping("/put/{firstName}")
    public GreetingDto putGreeting(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return new GreetingDto(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
    }

    @PostMapping("/name")
    public UserDto getMessage(@RequestBody UserDto userDto){
        return service.getGreeting(userDto);
    }
}

