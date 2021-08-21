package com.myproject.technicaltest.dto;

/**
 * UserDto class that is mapped with our entity User.
 * @author Yasmine MANSOURI
 *
 */

public class UserDto {

    private Long id;
    private String username;
    private String birthdate;

    private String residenceCountry;

    private String phoneNumber;

    private String gender;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id
        ;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
