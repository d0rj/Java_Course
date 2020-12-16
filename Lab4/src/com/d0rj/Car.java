package com.d0rj;


public class Car implements Priceable {

    private final int price;
    private final String name;
    private final String mark;


    public Car(int price, String name, String mark) {
        this.price = price;
        this.name = name;
        this.mark = mark;
    }


    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Car {" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
