package com.myproject.technicaltest.service;

import java.util.Optional;

import com.myproject.technicaltest.dto.UserDto;
import com.myproject.technicaltest.entity.User;

/**
 * UserService interface to define the methods needed
 * in different requests of the UserController.
 * @author Yasmine MANSOURI
 *
 */

public interface UserService {

    Optional<User> getUserById(Long id);

    User saveUser(UserDto user);

    User updateUser(User user);

    void deleteById (Long id);
}
