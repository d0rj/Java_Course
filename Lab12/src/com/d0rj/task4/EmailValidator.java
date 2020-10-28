package com.d0rj.task4;

import java.util.regex.Pattern;


public class EmailValidator {

    private static final String EmailRFC2822
            = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@((?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])|localhost)?";


    public static boolean IsValidEmail(String email) {
        return Pattern.compile(EmailRFC2822).matcher(email).matches();
    }


    public static void main(String[] args) {
        var email = "user@gmail";

        if (EmailValidator.IsValidEmail(email))
            System.out.println("Email '" + email + "' is valid.");
        else
            System.out.println("Email '" + email + "' is invalid.");
    }
}
