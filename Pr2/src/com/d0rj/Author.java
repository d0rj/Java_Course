package com.d0rj;


public class Author {

    private final String name;
    private String email;
    private final char gender;


    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Author {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
