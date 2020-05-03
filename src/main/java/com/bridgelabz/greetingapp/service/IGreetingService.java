package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.User;

import java.util.List;


public interface IGreetingService {
    public UserDto getGreeting(UserDto userDto);

    public Object getUserById(Long userDto);

    public List<User> getUserList();
}
