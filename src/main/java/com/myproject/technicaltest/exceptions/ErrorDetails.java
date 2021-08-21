package com.myproject.technicaltest.exceptions;

import java.util.Date;

/**
 * ErrorDetails class to define the format of the error message.
 * @author Yasmine MANSOURI
 *
 */

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}