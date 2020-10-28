package com.d0rj.task1;


public class Main {

    public static void main(String[] args) {

        try {
            Money m = PricesParser.Parse(".10 USD");
            System.out.println(m);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal price.");
        }
    }
}
