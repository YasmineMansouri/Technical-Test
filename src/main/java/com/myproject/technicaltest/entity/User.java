package com.myproject.technicaltest.entity;

import com.myproject.technicaltest.annotation.CheckDateFormat;
import com.myproject.technicaltest.annotation.CheckResidenceCountry;
import com.myproject.technicaltest.annotation.CheckUsernameFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * User class is the Entity that contains the informations about the user.
 * @author Yasmine MANSOURI
 *
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    @NotBlank(message = "username is mandatory")
    @CheckUsernameFormat()
    private String username;

    @Column(name = "birthdate")
    @NotBlank(message = "birthdate is mandatory")
    @CheckDateFormat()
    private String birthdate;

    @Column(name = "residence_country")
    @NotBlank(message = "residence Country is mandatory")
    @CheckResidenceCountry()
    private String residenceCountry;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;


    public User() {
        super();
    }

    public User(@NotBlank(message = "username is mandatory") String username,
                @NotBlank(message = "birthdate is mandatory") String birthdate,
                @NotBlank(message = "residence Country is mandatory") String residenceCountry, String phoneNumber,
                String gender) {
        super();
        this.username = username;
        this.birthdate = birthdate;
        this.residenceCountry = residenceCountry;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
