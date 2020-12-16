package com.d0rj;


public class Phone implements Priceable {

    private final int price;
    private final String name;


    public Phone(int price, String name) {
        this.price = price;
        this.name = name;
    }


    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Phone {" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
