package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDto;


public interface IGreetingService {
    public UserDto getGreeting(UserDto userDto);

    public Object getUserById(Long userDto);
}
