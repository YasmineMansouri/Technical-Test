package com.myproject.technicaltest.controller;

import com.myproject.technicaltest.dto.UserDto;
import com.myproject.technicaltest.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myproject.technicaltest.entity.User;
import com.myproject.technicaltest.service.UserService;

/**
 * UserController class that handles the HTTP requests.
 * @author Yasmine MANSOURI
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get request to retrieve a user.
     *
     * @param  id of the user
     * @return user with the given id
     * @throws UserNotFoundException
     * 
     */

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) throws UserNotFoundException {
        return this.userService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found with id:" + id));
    }

    /**
     * Post request to register a user.
     *
     * @param  user we want to save
     * @return Httpstatus of the post request
     *
     */

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        userService.saveUser(user);
        return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
    }

    /**
     * Put request to update a user.
     *
     * @param  newUser with the updated informations
     * @param  id of the user we want to update
     * @return Httpstatus of the put request
     *
     */

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id) {

        return userService.getUserById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setBirthdate(newUser.getBirthdate());
                    user.setResidenceCountry(newUser.getResidenceCountry());
                    user.setGender(newUser.getGender());
                    user.setPhoneNumber(newUser.getPhoneNumber());

                    userService.updateUser(user);
                    return new ResponseEntity<User>(user, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    userService.updateUser(newUser);
                    return new ResponseEntity<User>(newUser, HttpStatus.OK);
                });
    }

    /**
     * Delete request to delete a user.
     *
     * @param  id of the user we want to delete
     *
     */

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
