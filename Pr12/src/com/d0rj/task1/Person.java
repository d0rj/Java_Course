package com.d0rj.task1;


public class Person {

    private String name;
    private String surname;
    private String patronymic;


    public Person(String surname) {
        this.surname = surname;
    }


    public Person(String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }


    @Override
    public String toString() {
        var builder = new StringBuilder();

        builder.append(surname);
        if (name != null)
            builder.append(" ").append(name.toUpperCase().charAt(0)).append(".");
        if (name != null && patronymic != null)
            builder.append(patronymic.toUpperCase().charAt(0)).append(".");

        return builder.toString();
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
