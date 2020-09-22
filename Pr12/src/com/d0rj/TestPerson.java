package com.d0rj;


public class TestPerson {

    public static void main(String[] args) {
        var p1 = new Person("Kaczynski");
        System.out.println(p1);

        p1.setName("Theodore");
        System.out.println(p1);

        p1.setPatronymic("John");
        System.out.println(p1);
    }
}
