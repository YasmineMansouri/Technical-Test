package com.myproject.technicaltest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserNotFoundException class to define the message to display if a user is not found.
 * @author Yasmine MANSOURI
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {


    public UserNotFoundException(String message) {
        super(message);
    }
}
