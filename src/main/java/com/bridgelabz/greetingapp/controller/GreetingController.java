package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDto;
import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    private static final String template = "Hello %s!";
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

    @PostMapping("/message")
    public UserDto getMessage(@RequestBody UserDto userDto) {
        return service.getGreeting(userDto);
    }

    @GetMapping("/{id}")
    public Object getUserData(@PathVariable(value = "id") Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/list")
    public List<User> getUserData() {
        return service.getUserList();
    }

    @PutMapping("/{id}")
    public User getUserUpdate(@PathVariable(value = "id") Long id) {
        return service.getUserUpdate(id);
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable(value = "id") Long id) {
        return service.getUser(id);
    }
}

