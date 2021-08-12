package com.myproject.technicaltest.controller;

import com.myproject.technicaltest.dto.UserDto;
import com.myproject.technicaltest.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.technicaltest.entity.User;
import com.myproject.technicaltest.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        // TODO Auto-generated constructor stub
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return this.userService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found with id:" + id));
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        userService.saveUser(user);
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);

    }


}
