package com.cidenet.application.entities;

public class Email {
    private String email;
    

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            "}";
    }
    
}
