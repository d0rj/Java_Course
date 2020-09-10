package com.d0rj;


public class Main {

    public static void main(String[] args) {
        var date = new UsaDateParser().parse("03/22/2001");
        System.out.println(date);
    }
}
