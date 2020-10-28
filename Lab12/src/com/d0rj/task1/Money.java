package com.d0rj.task1;


public class Money {

    private double roubles;


    private Money(double roubles) {
        this.roubles = roubles;
    }


    public static Money fromRoubles(double roubles) {
        return new Money(roubles);
    }


    public static Money fromEuro(double euro) {
        return new Money(euro * 90);
    }


    public static Money fromDollar(double dollars) {
        return new Money(dollars * 80);
    }


    public double getRoubles() {
        return roubles;
    }


    @Override
    public String toString() {
        return roubles + "руб.";
    }
}
