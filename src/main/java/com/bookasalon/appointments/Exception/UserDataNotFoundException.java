package com.bookasalon.appointments.Exception;

public class UserDataNotFoundException extends RuntimeException {
    public UserDataNotFoundException(String Exception, String email) {
        super(Exception + email);
    }

    public UserDataNotFoundException(String username) {
    }
}
