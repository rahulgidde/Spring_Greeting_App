package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GreetingService implements IGreetingService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    UserRepository repository;

    String template = "Hello World %s";

    @Override
    public UserDto getGreeting(UserDto userDto) {
        userDto.setGreeting(String.format(template, userDto.getFirstName()));
        User user = mapper.map(userDto, User.class);
        repository.save(user);
        return userDto;
    }

    @Override
    public Object getUserById(Long id) {

        return repository.findById(id);
    }
}