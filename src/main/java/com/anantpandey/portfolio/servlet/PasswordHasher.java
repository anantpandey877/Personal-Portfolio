package com.anantpandey.portfolio.servlet;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public static void main (String [] args ) {
        // Choose a strong password
        String myPassword = "admin";
        String hashedPassword = BCrypt.hashpw(myPassword, BCrypt.gensalt());
        System.out.println(hashedPassword);
    }
}