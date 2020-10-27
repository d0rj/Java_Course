package com.d0rj;


public class Main {

    public static void main(String[] args) {
        var date = new DateParser().parse("22/03/2001");
        System.out.println(date);
    }
}
