package com.myproject.technicaltest.service;

import java.util.Optional;

import com.myproject.technicaltest.dto.UserDto;
import com.myproject.technicaltest.entity.User;

public interface UserService {

    Optional<User> getUserById(Long id);

    User saveUser(UserDto user);
}
