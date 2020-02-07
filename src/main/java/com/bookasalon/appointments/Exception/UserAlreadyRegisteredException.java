package com.bookasalon.appointments.Exception;

import javax.validation.constraints.Email;


public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String existing_user, @Email String email) {
        super("UserData already exist : " + email);
    }
}
